import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    public String name;
    public String email;
    public String password;
    public String token;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/api";
    }

    @Before
    public void creationUserCreds(){
        name = RegistrationPage.creationName();
        email = RegistrationPage.creationEmail();
        password = RegistrationPage.creationPassword();
    }

    @DisplayName("Успешная регистрация")
    @Test
    public void successAuthorization() {
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickInactiveInputName();
        registrationPage.setName(name);
        registrationPage.clickInactiveInputEmail();
        registrationPage.setEmail(email);
        registrationPage.clickInactiveInputPassword();
        registrationPage.setPassword(password);
        registrationPage.clickRegisterButton2();
        String textRegister = loginPage.getEntryText();
        assertEquals("Вход", textRegister);

        RegistrationPage creds = new RegistrationPage(email, password, name);

        token = given()
                .contentType(ContentType.JSON)
                .body(creds)
                .when()
                .post("auth/login")
                .then()
                .extract()
                .path("accessToken");

        given()
                .header("authorization", token)
                .contentType(ContentType.JSON)
                .body(creds)
                .delete("auth/user");
    }
    @DisplayName("Регистрация с паролем в 5 знаков")
    @Test
    public void authorizationWithIncorrectPassword(){
        password = "FoUre";
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickInactiveInputName();
        registrationPage.setName(name);
        registrationPage.clickInactiveInputEmail();
        registrationPage.setEmail(email);
        registrationPage.clickInactiveInputPassword();
        registrationPage.setPassword(password);
        registrationPage.clickRegisterButton2();
        String textIncorrectPassword = registrationPage.getTextIncorrectPassword();
        assertEquals("Некорректный пароль", textIncorrectPassword);
    }
}

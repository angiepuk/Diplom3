import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    String name;
    String email;
    String password;
    String token;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/api";
    }

    @Before
    public void creation_user_creds(){
        name = RegistrationPage.creationName();
        email = RegistrationPage.creationEmail();
        password = RegistrationPage.creationPassword();
    }

    @DisplayName("Успешная регистрация")
    @Test
    public void success_authorization() {
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.click_personal_account_button();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.click_register_button();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.click_inactive_input_name();
        registrationPage.setName(name);
        registrationPage.click_inactive_input_email();
        registrationPage.setEmail(email);
        registrationPage.click_inactive_input_password();
        registrationPage.setPassword(password);
        registrationPage.click_register_button2();
        String textRegister = loginPage.getEntryText();
        assertEquals(textRegister, "Вход");

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
    public void authorization_with_incorrect_password(){
        password = "FoUre";
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.click_personal_account_button();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.click_register_button();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.click_inactive_input_name();
        registrationPage.setName(name);
        registrationPage.click_inactive_input_email();
        registrationPage.setEmail(email);
        registrationPage.click_inactive_input_password();
        registrationPage.setPassword(password);
        registrationPage.click_register_button2();
        String textIncorrectPassword = registrationPage.getTextIncorrectPassword();
        assertEquals(textIncorrectPassword, "Некорректный пароль");
    }
}

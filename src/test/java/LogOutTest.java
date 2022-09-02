import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.AccountPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class LogOutTest {
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

    @Before
    public void register_user() {
        RegistrationPage creds = new RegistrationPage(email, password, name);
        token = given()
                .contentType(ContentType.JSON)
                .body(creds)
                .when()
                .post("auth/register")
                .then()
                .extract()
                .path("accessToken");
    }

    @After
    public void delete_user(){
        RegistrationPage creds = new RegistrationPage(email, password, name);
        given()
                .header("authorization", token)
                .contentType(ContentType.JSON)
                .body(creds)
                .delete("auth/user");
    }

    @DisplayName("Выход по кнопке Выйти в Личном Кабинете")
    @Test
    public void logOut() {
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickInactiveInputEmail();
        loginPage.setEmail(email);
        loginPage.clickInactiveInputPassword();
        loginPage.setPassword(password);
        loginPage.clickLogInButton();
        mainPage.clickPersonalAccountButton();
        AccountPage accountPage = page(AccountPage.class);
        accountPage.clickLogOutButton();
        String textRegister = loginPage.getEntryText();
        assertEquals(textRegister, "Вход");
    }
}

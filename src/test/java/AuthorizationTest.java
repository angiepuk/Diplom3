import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RecoverPasswordPage;
import pageobject.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class AuthorizationTest {
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

    @DisplayName("Авторизация по кнопке «Войти в аккаунт» на главной")
    @Test
    public void authorization_with_signIn_button_on_main_page(){
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.clickSignInMainPageButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickInactiveInputEmail();
        loginPage.setEmail(email);
        loginPage.clickInactiveInputPassword();
        loginPage.setPassword(password);
        loginPage.clickLogInButton();
        String placeOrderText = mainPage.getTextPlaceOrder();
        assertEquals("Оформить заказ", placeOrderText);
    }

    @DisplayName("Авторизация по кнопке «Личный кабинет» на главной")
    @Test
    public void authorization_with_personal_account_button_on_main_page(){
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickInactiveInputEmail();
        loginPage.setEmail(email);
        loginPage.clickInactiveInputPassword();
        loginPage.setPassword(password);
        loginPage.clickLogInButton();
        String placeOrderText = mainPage.getTextPlaceOrder();
        assertEquals("Оформить заказ", placeOrderText);
    }

    @DisplayName("Авторизация через кнопку в форме регистрации")
    @Test
    public void authorization_with_logIn_button_on_registration_page(){
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.clickLogInButtonRegistrationPage();
        loginPage.clickInactiveInputEmail();
        loginPage.setEmail(email);
        loginPage.clickInactiveInputPassword();
        loginPage.setPassword(password);
        loginPage.clickLogInButton();
        String placeOrderText = mainPage.getTextPlaceOrder();
        assertEquals("Оформить заказ", placeOrderText);
    }

    @DisplayName("Авторизация через кнопку в форме восстановления пароля")
    @Test
    public void authorization_with_logIn_button_on_recover_password_page(){
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRecoverPassword();
        RecoverPasswordPage recoverPasswordPage = page(RecoverPasswordPage.class);
        recoverPasswordPage.clickLogInButtonRecoverPasswordPage();
        loginPage.clickInactiveInputEmail();
        loginPage.setEmail(email);
        loginPage.clickInactiveInputPassword();
        loginPage.setPassword(password);
        loginPage.clickLogInButton();
        String placeOrderText = mainPage.getTextPlaceOrder();
        assertEquals("Оформить заказ", placeOrderText);
    }
}

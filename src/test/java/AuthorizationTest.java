import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RecoverPasswordPage;
import pageObject.RegistrationPage;
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
        mainPage.click_signIn_mainPage_button();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.click_inactive_input_email();
        loginPage.setEmail(email);
        loginPage.click_inactive_input_password();
        loginPage.setPassword(password);
        loginPage.click_logIn_button();
        String placeOrderText = mainPage.getTextPlaceOrder();
        assertEquals(placeOrderText, "Оформить заказ");
    }

    @DisplayName("Авторизация по кнопке «Личный кабинет» на главной")
    @Test
    public void authorization_with_personal_account_button_on_main_page(){
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.click_personal_account_button();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.click_inactive_input_email();
        loginPage.setEmail(email);
        loginPage.click_inactive_input_password();
        loginPage.setPassword(password);
        loginPage.click_logIn_button();
        String placeOrderText = mainPage.getTextPlaceOrder();
        assertEquals(placeOrderText, "Оформить заказ");
    }

    @DisplayName("Авторизация через кнопку в форме регистрации")
    @Test
    public void authorization_with_logIn_button_on_registration_page(){
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.click_personal_account_button();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.click_register_button();
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.click_logIn_button_registration_page();
        loginPage.click_inactive_input_email();
        loginPage.setEmail(email);
        loginPage.click_inactive_input_password();
        loginPage.setPassword(password);
        loginPage.click_logIn_button();
        String placeOrderText = mainPage.getTextPlaceOrder();
        assertEquals(placeOrderText, "Оформить заказ");
    }

    @DisplayName("Авторизация через кнопку в форме восстановления пароля")
    @Test
    public void authorization_with_logIn_button_on_recover_password_page(){
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.click_personal_account_button();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.click_recover_password();
        RecoverPasswordPage recoverPasswordPage = page(RecoverPasswordPage.class);
        recoverPasswordPage.click_logIn_button_recover_password_page();
        loginPage.click_inactive_input_email();
        loginPage.setEmail(email);
        loginPage.click_inactive_input_password();
        loginPage.setPassword(password);
        loginPage.click_logIn_button();
        String placeOrderText = mainPage.getTextPlaceOrder();
        assertEquals(placeOrderText, "Оформить заказ");
    }
}

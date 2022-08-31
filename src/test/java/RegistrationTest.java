import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

//два теста на регистрацию(успешная, и ошибка при введении пароля менее 6 символов)
public class RegistrationTest {
    String name;
    String email;
    String password;
    String token;
    String endpoint_delete = "https://stellarburgers.nomoreparties.site/api/auth/user";
    String endpoint_login = "https://stellarburgers.nomoreparties.site/api/auth/login";

    @Before
    public void creation_user_creds(){
        name = RegistrationPage.creationName();
        email = RegistrationPage.creationEmail();
        password = RegistrationPage.creationPassword();
    }

   @After
    public void delete_user_creds(){
       RegistrationPage creds = new RegistrationPage(email, password, name);
       token = given()
               .contentType(ContentType.JSON)
               .body(creds)
               .when()
               .post(endpoint_login)
               .then()
               .extract()
               .path("accessToken");

       given()
                .header("authorization", token)
                .contentType(ContentType.JSON)
                .body(creds)
                .delete(endpoint_delete);

    }

    @DisplayName("Успешная регистрация")
    @Test
    public void success_authorization() {

        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.click_personal_account_button(); //провалиться в ЛК
        LoginPage loginPage = page(LoginPage.class);
        loginPage.click_register_button(); //провалиться в Зарегистрироваться
        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.click_inactive_input_name(); //кликнуть в инпут имени
        registrationPage.setName(name); //написать имя
        registrationPage.click_inactive_input_email();
        registrationPage.setEmail(email);//написать email
        registrationPage.click_inactive_input_password();
        registrationPage.setPassword(password);
        registrationPage.click_register_button2();
        String textRegister = loginPage.getTextRegisterButton();
        assertEquals(textRegister, "Зарегистрироваться"); //переписать на сравнение с другой кнопкой, не Зарегистрироваться

    }
        @DisplayName("Регистрация с паролем в 5 знаков")
        @Test
        public void authorization_with_incorrect_password(){
            password = "FoUre";
            open("https://stellarburgers.nomoreparties.site");
            MainPage mainPage = page(MainPage.class);
            mainPage.click_personal_account_button(); //провалиться в ЛК
            LoginPage loginPage = page(LoginPage.class);
            loginPage.click_register_button(); //провалиться в Зарегистрироваться
            RegistrationPage registrationPage = page(RegistrationPage.class);
            registrationPage.click_inactive_input_name(); //кликнуть в инпут имени
            registrationPage.setName(name); //написать имя
            registrationPage.click_inactive_input_email();
            registrationPage.setEmail(email);//написать email
            registrationPage.click_inactive_input_password();
            registrationPage.setPassword(password); //написать пароль
            registrationPage.click_register_button2();
            String textIncorrectPassword = registrationPage.getTextIncorrectPassword();
            assertEquals(textIncorrectPassword, "Некорректный пароль");

    }
}

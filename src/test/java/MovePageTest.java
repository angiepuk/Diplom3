import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class MovePageTest {

    @DisplayName("Переход на вкладку Соусы")
    @Test
    public void move_to_sauce(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.click_sauce_button();
        String textSauce = mainPage.getTextSauce();
        assertEquals(textSauce, "Соусы");
    }

    @DisplayName("Переход на вкладку Начинки")
    @Test
    public void move_to_filling(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.click_filling_button();
        String textFilling = mainPage.getTextFilling();
        assertEquals(textFilling, "Начинки");
    }

    @DisplayName("Переход на вкладку Булки")
    @Test
    public void move_to_bulki(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.click_filling_button();
        mainPage.click_bulki_button();
        String textBulki = mainPage.getTextBulki();
        assertEquals(textBulki, "Булки");
    }

    @DisplayName("Переход на вкладку Личный Кабинет")
    @Test
    public void move_to_personal_account(){
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.click_personal_account_button();
        LoginPage loginPage = page(LoginPage.class);
        String textRegister = loginPage.getEntryText();
        assertEquals(textRegister, "Вход");
    }

    @DisplayName("Переход на вкладку Конструктор")
    @Test
    public void move_to_constructor() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.click_personal_account_button();
        mainPage.click_constructor_button();
        String textRaiseBurger = mainPage.getTextRaiseBurger();
        assertThat(textRaiseBurger, is("Соберите бургер"));
    }

    @DisplayName("Переход по лого на главную страницу")
    @Test
    public void move_to_main_page() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.click_personal_account_button();
        mainPage.click_logo();
        String textRaiseBurger = mainPage.getTextRaiseBurger();
        assertThat(textRaiseBurger, is("Соберите бургер"));
    }
}

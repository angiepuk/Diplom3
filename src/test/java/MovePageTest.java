import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class MovePageTest {

    @DisplayName("Переход на вкладку Соусы")
    @Test
    public void moveToSauce(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickSauceButton();
        String textSauce = mainPage.getTextSauce();
        assertEquals("Соусы", textSauce);
    }

    @DisplayName("Переход на вкладку Начинки")
    @Test
    public void movToFilling(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickFillingButton();
        String textFilling = mainPage.getTextFilling();
        assertEquals("Начинки", textFilling);
    }

    @DisplayName("Переход на вкладку Булки")
    @Test
    public void moveToBulki(){
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickFillingButton();
        mainPage.clickBulkiButton();
        String textBulki = mainPage.getTextBulki();
        assertEquals("Булки", textBulki);
    }

    @DisplayName("Переход на вкладку Личный Кабинет")
    @Test
    public void moveToPersonalAccount(){
        open("https://stellarburgers.nomoreparties.site");
        MainPage mainPage = page(MainPage.class);
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = page(LoginPage.class);
        String textRegister = loginPage.getEntryText();
        assertEquals("Вход", textRegister);
    }

    @DisplayName("Переход на вкладку Конструктор")
    @Test
    public void moveToConstructor() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickPersonalAccountButton();
        mainPage.clickConstructorButton();
        String textRaiseBurger = mainPage.getTextRaiseBurger();
        assertThat(textRaiseBurger, is("Соберите бургер"));
    }

    @DisplayName("Переход по лого на главную страницу")
    @Test
    public void moveToMainPage() {
        MainPage mainPage = open("https://stellarburgers.nomoreparties.site", MainPage.class);
        mainPage.clickPersonalAccountButton();
        mainPage.clickLogo();
        String textRaiseBurger = mainPage.getTextRaiseBurger();
        assertThat(textRaiseBurger, is("Соберите бургер"));
    }
}

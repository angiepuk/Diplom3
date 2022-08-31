package pageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.*;
public class MainPage {

    //метод клика кнопки Конструктор
    public void click_constructor_button() {
        constructorButton.click();
    }

    //метод клика кнопки Личный Кабинет
    public void click_personal_account_button() {
        personalAccountButton.click();
    }

    //метод клика кнопки Войти в аккаунт
    public void click_signIn_mainPage_button() {
        signInMainPageButton.click();
    }

    //метод клика лого Stellar Burger
    public void click_logo() {
        logoStellarBurger.click();
    }

    //метод клика кнопка Булки
    public void click_bulki_button() {
        bulkiButton.click();
    }

    //метод получения текста Булки
    public String getTextBulki(){
        return bulkiText.getText();
    }

    //метод клика кнопка Соусы
    public void click_sauce_button() {
        sauceButton.click();
    }

    //метод получения текст Соусы
    public String getTextSauce(){
        return sauceText.getText();
    }

    //метод клика кнопки Начинки
    public void click_filling_button() {
        fillingButton.click();
    }

    //метод получения текст Начинки
    public String getTextFilling(){
        return fillingText.getText();
    }

    //метод получения текста Соберите бургер
    public String getTextRaiseBurger(){
        return raiseBurgerText.getText();
    }


    //кнопка Конструктор
    @FindBy(how = How.XPATH, using = "//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Конструктор']")
    private static SelenideElement constructorButton;

    //кнопка Личный Кабинет
    @FindBy(how = How.XPATH, using = "//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Личный Кабинет']")
    private static SelenideElement personalAccountButton;

    //кнопка Войти в Аккаунт
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'button_button__33qZ0')[text()='Войти в аккаунт']")
    private static SelenideElement signInMainPageButton;

    //кнопка лого Stellar Burger
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private static SelenideElement logoStellarBurger;

    //кнопка Булки
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'text_type_main-default')][text()='Булки']")
    private static SelenideElement bulkiButton;

    //текст Булки
    @FindBy(how = How.XPATH, using = "//h2[contains(@class, 'text_type_main-medium')][text()='Булки']")
    private static SelenideElement bulkiText;

    //кнопка Соусы
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'text_type_main-default')][text()='Соусы']")
    private static SelenideElement sauceButton;

    //текст Соусы
    @FindBy(how = How.XPATH, using = "//h2[contains(@class, 'text_type_main-medium')][text()='Соусы']")
    private static SelenideElement sauceText;

    //кнопка Начинки
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'text_type_main-default')][text()='Начинки']")
    private static SelenideElement fillingButton;

    //текст Начинки
    @FindBy(how = How.XPATH, using = "//h2[contains(@class, 'text_type_main-medium')][text()='Начинки']")
    private static SelenideElement fillingText;

    //текст Соберите бургер
    @FindBy(how = How.XPATH, using = "//h1[contains(@class, 'text_type_main-large')][text()='Соберите бургер']")
    private static SelenideElement raiseBurgerText;
}

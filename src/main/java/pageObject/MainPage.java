package pageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.*;
public class MainPage {

    public void click_constructor_button() {
        constructorButton.click();
    }

    public void click_personal_account_button() {
        personalAccountButton.click();
    }

    public void click_signIn_mainPage_button() {
        signInMainPageButton.click();
    }

    public void click_logo() {
        logoStellarBurger.click();
    }

    public void click_bulki_button() {
        bulkiButton.click();
    }

    public String getTextBulki(){
        return bulkiText.getText();
    }

    public void click_sauce_button() {
        sauceButton.click();
    }

    public String getTextSauce(){
        return sauceText.getText();
    }

    public void click_filling_button() {
        fillingButton.click();
    }

    public String getTextFilling(){
        return fillingText.getText();
    }

    public String getTextRaiseBurger(){
        return raiseBurgerText.getText();
    }
    public String getTextPlaceOrder() {
        return placeOrderButton.getText();
    }

    @FindBy(how = How.XPATH, using = "//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Конструктор']")
    private static SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = "//p[@class='AppHeader_header__linkText__3q_va ml-2'][text()='Личный Кабинет']")
    private static SelenideElement personalAccountButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'button_button__33qZ0')][text()='Войти в аккаунт']")
    private static SelenideElement signInMainPageButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private static SelenideElement logoStellarBurger;

    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'text_type_main-default')][text()='Булки']")
    private static SelenideElement bulkiButton;

    @FindBy(how = How.XPATH, using = "//h2[contains(@class, 'text_type_main-medium')][text()='Булки']")
    private static SelenideElement bulkiText;

    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'text_type_main-default')][text()='Соусы']")
    private static SelenideElement sauceButton;

    @FindBy(how = How.XPATH, using = "//h2[contains(@class, 'text_type_main-medium')][text()='Соусы']")
    private static SelenideElement sauceText;

    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'text_type_main-default')][text()='Начинки']")
    private static SelenideElement fillingButton;

    @FindBy(how = How.XPATH, using = "//h2[contains(@class, 'text_type_main-medium')][text()='Начинки']")
    private static SelenideElement fillingText;

    @FindBy(how = How.XPATH, using = "//h1[contains(@class, 'text_type_main-large')][text()='Соберите бургер']")
    private static SelenideElement raiseBurgerText;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'button_button__33qZ0')][text()='Оформить заказ']")
    private static SelenideElement placeOrderButton;
}

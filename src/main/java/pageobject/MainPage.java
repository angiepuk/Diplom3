package pageobject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.*;
public class MainPage {

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

    @Step("Клик кнопки <Конструктор>")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    @Step("Клик кнопки <Личный Кабинет>")
    public void clickPersonalAccountButton() {
        personalAccountButton.click();
    }

    @Step("Клик кнопки <Войти в аккаунт>")
    public void clickSignInMainPageButton() {
        signInMainPageButton.click();
    }

    @Step("Клик лого <Stellar burgers>")
    public void clickLogo() {
        logoStellarBurger.click();
    }

    @Step("Клик кнопки <Булки>")
    public void clickBulkiButton() {
        bulkiButton.click();
    }

    @Step("Проверка присутствия заголовка <Булки> на странице")
    public String getTextBulki(){
        return bulkiText.getText();
    }

    @Step("Клик кнопки <Соусы>")
    public void clickSauceButton() {
        sauceButton.click();
    }

    @Step("Проверка присутствия заголовка <Соусы> на странице")
    public String getTextSauce(){
        return sauceText.getText();
    }

    @Step("Клик кнопки <Начинки>")
    public void clickFillingButton() {
        fillingButton.click();
    }

    @Step("Проверка присутствия заголовка <Начинки> на странице")
    public String getTextFilling(){
        return fillingText.getText();
    }

    @Step("Проверка присутствия заголовка <Соберите бургер> на странице")

    public String getTextRaiseBurger(){
        return raiseBurgerText.getText();
    }

    @Step("Проверка присутствия кнопки <Оформить заказ> на странице")
    public String getTextPlaceOrder() {
        return placeOrderButton.getText();
    }
}

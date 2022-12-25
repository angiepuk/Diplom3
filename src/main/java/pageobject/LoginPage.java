package pageobject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private static SelenideElement entryText;

    @FindBy(how = How.XPATH, using = "//label[@class='input__placeholder text noselect text_type_main-default'][text()='Email']")
    private static SelenideElement inactiveEmailInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@class, 'text input__textfield')][@name = 'name']")
    private static SelenideElement activeEmailInput;

    @FindBy(how = How.XPATH, using = "//label[@class='input__placeholder text noselect text_type_main-default'][text()='Пароль']")
    private static SelenideElement inactivePasswordInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@class, 'text input__textfield')][@name = 'Пароль']")
    private static SelenideElement activePasswordInput;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'button_button__33qZ0')][text()='Войти']")
    private static SelenideElement logInButton;

    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj'][text()='Зарегистрироваться']")
    private static SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj'][text()='Восстановить пароль']")
    private static SelenideElement recoverPasswordButton;

    @Step("Проверка присутствия заголовка <Вход> на странице")
    public String getEntryText(){
        return entryText.getText();
    }
    @Step("Клик поля <Email>")
    public void clickInactiveInputEmail(){
        inactiveEmailInput.click();
    }
    @Step("Заполнение данных в поле <Email>")
    public void setEmail(String email){
        activeEmailInput.setValue(email);
    }
    @Step("Клик поля <Пароль>")
    public void clickInactiveInputPassword(){
        inactivePasswordInput.click();
    }
    @Step("Заполнение данных в поле <Пароль>")
    public void setPassword(String password){
        activePasswordInput.setValue(password);
    }
    @Step("Клик кнопки <Войти>")
    public void clickLogInButton() {
        logInButton.click();
    }
    @Step("Клик кнопки <Зарегистрироваться>")
    public void clickRegisterButton(){
        registerButton.click();
    }
    @Step("Клик кнопки <Восстановить пароль>")
    public void clickRecoverPassword(){
        recoverPasswordButton.click();
    }
}


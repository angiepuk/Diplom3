package pageObject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    String name;
    String email;
    String password;

    @FindBy(how = How.XPATH, using = "//label[@class='input__placeholder text noselect text_type_main-default'][text()='Имя']")
    private static SelenideElement inactiveNameInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@class, 'text input__textfield')][@name = 'name']")
    private static SelenideElement activeNameInput;

    @FindBy(how = How.XPATH, using = "//label[@class='input__placeholder text noselect text_type_main-default'][text()='Email']")
    private static SelenideElement inactiveEmailInput;

    @FindBy(how = How.XPATH, using = "//form//div[label[text()='Email']]/input")
    private static SelenideElement activeEmailInput;

    @FindBy(how = How.XPATH, using = "//label[@class='input__placeholder text noselect text_type_main-default'][text()='Пароль']")
    private static SelenideElement inactivePasswordInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@class, 'text input__textfield')][@name = 'Пароль']")
    private static SelenideElement activePasswordInput;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'button_button__33qZ0')][text()='Зарегистрироваться']")
    private static SelenideElement registerButton2;

    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj'][text()='Войти']")
    private static SelenideElement logIn_button_registration_page;

    @FindBy(how = How.XPATH, using = "//p[@class='input__error text_type_main-default'][text()='Некорректный пароль']")
    private static SelenideElement incorrectPasswordText;

    public RegistrationPage() {
    }

    public RegistrationPage(String email, String password, String name) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public static String creationName(){
        return RandomStringUtils.random(8, true, false);
    }

    public static String creationEmail(){
        return RandomStringUtils.random(5, true, true) + "@yandex.ru";
    }

    public static String creationPassword(){
        return RandomStringUtils.random(6, true, true);
    }

    @Step("Клик неактивного поля <Имя>")
    public void click_inactive_input_name(){
        inactiveNameInput.click();
    }

    @Step("Клик неактивного поля <Email>")
    public void click_inactive_input_email(){
        inactiveEmailInput.click();
    }

    @Step("Клик неактивного поля <Пароль>")
    public void click_inactive_input_password(){
        inactivePasswordInput.click();
    }

    @Step("Заполнение данными поля <Имя>")
    public void setName(String name){
        activeNameInput.setValue(name);
    }

    @Step("Заполнение данными поля <Email>")
    public void setEmail(String email){
        activeEmailInput.setValue(email);
    }

    @Step("Заполнение данными поля <Пароль>")
    public void setPassword(String password){
        activePasswordInput.setValue(password);
    }

    @Step("Клик кнопки <Зарегистрироваться>")
    public void click_register_button2(){
        registerButton2.click();
    }

    @Step("Клик кнопки <Войти>")
    public void click_logIn_button_registration_page() {
        logIn_button_registration_page.click();
    }

    @Step("Проверка появления ошибки <некорректный пароль>")
    public String getTextIncorrectPassword(){
        return incorrectPasswordText.getText();
    }
}

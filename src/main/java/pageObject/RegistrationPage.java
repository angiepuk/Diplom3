package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    String name;
    String email;
    String password;

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

    public void click_inactive_input_name(){
        inactiveNameInput.click();
    }

    public void click_inactive_input_email(){
        inactiveEmailInput.click();
    }

    public void click_inactive_input_password(){
        inactivePasswordInput.click();
    }

    public void click_register_button2(){
        registerButton2.click();
    }

    public void setName(String name){
        activeNameInput.setValue(name);
        }

    public void setEmail(String email){
        activeEmailInput.setValue(email);
    }

    public void setPassword(String password){
        activePasswordInput.setValue(password);
    }

    public String getTextIncorrectPassword(){
        return incorrectPasswordText.getText();
    }

    //Инпут Неактивного Имени
    @FindBy(how = How.XPATH, using = "//label[@class='input__placeholder text noselect text_type_main-default'][text()='Имя']")
    private static SelenideElement inactiveNameInput;

    //Инпут активного Имени
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input")
    private static SelenideElement activeNameInput;

    //Инпут Неактивного email
    @FindBy(how = How.XPATH, using = "//label[@class='input__placeholder text noselect text_type_main-default'][text()='Email']")
    private static SelenideElement inactiveEmailInput;

    //Инпут активного email
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input")
    private static SelenideElement activeEmailInput;

    //Инпут Неактивного Пароля
    @FindBy(how = How.XPATH, using = "//label[@class='input__placeholder text noselect text_type_main-default'][text()='Пароль']")
    private static SelenideElement inactivePasswordInput;

    //Инпут активного Пароля
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input")
    private static SelenideElement activePasswordInput;

    //кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'button_button__33qZ0')][text()='Зарегистрироваться']")
    private static SelenideElement registerButton2;

    @FindBy(how = How.XPATH, using = "//p[@class='input__error text_type_main-default'][text()='Некорректный пароль']")
    private static SelenideElement incorrectPasswordText;
}

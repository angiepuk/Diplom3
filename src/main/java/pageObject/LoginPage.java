package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //метод получения текста кнопки Зарегистрироваться
    public String getTextRegisterButton(){
        return registerButton.getText();
    }

    public void click_register_button(){
        registerButton.click();
    }
    //кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj'][text()='Зарегистрироваться']")
    private static SelenideElement registerButton;

}


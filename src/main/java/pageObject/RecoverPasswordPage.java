package pageObject;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecoverPasswordPage {

    public void click_logIn_button_recover_password_page(){
        logIn_button_recover_password_page.click();
    }
    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj'][text()='Войти']")
    private static SelenideElement logIn_button_recover_password_page;
}

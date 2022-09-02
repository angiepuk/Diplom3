package pageObject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecoverPasswordPage {
    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj'][text()='Войти']")
    private static SelenideElement logIn_button_recover_password_page;

    @Step("Клик кнопки <Войти> на странице восстановления пароля")
    public void click_logIn_button_recover_password_page(){
        logIn_button_recover_password_page.click();
    }
}

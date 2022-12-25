package pageobject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage {
    @FindBy(how = How.XPATH, using = "//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive'][text()='Выход']")
    private static SelenideElement logOutButton;
    @Step("Нажать кнопку Выход")
    public void clickLogOutButton() {
        logOutButton.click();
    }
}


package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiter.Waiter;

public class PasswordPage extends AbstractPage {

    @FindBy(xpath = "//input[@type = 'password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@id= 'passwordNext']")
    private WebElement continueButton;

    private WebDriver driver;

    PasswordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step
    public PasswordPage setPassword(String password) {
        Waiter.waitFor(passwordInput);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public EmailListPage clickNextButton() {
        continueButton.click();
        return new EmailListPage(driver);
    }
}

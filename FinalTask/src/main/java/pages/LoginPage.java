package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiter.Waiter;

import static constants.Constants.URL;

public class LoginPage extends AbstractPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id = 'identifierNext']")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement mailInput;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPage initPage() {
        driver.get(URL);
        return this;
    }

    @Step
    public LoginPage setEmail(String email) {
        Waiter.waitFor(mailInput);
        mailInput.sendKeys(email);
        return this;
    }

    public PasswordPage clickNextButton() {
        continueButton.click();
        return new PasswordPage(driver);
    }
}

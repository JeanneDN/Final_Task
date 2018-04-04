package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiter.Waiter;

public class EmailListPage extends AbstractPage {
    WebDriver driver;

    @FindBy(xpath = "//div[@act = '20']")
    private WebElement refreshButton;

    @FindBy(xpath = "//div[contains(text(),'COMPOSE')]")
    private WebElement writeButton;

    @FindBy(xpath = "//*[@name = 'to']")
    private WebElement recipientInput;

    @FindBy(xpath = "//input[@name = 'subjectbox']")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@aria-label = 'Message Body']")
    private WebElement messageInput;

    @FindBy(xpath = "//div[contains(text(),'Send')]")
    private WebElement sendButton;

    @FindBy(xpath = "(//span[text()='me'])[2]")
    private WebElement receivedEmail;

    @FindBy(xpath = "//*[@role='presentation']//div[@dir]")
    private WebElement receivedMessage;

    @FindBy(xpath = "(//*[@act = '10'])[2]")
    private WebElement deleteMessageButton;

    public EmailListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step
    public String getReceivedMessageText() {
        return receivedMessage.getText();
    }

    @Step
    public EmailListPage clickDeleteMessageButton() {
        Waiter.waitFor(deleteMessageButton);
        deleteMessageButton.click();
        return new EmailListPage(driver);
    }

    @Step
    public void clickReceivedEmail() {
        Waiter.waitFor(receivedEmail);
        receivedEmail.click();
    }

    @Step
    public EmailListPage setRecipientEmail(String email) {
        Waiter.waitFor(recipientInput);
        recipientInput.sendKeys(email);
        return this;
    }

    @Step
    public EmailListPage setSubject(String subject) {
        subjectInput.sendKeys(subject);
        return this;
    }

    @Step
    public EmailListPage setMessage(String message) {
        messageInput.sendKeys(message);
        return this;
    }

    @Step
    public EmailListPage clickWriteButton() {
        Waiter.waitFor(writeButton);
        writeButton.click();
        return this;
    }

    @Step
    public EmailListPage clickSendButton() {
        sendButton.click();
        return this;
    }

    @Step
    public EmailListPage clickRefreshButton() {
        Waiter.waitFor(refreshButton);
        refreshButton.click();
        return this;
    }
}

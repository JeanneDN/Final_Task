package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiter.Waiter;

public class AbstractPage {

    AbstractPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Waiter.initWaiter(driver);
    }
}

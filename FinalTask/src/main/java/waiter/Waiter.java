package waiter;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Waiter {
    private static WebDriverWait waiter;

    public static void initWaiter(WebDriver driver) {
        waiter = new WebDriverWait(driver, 2);
        waiter.withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public static void waitFor(WebElement element) {
        waiter.until(ExpectedConditions.visibilityOf(element));
    }
}

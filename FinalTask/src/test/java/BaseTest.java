import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.EmailListPage;
import pages.LoginPage;

import static constants.Constants.*;

public class BaseTest {
    protected LoginPage loginPage;
    protected EmailListPage emailListPage;
    protected WebDriver driver;

    @BeforeClass
    public void initDriver() {
        System.setProperty(DRIVER_NAME, DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void initPages() {
        loginPage = new LoginPage(driver);
        emailListPage = new EmailListPage(driver);
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }
}

import org.testng.annotations.Test;

import static constants.Constants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GmailTest extends BaseTest {

    @Test
    public void shouldCheckReceivedEmailMatchesToSentEmail() {

        loginPage.initPage()
                .setEmail(EMAIL)
                .clickNextButton()
                .setPassword(PASSWORD)
                .clickNextButton()
                .clickWriteButton()
                .setRecipientEmail(EMAIL)
                .setSubject(SUBJECT)
                .setMessage(MESSAGE)
                .clickSendButton()
                .clickRefreshButton()
                .clickReceivedEmail();

        assertThat(driver.getTitle(), equalTo(String.format("%s - %s - Gmail", SUBJECT, EMAIL)));
        assertThat(MESSAGE, equalTo(emailListPage.getReceivedMessageText()));

        emailListPage.clickDeleteMessageButton().clickRefreshButton();
    }
}

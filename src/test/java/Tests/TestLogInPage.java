package Tests;

import hooks.BeforeAndAfterHooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import static Tests.HelpMethods.loginPage;
import static Tests.HelpMethods.loginUser;
import static helpers.CustomWaits.waitForUsernameToBeVisible;

public class TestLogInPage extends BeforeAndAfterHooks {


    @Test(priority = 1)
    public void loginWithValidCredentials() throws InterruptedException {
        loginUser("maria", "thoushallnotpass");
        HomePage homePage = HomePage.getInstance(driver);
        Assert.assertTrue(homePage.isThereLoggedUsername());
        homePage.clickOnLogoutButton();
        waitForUsernameToBeVisible();
    }

    @Test(priority = 2)
    public void loginWithInvalidPassword() {
        loginUser("maria", "maria");
        Assert.assertTrue(loginPage.isVisibleAlert());
    }
}


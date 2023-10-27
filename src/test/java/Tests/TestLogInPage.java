package Tests;

import hooks.BeforeAndAfterHooks;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import static helpers.CustomWaits.waitForUsernameToBeVisible;

@Listeners(ReporterManager.class)
public class TestLogInPage extends BeforeAndAfterHooks {
    public LoginPage loginPage = new LoginPage(driver);

    @Test(priority = 1)
    public void loginWithValidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = HomePage.getInstance(driver);
        loginPage.loginUser("maria", "thoushallnotpass");
        Assert.assertTrue(homePage.isThereLoggedUsername());
        homePage.clickOnLogoutButton();
        waitForUsernameToBeVisible();
    }

    @Test(priority = 2)
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("maria", "maria");
        Assert.assertTrue(loginPage.isVisibleAlert());
    }
}
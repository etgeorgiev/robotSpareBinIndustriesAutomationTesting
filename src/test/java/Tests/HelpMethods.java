package Tests;

import hooks.BeforeAndAfterHooks;
import org.openqa.selenium.NoSuchElementException;
import pages.HomePage;
import pages.LoginPage;

public class HelpMethods extends BeforeAndAfterHooks {
    static LoginPage loginPage = new LoginPage(driver);
    static HomePage homePage = new HomePage(driver);

    public static void loginUser(String username, String password){
        loginPage.insertUsernameInTheField(username);
        loginPage.insertPasswordInTheField(password);
        loginPage.pressLoginButton();
    }

    public static void addNewSalesEntries(String firstName, String lastName, String salesTarget, String salesResult){
        homePage.insertFirstName(firstName);
        homePage.insertLastName(lastName);
        homePage.clickOnSalesTargetMenu();
        homePage.clickOnTargetOptions(salesTarget);
        homePage.insertSalesResult(salesResult);
        homePage.clickSubmitButton();
    }
}

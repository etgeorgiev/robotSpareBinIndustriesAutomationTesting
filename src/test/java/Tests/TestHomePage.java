package Tests;

import helpers.CustomWaits;
import hooks.BeforeAndAfterHooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Tests.HelpMethods.*;

public class TestHomePage extends BeforeAndAfterHooks {
    @Test(priority = 1)
    public void tryAddNewSalesEntries() throws InterruptedException {
        loginUser("maria", "thoushallnotpass");
        addNewSalesEntries("Ivan","Ivanov","10000", "9999");
        Assert.assertEquals(homePage.getTextFromSpanActiveSalesPeople(),"1");
        Thread.sleep(5);
    }

    @Test(priority = 2)
    public void tryAddSecondNewSalesEntries() throws InterruptedException {
        addNewSalesEntries("Petar","Petrov","25000","30000");
        Assert.assertEquals(homePage.getTextFromSpanActiveSalesPeople(),"2");
        Thread.sleep(5);
    }

    @Test(priority = 3)
    public void showPerformanceResult(){
        homePage.clickShowPerformanceButton();
        Assert.assertEquals(homePage.getTextFromPerformanceComment(1),"A positive result. Well done!");
        Assert.assertEquals(homePage.getTextFromPerformanceComment(2),"Hmm. Did not quite make it.");
    }

    @Test(priority = 4)
    public void deleteAllSalesEntries() throws InterruptedException {
        homePage.clickDeleteEntries();
        CustomWaits.waitForSalesResultToBeDeleted();
        Assert.assertFalse(homePage.isThereTableWithSalesEntries());
        homePage.clickOnLogoutButton();
        CustomWaits.waitForUsernameToBeVisible();
    }
}

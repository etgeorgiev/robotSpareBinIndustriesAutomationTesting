package hooks;

import helpers.BrowserFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BeforeAndAfterHooks extends BrowserFactory {

    public static WebDriver driver;

    @BeforeMethod
    public void beforeClass(){
        driver = getBrowser("Chrome");
        driver.get("https://robotsparebinindustries.com/#/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void clearCache(){
        clearCacheAndHistory();
       // quitDriver();
    }

    @AfterTest
    public void closeAllDriver(){
        closeDriver();
    }
}

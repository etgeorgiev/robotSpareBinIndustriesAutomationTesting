package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static hooks.BeforeAndAfterHooks.driver;

public class CustomWaits {
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public static void waitForUsernameToBeVisible(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
    }

    public static void waitForSalesResultToBeDeleted(){
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.className("btn-info"))));
    }
}

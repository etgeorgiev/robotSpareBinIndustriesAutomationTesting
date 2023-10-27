package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    private static Map<String, WebDriver> drivers = new HashMap<>();
    static WebDriver driver = null;

    public static WebDriver getBrowser(String browserName) {
        switch (browserName) {
            case "Chrome":
                driver = drivers.get("Chrome");
                if (driver == null) {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    drivers.put("Chrome", driver);
                }
                break;

            case "Firefox":
                driver = drivers.get("Firefox");
                if (driver == null) {
                    driver = new FirefoxDriver();
                    //Set time for waiting if there is a problem with network
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    drivers.put("Firefox", driver);
                }
                break;
            case "Edge":
                driver = drivers.get("IE");
                if (driver == null) {
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(options);
                    //Set time for waiting if there is a problem with network
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                    drivers.put("Edge", driver);
                }
                break;
        }
        return driver;
    }

    public static void clearCacheAndHistory() {
        driver.manage().deleteAllCookies();
        driver.get("chrome://settings/clearBrowserData");
        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
    }

    public static void closeDriver() {
        for (String key : drivers.keySet()) {
            drivers.get(key).quit();
        }
    }
}
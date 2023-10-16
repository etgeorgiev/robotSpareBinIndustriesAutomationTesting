package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
                    System.setProperty("webdriver.chrome.driver", "D:\\robotSpareBinIndustriesAutomationTesting\\src" +
                            "\\test\\resources\\drivers\\chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    drivers.put("Chrome", driver);
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

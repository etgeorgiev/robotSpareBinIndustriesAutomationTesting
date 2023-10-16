package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    static LoginPage logInPageInstance;

    By userUsernameField = By.id("username");
    By passwordField = By.id("password");
    By warningAlert = By.className("alert-warning");
    By loginButton = By.className("btn-primary");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static LoginPage getInstance(WebDriver driver) {

        if (logInPageInstance == null) {
            logInPageInstance = new LoginPage(driver);
        }
        return logInPageInstance;
    }


    public void insertUsernameInTheField(String username) {
        driver.findElement(userUsernameField).sendKeys(username);
    }

    public void insertPasswordInTheField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void pressLoginButton() {
        driver.findElement(loginButton).click();
    }

    public Boolean isVisibleAlert(){
        return driver.findElement(warningAlert).isDisplayed();
    }
}

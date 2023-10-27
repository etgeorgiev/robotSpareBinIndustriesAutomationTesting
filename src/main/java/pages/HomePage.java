package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public static HomePage homePageInstance;

    By firstNameField = By.id("firstname");
    By lastNameField = By.id("lastname");
    By salesTarget = By.id("salestarget");
    By salesResultField = By.id ("salesresult");
    By submitButton = By.className("btn-primary");
    By showPerformanceButton = By.className("btn-info");
    By hidePerformanceButton = By.linkText("Hide performance");
    By deleteSalesEntriesButton = By.className("btn-danger");
    By loggedUsername = By.className("btn-dark");
    By logoutButton = By.id("logout");
    By activeSalesPeople = By.xpath("//div[@class='alert alert-dark sales-summary']/div[1]/span[2]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public static HomePage getInstance(WebDriver driver){
        if(homePageInstance == null){
            homePageInstance = new HomePage(driver);
        }
        return homePageInstance;
    }

    public void insertFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void insertLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void clickOnSalesTargetMenu(){
        driver.findElement(salesTarget).click();
    }

    public void clickOnTargetOptions(String option){
        switch (option){
            case "5000": driver.findElement(By.xpath("//select/option[@value='5000']")).click();
                break;
            case "10000": driver.findElement(By.xpath("//select/option[@value='10000']")).click();
                break;
            case "25000": driver.findElement(By.xpath("//select/option[@value='25000']")).click();
                break;
            case "30000": driver.findElement(By.xpath("//select/option[@value='30000']")).click();
                break;
        }
    }

    public void insertSalesResult(String salesResult){
        driver.findElement(salesResultField).sendKeys(salesResult);
    }

    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public void clickShowPerformanceButton(){
        driver.findElement(showPerformanceButton).click();
    }

    public void clickHidePerformanceButton(){
        driver.findElement(hidePerformanceButton).click();
    }

    public void clickDeleteEntries(){
        driver.findElement(deleteSalesEntriesButton).click();
    }

    public Boolean isThereLoggedUsername(){return driver.findElement(loggedUsername).isDisplayed();}

    public void clickOnLogoutButton(){
        driver.findElement(logoutButton).click();
    }
    public String getTextFromSpanActiveSalesPeople(){return driver.findElement(activeSalesPeople).getText();}

    public String getTextFromPerformanceComment(int salesEntries){
        switch (salesEntries){
            case 1: return driver.findElement(By.xpath("//*[@id=\"sales-results\"]/table/tbody/tr[2]")).getText();
            case 2: return driver.findElement(By.xpath("//*[@id=\"sales-results\"]/table/tbody/tr[4]")).getText();
            case 3: return driver.findElement(By.xpath("//*[@id=\"sales-results\"]/table/tbody/tr[6]")).getText();
            case 4: return driver.findElement(By.xpath("//*[@id=\"sales-results\"]/table/tbody/tr[8]")).getText();
            case 5: return driver.findElement(By.xpath("//*[@id=\"sales-results\"]/table/tbody/tr[10]")).getText();
            default:
                return "There is no sales entries";
        }
    }

    public Boolean isThereTableWithSalesEntries(){
        try {
            return driver.findElement(showPerformanceButton).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void addNewSalesEntries(String firstName, String lastName, String salesTarget, String salesResult){
        insertFirstName(firstName);
        insertLastName(lastName);
        clickOnSalesTargetMenu();
        clickOnTargetOptions(salesTarget);
        insertSalesResult(salesResult);
        clickSubmitButton();
    }
}
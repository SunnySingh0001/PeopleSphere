package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage{

    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By username = By.name("username");
    By password = By.name("password");
    By submit = By.xpath("//button[normalize-space()='Login']");
    By errorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");
    By requiredMessage = By.xpath("//span[text()='Required']");

    public void enterUserName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).sendKeys(name);
    }

    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.password));
        driver.findElement(this.password).sendKeys(password);
    }

    public void loginSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
    }

    public String getInvalidCredentialMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

    public String getRequiredMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(requiredMessage));
        return driver.findElement(requiredMessage).getText();

    }

}

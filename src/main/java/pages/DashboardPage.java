package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    By profile = By.xpath("//li[@class='oxd-userdropdown']");
    By logout = By.xpath("//a[normalize-space()='Logout']");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By dashboardlocator = By.xpath("//h6[normalize-space()='Dashboard']");
    By loginpage = By.name("username");

    public boolean isDashboardDesible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardlocator));
        return driver.findElement(dashboardlocator).isDisplayed();
    }

    public void clickProfile(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(profile));
        driver.findElement(profile).click();
    }

    public void clickLogout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
        driver.findElement(logout).click();
    }

    public boolean isLoginDesible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginpage));
        return driver.findElement(loginpage).isDisplayed();
    }

}

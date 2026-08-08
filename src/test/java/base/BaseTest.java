package base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.ConfigReader;

public class BaseTest {
    protected WebDriver driver;

    String url = ConfigReader.getProperty("baseUrl");

    @BeforeMethod
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(url);

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
//        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            driver.quit();

        }
    }

    public void login() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUserName(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.loginSubmit();

    }

}
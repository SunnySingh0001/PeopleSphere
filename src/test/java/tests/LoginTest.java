package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    String username = ConfigReader.getProperty("username");
    String password = ConfigReader.getProperty("password");

    @Test
    public void ValidLoginTest(){

        login();

        DashboardPage dashboardPage = new DashboardPage(driver);

        Assert.assertTrue(dashboardPage.isDashboardDesible());

    }

    @Test
    public void invalidPasswordTest(){

        LoginPage loginpage = new LoginPage(driver);

        loginpage.enterUserName(username);
        loginpage.enterPassword("wrong123");
        loginpage.loginSubmit();

        Assert.assertEquals(
                loginpage.getInvalidCredentialMessage(),
                "Invalid credentials"
        );

    }

    @Test
    public void invalidUsernameTest(){

        LoginPage loginpage = new LoginPage(driver);

        loginpage.enterUserName("WrongUser");
        loginpage.enterPassword(password);
        loginpage.loginSubmit();

        Assert.assertEquals(
                loginpage.getInvalidCredentialMessage(),
                "Invalid credentials"
        );

    }

    @Test
    public void EmptyUsernameTest(){

        LoginPage loginpage = new LoginPage(driver);

        loginpage.enterUserName("");
        loginpage.enterPassword(password);
        loginpage.loginSubmit();

        Assert.assertEquals(
                loginpage.getRequiredMessage(),
                "Required"
        );

    }

    @Test
    public void EmptyPasswordTest(){

        LoginPage loginpage = new LoginPage(driver);

        loginpage.enterUserName(username);
        loginpage.enterPassword("");
        loginpage.loginSubmit();

        Assert.assertEquals(
                loginpage.getRequiredMessage(),
                "Required"
        );

    }

    @Test
    public void EmptyCredentialTest(){

        LoginPage loginpage = new LoginPage(driver);

        loginpage.enterUserName("");
        loginpage.enterPassword("");
        loginpage.loginSubmit();

        Assert.assertEquals(
                loginpage.getRequiredMessage(),
                "Required"
        );

    }

    @Test
    public void LogoutTest(){

        login();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickProfile();
        dashboardPage.clickLogout();

        Assert.assertTrue(dashboardPage.isLoginDesible());


    }

////li[@class='oxd-userdropdown'] drodown
    //a[normalize-space()='Logout'] logout

}

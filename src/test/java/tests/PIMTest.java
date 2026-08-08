package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;
import utils.ConfigReader;

public class PIMTest extends BaseTest {

    String username = ConfigReader.getProperty("username");
    String password = ConfigReader.getProperty("password");

    @Test
    public void openPIM() {

       login();

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDesible());

        PIMPage pimPage = new PIMPage(driver);
        pimPage.PimClick();

        Assert.assertTrue(pimPage.isPimPageOpen());
    }

    @Test
    public void addEmployeeTest(){

        login();

        PIMPage pim = new PIMPage(driver);

        pim.PimClick();

        Assert.assertTrue(pim.isPimPageOpen());

        pim.clickAddButton();

        Assert.assertTrue(pim.isAddEmployeePageOpen());

        pim.addEmployeeDetails(
                "Sunny",
                "Singh",
                "Parihar",
                "1011"
        );

        pim.clickSave();

        Assert.assertTrue(pim.isEmployeeCreated());

    }

    @Test
    public void searchEmployeeTest(){

        login();

        PIMPage pim = new PIMPage(driver);

        pim.PimClick();

        pim.searchEmployeeId("10011");

        pim.clickSearch();

        Assert.assertTrue(pim.isRecordDisplayed());

    }

    @Test
    public void editEmployeeTest() {

        // Reusable Login
        login();

        PIMPage pimPage = new PIMPage(driver);

        // Open PIM
        pimPage.PimClick();

        // Search Employee
        pimPage.searchEmployeeId("05931011");   // <-- Apna Employee ID likho

        pimPage.clickSearch();

        Assert.assertTrue(pimPage.isEmployeeFound());

        // Click Edit
        pimPage.clickEdit();

        // Update First Name
        pimPage.editFirstName("Sunny");

        // Save
        pimPage.clickSaveEdit();

        // Verify
        Assert.assertTrue(pimPage.isUpdateSuccess());

    }

    @Test
    public void deleteEmployeeTest(){

        login();

        PIMPage pim = new PIMPage(driver);

        pim.PimClick();

        pim.searchEmployeeId("05931011");

        pim.clickSearch();

        Assert.assertTrue(pim.isEmployeeFound());

        pim.selectEmployee();

        pim.clickDelete();

        pim.confirmDelete();

        Assert.assertTrue(pim.isDeleteSuccess());

    }

}

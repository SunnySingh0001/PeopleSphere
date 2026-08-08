package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {
    WebDriver driver;
    WebDriverWait wait;

    public PIMPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    By employeeCheckbox = By.xpath("(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[1]");

    By deleteButton = By.xpath("//button[i[@class='oxd-icon bi-trash']]");

    By confirmDelete = By.xpath("//button[normalize-space()='Yes, Delete']");

    By deleteSuccess = By.xpath("//p[contains(text(),'Successfully Deleted')]");

    By noRecord = By.xpath("//span[contains(text(),'No Records Found')]");
    By editButton = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
    By SearchrecordFound = By.xpath("//span[contains(text(),'Record Found') or contains(text(),'Records Found')]");
    By employeeName = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
    By resetButton = By.xpath("//button[normalize-space()='Reset']");
    By pimMenu = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']");
    By pimPagesOpen = By.xpath("//div[@class='oxd-topbar-header-title']");
    By addButton = By.xpath("//button[normalize-space()='Add']");
    By addPage = By.xpath("//h6[normalize-space()='Add Employee']");
    By firstName = By.name("firstName");
    By middleName = By.name("middleName");
    By lastName = By.name("lastName");
    By employeeId = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By save = By.xpath("//button[normalize-space()='Save']");
    By personalDetails = By.xpath("//h6[text()='Personal Details']");
    By searchEmployeeId = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By searchButton = By.xpath("//button[normalize-space()='Search']");
    By recordFound = By.xpath("//div[@class='oxd-table-body']");
    By firstNameEdit = By.name("firstName");
    By saveEdit = By.xpath("(//button[@type='submit'])[1]");
    By successMessage = By.xpath("//p[text()='Successfully Updated']");


    public void PimClick(){
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu));
        driver.findElement(pimMenu).click();
    }

    public boolean isPimPageOpen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pimPagesOpen));
        return driver.findElement(pimPagesOpen).isDisplayed();
    }

    public void clickAddButton(){
        wait.until(ExpectedConditions.elementToBeClickable(addButton));
        driver.findElement(addButton).click();
    }

    public void enterFirstName(String fname){
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterMiddleName(String mname){
        driver.findElement(middleName).sendKeys(mname);
    }

    public void enterLastName(String lname){
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmployeeId(String id){
        driver.findElement(employeeId).clear();
        driver.findElement(employeeId).sendKeys(id);
    }

    public void clickSave(){
        driver.findElement(save).click();
    }

    public boolean isEmployeeCreated(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetails));
        return driver.findElement(personalDetails).isDisplayed();
    }

    public boolean isAddEmployeePageOpen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addPage));
        return driver.findElement(addPage).isDisplayed();
    }

    public void addEmployeeDetails(String fname,
                                   String mname,
                                   String lname,
                                   String empId){

        enterFirstName(fname);
        enterMiddleName(mname);
        enterLastName(lname);
        enterEmployeeId(empId);

    }

    public void searchEmployeeId(String id){

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchEmployeeId));

        driver.findElement(searchEmployeeId).clear();
        driver.findElement(searchEmployeeId).sendKeys(id);

    }

    public void clickSearch(){

        wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        driver.findElement(searchButton).click();

    }

    public boolean isEmployeeFound(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(recordFound));

        return driver.findElement(recordFound).isDisplayed();

    }

    public void enterEmployeeName(String name){
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName));
        driver.findElement(employeeName).sendKeys(name);
    }

    public void clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchButton).click();
    }

    public void clickResetButton(){
        wait.until(ExpectedConditions.elementToBeClickable(resetButton));
        driver.findElement(resetButton).click();
    }

    public boolean isRecordDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(recordFound));
        return driver.findElement(recordFound).isDisplayed();
    }

    public void editFirstName(String newName){

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameEdit));

        driver.findElement(firstNameEdit).clear();
        driver.findElement(firstNameEdit).sendKeys(newName);

    }

    public void clickSaveEdit(){

        wait.until(ExpectedConditions.elementToBeClickable(saveEdit));

        driver.findElement(saveEdit).click();
    }

    public boolean isUpdateSuccess(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));

        return driver.findElement(successMessage).isDisplayed();
    }

    public void clickEdit() {

        wait.until(ExpectedConditions.elementToBeClickable(editButton));

        driver.findElement(editButton).click();
    }

    public void selectEmployee(){

        wait.until(ExpectedConditions.elementToBeClickable(employeeCheckbox));

        driver.findElement(employeeCheckbox).click();

    }

    public void clickDelete(){

        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));

        driver.findElement(deleteButton).click();

    }

    public void confirmDelete(){

        wait.until(ExpectedConditions.elementToBeClickable(confirmDelete));

        driver.findElement(confirmDelete).click();

    }

    public boolean isDeleteSuccess(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccess));

        return driver.findElement(deleteSuccess).isDisplayed();

    }

    public boolean isNoRecordFound(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(noRecord));

        return driver.findElement(noRecord).isDisplayed();

    }




}


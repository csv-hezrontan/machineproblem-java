package webpages.Employee;

import models.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class EmployeesPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public static String PAGE_URL="http://magenicautomation.azurewebsites.net/Employees";

    @FindBy(linkText = "Create New")
    private WebElement createButton;

    @FindBy(className = "table")
    private WebElement table;

    @FindBy(css = "table.table tbody")
    private WebElement tableBody;

    @FindBy(css = "table.table tbody tr")
    private List<WebElement> tableBodyRows;

    public EmployeesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigate to the Employees Page
     */
    public void navigate() {
        driver.get(EmployeesPage.PAGE_URL);
    }

    /**
     * Clicks the create button
     */
    public void clickEmployeeCreate(){
        wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }

    /**
     * Click the employee action in the table
     * @param action Action link text to click in the table (Edit, Details, Delete)
     * @param employeeDetails Employee details storage to click
     */
    public void ClickEmployeeActionLink(String action, Employee employeeDetails){
        List<WebElement> rows = wait.until(
                ExpectedConditions.visibilityOfNestedElementsLocatedBy(table, By.cssSelector("tr")));
        for (WebElement element: rows){
            String tFirstName = element.findElements(By.cssSelector("td")).get(3).getText();
            String tLastName = element.findElements(By.cssSelector("td")).get(4).getText();
            if ((tFirstName.equals(employeeDetails.getFirstName())) &&
                    (tLastName.equals(employeeDetails.getLastName()))){
                wait.until(ExpectedConditions.elementToBeClickable(By.linkText(action))).click();
                break;
            }
        }
    }

    /**
     * Creates the employee with the data provided
     * @param employeeDetails Employee details to create
     */
    public Employee createEmployee(Employee employeeDetails) {
        this.navigate();
        this.clickEmployeeCreate();

        EmployeeCreatePage employeeCreatePage = new EmployeeCreatePage(driver);
        return employeeCreatePage.createEmployee(employeeDetails);
    }

    /**
     * Delete the employee by clicking the delete button on the employee row
     *  and on the employee delete page
     * @param employeeDetails Employee details to delete
     */
    public void deleteEmployee(Employee employeeDetails) {
        WebElement employeeRowInTableDeleteButton = employeeTableRowElement(employeeDetails).findElement(By.linkText("Delete"));
        employeeRowInTableDeleteButton.click();

        EmployeeDeletePage employeeDeletePage = new EmployeeDeletePage(driver, employeeDetails);
        employeeDeletePage.waitToBeActive();
        employeeDeletePage.deleteEmployee();
    }

    /**
     * Verify the Employee exist in data table
     * @param employeeDetails Employee details storage to verify
     * @return true/false: employee exist/not in table
     */
    public boolean doesEmployeeExist(Employee employeeDetails){
        boolean exists = false;
        for (WebElement element: this.employeeRows()){
            List<WebElement> tableData = element.findElements(By.tagName("td"));

            // Skip table header
            if (tableData.size() == 0) {
                continue;
            }

            if (!employeeDetails.getFirstName().equals(tableData.get(3).getText())
                    || !employeeDetails.getLastName().equals(tableData.get(4).getText())) {
                continue;
            }

            if (employeeDetails.getAddress() != null
                    && !employeeDetails.getAddress().equals(tableData.get(5).getText())) {
                continue;
            }

            if (employeeDetails.getState() != null
                    && !employeeDetails.getState().equals(tableData.get(2).getText())) {
                continue;
            }

            if (employeeDetails.getCity() != null
                    && !employeeDetails.getCity().equals(tableData.get(0).getText())) {
                continue;
            }

            if (employeeDetails.getDepartment() != null
                    && !employeeDetails.getDepartment().equals(tableData.get(1).getText())) {
                continue;
            }

            exists = true;
            break;
        }

        return exists;
    }

    /**
     * Get the Employee ID from the last section of the Edit link
     * @param employeeDetails Employee details to delete
     */
    public int getEmployeeIDFromTableRow(Employee employeeDetails) {
        WebElement employeeRowEditButton = this.employeeTableRowElement(employeeDetails).findElement(By.linkText("Edit"));
        String editButtonLink = employeeRowEditButton.getAttribute("href");
        String[] splitEditButtonLink = editButtonLink.split("/");

        // Employee ID can be retrieved from the last section of the Edit, View, and Delete links
        return Integer.parseInt(splitEditButtonLink[splitEditButtonLink.length - 1]);
    }


    // --- Web elements
    private WebElement employeeTableRowElement(Employee employeeDetails) {
        return this.tableBodyRows.stream().filter(tr ->
                tr.getText().contains(employeeDetails.getFirstName() + " " + employeeDetails.getLastName()))
                .findFirst().orElse(null);
    }

    private List<WebElement> employeeRows() {
        return wait.until(
                ExpectedConditions.visibilityOfNestedElementsLocatedBy(tableBody, By.cssSelector("tr")));
    }
}

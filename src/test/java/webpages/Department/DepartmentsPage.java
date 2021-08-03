package webpages.Department;

import models.Department;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * This class contains the elements and actions that can be done on the Departments Page
 */
public class DepartmentsPage {
    private final WebDriver driver;

    //Page URL
    public static final String PAGE_URL = "http://magenicautomation.azurewebsites.net/Departments";

    //Locators

    //Create New Department Button
    @FindBy(how = How.LINK_TEXT, using = "Create New")
    private WebElement createNewDepartmentLink;

    //Constructor
    public DepartmentsPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    /**
     * Checks if the Department page is active by verifying the URI
     * @return true/false If the create Department page is opened or not
     */
    public boolean isPageOpened(){
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

    /**
     * Clicks on the new Department Link
     */
    public void clickOnCreateNewDepartmentLink(){
        createNewDepartmentLink.click();
    }

    /**
     * Checks if the provided Department details exists in the table
     * @param departmentDetails Department details to check
     */
    public boolean checkIfDepartmentExists(Department departmentDetails) {
        List<WebElement> departments = driver.findElements(new By.ByCssSelector("tr > td:first-child"));

        return departments.stream().anyMatch(department -> department.getText().equals(departmentDetails.getName()));
    }

    /**
     * Deletes the Department provided
     * @param departmentDetails Department details to delete
     */
    public void deleteDepartment(Department departmentDetails) {
        List<WebElement> departments = driver.findElements(new By.ByCssSelector("tbody > tr"));
        List<WebElement> rowObjects;
        for (WebElement department : departments) {
            rowObjects = department.findElements(new By.ByCssSelector("td"));
            if (rowObjects.size() == 0)
                continue;

            if (rowObjects.get(0).getText().equals(departmentDetails.getName())) {
                department.findElement(new By.ByCssSelector("a[href*='Delete']")).click();
                break;
            }
        }
    }
}

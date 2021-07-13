package webpages.Employee;

import models.Employee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains the elements and actions that can be done on the Employees Delete Page
 */
public class EmployeeDeletePage {
    private WebDriverWait wait;
    private static String BASE_PAGE_URL="http://magenicautomation.azurewebsites.net/Employees/Delete/";
    private String PAGE_URL;

    @FindBy(css = "form > div > input[value=\"Delete\"]")
    private WebElement deleteButton;

    public EmployeeDeletePage(WebDriver driver, Employee employeeDetails) {
        this.PAGE_URL = EmployeeDeletePage.BASE_PAGE_URL + employeeDetails.getID();
        wait = new WebDriverWait(driver, 10);

        //Initialize Elements
        PageFactory.initElements(driver, this);
    }

    /**
     * Wait for the page to be active by checking the browser url
     */
    public void waitToBeActive() {
        wait.until(ExpectedConditions.urlToBe(this.PAGE_URL));
    }

    /**
     * Click the delete button and wait for the redirection back to the main employees page
     */
    public void deleteEmployee() {
        this.deleteButton.click();

        // Redirecting back to the main page means that the delete button has been clicked
        wait.until(ExpectedConditions.urlToBe(EmployeesPage.PAGE_URL));
    }
}

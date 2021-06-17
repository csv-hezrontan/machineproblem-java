package webpages.Department;

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

public class DepartmentsPage {
    private WebDriver driver;

    //Page URL
    private static String PAGE_URL="http://magenicautomation.azurewebsites.net/Departments";

    //Locators

    //Create New Department
    @FindBy(how = How.LINK_TEXT, using = "Create New")
    private WebElement createNewDepartmentLink;

    //Constructor
    public DepartmentsPage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnCreateNewDepartmentLink(){
        createNewDepartmentLink.click();
    }

    public boolean checkIfDepartmentExists(String departmentName) {
        List<WebElement> departments = driver.findElements(new By.ByCssSelector("tr > td:first-child"));

        return departments.stream().anyMatch(department -> department.getText().equals(departmentName));
    }

    public void deleteDepartment(String departmentName) {
        List<WebElement> departments = driver.findElements(new By.ByCssSelector("tbody > tr"));
        List<WebElement> rowObjects;
        for (WebElement department : departments) {
            rowObjects = department.findElements(new By.ByCssSelector("td"));
            if (rowObjects.size() == 0)
                continue;

            if (rowObjects.get(0).getText().equals(departmentName)) {
                department.findElement(new By.ByCssSelector("a[href*='Delete']")).click();
                break;
            }
        }
    }
}

package webpages.Employee;

import models.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class EmployeeCreatePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static String PAGE_URL="http://magenicautomation.azurewebsites.net/Employees/Create";

    @FindBy(id = "EmpFirstName")
    private WebElement firstNameInputField;

    @FindBy(id = "EmpLastName")
    private WebElement lastNameInputField;

    @FindBy(id = "EmpAddress")
    private WebElement addressInputField;

    @FindBy(id = "CityObj_CityName")
    private WebElement cityInputField;

    @FindBy(id = "StateID")
    private WebElement stateDropdown;

    @FindBy(id = "DepartmentID")
    private WebElement departmentDropdown;

    @FindBy(css = "input[value=\"Create\"]")
    private WebElement createButton;

    public EmployeeCreatePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

        //Initialize Elements
        PageFactory.initElements(driver, this);
    }

    /**
     * Creates the employee by filling out the form with the data provided
     * @param employeeDetails Employee details to enter in the form
     */
    public Employee createEmployee(Employee employeeDetails) {
        Random random = new Random();
        WebElement randomOption;

        firstNameInputField.sendKeys(employeeDetails.getFirstName());
        lastNameInputField.sendKeys(employeeDetails.getLastName());
        addressInputField.sendKeys(employeeDetails.getAddress());

        stateDropdown.click();
        List<WebElement> stateOptions = stateDropdown.findElements(By.tagName("option"));

        if (employeeDetails.getState() == null) {
            // Click on a random State option
            randomOption = stateOptions.get(random.nextInt(stateOptions.size()));
            randomOption.click();

            employeeDetails.setState(randomOption.getText());
        } else {
            // create future implementation for non-null state
            System.out.println("Not yet implemented");
        }

        cityInputField.sendKeys(employeeDetails.getCity());

        String department = employeeDetails.getDepartment();
        List<WebElement> departmentOptions = departmentDropdown.findElements(By.tagName("option"));

        if (department == null) {
            // Click on a random Department option
            randomOption = departmentOptions.get(random.nextInt(departmentOptions.size()));
            randomOption.click();

            employeeDetails.setDepartment(randomOption.getText());
        } else {
            for (WebElement option : departmentOptions) {
                if (option.getText().equals(department)) {
                    option.click();
                    break;
                }
            }
        }

        this.createButton.click();

        return employeeDetails;
    }
}

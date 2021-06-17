package tests;

import models.Employee;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import webpages.Employee.EmployeesPage;

public class EmployeeTest {

    private static ChromeDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setting up drivers");
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        driver = new ChromeDriver();
    }

    @AfterClass
    public static void teardown() {
        System.out.println("Cleaning up tests");

        driver.quit();
    }

    /**
       Test Case # 2
     * 1. Navigate to Employees Page
     * http://magenicautomation.azurewebsites.net/Employees
     * 2. Verify if the following employee to be added is in the list
     * First name: John
     * Last name: Doe
     * 3. If the employee exists, Delete the target employee
     * 4. Click “Create New”
     * 5. Enter Employee Details
     * First name: John
     * Last name: Doe
     * Address: [Any Value]
     * State: Select a random value from the dropdown
     * City: [Any Value]
     * Department: Quality Engineering
     * 6. Click “Create”
     * 7. Verify that the page redirects to /employees
     * 8. Verify that the newly created employee is in the list
     * 9. Delete the created employee
     * 10.Verify that the newly created employee is NOT in the list
     **/
}

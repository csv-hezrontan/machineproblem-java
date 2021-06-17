package tests;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.Department.CreateDepartmentPage;
import webpages.Department.DeleteDepartmentPage;
import webpages.Department.DepartmentsPage;

public class DepartmentTest {

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
 * Test Case # 1
 * 1. Navigate to Department Page
 * http://magenicautomation.azurewebsites.net/Departments
 * 2. Verify if the following department to be added is in the list
 * Magenic Manila Recruitment – [random number between 1 - 999]
 * 3. If the department exists, Delete the target department
 * 4. Click “Create New”
 * 5. Enter Department Details used in Step 2
 * 6. Click “Create”
 * 7. Verify that the page redirects to /departments
 * 8. Verify that the newly created department is in the list
 * 9. Delete the created department
 * 10. Verify that the newly created department is NOT in the list
*/


}

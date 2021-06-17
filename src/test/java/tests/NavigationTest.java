package tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webpages.Department.CreateDepartmentPage;
import webpages.Department.DepartmentsPage;

//Sample Test
public class NavigationTest {
    @Test
    public void startWebDriver(){

        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        DepartmentsPage departments = new DepartmentsPage(driver);
        departments.clickOnCreateNewDepartmentLink();

        CreateDepartmentPage createDepartment = new CreateDepartmentPage(driver);
        Assert.assertTrue(createDepartment.isPageOpened());

        driver.close();

    }
}

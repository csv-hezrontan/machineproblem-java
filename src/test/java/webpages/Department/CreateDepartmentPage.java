package webpages.Department;

import models.Department;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains the elements and actions that can be done on the Department Delete Page
 */
public class CreateDepartmentPage {
    private WebDriver driver;

    @FindBy(css = "body > div.container.body-content > h2")
    private WebElement heading;


    //Constructor
    public CreateDepartmentPage (WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    /**
     * Checks if the Department page is active by verifying if the created Department page header is present
     * @return true/false If the create Department page is opened or not
     */
    public boolean isPageOpened(){
        return heading.getText().contains("Create");
    }

    /**
     * Creates the Department by filling out the form with the data provided
     * @param departmentDetails Department details to enter in the form
     */
    public void create( Department departmentDetails ) {
        driver.findElement(By.id("DepartmentName")).sendKeys(departmentDetails.getName());
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}

package webpages.Department;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    //We will use this boolean for assertion. To check if page is opened
    public boolean isPageOpened(){
        return heading.getText().contains("Create");
    }

    public void create( String departmentName ) {
        driver.findElement(By.id("DepartmentName")).sendKeys(departmentName);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}

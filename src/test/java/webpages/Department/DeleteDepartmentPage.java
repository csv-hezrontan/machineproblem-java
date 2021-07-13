package webpages.Department;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains the elements and actions that can be done on the Department Delete Page
 */
public class DeleteDepartmentPage {
    private WebDriver driver;

    @FindBy(css = "body > div.container.body-content > h2")
    private WebElement heading;


    //Constructor
    public DeleteDepartmentPage (WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    //We will use this boolean for assertion. To check if page is opened
    public boolean isPageOpened(){
        return heading.getText().contains("Delete");
    }

    public void delete() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}

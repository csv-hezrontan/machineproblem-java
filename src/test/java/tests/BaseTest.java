package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.out.println("Setting up drivers");

        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.args", "--disable-logging"); // disables logging so only exceptions are shown
        System.setProperty("webdriver.chrome.silentOutput", "true"); // disables logging so only exceptions are shown

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown() {
        System.out.println("Cleaning up tests");

        driver.quit();
    }
}

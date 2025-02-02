package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SessionClassTest {
    WebDriver driver;


    @Test
    public void testDuckDuckGoTitle() {
        // Test steps
        // Navigation to the website
        driver.navigate().to("https://duckduckgo.com/");
        driver.manage().window().maximize();
        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "Google");
    }

    @BeforeClass
    public void setup() {
        // Setup
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        // Tear down
        driver.quit();
    }
}

package testPackage;

/*
________________ Basic ________________
●	Open Google Chrome
●	Navigate to [https://duckduckgo.com/]
●	Assert that the page title is [Google]
●	Close Google Chrome
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTask1 {

    WebDriver driver;

    @Test
    public void task1() {

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to URL
        driver.navigate().to("https://duckduckgo.com/");

        // Getting title
        String pageTitle = driver.getTitle();

        // Assert
        Assert.assertEquals(pageTitle, "Google", "Page title doesn't match expected title");
    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

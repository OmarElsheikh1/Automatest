package testPackage;

/*
________________ Basic ________________
●	Open Google Chrome
●	Navigate to [https://duckduckgo.com/]
●	Assert that the DuckDuckGo logo is displayed
●	Close Google Chrome
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestTask2 {

    WebDriver driver;

    @Test
    public void task2() {

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to URL
        driver.navigate().to("https://duckduckgo.com/");

        // Locate the DuckDuckGo logo
        By logo = By.xpath("//div[contains(@class, 'header_headerWrapMobile__hDkhc')]//a[@class = 'header_logoHorizontal__KABN4 header_logoText__d_X6V header_logoImg__85jCX']");
        boolean isLogoDisplayed = driver.findElement(logo).isDisplayed();

        // Assertion
        Assert.assertTrue(isLogoDisplayed, "DuckDuckGo's Logo isn't displayed");
    }

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {

        // Quit browser window
        driver.quit();
    }
}
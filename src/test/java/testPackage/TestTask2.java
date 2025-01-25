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

public class TestTask2 {

    WebDriver driver;

    @Test
    public void task2() {

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to URL
        driver.navigate().to("https://duckduckgo.com/");

        // Locate DuckDuckGo logo
        By duckDuckGoLogo = By.xpath("//div[@class = 'header_headerContent__hDivV']/section[@class = 'header_headerLeft__gTUAg header_headerSection__C99zW']//img");
        boolean isLogoDisplayed = driver.findElement(duckDuckGoLogo).isDisplayed();

        // Assert
        Assert.assertTrue(isLogoDisplayed, "DuckDuckGo's Logo isn't displayed");
    }

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {

        // Quit browser window
        // driver.quit();
    }
}

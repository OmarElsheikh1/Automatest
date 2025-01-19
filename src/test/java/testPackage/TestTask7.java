package testPackage;

/*
________________ Moderate ________________
●	Open Google Chrome
●	Navigate to [https://www.w3schools.com/html/html_tables.asp]
●	Assert that the Country for the Company [Ernst Handel] is [Austria]
●	Close Google Chrome
*/

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestTask7 {

    WebDriver driver;

    @Test
    public void task7() {

        // Navigate to URL
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");

        // Maximize window
        driver.manage().window().maximize();

        // Locate elements
        // By countryName = By.xpath("//table[@class = 'ws-table-all']//tr[4]/td[1]");
        By countryLocation = By.xpath("//tr[contains(., 'Ernst Handel')]/td[3]");
        String countryName = driver.findElement(countryLocation).getText();

        // Assertion
        Assert.assertEquals(countryName, "Austria");
    }

    @BeforeClass
    public void setup() {

        // Setup driver
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.enableBiDi();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(chromeOptions);

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterClass
    public void tearDown() {

        // close driver
        driver.quit();
    }
}
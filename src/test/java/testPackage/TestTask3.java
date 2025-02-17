package testPackage;

/*
________________ Basic ________________
●	Open Google Chrome
●	Navigate to [https://duckduckgo.com/]
●	Search for [Selenium WebDriver]
●	Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
●	Close Google Chrome
*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask3 {

    @Test
    public void task3() {
        // Initialize driver, open google chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to DuckDuckGo
            String url = "https://duckduckgo.com/";
            driver.navigate().to(url);

            // Maximize window
            driver.manage().window().maximize();

            // Find the search bar element
            WebElement searchBar = driver.findElement(By.xpath("//input[@name = 'q']"));
            // WebElement searchBar = driver.findElement(By.id("searchbox_input"));

            // Search for "Selenium WebDriver"
            searchBar.sendKeys("Selenium WebDriver");
            searchBar.submit();

            // Locate the first result and click on it
            // WebElement firstResult = driver.findElement(By.xpath("//div/a[@href='https://www.selenium.dev/documentation/webdriver/']"));
            WebElement firstResult = driver.findElement(By.linkText("WebDriver - Selenium"));
            firstResult.click();

            // Get the page's url
            String title = driver.getCurrentUrl();

            // Assert the Actual result with the Expected result
            Assert.assertEquals(title, "https://www.selenium.dev/documentation/webdriver/");

        } finally {
            // Close the browser after performing the test
            driver.quit();
        }
    }
}


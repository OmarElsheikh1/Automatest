package testPackage;

/*
________________ Moderate ________________
●	Open Mozilla Firefox
●	Navigate to [https://duckduckgo.com/]
●	Search for [TestNG]
●	Assert that the text of the fourth result is [TestNG Tutorial]
●	Close Mozilla Firefox
*/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask4 {
    @Test
    public void task4() {

        // Initialize driver, open google chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to DuckDuckGo
            String url = "https://duckduckgo.com/";
            driver.navigate().to(url);

            // Maximize window
            driver.manage().window().maximize();

            // Locate searchbar, used Basic Relative XPath by contains
            By searchBox = By.xpath("//input[contains(@type, 'text')]");

            // Sending keys
            driver.findElement(searchBox).sendKeys("TestNG", Keys.ENTER);

            // Get the location of result number
            By fourthSearchResult = By.xpath("(//li[@data-layout = 'organic'])[4]//a[@data-testid= 'result-title-a']");
            // Link 6
            // By fourthSearchResult = By.xpath("(//li[@data-layout = 'organic'])[4]//a[@data-testid = 'result-title-a']");

            //
            String fourthResultTitle = driver.findElement(fourthSearchResult).getDomAttribute("href");
            //System.out.println(fourthResultTitle);

            Assert.assertEquals(fourthResultTitle, "TestNG Tutorial");
        } finally {
            // Close the browser after performing the test
            // driver.quit();

            // Calling multi times isn't good for performance might get StaleElement
            String yes = driver.findElements(By.xpath("//li[@data-layout = 'organic']")).get(4).findElement(By.xpath("//a[@data-testid= 'result-title-a']")).getText();
        }
    }
}

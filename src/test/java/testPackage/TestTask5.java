package testPackage;

/*
________________ Moderate* ________________
●	Open Google Chrome
●	Navigate to [https://duckduckgo.com/]
●	Search for [Cucumber IO]
●	Navigate to the second results page
●	Assert that the link of the second result contains [https://www.linkedin.com]
●	Close Google Chrome
*/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTask5 {
    WebDriver driver;


    @Test
    public void task5() {

        // Navigate to the URL
        driver.navigate().to("https://duckduckgo.com/");
        driver.manage().window().maximize();

        // Locate searchbar, and search for "Cucumber IO"
        By searchBar = By.cssSelector("input.searchbox_input__bEGm3");
        driver.findElement(searchBar).sendKeys("Cucumber IO", Keys.ENTER);

        // Locate second search result and click it
        By secondResult = By.xpath("(//li[@data-layout = 'organic'])[2]//a[@data-testid = 'result-extras-url-link']");
        WebElement secondResultLink = driver.findElement(secondResult);

        String linkHref = secondResultLink.getDomAttribute("href");

        Assert.assertEquals(linkHref, "https://www.linkedin.com");
    }

    @BeforeClass
    public void setup() {

        // Initiate driver
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {

        // Quit driver
        driver.quit();
    }
}


//     Eng. Mohab Mohie
//WebDriver driver;
//Wait<WebDriver> wait;
//
//@Test
//public void testMethod() {
//    driver.navigate().to("https://duckduckgo.com/");
//
//    // identify search box
//    By searchInput = By.id("searchbox_input");
//    // type search query
//    driver.findElement(searchInput).sendKeys("TestNG" + Keys.ENTER);
//    // press enter
//
//    // Synchronization point
//
//    int targetSearchResult = 4;
//    By dynamicSearchResult = By.xpath("(//li[@data-layout='organic'])[" + targetSearchResult + "]//a[@data-testid='result-title-a']");
//
//    wait.until(d -> {
//        String searchResultTitle = driver.findElement(dynamicSearchResult).getText();
//        Assert.assertEquals(searchResultTitle, "TestNG Tutorial");
//        return true;
//    });
//
//}
//
//@BeforeClass
//public void setup() {
//    driver = new FirefoxDriver();
//    wait = new FluentWait<>(driver)
//            .withTimeout(Duration.ofSeconds(5))
//            .pollingEvery(Duration.ofMillis(300))
//            .ignoring(NotFoundException.class)
//            .ignoring(StaleElementReferenceException.class)
//            .ignoring(ElementNotInteractableException.class)
//            .ignoring(AssertionError.class)
//    ;
//
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    driver.manage().window().maximize();
//}
//
//@AfterClass
//public void tearDown() {
//    driver.quit();
//}
//
//}
package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {

    @Test
    public void test1() {

        // Set the system property for ChromeDriver
        // System.setProperty("WebDriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        //ChromeDriver driver = new ChromeDriver();

        try {

            // Navigate to specific URL
            String url = "https://duckduckgo.com/";
            driver.get(url);        // This opens the specified URL

            // Get the page title
            String pageTitle = driver.getTitle();

            // Assert that the page title is "Google"
            Assert.assertEquals(pageTitle, "Google", "The page title doesn't match the expected value!");

        } finally {
            // Close the browser after performing the test
            driver.quit();
        }
    }

    @Test
    public void test2() {

        // Set the system property for ChromeDriver
        // System.setProperty("WebDriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        try {

            // Navigate to specific URL
            String url = "https://duckduckgo.com/";
            driver.get(url);                                      // This opens the specified URL
            // driver.navigate().to("https://duckduckgo.com/");

            // Find the DuckDuckGo logo element (Assuming it's an <img> tag with a specific alt attribute)
            WebElement logo = driver.findElement(By.cssSelector("#__next > div > main > article > div.desktop-homepage_hero__Zoh95 > div.is-not-mobile-device > div.container_root__Lmrbx.container_responsive__IDWnv.container_fullWidth__0ZLFb > div > header > div > section.header_headerLeft__gTUAg.header_headerSection__C99zW > a > img"));

            // Assert that the page title is "Google"
            Assert.assertTrue(logo.isDisplayed(), "The DuckDuckGo logo is not displayed on the page!");

        } finally {
            // Close the browser after performing the test
            driver.quit();
        }
    }

    @Test
    public void test3() {

        WebDriver driver = new ChromeDriver();

        try {

            // Navigate to specific URL
            String url = "https://duckduckgo.com/";
            driver.navigate().to(url);

            // Maximize the WebPage for smoother look
            driver.manage().window().maximize();

            // Locate the search box, enter "Selenium WebDriver," and submit
            WebElement searchBar = driver.findElement(By.id("searchbox_input"));
            searchBar.sendKeys("Selenium WebDriver");
            searchBar.submit();


            WebElement firstResult = driver.findElement(By.cssSelector("h3"));
            Assert.assertEquals(firstResult, "https://www.selenium.dev/documentation/webdriver/");
            // firstResult.click();

        } finally {
            // Close the browser after performing the test
            driver.quit();
        }
    }

    @Test
    public void test4() {
        // Self training
        WebDriver driver = new ChromeDriver();

        try {

            // Navigate to specific URL
            driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

            // Maximize window
            driver.manage().window().maximize();

            // Retrieving page title
            String currentPageTitle = driver.getTitle();

            // Showing page title on the console
            System.out.println(currentPageTitle);

            // Asserting page title with "Web form"
            Assert.assertEquals(currentPageTitle, "Web form");

            // Implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

            // Find an element
            WebElement textBox = driver.findElement(By.name("my-text"));
            WebElement submitButton = driver.findElement(By.cssSelector("button"));

            // Take action on element
            textBox.sendKeys("Selenium");
            submitButton.click();

            // Request element information
            WebElement message = driver.findElement(By.id("message"));
            System.out.println(message.getText());

            // Assert the text
            Assert.assertEquals(message, "Received!");
        }
        finally {
            // Close the browser after performing the test
            // driver.quit();
        }
    }

    @Test
    public void test5() {
        // Task 3
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to specific URL
            driver.navigate().to("https://duckduckgo.com/");

            // Maximize window
            driver.manage().window().maximize();

            // Locate the search bar on the website, and write "Selenium WebDriver"
            WebElement searchBar = driver.findElement(By.id("searchbox_input"));
            searchBar.sendKeys("Selenium WebDriver");

            // Locate search button, and then click it
            WebElement searchIcon = driver.findElement(By.xpath("//button[@aria-label='Search']//*[name()='svg']"));
            searchIcon.click();

            WebElement searchResult = driver.findElement(By.xpath("//span[normalize-space()='WebDriver - Selenium']"));
            searchResult.click();

            String url = driver.getCurrentUrl();

            Assert.assertEquals(url, "https://www.selenium.dev/documentation/webdriver/");
        }
        finally {
            // Close the browser after performing the test
            driver.quit();
        }
    }
}
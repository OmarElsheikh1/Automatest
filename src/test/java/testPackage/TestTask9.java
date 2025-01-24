package testPackage;

/*
________________ Moderate ________________
●	Open Google Chrome
●	Navigate to [https://jqueryui.com/resources/demos/droppable/default.html]
●	Drag [Drag me to my target] and drop it on [Drop here]
●	Assert that the text has been changed to [Dropped!]
●	Close Google Chrome
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTask9 {

    WebDriver driver;

    @Test
    public void task9() {

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to specific URL
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");

        // Drag and Drop on element
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();

        // dragAndDropBy
//        new Actions(driver)
//                .dragAndDropBy(draggable, 162, 27).perform();

        // Assertion
        Assert.assertEquals(driver.findElement(By.id("droppable")).getText(), "Dropped!");

    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        // driver.quit();
    }
}
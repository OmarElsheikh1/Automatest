package testPackage;

/*
________________ Basic ________________
●	Open Google Chrome
●	Navigate to [http://the-internet.herokuapp.com/checkboxes]
●	Check Checkbox 1
●	Assert that both Checkboxes are checked
●	Close Google Chrome
* */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTask6 {

    WebDriver driver;

    @Test
    public void task6() {

        // Navigate to URL
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");

        // Maximize window
        driver.manage().window().maximize();


        // Locate checkboxes
        By checkBox1 = By.xpath("//form[@id = 'checkboxes']/child::input[1]");
        driver.findElement(checkBox1);
        By checkBox2 = By.xpath("//form[@id = 'checkboxes']/child::input[2]");
        driver.findElement(checkBox2);

        // Check the 1st checkbox
        driver.findElement(checkBox1).click();

        boolean isCheckBox1Selected = driver.findElement(checkBox1).isSelected();
        boolean isCheckBox2Selected = driver.findElement(checkBox1).isSelected();


        Assert.assertTrue(isCheckBox1Selected, "CheckBox 1 is selected");
        Assert.assertTrue(isCheckBox2Selected, "CheckBox 2 is selected");
    }

    @BeforeClass
    public void setup() {

        // Setup driver
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {

        // close driver
        driver.quit();
    }
}

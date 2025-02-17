package testPackage;

/*
________________ Moderate ________________
●	Open Google Chrome
●	Navigate to [http://the-internet.herokuapp.com/upload]
●	Upload a small image file
●	Assert that the file was uploaded successfully
●	Close Google Chrome
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTask8 {
    WebDriver driver;

    @Test
    public void task8() {
        // Navigate to URL
        driver.navigate().to("http://the-internet.herokuapp.com/upload");

        // Maximize window
        driver.manage().window().maximize();

        // Path to image
        String filePath = "D:\\Omar\\ITI current\\ITI\\Software Testing\\Test Automation\\Mohab Mohie - Leveling Up\\image (3).jpg";

        // Locate the "Choose File" input element, and send the chosen file path
        By chooseFileButton = By.id("file-upload");
        driver.findElement(chooseFileButton).sendKeys(filePath);

        // Click the "Upload" button
        By uploadButton = By.id("file-submit");
        driver.findElement(uploadButton).click();

        // Assert that the file was uploaded successfully after locating the message
        By uploadedFile = By.xpath("//h3[contains(.,'File Uploaded!')]");
        boolean isFileUploadMessageDisplayed = driver.findElement(uploadedFile).isDisplayed();
        Assert.assertTrue(isFileUploadMessageDisplayed, "File was uploaded successfully");
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
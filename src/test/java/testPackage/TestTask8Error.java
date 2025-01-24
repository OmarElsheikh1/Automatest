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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestTask8Error {

    WebDriver driver;

    // Explicit
    // Wait<WebDriver> wait;

    WebDriverWait myWait;

    @Test
    public void task8() {

        // Navigate to URL
        driver.navigate().to("http://the-internet.herokuapp.com/upload");

        // Maximize window
        driver.manage().window().maximize();

        // Path to image
        String filePath = "D:\\Omar\\ITI current\\ITI\\Software Testing\\Test Automation\\Mohab Mohie - Leveling Up\\image.jpg";


        // Locate the "Choose File" input element, and send the chosen file path
        By chooseFileButton = By.id("file-upload");
        driver.findElement(chooseFileButton).sendKeys(filePath);

        // Click the "Upload" button
        By uploadButton = By.id("file-submit");
        driver.findElement(uploadButton).click();

        // Explicit
        // wait.until(d -> isSuccessMessageDisplayed);

        // Pavan explicit wait
        // boolean isMessageDisplayed = myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() = 'File Uploaded!']"))).isDisplayed();

        // Lambda attempt
        boolean isMessageDisplayed = myWait.until(d -> driver.findElement(By.xpath("//h3[text() = 'File Uploaded!']"))).isDisplayed();

        // Locate success message
        //By successMessage = By.xpath("//h3[text() = 'File Uploaded!']");
        //boolean isSuccessMessageDisplayed = driver.findElement(successMessage).isDisplayed();



        // Assertion
        //Assert.assertTrue(isSuccessMessageDisplayed, "File upload isn't successful");

        // Pavan
        Assert.assertTrue(isMessageDisplayed, "Message didn't appear");
    }

    @BeforeClass
    public void setup() {

        // Setup driver
        driver = new ChromeDriver();

        // Implicit wait
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Explicit wait
        //wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Pavavn
         myWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterClass
    public void tearDown() {

        // close driver
        // driver.quit();
    }
}
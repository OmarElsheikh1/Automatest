package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CosmoCodeDemoTest {

    WebDriver driver;
    String countryName = "Albania";

    @Test
    public void cosmoCode() {

        // Maximize window
        driver.manage().window().maximize();

        // Navigate to URL
        driver.navigate().to("https://cosmocode.io/automation-practice-webtable/");

        By countryCheckBox = By.xpath("//td[. = '" + countryName + "']/parent::tr//input");
        driver.findElement(countryCheckBox).click();
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
package testPackage;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {
    WebDriver driver;

    @Test
    public void mm() {

    }


    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
    }


    @AfterClass
    public void nn() {

    }
}

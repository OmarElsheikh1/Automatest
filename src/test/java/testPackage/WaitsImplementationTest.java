package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsImplementationTest {


    @Test
    public void controlTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        By revealANewOutput = By.id("reveal");
        driver.findElement(revealANewOutput).click();

        By outputTextBox = By.id("revealed");
        // Question
        driver.findElement(outputTextBox).sendKeys("test");

        driver.quit();
    }

    @Test
    public void implicitWait() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("reveal")).click();

        driver.findElement(By.id("revealed")).sendKeys("test");

        driver.quit();
    }

    @Test
    public void explicitWaitTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("reveal")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Question
        wait.until(d -> {
            d.findElement(By.id("revealed")).sendKeys("test");
            return true;
        });

        driver.quit();
    }

    @Test
    public void explicitFluentWaitTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("reveal")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

        wait.until(d -> {
            d.findElement(By.id("revealed")).sendKeys("test");
            return true;
        });

        driver.quit();
    }

    @Test
    public void customExplicitFluentWaitTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.findElement(By.id("reveal")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(d ->
        {
            d.findElement(By.id("revealed")).sendKeys("test");
            return true;
        });

        driver.quit();
    }
}
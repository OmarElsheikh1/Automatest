import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {

    }

    // Method to navigate to DuckDuckGo
    public void navigateToHomePage() {
        driver.navigate().to("https://duckduckgo.com/");
    }

    // Method to get the page title
    public String getPageTitle() {
        return driver.getTitle();
    }

}

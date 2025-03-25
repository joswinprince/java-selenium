package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
interface calc {
    int add(int a, int b);
}

public class GoogleTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
           // Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Use "--headless" for older versions
        options.addArguments("--disable-gpu"); // Recommended to avoid rendering issues
        options.addArguments("--window-size=1920,1080"); // Set screen size
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);

      
    }

    @Test
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"), "Title does not match!");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

  
}
 

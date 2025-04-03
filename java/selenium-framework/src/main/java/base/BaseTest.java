package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");   
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
 
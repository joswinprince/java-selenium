package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    ChromeOptions options;
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\chromedriver\\chromedriver-win64\\chromedriver.exe");   
        
        options = new ChromeOptions();
        options.setBinary(System.getProperty("user.home")+"\\chromedriver\\chrome-win64\\chrome.exe");
        options.addArguments("--headless=new"); // Use headless mode if needed

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

     
    }

    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
 
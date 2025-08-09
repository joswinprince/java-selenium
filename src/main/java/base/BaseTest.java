package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.time.Duration;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class BaseTest {
    protected static WebDriver driver;
    ChromeOptions options;
    Path userDataDir;
    public void setup() throws Exception {
        // System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\chromedriver\\chromedriver-win64\\chromedriver.exe");   
        // System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // Create a temporary unique directory for user data:
        try {
            userDataDir = Files.createTempDirectory("chrome-user-data");
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        options = new ChromeOptions();
        // options.setBinary(System.getProperty("user.home")+"\\chromedriver\\chrome-win64\\chrome.exe");
        
        // options.setBinary("/usr/bin/google-chrome");
        // Set unique user data dir to avoid session conflicts
        options.addArguments("--user-data-dir=" + userDataDir.toAbsolutePath().toString());
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
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
 
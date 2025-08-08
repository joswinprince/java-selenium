package tests;

import java.io.ObjectInputFilter.Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GooglePage;
import utils.ConfigReader;
interface calc {
    int add(int a, int b);
}

public class GoogleTest extends BaseTest {
    private GooglePage googlePage;
    private ConfigReader configReader;
    @BeforeMethod
    public void setUpTest() throws Exception {
        setup();
        googlePage = new GooglePage(driver);
        configReader = new ConfigReader();
    }
    
    @Test
    public void testGoogleTitle() {
        driver.get(configReader.getProperty("googleUrl"));
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
 

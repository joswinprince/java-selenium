package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private ConfigReader configReader;

    @BeforeMethod
    public void setUpTest() {
        setup();
        loginPage = new LoginPage(driver);
        configReader = new ConfigReader();
        driver.get(configReader.getProperty("baseUrl"));
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("testUser");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        Assert.assertEquals(driver.getTitle(), "Dashboard");
    }

    @AfterMethod
    public void tearDownTest() {
        teardown();
    }
}
 LoginTest {
    
}

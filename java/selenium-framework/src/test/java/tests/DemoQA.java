package tests;

import base.BaseTest;
import pages.DemoQAElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class DemoQA extends BaseTest {
    private DemoQAElement demoQAElement;
    private ConfigReader configReader;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeMethod
    public void setUpTest() {
        setup();
        demoQAElement = new DemoQAElement(driver);
        configReader = new ConfigReader();
        driver.get(configReader.getProperty("baseUrl"));
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        // loginPage.enterUsername("testUser");
        // loginPage.enterPassword("password123");
        // loginPage.clickLogin();
        System.out.println("Configuration ");
        System.out.println(configReader.getProperty("demoQAElement"));
        String []deomoQAElements = configReader.getProperty("demoqaallElement").split(",");
        // for (String element : deomoQAElements) {
        //     System.out.println("Element: " + element);
        //     String format = String.format(configReader.getProperty("demoQAElement"),element);
        //     demoQAElement.selectElement(format);
        // }

        Assert.assertEquals(driver.getTitle(), "Example Domain");
        demoQAElement.openDemoQA();
        demoQAElement.selectTextBox();
        demoQAElement.selectElement(configReader.getProperty("demoQAElement"));
        Thread.sleep(3000);
        WebElement eleme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("null")));
    }

    @AfterMethod
    public void tearDownTest() {
        teardown();
    }
}


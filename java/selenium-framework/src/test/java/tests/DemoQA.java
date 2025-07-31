package tests;

import base.BaseTest;
import pages.DemoQAPage;

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
    private DemoQAPage DemoQAPage;
    private ConfigReader configReader;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeMethod
    public void setUpTest() {
        setup();
        DemoQAPage = new DemoQAPage(driver);
        configReader = new ConfigReader();
        driver.get(configReader.getProperty("baseUrl"));
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        // loginPage.enterUsername("testUser");
        // loginPage.enterPassword("password123");
        // loginPage.clickLogin();
        System.out.println("Configuration ");
        System.out.println(configReader.getProperty("DemoQAPage"));
        String []deomoQAElements = configReader.getProperty("demoqaallElement").split(",");
        // for (String element : deomoQAElements) {
        //     System.out.println("Element: " + element);
        //     String format = String.format(configReader.getProperty("DemoQAPage"),element);
        //     DemoQAPage.selectElement(format);
        // }

        Assert.assertEquals(driver.getTitle(), "Example Domain");
        DemoQAPage.openDemoQA();
        DemoQAPage.selectTextBox();
        DemoQAPage.selectElement(configReader.getProperty("DemoQAPage"));
        Thread.sleep(3000);
        WebElement eleme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("null")));
    }

    @AfterMethod
    public void tearDownTest() {
        teardown();
    }
}


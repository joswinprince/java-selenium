package tests;

import base.BaseTest;
import pages.DemoQAPage;

import java.io.File;
import java.time.Duration;

import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import io.qameta.allure.*;

@Epic("DemoQA Feature")
@Feature("DemoQA Functionality")
public class DemoQaTest extends BaseTest {
    private DemoQAPage DemoQAPage;
    private ConfigReader configReader;
    

    @BeforeMethod
    public void setUpTest() throws Exception {
        setup();
        DemoQAPage = new DemoQAPage(driver);
        configReader = new ConfigReader();
        // driver.get(configReader.getProperty("baseUrl"));
    }

    @Test
    @Story("Dashboard Demo QA")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User logs in using valid credentials")
    public void testValidLogin() throws Exception {
        // loginPage.enterUsername("testUser");
        // loginPage.enterPassword("password123");
        // loginPage.clickLogin();
        DemoQAPage.openDemo(configReader.getProperty("DemoQAPage"));
        System.out.println("Configuration ");
        System.out.println(configReader.getProperty("DemoQAPage"));
        String []deomoQAElements = configReader.getProperty("demoqaallElement").split(",");
        // for (String element : deomoQAElements) {
        //     System.out.println("Element: " + element);
        //     String format = String.format(configReader.getProperty("DemoQAPage"),element);
        //     DemoQAPage.selectElement(format);
        // }

        try {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("screenshot.png"), false);
            System.out.println("********************8");
            System.out.println(src.getAbsolutePath());
        }
         catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

       }

    @AfterMethod
    public void tearDownTest() {
        teardown();
    }
}


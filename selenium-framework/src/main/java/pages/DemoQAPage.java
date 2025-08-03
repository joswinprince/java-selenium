package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQAPage {
    
    private WebDriver driver;
    public DemoQAPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openDemoQA() {
        driver.get("https://demoqa.com/elements");
    }
    public void openGoogle() {
        driver.get("https://www.google.com");
       
    }
    public void selectTextBox() {
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
    }
    
    public void selectElement(String element) {
        driver.findElement(By.xpath(element)).click();

    }
}

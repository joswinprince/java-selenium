package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQAPage {
    
    private WebDriver driver;
    public DemoQAPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openDemoQA() throws Exception {
    }
    public void openDemo(String url) throws Exception{

        driver.get(url);
        driver.findElement(By.xpath("//*[@id='username']")).click();
        
    }
       

    public void selectTextBox() {
        driver.findElement(By.xpath("//span[text()='Text Box']")).click();
    }
    
    public void selectElement(String element) {
        driver.findElement(By.xpath(element)).click();

    }
}

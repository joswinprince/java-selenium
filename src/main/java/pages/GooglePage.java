package pages;

import org.openqa.selenium.WebDriver;

public class GooglePage {
    
        private WebDriver driver;

        public GooglePage(WebDriver driver) {
            this.driver = driver;
        }
         public void openpage() {
        driver.get("https://google.com");
    }

}

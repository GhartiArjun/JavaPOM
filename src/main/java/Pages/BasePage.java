package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import setup.Utils;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver ,this);

    }
    public void launchApplication(String url){
        driver.get(url);
    }
    public void closeBrowser(){
        driver.close();
    }

}

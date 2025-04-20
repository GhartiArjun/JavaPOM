package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver ,this);

    }
    @FindBy(xpath = "//img[@alt='profile picture']")
    WebElement userIconElement;

    public boolean verifyIfUserIconIsDisplayed(){
        return userIconElement.isDisplayed();

    }
}

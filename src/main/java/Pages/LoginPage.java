package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver ,this);
    }
    @FindBy(name ="username")
    WebElement usernameElement;

    @FindBy(name="password")
    WebElement passwordElement;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginElement;

    public void setUsernameElement(String userName){
        usernameElement.sendKeys(userName);
    }
    public void setPasswordElement(String pwd ){
        passwordElement.sendKeys(pwd);
    }
    public void clickOnLoginButton(){
        loginElement.click();
    }
}

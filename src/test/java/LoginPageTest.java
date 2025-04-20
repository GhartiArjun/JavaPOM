import Pages.BasePage;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.LoginPage;
import setup.DriverFactory;
import setup.Utils;

public class LoginPageTest {
    WebDriver driver;
    BasePage basepage;
    LoginPage loginPage;
    HomePage homePage;


    @BeforeClass()
    public void tearUp(){
        driver = DriverFactory.getDriver(Utils.getProperties("browser"));
        basepage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        basepage.launchApplication(Utils.getProperties("url"));

    }
    @Test()
    public void loginPageTestWithValidCredential(){
        loginPage.setUsernameElement(Utils.getProperties("username"));
        loginPage.setPasswordElement(Utils.getProperties("password"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.verifyIfUserIconIsDisplayed());
    }
    @AfterClass()
    public void tearDown(){
        basepage.closeBrowser();
    }
}

package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    static WebDriver driver;
    static Properties prop;
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/sumanarai/Documents/JavaPOM/src" +
                    "/main/java/Setup/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialization(String browsername){
        if(browsername.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver();
            driver= new FirefoxDriver();
        }else if (browsername.equalsIgnoreCase("egde")) {
            WebDriverManager.edgedriver();
            driver= new EdgeDriver();
        }else if (browsername.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver();
            driver= new SafariDriver();
        }else{
            System.out.println("spelling mistake");
        }



    }
}


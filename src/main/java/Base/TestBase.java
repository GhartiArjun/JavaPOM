package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static void pauseExecutionForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties loadProperties() {
        Properties property = new Properties();
        //System.getProperty("user.dir");
        String propertyFilePath = "/Users/sumanarai/Documents/JavaPOM/src/main/java" +
                "/Setup/config.properties";
        try (FileInputStream input = new FileInputStream(propertyFilePath)) {
            property.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }


    public static String getProperties(String propertyName) {
        return loadProperties().getProperty(propertyName).trim();
    }

    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver();
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver();
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid Browser Name");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }
}
package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){

    }

    private static WebDriver driver;

    public static WebDriver getReference() {
        return driver;
    }

    public static WebDriver getDriver() {
        if(driver == null) {
            switch (Config.getProperty("browser")) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
            }
//            driver.manage().window().maximize();
              driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        }
        return driver;
    }

    public static void closeDriver() {
        if(driver !=null){
            driver.quit();
            driver = null;
        }
    }

}

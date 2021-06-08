package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    //Start Application

    public static WebDriver startApplication(WebDriver driver, String browserName, String AppURL){

        //Chrome
        if(browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
        }

        else if(browserName.equals("firefox")){

            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(AppURL);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return driver;
    }

    // close Bowser

    public  static void quitBrowser(WebDriver driver){
       // driver.quit();
    }
}

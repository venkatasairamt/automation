package Timedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Implicitwait {
    @Test
    public void implecitwait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //No such element exception

    }
}

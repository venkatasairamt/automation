package ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Sceenshots {

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("");

        TakesScreenshot ts= (TakesScreenshot)driver;
        File src =ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("./cap.png"));
        driver.quit();
    }
}

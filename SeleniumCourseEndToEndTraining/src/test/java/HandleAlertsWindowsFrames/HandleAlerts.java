package HandleAlertsWindowsFrames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandleAlerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://ksrtc.in/oprs-web/");

        driver.findElement(By.xpath("//button[normalize-space()='Search for Bus']")).click();

        Alert alert =driver.switchTo().alert();
        String alertTxt =alert.getText();
        System.out.println(alertTxt);
        alert.accept();
        driver.quit();


    }
}

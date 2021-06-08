package PageTitleErrorMessages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class VerifyErrmsgGetattributeInnerhtml {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();

        String actuvalErr =driver.findElement(By.xpath("//div[@class='o6cuMc']")).getAttribute("innerHTML");
        System.out.println(actuvalErr);
        String expectedErr = "please enter email";
        Assert.assertEquals(actuvalErr,expectedErr);
    }
}

package HandleAlertsWindowsFrames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleFrames {

    // 3 ways a) name or id b) index c) web element



    @Test
    public void byid(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("");

        driver.switchTo().frame("id");

        driver.findElement(By.xpath("")).click();

        //Switch to parent window
        driver.switchTo().defaultContent();

    }

    @Test
    public void byindex(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("");
      int totalnoofframes =  driver.findElements(By.tagName("iframe")).size();
        System.out.println(totalnoofframes);

        driver.switchTo().frame(0);

        driver.findElement(By.xpath("")).click();

        //Switch to parent window
        driver.switchTo().defaultContent();

    }

    @Test
    public void byElement(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("");
        WebElement element =  driver.findElement(By.xpath(""));


        driver.switchTo().frame(element);

        driver.findElement(By.xpath("")).click();

        //Switch to parent window
        driver.switchTo().defaultContent();

    }
}

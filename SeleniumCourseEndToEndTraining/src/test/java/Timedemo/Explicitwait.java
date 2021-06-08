package Timedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Explicitwait {

    @Test
    public void explicitwait(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        driver.findElement(By.xpath("//button[normalize-space()='Click me to start timer']")).click();

        WebDriverWait wait = new WebDriverWait(driver,5);
       WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

       boolean status = element.isDisplayed();

       if(status){
           System.out.println("element is displayed");
       } else{
           System.out.println("element not dispalyed");
       }


    }
}

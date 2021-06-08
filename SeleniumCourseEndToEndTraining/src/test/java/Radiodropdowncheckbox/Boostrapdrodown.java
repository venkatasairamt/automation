package Radiodropdowncheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Boostrapdrodown {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");

        driver.findElement(By.xpath("//button[@id='menu1']")).click();

        List<WebElement> ddvalues = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));

        for(WebElement ele : ddvalues){

            String ddvaluetext = ele.getText();

            if(ddvaluetext.equalsIgnoreCase("JavaScript")){
                ele.click();
                break;

            }

        }

    }
}

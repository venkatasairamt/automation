package Radiodropdowncheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleCheckBoxes {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");

       List<WebElement> checkbox = driver.findElements(By.xpath("//input[@name='lang' and @type='checkbox']"));

       for(int i=0; i<checkbox.size();i++){

         WebElement localcheckbox =  checkbox.get(i);

         String checkboxtxt =localcheckbox.getAttribute("id");
         if(checkboxtxt.equalsIgnoreCase("code")){
             localcheckbox.click();
             break;
         }
       }
    }
}

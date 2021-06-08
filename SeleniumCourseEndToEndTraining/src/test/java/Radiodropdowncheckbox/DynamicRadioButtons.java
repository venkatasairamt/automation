package Radiodropdowncheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicRadioButtons {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // open url
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");

        List<WebElement> radio =  driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));

        for(int i=0; i<radio.size();i++){

            WebElement localRadio = radio.get(i);
           String value = localRadio.getAttribute("value");

           if(value.equalsIgnoreCase("ruby")){
               localRadio.click();
           }
        }


        //driver.quit();
    }
}

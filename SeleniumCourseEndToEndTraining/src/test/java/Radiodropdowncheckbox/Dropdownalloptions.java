package Radiodropdowncheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdownalloptions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[normalize-space()='Create New Account']")).click();
        WebElement monthdropdown = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Thread.sleep(3000);

        Select month = new Select(monthdropdown);

        List<WebElement> alloptions =  month.getOptions();
        int totalnumberofoptions = alloptions.size();

        for(WebElement ele : alloptions){
            String monthname= ele.getText();


        }


    }
}

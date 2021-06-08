package Radiodropdowncheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DroDown {
    //Select values
    //Get selected values
    //Get all selected va;lues
    //Get all values from drop down
    public void selectdrodownvalues() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[normalize-space()='Create New Account']")).click();

        driver.findElement(By.name("firstname")).sendKeys("dvvcsvcfvaschb");

       WebElement monthdropdown = driver.findElement(By.xpath("//select[@name='birthday_month']"));
       Thread.sleep(3000);

       Select month = new Select(monthdropdown);
       month.selectByVisibleText("Jan");

       //Get selected drop down value
        WebElement selectedOption = month.getFirstSelectedOption();
        String selectedoptionTxt = selectedOption.getText();


    }


    public static void main(String[] args) throws InterruptedException {
        DroDown droDown = new DroDown();
        droDown.selectdrodownvalues();



    }
}

package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

    @Test
    public void drapanddropa(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("");

        Actions actions = new Actions(driver);

        WebElement src = driver.findElement(By.xpath(""));

        WebElement target = driver.findElement(By.xpath(""));

        actions.clickAndHold(src).moveToElement(target).build().perform();
    }
}

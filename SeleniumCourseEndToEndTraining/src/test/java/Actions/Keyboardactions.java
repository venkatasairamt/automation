package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Keyboardactions {
    @Test
    public void enterkeys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("");

        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("")).sendKeys("wqdwadf");

        actions.sendKeys(Keys.TAB)
                .pause(Duration.ofSeconds(1))
                .sendKeys("web").build().perform();
    }
}

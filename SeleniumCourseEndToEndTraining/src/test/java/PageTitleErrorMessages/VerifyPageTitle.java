package PageTitleErrorMessages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifyPageTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("");
        String pagetitle = driver.getTitle();
        Assert.assertEquals(pagetitle,"software");

        Assert.assertTrue(pagetitle.contains("software"));
    }
}

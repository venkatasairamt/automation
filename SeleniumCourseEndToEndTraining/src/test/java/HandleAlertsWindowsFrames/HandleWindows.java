package HandleAlertsWindowsFrames;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class HandleWindows {

    // getwindowhandle and getwindowhandles

    @Test
    public void windowhandle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com/");

        String parentWindow= driver.getWindowHandle();

        System.out.println("parent window id = "+ parentWindow);

       Set<String> allWindowhandles = driver.getWindowHandles();

        ArrayList<String> tab = new ArrayList<>(allWindowhandles);
        driver.switchTo().window(tab.get(2));
        driver.close();

        driver.switchTo().window(tab.get(0));
        System.out.println("title of parent window is "+ driver.getTitle());



    }
}

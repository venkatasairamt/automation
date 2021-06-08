package Radiodropdowncheckbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.FixedValue;
import org.apache.hc.core5.util.Asserts;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VerifyDropdownValesorder {

    @Test
    public void verifydropdownassendingordesending() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");

        Select select = new Select(driver.findElement(By.id("tools")));

        List actuvallist = new ArrayList();

        List<WebElement> dropdownvalues =select.getOptions();

        for(WebElement ele : dropdownvalues){

            String ddval =ele.getText();
            actuvallist.add(ddval);


        }

        List temp = new ArrayList();

        temp.addAll(actuvallist);

        //Asending

        Collections.sort(temp);
        //do asertion

        // desending
        Collections.sort(temp,Collections.reverseOrder());
        //do assertion


    }
}

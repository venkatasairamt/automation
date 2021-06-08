package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {
    public WebDriver driver;

    // create a constroctur for initilise  driver

    public Loginpage(WebDriver ldriver){
        this.driver = ldriver;
    }

    // By using Object repositary locate elements

    @FindBy(xpath="//input[@id='txtUsername']") WebElement uname;
    @FindBy(xpath = "//input[@id='txtPassword']") WebElement pass;
    @FindBy(xpath = "//input[@id='btnLogin']") WebElement loginbutton;


    // create a Loginmethod

    public  void loginToCRM(String applicationUsername, String applicationPassword){
        uname.sendKeys(applicationUsername);
        pass.sendKeys(applicationPassword);
        loginbutton.click();

    }




}

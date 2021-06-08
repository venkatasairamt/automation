package Pages;


import Utility.ReuseMethos;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    public WebDriver driver;

    // create a constroctur for initilise  driver

    public  HomePage(WebDriver ldriver){
        this.driver = ldriver;
    }

    @FindBy(xpath = "//b[normalize-space()='Admin']")
    WebElement admin;
    @FindBy(xpath = "//a[normalize-space()='User Management']") WebElement usermanagement;
    @FindBy(xpath = "//a[normalize-space()='Users']") WebElement user;

    public void clickOnAdmin(){
        ReuseMethos.mouseHover(driver, admin);
        ReuseMethos.click(driver,admin);
    }

    public void clickonUser() {
        ReuseMethos.mouseHover(driver, admin);
        ReuseMethos.mouseHover(driver, usermanagement);
        ReuseMethos.mouseHover(driver, user);
        ReuseMethos.click(driver,user);
    }






}

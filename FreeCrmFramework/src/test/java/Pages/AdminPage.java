package Pages;
import Utility.ReuseMethos;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AdminPage {
    public WebDriver driver;

    // create a constroctur for initilise  driver

    public AdminPage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    @FindBy(xpath = "//input[@id='searchSystemUser_userName']")
    WebElement usernameTextbox;
    @FindBy(xpath = "//select[@id='searchSystemUser_userType']")
    WebElement userRoledropdown;
    @FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
    WebElement employernametextbox;
    @FindBy(xpath = "//select[@id='searchSystemUser_status']")
    WebElement statusDropdown;
    @FindBy(xpath = "//input[@id='searchBtn']")
    WebElement searchbutton;

    public void search(WebDriver driver,String username, int userrole, String employename, int status){
        ReuseMethos.enterTextInTextbox(driver,usernameTextbox, username);
        ReuseMethos.dropdownselectByIndex(driver,userRoledropdown,userrole);
        ReuseMethos.enterTextInTextbox(driver,employernametextbox,employename);
        ReuseMethos.dropdownselectByIndex(driver,statusDropdown,status);
        ReuseMethos.click(driver,searchbutton);

    }











}

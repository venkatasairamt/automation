package TestCases;
import Pages.Loginpage;
import TestCases.LoginTestCRM;
import Pages.BaseClass;
import Pages.HomePage;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomepageTestCase extends BaseClass {

    @Test(priority = 0)
    public   void loginCrm() throws InterruptedException {
        logger = report.createTest("logincrm");
        Loginpage loginPage = PageFactory.initElements(driver,Loginpage.class);
        loginPage.loginToCRM(excel.getStringData(0,0,0), excel.getStringData(0,0,1));
    }


    @Test(priority = 1)
    public void clickOnAdmin() throws InterruptedException {


        logger = report.createTest("Homepage");
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnAdmin();




    }
}

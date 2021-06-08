package TestCases;

import Pages.BaseClass;
import Pages.Loginpage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCRM extends BaseClass {
    Loginpage loginPage;
    @Test
    public   void loginCrm() throws InterruptedException {
       // logger = report.createTest("logincrm");
        System.out.println("hi");
        loginPage = PageFactory.initElements(driver,Loginpage.class);
        System.out.println("hi");
        loginPage.loginToCRM(excel.getStringData(0,0,0), excel.getStringData(0,0,1));
        System.out.println("hi");


    }
}

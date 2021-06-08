package TestCases;

import Pages.AdminPage;
import Pages.BaseClass;
import Pages.HomePage;
import Pages.Loginpage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AdminTestcases extends BaseClass {

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

    @Test(priority = 2 )
    public void search(){
        logger = report.createTest("Admin Test cases");
        AdminPage adminPage = PageFactory.initElements(driver,AdminPage.class);
        adminPage.search(driver,"Aatmaram",0,"Alice Duval",0);


    }
}

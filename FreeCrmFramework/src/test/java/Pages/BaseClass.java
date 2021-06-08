package Pages;

import Utility.BrowserFactory;
import Utility.ConfigDataProvider;
import Utility.ExcelDataProvider;

import Utility.ReuseMethos;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class BaseClass {
    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;
    public ExtentReports report;
    public ExtentTest logger;


    //create lanch

    @BeforeClass
    public  void setUp(){
        driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getStringUrl());


    }
    @Test
    public void m1(){
        System.out.println("hi");
    }

    // create close browser
    @AfterClass
    public void tearDown(){
        BrowserFactory.quitBrowser(driver);
    }

    @BeforeSuite
    public void setuPSuite()
    {
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();
        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/freecrm.html"));

        report = new ExtentReports();
        report.attachReporter(extent);
    }

    @AfterMethod
    public void atFailurescreenshots(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            ReuseMethos.captureScreenshot(driver);

        }

        report.flush();

    }

}

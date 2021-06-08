package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReuseMethos {

    /*
     List of methods
     enterTextInTextbox
     captureScreenshot
     mouseHover
     click
     checkboxSelected
     radioButtonselect
     dropdownselectByIndex
     dropdownselectByValue
     dropdownselectByVisibleText
     selectByMultipleValuesDropdown
     handledJSaAlert
     handleFileUpload
     drapAndDrop
      explicitWait
      handleBrowserPopUpWindows
      handleBootstrapDropDown
      enterDateWithJSE

     */

    /*
    Start create a helper method for textbox
    */

    public static void enterTextInTextbox(WebDriver driver, WebElement element, String txt){
        element.sendKeys(txt);
    }
    /*
     End create a helper method for textbox
     */

    /*
     Start create a capture screenshot method

     */
    public static void captureScreenshot(WebDriver driver) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File("./Screenshots/Login.png"));
        } catch (Exception e) {
            System.out.println("unable to capture screenshot" + e.getMessage());
        }
    }
    /*
     End create a capture screenshot method
     */

    /*
    Start Mouse Hover
     */
    public static void mouseHover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

    }
    /*
    End Mouse Hover
     */

    /*
    Start click
     */
    public static void click(WebDriver driver, WebElement element) {
        element.click();

    }
    /*
    End Click
     */

    /*
    Start checkbox Selected  method
     */
    public static void checkboxSelected(WebDriver driver,WebElement element){

        //Is dispalyed or not
        boolean checkboxisdisplayedstatus = element.isDisplayed();
        boolean checkboxisenabledstatus=element.isEnabled();
        boolean checkboxisselctedstatus = element.isSelected();


        if(checkboxisdisplayedstatus == true && checkboxisenabledstatus == true && checkboxisselctedstatus ==false){
            element.click();

        }
        else{
            System.out.println("Checkbox  not selcted");
        }

    }
/*
End checkbox Selected  method
 */

    /*
    Start Radio button selected method
     */
    public static  void radioButtonselect(WebDriver driver,WebElement element){
       boolean radiobuttonDispalyedStatus= element.isDisplayed();
       boolean radiobuttonEnabledStatus = element.isEnabled();
      boolean radiobuttonSelectedStatus= element.isSelected();
        if(radiobuttonDispalyedStatus == true && radiobuttonEnabledStatus == true && radiobuttonSelectedStatus ==false){
            element.click();

        }
        else{
            System.out.println("radio button not selcted");
        }
    }

     /*
    End Radio button selected method
     */

    /*
    Start Select drop down values methods
     */

    /*
    Start select by index
     */

    public static void dropdownselectByIndex(WebDriver driver, WebElement element, int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    /*
    End select by index
     */

    /*
    Start Select by value
     */
    public static void dropdownselectByValue(WebDriver driver, WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }
    /*
    End Select by value
     */

    /*
    Start Select by visible text
     */
    public static void dropdownselectByVisibleText(WebDriver driver, WebElement element, String visibletext){
        Select select = new Select(element);
        select.selectByVisibleText(visibletext);
    }
    /*
    End Select by visible text
     */

    /*
    Start Select by multiple values
     */
    public static void selectByMultipleValuesDropdown(WebDriver driver, WebElement element,String which, String[] array){
        Select select = new Select(element);
        if(select.isMultiple()){
            if(which.equals("byindex")){
                for(int i=0; i<=array.length;i++){
                    select.selectByIndex(i);
                }

            } else if(which.equals("byvalue")){
                for(int i=0; i<=array.length;i++){
                    select.selectByValue(array[i]);
                }

            }else if(which.equals("byvisibletext")){
                for(int i=0; i<=array.length;i++){
                    select.selectByVisibleText(array[i]);
                }

            }
        }
    }
/*
    End Select by multiple values
     */
 /*
    End  Select drop down values methods
     */


    /* Handled javascript alert
    */
    public static String handledJSaAlert(WebDriver driver, String option){
        Alert alert= driver.switchTo().alert();
        String alerttxt =alert.getText();

        if(option.equalsIgnoreCase("acept")){
            alert.accept();
        }else if(option.equalsIgnoreCase("dismis")){
            alert.dismiss();
        }
        else{
            System.out.println("Handle alert functinality is not working");
        }

        return alerttxt;
    }
    /*
    End Handled javascript alert
     */

    /*
    Start handle file uploads
     */

    public static void handleFileUpload(WebDriver driver,WebElement element, String filepath){
        element.sendKeys(filepath);
    }

    /*
    End handle file uploads
     */

    /*
    Start handle frames
     */
    public static void handleFrames(WebDriver driver, String frmaename){
        driver.switchTo().frame(frmaename);

    }

    /*
    End handle frames
     */

    /*
    Start Drag and Drop
     */
    public static void drapAndDrop(WebDriver driver, WebElement sourceElement, WebElement targetElement){
        Actions actions = new Actions(driver);
        actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
    }
    /*
    End Drag and Drop
     */

    /*
    Start Explicit wait
     */

    public static void explicitWait(WebDriver driver,WebElement element, long time){
        new WebDriverWait(driver,time).ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /*
    End Explicit wait
     */


    /*
    Start browser popup windows
     */
    public static void handleBrowserPopUpWindows(WebDriver driver){
        Set<String> handler = driver.getWindowHandles();
       Iterator<String> it= handler.iterator();
       String childWindowId = it.next();
       driver.switchTo().window(childWindowId);
       String title = driver.getTitle();
        System.out.println(title);
    }

    /*
    End browser popup windows
     */

    /*
    Start handle bootstarp dropdown
     */
    public static void handleBootstrapDropDown(WebDriver driver,WebElement dropdown, String xpath, String optionValue){
        dropdown.click();
        List<WebElement> list = driver.findElements(By.xpath(xpath));
        for(int i=0; i<list.size();i++){
            if(list.get(i).getText().equalsIgnoreCase(optionValue)){
                list.get(i).click();
                break;

            }

        }
    }
      /*
    End handle bootstarp dropdown
     */

    /*
    Start enter date with JSE
     */
    public static void enterDateWithJSE(WebDriver driver,String date, WebElement element){
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value',"+date+");",element);

    }
    /*
    End enter date with JSE
     */



}








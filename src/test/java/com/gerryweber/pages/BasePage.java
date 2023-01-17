package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }



    public static void verifyUrl(String expectedURL) {
        String actualTitle = Driver.get().getCurrentUrl();
        actualTitle = actualTitle.replace("https://www.gerryweber.com.tr","");
        Assert.assertEquals(expectedURL,actualTitle);
    }

    public static String verifyMessage(String msg){
        String msg_Loc = Driver.get().findElement(By.xpath("//*[text()='"+msg+"']")).getText();

        return msg_Loc;
    }

    public static String verifyMessagee(String msg){
        String msg_Loc = Driver.get().findElement(By.xpath("(//*[text()='"+msg+"'])[2]")).getText();

        return msg_Loc;
    }

    public static void clickButton(String button){
    String button_Loc = "//*[text()='"+button+"']";
    BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(button_Loc)),5);
    Driver.get().findElement(By.xpath(button_Loc)).click();
    BrowserUtils.waitFor(2);
    }
    public static void clickButton2(String button){
        String button_Loc = "(//*[text()='"+button+"'])[2]";
        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(button_Loc)),5);
        Driver.get().findElement(By.xpath(button_Loc)).click();
        BrowserUtils.waitFor(1);
    }
    public static void clickButton3(String button){
        String button_Loc = "(//*[text()='"+button+"'])[3]";
        BrowserUtils.waitForClickablility(Driver.get().findElement(By.xpath(button_Loc)),5);
        Driver.get().findElement(By.xpath(button_Loc)).click();
        BrowserUtils.waitFor(1);
    }


    /**
     * This method will navigate user to the specific module in useinsider application.
     * For example: if tab is equals to More, and module equals to Careers,
     * Then method will navigate user to this page: https://useinsider.com/careers/
     *
     * @param tab
     * @param module
     *
     */
    public static void navigateToModule(String tab, String module) {
        String tabLocator = "//p[text()='"+tab+"']";
        String moduleLocator = "//*[text()='"+module+"']";

        try {
            BrowserUtils.waitFor(1);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            Actions actions = new Actions(Driver.get());
            actions.moveToElement(tabElement).perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.waitFor(1);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.waitFor(2);
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);

        }
    }

}

package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import com.gerryweber.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(css = "#email")
    public WebElement email_Loc;

    @FindBy(css = "#password")
    public WebElement password_Loc;

    @FindBy(css = "#mui-1")
    public WebElement searchBox_Loc;


    public void gotoHomePage() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(5);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        WebElement accept = (WebElement) jse.executeScript("return document.querySelector('#usercentrics-root').shadowRoot.querySelector('#focus-lock-id > div.sc-furwcr.kbclTA > div > div.sc-bYoBSM.egarKh > div > div > div.sc-dlVxhl.bEDIID > div > button:nth-child(3)')");
        BrowserUtils.clickWithJS(accept);
        BrowserUtils.waitFor(1);

    }

    public void login() {
        String email = ConfigurationReader.get("user_email");
        String password = ConfigurationReader.get("user_password");

        email_Loc.sendKeys(email);
        BrowserUtils.waitFor(1);
        password_Loc.sendKeys(password);
    }

    public static void checkHomePage() {
        String expectedUrl = "https://www.gerryweber.com.tr/tr-TR";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        BrowserUtils.waitFor(2);
    }

    public void searchBox(String string) {
        searchBox_Loc.sendKeys(string + Keys.ENTER);

        BrowserUtils.waitFor(1);

    }

    public void invalidEmailCheck() {
        email_Loc.sendKeys(ConfigurationReader.get("guest_email"));
        password_Loc.sendKeys(ConfigurationReader.get("user_password"));
    }

    public void invalidPasswordCheck() {
        email_Loc.sendKeys(ConfigurationReader.get("user_email"));
        password_Loc.sendKeys("Inveon34...");
    }

}

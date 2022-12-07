package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import com.gerryweber.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage {

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#mui-1") public WebElement searchBox_Loc;

    @FindBy(xpath = "//*[@class='MuiBox-root muirtl-1wpou87']") public List<WebElement> categoriesList_Loc;

    @FindBy(xpath = "//*[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall muirtl-jj2tjk']//p") public List<WebElement> headerNames_Loc;

    public void gotoHomePage() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(5);

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        WebElement accept = (WebElement) jse.executeScript("return document.querySelector('#usercentrics-root').shadowRoot.querySelector('#focus-lock-id > div.sc-kDvujY.cRCOkl > div > div.sc-cCjUiG.gHlwwJ > div > div > div.sc-lllmON.fjvxqY > div > button:nth-child(3)')");
        BrowserUtils.clickWithJS(accept);
        BrowserUtils.waitFor(1);
    }

    public static void checkHomePage(){
        String expectedTitle ="GERRY WEBER";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public void searchBox(String string) {
        searchBox_Loc.sendKeys(string + Keys.ENTER);

        BrowserUtils.waitFor(1);
    }

    List<String> allCategories = new ArrayList<>();
    public void checkCategories(List<String> categoriesList){

        for (WebElement element : categoriesList_Loc) {
            allCategories.add(element.getText());
        }
        Assert.assertTrue(allCategories.containsAll(categoriesList));
    }

    List<String> allNames = new ArrayList<>();
    public void checkHeaderNames(List<String> headerNames){

        for (WebElement element : headerNames_Loc) {
            allNames.add(element.getText());
        }
        Assert.assertTrue(allNames.containsAll(headerNames));
    }
}

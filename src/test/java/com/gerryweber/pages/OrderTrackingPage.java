package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderTrackingPage extends BasePage{

    @FindBy(css = "#orderId") public WebElement siparisNo_Loc;

    @FindBy(css = "#email") public WebElement ePosta_Loc;

    public void enterInformations(){

        BrowserUtils.waitForClickablility(siparisNo_Loc,5);
        siparisNo_Loc.sendKeys("123ABC");
        BrowserUtils.waitFor(1);
        ePosta_Loc.sendKeys(ConfigurationReader.get("user_email"));
        BrowserUtils.waitFor(1);
    }
}

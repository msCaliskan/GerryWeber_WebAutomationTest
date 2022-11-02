package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage{

    @FindBy(css = "#oldPassword") public WebElement gecerliSifre_Loc;

    @FindBy(css = "#newPassword") public WebElement yeniSifre_Loc;

    @FindBy(css = "#confirmNewPassword") public WebElement sifreTekrari_Loc;
    public void changePassword(){
        gecerliSifre_Loc.sendKeys(ConfigurationReader.get("user_password"));
        yeniSifre_Loc.sendKeys(ConfigurationReader.get("user_password"));
        sifreTekrari_Loc.sendKeys(ConfigurationReader.get("user_password"));

        BrowserUtils.waitFor(2);
    }

    public void wrongOldPassword(){
        gecerliSifre_Loc.sendKeys("Inveon34..");
        yeniSifre_Loc.sendKeys("Inveon34.");
        sifreTekrari_Loc.sendKeys("Inveon34.");

        BrowserUtils.waitFor(2);
    }
    public void differentPassword(){
        gecerliSifre_Loc.sendKeys("Inveon34.");
        yeniSifre_Loc.sendKeys("Inveon34..");
        sifreTekrari_Loc.sendKeys("Inveon34.");

        BrowserUtils.waitFor(2);
    }
}

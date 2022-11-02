package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddressPage extends BasePage{

    @FindBy(css = "#firstName") public WebElement ad_Loc;

    @FindBy(css = "#lastName") public WebElement soyad_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#phone") public WebElement telefon_Loc;

    @FindBy(css = "#title") public WebElement adresBasligi_Loc;

    @FindBy(css = "#cityId") public WebElement sehir_Loc;

    @FindBy(css = "#countyId") public WebElement ilce_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters')]") public List<WebElement> dataList_Loc;

    @FindBy(css = "#zipPostalCode") public WebElement postaKodu_Loc;

    @FindBy(css = "#identifier") public WebElement tcKimlik_Loc;

    @FindBy(css = "#streetAddress") public WebElement adres_Loc;

    public void enterAdress(){
        BrowserUtils.scrollDown();
        BrowserUtils.waitFor(1);

        adresBasligi_Loc.sendKeys(ConfigurationReader.get("adress_title"));
        ad_Loc.sendKeys(ConfigurationReader.get("user_firstName"));
        soyad_Loc.sendKeys(ConfigurationReader.get("user_lastName"));
        email_Loc.sendKeys(ConfigurationReader.get("user_email"));
        telefon_Loc.click();
        telefon_Loc.sendKeys(ConfigurationReader.get("user_phone1"));
        postaKodu_Loc.click();
        postaKodu_Loc.sendKeys("34340");
        tcKimlik_Loc.click();
        tcKimlik_Loc.sendKeys(ConfigurationReader.get("user_identifier"));
        BrowserUtils.waitFor(1);

        sehir_Loc.click();
        BrowserUtils.waitFor(1);

        for (int i = 0; i < dataList_Loc.size(); i++) {
            if (dataList_Loc.get(i).getText().contains("Ankara")){
                BrowserUtils.clickWithJS(dataList_Loc.get(i));
                break;
            }
        }

        BrowserUtils.waitFor(1);

        ilce_Loc.click();
        BrowserUtils.waitFor(1);

        for (int i = 0; i < dataList_Loc.size(); i++) {
            if (dataList_Loc.get(i).getText().contains("EVREN")){
                BrowserUtils.clickWithJS(dataList_Loc.get(i));
                break;
            }
        }
        adres_Loc.sendKeys("test test test");

    }
}

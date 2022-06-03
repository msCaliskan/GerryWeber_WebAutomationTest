package com.gerryweber.pages;


import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountPage extends BasePage{

    @FindBy(css = "#firstName") public WebElement ad_Loc;

    @FindBy(css = "#lastName") public WebElement soyad_Loc;

    @FindBy(css = "#email") public WebElement email_Loc;

    @FindBy(css = "#phone") public WebElement telefon_Loc;

    @FindBy(css = "#oldPassword") public WebElement gecerliSifre_Loc;

    @FindBy(css = "#newPassword") public WebElement yeniSifre_Loc;

    @FindBy(css = "#confirmNewPassword") public WebElement sifreTekrari_Loc;

    @FindBy(css = "#title") public WebElement adresBasligi_Loc;

    @FindBy(css = "#countryId") public WebElement ulke_Loc;

    @FindBy(css = "#cityId") public WebElement sehir_Loc;

    @FindBy(css = "#countyId") public WebElement ilce_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root')]") public List<WebElement> dataList_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root')]") public WebElement ulke_Loc2;

    @FindBy(css = "#zipPostalCode") public WebElement postaKodu_Loc;

    @FindBy(css = "#identifier") public WebElement tcKimlik_Loc;

    @FindBy(css = "#streetAddress") public WebElement adres_Loc;

    public void getInformation(String name, String lastname, String email, String phone){
        String actName = ad_Loc.getAttribute("value");
        String actlastName = soyad_Loc.getAttribute("value");
        String actEmail = email_Loc.getAttribute("value");
        String actPhone = telefon_Loc.getAttribute("value");

        assertEquals(name,actName);
        assertEquals(lastname,actlastName);
        assertEquals(email,actEmail);
        assertEquals(phone,actPhone);
    }

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
        List<WebElement> allCity = dataList_Loc;

        for (int i = 1; i <= allCity.size(); i++) {
            if (allCity.get(i).getText().contains("İstanbul")){
                BrowserUtils.clickWithJS(allCity.get(i));
                break;
            }
        }

        BrowserUtils.waitFor(1);

        ilce_Loc.click();
        BrowserUtils.waitFor(1);

        List<WebElement> allCounty= dataList_Loc;

        for (int i = 1; i <= allCounty.size(); i++) {
            if (allCounty.get(i).getText().contains("BESIKTAS")){
                BrowserUtils.clickWithJS(allCounty.get(i));
                break;
            }
        }
        adres_Loc.sendKeys("Levent, HAN Spaces, Nispetiye Cd No:24");

    }
    public void enterGuestAdress(){

        BrowserUtils.scrollDown();
        BrowserUtils.waitFor(1);

        adresBasligi_Loc.sendKeys(ConfigurationReader.get("adress_title"));
        ad_Loc.sendKeys(ConfigurationReader.get("user_firstName"));
        soyad_Loc.sendKeys(ConfigurationReader.get("user_lastName"));
        email_Loc.sendKeys(ConfigurationReader.get("guest_email"));
        telefon_Loc.click();
        telefon_Loc.sendKeys(ConfigurationReader.get("user_phone1"));
        BrowserUtils.waitFor(1);
        postaKodu_Loc.click();
        postaKodu_Loc.sendKeys("34340");
        tcKimlik_Loc.click();
        tcKimlik_Loc.sendKeys(ConfigurationReader.get("user_identifier"));
        BrowserUtils.waitFor(1);

        sehir_Loc.click();
        BrowserUtils.waitFor(1);
        List<WebElement> allCity = dataList_Loc;

        for (int i = 1; i <= allCity.size(); i++) {
            if (allCity.get(i).getText().contains("İstanbul")){
                allCity.get(i).click();
                break;
            }
        }

        BrowserUtils.waitFor(1);

        ilce_Loc.click();
        BrowserUtils.waitFor(1);

        List<WebElement> allCounty= dataList_Loc;

        for (int i = 1; i <= allCounty.size(); i++) {
            if (allCounty.get(i).getText().contains("BESIKTAS")){
                allCounty.get(i).click();
                break;
            }
        }
        adres_Loc.sendKeys("Levent, HAN Spaces, Nispetiye Cd No:24");

    }

}

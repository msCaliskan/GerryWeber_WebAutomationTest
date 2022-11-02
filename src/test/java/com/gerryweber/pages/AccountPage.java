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

    @FindBy(css = "#title") public WebElement adresBasligi_Loc;

    @FindBy(css = "#cityId") public WebElement sehir_Loc;

    @FindBy(css = "#countyId") public WebElement ilce_Loc;

    @FindBy(xpath = "//*[contains(@class, 'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters')]") public List<WebElement> dataList_Loc;

    @FindBy(css = "#zipPostalCode") public WebElement postaKodu_Loc;

    @FindBy(css = "#identifier") public WebElement tcKimlik_Loc;

    @FindBy(css = "#streetAddress") public WebElement adres_Loc;

    @FindBy(xpath = "//*[@class='MuiBox-root muirtl-1qm1lh']") public WebElement urun_Loc;

    @FindBy(xpath = "//*[text()='Listeden Çıkar']") public WebElement removeBtn_Loc;

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

    public void removeProduct(){
        BrowserUtils.hover(urun_Loc);
        BrowserUtils.waitFor(2);
        removeBtn_Loc.click();
        BrowserUtils.waitFor(1);
    }

}

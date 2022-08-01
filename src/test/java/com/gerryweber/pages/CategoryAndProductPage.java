package com.gerryweber.pages;

import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CategoryAndProductPage extends BasePage {

    @FindBy(xpath = "//*[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-4 MuiGrid-grid-md-4')]") public List<WebElement> prodList_Loc;

    @FindBy(xpath = "//button[contains(@class, 'MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-disableElevation MuiButtonBase-root has-stock')]") public List<WebElement> sizeList_Loc;

    @FindBy(xpath = "//*[@class='MuiTypography-root jss140 MuiTypography-body1']") public List<WebElement> productName_Loc;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium muirtl-1x0t2pd'])[2]") public WebElement uyari_Loc;

    @FindBy(xpath = "//*[contains (@class, 'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6 MuiGrid-grid-sm-4')]") public WebElement product_Loc;

    @FindBy(xpath = "//*[@name='price']") public WebElement priceHolder_Loc;

    public void clickProductRandom(){

        Random rn = new Random();
        int a = rn.nextInt(prodList_Loc.size());

        BrowserUtils.waitFor(2);
        BrowserUtils.hover(prodList_Loc.get(a));
        BrowserUtils.waitFor(2);
        prodList_Loc.get(a).click();
        BrowserUtils.waitFor(1);
    }

    public void selectSize(){

        Random rn = new Random();
        int a = rn.nextInt(sizeList_Loc.size());

        sizeList_Loc.get(a).click();
    }

    public void searchResult(String string){

        List<String> allNames = new ArrayList<>();
        for (WebElement element : prodList_Loc) {
        allNames.add(element.getText());
        }
        for (int i = 0; i < productName_Loc.size(); i++) {
             allNames.get(i).contains(string);
        }
        String a = Driver.get().findElement(By.xpath("(//*[@class='MuiTypography-root MuiTypography-body3 muirtl-1e5a1xf'])[2]")).getText();
        a=a.replace(" TL","");
        System.out.println("a = " + a);

    }
    public void closePopUps(){
        uyari_Loc.click();
        BrowserUtils.waitFor(1);
    }

    public void hoverToProduct(){
        BrowserUtils.hover(product_Loc);
        BrowserUtils.waitFor(2);
    }
    public void validPrice(){
        String price = priceHolder_Loc.getAttribute("value");

        int b = Integer.parseInt(price);
        int c= b-5;

        BrowserUtils.waitFor(2);
        priceHolder_Loc.sendKeys(Keys.CONTROL+"a");
        priceHolder_Loc.sendKeys(Keys.DELETE);
        BrowserUtils.waitFor(1);
        priceHolder_Loc.sendKeys(Integer.toString(c));
        BrowserUtils.waitFor(2);

    }

}
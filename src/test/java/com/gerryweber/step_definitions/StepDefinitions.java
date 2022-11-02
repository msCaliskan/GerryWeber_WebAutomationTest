package com.gerryweber.step_definitions;

import com.gerryweber.pages.*;
import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import com.gerryweber.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class StepDefinitions {
    
    AccountPage accountPage = new AccountPage();
    AddressPage addressPage = new AddressPage();
    CategoryAndProductPage categoryAndProductPage = new CategoryAndProductPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    OrderTrackingPage orderTrackingPage = new OrderTrackingPage();

    @Given("The user visits GerryWeber homepage")
    public void the_user_visits_GerryWeber_homepage() {
        homePage.gotoHomePage();
    }

    @And("The user verifies redirected to homepage")
    public void the_user_verifies_redirected_to_homepage() {
        HomePage.checkHomePage();
    }

    @Given("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login();
    }

    @When("The user verifies redirected to {string} page")
    public void the_user_verifies_redirected_to_page(String expUrl) {
        BasePage.verifyUrl(expUrl);
    }

    @When("The user checks {string}, {string}, {string} and {string} informations")
    public void the_user_checks_and_informations(String name, String lastName, String email, String phone) {
        accountPage.getInformation(name,lastName,email,phone);
    }

    @When("The user clicks {string} button")
    public void the_user_clicks_button(String button) {
        BasePage.clickButton(button);
    }

    @And("The user clicks {string} buttonn")
    public void theUserClicksButtonn(String button) {
        BasePage.clickButton2(button);
    }

    @And("The user clicks {string} buttonnn")
    public void theUserClicksButtonnn(String str) {
        BasePage.clickButton3(str);
    }

    @When("The user enters old, new and confirm new password")
    public void the_user_enters_old_new_and_confirm_new_password() {
        changePasswordPage.changePassword();
    }

    @When("The user enters valid informations")
    public void the_user_enters_valid_informations() {
      addressPage.enterAdress();
    }

    @When("The user enters valid informations for guest")
    public void theUserEntersValidInformationsForGuest() {
        checkoutPage.enterGuestAdress();
    }

    @Given("The user navigates to {string} {string} category")
    public void the_user_navigates_to_category(String tab, String module) {
        BasePage.navigateToModule(tab,module);
    }

    @When("The user clicks any product")
    public void the_user_clicks_any_product() {
        categoryAndProductPage.clickProductRandom();
    }

    @When("The user verifies {string} message")
    public void the_user_verifies_message(String message) {
        Assert.assertEquals(message.trim(), BasePage.verifyMessage(message));
    }

    @When("The user chooses size")
    public void the_user_chooses_size() {
        categoryAndProductPage.selectSize();
    }

    @When("The user enters invalid informations")
    public void the_user_enters_invalid_informations() {
        checkoutPage.invalidCard();
    }

    @When("The user selects On Bilgilendirme and Mesafeli Satis Sozlesmesi buttons")
    public void the_user_selects_On_Bilgilendirme_and_Mesafeli_Satis_Sozlesmesi_buttons() {
        checkoutPage.checkBox();
    }

    @Then("The user clicks Back button")
    public void the_user_clicks_Back_button() {
        Driver.get().navigate().back();
        BrowserUtils.waitFor(2);
    }

    @Then("The user enters forget password email address")
    public void the_user_enters_forget_password_email_address() {
        homePage.email_Loc.sendKeys(ConfigurationReader.get("user_email"));

    }
    @Given("The user fills {string} in the searchbox and click")
    public void the_user_fills_in_the_searchbox_and_click(String string) {
        homePage.searchBox(string);
    }

    @Then("The user should see all search results match with {string}")
    public void the_user_should_see_all_search_results_match_with(String string) {
        categoryAndProductPage.searchResult(string);
    }

    @And("The user enters invalid email")
    public void theUserEntersInvalidEmail() {
        loginPage.invalidEmailCheck();
    }

    @And("The user enters invalid password")
    public void theUserEntersInvalidPassword() {
        loginPage.invalidPasswordCheck();
    }

    @And("The user clicks Cart button")
    public void theUserClicksCartButton() {
        checkoutPage.cartButton();
    }

    @And("The user closes popUps")
    public void theUserClosesPopUps() {
        categoryAndProductPage.closePopUps();
    }

    @And("The user enters wrong old password")
    public void theUserEntersWrongOldPassword() {
        changePasswordPage.wrongOldPassword();
    }

    @And("The user enters different passwords")
    public void theUserEntersDifferentPasswords() {
        changePasswordPage.differentPassword();
    }

    @And("The user enters valid price")
    public void theUserEntersValidPrice() {
        categoryAndProductPage.validPrice();
    }
    @And("The user remove product")
    public void theUserRemoveProduct() {
        accountPage.removeProduct();
    }

    @And("The user verifies categories")
    public void theUserVerifiesCategories(List<String> categoriesList) {
        homePage.checkCategories(categoriesList);
    }

    @And("The user verifies header menu names")
    public void theUserVerifiesHeaderMenuNames(List<String> headerNames) {
        homePage.checkHeaderNames(headerNames);
    }

    @And("The user enters informations")
    public void theUserEntersInformations() {
        orderTrackingPage.enterInformations();
    }
}

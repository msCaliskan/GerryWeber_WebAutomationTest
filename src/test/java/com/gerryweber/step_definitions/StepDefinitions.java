package com.gerryweber.step_definitions;

import com.gerryweber.pages.*;
import com.gerryweber.utilities.BrowserUtils;
import com.gerryweber.utilities.ConfigurationReader;
import com.gerryweber.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class StepDefinitions {

    @Given("The user visits GerryWeber homepage")
    public void the_user_visits_GerryWeber_homepage() {
        new HomePage().gotoHomePage();
        BrowserUtils.waitFor(1);
    }

    @And("The user verifies redirected to homepage")
    public void the_user_verifies_redirected_to_homepage() {
        HomePage.checkHomePage();
    }

    @Given("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        new HomePage().login();
    }

    @When("The user verifies redirected to {string} page")
    public void the_user_verifies_redirected_to_page(String expUrl) {
        BasePage.verifyUrl(expUrl);
    }

    @When("The user checks {string}, {string}, {string} and {string} informations")
    public void the_user_checks_and_informations(String name, String lastName, String email, String phone) {
        new AccountPage().getInformation(name,lastName,email,phone);
    }

    @When("The user clicks {string} button")
    public void the_user_clicks_button(String button) {
        BasePage.clickButton(button);
    }

    @And("The user clicks {string} buttonn")
    public void theUserClicksButtonn(String str) {
        BasePage.clickButton2(str);
    }

    @When("The user enters old, new and confirm new password")
    public void the_user_enters_old_new_and_confirm_new_password() {
        new AccountPage().changePassword();
    }

    @When("The user enters valid informations")
    public void the_user_enters_valid_informations() {
      new AccountPage().enterAdress();
    }

    @When("The user enters valid informations for guest")
    public void theUserEntersValidInformationsForGuest() {
        new AccountPage().enterGuestAdress();
    }

    @Given("The user navigates to {string} {string} category")
    public void the_user_navigates_to_category(String tab, String module) {
        BasePage.navigateToModule(tab,module);
    }

    @When("The user clicks anyone product")
    public void the_user_clicks_anyone_product() {
        new CategoryAndProductPage().clickProductRandom();
    }

    @When("The user verifies {string} message")
    public void the_user_verifies_message(String message) {
        Assert.assertEquals(message.trim(), BasePage.verifyMessage(message));
    }

    @When("The user chooses color and size")
    public void the_user_chooses_color_and_size() {
        new CategoryAndProductPage().selectSize();
    }

    @When("The user enters invalid informations")
    public void the_user_enters_invalid_informations() {
        new CheckoutPage().invalidCard();
    }

    @When("The user selects Ön Bilgilendirme and Mesafeli Satış Sözleşmesi buttons")
    public void the_user_selects_Ön_Bilgilendirme_and_Mesafeli_Satış_Sözleşmesi_buttons() {
        new CheckoutPage().checkBox();
    }

    @Then("The user clicks Back button")
    public void the_user_clicks_Back_button() {
        Driver.get().navigate().back();
    }

    @Then("The user enters forget password email address")
    public void the_user_enters_forget_password_email_address() {
        new HomePage().email_Loc.sendKeys(ConfigurationReader.get("user_email"));

    }
    @Given("The user fills {string} in the searchbox and click")
    public void the_user_fills_in_the_searchbox_and_click(String string) {
        new HomePage().searchBox(string);
    }

    @Then("The user should see all search results match with {string}")
    public void the_user_should_see_all_search_results_match_with(String string) {
        new CategoryAndProductPage().searchResult(string);
    }

    @And("The user enters invalid email")
    public void theUserEntersInvalidEmail() {
        new HomePage().invalidEmailCheck();
    }

    @And("The user enters invalid password")
    public void theUserEntersInvalidPassword() {
        new HomePage().invalidPasswordCheck();
    }

    @And("The user clicks Cart button")
    public void theUserClicksCartButton() {
        new CheckoutPage().cartButton();
    }

    @And("The user closes popUps")
    public void theUserClosesPopUps() {
        new CategoryAndProductPage().closePopUps();
    }

    @And("The user hovers to product")
    public void theUserHoversToProduct() {
        new CategoryAndProductPage().hoverToProduct();
    }
    @And("The user enters wrong old password")
    public void theUserEntersWrongOldPassword() {
        new AccountPage().wrongOldPassword();
    }

    @And("The user enters different passwords")
    public void theUserEntersDifferentPasswords() {
        new AccountPage().differentPassword();
    }
}

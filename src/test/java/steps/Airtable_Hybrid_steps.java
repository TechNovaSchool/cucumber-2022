package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AirtableLoginPage;
import utilities.Config;
import utilities.Driver;

public class Airtable_Hybrid_steps {
    AirtableLoginPage airtableLoginPage = new AirtableLoginPage();

    @Given("Navigate to login page")
    public void navigate_to_login_page() {
        Driver.getDriver().get(Config.getProperty("loginAirTableURL"));
        airtableLoginPage.signInReference.click();
    }
    @When("Enter the email address")
    public void enter_the_email_address() {
        airtableLoginPage.login.sendKeys(Config.getProperty("User"));
    }
    @When("Enter the password")
    public void enter_the_password() {
        airtableLoginPage.passwordLogin.sendKeys(Config.getProperty("Pass"));
    }
    @When("press the sign in button")
    public void press_the_sign_in_button() {
        airtableLoginPage.signInButton.click();
    }
    @Then("Home base page should appear")
    public void home_base_page_should_appear() {

    }
    @Then("Click on Transformers button")
    public void click_on_transformers_button() {

    }
    @When("I add a new record")
    public void i_add_a_new_record() {

    }
    @Then("I will check with API that record was saved")
    public void i_will_check_with_api_that_record_was_saved() {

    }
}

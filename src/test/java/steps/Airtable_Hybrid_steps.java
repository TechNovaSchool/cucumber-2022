package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AirtableLoginPage;
import pages.AirtableOnePage;
import utilities.APIUtil;
import utilities.Config;
import utilities.Driver;

public class Airtable_Hybrid_steps {
    AirtableLoginPage airtableLoginPage = new AirtableLoginPage();
    AirtableOnePage tablePage = new AirtableOnePage();
    String name = "Andrew";

    @Given("Navigate to login page")
    public void navigate_to_login_page() {
        Driver.getDriver().get(Config.getProperty("loginAirTableURL"));
//        airtableLoginPage.signInReference.click();
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
    String expectedValue = "My First Workspace";
    String actualValue = tablePage.workSpaceName.getText();
        Assert.assertEquals(expectedValue, actualValue);
    }
    @Then("Click on Transformers button")
    public void click_on_transformers_button() {
        airtableLoginPage.getTransformersTable.click();
    }
    @When("I add a new record")
    public void i_add_a_new_record() {
        tablePage.plusSign.click();
        tablePage.plusSign.sendKeys(name);

    }
    @Then("I will check with API that record was saved")
    public void i_will_check_with_api_that_record_was_saved() {
        String resource = "/table%201";
        APIUtil.hitGET(resource);
        String actualName =  APIUtil.getResponseBody().getRecords().get(0).getFields().getName();
        Assert.assertEquals(actualName, name);
    }
}

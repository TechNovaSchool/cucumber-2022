package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.GooglePage;
import utilities.Driver;

public class Google_steps {

    GooglePage googlePage = new GooglePage();

    @Given("I am at google home page")
    public void i_am_at_google_home_page() {
        Driver.getDriver().get("https://www.google.com");

    }
    @Then("I verify the title is Google")
    public void i_verify_the_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    @When("I search for dark web")
    public void i_search_for_dark_web() {
        googlePage.searchBox.sendKeys("dark web", Keys.ENTER);
    }
    @Then("I verify the title contains dark web")
    public void i_verify_the_title_contains_dark_web() {
        String expectedTitle = "dark web";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue("The title is not correct",actualTitle.contains(expectedTitle));
    }

}

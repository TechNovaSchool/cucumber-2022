package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.Driver;

public class Amazon_steps {
    AmazonPage amazonPage = new AmazonPage();
    String searchValue = "apple watch";

    @Given("I am at amazon application")
    public void i_am_at_amazon_application() {
        Driver.getDriver().get("https://www.amazon.com");

    }
    @When("I search for apple watch")
    public void i_search_for_apple_watch() {
    amazonPage.searchBox.sendKeys(searchValue, Keys.ENTER);
    }
    @Then("I see the product is displayed")
    public void i_see_the_product_is_displayed() {

        Assert.assertTrue(amazonPage.firstProduct.isDisplayed());

    }
    @Then("I open first product")
    public void i_open_first_product() {
    amazonPage.firstProduct.click();
    }
    @Then("I verify the title contains apple watch")
    public void i_verify_the_title_contains_apple_watch() {
    Assert.assertTrue(amazonPage.titleOfProduct.getText().toLowerCase().contains(searchValue));
    }
    @Then("I add product the the cart")
    public void i_add_product_the_the_cart() {
    amazonPage.addToCart.click();
    }
}

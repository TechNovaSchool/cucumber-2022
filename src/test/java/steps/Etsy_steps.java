package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.EtsyPage;
import utilities.Driver;

public class Etsy_steps {
    EtsyPage etsy = new EtsyPage();
    String book = "book";

    @Given("I am on etsy homepage")
    public void i_am_on_etsy_homepage() {
        Driver.getDriver().get("https://www.etsy.com");

    }
    @When("I search for book")
    public void i_search_for_book() {
        etsy.search.sendKeys(book);
    }
    @When("I click on search box")
    public void i_click_on_search_box() {
        etsy.getSearch.click();
    }
    @Then("I see the title contains book")
    public void i_see_the_title_contains_book() {
        String mainWindow = Driver.getDriver().getWindowHandle();
        etsy.firstProduct.click();

        for(String tabs : Driver.getDriver().getWindowHandles()){
            if ( !tabs.equals(mainWindow)){
                Driver.getDriver().switchTo().window(tabs);
            }
        }

        System.out.println(etsy.titleOfTheBook.getText().toLowerCase());
        Assert.assertTrue(etsy.titleOfTheBook.getText().toLowerCase().contains(book));
    }


}

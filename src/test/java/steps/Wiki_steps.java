package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.WikiPage;
import utilities.Driver;

public class Wiki_steps {
    WikiPage wikiPage = new WikiPage();
    String name = "Steeve Job";
    @Given("user click on wikipedia page")
    public void user_click_on_wikipedia_page() {
        Driver.getDriver().get("https://en.wikipedia.org/wiki/Main_Page");
    }
    @When("User type Steve Jobs in the wiki search box")
    public void user_type_steve_jobs_in_the_wiki_search_box() {
        wikiPage.searchBox.sendKeys(name, Keys.ENTER);
    }
    @When("User click search button")
    public void user_click_search_button() {
    }
    @Then("User see Steve Jobs in the wiki page title")
    public void user_see_steve_jobs_in_the_wiki_page_title() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(name));
    }
}

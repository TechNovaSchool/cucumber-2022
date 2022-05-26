package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.WikiPage;
import utilities.Driver;

public class Wiki_steps {
    WikiPage wikiPage = new WikiPage();
    String name = "Steve Jobs";
    @Given("user click on wikipedia page")
    public void user_click_on_wikipedia_page() {
        Driver.getDriver().get("https://en.wikipedia.org/wiki/Main_Page");
    }
    @When("User type Steve Jobs in the wiki search box")
    public void user_type_steve_jobs_in_the_wiki_search_box() {
        wikiPage.searchBox.sendKeys(name);
    }
    @When("User click search button")
    public void user_click_search_button() {
        wikiPage.searchBtn.click();
    }
    @Then("User see Steve Jobs in the wiki page title")
    public void user_see_steve_jobs_in_the_wiki_page_title() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(name));
    }

    @Then("User see Steve Jobs in the main header")
    public void user_see_steve_jobs_in_the_main_header() {
        Assert.assertTrue(wikiPage.headerTitle.isDisplayed());
        Assert.assertEquals(wikiPage.headerTitle.getText(), name);
    }

    @Then("User see Steve Jobs in the image header")
    public void user_see_steve_jobs_in_the_image_header() {
        Assert.assertEquals(wikiPage.imageHeader.getText(), name);

    }

    @When("User type {string} in the wiki search box")
    public void user_type_in_the_wiki_search_box(String str) {
       wikiPage.searchBox.sendKeys(str);
    }
    @Then("User see {string} in the wiki page title")
    public void user_see_in_the_wiki_page_title(String name) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(name));
    }

    @Then("User see {string} in the main header")
    public void user_see_in_the_main_header(String string) {
        Assert.assertEquals(wikiPage.headerTitle.getText(), string);
    }

    @Then("User see {string} in the image header")
    public void user_see_in_the_image_header(String string) {
        Assert.assertEquals(wikiPage.imageHeader.getText(), string);

    }

}

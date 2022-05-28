package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.SmartBearLoginPage;
import pages.SmartBearorderPage;
import utilities.Config;
import utilities.Driver;

public class SmartBearSteps {
    SmartBearLoginPage login = new SmartBearLoginPage();
    SmartBearorderPage order = new SmartBearorderPage();

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {
        Driver.getDriver().get(Config.getProperty("smartBearUrl"));
        login.login.sendKeys(Config.getProperty("login"));
        login.password.sendKeys(Config.getProperty("pass"));
        login.loginButton.click();
        order.order.click();
    }
    @Given("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String string) {
        Select productDropDown = new Select(order.product);
        productDropDown.selectByVisibleText(string);
    }
    @Given("User enters {string} to quantity input box")
    public void user_enters_to_quantity_input_box(String quantity) {
        order.quantity.sendKeys(Keys.BACK_SPACE, quantity);
    }
    @Given("User enters {string} to costumer name input box")
    public void user_enters_to_costumer_name_input_box(String costumerName) {
        order.name.sendKeys(costumerName);
    }
    @Given("User enters {string} to street name input box")
    public void user_enters_to_street_name_input_box(String streetName) {
        order.streetName.sendKeys(streetName);
    }
    @Given("User enters {string} to city input box")
    public void user_enters_to_city_input_box(String city) {
        order.city.sendKeys(city);
    }
    @Given("User enters {string} to state input box")
    public void user_enters_to_state_input_box(String stateName) {
        order.state.sendKeys(stateName);
    }
    @Given("User enters {string} to zip input box")
    public void user_enters_to_zip_input_box(String zipCode) {
        order.zip.sendKeys(zipCode);
    }
    @Given("User selects {string} as card type from radio buttons")
    public void user_selects_as_card_type_from_radio_buttons(String cardType) {
        if(cardType.equalsIgnoreCase("MasterCard")){
            order.cardTypeMaster.click();
        }
        else if (cardType.equalsIgnoreCase("Visa")){
            order.cardTypeVisa.click();
        }
        else if (cardType.equalsIgnoreCase("American Express")){
            order.cardTypeAmerican.click();
        }
        else {
            Assert.assertTrue("Unexpected card type", false);
        }

    }
    @Given("User enters {string} to card number input box")
    public void user_enters_to_card_number_input_box(String cardNumber) {
        order.cardNumber.sendKeys(cardNumber);
    }
    @Given("User enters {string} to expiration date into input box")
    public void user_enters_to_expiration_date_into_input_box(String expirationDate) {
        order.expirationDate.sendKeys(expirationDate);
    }
    @Given("User clicks process button")
    public void user_clicks_process_button() {
        order.processButton.click();
    }
    @Then("User verifies {string} is in the table")
    public void user_verifies_is_in_the_table(String string) {

    }

}

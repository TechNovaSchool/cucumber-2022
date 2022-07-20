package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.APIUtil;

public class Airtable_steps {

    @When("I hit the GET endpoint")
    public void i_hit_the_get_endpoint() {
        String resource = "/Table%201";
        APIUtil.hitGET(resource);

    }
    @Then("I expect status code to be {string}")
    public void i_expect_status_code_to_be(String statusCode) {
       String str = String.valueOf(APIUtil.getResponse().statusCode());
        Assert.assertEquals(statusCode, str);
    }

    @Then("I expect status code to be {int}")
    public void iExpectStatusCodeToBe(int statusCode) {
        Assert.assertEquals(statusCode,APIUtil.getResponse().statusCode() );
    }

    @And("I verify the name of first record to be {string}")
    public void iVerifyTheNameOfFirstRecordToBe(String name) {
        String actualName = APIUtil.getResponseBody().getRecords().get(0).getFields().getName();
        Assert.assertEquals(name,actualName);
    }
}

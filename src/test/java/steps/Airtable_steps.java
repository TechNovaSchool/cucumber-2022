package steps;

import api.models.MyFields;
import api.models.Record;
import api.models.RequestBody;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.APIUtil;

import java.util.ArrayList;
import java.util.List;

public class Airtable_steps {

    String myRecord;
    String resource = "/Table%201";

    @When("I hit the GET endpoint")
    public void i_hit_the_get_endpoint() {
        APIUtil.hitGET(resource);

    }
    @Then("I expect status code to be {string}")
    public void i_expect_status_code_to_be(String statusCode) {
       String str = String.valueOf(APIUtil.getResponse().statusCode());
        Assert.assertEquals(statusCode, str);
    }

    @Then("I expect status code to be {int}")
    public void iExpectStatusCodeToBe(int statusCode) {
        Assert.assertEquals(statusCode,APIUtil.getResponse().statusCode());
    }

    @And("I verify the name of first record to be {string}")
    public void iVerifyTheNameOfFirstRecordToBe(String name) {
        String actualName = APIUtil.getResponseBody().getRecords().get(0).getFields().getName();
        Assert.assertEquals(name,actualName);
    }

    @When("I create a record")
    public void i_create_a_record() {


        MyFields fields = new MyFields();
        fields.setName("MAX");
        fields.setEmail("test@gmail.com");
        fields.setAddress("985 road");
        fields.setNotes("these are my notes");
        fields.setPhone("123-123-4569");
        fields.setCheckBox(false);

        Record record = new Record();
        record.setFields(fields);
        List<Record> records = new ArrayList<>();
        records.add(record);
        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtil.hitPOST(resource,requestBody);

    }
    @When("I check status code is {int}")
    public void i_check_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode,APIUtil.getResponse().statusCode());

    }
    @Then("I am able to get recordID")
    public void i_am_able_to_get_record_id() {
        myRecord = APIUtil.getResponseBody().getRecords().get(0).getId();

    }
    @Then("I update the record email to name")
    public void i_update_the_record_email_to_name() {
        String str = APIUtil.getResponseBody().getRecords().get(0).getFields().getName();

        MyFields fields = new MyFields();
        fields.setEmail(str+ "@gmail.com");

        Record record = new Record();
        record.setFields(fields);
        record.setId(myRecord);
        List<Record> records = new ArrayList<>();
        records.add(record);
        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        APIUtil.hitPATCH(resource,requestBody);
    }

    @Then("I delete the record")
    public void i_delete_the_record() {
        APIUtil.hitDELETE(resource, myRecord);
    }


    @When("I create a record with a wrong jsonBody")
    public void iCreateARecordWithAWrongJsonBody() {
//        MyFields fields = new MyFields();
//        fields.setName("MAX");
//        fields.setEmail("test@gmail.com");
//        fields.setAddress();
//        fields.setNotes("these are my notes");
//        fields.setPhone("123-123-4569");
//        fields.setCheckBox(false);

//        Record record = new Record();
//        record.setFields(fields);
//        List<Record> records = new ArrayList<>();
//        records.add(record);
       RequestBody requestBody = new RequestBody();
//        requestBody.setRecords(records);

        APIUtil.hitPOST(resource,requestBody);
    }
}

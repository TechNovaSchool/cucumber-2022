package api.test;

import api.models.MyFields;
import api.models.Record;
import api.models.RequestBody;
import api.models.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Config;

import java.util.ArrayList;
import java.util.List;

public class AirtableTests {

    @Test (priority = 1)
    public void getRecord() throws Exception {
        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .get(Config.getProperty("host"));
        System.out.println(response.statusCode());

        ObjectMapper obj = new ObjectMapper();

        ResponseBody rb = obj.readValue(response.asString(), ResponseBody.class);
//        System.out.println(rb.getRecords().get(0).getFields().getName());

        String len = rb.getRecords().toString();
        int size = rb.getRecords().size();
        Assert.assertEquals(response.statusCode(), 200 );
//        System.out.println(size);

        for (Record elements : rb.getRecords()) {
            if (elements.getFields().getName().startsWith("A")) {
                System.out.println(elements.getFields().getName()
                        + " " + elements.getFields().getAddress()
                        + " " + elements.getFields().getPhone()
                        + " " + elements.getFields().getNotes()
                        + " " + elements.getFields().getEmail()

                );

            }
        }


//        for (int i =0; i< size; i++) {
//            String name = rb.getRecords().get(i).getFields().getName();
//            if (name.charAt(0) == 'A') {
//                System.out.println(rb.getRecords().get(i).getFields().getName() + " "
//                        +" "+rb.getRecords().get(i).getFields().getAddress()
//                        +" " +rb.getRecords().get(i).getFields().getNotes()
//                        +" " +rb.getRecords().get(i).getFields().getPhone()
//                        +" " +rb.getRecords().get(i).getFields().getEmail()
//                );
//            }
//        }
    }
    String myRecordId;

    @Test (priority = 2)
    public void postRecord() throws JsonProcessingException {
//
        MyFields fields = new MyFields();
        fields.setName("Andrew");
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

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(requestBody);
//        System.out.println(jsonValue);


        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .contentType("application/json")
                .body(jsonValue)
                .post(Config.getProperty("host"));
//        System.out.println(response.statusCode());

        ResponseBody rb = objectMapper.readValue(response.asString(), ResponseBody.class);
        myRecordId = rb.getRecords().get(0).getId();
        Assert.assertEquals(response.statusCode(), 200 );


    }

    @Test (priority = 3)
    public void updateRecord() throws JsonProcessingException {
        MyFields fields = new MyFields();
        fields.setName("JamesBond");

        Record record = new Record();
        record.setFields(fields);
        record.setId(myRecordId);

        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(requestBody);
//        System.out.println(jsonValue);

        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .body(jsonValue)
                .contentType("application/json")
                .patch(Config.getProperty("host"));

//        System.out.println(response.statusCode());
        Assert.assertEquals(response.statusCode(), 200 );

    }

    @Test (priority = 4)
    public void deleteRecord() {

        String queryPram = "records[]";
        String recordID = myRecordId;

        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .queryParam(queryPram, recordID)
                .delete(Config.getProperty("host"));
//        System.out.println(response.statusCode());
//        System.out.println(response.asString());
        Assert.assertEquals(response.statusCode(), 200 );



    }


}

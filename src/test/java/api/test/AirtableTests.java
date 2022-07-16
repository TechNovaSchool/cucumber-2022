package api.test;

import api.models.MyFields;
import api.models.Record;
import api.models.RequestBody;
import api.models.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Config;

import java.util.ArrayList;
import java.util.List;

public class AirtableTests {

    @Test
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
        System.out.println(size);

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

    @Test
    public void postRecord() throws JsonProcessingException {
//
        MyFields fields = new MyFields();
        fields.setName("Andrew");
        fields.setEmail("test@gmail.com");
        fields.setAddress("985 road");
        fields.setNotes("these are my notes");
        fields.setPhone("123-123-4569");

        Record record = new Record();
        record.setFields(fields);

        List<Record> records = new ArrayList<>();
        records.add(record);

        RequestBody requestBody = new RequestBody();
        requestBody.setRecords(records);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonValue = objectMapper.writeValueAsString(requestBody);
        System.out.println(jsonValue);



        Response response = RestAssured.given()
                .header("Authorization", "Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .contentType("application/json")
                .body(jsonValue)
                .post(Config.getProperty("host"));
        System.out.println(response.statusCode());

    }


}

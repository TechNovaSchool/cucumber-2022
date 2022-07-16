package api.test;

import api.models.Record;
import api.models.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.Config;

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
}

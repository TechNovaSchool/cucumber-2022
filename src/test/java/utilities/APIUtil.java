package utilities;

import api.models.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtil {
    //CRUD operations
    //GET, POST, PATCH, DELETE


    public static void hitGET(String resource) {
        String uri = Config.getProperty("host") + resource;
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + Config.getProperty("token"))
                .urlEncodingEnabled(false)
                .get(uri);
        System.out.println(response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ResponseBody responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }


}

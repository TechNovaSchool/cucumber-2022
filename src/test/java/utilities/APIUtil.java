package utilities;

import api.models.RequestBody;
import api.models.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APIUtil {
    //CRUD operations
    //GET, POST, PATCH, DELETE

    private static Response response;
    private static ResponseBody responseBody;

    public static ResponseBody getResponseBody() {
        return responseBody;
    }

    public static Response getResponse() {
        return response;
    }


    public static void hitGET(String resource) {
        String uri = Config.getProperty("host") + resource;
        response = RestAssured.given()
                .header("Authorization", "Bearer " + Config.getProperty("token"))
                .urlEncodingEnabled(false)
                .get(uri);
        System.out.println(response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void hitPOST(String resource, RequestBody body) {
        String uri = Config.getProperty("host") + resource;

        ObjectMapper objectMapper = new ObjectMapper();
        String bodyJSON = "";
        try {
            bodyJSON = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        response = RestAssured.given()
                .header("Authorization", "Bearer " + Config.getProperty("token"))
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .body(bodyJSON)
                .post(uri);
        System.out.println(response.statusCode());

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void hitPATCH(String resource, RequestBody body) {
        String uri = Config.getProperty("host") + resource;

        ObjectMapper objectMapper = new ObjectMapper();
        String bodyJSON = "";
        try {
            bodyJSON = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        response = RestAssured.given()
                .header("Authorization", "Bearer " + Config.getProperty("token"))
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .body(bodyJSON)
                .patch(uri);
        System.out.println(response.statusCode());

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void hitDELETE(String resource,String recordId) {
        String uri = Config.getProperty("host") + resource;

        response = RestAssured.given()
                .header("Authorization", "Bearer " + Config.getProperty("token"))
                .urlEncodingEnabled(false)
                .queryParam("records[]", recordId)
                .delete(uri);
        System.out.println(response.statusCode());
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}

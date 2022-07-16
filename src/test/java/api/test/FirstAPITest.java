package api.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class FirstAPITest {
    //1. Hitting an endpoint or hit an api
    //2. What type of http request (get, put, post, delete) auth, headers, body, endpoint

    @Test
    public void getListOfBooks() {

        Response response = RestAssured.get("https://simple-books-api.glitch.me/books");
//        System.out.println(response.statusCode());
        System.out.println(response.asString());
        Assert.assertEquals("Test fail", 200, response.statusCode());

        JsonPath jsonPath = response.jsonPath();
        int size = jsonPath.getList("").size();
        System.out.println(size);
       String str = jsonPath.get("[1].name");
//        System.out.println(str);

        for (int i = 0; i < size; i++) {
            String names = jsonPath.get("["+i+"].name");
            System.out.println(names);
        }

    }

    @Test
    public void authorizationTest() {
        Response response = RestAssured.given()

                .header("Authorization", "Bearer 74db1034224bb3b9f1719c5af632d8df53445009df04592ba587607f4d22a63e")
                .get("https://simple-books-api.glitch.me/orders");
        System.out.println(response.statusCode());
    }

    @Test
    public void authorizationAirtable() {
        Response response = RestAssured.given()
                .header("Authorization","Bearer keyUciDKN0atCXT7w")
                .urlEncodingEnabled(false)
                .get("https://api.airtable.com/v0/appWfJf4mdJWAcc8v/Table%201");
        System.out.println(response.statusCode());

    }


}

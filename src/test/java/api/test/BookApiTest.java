package api.test;

import api.models.BookRecords;
import api.models.OrderBook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class BookApiTest {

    @Test
    public void createJsonObject() throws JsonProcessingException {
        BookRecords records = new BookRecords();

        records.setId("myId7859477");
        records.setBookId(16);
        records.setCustomerName("Andrew");
        records.setQuantity(10);

        ObjectMapper objectMapper = new ObjectMapper(); // this is coming from jackson library

        String recordJson = objectMapper.writeValueAsString(records);
        System.out.println(recordJson);

    }

    @Test
    public void submitAnOrder() throws  Exception{
        OrderBook orderBook = new OrderBook();
        orderBook.setBookId(5);
        orderBook.setCustomerName("Andrew");

        ObjectMapper objectMapper = new ObjectMapper();

        String recordJson = objectMapper.writeValueAsString(orderBook);
//        System.out.println(recordJson);

        Response response = RestAssured.given()
                .header("Authorization", "Bearer 74db1034224bb3b9f1719c5af632d8df53445009df04592ba587607f4d22a63e")
                .contentType(ContentType.JSON)
                .body(recordJson)
                .post("https://simple-books-api.glitch.me/orders/");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

    }
}

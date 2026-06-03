package api.requests;

import api.ApiBaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartApiTest extends ApiBaseTest {

    @Test
    public void testFullCartLifecycle() {

        String testSessionId = UUID.randomUUID().toString();

        String productId = "c0c7f40f-7419-47cb-8835-0350e5b01b07";

        given().header("x-session-id", testSessionId)
                .when().get("/cart")
                .then().statusCode(200);

        Map<String, Object> itemPayload = new HashMap<>();
        itemPayload.put("productId", productId);
        itemPayload.put("quantity", 1);

        Response addResponse = given()
                .contentType(ContentType.JSON)
                .header("x-session-id", testSessionId)
                .body(itemPayload)
                .when()
                .post("/cart/items")
                .then()
                .extract().response();

        System.out.println("Add Item Status: " + addResponse.statusCode());
        assertEquals(200, addResponse.statusCode(), "CRITICAL: Adding item to cart failed!");
        Response clearResponse = given()
                .header("x-session-id", testSessionId)
                .when()
                .delete("/cart")
                .then()
                .extract().response();

        System.out.println("Clear Cart Status: " + clearResponse.statusCode());
        assertEquals(200, clearResponse.statusCode(), "CRITICAL: Clearing the cart failed!");
    }
}
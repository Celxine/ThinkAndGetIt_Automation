package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AdminLoginApiTest {

    @BeforeAll
    public static void setup() {

        RestAssured.baseURI = "https://think-and-get-it-production.up.railway.app/api/v1";
    }

    @Test
    public void testAdminLoginSuccessfully() {

        String loginPayload = "{\n" +
                "  \"email\": \"admin@thinkandgetit.com\",\n" +
                "  \"password\": \"Admin@123456\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(loginPayload)
                .when()
                .post("/auth/login")
                .then()
                .extract()
                .response();

        assertEquals(200, response.statusCode(), "Expected status code 200 OK");
        String token = response.jsonPath().getString("data.token");

        assertNotNull(token, "The authentication token should not be null");

        System.out.println("Login Test Passed! Retrieved Token: " + token);
    }
}
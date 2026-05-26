package api;

import api.payloads.LoginRequest;
import api.requests.AuthApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AdminLoginApiTest extends ApiBaseTest {

    @Test
    public void testAdminLoginSuccessfully() {

        String rawJsonPayload = "{\n" +
                "  \"email\": \"admin1@thinkandgetit.com\",\n" +
                "  \"password\": \"Admin@123456\"\n" +
                "}";

        Response response = AuthApi.login(rawJsonPayload);

        assertEquals(200, response.statusCode(), "Expected status code 200 OK");
        String token = response.jsonPath().getString("token");
        assertNotNull(token, "The authentication token should not be null");

        System.out.println("Login Test Passed! Retrieved Token: " + token);
    }
}
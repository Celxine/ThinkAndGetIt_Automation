package api;

import api.payloads.LoginRequest;
import api.requests.AuthApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AdminLoginApiTest extends ApiBaseTest {

    @Test
    public void testAdminLoginSuccessfully() {


        Map<String, String> loginPayload = new HashMap<>();
        loginPayload.put("email", "admin@thinkandgetit.com");

        loginPayload.put("password", "your_password");


        Response response = AuthApi.login(loginPayload);

        assertEquals(200, response.statusCode(), "Expected status code 200 OK");
        String token = response.jsonPath().getString("token");
        assertNotNull(token, "The authentication token should not be null");

        System.out.println("Login Test Passed! Retrieved Token: " + token);
    }
}
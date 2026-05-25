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

        LoginRequest loginPayload = new LoginRequest("admin@thinkandgetit.com", "Admin@123456");


        Response response = AuthApi.login(loginPayload);
        assertEquals(200, response.statusCode(), "Expected status code 200 OK");

        String token = response.jsonPath().getString("data.token");
        assertNotNull(token, "The authentication token should not be null");

        System.out.println("Login Test Passed! Retrieved Token: " + token);
    }
}
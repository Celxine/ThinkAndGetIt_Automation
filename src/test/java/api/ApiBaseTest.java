package api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiBaseTest {

    @BeforeAll
    public static void setup() {

        RestAssured.baseURI = "https://think-and-get-it-production.up.railway.app/api/v1";
    }
}
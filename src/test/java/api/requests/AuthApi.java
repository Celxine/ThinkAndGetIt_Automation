package api.requests;

import api.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi {

    public static Response login(Object payload) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Endpoints.LOGIN)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
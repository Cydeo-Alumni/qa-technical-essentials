package api_review;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ReqResUsersTest {
    @Test
    public void getAllUsersTest() {
        Response response = RestAssured.given().accept("application/json").   ///and().header("x-api-key", "reqres-free-v1")
                when().get("https://reqres.in/api/users?page=2");
        response.prettyPrint();
        //-- Validate response
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        //"total": 12
        System.out.println(response.body().jsonPath().getInt("total"));
        Assert.assertEquals(response.body().jsonPath().getInt("total"), 12);
        Assert.assertEquals(response.body().jsonPath().getString("data[0].email"), "michael.lawson@reqres.in");
    }

    @Test
    public void getSpecificUserTest() {
        Response response = RestAssured.given().accept("application/json")
                .when().get("https://reqres.in/api/users/2");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(response.jsonPath().getInt("data.id"), 2);
        Assert.assertEquals(response.jsonPath().getString("data.email"), "janet.weaver@reqres.in");
        Assert.assertEquals(response.jsonPath().getString("data.first_name"), "Janet");
        Assert.assertEquals(response.jsonPath().getString("data.last_name"), "Weaver");
    }

    @Test
    public void createUserTest() {
        Map<String, String> userData = new HashMap<>();
        userData.put("name", "Tester");
        userData.put("job", "SDET");

        Response response = RestAssured.given().accept("application/json").contentType("application/json")
                .header("x-api-key", "reqres-free-v1")
                .and().body(userData) //serialization
                .when().post("https://reqres.in/api/users");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(response.jsonPath().getString("name"), "Tester");
        Assert.assertEquals(response.jsonPath().getString("job"), "SDET");
        Assert.assertEquals(response.jsonPath().getString("createdAt").split("T")[0], "2025-10-11");

    }
}

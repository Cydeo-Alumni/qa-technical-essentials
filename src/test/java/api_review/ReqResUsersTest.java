package api_review;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}

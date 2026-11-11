import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.Method;

public class GetMethod {

	@Test
	void getMethodAPI() {

		Response res = given()
				.header("Content-Type", "application/json")
				.when().request(Method.GET,
				"https://jsonplaceholder.typicode.com/posts/1");

		res.then().statusCode(200);

		System.out.println("Response Of Get Method -> " + res.asString());

		Assert.assertEquals(res.statusCode(), 200, "Status code is Wrong->");

		int idfromResponse = res.jsonPath().getInt("id");

		Assert.assertEquals(idfromResponse, 1, "ID in the respnse does not match with expected value -> ");

		String titleFromResponse = res.jsonPath().getString("title");

		Assert.assertEquals(titleFromResponse,
				"sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
				"ID in the respnse does not match with expected value -> ");

		// Assert.assertEquals(res.jsonPath().getString("id"),"1");

	}
}
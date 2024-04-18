package apiTest.apiTestingShiv;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class OauthTest {

	public static void main(String[] args) {
		String response = given().log().all()
				.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
				.formParam("grant_type", "client_credentials")
				.formParam("scope", "trust")
				.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
				.then()
				.log().all()
				.extract().response().asString();
				JsonPath js = new JsonPath(response);
				String token = js.get("access_token");
				given()
				.queryParam("access_token",token)
				.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
				.then().log().all();

	}

}

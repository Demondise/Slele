package apiTest.apiTestingShiv;

import org.codehaus.groovy.runtime.callsite.PojoMetaMethodSite.PojoCachedMethodSite;
import org.testng.annotations.Test;

import POJO.CourceDetails;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class PojoDeserialization {
	
	@Test
	public void authenticationTest() {
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
	
				
		CourceDetails courceDetails = given()
		.queryParam("access_token",token)
		.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
		.then().extract().response().as(CourceDetails.class);
		courceDetails.getCourses().getApi().stream().filter(s->s.getCourseTitle().contains("Rest Assured")).forEach(s->System.out.println(s.getCourseTitle()+" "+s.getPrice()));
	}
}

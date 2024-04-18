package apiTest.apiTestingShiv;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;

public class SimpleTest {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//put_location
		String response = given().queryParam("key", "qaclick123").header("Content-Type","application/json").body(Payload.getBody())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String place_id = js.get("place_id");
		//`System.out.println(place_id);
		//update location
		String place = "70 Summer walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+place+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json")
		.then().log().all();
		//get_location
				String responce2 = given().log().all().queryParam("key", "qaclick123").queryParam("place_id",place_id).when().get("maps/api/place/get/json").then().log().all().extract().response().asString();
				JsonPath js1 = new JsonPath(responce2);
				String placeResp = js1.get("address");
				Assert.assertEquals(place, placeResp);
		//delete location
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\"70 Summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().delete("maps/api/place/delete/json").then().log().all();
		
		
	}

}

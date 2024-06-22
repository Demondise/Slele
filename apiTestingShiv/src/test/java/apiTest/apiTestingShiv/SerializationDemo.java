package apiTest.apiTestingShiv;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import PojoMaps.Location;
import PojoMaps.Place;
import files.Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SerializationDemo {

	@Test
	public void serialDemo() {
		Place place = new Place();
		Location location = new Location();
		location.setLat("-38.383494");
		location.setLng("33.427362");
		place.setLocation(location);
		place.setAccuracy("50");
		place.setName("Frontline house");
		place.setPhone_number("(+91) 983 893 3937");
		place.setAddress("29, side layout, cohen 09");
		List <String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		place.setTypes(types);
		place.setWebsite("http://google.com");
		place.setLanguage("French-IN");
		
		RequestSpecification specBuilder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
				.build();
		ResponseSpecification respBuilder = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).expectHeader("Server", "Apache/2.4.52 (Ubuntu)").build();
		
		//put_location
		String response = given().spec(specBuilder).body(place)
		.when().post("maps/api/place/add/json")
		.then().spec(respBuilder).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String place_id = js.get("place_id");
		//`System.out.println(place_id);
		//update location
		String placeName = "70 Summer walk, USA";
		given().log().all().spec(specBuilder).body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+place+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json")
		.then().log().all();
	}

}

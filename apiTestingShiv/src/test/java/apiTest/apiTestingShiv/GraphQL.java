package apiTest.apiTestingShiv;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

import java.util.Scanner;

import io.restassured.path.json.JsonPath;
public class GraphQL {
	static int locationId;
	static int episodeId;
	static int characterId;
	public static void main(String[] args) {
	   given().header("Content-type","application/json").body("{\"query\":\"query($Name:String!) {\\n  locations(filters: {name: $Name}) {\\n    info {\\n      count\\n    }\\n     result {\\n        id\\n      }\\n  }\\n  location(locationId:8776){\\n    dimension\\n  }\\n}\\n\",\"variables\":{\"Name\":\"Noida Sec 126\"}}")
				.when().post("https://www.rahulshettyacademy.com/gq/graphql").then().log().all();
		
//		initializeVars();
//		String response = given().header("Content-type","application/json").body("{\"query\":\"mutation($characterId:Int!, $episodeId:Int!,$locationId:Int!) {\\n  createLocation(location: {name: \\\"Noida\\\", type: \\\"Work\\\", dimension: \\\"Square\\\"}) {\\n    id\\n  }\\n  createCharacter(character: {name: \\\"Shivam\\\", type: \\\"Cool\\\", status: \\\"Single\\\", species: \\\"Humans\\\", gender: \\\"male\\\", image: \\\"img\\\", originId: 8766, locationId: 8766}) {\\n    id\\n  }\\n  createEpisode(episode:{name:\\\"Bleach\\\", air_date:\\\"2012\\\", episode:\\\"Love is in the air\\\"}){\\n    id\\n  }\\n  associateEpisodeCharacter(episodeId:$episodeId,characterId:$characterId){\\n    status\\n  }\\n  editLocation(locationId:$locationId,newLocationData:{name:\\\"Noida Sec 126\\\"}){\\n    status\\n  }\\n}\\n\",\"variables\":{\"characterId\":"+characterId+",\"episodeId\":"+episodeId+",\"locationId\":"+locationId+"}}")
//		.when().post("https://www.rahulshettyacademy.com/gq/graphql").then().log().all().extract().response().asString();
//		JsonPath js = new JsonPath(response);
//		int i = js.get("data.editLocation.status");
//		locationId = js.getInt("data.createLoation.id");
//		characterId = js.getInt("data.createCharacter.id");
//		episodeId = js.getInt("data.createEpisode.id");
//		assertTrue(i==1);
	}
	public static void initializeVars() {
			Scanner sc = new Scanner(System.in);
			locationId = sc.nextInt();
			characterId = sc.nextInt();
			episodeId = sc.nextInt();
	}

}

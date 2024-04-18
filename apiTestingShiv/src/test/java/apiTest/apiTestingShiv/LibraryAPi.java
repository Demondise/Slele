package apiTest.apiTestingShiv;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
public class LibraryAPi {
	String bookid;
	String bookName;
	
	@Test
	public void addBook() {
		 RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().header("Content-Type","application/json").body(Payload.getBook())
						 .when().post("Library/Addbook.php")
						 .then().log().all().extract().response().asString();
		JsonPath js =  new JsonPath(response);
		bookid = js.get("ID");
		
	}
	@Test(dependsOnMethods = "addBook")
	public void getBookByName() {
		RestAssured.baseURI = "http://216.10.245.166";
		given().queryParam("AuthorName", "John foe")
		.when().get("Library/GetBook.php").then().log().all();
	}
	@Test(dependsOnMethods = "addBook")
	public void getBookById() {
		RestAssured.baseURI = "http://216.10.245.166";
		given().queryParam("ID", bookid)
		.when().get("Library/GetBook.php").then().log().all();
	}
	@Test(dependsOnMethods = "addBook")
	public void deleteBook() {
		RestAssured.baseURI = "http://216.10.245.166";
		given().header("Content-Type","application/json").body("{\r\n"
				+ " \r\n"
				+ "\"ID\" : \"bcd227\"\r\n"
				+ " \r\n"
				+ "}\r\n"
				+ "")
		.when().get("Library/DeleteBook.php").then().log().all();
	}
}

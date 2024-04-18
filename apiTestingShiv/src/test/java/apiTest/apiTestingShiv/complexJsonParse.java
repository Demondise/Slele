package apiTest.apiTestingShiv;

import org.testng.Assert;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class complexJsonParse {
	public static void main(String[] args) {
		JsonPath js = new JsonPath(Payload.courcePrice());
//		Print No of courses returned by API
		int j = js.get("courses.size()");
		System.out.println(j);
//		Print Purchase Amount
		int pucrchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(pucrchaseAmount);
//		Print Title of the first course
		String titleFistCourse = js.get("courses[0].title");
		System.out.println(titleFistCourse);
//		Print All course titles and their respective Prices
		int totalPrice = 0;
		for (int i = 0; i < j; i++) {
			String title = js.get("courses[" + i + "].title");
			System.out.println(title);
//		Print no of copies sold by RPA Course
			int copies = js.getInt("courses[" + i + "].copies");
			if (title.equalsIgnoreCase("RPA")) {
				System.out.println(copies);
			}
//			Verify if Sum of all Course prices matches with Purchase Amount
			int prices =  js.getInt("courses[" + i + "].price");
			totalPrice += copies * prices;

		}
		System.out.println(totalPrice);
		Assert.assertEquals(pucrchaseAmount, totalPrice);

	}

}

package apiTest.apiTestingShiv;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import PojoE2E.LoginPage;
import PojoE2E.LoginResponse;
import PojoE2E.OrderDetails;
import PojoE2E.OrderList;
import PojoE2E.Orders;

public class E2eApiTest {

	public static void main(String[] args) {
		RequestSpecification req = new RequestSpecBuilder().setRelaxedHTTPSValidation().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		LoginPage login =  new LoginPage();
		login.setUserEmail("ss367940@gmail.com");
		login.setUserPassword("Shivam@123");
		
		ResponseSpecification resp = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		RequestSpecification reqLogin = given().spec(req).body(login);
		LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().spec(resp).extract().as(LoginResponse.class);
		String token = loginResponse.getToken();
		System.out.println(token);
		String userId = loginResponse.getUserId();
		RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addFormParam("productName", "qwerty").addFormParam("productAddedBy", userId)
				.addFormParam("productCategory", "fashion").addFormParam("productSubCategory","shirts").addFormParam("productPrice", "11500").addFormParam("productDescription", "Addias Originals")
				.addFormParam("productFor", "women").addMultiPart("productImage", new File("C:\\Users\\shivam_shar\\Downloads\\JenkinsScedule.png")).addHeader("Authorization", token).build();
		String respAddProduct = given().spec(addProductBaseReq).when().post("/api/ecom/product/add-product").then().extract().response().asString();
		JsonPath jsp =  new JsonPath(respAddProduct);
		String productid = jsp.get("productId");
		System.out.println(productid);
		RequestSpecification createOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).setContentType(ContentType.JSON).build();
		Orders orders =  new Orders();
		OrderList orderli =  new OrderList();
		orderli.setCountry("India");
		orderli.setProductOrderedId(productid);
		List<OrderList> orderList = new ArrayList<OrderList>();
		orderList.add(orderli);
		orders.setOrders(orderList);
		RequestSpecification createOrder = given().log().all().spec(createOrderBaseReq).body(orders);
		String orderPlaced = createOrder.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
		JsonPath jsp2 = new JsonPath(orderPlaced);
		List <String> orderIds = jsp2.get("orders");
		String orderId = orderIds.get(0);
		
		RequestSpecification OrderRec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("id", orderId).addHeader("Authorization", token).build();
		OrderDetails details = given().spec(OrderRec).get("/api/ecom/order/get-orders-details").then().extract().response().as(OrderDetails.class);
		System.out.println(details.getMessage());
		RequestSpecification delOrderRec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addPathParam("productId", productid).addHeader("Authorization", token).build();

		given().spec(delOrderRec).delete("/api/ecom/product/delete-product/{productId}").then().log().all();
		

		
	}

}

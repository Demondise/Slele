package apiTest.apiTestingShiv;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import groovy.transform.ToString;
public class OAuth2 {
	public static void main(String[] args) {
//		
//		given().queryParam("scope","https://www.googleapis.com/auth/userinfo.email").queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//		.queryParam("state","shivam").queryParam("auth_uri","https://accounts.google.com/o/oauth2/v2/auth").queryParam("redirect_uri"+"https://rahulshettyacademy.com/getCourse.php")
//		.queryParam("response_type"+"code").when().post("https://accounts.google.com/o/oauth2/v2/auth");
		String resp = given().urlEncodingEnabled(false).queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W").queryParam("grant_type","authorization_code")
		.queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParam("code","4%2F0AeaYSHBiOmhNOKd0t1x2KvzKSDLYPb5OCezU75Qzfe20is6by4aeJ5TtNK0W3ejuDHwiDg").when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();
		System.out.println(resp);
	}

}

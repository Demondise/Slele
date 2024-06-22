package StepDefs;

import com.github.dockerjava.transport.DockerHttpClient.Request;

import DI.ApiDi;
import POJO.DataFetcher;
import POJO.LoginCreds;
import abstractComponents.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class ApiStepDefs {
	ApiDi di;
	DataFetcher data;
	ValidatableResponse request;
	ApiStepDefs(ApiDi di){
		this.di = di;
	}
	RequestSpecification req ;	
	@Given("{string} data payload is added")
	public void login_data_payload_is_added(String dataType) {
	    data = new DataFetcher(dataType);
	    if
	    data.setEmail(di.getProp().getProperty("email"));
	    login.setPassword(di.getProp().getProperty("password"));
	}

	@When("user calls {string} api with {string} http request")
	public void user_calls_api_with_http_request(String apiRes, String httpReq) {
	    ApiResources apiReqs = ApiResources.valueOf(apiRes);
	    ValidatableResponse request=null;
	    if(httpReq.equals("post")) {
	    	request = di.getReq().body(login).when().post(apiReqs.getResource()).then();
	    }
	}

	@Then("{string} in the response is {string}")
	public void in_the_response_is(String string, String string2) {
	    
	}
	


}

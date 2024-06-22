package DI;

import java.util.Properties;

import io.restassured.specification.RequestSpecification;

public class ApiDi {
	Properties prop;
	RequestSpecification req ;

	public RequestSpecification getReq() {
		return req;
	}

	public void setReq(RequestSpecification req) {
		this.req = req;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
}

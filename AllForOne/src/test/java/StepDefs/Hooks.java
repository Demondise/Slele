package StepDefs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import DI.ApiDi;
import DI.TextcContext;
import DriverManager.DriverSingleTon;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.given;

public class Hooks {
	TextcContext di;
	ApiDi apiDi;

	public Hooks(TextcContext di,ApiDi apiDi) {
		this.di = di;
		this.apiDi = apiDi;
	}
	@Before("@api")
	public void setupApi(Scenario scn) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("C:\\Users\\shivam_shar\\eclipse-workspace\\AllForOne\\src\\test\\resources\\Config.properties")));
		apiDi.setProp(prop);
		RequestSpecification req = given().baseUri(prop.getProperty("baseUrl")).header("Content-Type","application/json");
		apiDi.setReq(req);
		
	}
	@Before("@ui")
	public void setUp(Scenario scn) {
		DriverSingleTon manager = DriverSingleTon.getInstance();
		di.setDriver(manager.initDriver());
		manager.setImplicitWait(10);
		di.setScn(scn);
		di.setConfig(manager.getConfig());
		di.initPageObj();
	}
	@After("@ui")
	public void wrapUp(Scenario scn) {
		if(scn.isFailed()) {
			di.getHomePage().getFullScreenShot();
		}
		di.getDriver().quit();
	}

}

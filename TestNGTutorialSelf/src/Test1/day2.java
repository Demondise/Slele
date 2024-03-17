package Test1;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class day2 {
	@Parameters({"Url","Password"})
	@Test
	public void shivam(String url,String password) {
		System.out.println(url + " "+password);
	}
	@BeforeClass
	public void BeforeClass1(){
		System.out.println("beforeClass");
	}
	@Test
	public void webTestHomeLoan() {
		System.out.println("webTestHomeLoan");
	}
	@Test(groups= {"smoke"})
	public void mobileTestHomeLoan() {
		System.out.println("mobileTestHomeLoan");
	}
	@Test
	public void apiTestHomeLoan() {
		System.out.println("apiTestHomeLoan");
	}
	@BeforeMethod
	public void beforMethod() {
		System.out.println("beforeMethod");
	}
	@AfterMethod
	public void AfterMethod() {
		System.out.println("afterMethod");
	}
	@BeforeTest
	public void beforeTest1() {
		System.out.println("beforeTest");
	}
	
	
	@AfterTest
	public void afterTest2() {
		System.out.println("afterTest");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSUite");
	}
	@AfterClass
	public void afterClass1() {
		System.out.println("afterClass");
	}
	
	

	
}

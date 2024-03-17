package Test1;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {
	@Test(groups= {"smoke"})
	public void webTestCarLoan() {
		System.out.println("webTestCarLoan");
	}
	@Test(groups= {"smoke"})
	public void mobileTestCarLoan() {
		System.out.println("mobileTestCarLoan");
	}
	@Test
	public void apiTestCarLoan() {
		System.out.println("apiTestCarLoan");
	}
	@Parameters({"Ding"})
	@Test
	public void Dinging(String Ding) {
		System.out.println(Ding);
	}
	@Test
	public void Demo()
	{
		System.out.println("hello");//automation
		Assert.assertTrue(false);
	}
}

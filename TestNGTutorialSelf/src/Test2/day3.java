package Test2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day3 {
	@Test
	public void webTestPersonalLoan() {
		System.out.println("webTestPersonalLoan");
	}
	@Test
	public void mobileTestPersonalLoan() {
		System.out.println("mobileTestPersonalLoan");
	}
	@Test(dependsOnMethods = {"webTestPersonalLoan","mobileTestPersonalLoan"})
	public void apiTestPersonalLoan() {
		System.out.println("apiTestPersonalLoan");
	}
	@Test(enabled = false)
	public void enabledMeth() {
		System.out.println("Skipped");
	}
	@Test(timeOut = 4000)
	public void timeoutMeth() {
		System.out.println("TimeOut");
	}
	@DataProvider
	public Object[][] getData() {
		//1st combiantion - username password - good credit history= row
				//2nd - username password  - no crdit history
				// 3rd - fraudelent credit history
				Object[][] data= new Object[3][2];
				//1st set 
				data[0][0]="firstsetusername";
				data[0][1]="firstpassword";
				//couloumns in the row are nothing but values for that particualar combination(row)
				
				//2nd set
				data[1][0]= "secondsetusername";
				data[1][1]= "secondpassword";
				
				//3rd set
				data[2][0]="thirdsetusername";
				data[2][1]="thirdpassword";
				return data;
	    
	    
	}
	@Test(dataProvider = "getData")
	public void nono(String username, String password) {
		System.out.println(username+"  "+ password);
	}
	
}

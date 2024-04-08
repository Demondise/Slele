package PageFactoryClasses;

import org.testng.annotations.Test;

import frameWorkComponents.BaseTest;

public class TestCases extends BaseTest {

	@Test
	public void addtocartTest() throws InterruptedException {
		HomePage homepage = loginpage.singnIn("shivamtest9899@gmail.com", "Shivam@123");
		SearchResultsPage srp = homepage.searchProduct("macbook");
		srp.addProductToCart("macbook");
		srp.goToCartPage();
		Thread.sleep(10000);
		
	}
	
}

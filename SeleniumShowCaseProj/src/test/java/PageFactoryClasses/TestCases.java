package PageFactoryClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameWorkComponents.BaseTest;

public class TestCases extends BaseTest {

	@Test
	public void addtocartTest() throws InterruptedException {
		HomePage homepage = loginpage.singnIn("shivamtest9899@gmail.com", "Shivam@123");
		SearchResultsPage searchPage = homepage.searchProduct("macbook");
		String productName = searchPage.addProductToCart("macbook");
		CartPage cartPage = searchPage.goToCartPage();
		Assert.assertTrue(cartPage.cartProductMatch(productName));
	}
	
}

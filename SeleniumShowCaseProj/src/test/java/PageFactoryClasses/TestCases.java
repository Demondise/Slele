package PageFactoryClasses;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import frameWorkComponents.BaseTest;
import frameWorkComponents.FrameworkUtils;
import frameWorkComponents.RetryAnalyzer;

public class TestCases extends BaseTest implements FrameworkUtils {
    
	//Flaky test retry using iretryanalyzer interface
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void addtocartTest() throws InterruptedException {
		HomePage homepage = loginpage.singnIn(prop.getProperty("email"), prop.getProperty("password"));
		SearchResultsPage searchPage = homepage.searchProduct("macbook");
		String productName = searchPage.addProductToCart("macbook");
		CartPage cartPage = searchPage.goToCartPage();
		Assert.assertTrue(cartPage.cartProductMatch(productName));
	}
	//Testcase with parameters derived from XML.
	@Parameters({"email","password","pincode"})
	@Test()
	public void changeDileveryLocationTest(String email, String password, String pincode) throws InterruptedException {
		HomePage homepage = loginpage.singnIn(email, password);
		homepage.deliveryLocationChange(pincode);
		Assert.assertTrue(homepage.deliveryLocationCheck(pincode));
	}
	//Testcase with multiple sets of data using data provider method.
	@Test(dataProvider = "getData")
	public void addtocartWithFilter(HashMap<String, String> map) throws InterruptedException {
		HomePage homepage = loginpage.singnIn(prop.getProperty("email"), prop.getProperty("password"));
		SearchResultsPage searchPage = homepage.searchProduct(map.get("product"));
		searchPage.filterItem(map.get("filter"));
		String productName = searchPage.addProductToCart(map.get("product"));
		CartPage cartPage = searchPage.goToCartPage();
		Assert.assertTrue(cartPage.cartProductMatch(productName));
	}
	@DataProvider
	public Object[] getData() throws IOException{
		List<HashMap<String, String>> data = getDataJson();
		return data.toArray();
		
	}
	
}

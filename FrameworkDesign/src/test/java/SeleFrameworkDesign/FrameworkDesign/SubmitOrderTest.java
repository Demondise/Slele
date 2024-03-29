package SeleFrameworkDesign.FrameworkDesign;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleFrameworkDesign.Test.BaseTest;
import SeleFrameworkDesign.abstractComponents.frameworkUtils;
import SeleFrameworkDesign.pageFoctoryObjects.CartPage;
import SeleFrameworkDesign.pageFoctoryObjects.LoginPage;
import SeleFrameworkDesign.pageFoctoryObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest implements frameworkUtils {
	
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider = "getData", groups = {"dataprovider"})
	 public void submitOrderTest( HashMap<String, String> map) throws FileNotFoundException, IOException, InterruptedException{
		// TODO Auto-generated method stub
		ProductCatalogue productCatalogue = getLoginPage().loginApplication(map.get("email"), map.get("password"));
		productCatalogue.addProductToCart(map.get("productName"));
		boolean match = productCatalogue.cart(map.get("productName"));
		Assert.assertTrue(match);
		CartPage cartPage = productCatalogue.cartCeckOut(b);
		cartPage.selectCountry(b);
		cartPage.placeOrder(b);
		String confirmMessage = cartPage.checkMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}
	@Test(dependsOnMethods = {"submitOrderTest"},groups = {"ErrorHandling"})
	public void productOrderCheck() throws FileNotFoundException, IOException, InterruptedException {
		ProductCatalogue productCatalogue = getLoginPage().loginApplication("anshika@gmail.com", "Iamking@000");
		boolean match = productCatalogue.orders(productName);
		Assert.assertTrue(match);
	}
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap<Object, Object> map1 = new HashMap<Object, Object>();
//		map1.put("email", "anshika@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("productName", "ZARA COAT 3");
//		HashMap<Object, Object> map2 = new HashMap<Object, Object>();
//		map2.put("email", "ss367940@gmail.com");
//		map2.put("password", "Shivam@123");
//		map2.put("productName", "IPHONE 13 PRO");
		List<HashMap<String, String>> data = getDataJason();
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}

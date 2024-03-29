package SeleFrameworkDesign.FrameworkDesign;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleFrameworkDesign.Test.BaseTest;
import SeleFrameworkDesign.pageFoctoryObjects.ProductCatalogue;

public class ErrorValidationTests extends BaseTest {

	@Test(groups = {"ErrorHandling"})
	public void wrongId() throws FileNotFoundException, IOException, InterruptedException {
		getLoginPage().loginApplication("anshikaa@gmail.com", "Iamking@000");
		Assert.assertEquals(getLoginPage().checkToast(),"Incorrect email or password.");
	}
	@Test(groups = {"ErrorHandling"})
	public void wrongPassword() throws FileNotFoundException, IOException, InterruptedException {
		getLoginPage().loginApplication("anshikaa@gmail.com", "Iamking@000");
		Assert.assertEquals(getLoginPage().checkToast(),"Incorrect email or password.");
	}
	@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void productCartCheck() throws FileNotFoundException, IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = getLoginPage().loginApplication("anshika@gmail.com", "Iamking@000");
		productCatalogue.addProductToCart(productName);
		boolean match = productCatalogue.cart(productName);
		Assert.assertTrue(match);
	}
	
	
}

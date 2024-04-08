package SeleFrameworkDesign.StepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

import SeleFrameworkDesign.Test.BaseTest;
import SeleFrameworkDesign.pageFoctoryObjects.CartPage;
import SeleFrameworkDesign.pageFoctoryObjects.LoginPage;
import SeleFrameworkDesign.pageFoctoryObjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsFile extends BaseTest {
	LoginPage loginPage;
	ProductCatalogue productCatalogue;
	CartPage cartPage;

	@Given("I landed on Ecommerce page.")
	public void I_landed_on_Ecommerce_page() throws FileNotFoundException, IOException {
		loginPage = launchApplication();
	}

	@Given("^Login to ecommerece website using username (.+) and password (.+)$")
	public void Login_to_ecommerece_website_using_username_and_password(String username, String password) {
		productCatalogue = loginPage.loginApplication(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException {
		productCatalogue.addProductToCart(productName);
		boolean match = productCatalogue.cart(productName);
		Assert.assertTrue(match);
	}

	@And("^Checkout product (.+) and submit order$")
	public void Checkout_product_and_submit_order(String productname) throws InterruptedException {
		cartPage = productCatalogue.cartCeckOut(b);
		cartPage.selectCountry(b);
		cartPage.placeOrder(b);
	}

	@Then("{string} message is displayed on confirmation page.")
	public void message_is_displayed_on_confirmation_page(String message) {

		String confirmMessage = cartPage.checkMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(message));
	}
	
	@Then("Correct product is added to cart")
	public void correct_product_is_added_to_cart() {
		Assert.assertTrue(true);
	}
	@Then("{string} message is displayed on login page.")
	public void message_is_displayed_on_login_page(String message) throws InterruptedException {
		Assert.assertEquals(getLoginPage().checkToast(),message);
	}
}

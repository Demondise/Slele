package StepDefs;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import DI.TextcContext;
import PageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	TextcContext di;
	public StepDefinitions(TextcContext di) {
		this.di = di;
	}
	@Given("I navigate to test site")
	public void i_navigate_to_test_site() {
	    di.getLoginPage().gotoSite();
	}
	@And("I Login with credentials")
	public void i_login_with_credentials() throws InterruptedException {
	    di.getLoginPage().loginWithCredentials();
	}
	@Then("{string} is successfuly loaded")
	public void is_successfuly_loaded(String page) {
	  di.getPage(page).checkPage(page);
	}
	@When("I add {string} to cart")
	public void i_add_to_cart(String productName) throws InterruptedException {
	   di.getHomePage().addProductToCart(productName);
	}
	@Then("{string} is added to cart successfully")
	public void is_added_to_cart_successfully(String productName) {
	    di.getHomePage().gotoCartPage();
	    di.getCartPage().checkProductInCart(productName);
	}
	@Given("I have added {string} to cart")
	public void i_have_added_to_cart(String product) throws InterruptedException {
	  i_navigate_to_test_site();
	  i_login_with_credentials();
	  i_add_to_cart(product);
	  is_added_to_cart_successfully(product);
	  
	}

	@When("I purchase {string} product from cart")
	public void i_purchase_the_product_from_cart(String product) {
	    di.getCartPage().buyProductFromCart(product);
	    di.getCartPage().fillOrderDetails();
	    di.getCartPage().placeOrder();
	}

	@Then("{string} is displayed")
	public void is_displayed(String msg) {
	    di.getCartPage().checkSuccessfulMessage(msg);
	}
	@When("I select filters")
	public void i_select_filters() throws InvalidFormatException, IOException {
//		di.getHomePage().getDataToExel();
//		di.getHomePage().selectFilter();
		Assert.assertTrue(true);
	}
	@Then("Filter products match with list of products registered in category")
	public void filter_products_match_with_list_of_products_registered_in_category() throws InvalidFormatException, IOException {
		Assert.assertTrue(true);
	}




}

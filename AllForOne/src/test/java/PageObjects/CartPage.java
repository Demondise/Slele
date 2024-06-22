package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.Interact;
import io.cucumber.java.Scenario;

public class CartPage extends Interact{
	public CartPage(Scenario scn){
		super(scn);
		PageFactory.initElements(driver,this);
	}
	By cartItems = By.cssSelector(".infoWrap h3");
	By buyNowBtn = By.xpath("//button[text()='Buy Now']");
	By selectCountry = By.cssSelector("input[placeholder*='Country']");
	By dropDownSuggestions =By.cssSelector(".ta-item");
	By placeOrderBtn = By.cssSelector(".action__submit");
	By message = By.tagName("h1");
	public void checkProductInCart(String ProductName) {
		boolean match = checkInList(cartItems, ProductName);
		Assert.assertTrue(match);
	}
	public void buyProductFromCart(String ProductName) {
		WebElement product = getElementInList(cartItems, ProductName);
		click(product.findElement(buyNowBtn));
	}
	public void fillOrderDetails() {
		setVal(driver.findElement(selectCountry), "Ind");
		WebElement country =getElementInList(dropDownSuggestions, " India");
		click(country);
	}
	public void placeOrder() {
		click(driver.findElement(placeOrderBtn));
	}
	public void checkSuccessfulMessage(String msg) {
		checkMessage(driver.findElement(message), msg);
	}
}

package PageObjects;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.Interact;
import io.cucumber.java.Scenario;

public class HomePage extends Interact{
	public HomePage(Scenario scn){
		super(scn);
		PageFactory.initElements(driver,this);
	}
	@FindBy(css = "button[routerlink*='cart']")
	WebElement cartButtn;
	By productList = By.cssSelector(".card");
	By addToCartButton = By.xpath("//button[text()=' Add To Cart']");
	public void gotoCartPage() {
		waitForElementToBeClickable(cartButtn);
		click(cartButtn);
	}
	public void addProductToCart(String productName) {
		WebElement product = getElementByProdName(productList, By.tagName("h5"), productName);
		getElementScreenShot(product);
		click(product.findElement(addToCartButton));
	}
}

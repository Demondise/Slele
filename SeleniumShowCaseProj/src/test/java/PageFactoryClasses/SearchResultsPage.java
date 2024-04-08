package PageFactoryClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkComponents.AbstractComponents;

public class SearchResultsPage extends AbstractComponents {
	WebDriver driver;
	public SearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css = "div[class*='card']")
	List<WebElement> searchResults;
	By addtocart = By.tagName("button");
	
	
	public void addProductToCart(String ProductName) {
		WebElement product = searchResults.stream().filter(s->s.findElement(By.tagName("h2")).getText().toLowerCase().contains(ProductName)).findFirst().get();
		actionsFW.moveToElement(product.findElement(addtocart));
		product.findElement(addtocart).click();
		//js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		product.findElement(addtocart).click();
		wait.until(ExpectedConditions.elementToBeClickable(product.findElement(addtocart)));
		
	}
	public CartPage goToCartPage() {
		
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}

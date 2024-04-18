package PageFactoryClasses;

import java.util.List;
import java.util.Optional;

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
	By productTitle = By.cssSelector("span[Class*=a-text-normal]");
	@FindBy(css ="div[id*='s-refinements'] li")
	List<WebElement> filterBy;
	
	
	public String addProductToCart(String ProductName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
		WebElement product = searchResults.stream().filter(s->s.findElement(By.tagName("h2")).getText().toLowerCase().contains(ProductName)).findFirst().get();
		//actionsFW.moveToElement(product.findElement(addtocart));
		String prodName = product.findElement(productTitle).getText();
		product.findElement(addtocart).click();
//		//js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
//		product.findElement(addtocart).click();
    	wait.until(ExpectedConditions.elementToBeClickable(product.findElement(addtocart)));
    	return prodName;
		
	}
	public CartPage goToCartPage() {
		
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	public void filterItem(String filter) {
	 WebElement filterSelected = filterBy.stream().filter(s->s.getText().contains(filter)).findFirst().orElse(null);
	 filterSelected.click();
	}
}

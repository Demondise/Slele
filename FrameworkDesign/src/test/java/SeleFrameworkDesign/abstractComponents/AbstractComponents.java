package SeleFrameworkDesign.abstractComponents;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleFrameworkDesign.pageFoctoryObjects.CartPage;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orders;
	@FindBy(css = ".cartSection h3" )
	List<WebElement> cartProducts;
	@FindBy(css = ".totalRow button" )
	WebElement checkOut;
	@FindBy(css = "tr td:nth-child(3)" )
	List<WebElement> orderedProducts;
	public void waitForVisibilityOfElement(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
public void waitForVisibilityOfElement(WebElement ele) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForInVisibilityOfElement(By findby) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
		Thread.sleep(1000);
	}
	public void waitForInVisibilityOfElement(WebElement ele) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public boolean cart(String productName) {
		cart.click();
		boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	public boolean orders(String productName) {
		orders.click();
		boolean match = orderedProducts.stream().anyMatch(s->s.getText().equals(productName));
		return match;
	}
	public CartPage cartCeckOut(Actions b) throws InterruptedException {
		Thread.sleep(2000);
		b.moveToElement(checkOut).build().perform();
		checkOut.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}

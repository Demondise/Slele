package PageObjects;


import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import POJO.Product;
import POJO.ProductBuilder;
import POJO.Products;
import Utils.ExelDataManager;
import Utils.ExelDataManager;
import abstractComponents.Interact;
import io.cucumber.java.Scenario;

public class HomePage extends Interact{
	String name;
	String priiceprod;
	public HomePage(Scenario scn){
		super(scn);
		PageFactory.initElements(driver,this);
	}
	@FindBy(css = "button[routerlink*='cart']")
	WebElement cartButtn;
	@FindBy(css = "#sidebar label[for='cat']")
	List<WebElement> category;
	@FindBy(css = "#sidebar label[for='sub']")
	List<WebElement> subCategory;
	@FindBy(css = "#sidebar label[for='ge']")
	List<WebElement> gender;
	By productCards = By.cssSelector(".card-body");
	By productName = By.cssSelector("h5");
	By price = By.cssSelector("div div");
	@FindBy(id="res")
	WebElement resultCount;
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
	public void getDataToExel() throws InvalidFormatException, IOException {
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productCards));
		List<WebElement> li = driver.findElements(productCards).stream().map(s->s.findElement(productName)).collect(Collectors.toList());
		List<WebElement> priceList = driver.findElements(productCards).stream().map(s->s.findElement(price)).collect(Collectors.toList());
		ProductBuilder builder = new ProductBuilder();
		AtomicInteger count = new AtomicInteger(0);
		List<Product> prod = new ArrayList<Product>();
		li.stream().forEach(s->{
			prod.add(builder.name(s.getText()).price(priceList.get(count.getAndIncrement()).getText()).build());
			});
		prod.stream().forEach(s->{System.out.println(s.getProductName()+" "+s.getPrice());});
		Products products = new Products();
		products.setProducts(prod);
		ExelDataManager.setDataExel(products);
		}
	public void selectFilter() {
		category.stream().forEach(s->{
			clickCheckBox(s);
			
			if(!resultCount.getText().contains("0")) clickCheckBox(s);
			});
		w.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(productCards)));
		 name = driver.findElement(productCards).findElement(productName).getText();
		 priiceprod=driver.findElement(productCards).findElement(price).getText();
		
	}
	public void checkProds() throws InvalidFormatException, IOException {
		Products prods = ExelDataManager.getDataExel();
	Assert.assertTrue(prods.getProducts().stream().anyMatch(s->s.getPrice()==priiceprod&&s.getProductName()==name));
	}
	}

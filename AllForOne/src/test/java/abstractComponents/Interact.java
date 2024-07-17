package abstractComponents;

import java.io.File;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.events.CollectionEndEvent;

import DriverManager.DriverSingleTon;
import io.cucumber.java.Scenario;

public class Interact {
	protected WebDriver driver;
	protected Scenario scn;
	protected Properties config;
	protected DriverSingleTon manager;
	protected WebDriverWait w;
	Actions a;
	public Interact (Scenario scn) {
		manager = DriverSingleTon.getInstance();
		this.driver =  manager.getDriver();
		this.config = manager.getConfig();
		this.scn = scn;
		w = new WebDriverWait(driver,Duration.ofSeconds(8));
	    a = new Actions(driver);
	}
	public void gotoSite() {
		driver.get(config.getProperty("url"));
	}
	public void setVal(WebElement ele, String text) {
		waitForElementToBeClickable(ele);
		ele.sendKeys(text);
	}
	public void click(WebElement ele) {
		a.moveToElement(ele).build().perform();
		waitForElementToBeClickable(ele);
		ele.click();
	}
	public void waitForElementToBeClickable(WebElement ele) {
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public String getProp(String key) {
		return config.getProperty(key);
	}
	public boolean checkElementDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}
	public void checkPage(String page) {
		Assert.assertTrue(driver.getTitle().toLowerCase().contains(getProp(page + "Title"))) ;
	}
	public void waitForPresenseOfElement(By elementLists) {
		w.until(ExpectedConditions.presenceOfElementLocated(elementLists));
	}
	public WebElement getElementByProdName(By products,By nameSelector,String productName) {
		waitForPresenseOfElement(nameSelector);
		WebElement ele = driver.findElements(products).stream().filter(s->s.findElement(nameSelector).getText().equals(productName)).findAny().orElse(null);
	    return ele;
	 }
	public boolean checkInList(By productList,String prod) {
		return driver.findElements(productList).stream().anyMatch(s->s.getText().contains(prod));
	}
	public void getFullScreenShot() {
		byte[] sc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scn.attach(sc, "image/png", "View");
	}
	public void getElementScreenShot(WebElement ele) {
		
		byte[] sc = ((TakesScreenshot)ele).getScreenshotAs(OutputType.BYTES);
		scn.attach(sc, "image/png", "Element View");
	}
	public WebElement getElementInList(By productList,String prod) {
		return driver.findElements(productList).stream().filter(s->s.getText().contains(prod)).findFirst().orElse(null);
	}
	public void checkMessage(WebElement ele,String msg) {
		Assert.assertTrue(ele.getText().contains(msg));
	}
	public List<String> getElementsText(List<WebElement> eles){
	return eles.stream().map(s->s.getText()).collect(Collectors.toList());
	}
	public void clickCheckBox(WebElement ele) {
		waitForElementToBeClickable(driver.findElement(with(By.tagName("input")).near(ele)));
		click(driver.findElement(with(By.tagName("input")).near(ele)));
	}
}

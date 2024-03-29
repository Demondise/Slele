package SeleFrameworkDesign.pageFoctoryObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SeleFrameworkDesign.abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "[placeholder='Select Country']")
	WebElement countrySelector;
	By dropDownResults = By.cssSelector(".ta-results");
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement result;
	@FindBy(css = ".action__submit")
	WebElement submit;
	@FindBy(css = ".hero-primary")
	WebElement message;
	public void selectCountry(Actions b) {
		b.sendKeys(countrySelector, "india").build().perform();
		waitForVisibilityOfElement(dropDownResults);
		result.click();
	}
	public void placeOrder(Actions b) {
		b.moveToElement(submit).build().perform();
		submit.click();
	}
	public String checkMessage() {
		String messg = message.getText();
		return messg;
	}
	
}

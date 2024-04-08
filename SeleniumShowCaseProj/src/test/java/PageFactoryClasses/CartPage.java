package PageFactoryClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import frameWorkComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
}

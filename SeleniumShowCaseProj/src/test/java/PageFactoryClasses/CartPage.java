package PageFactoryClasses;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkComponents.AbstractComponents;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css = "span[class*='truncate-cut']")
	List<WebElement> cartProducts;
	public boolean cartProductMatch(String productName) {
		wait.until(ExpectedConditions.visibilityOfAllElements(cartProducts));
		boolean match = cartProducts.stream().anyMatch(s->productName.contains(s.getText().replaceAll("…","")));
		
		return match;
	}
}

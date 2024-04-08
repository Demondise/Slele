package PageFactoryClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkComponents.AbstractComponents;

public class HomePage extends AbstractComponents {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css = "#twotabsearchtextbox")
	WebElement searchBox;
	@FindBy(css = "div[class*='suggestion-container']")
	List<WebElement> searchSuggestions;
	
	public SearchResultsPage searchProduct(String productName) {
		searchBox.sendKeys(productName);
		wait.until(ExpectedConditions.visibilityOfAllElements(searchSuggestions));
		searchSuggestions.stream().filter(s->s.getText().contains(productName)).findFirst().get().click();
		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		return searchResultsPage;
	}
}

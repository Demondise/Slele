package SeleFrameworkDesign.pageFoctoryObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleFrameworkDesign.abstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	WebDriver driver ;
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "userEmail")
	WebElement userEmail;
	@FindBy(id = "userPassword")
	WebElement Password;
	@FindBy(id = "login")
	WebElement login;
	String url = "https://rahulshettyacademy.com/client";
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorToast;
	public ProductCatalogue loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		Password.sendKeys(password);
		login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	public void goTo() {
		driver.get(url);
	}
	public String checkToast() throws InterruptedException {
		waitForVisibilityOfElement(errorToast);
		String errorMsg = errorToast.getText();
		return errorMsg;
	}
}

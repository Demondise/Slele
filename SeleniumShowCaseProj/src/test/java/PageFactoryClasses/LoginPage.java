package PageFactoryClasses;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import frameWorkComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css = "a[id*='accountList']")
	WebElement accountList;
	@FindBy(css = "div[id*='container'] span[class*='nav-action-inner']")
	WebElement signIn;
	@FindBy(css="input[type='email']")
	WebElement emailInput;
	@FindBy(css="span[id='continue']")
	WebElement continueButton;
	@FindBy(css="input[type='password']")
	WebElement passwordInput;
	@FindBy(css="input[name='rememberMe']")
	WebElement rememberMe;
	@FindBy(css="#signInSubmit")
	WebElement submitButton;
	@FindBy(css = "input[type='text']")
	WebElement captcha;
	@FindBy(css = "input[type='submit']")
	WebElement continueCaptcha;
	
	public void goToSignIn() {
		actionsFW.moveToElement(accountList).build().perform();
		signIn.click();
	}
	@SuppressWarnings("resource")
	public HomePage singnIn(String email,String password) throws InterruptedException {
		goToSignIn();
		emailInput.sendKeys(email);
		continueButton.click();
		passwordInput.sendKeys(password);
		rememberMe.click();
		submitButton.click();
		if(driver.getCurrentUrl().contains("/ap/cvf/request")) {
			captcha.sendKeys(new Scanner(System.in).next());
			continueCaptcha.click();
		}
		HomePage homepage =  new HomePage(driver);
		return homepage;
	}

}

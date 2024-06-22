package PageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DI.TextcContext;
import abstractComponents.Interact;
import io.cucumber.java.Scenario;

public class LoginPage extends Interact  {
	public LoginPage(Scenario scn){
		super(scn);
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "userEmail")
	WebElement emailTextBox;
	@FindBy(id = "userPassword")
	WebElement passwordTextBox;
	@FindBy(id ="login")
	WebElement submitButton;
	public void loginWithCredentials() throws InterruptedException {
		setVal(emailTextBox, getProp("email"));
		setVal(passwordTextBox,getProp("password"));
		click(submitButton);
	}
	
}
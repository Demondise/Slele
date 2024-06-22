package DI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import abstractComponents.Interact;
import io.cucumber.java.Scenario;

public class TextcContext {
	WebDriver driver;
	Properties config;
	Scenario scn;
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	public LoginPage getLoginPage() {
		return loginPage;
	}

	public Scenario getScn() {
		return scn;
	}

	public void setScn(Scenario scn) {
		this.scn = scn;
	}

	public Properties getConfig() {
		return config;
	}

	public void setConfig(Properties config) {
		this.config = config;
	}

	public TextcContext() throws FileNotFoundException, IOException{
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void initPageObj() {
		loginPage = new LoginPage(scn);
		homePage = new HomePage(scn);
		cartPage = new CartPage(scn);
	}

	public CartPage getCartPage() {
		return cartPage;
	}

	public HomePage getHomePage() {
		return homePage;
	}
	public Interact getPage(String page) {
		if(page.contains("Homepage")) {
			return getHomePage();
		}else if(page.contains("Loginpage")){
			return getLoginPage();
		}
		return null;
	}
}

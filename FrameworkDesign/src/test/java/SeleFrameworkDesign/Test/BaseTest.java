package SeleFrameworkDesign.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import SeleFrameworkDesign.abstractComponents.frameworkUtils;
import SeleFrameworkDesign.pageFoctoryObjects.LoginPage;
import SeleFrameworkDesign.pageFoctoryObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements frameworkUtils{
	public WebDriver driver;
	private LoginPage loginPage;
	public Actions b;
	
	public LoginPage getLoginPage() {
		return loginPage;
	}
	public void setLoginPage(LoginPage loginPage) {
		this.loginPage = loginPage;
	}
	
	public void initialiseBrowser() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\java\\SeleFrameworkDesign\\resources\\GlobalData.properties")));
		String browser =System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		
		if(browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions config = new ChromeOptions();
			if(browser.contains("headless"))
				config.addArguments("headless");
			driver = new ChromeDriver(config);
			driver.manage().window().setSize(new Dimension(1440, 900));

			
		}else if(browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions config =  new EdgeOptions();
			if(browser.contains("headless"))
				config.addArguments("headless");
			driver = new EdgeDriver(config);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}else if(browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions config =  new FirefoxOptions();
			if(browser.contains("headless"))
				config.addArguments("headless");
			driver = new FirefoxDriver(config);
			driver.manage().window().setSize(new Dimension(1440, 900));

		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		b = new Actions(driver);
		
	}
	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApplication() throws FileNotFoundException, IOException {
		initialiseBrowser();
		loginPage = new LoginPage(driver);
		loginPage.goTo();
		return loginPage;
		
	}
	@AfterMethod(alwaysRun = true)
	public void wrapUp() throws IOException {
		getScreenShot(driver,"submitOrderTest");
		System.out.println("after test");
		driver.close();
	}
	
	
}

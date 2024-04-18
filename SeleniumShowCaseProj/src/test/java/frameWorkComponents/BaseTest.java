package frameWorkComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageFactoryClasses.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public WebDriverWait wait;

	void initialiseDriver() throws IOException {
		prop = new Properties();
		FileInputStream propFile = new FileInputStream(
				System.getProperty("user.dir") + "\\resources\\setupProp.properties");
		prop.load(propFile);
		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		if (browser.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (browser.contains("headless"))
				options.addArguments("headless");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			driver.manage().window().setSize(new Dimension(1440, 900));
		} else if (browser.contains("edge")) {
			EdgeOptions options = new EdgeOptions();
			if (browser.contains("headless"))
				options.addArguments("headless");
			driver = new EdgeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			driver.manage().window().setSize(new Dimension(1440, 900));
		} else if (browser.contains("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			if (browser.contains("headless"))
				options.addArguments("headless");
			driver = new FirefoxDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			driver.manage().window().setSize(new Dimension(1440, 900));
		}
	}

	@BeforeMethod(alwaysRun = true)

	public void loadSite() throws IOException {
		initialiseDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
	}

	@AfterMethod(alwaysRun = true)

	public void wrapUp() {
		driver.close();
	}
}

package DriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSingleTon {
	private WebDriver driver;
	private Properties config ;
	static ThreadLocal<DriverSingleTon> instance = new ThreadLocal<DriverSingleTon>();
	private DriverSingleTon() {
		loadProperties();
	}
    private Properties loadProperties() {
    	config = new Properties();
		try{config.load(new FileInputStream(new File("C:\\Users\\shivam_shar\\eclipse-workspace\\AllForOne\\src\\test\\resources\\Config.properties")));}
		catch (Exception e) {
			System.out.println("config file not found");
		}
		return config;
    }
	public WebDriver initDriver() {
		String browser = System.getProperty("browser")==null?config.getProperty("browser"):System.getProperty("browser");
    	if(browser.toLowerCase().contains("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    	}else if(browser.toLowerCase().contains("edge")) {
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    	}else if(browser.toLowerCase().contains("firefox")) {
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
    	}
    		driver.manage().window().maximize();
    	return driver;
    }
    
    public WebDriver getDriver() {
		return driver;
	}
    public void setImplicitWait(int secs) {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
    }
	public static DriverSingleTon getInstance(){
    	if(instance.get()==null) {
    		instance.set(new DriverSingleTon());
    	}
    	return instance.get();
    }
	public Properties getConfig() {
		return config;
	}
}

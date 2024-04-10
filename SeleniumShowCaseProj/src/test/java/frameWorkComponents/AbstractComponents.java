package frameWorkComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;
	protected Actions actionsFW;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		actionsFW = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor)driver;
	}
	@FindBy(css= "div[id*='nav-tools'] div[id*='nav-cart-count-container']")
	protected WebElement cartButton;
	
	static public String getscreenshot(WebDriver driver1, String methodName) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot)driver1;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File file = new File("C:\\Users\\shivam_shar\\git\\Slele\\SeleniumShowCaseProj\\TestReports\\"+methodName+".png");
		 FileUtils.copyFile(source, file);
		 return "C:\\Users\\shivam_shar\\git\\Slele\\SeleniumShowCaseProj\\TestReports\\"+methodName+".png";
		// TODO Auto-generated method stub

	}
	
	
}

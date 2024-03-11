package PractProbs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.remote.RemoteWebDriverBuilder;
import org.testng.Assert;

public class Scroll {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	//Javascript scrolling
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
	Thread.sleep(1000);
	List<WebElement> amount = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
	int sum = 0;
	for(WebElement i : amount) {
		sum+=Integer.parseInt(i.getText());
	}
	System.out.println(sum);
	int webSum = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
	Assert.assertEquals(sum, webSum);
	System.out.println("Done");
	driver.close();
	}	

}

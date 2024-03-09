package SectionProj;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
		login(driver, w);
		shopProducts(driver, w);
		
	}
	static void login(WebDriver driver, WebDriverWait w) {
		 driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		 driver.findElement(By.id("password")).sendKeys("learning");
		 driver.findElement(By.xpath("//span[text()=' User']/following-sibling::span")).click();
		 w.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		 driver.findElement(By.id("okayBtn")).click();
		 Select s = new Select(driver.findElement(By.cssSelector("select.form-control")));
		 s.selectByIndex(2);
		 driver.findElement(By.id("terms")).click();
		 driver.findElement(By.id("signInBtn")).click();
		 
	}
	static void shopProducts(WebDriver driver, WebDriverWait w) throws InterruptedException {
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn-primary")));
		int i = driver.findElements(By.cssSelector("button.btn")).size();
		while(i>0) {
			w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-info'])["+i+"]")));
			driver.findElement(By.xpath("(//button[@class='btn btn-info'])["+i+"]")).click();
			i--;
		}
		driver.findElement(By.cssSelector("a.btn-primary")).click();
	}

}

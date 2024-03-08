package SectionProj;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		String[] kartItems = {"Cauliflower","Cucumber","Beetroot"};
		selectItems(driver, kartItems);
		checkOut(driver,w);
		
		
	}
	static void selectItems(WebDriver driver,String[] kartItems) {
		List<String> li = Arrays.asList(kartItems);
		List<WebElement> items = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int count = 0;
		x: for(int i = 1 ;i<=items.size();i++) {
				String[] j = items.get(i).getText().split("-");
				String k = j[0].trim();
				if(li.contains(k)) {
					count++;
					driver.findElement(By.xpath("(//div[@class='product-action']/button)[" +i+"]" )).click();
					if(count==kartItems.length){
						break x;
				}
			}
		}
	}
	static void checkOut(WebDriver driver,WebDriverWait w) {
		driver.findElement(By.cssSelector("a.cart-icon img")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.cart-preview button")));
		driver.findElement(By.cssSelector("div.cart-preview button")).click();
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("button.promoBtn")).isDisplayed()?"displayed":"not displayed");
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}
}



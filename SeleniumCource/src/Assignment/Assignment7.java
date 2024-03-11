package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.cssSelector("table[name='courses'] tr")).size());
		System.out.println(driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(1) th")).size());
		List<WebElement> list = driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(4) td"));
		for(WebElement i : list) {
			System.out.print(i.getText()+" ");
		}


	}

}

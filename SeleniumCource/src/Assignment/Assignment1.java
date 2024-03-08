package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {
	public static void main(String [] args) {
		WebDriver driver = new ChromeDriver();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=checkBoxOption1]")).isSelected());
		driver.findElement(By.cssSelector("input[id*=checkBoxOption1]")).click();
	}
}

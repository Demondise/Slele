package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment2 {
	
		public static void main(String [] args) {
			WebDriver driver = new ChromeDriver();
			driver.findElements(By.cssSelector("input[id*=checkBoxOption]")).size();
			driver.findElement(By.cssSelector("input[id*=checkBoxOption1]")).click();
		}
	}


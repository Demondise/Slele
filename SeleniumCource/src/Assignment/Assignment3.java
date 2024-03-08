package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']")).sendKeys("Shivam Sharma");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("ss367940@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Shivam@123");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		WebElement select = driver.findElement(By.cssSelector("select[id='exampleFormControlSelect1']"));
		Select s = new Select(select);
		s.selectByIndex(1);
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("7111998");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class*='success']")).getText());
		driver.close();
		
		

	}

}

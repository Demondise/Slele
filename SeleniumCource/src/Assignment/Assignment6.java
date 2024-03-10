package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {
	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
		String opt = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		Select sl = new Select(driver.findElement(By.id("dropdown-class-example")));
		sl.selectByVisibleText(opt);
		driver.findElement(By.id("name")).sendKeys(opt);
		driver.findElement(By.id("alertbtn")).click();
		String check = driver.switchTo().alert().getText().contains(opt)?"Present":"Not Present";
		System.out.println(check);
		driver.switchTo().alert().accept();
	}
}

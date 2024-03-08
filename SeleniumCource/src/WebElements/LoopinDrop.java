package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoopinDrop {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(500);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i = 0;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		int i = 0;
		while(i<2) {
			driver.findElement(By.id("hrefIncChd")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		driver.close();
		}
}

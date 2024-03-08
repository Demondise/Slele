package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calander {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		 driver.get("https://www.spicejet.com/");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[text()='From']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[text()='AGR']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[text()='DEL']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.cssSelector(" div[data-testid='undefined-calendar-picker'] div[class*='r-19m6qjp']")).click();
		 driver.close();
	}
}

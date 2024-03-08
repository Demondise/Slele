package SectionProj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class SpiceJet {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		 driver.get("https://www.spicejet.com/");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[text()='one way']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[text()='From']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[text()='AGR']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[text()='DEL']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.cssSelector(" div[data-testid='undefined-calendar-picker'] div[class*='r-19m6qjp']")).click();
		 if(driver.findElement(By.xpath("//div[text()='Return Date']")).getAttribute("class").contains("r-icoktb")) {
			 System.out.println("Disabled");
			 Assert.assertTrue(true);
		 }else {
			 System.out.println("Enabled");
			 Assert.assertTrue(false);
		 }
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()='Passengers']")).click();
			Thread.sleep(1000);
			for(int i = 0;i<5;i++) {
				driver.findElement(By.cssSelector("div[data-testid*='Adult-testID-plus']")).click();
			}
			int i = 0;
			while(i<2) {
				driver.findElement(By.cssSelector("div[data-testid*='Children-testID-plus']")).click();
				i++;
			}
			driver.findElement(By.xpath("//div[text()='Passengers']")).click();
			driver.findElement(By.xpath("//div[text()='Family & Friends']")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("div[class*='css-1dbjc4n r-1awozwy r-z2wwpe']")).click();
	}
}

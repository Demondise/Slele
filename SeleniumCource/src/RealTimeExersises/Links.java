package RealTimeExersises;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Find the no of links in all the page
		System.out.println(driver.findElements(By.cssSelector("a[href]")).size());
		//Find the no of links in the footer
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.cssSelector("a[href]")).size());
		//Find the no of links in first column of the footer
		WebElement column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(column.findElements(By.cssSelector("a[href]")).size());
		//check all the links in the column are working
		int x = column.findElements(By.cssSelector("a[href]")).size();
		for(int i=1;i<x;i++) {
			String ke = Keys.chord(Keys.CONTROL,Keys.ENTER);
			column.findElements(By.cssSelector("a[href]")).get(i).sendKeys(ke);
			Thread.sleep(5000);
		}
		//get the titles of all the open links
		Set<String> links = driver.getWindowHandles();
		Iterator<String> itr = links.iterator();
		while(itr.hasNext()) {
			String j = driver.switchTo().window(itr.next()).getTitle();
			System.out.println(j);
		}
	}

}

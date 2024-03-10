package RealTimeExersises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalanderEx {
	public static void main(String[] args) {
		String month =  "6";
		String day = "11";
		String year = "2027";
		String[] date = {month, day, year};
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("div.react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector("button.react-calendar__tile")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		for(int i =0 ;i<date.length;i++) {
			String value = driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input")).get(i).getAttribute("value");
			Assert.assertEquals(value, date[i]);
			}
		System.out.println("Every thing work fine");
		}
}

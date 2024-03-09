import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Asserts {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();

		driver.get("http://spicejet.com"); //URL in the browser

		Assert.assertFalse(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isSelected());

		//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		driver.findElement(By.xpath("//div[text()='Senior Citizen']")).click();

		System.out.println(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isSelected());

		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Senior Citizen']")).isSelected());

	}

}

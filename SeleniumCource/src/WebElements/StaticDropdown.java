package WebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver  = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDrpdwn = driver.findElement(By.xpath("//*[contains(@id,'ListCurrency')]"));
		Select sle = new Select(staticDrpdwn);
		sle.selectByIndex(2);
		System.out.println(sle.getFirstSelectedOption().getText());
		sle.selectByVisibleText("AED");
		System.out.println(sle.getFirstSelectedOption().getText());
		sle.selectByValue("INR");
		System.out.println(sle.getFirstSelectedOption().getText());
		driver.close();
	}
	
}

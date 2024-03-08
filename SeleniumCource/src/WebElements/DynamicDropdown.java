package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
	//Dynamic dorpdowns are a bit messy as the element only appears after it is clicked
	//you may find two elements with same xpath can be resolved by proper indexing.
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.spicejet.com/");
		 driver.findElement(By.xpath("(//input[contains(@class,'homx')])[1]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[text()='AMD']")).click();
		 driver.findElement(By.xpath("(//input[contains(@class,homxoj)])[2]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[text()='IXB']")).click();
		 Thread.sleep(1000);
		 driver.close();
		// parent child relationship xpath. if someone dont like indexes
		 /* "//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"
		  * */
	}

}

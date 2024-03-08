package SectionProj;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kart {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		String[] kartItems = {"Cauliflower","Cucumber","Beetroot"};
		List<String> li = Arrays.asList(kartItems);
		List<WebElement> items = driver.findElements(By.xpath("//h4[@class='product-name']"));
		int count = 0;
		x: for(int i = 1 ;i<=items.size();i++) {
				String[] j = items.get(i).getText().split("-");
				String k = j[0].trim();
				if(li.contains(k)) {
					count++;
					driver.findElement(By.xpath("(//div[@class='product-action']/button)[" +i+"]" )).click();
					if(count==kartItems.length){
						break x;
				}
			}
		}
		System.out.println("Execution done");
		driver.close();
	}
}

//Using text() as locator is discouraged, Index is discouraged as it can change with new webelements addition deletion

//import java.util.Arrays;
//
//import java.util.List;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//
//import org.openqa.selenium.WebDriver;
//
//import org.openqa.selenium.WebElement;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class base {
//
//	public static void main(String[] args) throws InterruptedException {
//
//// TODO Auto-generated method stub
//
//		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
//
//		WebDriver driver = new ChromeDriver();
//
//		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
//
//		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//
//		Thread.sleep(3000);
//
//		addItems(driver, itemsNeeded);
//
//	}
//
//	public static void addItems(WebDriver driver, String[] itemsNeeded)
//
//	{
//
//		int j = 0;
//
//		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
//
//		for (int i = 0; i < products.size(); i++)
//
//		{
//
////Brocolli - 1 Kg
//
////Brocolli,    1 kg
//
//			String[] name = products.get(i).getText().split("-");
//
//			String formattedName = name[0].trim();
//
////format it to get actual vegetable name
//
////convert array into array list for easy search
//
////  check whether name you extracted is present in arrayList or not-
//
//			List itemsNeededList = Arrays.asList(itemsNeeded);
//
//			if (itemsNeededList.contains(formattedName))
//
//			{
//
//				j++;
//
////click on Add to cart
//
//				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
//
//				if (j == itemsNeeded.length)
//
//				{
//
//					break;
//
//				}
//
//			}
//
//		}
//
//	}
//
//}

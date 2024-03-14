package newFeaturesSel4.o;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class MultiWindow {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it  = win.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		driver.get("https://courses.rahulshettyacademy.com/courses/");
		String cource = driver.findElements(By.xpath("//div[@class='col-lg-12']/div[2]")).get(2).getText();
		System.out.println(cource);
		driver.switchTo().window(parent);
		WebElement name = driver.findElement(By.cssSelector("div.form-group input[name='name']"));
	    name.sendKeys(cource);
	    File file = name.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(file, new File("logo.png"));
	    System.out.println(name.getRect().height);
	    System.out.println(name.getRect().width);

	}

}

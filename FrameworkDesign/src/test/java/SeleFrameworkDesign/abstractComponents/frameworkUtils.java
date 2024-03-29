package SeleFrameworkDesign.abstractComponents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface frameworkUtils {
	default List<HashMap<String, String>> getDataJason() throws IOException {
		String json = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\SeleFrameworkDesign\\resources\\Data.json"),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(json, new TypeReference <List<HashMap<String, String>>>(){});
		return data;
	}
	default String getScreenShot(WebDriver driver, String methodName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\shivam_shar\\git\\Slele\\FrameworkDesign\\Sreenshots\\"+methodName+".png");
		FileUtils.copyFile(source, file);
		return "C:\\Users\\shivam_shar\\git\\Slele\\FrameworkDesign\\Sreenshots\\"+methodName+".png";
		
	}
	
}

package frameWorkComponents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import javax.sound.sampled.AudioFormat.Encoding;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.UTF8;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public interface FrameworkUtils {
 default String getscreenshot(WebDriver driver1, String methodName) throws IOException {
		TakesScreenshot ts =  (TakesScreenshot)driver1;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 File file = new File("C:\\Users\\shivam_shar\\git\\Slele\\SeleniumShowCaseProj\\TestReports\\"+methodName+".png");
		 FileUtils.copyFile(source, file);
		 return "C:\\Users\\shivam_shar\\git\\Slele\\SeleniumShowCaseProj\\TestReports\\"+methodName+".png";
	}
 default List<HashMap<String, String>> getDataJson() throws IOException{
	 String jsonFile = (String) FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\resources\\Data.json"), StandardCharsets.UTF_8);
	 ObjectMapper mapper = new ObjectMapper();
	 List<HashMap<String, String>> data = mapper.readValue(jsonFile, new TypeReference <List<HashMap<String, String>>>(){});
	 return data;
 	}
 }

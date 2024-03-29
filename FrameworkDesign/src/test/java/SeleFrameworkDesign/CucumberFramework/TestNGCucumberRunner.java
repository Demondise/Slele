package SeleFrameworkDesign.CucumberFramework;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\shivam_shar\\git\\Slele\\FrameworkDesign\\src\\test\\java\\SeleFrameworkDesign\\CucumberFramework", glue = "SeleFrameworkDesign.StepDefinitions", monochrome = true, plugin = "html:reprots\\cucmber.html")
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

}

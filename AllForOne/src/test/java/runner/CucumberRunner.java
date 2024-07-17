package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\ui",
glue = "StepDefs",tags = "@ui",
plugin = {
		"pretty",
		"html:target/default-Cucumber-report.html",
		"json:target/Json/json-report.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
})
public class CucumberRunner {

}

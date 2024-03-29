package SeleFrameworkDesign.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import SeleFrameworkDesign.Test.BaseTest;

public class ExtentReportsFramework extends BaseTest {
	public static ExtentReports getExtentReports() {
		String path = System.getProperty("user.dir")+"//reprots//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Test");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extent =  new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Shivam", "Shivam automation tests");
		return extent;
		
		
	}
}

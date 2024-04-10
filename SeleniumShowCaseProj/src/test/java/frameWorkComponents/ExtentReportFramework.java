package frameWorkComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportFramework extends BaseTest{
	public static ExtentReports getExtentReports() {
		String path = System.getProperty("user.dir") + "\\TestReports\\Index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Show case framework");
		reporter.config().setDocumentTitle("Amazon web automation tests results");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
	}
}

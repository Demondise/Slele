package frameWorkComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	  ExtentTest test;
	  ExtentReports extent = ExtentReportFramework.getExtentReports();
	  ThreadLocal<ExtentTest> extenTest = new ThreadLocal<ExtentTest>();
	  public void onTestStart(ITestResult result) {
		  test = extent.createTest(result.getMethod().getMethodName());
		  extenTest.set(test);
	  }
	  public void onTestSuccess(ITestResult result) {
	    extenTest.get().log(Status.PASS, "Testcase Passed");
	  }

	  public void onTestFailure(ITestResult result) {
	   extenTest.get().fail(result.getThrowable());
	    WebDriver driver = null;
	    try {
			driver =(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    try {
			extenTest.get().addScreenCaptureFromPath(AbstractComponents.getscreenshot(driver,result.getMethod().getMethodName()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  public void onStart(ITestContext context) {
	    // not implemented
	  }
	  public void onFinish(ITestContext context) {
		  extent.flush();
	  }

}

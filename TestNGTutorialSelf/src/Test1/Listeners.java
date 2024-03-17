package Test1;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	  public void onTestStart(ITestResult result) {
	    // not implemented
	  }

	
	  public void onTestSuccess(ITestResult result) {
	    System.out.println("I have passed the test");
	  }

	  public void onTestFailure(ITestResult result) {
		  System.out.println("I have Failed the test");
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
	    // not implemented
	  }

}

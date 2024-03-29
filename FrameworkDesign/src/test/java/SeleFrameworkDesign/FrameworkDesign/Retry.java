package SeleFrameworkDesign.FrameworkDesign;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int count = 0;
	int max_count = 1;
	@Override
	public boolean retry(ITestResult result) {
		if(count<max_count) {
			count++;
			return true;
		}
		return false;
	}

}

package frameWorkComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	int count = 0;
	int max_try = 1;
	@Override
	public boolean retry(ITestResult result) {
		if(count<1) {
			count++;
			return true;
		}
		return false;
	}

}

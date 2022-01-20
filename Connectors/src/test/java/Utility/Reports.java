/**
 * 
 */
package Utility;

import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author Raja Reddy
 *
 */
public class Reports {

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public void setUp() {
		reporter = new ExtentHtmlReporter("./OutPut/extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail(MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			logger.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass(MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
			logger.pass(result.getThrowable());
		}
	}

	public void tearDown() {
		extent.flush();
	}
}

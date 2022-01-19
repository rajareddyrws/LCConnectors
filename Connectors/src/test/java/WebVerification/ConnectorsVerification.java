package WebVerification;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import DataProvider.DropboxVerify;
import DataProvider.BoxVerify;

/**
 * @author Raja Reddy
 *
 */

public class ConnectorsVerification extends BoxVerify {

	DropboxVerify dv = new DropboxVerify();
	BoxVerify bv = new BoxVerify();

	@BeforeMethod
	public void extentReportStart() {

		String report = "Connectors" + getDate("yyyy-MM-dd") + ".html";
		reporter = new ExtentHtmlReporter("./OutPut/" + report);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@Test(priority = 1)
	public void cleanFolder() {
		cleanLocalFolder(Local_Folder_Connectors);
	}

	@Test(priority = 2)
	public void boxConnector() throws Exception {
		logger = extent.createTest("Box Connector verification");
		logger.log(Status.INFO, "*********** Box Connector verification starts ***********");
		bv.boxConnectorVerify();
		logger.log(Status.PASS, "*********** Box Connector verification completed ***********");
	}

	// @Test(priority = 3)
	public void dropBoxConnector() throws Exception {
		logger = extent.createTest("DropBox Connector verification");
		logger.log(Status.INFO, "*********** DropBox Connector verification starts ***********");
		dv.dropboxConnectorVerify();
		logger.log(Status.PASS, "*********** DropBox Connector verification completed ***********");
	}

	@AfterMethod
	public void flushMethod() {
		extent.flush();
	}

}

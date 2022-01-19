package DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author Raja Reddy
 *
 */
public class ConfigReader {

	private final static String propertyFilePath = "Data//config.properties";

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	protected static final String Local_Folder_Connectors = getMainFolder() + File.separator
			+ loadProperty("LocalFolderConnectors");
	protected static final String Url = loadProperty("URL");
	protected static final String Browser = loadProperty("SelectBrowser");
	protected static final String Web_Login = loadProperty("WebUserName");
	protected static final String Web_Password = loadProperty("WebPassword");
	protected static final String Project_Name = loadProperty("ProjectName");

	// DropBox
	protected static final String DropBox_Url = loadProperty("DropBoxURL");
	protected static final String DropBox_Web_Login = loadProperty("DropBoxWebUserName");
	protected static final String DropBox_Web_Password = loadProperty("DropBoxWebPassword");

	// GoogleDrive
	protected static final String Gdrive_Url = loadProperty("GoogleDriveURL");
	protected static final String Gdrive_Web_Login = loadProperty("GoogleDriveWebUserName");
	protected static final String Gdrive_Web_Password = loadProperty("GoogleDriveWebPassword");

	// Box
	protected static final String Box_Url = loadProperty("BoxURL");
	protected static final String Box_Web_Login = loadProperty("BoxWebUserName");
	protected static final String Box_Web_Password = loadProperty("BoxWebPassword");

	static {
		new File(Local_Folder_Connectors).mkdirs();
	}

	public static String loadProperty(String propName) {

		Properties props = new Properties();
		String sysProp = System.getProperties().getProperty(propName);
		String value = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
			props.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (propName != null) {
			value = props.getProperty(propName);
		}

		if (sysProp != null) {
			value = System.getProperties().getProperty(propName);
		}
		return value;
	}

	public static String getDate(Date date, String format) {
		SimpleDateFormat sdt = new SimpleDateFormat(format);
		return sdt.format(date).toString();
	}

	public static String getDate(String format) {
		return getDate(new Date(), format);
	}

	public static String getMainFolder() {
		String OSName = System.getProperty("os.name").toLowerCase();
		if (OSName.indexOf("win") >= 0) {
			return loadProperty("MainFolderWin");
		}
		return loadProperty("MainFolderLin");
	}

	public void cleanLocalFolder(String folder) {
		try {
			for (File file : (new File(folder)).listFiles()) {
				file.delete();
			}

			System.out.println("Successfully deleted all the files inside local_folder.");
		} catch (NullPointerException e) {
			System.out.println(folder + " did not exist. Created it newly.");
			System.err.println(folder + " did not exist. Created it newly.");
			new File(folder).mkdirs();
		}
	}
}

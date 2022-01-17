/**
 * 
 */
package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import DataProvider.ConfigReader;

/**
 * @author Raja Reddy
 *
 */
public class BrowserSelection extends ConfigReader{
	
	protected static WebDriver driver;
	
	
	
	
	public static WebDriver launchBrowser(String browserName,String url)
	{
		if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","geckodriver.exe" ); 
			driver= new FirefoxDriver();
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver=  new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}

}

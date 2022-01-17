package DataProvider;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

/*import org.apache.commons.lang3.ArrayUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;*/
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pages.DropboxPage;
import Pages.GoogleDrivePage;
import Utility.BrowserSelection;
import Utility.ScreenShot;

/**
 * @author Raja Reddy
 *
 */

public class GoogleDriveVerify extends BrowserSelection{
	static GoogleDrivePage gD;
	static BrowserSelection bS;
	
	@Test(priority = 1)
	public void dropboxConnectorVerify() throws IOException, AWTException, InterruptedException {
		
		String URL = "https://" + Url + "/signin";
		//navigating to the website
		BrowserSelection.launchBrowser(Browser,URL);
		gD = PageFactory.initElements(driver, GoogleDrivePage.class);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        driver.findElement(By.xpath("//input[@type='email']")).click();
        //login to the website
        gD.getuname().sendKeys(Web_Login); 
		gD.getpword().sendKeys(Web_Password);
		gD.getsignIn();
		//go to project dashboard
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Projects']")));
        gD.getproject().click();
        //go to new project
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New Project']")));
        gD.getnewProject().click();
        //entering the project details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        gD.getname().click();
        gD.getname().clear();
        gD.getname().sendKeys("TestR");
        gD.getlocation().sendKeys("Root");
       // gD.getprojectTemplate().sendKeys("Simple Project Template");
        //selecting the file
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='//du15km6j44b3f.cloudfront.net/static-assets/js/language-cloud/c8fe4e6ed2e0022e293daf611d4f67ed.svg']")));
        gD.getconnector().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//[text()='Select OneDrive configuration']/../../../../.. //[text()='Dropbox Configuration _ Testing']")));
        gD.getselectconfig().click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        
        String parentWindow=driver.getWindowHandle();		
		
        // To handle all new opened window.				
        Set<String> s1=driver.getWindowHandles();		
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String childWindow=i1.next();		
            		
            if(!parentWindow.equalsIgnoreCase(childWindow))			
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(childWindow);	     
                    driver.manage().window().maximize();
                    //driver.findElement(By.xpath("//*[@id='gridview-1841-record-1278']/tbody/tr/td[1]/div/span")).click();
//        	        driver.findElement(By.xpath(xpathExpression))           
			// Closing the Child Window.
             //           driver.close();		
            }		
        }		
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(parentWindow);
                   
                  }
}
	

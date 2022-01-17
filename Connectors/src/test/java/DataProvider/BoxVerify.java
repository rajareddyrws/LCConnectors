package DataProvider;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.BoxPage;
import Utility.BrowserSelection;
import Utility.ScreenShot;

/**
 * @author Raja Reddy
 *
 */

public class BoxVerify extends BrowserSelection{
	static BoxPage bP;
	static BrowserSelection bS;
	
	@Test(priority = 1)
	public void boxConnectorVerify() throws InterruptedException {

		String URL = "https://" + Url + "/signin";
		//navigating to the website
		BrowserSelection.launchBrowser(Browser,URL);
		bP = PageFactory.initElements(driver, BoxPage.class);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        ScreenShot.captureScreenshot(driver, "LanguageCloudSignInPage");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        driver.findElement(By.xpath("//input[@type='email']")).click();
        //login to the website
        bP.getuname().sendKeys(Web_Login); 
		bP.getpword().sendKeys(Web_Password);
		bP.getsignIn();
		logger.log(Status.INFO, "Signing In to Language Cloud is successful");
		//go to project dashboard
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Projects']")));
		ScreenShot.captureScreenshot(driver, "LanguageCloudHomePage");
		bP.getproject().click();
		logger.log(Status.INFO, "Navigating to Projects page successful");
		ScreenShot.captureScreenshot(driver, "ProjectDashBoardPage");
        //go to new project
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New Project']")));
        bP.getnewProject().click();
        logger.log(Status.INFO, "Navigating to new Project page successful");
        //entering the project details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        ScreenShot.captureScreenshot(driver, "NewProjectBeforeEnteringDetailsPage");
        bP.getname().click();
        bP.getname().clear();
        String Pname = "Box_TestR_Auto_"+getDate("DDMMYYYYHHmm");
        bP.getname().sendKeys(Pname);
        bP.getlocation().sendKeys("Root");
        bP.getprojectTemplate().sendKeys("Simple Project Template");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class='x-body boundlist-filter']//following-sibling::li")).click();
        driver.findElement(By.xpath("//*[text()='2 selected']//following-sibling::span[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Select target languages...']")).click();
        driver.findElement(By.xpath("//*[text()=' Urdu (India)']")).click();
        driver.findElement(By.xpath("//*[@name='description']")).sendKeys("test");
        //selecting the file
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='//du15km6j44b3f.cloudfront.net/static-assets/js/language-cloud/200ec776a5adc0285636d611df5b59ae.svg']")));
        bP.getconnector().click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Box Configuration' and @class='action-link']")));
        JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", bP.getselectconfig()); 
        Thread.sleep(5000);
        String parentWindow=driver.getWindowHandle();		
		// To handle all new opened window.				
        Set<String> a1=driver.getWindowHandles();		
        Iterator<String> i1=a1.iterator();		
        while(i1.hasNext())			
        {	
            String childWindow=i1.next();		
            if(!parentWindow.equalsIgnoreCase(childWindow))			
            {    		
                    // Switching to Child window
                    driver.switchTo().window(childWindow);	     
                    driver.manage().window().maximize();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login']")));
                    bP.getbuname().sendKeys(Box_Web_Login);
                    bP.getbpword().sendKeys(Box_Web_Password);
                    bP.getbsignIn();
                    Thread.sleep(5000);
                    List<WebElement> n1=driver.findElements(By.xpath("//*[@id='consent_accept_button']/span[1]"));

                    if(n1.isEmpty()) {
                    }
                    else {
                    	driver.findElement(By.xpath("//*[@id='consent_accept_button']/span[1]")).click();
                    	}   
                    Thread.sleep(5000);	
            }		
        }		
        	// Switching to Parent window i.e Main Window.
        	logger.log(Status.INFO, "Selecting the file successful");
            driver.switchTo().window(parentWindow);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' x-tree-elbow-img x-tree-elbow-plus x-tree-expander']")));
            bP.getselectfolder();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' x-tree-elbow-img x-tree-elbow']//following-sibling::div")));
            bP.getselectfile();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Confirm']")));
            bP.getconfirm();
            logger.log(Status.INFO, "Entering the project details successful");
            Thread.sleep(5000);
            ScreenShot.captureScreenshot(driver, "NewProjectAfterEnteringDetailsPage");
            bP.getcreateStart();
            logger.log(Status.INFO, "Creating new project successful");
            //Opening the project
            ScreenShot.captureScreenshot(driver, "ProjectDashBoardPage2");
            String project = "//span[text()='"+Pname+"']";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(project)));
            driver.findElement(By.xpath(project)).click();
			//Navigating to Project Files Page
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@unselectable='on' and text()='Files']")));
			ScreenShot.captureScreenshot(driver, "ProjectDetailsPage");
			driver.findElement(By.xpath("//span[@unselectable='on' and text()='Files']")).click();
			//Integrating Back to Box page
			List<WebElement> n2=driver.findElements(By.xpath("//span[@class='status file-in_progress']"));
	        for(int i=0;n2.isEmpty();i++) {
	        	driver.navigate().refresh();
	        	Thread.sleep(10000);
	        	i=i+0;
	        	List<WebElement> n4=driver.findElements(By.xpath("//span[@class='status file-finished']"));
		        if(n4.isEmpty()==false) {
		        	WebElement ele =driver.findElement(By.xpath("//span[text()='Integrate to Box']"));
		        	Je.executeScript("arguments[0].click();", ele);
		        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='notification-container']/div/div/p")));
					String s =driver.findElement(By.xpath("//*[@class='notification-container']/div/div/p")).getText();
		        	Thread.sleep(10000);
		        	if(s=="Cannot upload until all target files have been processed.") {
		        		
		        	}
		        	else {
					break;
		        	}
		        	if(s=="test.txt[ur-IN] file successfully integrated to Box") {
		        		
		        	}
		        	else {
					break;
		        	}
		        	
		        }
	        }
	        logger.log(Status.INFO, "File Integrated to Box successful");
	        ScreenShot.captureScreenshot(driver, "ProjectFilesPage");
	        Thread.sleep(5000);
	        //Checking the file integration successful or not
	        driver.navigate().to("https://account.box.com/login");
	        Thread.sleep(5000);
	        bP.getbuname().sendKeys(Box_Web_Login);
	        bP.getbsignIn();
	        Thread.sleep(5000);
	        bP.getbpword().sendKeys(Box_Web_Password);
	        bP.getbsignIn();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//a[text()='Test']")).click();
	        Thread.sleep(5000);
	        List<WebElement> n5=driver.findElements(By.xpath("//a[text()='test[ur-IN].txt']"));
	        if(n5.isEmpty()) {
	        	System.out.println("File not Imported");
	        }
	        else {
	        	System.out.println("Imported Successfully done");
	        	}   
	        ScreenShot.captureScreenshot(driver, "BoxFilesPage");
	        logger.log(Status.INFO, "File imported to Box successful");
	        driver.close();
	}
}

package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
/**
 * @author Raja Reddy
 *
 */
public class GoogleDrivePage {
	WebDriver driver;

	public GoogleDrivePage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//input[@type='email']")
	WebElement uname;
	
	@FindBy(how = How.XPATH, using = "//*[@name='password']")
	WebElement pword;

	@FindBy(how = How.XPATH, using = "//button[@name='submit']")
	WebElement signIn;

	@FindBy(how = How.XPATH, using = "//span[text()='Projects']")
	WebElement project;

	@FindBy(how = How.XPATH, using = "//span[text()='New Project']")
	WebElement newProject;

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	WebElement name;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Location']/../../.. //input")
	WebElement location;

	@FindBy(how = How.XPATH, using = "//*[@id='strategycombobox-1532-inputEl']")
	WebElement projectTemplate;

	@FindBy(how = How.XPATH, using = "//img[@src='//du15km6j44b3f.cloudfront.net/static-assets/js/language-cloud/c8fe4e6ed2e0022e293daf611d4f67ed.svg']")
	WebElement connector;
	
	@FindBy(how = How.XPATH, using = "//[text()='Select Dropbox configuration']/../../../../.. //[text()='Dropbox Configuration _ Testing']")
	WebElement selectconfig;
	
	@FindBy(how = How.XPATH, using = "//*[@name = 'login_email']")
	WebElement dbuname;
	
	@FindBy(how = How.XPATH, using = "//input[@name='login_password']")
	WebElement dbpword;

	@FindBy(how = How.CSS, using = ".login-button.signin-button.button-primary")
	WebElement dbsignIn;

	
	public WebElement getuname() {
		return uname;
	}
	
	public WebElement getpword() {
		return pword;
	}
	
	public void getsignIn() {
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", signIn);
	}

	public WebElement getproject() {
		return project;
	}

	public WebElement getnewProject() {
		return newProject;
	}

	public WebElement getname() {
		return name;
	}

	public WebElement getlocation() {
		return location;
	}

	public WebElement getprojectTemplate() {
		return projectTemplate;
	}

	public WebElement getconnector() {
		return connector;
	}

	public WebElement getselectconfig() {
		return selectconfig;
	}

	public WebElement getdbuname() {
		return dbuname;
	}
	
	public WebElement getdbpword() {
		return dbpword;
	}
	
	public void getdbsignIn() {
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", dbsignIn);
	}

}

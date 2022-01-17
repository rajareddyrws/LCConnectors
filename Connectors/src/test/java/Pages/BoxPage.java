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
public class BoxPage {
	WebDriver driver;

	public BoxPage(WebDriver driver) {
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

	@FindBy(how = How.XPATH, using = "//*[@placeholder='Select from project templates']")
	WebElement projectTemplate;

	@FindBy(how = How.XPATH, using = "//img[@src='//du15km6j44b3f.cloudfront.net/static-assets/js/language-cloud/200ec776a5adc0285636d611df5b59ae.svg']")
	WebElement connector;
	
	
	@FindBy(how = How.XPATH, using = "//*[text()='Box Configuration' and @class='action-link']")
	//@FindBy(how = How.XPATH, using = "//*[@id='gridview-1674-record-1023']/tbody/tr/td[1]/div/span")
	//@FindBy(how = How.XPATH, using = "//*[@id='configWindow_header-title-textEl']/../../../../.. //[text()='TestR Box']")
	WebElement selectconfig;
	
	@FindBy(how = How.XPATH, using = "//input[@name='login']")
	WebElement buname;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement bpword;

	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	WebElement bsignIn;

	@FindBy(how = How.XPATH, using = "//div[@class=' x-tree-elbow-img x-tree-elbow-plus x-tree-expander']")
	WebElement selectfolder;

	@FindBy(how = How.XPATH, using = "//*[@class=' x-tree-elbow-img x-tree-elbow']//following-sibling::div")
	WebElement selectfile;

	@FindBy(how = How.XPATH, using = "//*[text()='Confirm']")
	WebElement confirm;

	@FindBy(how = How.XPATH, using = "//*[text()='Create & Start']")
	WebElement createStart;

	
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

	public WebElement getbuname() {
		return buname;
	}
	
	public WebElement getbpword() {
		return bpword;
	}
	
	public void getbsignIn() {
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", bsignIn);
	}

	public void getselectfolder() {
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", selectfolder);
	}

	public void getselectfile() {
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", selectfile);
	}

	public void getconfirm() {
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", confirm);
	}

	public void getcreateStart() {
		JavascriptExecutor Je = (JavascriptExecutor) driver;
		Je.executeScript("arguments[0].click();", createStart);
	}

}

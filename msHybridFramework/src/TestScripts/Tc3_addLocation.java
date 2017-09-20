package TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import GeneralLogin.Admin;
import GeneralLogin.Login;

public class Tc3_addLocation extends RootTest
{
	static Login login = new Login(browser);
	static Admin admin = new Admin(browser);
	@Test
	public static void addlocation() throws FileNotFoundException, IOException
	{
		browser.StartBrowser();
		browser.maximizeBrowser();
		browser.VerifyTitle("OrangeHRM - New Level of HR Management");
		login.setup();
		login.LogintoApp("qaplanet1", "user1");
		browser.waitforPageToload();
	    browser.VerifyTitle("OrangeHRM");
	    browser.startActions();
	    browser.MoveTOElement("xpath", ".//*[@id='admin']/a/span");
  
	    browser.MoveTOElement("xpath", ".//*[@id='admin']/ul/li[1]/a/span");
	    browser.MoveTOElement("xpath", ".//*[@id='admin']/ul/li[1]/ul/li[2]/a/span");
	    browser.clickActions();
	    browser.sleepThread(2000);
	    // browser.waitforPageToload();
	    browser.SelectFrameById("rightMenu");
	    browser.waitUntilElementTObePresent("html/body/div/div[2]/form/div[1]/h2");
	    browser.click("xpath", "html/body/div/div[2]/form/div[3]/div[1]/input[1]");
	    browser.waitUntilElementTObePresent("html/body/div[1]/div[3]/div[2]/div/h2");
	    browser.clearTextField("id", "txtLocDescription");
	    browser.SendKeys("id", "txtLocDescription", "hyderabad");
	    browser.SelectItemFromDroopdrown("id", "cmbCountry");
	    //int x = 0;
	    //browser.SelectItemByIndex(x);
	    browser.SendKeys("id", "txtState", "andhraprdesh");
	    browser.SendKeys("id", "cmbDistrict", "Hyderabad");
	    browser.SendKeys("id", "txtAddress", "ameerpate BSNL office");
	    browser.SendKeys("id", "txtZIP", "500082");
	    browser.SendKeys("id", "txtPhone", "8801860334");
	    browser.SendKeys("id", "txtComments", "This is LocTION OF THE MAIN BRANCH");
	    browser.click("id", "editBtn");
	    browser.waitforPageToload();
	    login.Logout();
	    browser.closeBrowser();
	    browser.QuitBrowser();
	    	    
	    
	    //browser.click("xpath", ".//*[@id='admin']/ul/li[1]/a/span");
	    
	    
	    
		
	}
	
	
	
	

}

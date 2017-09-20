package TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import GeneralLogin.Admin;
import GeneralLogin.Login;

public class TC7_deleteLocation extends RootTest
{
	static Login login = new Login(browser); 
	static Admin admin= new Admin(browser);
	@Test
	public void deleteLocation() throws FileNotFoundException, IOException
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
	    browser.SelectFrameById("rightMenu");
	    admin.setup();
	    admin.deleteLocationInTable("hyderabad");
	    browser.acceptAlert();
	    browser.Successfulmessage("Successfully Deleted");
	    login.Logout();
	    browser.closeBrowser();
	    browser.QuitBrowser();
	    
	    
	   /* browser.VerifyElementInTable("html/body/div/div[2]/form/table/tbody/tr[1]/td[1]/a", "Hyderabad");
	    browser.click("xpath", "html/body/div[1]/div[2]/form/table/tbody/tr[1]/td[1]/input");
	    browser.click("xpath", "html/body/div/div[2]/form/div[3]/div[1]/input[2]");
	    browser.Successfulmessage("Successfully Deleted");*/
	}

}

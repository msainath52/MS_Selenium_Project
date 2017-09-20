package TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import GeneralLogin.Admin;
import GeneralLogin.Login;

public class TC6_editLocation extends RootTest
{
	static Login login = new Login(browser); 
	static Admin admin= new Admin(browser);
	@Test
	public void editLocation() throws FileNotFoundException, IOException
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
	    admin.editLocation("hyderabad");  
	    browser.waitUntilElementTObePresent("//html/body/div[1]/div[3]/div[2]/div/h2");
	    browser.click("id", "editBtn");
	    browser.clearTextField("id", "txtState");
	    browser.SendKeys("id", "txtState", "andhrapradesh");
	    browser.clearTextField("id", "cmbDistrict");
	    browser.SendKeys("id", "cmbDistrict", "Tirupathi");
	    browser.clearTextField("id", "txtZIP");
	    browser.SendKeys("id", "txtZIP", "500037");
	    browser.click("id", "editBtn");
	    browser.waitforPageToload();
	    login.Logout();
	    browser.closeBrowser();
	    browser.QuitBrowser();
	   
	   
	    
	}
	

}

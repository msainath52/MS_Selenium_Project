package TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import GeneralLogin.Admin;
import GeneralLogin.Login;

public class TC5_deleteEmployee extends RootTest
{
	static Login login=new Login(browser);
	static Admin admin= new Admin(browser);
	@Test
	public void deleteEmployee() throws FileNotFoundException, IOException
	{
		browser.StartBrowser();
		browser.maximizeBrowser();
		browser.VerifyTitle("OrangeHRM - New Level of HR Management");
		login.setup();
		login.LogintoApp("qaplanet1", "user1");
		browser.waitforPageToload();
	    browser.VerifyTitle("OrangeHRM");
	    browser.SelectFrameById("rightMenu");
	    browser.VerifyElementInTable(".//*[@id='standardView']/table/tbody/tr[4]/td[3]/a", "qa planet");
	    System.out.println("This element is present in the table");	
	    browser.click("xpath", ".//*[@id='standardView']/table/tbody/tr[4]/td[1]/input");
	    browser.click("xpath", ".//*[@id='standardView']/div[3]/div[1]/input[2]");
	    browser.Successfulmessage("Successfully Deleted");
	    login.Logout();
	    browser.closeBrowser();
	    browser.QuitBrowser();
	    
		
	}
	

}

package TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;


import org.testng.annotations.Test;

import GeneralLogin.Login;

public class TC4_editEmployee extends RootTest
{
	static Login login=new Login(browser);
	@Test
	public static void editEmployee() throws FileNotFoundException, IOException
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
	    browser.click("xpath", ".//*[@id='standardView']/table/tbody/tr[4]/td[3]/a");
	    browser.waitUntilElementTObePresent(".//*[@id='personal']/div[1]/div[2]/div[1]/h2");
	    browser.click("id", "btnEditPers");
	    browser.SendKeys("id", "txtEmpNickName", "Sreedhar");
	    browser.SendKeys("id", "txtNICNo", "223-112-223");
	    browser.SelectItemFromDroopdrown("id", "cmbNation");
	    browser.click("id", "btnEditPers");
	    System.out.println("Employee details are updated");
	    login.Logout();
	    browser.closeBrowser();
	    browser.QuitBrowser();
	       

    }
}

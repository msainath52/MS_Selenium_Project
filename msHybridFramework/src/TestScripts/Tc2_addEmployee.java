package TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import GeneralLogin.Login;

public class Tc2_addEmployee extends RootTest
{
	static Login login=new Login(browser);
	@Test
	public static void addEmployee() throws FileNotFoundException, IOException
	{
		browser.StartBrowser();
		browser.maximizeBrowser();
		browser.VerifyTitle("OrangeHRM - New Level of HR Management");
		login.setup();
		login.LogintoApp("qaplanet1", "user1");
		browser.waitforPageToload();
	    browser.VerifyTitle("OrangeHRM");
	    login.addEmployee("qa", "planet");
	    login.verifyItemInEmpList("qa", "planet");
	    login.Logout();
	    browser.closeBrowser();
	    browser.QuitBrowser();
		
	}
	

}

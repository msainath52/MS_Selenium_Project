package TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import GeneralLogin.Login;

public class Tc1_addEmployeeLogin extends RootTest 
{
	static Login login = new Login(browser);
	@Test
	public static void verifyOrangeHrm() throws FileNotFoundException, IOException, InterruptedException
	{
		browser.StartBrowser();
		//browser.wait(2000);
		browser.maximizeBrowser();
		browser.VerifyTitle("OrangeHRM - New Level of HR Management");
		login.setup();
	    login.LogintoApp("qaplanet1", "user1");
		browser.waitforPageToload();
		login.Logout();
		browser.closeBrowser();
		browser.QuitBrowser();
		
	}

}

package TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import GeneralLogin.Admin;
import GeneralLogin.Login;

public class TC10_deleteJobDeatils extends RootTest
{
	static Login login=new Login(browser);
	static Admin admin= new Admin(browser);
	@Test
	public static void deletejob() throws FileNotFoundException, IOException
	{
	browser.StartBrowser();
	browser.maximizeBrowser();
	browser.VerifyTitle("OrangeHRM - New Level of HR Management");
	login.setup();
	login.LogintoApp("qaplanet1", "user1");
	browser.waitforPageToload();
    browser.VerifyTitle("OrangeHRM");
    admin.deleteJob("Quality Assurance");
    browser.acceptAlert();
    login.Logout();
    browser.closeBrowser();
    browser.QuitBrowser();
    
    
	}
	

}

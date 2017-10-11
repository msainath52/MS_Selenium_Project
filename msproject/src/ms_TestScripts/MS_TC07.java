package ms_TestScripts;

import org.testng.annotations.Test;

import ms_LIB.MS_BusinessFunctions;

public class MS_TC07 {

@Test
	

	public void AddEmployee()
	{
	
		MS_BusinessFunctions Br = new MS_BusinessFunctions ();
		Br.Configuration("Chrome");
		Br.OpenApplication("http://apps.qaplanet.in/qahrm/login.php");
		Br.LoginToOrangeHRM("qaplanet1", "user1");
		Br.LogoutFromApp();
		Br.closebrowser();
		Br.quitobject();
		
		
	}			
}

package ms_TestScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import ms_LIB.MS_BusinessFunctions;

public class MS_TC05 {

@Test
	

	public void AddEmployee() throws Exception
	{
	
		MS_BusinessFunctions Br = new MS_BusinessFunctions ();
		Br.Configuration("Chrome");
		Br.OpenApplication("http://apps.qaplanet.in/qahrm/login.php");
		Br.LoginToOrangeHRM("qaplanet1", "user1");
		Br.addlocation();
		Br.LogoutFromApp();
		Br.closebrowser();
		Br.quitobject();
		
		
	}			
}

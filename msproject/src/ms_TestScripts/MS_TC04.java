package ms_TestScripts;

import org.testng.annotations.Test;

import ms_LIB.MS_BusinessFunctions;

public class MS_TC04 {

@Test
	

	public void AddEmployee() throws Exception
	{
	

	MS_BusinessFunctions Br = new MS_BusinessFunctions ();
	Br.Configuration("Chrome");
	Br.OpenApplication("http://classroom:90/qahrm/login.php");
	Br.LoginToOrangeHRM("qaplanet1", "user1");
	Br.AddEmployee("QAP","Tset");
	Br.edit_employee("QAP","Tset");
	Br.LogoutFromApp();
	Br.closebrowser();
	Br.quitobject();
		
	}			
}

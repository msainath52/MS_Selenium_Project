package GeneralLogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import GeneralBrowsers.Browser;

public class Login
{
	Browser browser;
	//Constructor with one argument 
	public Login(Browser br)
	{
		browser=br;
	}
	
	
	//Initializing the and assigning of properties file
	Properties locators = new Properties();
	File locFile= new File("D:\\subbu\\MY Project\\src\\ElementLocations\\Login.properties"); 
	//Setup the for property files
	public void setup() throws FileNotFoundException, IOException
	{
		locators.load(new FileInputStream(locFile));
		
	}
	//Login into the application 
	public void LogintoApp(String username, String password)
	{
		String usenameloc= locators.getProperty("Username.textField.loc");
		String passwordloc=locators.getProperty("Password.textField.loc");
		String Loginbtnloc=locators.getProperty("Login.Button.loc");
		//Verify the Username and password
		browser.verifyElmentPresent("name", usenameloc);
		browser.clearTextField("name", usenameloc);
		browser.SendKeys("name", usenameloc, username);
		//verify the paswword field
		browser.verifyElmentPresent("name", passwordloc);
		browser.clearTextField("name", passwordloc);
		browser.SendKeys("name", passwordloc, password);
		browser.verifyElmentPresent("xpath", Loginbtnloc);
		browser.click("xpath", Loginbtnloc);
		browser.waitforPageToload();
	}
		
	public void Logout()
	{
		//Select frame 
		browser.SelectDefaultFrame();
		browser.click("linkText", "Logout");
	}
	public void addEmployee(String FirstName,String lastName)	
	{
		//click on add
		browser.startActions();
		//select frame 
		browser.SelectFrameById("rightMenu");
		browser.click("xpath", ".//*[@id='standardView']/div[3]/div[1]/input[1]");
		//wait until the element to be loaded 
		browser.waitUntilElementTObePresent("//*[@id='frmEmp']/div/div/div[2]/div/h2");
		browser.verifyText("xpath", "//*[@id='frmEmp']/div/div/div[2]/div/h2", "PIM : Add Employee");
		browser.SendKeys("name", "txtEmpLastName", lastName);
		browser.SendKeys("name", "txtEmpFirstName", FirstName);
		//click on save button
		browser.click("id", "btnEdit");
		browser.waitUntilElementTObePresent("//*[@id='personal']/div/div[2]/div/h2");
		
		
	}
	public void verifyItemInEmpList(String FirstName,String lastName)
	{
		//select frame 
		browser.SelectDefaultFrame();
		//click on employee list
			
		browser.click("linkText", "PIM");
		//select frame 
		browser.SelectFrameById("rightMenu");
		//wait for employee list to be displayed
		browser.waitUntilElementTObePresent("//*[@id='standardView']/div/h2");
		//verify the employee information text
		browser.verifyText("xpath", "//*[@id='standardView']/div/h2", "Employee Information");
		String itemname=FirstName + " "+lastName;
		browser.VerifyElementInTable("//*[@id='standardView']/table/tbody/tr/td[3]", itemname);
		
	}
}
	


package ms_testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MS_Selenium_TC_01 {

	public static void main(String[] args) throws Exception {
		
      		
	   System.setProperty("webdriver.chrome.driver", "D:\\tet\\chromedriver.exe");  
		
	   ChromeDriver Driver = new ChromeDriver();
	   Driver.get("http://apps.qaplanet.in/qahrm/login.php");
	   
// Wait 2 sec
	   Thread.sleep(2000);
	   
//Verify home page
	   if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
	   {
	   System.out.println("Home Page displayed");
	   }
	   else
	   {
	   System.out.println("Failed to open home page");
	   return; 
	   
	   }
	   
//Create WebElements for user name,password,login and clear
	   
	   WebElement objUserName=Driver.findElement(By.name("txtUserName"));
	   WebElement objPassword=Driver.findElement(By.name("txtPassword"));
	   WebElement objLogin=Driver.findElement(By.name("Submit"));
	   WebElement objClear=Driver.findElement(By.name("clear"));	
//-------------------------------------------------------------

//Verify user name
	 if(objUserName.isDisplayed())
	 {
	 System.out.println("User name displayed");
	 }
//Verify password
	 if(objPassword.isDisplayed())
	 {
	 System.out.println("Password displayed");
	 }
//Verify login and clear
	 if(objLogin.isDisplayed() && objClear.isDisplayed())
	 {
	 System.out.println("Login and clear buttons are displayed");
	 }

//---------------------------------------------------------------
	 String strUserName="qaplanet1";
	 String strPassword="user1";
//--------------------------------------------------------------
//Login to orangeHRM
	 objUserName.clear();
	 objUserName.sendKeys(strUserName);
	 objPassword.clear();
	 objPassword.sendKeys(strPassword);
	 objLogin.click();
//wait 2 sec
	 Thread.sleep(2000);
 
//Verify OrangeHRM
	 if(Driver.getTitle().equals("OrangeHRM"))
	 {
	 System.out.println("OrangeHRM displayed");
	 }
	 else
	 {
	 System.out.println("Faile dto login");
	 return;
	 }
//--------------------------------------------------------------

	//Get welcome text
	 String strWelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();

//Verify welcome text
	 if(strWelText.equals("Welcome "+strUserName))
		 
     	 {
		 System.out.println("Welcome "+strUserName+" displayed");
	     }

//Create webelements for change password and logout
	 WebElement objChangePassword=Driver.findElement(By.linkText("Change Password"));
	 WebElement objLogout=Driver.findElement(By.linkText("Logout"));
	 
//Verify change password and logout
	 if(objChangePassword.isDisplayed() && objLogout.isDisplayed())
	 {
	 System.out.println("Change password and logout are displayed");
	 }
//---------------------------------------------------------------

//Click on logout
	 objLogout.click();

//wait 2 sec
	 Thread.sleep(2000);
	 
//Verify home page
	 if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
	 {
	 System.out.println("Signoff sucessfull & Home Page displayed");
	 }
	 else
	 {
	 System.out.println("Failed to Signoff");
	 return;

	 } 	 

//--------------------------------------------------------------
	 Driver.close();
	 Driver.quit();

	 
	}

 }

package ms_robot_classexamples;

		
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

		
		
		public class MS_RobotExamples {

			public static void main(String[] args) throws Exception {
				
				System.setProperty("webdriver.chrome.driver", "D:\\tet\\chromedriver.exe");
				ChromeDriver Driver=new ChromeDriver();
				
//Maximize browser
				Driver.manage().window().maximize();
				
//------------------------------------------------
				WebDriverWait wait=new WebDriverWait(Driver, 60);
				Actions Act=new Actions(Driver);
//------------------------------------------------

//Open orangeHRM
				Driver.get("http://apps.qaplanet.in/qahrm/login.php");
				
//Create webelements for user name,password,login and clear
				WebElement objUserName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
				WebElement objPassword=Driver.findElement(By.name("txtPassword"));
				WebElement objLogin=Driver.findElement(By.name("Submit"));
			
				
				
//-------------------------------------------------------------
				
				String strUserName="qaplanet1";
				String strPassword="user1";
//--------------------------------------------------------------
				
//Login to orangeHRM
				objUserName.clear();
				objUserName.sendKeys(strUserName);
				objPassword.clear();
				objPassword.sendKeys(strPassword);
				objLogin.click();

//--------------------------------------------------------------
//Get welcome text
						String strWelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
						
//Get only user name
						String[] Arr=strWelText.split(" ");
						String sUN=Arr[1].trim();
						if(sUN.equals(strUserName))
						{
						System.out.println(strUserName+" displayed");
						}

//Create webelements for change password and logout
					
						WebElement objLogout=Driver.findElement(By.linkText("Logout"));	
						
//Create webElement for PIM
						WebElement objPIM=Driver.findElement(By.id("pim"));
						
//Mouse over on pim
						Act.moveToElement(objPIM).perform();
						
//Click on add employee
						Driver.findElement(By.linkText("Add Employee")).click();
						
//wait for frame and switch to it
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
						
//Get employee code
						String sEmpcode=Driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
						
//----------------------------------------------------------------
						String sFN="Sainath";
						String sLN="M";
//----------------------------------------------------------------
						
//Create webElement for save
						WebElement objsave=Driver.findElement(By.id("btnEdit"));
						
//Click on saveobj
						objsave.click();
										
//wait for alert
						Alert A=wait.until(ExpectedConditions.alertIsPresent());
						
//Click on save
						
//wait for alertA
						A.accept();
						Driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
						
						
//Click on save
						objsave.click();
						A.accept();
						Driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
						
						
// Create object for robot class
						
						Robot rt = new Robot();
						
// Click on photo file
						
						WebElement objBowse = Driver.findElement(By.name("photofile"));
						
						objBowse.click();
						
// Load image path/ any file
						
			StringSelection ss = new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
			
//Set image path to default window
			
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			
			rt.delay(2000);
			
//rt.keyPress(key);
			
						
			rt.keyPress(KeyEvent.VK_CONTROL);			
			rt.keyPress(KeyEvent.VK_V);		
			rt.keyRelease(KeyEvent.VK_V);		
			rt.keyRelease(KeyEvent.VK_CONTROL);	
			rt.delay(2000);
			rt.keyPress(KeyEvent.VK_ENTER);	
			rt.delay(1000);
			rt.keyRelease(KeyEvent.VK_ENTER);	
			rt.delay(1000);
							
			
			objsave.click();
//wait for Personal Details
						if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details")))
						{
						System.out.println("Personal Details displayed");
						}

//Switch to parent frame
						Driver.switchTo().parentFrame();

//----------------Employee list-----------------------------------------------
//Mouse over on pim
						Act.moveToElement(objPIM).perform();
						
//Click on Employee List
						Driver.findElement(By.linkText("Employee List")).click();
						
//wait for frame and switch to it
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
				
//-------------------------Check empployee details---------------------------------------------------
//Get row count
								int rc=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
								int i;
								for(i=1;i<=rc;i++)
								{

//Get second column data
								String sEmpID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
//Get third column data
								String sEmpName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
								if(sEmpName.equals(sFN+" "+sLN) && sEmpID.equals(sEmpcode))
								{
								System.out.println(sEmpcode+" , "+sEmpName+" displayed at: "+i);
								break;
								}
								}
							
//Switch to top frame
								Driver.switchTo().defaultContent();
//---------------------------------------------------------------------------
//Click on logout
								objLogout.click();
				
				
//--------------------------------------------------------------
								Driver.close();
								Driver.quit();

				

	}

}
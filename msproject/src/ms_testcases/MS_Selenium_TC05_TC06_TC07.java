package ms_testcases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.unix.X11.Display;

public class MS_Selenium_TC05_TC06_TC07 
{

//                         ADD LOCATION
	
	public static void main(String[] args) throws Exception 
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		
		//Maximize browser
		Driver.manage().window().maximize();
		
		//------------------------------------------------
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		Actions Act=new Actions(Driver);
		//------------------------------------------------

// S.No 1 -  Open HRM home page=============================================================================================
		
		Driver.get("http://classroom:90/qahrm/login.php");
		
        //Verify home page		
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
		System.out.println("Home Page displayed");
		}
		else
		{
		System.out.println("Failed to open home page");
		return;
		
		}
		
// S.No 2  -  Enter Valid UN,PWD, and Click on Login=========================================================================		
		

        //Create webelements for user name,password,login and clear
		WebElement objUserName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement objPassword=Driver.findElement(By.name("txtPassword"));
		WebElement objLogin=Driver.findElement(By.name("Submit"));
		WebElement objClear=Driver.findElement(By.name("clear"));
		
		
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
		// This will take next page
		//Verify OrangeHRM
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
		{
		System.out.println("OrangeHRM displayed");
		}
		else
		{
		System.out.println("Failed to login");
		return;
		}

		//Get welcome text  - First approach
		String strWelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
		//Verify welcome text
		if(strWelText.equals("Welcome "+strUserName))
		{
		System.out.println("Welcome "+strUserName+" displayed");
		}
// S.No 3  -  Focus on Admin=================================================================================================
		
		Driver.navigate().refresh();
		WebElement OBJADM = Driver.findElement(By.id("admin"));
		if(OBJADM.isDisplayed())
		{
			System.out.println("Admin is Displayed");
		}
		else
		{
			System.out.println("Admin is not Dispayed");
		
		return;
	    }
		// Mouse Over
		Act.moveToElement(OBJADM).perform();
		
		//Creat objects for Company info, Job, Qualifications, Skills .. Etc		
		WebElement OBJCOM = Driver.findElement(By.linkText("Company Info"));
		WebElement OBJJOB = Driver.findElement(By.linkText("Job"));
		WebElement OBJQAL = Driver.findElement(By.linkText("Qualification"));
		WebElement OBJSKL = Driver.findElement(By.linkText("Skills"));
		
		if(OBJCOM.isDisplayed()&&OBJJOB.isDisplayed()&&OBJQAL.isDisplayed()&&OBJSKL.isDisplayed())
			
		{
			System.out.println("Company information,Job,Qualification and Skills are displayed");
		}
		else
		{
			System.out.println("Company information,Job,Qualification and Skills are not displayed");
		return;	
		}
		
// S.No 4  -  Focus on Company info==========================================================================================	
		
		// Mouse Over		
		Act.moveToElement(OBJCOM).perform();;
		
		// Create objects for General, Locations, Company Structure, and Company Property		
		WebElement OBJGNL = Driver.findElement(By.linkText("General"));
		WebElement OBJLOC = Driver.findElement(By.linkText("Locations"));
		WebElement OBJCSTR = Driver.findElement(By.linkText("Company Structure"));
		WebElement OBJCPRO = Driver.findElement(By.linkText("Company Property"));

		// Verify General, Locations,Company Structure and Company Property		
		if(OBJGNL.isDisplayed()&&OBJLOC.isDisplayed()&&OBJCSTR.isDisplayed()&&OBJCPRO.isDisplayed())
		{
			System.out.println("General, Locations, Company Structure and Company Property are Displayed");
		}
		
		else
		{
			System.out.println("General, Locations, Company Structure and Company Property are Displayed");
		
		return;	
		}
		
// S.No 5  -  Click on Locations=============================================================================================
		
		Act.moveToElement(OBJLOC).click().perform();
		
		//Wait for Frame and Swich to it		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));

		// Verify Company Info: Locations		
		if(Driver.findElement(By.cssSelector(".mainHeading>h2")).getText().equals("Company Info : Locations"))
		{
			System.out.println("Company Info : Locations is Displayed");
		}
		else
		{
			System.out.println("Company Info : Locations is not Displayed");
			
		}

		// Verify All		
		if(Driver.findElement(By.cssSelector(".searchbox>label")).getText().equals("Search By:"))
		{
			System.out.println("Search By: is Displayed");
		}
		else
		{
			System.out.println("Search By: is not Displayed");
		}
		
		// Creat objects for search by and search for		
		WebElement OBJSBY = Driver.findElement(By.name("loc_code"));
		WebElement OBJSFOR = Driver.findElement(By.name("loc_name"));
			
		if(OBJSBY.isDisplayed())
		{
			System.out.println("Location ID is Displayed");
		}
		else
		{
			System.out.println("Location ID is not Displayed");
			
		}
		
		if(OBJSFOR.isDisplayed())
		{
			System.out.println("Location Name is Displayed");
		}
		
		else
		{
			System.out.println("Location Name is not Displayed");
		}
		
		WebElement OBJSRH = Driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/input[2]"));
		WebElement OBJRST = Driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/input[3]"));
		WebElement OBJADD = Driver.findElement(By.xpath("//input[@value='Add']"));
		WebElement OBJDLT = Driver.findElement(By.xpath("//input[@value='Delete']"));
		
		if(OBJSRH.isDisplayed())
		{
			System.out.println("Search Button is Displayed");
		}
		else
		{
			System.out.println("Search Button is not Displayed");
		}
		
		if(OBJRST.isDisplayed())
		{
			System.out.println("Reset Button is Displayed");
		}
		else
		{
			System.out.println("Reset Button is not Displayed");
		}
		
		if(OBJADD.isDisplayed())
		{
			System.out.println("Add Button is Displayed");
		}
		else
		{
			System.out.println("Add Button is not Displayed");
		}
		
		if(OBJDLT.isDisplayed())
		{
			System.out.println("Delet Button is Displyed");
		}
		else
		{
			System.out.println("Delete Button is not Displayed");
		}
		
//====================== Type 2 Method ============================	
		
		/*if(OBJSRH.isDisplayed()&&OBJRST.isDisplayed()&&OBJADD.isDisplayed()&&OBJDLT.isDisplayed())
		{
			System.out.println("Search,Reset,Add and Delete Buttons are Displayed");
		}
		
		else
		{
			System.out.println("Search,Reset,Add and Delete Buttons are not Displayed");
		}
*/		
	
// S.No 6  -  Click on Add===================================================================================================
		
		OBJADD.click();
		
		// Verify Company Info Location		
		Thread.sleep(2000);
		
		if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getTagName().equals("Company Info : Locations"))
		{
			System.out.println("Company Info : Locations and all fields are Displayed");
		}
		else
		{
			System.out.println("Company Info : Locations and all fields are not Displayed");
		}
		
		// Create object for save		
		WebElement OBJSAVE = Driver.findElement(By.id("editBtn"));
		
		OBJSAVE.click();
		
		Thread.sleep(3000);
		//Create Alert		
		Alert A = Driver.switchTo().alert();
				
		//Verify empty fields		
		if(A.getText().equals("Please correct the following\n\n	- Location Name has to be specified\n	- Country should be selected!\n	- Address should be specified\n	- Zip Code should be specified\n"))
		{
			System.out.println("First Alert is Displayed as'Location Name, Country Address, Zip Code shuld be specified'");
		}
		else
		{
			System.out.println("First Alert is NOT Displayed as'Location Name, Country Address, Zip Code shuld be specified'");
		}
		
		// Alert Accept is for OK button		
		A.accept();
		
		String LCNAME = "Hemanth";
		
		// Enter name		
		WebElement OBJLNAME = Driver.findElement(By.name("txtLocDescription"));
		OBJLNAME.clear();
		OBJLNAME.sendKeys(LCNAME);
		OBJSAVE.click();
		
		// Verify name		
		if(A.getText().equals("Please correct the following\n\n	- Country should be selected!\n	- Address should be specified\n	- Zip Code should be specified\n"))
		{
			System.out.println("Second alert is Displayed as'Country Address, Zip Code shuld be specified");
		}
		else
		{
			System.out.println("Second alert is NOT Displayed as'Country Address, Zip Code shuld be specified");
		}

		// Alert Accept is for OK button		
		A.accept();
		
		Thread.sleep(2000);
		
		// Select Country		
		WebElement OBJCNTR = Driver.findElement(By.id("cmbCountry"));
		Select SCNTR = new Select(OBJCNTR);
		SCNTR.selectByVisibleText("India");
		OBJSAVE.click();
		
		//Verify Country		
		if(A.getText().equals("Please correct the following\n\n	- Address should be specified\n	- Zip Code should be specified\n"))
		{
		   System.out.println("Third Alert is Dispalyed as'Please correct the following\n\n	- Address should be specified\n	- Zip Code should be specified\n'");	
		}
		else
		{
			System.out.println("Third Alert not Dispalyed as'Please correct the following\n\n	- Address should be specified\n	- Zip Code should be specified\n'");	
		}
		
		// Alert Accept is for OK button		
				A.accept();	
				
		// Enter Address				
		Driver.findElement(By.id("txtAddress")).clear();
		Driver.findElement(By.id("txtAddress")).sendKeys("Hemanth Kumar, Hyderabad");
		
// Click on save
		
		OBJSAVE.click();
		
// Verify Address
		
		if(A.getText().equals("Please correct the following\n\n	- Zip Code should be specified\n"))
		{
			System.out.println("Fourth alert is displayed as'Please correct the following\n\n	- Zip Code should be specified\n'");
		}
		else
		{
			System.out.println("Fourth alert not displayed as'Please correct the following\n\n	- Zip Code should be specified\n'");
		}
		
// Alert Accept is for OK button
		
		A.accept();		
		
// Enter zip code
		
		Driver.findElement(By.id("txtZIP")).clear();
		Driver.findElement(By.id("txtZIP")).sendKeys("500020");
		Thread.sleep(3000);;
		
// Click on save		
		
		OBJSAVE.click();
		
		Thread.sleep(3000);
		
// Verify Company Info Location
		
		if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Company Info : Locations"))
		{
			System.out.println("Company Info : Locations is displayed");
		}
		else
		{
			System.out.println("Company Info : Locations is not displayed");
		}
		
		Thread.sleep(3000);
		
// Verify successfully added or not
		
		if(Driver.findElement(By.xpath("//div[@class='messagebar']")).getText().equals("Successfully Added"))
		{
			System.out.println("Successfully Added");
		}
		else
		{
			System.out.println("Failed to Add");
		}
		
//To get row count
		
		int rc = Driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
		
		System.out.println(rc);
		
		int i;
		
// Loop for selecting row count
		
		for(i=rc;i<=rc;i++)
		{
			// Get location name info details
			
			String LNAME = Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();
		
		if(LNAME.equals(LCNAME))
		  {
			System.out.println(LCNAME+"Displayed at:"+i);
		  }
		


		Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
		
		}
		
//================================== Edit Location ======================================================================		
		
		
		
//Verify company locaton
		
		if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Company Info : Locations"))
		{
			System.out.println("Company Info : Locations is displayed");
		}
		else
		{
			System.out.println("Company Info : Locations is not displayed");
		}
		
		Thread.sleep(3000);
// click on edit button		
		
		Driver.findElement(By.xpath("//*[@id='editBtn']")).click();
		
		WebElement OBJLNAME1 = Driver.findElement(By.id("txtLocDescription"));
		OBJLNAME1.clear();   // previous text will be cleared

// update with new name		
		
		String NEWNAME = "Hemanth Kumar";
		OBJLNAME1.sendKeys(NEWNAME);
// Click on save button
		
		Driver.findElement(By.xpath("//input[@value='Save']")).click();		
		
		
//To get row count
		
				int rc1 = Driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
				
				System.out.println(rc1);
				
				Thread.sleep(3000);
				
				int j;
				
// Loop for selecting row count
				
				for(j=rc1;j<=rc1;j++)
				{
// Verify new name
					
					String LNAME1 = Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).getText();
				
				if(LNAME1.equals(NEWNAME))
				  {
					System.out.println(NEWNAME+"Displayed at:"+j);
				  }
				
// Click on check box
				
				Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[1]/input")).click();
			
				}
	
	
// ======================================== Delete Location =================================================================

				// Click on Delete Button
				
				Driver.findElement(By.xpath("//input[@value='Delete']")).click();
				Driver.switchTo().alert().accept();
	
				// Verify succefu delete message
				
				String OBJMSG = Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/span")).getText();
				if(OBJMSG.equals("Successfully Deleted"))
				{
					System.out.println("Successfully Deleted is Displayed");
				}
				else
				{
					System.out.println("Successfully Deleted is not Displayed");
				}
				
				
				Driver.switchTo().defaultContent();
				
				// Click on Logout
				
				Driver.findElement(By.linkText("Logout")).click();
				
				
				
		        //Verify home page		
				if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
				{
				System.out.println("Home Page displayed");
				}
				else
				{
				System.out.println("Failed to open home page");
				return;
				
				}
				
				Driver.close();
				Driver.quit();
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	

}

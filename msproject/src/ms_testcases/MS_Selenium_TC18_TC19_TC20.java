package ms_testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MS_Selenium_TC18_TC19_TC20 
{

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
		
		
// S.No 5  -  Click on Company Structure
		
		// Mouse Over and click		
				Act.moveToElement(OBJCSTR).click().perform();
				
		// Wait for frame and swich to				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
				
		// Create webelement for Company Info : Company Structure				
				WebElement OBJCINFO = Driver.findElement(By.xpath("//*[@id='layerComStruct']/h2"));
				
		// verify
				if(OBJCINFO.getText().equals("Company Info : Company Structure"))
				{
					System.out.println("Company Info : Company Structure is Dispalyed");
				}
				else
				{
					System.out.println("Company Info : Company Structure is not Dispalyed");
				}
				
		// Verify sub division of QA planet	
				
				if(Driver.findElement(By.xpath("//*[@id='tblCompStruct']/tbody/tr[1]/td[1]")).getText().equals("QAPLANET"))
				{
					System.out.println("QAPLANET sub division is displayed");
				}
				else
				{
					System.out.println("QAPLANET sub division is not displayed");
				}
				
// S. No 6  -  Click on Add ============================================================================================
				
				Driver.findElement(By.xpath("//a[@class='add']")).click();
				Thread.sleep(1000);
				
				// Verify Add a sub-division to QAPLANET
				
				if(Driver.findElement(By.xpath("//h3[@id='parnt']")).getText().equals("Add a sub-division to QAPLANET"))
				{
					System.out.println("Add a sub-division to QAPLANET is Displyed");
				}
				else
				{
					System.out.println("Add a sub-division to QAPLANET is not Displyed");
				}
				
// S.No 7  -  Enter Department ID,Name,Type,Location and description and click on save ===================================
				
				// Create webelements for Department ID,Name,Type,Location and description and click on save
				
				String DPTID = "QA Planet";
				String NAME = "Hemanth";
				
				WebElement OBJDPTID = Driver.findElement(By.name("txtDeptId"));
				WebElement OBJNAME = Driver.findElement(By.name("txtTitle"));
				WebElement OBJTYPE = Driver.findElement(By.name("cmbType"));
				WebElement OBJLOC1 = Driver.findElement(By.name("cmbLocation"));
				WebElement OBJDESC = Driver.findElement(By.name("txtDesc"));
				
				// Verify above
				
				if(OBJDPTID.isDisplayed()&&OBJNAME.isDisplayed()&&OBJTYPE.isDisplayed()&&OBJLOC1.isDisplayed()&&OBJDESC.isDisplayed())
				{
					System.out.println("Department ID,Name,Type,Location and description - are displayed");
				}
				else
				{
					System.out.println("Department ID,Name,Type,Location and description - are not displayed");
				}
				
				Select STYPE=new Select(OBJTYPE);
		           
		           OBJDPTID.clear();
		           OBJDPTID.sendKeys(DPTID);
		           // CLICK ON SAVE
		           Driver.findElement(By.xpath("//input[@value='Save']")).click();
		           Thread.sleep(1000);
		          // CREATE ALERT
		           
		           Alert A=Driver.switchTo().alert();
		           
		           // VERIFY ALERT
		           if(A.getText().equals("Following errors were found:\n\n- Sub-division Name cannot be empty.\n- Please select a Type or define a custom type.\n"))
		          {
		          System.out.println("ALERT MESSAGE IS DISPLAYED");
		          }
		           A.accept();
		           Thread.sleep(1000);
		           
		           OBJNAME.clear();
		           OBJNAME.sendKeys(NAME);
		           STYPE.selectByVisibleText("Department");
		           Thread.sleep(1000);
		           Select SLOC=new Select(OBJLOC1);
		           
		           
		           SLOC.selectByVisibleText("Ameerpet");
		           
		           Driver.findElement(By.id("txtDesc")).sendKeys("Add");
		           
		           // CLICK ON SAVE
		            Driver.findElement(By.xpath("//input[@value='Save']")).click();
		           Thread.sleep(3000);
		           
		           
		           //*********************************************************************************************************************
		           
		           
		           // ROW COUNT
		           
		           // List<WebElement> LIST1=driver.findElements(By.xpath("//html/body/div[1]/table/tbody/tr/td/a"));
		     
		     /*     int rc=driver.findElements(By.xpath("//html/body/div[1]/table/tbody/tr")).size();
		          System.out.println(rc);
		          int i;
		            
		            for(i=rc;i<=rc;i++)
		            //for(int i: LIST1)
		          System.out.println(i);
		       
		     {
		     String[] ARR1=DPTID.split(NAME);
		         //  String DPTID1=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr["+i+"]/td[1]")).getText();
		         // String NAM=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr["+i+"]/td[1]/a")).getText();
		           if(ARR1[i].equals(DPTID))
		           {
		           System.out.println(DPTID+" DISPLAYED");
		           }
		         //  if(DPTID1.equals(DPTID)&&NAM.equals(NAME))
		          
		         //   if(NAM.equals(NAME))
		         //   {
		           System.out.println(NAME+" DISPLAYED AT: "+i);
		           
		         //   }
		           //else
		           //{
		         //  System.out.println(NAM);
		          // }
		         //  driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+i+"]/td[1]/a")).click();
		        
		     }
		            
		            
		       */   
		            // EDIT TC19
		            int rc=Driver.findElements(By.xpath("//html/body/div[1]/table/tbody/tr")).size();
		            for(int i=rc;i<=rc;i++)
		            {
		            Driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+i+"]/td[1]/a")).click();
		            
		            
		            }
		            Thread.sleep(2000);
		            
		            // VERIFY Add a sub-division to QA Planet
		               if(Driver.findElement(By.xpath("//h3[@id='parnt']")).getText().equals("Add a sub-division to QAPLANET"))
		               {
		               System.out.println("Add a sub-division to QA Planet IS DISPLAYED");
		               }
		               else
		               {
		               System.out.println("Add a sub-division to QA Planet IS NOT DISPLAYED");
		               
		               }
		            
		            // SEND DATA 
		            
		            Driver.findElement(By.name("txtTitle")).clear();
		            Driver.findElement(By.name("txtTitle")).sendKeys("POWER");
		            
		            // click on save
		            
		            Driver.findElement(By.xpath("//input[@value='Save']")).click();
		            Thread.sleep(2000);
		            
		         
		            for(int j=rc;j<=rc;j++)
		            {
		         //   driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+i+"]/td[1]/a")).click();
		            Driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+j+"]/td[4]/a")).click();
		            System.out.println(rc);
		            }
		            Thread.sleep(2000);
		            
		            if(A.getText().equals("Are you sure you want to delete POWER Department. It could cause the company structure to change."))
		            {
		           System.out.println("DELETE ALERT IS DISPLAYED");
		           A.accept();
		            }
		            else
		            {
		           System.out.println("DELETE ALERT IS NOT DISPLAYED");
		            }
		         	           
		           //*****************************************************************************************************************
		           
		           
// S.No 8  -  Click on logout
		           
		           Driver.switchTo().defaultContent();
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

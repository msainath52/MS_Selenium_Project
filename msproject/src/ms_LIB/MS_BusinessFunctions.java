package ms_LIB;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import static org.testng.Assert.*;

import java.awt.Desktop.Action;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MS_BusinessFunctions
{
	
	WebDriver Brow;
	WebDriverWait Wait;
	WebElement objUN;
	WebElement objPWD;
	WebElement PIM;
	Actions Act;
	WebElement objLogout;
	String Empname;
	String strinText;
	WebElement weJObEdit;
	WebElement eJob;
	Select sJob;

	WebElement eJobStat;
	Select sJobStat;
	//WebElement OBJJOB;
	//WebElement OBJQAL;
	//WebElement OBJSKL;
	WebElement OBJGNL;
	WebElement OBJLOC;
	WebElement OBJCSTR;
	WebElement OBJCPRO;
//	WebElement OBJSRH;
//	WebElement OBJRST;
//	WebElement OBJADD;
//	WebElement OBJDLT;
//	WebElement OBJSAVE;
	String LCNAME;
	WebElement OBJLNAME;
	Select SCNTR;
	WebElement OBJCNTR;
	String LNAME;
	//WebElement OBJLNAME1;
	//WebElement OBJLNAME1
	String NEWNAME;

	String OBJMSG;
	WebElement OBJADM;
	WebElement OBJCOM;
	WebElement OBJJOB;
	Alert A;
	//WebElement OBJADM;
	//WebElement OBJCOM;
	//WebElement OBJJOB;
	WebElement OBJQAL;
	WebElement OBJSKL;
	WebElement OBJJOB1;
	WebElement OBJJTTL;
	WebElement OBJJSPC;
	WebElement OBJJPAYG;
	WebElement OBJJEMST;
	WebElement OBJJEOJC;
	WebElement OBJSDROP;
	WebElement OBJSFOR;
	WebElement OBJDLT;
	WebElement OBJADD;
	WebElement OBJRST;
	WebElement OBJSRH;
	WebElement OBJSAVE;
	WebElement OBJJTN;
	WebElement OBJJDIS;
	String JTN;
	String JDIS;
	
	String JTN2;
int j;
int i;

int j2;
int rc;
	WebElement OBJEDIT2;
	
// Driver Configuration
	
	public void Configuration(String Browser)
	
	{
		if(Browser.equals("Firefox")) 
		{
		 System.setProperty("webdriver.gecko.driver","D:\\tet\\Selenium_Demp\\geckodriver.exe");
		 Brow = new FirefoxDriver ();		  	  
		}
		
		else if (Browser.equals("IE"))
		{
		  System.setProperty("webdriver.ie.driver","D:\\tet\\Selenium_Demp\\IEDriverServer.exe");
		  Brow = new InternetExplorerDriver();			
		}
		else if (Browser.endsWith("Chrome"))
		{
		  System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");   
		  Brow=new ChromeDriver();
		}
		else
		{
			System.out.println("Invlid Driver");
		}
		
		Wait = new WebDriverWait(Brow, 30);
		Brow.manage().window().maximize ();
		Act=new Actions(Brow);
		
		
	}

// Close Browser
	
	public void closebrowser()
	{
		Brow.close();
	}
	
// Quit Object
	
	public void quitobject()
	{
		Brow.quit();
	}
	

	
// Open Application
	
	public void OpenApplication(String url)
	{
		Brow.get(url);
		Wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
	

    // Verify Home Page
	
	    assertEquals(Brow.getTitle(),"OrangeHRM - New Level of HR Management");
	    Reporter.log("Home Page Displayd");
	    
	// Create Objects for UN and PWD
	    
	    objUN = Brow.findElement(By.name("txtUserName"));
	    objPWD = Brow.findElement(By.name("txtPassword"));
	    
	// Verify UN,PWD
	    
	    assertTrue(objUN.isDisplayed()&&objPWD.isDisplayed());
	    Reporter.log("UN,PWD are exists");    
	
	}
	
// Login to the application
	
	public void LoginToOrangeHRM(String username, String password)
	{
		objUN.sendKeys(username);
		objPWD.sendKeys(password);
		
		// click on login
		
		Brow.findElement(By.name("Submit")).click();
		Wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		
		// Verify Home Page
		
		assertEquals(Brow.getTitle(),"OrangeHRM"); 
		Reporter.log("OrangeHRM page is displayed");
		
		// Get welcome text
		
		String WelText = Brow.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText();
		
		// Verify welcome text
		
		assertEquals(WelText,"Welcome "+username);
		Reporter.log("welcome"+username+"displaye");		
	}
	
// Logout application
	
	public void LogoutFromApp()
	{
		// click on logout
		
		objLogout=Brow.findElement(By.linkText("Logout"));
		objLogout.click();
		Wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		
		// Verify Home Page
		
		assertEquals(Brow.getTitle(),"OrangeHRM - New Level of HR Management");
		Reporter.log("Sign Off & Succesful home page displayed");
		
	}	
		
// Add Employee
		
    public void AddEmployee(String FN,String LN) throws Exception
    {
    	Thread.sleep(2000);
 			//create object for  PIM
			PIM=Brow.findElement(By.id("pim"));
			
			//mouse over onPIM
			Act.moveToElement(PIM).perform();
			//click on add empleye
			Brow.findElement(By.linkText("Add Employee")).click();
			//wait for frame and switch to it
			Wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
			//Get PIM:Add Employee
		 String PIMText = Brow.findElement(By.xpath("//*[@id='frmEmp']/div/div[1]/div[2]/div[1]/h2")).getText();
		 //verify PIM:AddEployee
			if (PIMText.equals("PIM : Add Employee"))
			{
				Reporter.log("PIM : Add Employee displayed");
							}
			Brow.findElement(By.xpath("//input[@id='txtEmpFirstName']")).sendKeys(FN);
			Brow.findElement(By.name("txtEmpLastName")).sendKeys(LN);
			//cilck on Browse
			//Brow.findElement(By.id("photofile")).click();
			//wait 2sec 
			Thread.sleep(5000);
			//Runtime.getRuntime().exec("D:\\subbu\\Autoit\\upload.exe");
			//Runtime.getRuntime().exec("D:\\subbu\\Autoit\\upload.exe");
			Thread.sleep(8000);
			//click on save 
			Brow.findElement(By.id("btnEdit")).click();
			//wait for text
			Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='personal']/div[1]/div[2]/div[1]/h2"),"Personal Details"));
			//Go to default frame
			Brow.switchTo().defaultContent();
			//mouse over on PIM
			Act.moveToElement(PIM).perform();
			//click on Employee List
			Brow.findElement(By.linkText("Employee List")).click();
			//wait for frame and switch to it
			Wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
			//Get Emplayee Information
			String Emplnf=Brow.findElement(By.xpath("//*[@id='standardView']/div[1]/h2")).getText();
			//verify Employee information
			if (Emplnf.equals("Employee Information"))
			{
				Reporter.log("Employee Information displayed");
										}
			//Get row count
		            int rc=Brow.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();	
		            System.out.println(rc);
		            int i;
					for(i=1; i<=rc; i++)
										{
			//Get text from third column
				Empname=Brow.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				if (Empname.equals(FN+" "+LN))
				{
					Reporter.log(Empname+"displayedat"+i);
					break;
								}
			}
					
					Reporter.log("Add Employee");

 		}
    
    public void edit_employee(String FN,String LN)
	{
		
//-------------------------Check empployee details---------------------------------------------------
//Get row count
						int rc1=Brow.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
						int j;
						for(j=rc1;j<=rc1;j++)  // It considers the name which we enter in the last
						{

//Get second column data
							String sEmpID=Brow.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+j+"]/td[2]")).getText();
//Get third column data
						String sEmpName=Brow.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+j+"]/td[3]/a")).getText();
						if(sEmpName.equals(FN+" "+LN))
						{
						System.out.println(Brow+" , "+sEmpName+" displayed at: "+j);
						//break;
						}			
				
// To delete the employee
						
						Brow.findElement(By.xpath("//*[@id='standardView']/table/tbody/tr["+j+"]/td[1]/input")).click();	
				}
						
						Brow.findElement(By.xpath("//input[@value='Delete']")).click(); 		
						
				String DelTxt = Brow.findElement(By.xpath("//*[@id='standardView']/div[2]/span")).getText();		
				System.out.println(DelTxt);		 
						
//Switch to top frame
				Brow.switchTo().defaultContent();
//---------------------------------------------------------------------------

		
//Verify home page
		if(Wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
		System.out.println("Signoff sucessfull & Home Page displayed");
		}
		else
		{
		System.out.println("Failed to Signoff");
		return;
		}
//--------------------------------------------------------------
	}
    
    
    public void addlocation() throws FileNotFoundException, IOException, Exception
	{
    	// S.No 3  -  Focus on Admin=================================================================================================
		
    	        Brow.navigate().refresh();
    			OBJADM = Brow.findElement(By.id("admin"));
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
    			OBJCOM = Brow.findElement(By.linkText("Company Info"));
    			OBJJOB = Brow.findElement(By.linkText("Job"));
    			OBJQAL = Brow.findElement(By.linkText("Qualification"));
    			OBJSKL = Brow.findElement(By.linkText("Skills"));
    			
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
    			OBJGNL = Brow.findElement(By.linkText("General"));
    			OBJLOC = Brow.findElement(By.linkText("Locations"));
    			OBJCSTR = Brow.findElement(By.linkText("Company Structure"));
    			OBJCPRO = Brow.findElement(By.linkText("Company Property"));

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
    			Wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));

    			// Verify Company Info: Locations		
    			if(Brow.findElement(By.cssSelector(".mainHeading>h2")).getText().equals("Company Info : Locations"))
    			{
    				System.out.println("Company Info : Locations is Displayed");
    			}
    			else
    			{
    				System.out.println("Company Info : Locations is not Displayed");
    				
    			}

    			// Verify All		
    			if(Brow.findElement(By.cssSelector(".searchbox>label")).getText().equals("Search By:"))
    			{
    				System.out.println("Search By: is Displayed");
    			}
    			else
    			{
    				System.out.println("Search By: is not Displayed");
    			}
    			
    			// Creat objects for search by and search for		
    			WebElement OBJSBY = Brow.findElement(By.name("loc_code"));
    			WebElement OBJSFOR = Brow.findElement(By.name("loc_name"));
    				
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
    			
    			OBJSRH = Brow.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/input[2]"));
    			OBJRST = Brow.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/input[3]"));
    			OBJADD = Brow.findElement(By.xpath("//input[@value='Add']"));
    			OBJDLT = Brow.findElement(By.xpath("//input[@value='Delete']"));
    			
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
    			
    			if(Brow.findElement(By.xpath("//div[@class='mainHeading']/h2")).getTagName().equals("Company Info : Locations"))
    			{
    				System.out.println("Company Info : Locations and all fields are Displayed");
    			}
    			else
    			{
    				System.out.println("Company Info : Locations and all fields are not Displayed");
    			}
    			
    			// Create object for save		
    			OBJSAVE = Brow.findElement(By.id("editBtn"));
    			
    			OBJSAVE.click();
    			
    			Thread.sleep(3000);
    			//Create Alert		
    			Alert A = Brow.switchTo().alert();
    					
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
    			
    			 LCNAME = "Hemanth";
    			
    			// Enter name		
    			OBJLNAME = Brow.findElement(By.name("txtLocDescription"));
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
    			OBJCNTR = Brow.findElement(By.id("cmbCountry"));
    			SCNTR = new Select(OBJCNTR);
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
    					Brow.findElement(By.id("txtAddress")).clear();
    					Brow.findElement(By.id("txtAddress")).sendKeys("Hemanth Kumar, Hyderabad");
    			
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
    			
    			Brow.findElement(By.id("txtZIP")).clear();
    			Brow.findElement(By.id("txtZIP")).sendKeys("500020");
    			Thread.sleep(3000);;
    			
    	// Click on save		
    			
    			OBJSAVE.click();
    			
    			Thread.sleep(3000);
    			
    	// Verify Company Info Location
    			
    			if(Brow.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Company Info : Locations"))
    			{
    				System.out.println("Company Info : Locations is displayed");
    			}
    			else
    			{
    				System.out.println("Company Info : Locations is not displayed");
    			}
    			
    			Thread.sleep(3000);
    			
    	// Verify successfully added or not
    			
    			if(Brow.findElement(By.xpath("//div[@class='messagebar']")).getText().equals("Successfully Added"))
    			{
    				System.out.println("Successfully Added");
    			}
    			else
    			{
    				System.out.println("Failed to Add");
    			}
    			
    	//To get row count
    			
    			int rc = Brow.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
    			
    			System.out.println(rc);
    			
    			int i;
    			
    	// Loop for selecting row count
    			
    			for(i=rc;i<=rc;i++)
    			{
    				// Get location name info details
    				
    				LNAME = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();
    			
    			if(LNAME.equals(LCNAME))
    			  {
    				System.out.println(LCNAME+"Displayed at:"+i);
    			  }
    			


    			//Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
    			
    			}
	}
    			
    			//================================== Edit Location ======================================================================		
        		
    			
    			public void EditLocation()throws Exception
    			{
    	
    				
    			
    			
    			//Verify company locaton
    					
    					if(Brow.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Company Info : Locations"))
    					{
    						System.out.println("Company Info : Locations is displayed");
    					}
    					else
    					{
    						System.out.println("Company Info : Locations is not displayed");
    					}
    					
    					Thread.sleep(3000);
    			// click on edit button		
    					
    					Brow.findElement(By.xpath("//*[@id='editBtn']")).click();
    					
    					WebElement OBJLNAME1 = Brow.findElement(By.id("txtLocDescription"));
    					OBJLNAME1.clear();   // previous text will be cleared

    			// update with new name		
    					
    					 NEWNAME = "Hemanth Kumar";
    					OBJLNAME1.sendKeys(NEWNAME);
    			// Click on save button
    					
    					Brow.findElement(By.xpath("//input[@value='Save']")).click();		
    					
    					
    			//To get row count
    					
    							int rc1 = Brow.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
    							
    							System.out.println(rc1);
    							
    							Thread.sleep(3000);
    							
    							int j;
    							
    			// Loop for selecting row count
    							
    							for(j=rc1;j<=rc1;j++)
    							{
    			// Verify new name
    								
    								String LNAME1 = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).getText();
    							
    							if(LNAME1.equals(NEWNAME))
    							  {
    								System.out.println(NEWNAME+"Displayed at:"+j);
    							  }
    							
    			// Click on check box
    							
    							Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[1]/input")).click();
    						
    							}
 	
    			}
    			
    			
    			
    			// ======================================== Delete Location =================================================================
    			public void DeleteLocation() throws FileNotFoundException, IOException, Exception
    			{
    			
				// Click on Delete Button
				
    				Brow.findElement(By.xpath("//input[@value='Delete']")).click();
    				Brow.switchTo().alert().accept();
	
				// Verify succefu delete message
				
				 OBJMSG = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/span")).getText();
				if(OBJMSG.equals("Successfully Deleted"))
				{
					System.out.println("Successfully Deleted is Displayed");
				}
				else
				{
					System.out.println("Successfully Deleted is not Displayed");
				}
				
				
				Brow.switchTo().defaultContent();
				
				// Click on Logout
				
				Brow.findElement(By.linkText("Logout")).click();
				
				
				
		        //Verify home page		
				if(Wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
				{
				System.out.println("Home Page displayed");
				}
				else
				{
				System.out.println("Failed to open home page");
				return;
				
				}
    			
    			}
    	
    			// ======================================== Multiple Delete Location =================================================================

    			
    			  public void MultipleDeleteLocation() throws FileNotFoundException, IOException, Exception
    				{
    							
    						// Creat web element for list						
    							List<WebElement> OBJCHKS = Brow.findElements(By.cssSelector(".checkbox")); 
    							OBJCHKS.get(4).click();
    							OBJCHKS.get(5).click();
    							OBJCHKS.get(6).click();						
    							
    							// Click on Delete Button
    							
    							Brow.findElement(By.xpath("//input[@value='Delete']")).click();
    							Brow.switchTo().alert().accept();
    				
    							// Verify succefu delete message
    							
    							String OBJMSG = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/span")).getText();
    							if(OBJMSG.equals("Successfully Deleted"))
    							{
    								System.out.println("Successfully Deleted is Displayed");
    							}
    							else
    							{
    								System.out.println("Successfully Deleted is not Displayed");
    							}
    							
    							
    							Brow.switchTo().defaultContent();
    							
    							// Click on Logout
    							
    							Brow.findElement(By.linkText("Logout")).click();
    							
    							
    							
    					        //Verify home page		
    							if(Wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
    							{
    							System.out.println("Home Page displayed");
    							}
    							else
    							{
    							System.out.println("Failed to open home page");
    							return;						
    							}
    				}

    	//========================================================AddJOBTITLE=================================================================
    	
    			  public void AddJOBTITLE() throws FileNotFoundException, IOException, Exception
  				{
    			  
    			  
    			// S.No 3  -  Focus on Admin=================================================================================================
    				
    			Brow.navigate().refresh();
  				OBJADM = Brow.findElement(By.id("admin"));
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
                OBJCOM = Brow.findElement(By.linkText("Company Info"));
  				OBJJOB = Brow.findElement(By.linkText("Job"));
  				OBJQAL = Brow.findElement(By.linkText("Qualification"));
  				OBJSKL = Brow.findElement(By.linkText("Skills"));
  				
  				if(OBJCOM.isDisplayed()&&OBJJOB.isDisplayed()&&OBJQAL.isDisplayed()&&OBJSKL.isDisplayed())
  					
  				{
  					System.out.println("Company information,Job,Qualification and Skills are displayed");
  				}
  				else
  				{
  					System.out.println("Company information,Job,Qualification and Skills are not displayed");
  				return;	
  				}
  		
  // S.No 4 -  Focus on Job==========================================================================================================	
  				
  				//Driver.navigate().refresh();
  				OBJJOB1 = Brow.findElement(By.linkText("Job"));
  				if(OBJJOB1.isDisplayed())
  				{
  					System.out.println("Job is Displayed");
  				}
  				else
  				{
  					System.out.println("Job is not Displayed");
  				return;	
  				}
  				
  				// Mouse Over				
  				Act.moveToElement(OBJJOB1).perform();
  				
  				// Create objects for Job Titls, Job Specifications, Pay Grade, Employment Status, EEO Job Categaries===============
  				OBJJTTL = Brow.findElement(By.linkText("Job Titles"));
  				OBJJSPC = Brow.findElement(By.linkText("Job Specifications"));
  				OBJJPAYG = Brow.findElement(By.linkText("Pay Grades"));
  				OBJJEMST = Brow.findElement(By.linkText("Employment Status"));
  				OBJJEOJC = Brow.findElement(By.linkText("EEO Job Categories"));
  				
  				if(OBJJTTL.isDisplayed()&&OBJJSPC.isDisplayed()&&OBJJPAYG.isDisplayed()&&OBJJEMST.isDisplayed()&&OBJJEOJC.isDisplayed())
  				{
  					System.out.println("Job Titls, Job Specifications, Pay Grade, Employment Status, EEO Job Categaries is Displayed");					
  				}
  				else
  				{
  					System.out.println("Job Titls, Job Specifications, Pay Grade, Employment Status, EEO Job Categaries is not Displayed");
  				return;	
  				}
  				
  // S.No 5  -  Click on Job Tilte=================================================================================================
  				
  				Act.moveToElement(OBJJTTL).click().perform();
  				
  				//wait for frame and swich to it				
  				Wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
  				
  				// Verify job title and all fields
  				if(Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[1]/h2")).getText().equals("Job : Job Title"))
  				{
  					System.out.println("Job : Job Title is displayed");
  				}
  				else
  				{
  					System.out.println("Job : Job Title is not displayed");
  				return;
  				}
  				
  				// Verify All
  				
  				if(Brow.findElement(By.cssSelector(".searchbox>label")).getText().equals("Search By:"))
  				{
  					System.out.println("Search By:is Displayed");
  				}
  				else
  				{
  					System.out.println("Search By:is not Displayed");
  				return;	
  				}
  				
  				// Create web elements
  				
  				 OBJSDROP = Brow.findElement(By.name("loc_code"));
  				 OBJSFOR = Brow.findElement(By.name("loc_name"));
  				
  				if(OBJSDROP.isDisplayed()&&OBJSFOR.isDisplayed())
  				{
  					System.out.println("Dropdown and search text field is displayed");
  				}
  				else
  				{
  					System.out.println("Dropdown and search text field is not displayed");
  				return;
  				}
  				
  				 OBJSRH = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/input[2]"));
  				 OBJRST = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/input[3]"));
  				 OBJADD = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[3]/div[1]/input[1]"));
  				 OBJDLT = Brow.findElement(By.xpath("//html/body/div/div[2]/form/div[3]/div[1]/input[2]"));
  				
  				if(OBJSRH.isDisplayed()&&OBJRST.isDisplayed()&&OBJADD.isDisplayed()&&OBJDLT.isDisplayed())
  				{
  					System.out.println("search,reset,add and delete buttons are displayed");
  				}
  				else
  				{
  					System.out.println("search,reset,add and delete buttons are not displayed");
  				return;	
  				}
  				
  // S.No 6  -  Click on Add=================================================================================================================
  				
  				OBJADD.click();
  				Thread.sleep(2000);
  				
  				// Verify job titles and all fields
  				
  				if(Brow.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/div/h2")).getText().equals("Job : Job Title"))
  				{
  					System.out.println("Job : Job Title and all fields are displayed");
  				}
  				else
  				{
  					System.out.println("Job : Job Title and all fields are not displayed");
  				return;
  				}
  				
  				
  // S.No 7  -  Keep all fileds as blank and click on save
  				
  				
  				// click save button
  					OBJSAVE = Brow.findElement(By.xpath("//*[@id='frmJobTitle']/div[2]/input[1]"));
  					OBJSAVE.click();
  					Thread.sleep(2000);
  					
  				// Verify alerts
  					
  					Alert A = Brow.switchTo().alert();
  					if(A.getText().equals("Job Title Name should be specified"))
  					{
  						System.out.println("Alert is displayed as 'Job Title Name should be specified'");
  					}
  					else
  					{
  						System.out.println("Alert is not displayed '");
  					
  					}
  					A.accept();	

  // S.No 8  -   Enter Job title and click on save
  					
  					
  				// Create web elements for job title name and job description
  					
  					 OBJJTN = Brow.findElement(By.name("txtJobTitleName"));
  					 OBJJDIS = Brow.findElement(By.name("txtJobTitleDesc"));
  					
  					 JTN = "Software Test Engineer";
  					 JDIS = "Automation in Selenium Domain";
  					
  					OBJJTN.clear();
  					OBJJTN.sendKeys(JTN);
  					OBJSAVE.click();
  					
  					
  // S.No 9  -  Enter job description and click on save
  					
  					
  					if(A.getText().equals("Job Description should be specified"))
  					{
  						System.out.println("Alert is displayed as 'Job Description should be specified'");
  					}
  					else
  					{
  						System.out.println("Alert is not displayed '");
  					Thread.sleep(2000);	
  					
  					}
  					
  					A.accept();	
  					OBJJDIS.clear();
  					OBJJDIS.sendKeys(JDIS);
  					OBJSAVE.click();
  					
  				
  					WebElement OBJES = Brow.findElement(By.name("cmbAssEmploymentStatus"));
  					WebElement OBJAES = Brow.findElement(By.name("butUnAssEmploymentStatus"));
  					WebElement OBJEES = Brow.findElement(By.name("butUnAssEmploymentStatus"));
  					WebElement OBJLDRP = Brow.findElement(By.xpath("//*[@id='cmbAssEmploymentStatus']"));
  					WebElement OBJRDRP = Brow.findElement(By.xpath("//*[@id='cmbUnAssEmploymentStatus']"));
  					WebElement OBJADD1 = Brow.findElement(By.xpath("//input[@value='< Add']"));
  					
  					WebElement OBJRMV1 = Brow.findElement(By.xpath("//input[@value='Remove >']"));
  							
  					if(OBJES.isDisplayed()&&OBJAES.isDisplayed()&&OBJEES.isDisplayed())
  					{
  						System.out.println("Employment Status, Add Employment Status,Edit Employment Status are displayed");
  					}
  					else
  					{
  						System.out.println("Employment Status, Add Employment Status,Edit Employment Status are not displayed");
  					}
  					
  					if(OBJLDRP.isDisplayed()&&OBJRDRP.isDisplayed()&&OBJADD1.isDisplayed()&&OBJRMV1.isDisplayed())
  					{
  						System.out.println("Left dropsown,Right dropdown, Add and Remove buttons are displayed");
  					}
  					else
  					{
  						System.out.println("Left dropsown,Right dropdown, Add and Remove buttons are not displayed");
  					}
  					
  					Thread.sleep(2000);
  					if(OBJLDRP.isDisplayed()&&OBJRDRP.isDisplayed()&&OBJADD1.isDisplayed()&&OBJRMV1.isDisplayed())
  					{
  						System.out.println("Left and Right drop boxes and ADD,Remove buttons are displayed");
  					}
  					else
  					{
  						System.out.println("Left and Right drop boxes and ADD,Remove buttons are not displayed");
  					}
  					
  					Thread.sleep(2000);
  					
  				// S.No 10  -  Edit employee status details and other info and click on save					
					
  					// Create webelement for EDIT					
  						WebElement OBJEDIT = Brow.findElement(By.xpath("//input[@id='editBtn']"));
  						OBJEDIT.click();
  						
  					// Click on Edit Employment Status
  						
  						Select S = new Select(OBJRDRP);
  						S.selectByVisibleText("Full Time Contract");
  						Brow.findElement(By.xpath("//*[@id='frmJobTitle']/div[1]/input[1]")).click();
  						Thread.sleep(3000);
  						
  						WebElement OBJFTP = Brow.findElement(By.xpath("//*[@id='cmbAssEmploymentStatus']/option[2]"));
  						if(OBJFTP.isDisplayed())
  						{
  							System.out.println("Full Time Permanent is Added and Displayed");
  						}
  						else
  						{
  							System.out.println("Not Displayed");
  						}
  						
  				// Click on Save					
  						WebElement OBJSAV1 = Brow.findElement(By.xpath("//*[@id='editBtn']"));
  						Thread.sleep(3000);
  						OBJSAV1.click();
  						Thread.sleep(3000);
  						
  				// Verification for Successfully Updated
  						
  						if(Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/span")).getText().equals("Successfully Updated"))
  						{
  							System.out.println("Successfully Updated is Displayed");
  						}
  						else
  						{
  							System.out.println("Successfully Updated is not Displayed");
  						}
  						
  				//To get row count					
  						int rc = Brow.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
  						
  						System.out.println(rc);
  						
  						int i;
  						
  				// Loop for selecting row count
  						
  						for(i=rc;i<=rc;i++)
  						{
  							// Get location name info details
  							
  							String OBJJTN1 = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();
  						
  						if(OBJJTN1.equals(JTN))
  						  {
  							System.out.println(JTN+"Displayed at:"+i);
  						  }
  						


  						Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
  						
  						}
  						
  				// Edit Job Title and Delete Job Title test cases is pending		
  						
  						// select row count
  				           
  				           int rc2=Brow.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
  				           int j;
  				           // LOOP
  				           
  				           for( j=rc;j<=rc2;j++)
  				           {
  				                   String JTNAME=Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).getText();
  				                   if(JTNAME.equals(JTN))
  				                   {
  				                   System.out.println(JTN+" DISPLAYED AT :"+i);
  				                   }
  				                   else
  				                   {
  				                   System.out.println(JTN +"IS NOT DISPLAYED ");
  				                   }
  				                   
  				           }
  				}
  				               
  				                
  				               //----------------TEST CASE - 10 ---  EDIT JOB TITLE---------------------------------//
  				               
  				                 public void EDIT_JOB_TITLE() throws FileNotFoundException, IOException, Exception
   				  				{  
  				                	//To get row count					
  			  						int rc = Brow.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
  			  						
  			  						System.out.println(rc);
  			  						
  			  						int i;
  			  						
  			  				// Loop for selecting row count
  			  						
  			  						for(i=rc;i<=rc;i++)
  			  						{
  			  							// Get location name info details
  			  							
  			  							String OBJJTN1 = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();
  			  						
  			  						if(OBJJTN1.equals(JTN))
  			  						  {
  			  							System.out.println(JTN+"Displayed at:"+i);
  			  						  }
  			  						


  			  						Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
  			  						
  			  						}
  				                	int rc2=Brow.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
  		  				           int j;
  		  				           // LOOP
  		  				           
  		  				           for( j=rc;j<=rc2;j++)
  		  				           {
  		  				                   String JTNAME=Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).getText();
  		  				                   if(JTNAME.equals(JTN))
  		  				                   {
  		  				                   System.out.println(JTN+" DISPLAYED AT :"+i);
  		  				                   }
  		  				                   else
  		  				                   {
  		  				                   System.out.println(JTN +"IS NOT DISPLAYED ");
  		  				                   }
  		  				                   
  		  				           }
  				                	Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
  				               
  				           
  				           
  				         Thread.sleep(2000);
  				        // CREATE WEB ELEMENT FOR EDIT
  				       OBJEDIT2=Brow.findElement(By.xpath("//input[@id='editBtn']"));
  				     OBJEDIT2.click();
  				         Thread.sleep(2000);
  				         
  				        // AGAIN VERIFY Job : Job Title 
  				             if(Brow.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Job : Job Title"))
  				             {
  				           System.out.println("Job : Job Title is AGAIN  displayed");
  				             }
  				             else
  				             {
  				                 System.out.println("Job : Job Title is  not displayed AGAIN");
  				             }
  				             //EDIT JOB TITLE NAME
  				             WebElement OBJJTN1=Brow.findElement(By.xpath("//*[@id='txtJobTitleName']"));
  				             String JTN2="TEST ENGINEER";
  				             
  				             OBJJTN1.clear();
  				             OBJJTN1.sendKeys(JTN2);
  				             //OBJSAV.click();
  				             Thread.sleep(3000);
  				             /*
  				                WebElement OBJLDRP2=Driver.findElement(By.xpath("//*[@id='cmbAssEmploymentStatus']/option[2]"));
  				                Select S1=new Select(OBJLDRP2);
  				                
  				                
  				                 S1.selectByVisibleText("Full Time Permanent");
  				                 WebElement WERMV1=Driver.findElement(By.xpath("//input[@value='Remove >']"));
  				                 WERMV1.click();
  				                 if(WERMV1.isDisplayed())
  				                 {
  				                    System.out.println("Full Time Permanent is Removed");

  				                 }
  				                 else
  				                 {
  				                    System.out.println("Full Time Permanent is Not Removed");

  				                 }
  				                 Thread.sleep(2000);*/
  				                 
  				                 // CLICK ON SAVE
  				               Brow.findElement(By.xpath("//*[@id='editBtn']")).click();
  				                Thread.sleep(2000);
  				                

  				                // verification sucess fully updated or not
  				                if(Brow.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/span")).getText().equals("Successfully Updated"))
  				                {
  				                    System.out.println("Successfully Updated is displayed 2");
  				                }
  				                else
  				                {
  				                    System.out.println("Successfully Updated is not displayed 2");
  				                }
  				                
  				               
  				                //  LOOP2 
  				                
  				                for(int j2=rc;j2<=rc;j2++)
  				                  {
  				                      String JTNAME1=Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j2+"]/td[3]/a")).getText();
  				                      if(JTNAME1.equals(JTN2))
  				                      {
  				                          System.out.println(JTN2+" DISPLAYED AT :"+j2);
  				                      }
  				                      else
  				                      {
  				                          System.out.println(JTN2 +"IS NOT DISPLAYED ");
  				                      }
  				                      
  				                 
  				}
   				  				}
  				                //------------------------TEST CASE  - 11 JOBTITLE DELETION----------------------------------------//
  				                      
  				                    public void JOBTITLE_DELETION() throws FileNotFoundException, IOException, Exception
  	  				  				{
  				                      
  				                    	Brow.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+j2+"]/td[1]/input")).click();
  				               
  				               
  				                
  				                    	Brow.findElement(By.xpath("//input[@value='Delete']")).click();
  				                
  				                if(A.getText().equals("Deletion may affect Pay Grade of Employees in PIM. Do you want to delete ?"))
  				                {
  				                    System.out.println("ALERT DISPLAYED AS : Do you want to delete ? ");
  				                }
  				                A.accept();
  				                
  				            // VERIFY SUCESSFULLY DELETED OR NOT
  				                
  				                if(Brow.findElement(By.xpath("//div[@class='messagebar']")).getText().equals("Successfully Deleted"))
  				                {
  				                    System.out.println(JTN2+" DELETED AT:"+i);
  				                }
  				                else
  				                {
  				                    System.out.println("Successfully Deleted is not Displayed");
  				                }
  				              Brow.switchTo().defaultContent();
  				               Thread.sleep(3000);
  				                // click on logout
  				                //OBJLOGOUT.click();
  				             Brow.findElement(By.linkText("Logout")).click();
  				                
  				                // wait & verify home page is displayed or not
  				               Wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
  				               
  				                if(Brow.getTitle().equals("OrangeHRM - New Level of HR Management"))
  				                {
  				                    System.out.println("LOGOUT SUCESSFULL & HOME PAGE IS DISPLAYED");
  				                }
  				                else
  				                {
  				                    System.out.println("FAILED TO OPEN HOME PAGE");
  				                }

  					
  				}
    			  
  		 public void JOB_SPECIFICATION_TEST_CASE() throws FileNotFoundException, IOException, Exception
	  			{
			WebElement OBJADM=Brow.findElement(By.id("admin"));
			
			if(OBJADM.isDisplayed())
			{
			 System.out.println("Admin is displayed");
			}
			else
			{
			 System.out.println("Admin is not Displayed");
			 return;
			}
			
			// MOUSE OVER
			
			Act.moveToElement(OBJADM).perform();
			
			// CREATE OBJECT FOR COMPANY INFO,JOBS,QUALIFICATIONS,SKILLS,ETC,
			
			WebElement OBJCOM=Brow.findElement(By.linkText("Company Info"));
			WebElement OBJJOB=Brow.findElement(By.linkText("Job"));
			WebElement OBJQAL=Brow.findElement(By.linkText("Qualification"));
			WebElement OBJSKL=Brow.findElement(By.linkText("Skills"));
			// VERIFY COMPANY INFO,JOBS,QUALIFICATIONS,SKILLS,ETC,
			if(OBJCOM.isDisplayed()&&OBJJOB.isDisplayed() && OBJQAL.isDisplayed() && OBJSKL.isDisplayed())
			{
			 System.out.println("COMPANY INFO & JOB & QUALIFICATIONS & SKILLS ARE DISPLAYED");
			 
			}
			else
			{
			 System.out.println("COMPANY INFO & JOB & QUALIFICATIONS & SKILLS ARE NOT DISPLAYED");
			 return;
			}
			Act.moveToElement(OBJJOB).perform();
			// CREATE WEBELEMENT OBJECTS 
			/*
			WebElement OBJJTTL=driver.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[1]/a/span"));//getText().equals("Job Titles");
			WebElement OBJJSPC=driver.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[2]/a/span"));
			WebElement OBJPAYG=driver.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[3]/a/span"));
			WebElement OBJEMST=driver.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[4]/a/span"));
			WebElement OBJEOJC=driver.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[5]/a/span"));
			
			*/
			WebElement OBJJTTL=Brow.findElement(By.linkText("Job Titles"));//getText().equals("Job Titles");
			WebElement OBJJSPC=Brow.findElement(By.linkText("Job Specifications"));
			WebElement OBJPAYG=Brow.findElement(By.linkText("Pay Grades"));
			WebElement OBJEMST=Brow.findElement(By.linkText("Employment Status"));
			WebElement OBJEOJC=Brow.findElement(By.linkText("EEO Job Categories"));
			
			
			// VERIFY 
			if(OBJJTTL.isDisplayed()&&OBJJSPC.isDisplayed()&&OBJPAYG.isDisplayed()&&OBJEMST.isDisplayed()&&OBJEOJC.isDisplayed())
			{
			    System.out.println(" 'Job Titles,Job Specifications,Pay Grades,Employment Status,EEO Job Categories' IS DISPLAYED  ");
			}
			else
			{
			    System.out.println(" 'Job Titles,Job Specifications,Pay Grades,Employment Status,EEO Job Categories' IS NOT DISPLAYED  ");
			}
			Thread.sleep(2000);
			// click on job Specifications
			Act.moveToElement(OBJJSPC).click().perform(); 
			
			// WAIT FOR FRAME AND SWITCH TO IT
			
			Wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
			Thread.sleep(2000);
			//--------------VERIFY JOB AND JOB SPECIFICATIONS IS DISPLAYED OR NOT
			
			WebElement WEJJS=Brow.findElement(By.cssSelector(".mainHeading>h2"));
			if(WEJJS.getText().equals("Job : Job Specifications"))
			{
			    System.out.println("Job : Job Specifications is displayed1");
			}
			else
			{
			    System.out.println("Job : Job Specifications is not displayed");
			}

//     CREATE WEB ELEMENTS FOR INPUT FIELDS AND BUTTONS

          WebElement OBJSBY=Brow.findElement(By.name("loc_code"));
        WebElement OBJSFR=Brow.findElement(By.name("loc_name"));
        WebElement OBJSRH=Brow.findElement(By.xpath("//input[@value='Search']"));
        WebElement OBJRST=Brow.findElement(By.xpath("//input[@value='Reset']"));
        WebElement OBJADD=Brow.findElement(By.xpath("//input[@value='Add']"));
        WebElement OBJDLT=Brow.findElement(By.xpath("//input[@value='Delete']"));
        
//      VERIFY WEB ELEMENTS
        if(OBJSBY.isDisplayed()&&OBJSFR.isDisplayed()&&OBJSRH.isDisplayed()&&OBJRST.isDisplayed()&&OBJADD.isDisplayed()&&OBJDLT.isDisplayed())
        {
            System.out.println("SEARCH ,SEARCH FOR,SEARCH,RESET,ADD,DELETE BUTTONS ARE DISPLAYED");
        }
        else
        {
            System.out.println("SEARCH ,SEARCH FOR,SEARCH,RESET,ADD,DELETE BUTTONS ARE NOT DISPLAYED");
              
        }
        
//         NOW CLICK ON ADD BUTTON
        
        OBJADD.click();
        Thread.sleep(1000);
        
//        CHECK and VERIFY JOB SPECIFICATION 
        WebElement WEJJS1=Brow.findElement(By.cssSelector(".mainHeading>h2"));
        
       if( WEJJS1.getText().equals("Job : Job Specifications"))
       {
           System.out.println("Job : Job Specifications is displayed2");
       }
       else
       {
           System.out.println("Job : Job Specifications is not displayed2");
              
       }
       
//      CREATE STRING AND ENTER DATA
        String NAME="SOFTWARE1";
        String DESCR="TEST ENGINERR AT QAPLANET";
//        CREATE WEB ELEMENT FOR NAME AND DESCRIPTION
        WebElement OBJNAME=Brow.findElement(By.name("txtFieldName"));
        WebElement OBJDESCR=Brow.findElement(By.name("txtDesc"));
        WebElement OBJSAV=Brow.findElement(By.id("editBtn"));
        
//        VERIFY WEBELEMENTS NAME,DESCRIPTION,SAVE 
        if(OBJNAME.isDisplayed()&&OBJDESCR.isDisplayed()&&OBJSAV.isDisplayed())
          {
              System.out.println("NAME,DESCRIPTION AND SAVE BUTTON IS DISPLAYED");
          }
          else
          {
              System.out.println("NAME,DESCRIPTION AND SAVE BUTTON IS NOT DISPLAYED");
              
          }
//        CLICK ON SAVE
          OBJSAV.click();
//        CREATE ALERT
          Alert A=Brow.switchTo().alert();
//        VERIFY ALERT
          if(A.getText().equals("Please correct the following\n\n    - Please specify Job Specification name\n"))
          {
              System.out.println("Please specify Job Specification name\n is Displayed");
          }
          else
          {
              System.out.println("Please specify Job Specification name\n is Displayed");
          }
          A.accept();

          Thread.sleep(1000);

          //        TYPE DATA OR SEND DATA
        OBJNAME.clear();
        OBJNAME.sendKeys(NAME);
        OBJDESCR.clear();
        OBJDESCR.sendKeys(DESCR);
//        CLICK ON SAVE
        OBJSAV.click();
/*
//           VERIFY ALERT 2
          if(A.getText().equals("Please correct the following\n\n    - This name is in use\n"))
          {
              System.out.println("- This name is in use\n is Displayed");
          }
          else
          {
              System.out.println("PThis name is in use\n is not Displayed");
          }
          A.accept();     */
        Thread.sleep(2000);

//        CHECK and VERIFY JOB SPECIFICATION 
        
        WebElement WEJJS2=Brow.findElement(By.cssSelector(".mainHeading>h2"));
        
        
        if( WEJJS2.getText().equals("Job : Job Specifications"))
        {
            System.out.println("Job : Job Specifications is displayed2");
        }
        else
        {
            System.out.println("Job : Job Specifications is not displayed2");
               
        }

//        CHECK AND VERIFY SUCESSFULLY ADDED OR NOT
        if(Brow.findElement(By.xpath("//span[@class='success']")).getText().equals("Successfully Added"))
        {
            System.out.println("Successfully Added is displayed");
        }
        else
        {
            System.out.println("Successfully Added is not displayed");
        
          }
//        SELECT ROW COUNT
        int rc=Brow.findElements(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr")).size();
        int i;
        
//        LOOP 1
        for(i=rc;i<=rc;i++)
        {
            String NAME1=Brow.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();
//        VERIFY           
        if(NAME1.equals(NAME))
          {
            System.out.println(NAME+" DISPLAYED AT: "+i);
          }
           else
            {
            System.out.println(NAME+" IS NOT DISPLAYED");
            }
        
        }
	  			}
    	
        //-----------------------EDIT JOB SPECIFICATION TEST CASE 13-------------------------
        
        public void EDIT_JOB_SPECIFICATION_TEST_CASE() throws FileNotFoundException, IOException, Exception
				{
            
        
        	Brow.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
         
        Thread.sleep(2000);
        
//           CLICK ON EDIT BUTTON
        Brow.findElement(By.xpath("//*[@id='editBtn']")).click();
        Thread.sleep(1000);
        
//             CLEAR AND SEND DATA
        String NAM1="SOFTWARE ENGINEER";          
      WebElement WENAM1 = Brow.findElement(By.name("txtFieldName"));
        WENAM1.clear();
        WENAM1.sendKeys(NAM1);

//            CLICK ON SAVE
        
        Brow.findElement(By.id("editBtn")).click();

        Thread.sleep(2000);
//        CHECK and VERIFY JOB SPECIFICATION 
                    
        WebElement WEJJS3=Brow.findElement(By.cssSelector(".mainHeading>h2"));
                                
                    if( WEJJS3.getText().equals("Job : Job Specifications"))
                    {
                        System.out.println("Job : Job Specifications is displayed3");
                    }
                    else
                    {
                        System.out.println("Job : Job Specifications is not displayed3");
                           
                    }
                    Thread.sleep(1000);
//        CHECK AND VERIFY SUCESSFULLY ADDED OR NOT
                    if(Brow.findElement(By.xpath("//div[@class='messagebar']/span")).getText().equals("Successfully Updated"))
                    {
                        System.out.println("Successfully Updated is displayed");
                    }
                    else
                    {
                        System.out.println("Successfully Updated is not displayed");
                    
                      }
                    Thread.sleep(1000);
                    
                    
                  //-----------------------------------TEST CASE 14 DELETE JOB SPECIFICATION
         		   //         LOOP 2
         		                  int j;
         		                  for( j=rc;j<=rc;j++)
         		                    {
         		                        String NAME2=Brow.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).getText();
         		  //        VERIFY           
         		                        if(NAME2.equals(NAM1))
         		                           {
         		                             System.out.println(NAM1+" DISPLAYED AT: "+j);
         		                            }
         		                           else
         		                        {
         		                          System.out.println(NAM1+" IS NOT DISPLAYED");
         		                        }
         		   //         CHECK BOX SELECT AND CLICK
         		                       Brow.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[1]/input")).click(); 
         		                          }
         		    //        CLICK ON DELETE
         		                 Brow.findElement(By.xpath("//input[@value='Delete']")).click();
         		    //      VERIFY AND ACCEPT ALERT
         		                  if(A.getText().equals("Deletion might affect employee information. Do you want to delete ?"))
         		                  {
         		                      System.out.println("Deletion might affect employee information. Do you want to delete ? is DISPLAYED");
         		                  }
         		                  else
         		                  {
         		                      System.out.println("Deletion might affect employee information. Do you want to delete ? is NOT DISPLAYED");
         		                  }
         		                  A.accept();
         		                  Thread.sleep(2000);
         		    //       CHECK SUCESS FULLY DELETED OR NOT
         		                 if(Brow.findElement(By.cssSelector(".success")).getText().equals("Successfully Deleted"))
         		                 {
         		                     System.out.println("Successfully Deleted is Displayed at:" +j);
         		                 }
         		                 else
         		                 {
         		                     System.out.println("Deletion Failed or Successfully Deleted is not displayed");
         		                 }
         		              
         		   //       SWITCH TO DEFAULT FRAME
         		                Brow.switchTo().defaultContent();
         		                 Thread.sleep(3000);
         		   // REFRESH PAGE
         		                
         		                Brow.navigate().refresh();
         		                 
         		    //       CLICK ON LOGOUT
         		               
         		               Brow.findElement(By.linkText("Logout")).click();
         		              
         		                 
         		    //      WAIT AND VERIFY HOMPAGE DISPLAYED OR NOT
         		                Wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
         		                
         		                 if(Brow.getTitle().equals("OrangeHRM - New Level of HR Management"))
         		                 {
         		                     System.out.println("LOGOUT SUCESSFULL & HOME PAGE IS DISPLAYED");
         		                 }
         		                 else
         		                 {
         		                     System.out.println("FAILED TO OPEN HOME PAGE");
         		                 }
	  			}
    	//QUALIFIFCATION TEST CASE
    	
        
        public void QUALIFIFCATION_TEST_CASE() throws FileNotFoundException, IOException, Exception
		{
        
        
        
        // CREATE WEB ELEMENT FOR ADMIN
        WebElement OBADMIN=Brow.findElement(By.id("admin"));
        
        // VERIFY
        if(OBADMIN.isDisplayed())
        {
            System.out.println("ADMIN IS DISPLAYED");
        }
        else
        {
            System.out.println("ADMIN IS NOT DISPLAYED");
        }
        // ACTION COMMAND
        Actions ACT=new Actions(Brow);
        
        // MOVE TO ELEMENT ON ADMIN
        
        ACT.moveToElement(OBADMIN).perform();
        

        // CREATE OBJECT FOR COMPANY INFO,JOBS,QUALIFICATIONS,SKILLS,ETC,

          WebElement OBCOM=Brow.findElement(By.linkText("Company Info"));
          WebElement OBJOB=Brow.findElement(By.linkText("Job"));
          WebElement OBQAL=Brow.findElement(By.linkText("Qualification"));
          WebElement OBSKL=Brow.findElement(By.linkText("Skills"));
        
          // VERIFY COMPANY INFO,JOBS,QUALIFICATIONS,SKILLS,ETC,
          if(OBCOM.isDisplayed()&&OBJOB.isDisplayed() && OBQAL.isDisplayed() && OBSKL.isDisplayed())
          {
           System.out.println("COMPANY INFO & JOB & QUALIFICATIONS & SKILLS ARE DISPLAYED");
           
          }
          else
          {
           System.out.println("COMPANY INFO & JOB & QUALIFICATIONS & SKILLS ARE NOT DISPLAYED");
           return;
          }
          // MOVE TO ELEMENT ON QUALIFICATIONS
          
          ACT.moveToElement(OBQAL).perform();
          
          // CREATE WEBeLEMENT FOR EDUCATION,LICENCES
        WebElement OBEDU=Brow.findElement(By.linkText("Education"));
        WebElement OBLIC=Brow.findElement(By.linkText("Licenses"));
        
        // VERIFY 
        
        if(OBEDU.isDisplayed()&&OBLIC.isDisplayed())
        {
            System.out.println("EDUCATION,LICENCES ARE DISPLAYED");
        }
        else
        {
            System.out.println("EDUCATION,LICENCES ARE NOT DISPLAYED");
        }
        
        Thread.sleep(2000);
        // MOVE TO ELEMENT ON EDUCATION
        ACT.moveToElement(OBEDU).click().perform();
        
        // WAIT FOR FRAME AND SWITCH TO IT
        Wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
        Thread.sleep(2000);
        
        // VERIFY QUALIFICATION : EDUCATION
        
        WebElement WEQE=Brow.findElement(By.cssSelector(".mainHeading>h2"));
        if(WEQE.getText().equals("Qualification : Education"))
        {
            System.out.println("Qualification : Education is Displayed 1 ");
        }
        else
        {
            System.out.println("Qualification : Education is Not Displayed 1");
        }
        
         //     CREATE WEB ELEMENTS FOR INPUT FIELDS AND BUTTONS
          
          WebElement OBSBY=Brow.findElement(By.name("loc_code"));
          WebElement OBSFR=Brow.findElement(By.name("loc_name"));
          WebElement OBSRH=Brow.findElement(By.xpath("//input[@value='Search']"));
          WebElement OBRST=Brow.findElement(By.xpath("//input[@value='Reset']"));
          WebElement OBADD=Brow.findElement(By.xpath("//input[@value='Add']"));
          WebElement OBDLT=Brow.findElement(By.xpath("//input[@value='Delete']"));
          
          //    VERIFY WEB ELEMENTS
          
          if(OBSBY.isDisplayed()&&OBSFR.isDisplayed()&&OBSRH.isDisplayed()&&OBRST.isDisplayed()&&OBADD.isDisplayed()&&OBDLT.isDisplayed())
          {
              System.out.println("SEARCH ,SEARCH FOR,SEARCH,RESET,ADD,DELETE BUTTONS ARE DISPLAYED");
          }
          else
          {
              System.out.println("SEARCH ,SEARCH FOR,SEARCH,RESET,ADD,DELETE BUTTONS ARE NOT DISPLAYED");
                
          }
          
          //     NOW CLICK ON ADD BUTTON
          
          OBADD.click();
          Thread.sleep(3000);
    
        // VERIFY QUALIFICATION : EDUCATION
              WebElement WEQE1=Brow.findElement(By.cssSelector(".mainHeading>h2"));
            if(WEQE1.getText().equals("Qualification : Education"))
            {
                System.out.println("Qualification : Education is Displayed 2 ");
            }
            else
            {
                System.out.println("Qualification : Education is Not Displayed 2");
            }
            
            String INST="QAPLANET";
            String COURS="SOFTWARE TESTING";
            
        // CREATE WEBELEMENT FOR INSITUTE,COURSE, SAVE BUTTON
            
            WebElement OBINST=Brow.findElement(By.xpath("//input[@id='txtUni']"));
            WebElement OBCOURS=Brow.findElement(By.xpath("//input[@id='txtDeg']"));
            WebElement OBSAV=Brow.findElement(By.xpath("//input[@value='Save']"));
            
            
            
        // VERIFY ABOVE
            
            if(OBINST.isDisplayed()&&OBCOURS.isDisplayed()&&OBSAV.isDisplayed())
            {
                System.out.println("INSITUTE,COURSE, SAVE IS DISPLAYED");
            }
            else
            {
                System.out.println("INSITUTE,COURSE, SAVE IS NOT DISPLAYED");
            }
        //  CLICK ON SAVE
            
            OBSAV.click();
            
        // CREATE ALERT 
            Alert A=Brow.switchTo().alert();
        
        // VERIFY ALERT TEXT
            if(A.getText().equals("Please correct the following\n\n    - Institute Cannot be a Blank Value!\n    - Course Cannot be a Blank Value!\n"))
            {
                System.out.println("ENTER INSTITUTE & COURSE DETAILS ARE  DISPLAYED");
            }
            else
            {
                System.out.println("ENTER INSTITUTE & COURSE DETAILS ARE NOT DISPLAYED");
            }
            A.accept();
        // SEND DATA
            
            OBINST.clear();
            OBINST.sendKeys(INST);
            
        // CLICK ON SAVE 
            Brow.findElement(By.xpath("//input[@value='Save']")).click();
            
        // VERIFY ALERT TEXT
            
            if(A.getText().equals("Please correct the following\n\n    - Course Cannot be a Blank Value!\n"))
            {
                System.out.println("ENTER COURSE DETAILS ARE  DISPLAYED");
            }
            else
            {
                System.out.println("ENTER COURSE DETAILS ARE NOT DISPLAYED");
            }
            A.accept();
        
            Thread.sleep(2000);
        // SEND DATA TO COURSE
            
            OBCOURS.clear();
            OBCOURS.sendKeys(COURS);
        
            Brow.findElement(By.xpath("//input[@value='Save']")).click();
            Thread.sleep(2000);
      //  VERIFY SUCESSFULLY ADDED  OR NOT
            
            if(Brow.findElement(By.xpath("//span[@class='success']")).getText().equals("Successfully Added"))
            {
                System.out.println("Successfully Added is Displayed");
            }
            else
            {
                System.out.println("Successfully Added is not Displayed");
            }
            
        // ROW COUNT
            int rc=Brow.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
            int i;
            
            
        //     LOOP 1
                for(i=rc;i<=rc;i++)
                {
                    String USN1=Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[4]")).getText();
                    
                    //VERIFY
                    if(USN1.equals(INST))
                    {
                        System.out.println(INST+" DISPLAYED AT:"+i);
                    }
                    else
                    {
                        System.out.println(INST+" IS NOT DISPLAYED");
                    }
                    
                }
		}
                
              //-------------------------------EDIT QUALIFIFCATION TEST CASE 16---------------------------------------
                
                public void EDIT_QUALIFIFCATION_TEST_CASE() throws FileNotFoundException, IOException, Exception
        		{
                
                
              
		        //     CLICK ON EDUCATION    
                	Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
		                    
		                    
		                    Thread.sleep(3000);
		                
		        //     VERIFY         

		        //         VERIFY QUALIFICATION : EDUCATION
		                      WebElement WEQE2=Brow.findElement(By.cssSelector(".mainHeading>h2"));
		                    if(WEQE2.getText().equals("Qualification : Education"))
		                    {
		                        System.out.println("Qualification : Education is Displayed 3 ");
		                    }
		                    else
		                    {
		                        System.out.println("Qualification : Education is Not Displayed 3");
		                    
		                    }
		                    Thread.sleep(2000);
		        //      WEB ELEMENT FOR EDIT
		                    WebElement OBEDIT=Brow.findElement(By.xpath("//input[@id='editBtn']"));
		        //      VERIFY EDIT BUTTON
		                    if(OBEDIT.isDisplayed())
		                    {
		                        System.out.println("EDIT BUTTON IS DISPLAYED");
		                    }
		                    else
		                    {
		                        System.out.println("EDIT BUTTON IS NOT DISPLAYED");
		                
		                    }
		        //        CLICK ON EDIT 
		                    Brow.findElement(By.xpath("//input[@id='editBtn']")).click();
		                    
		        //         TYPE DATA
		                String INST1="QA ,planet";
		                
		                WebElement WEINST1=Brow.findElement(By.xpath("//input[@id='txtUni']"));

		                    WEINST1.clear();
		                    WEINST1.sendKeys(INST1);
		                    
		        //         CLICK ON SAVE
		                    
		                    Brow.findElement(By.xpath("//input[@value='Save']")).click();
		                    Thread.sleep(2000);
		    
		        //         VERIFY SUCESS FULLY UPDATED OR NOT
		                    if(Brow.findElement(By.xpath("//span[@class='success']")).getText().equals("Successfully Updated"))
		                    {
		                        System.out.println("Successfully Updated is Displayed");
		                    }
		                    else
		                    {
		                        System.out.println("Successfully Updated is not Displayed");
		                    }        
		                    Thread.sleep(2000);
		       //                     LOOP 2
		                    int j;
		                    for(j=rc;j<=rc;j++)
		                    {
		                        String USN2=Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[4]")).getText();
		                        
		                        //VERIFY
		                        if(USN2.equals(INST1))
		                        {
		                            System.out.println(INST1+" DISPLAYED AT:"+j);
		                        }
		                        else
		                        {
		                            System.out.println(INST1+" IS NOT DISPLAYED");
		                        }  
                
		                    }
		}
                
                //-------------------------------DELETE QUALIFIFCATION TEST CASE 17---------------------------------------
                
		                    
        public void DELETE_QUALIFIFCATION_TEST_CASE() throws FileNotFoundException, IOException, Exception
		{  
		                    
		                    
		    		      
		                    //             CLICK ON EDUCATION    
        	                   Brow.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[1]/input")).click();
		    		                        
		    		                  
		    		                    Thread.sleep(2000);
		    		        //           CLICK ON DELETE
		    		                    
		    		                    Brow.findElement(By.xpath("//input[@value='Delete']")).click();
		    		                
		    		        //            VERIFY AND ACCEPT ALERT
		    		                 if(A.getText().equals("Deletion might affect Education. Do you want to delete ?"))
		    		                 {
		    		                     System.out.println("Do you want to delete ? ALERT IS DISPLAYED");
		    		                 }
		    		                 else
		    		                 {
		    		                     System.out.println("Do you want to delete ?ALERT IS NOT DISPLAYED");
		    		                 }
		    		                 A.accept();
		    		                 Thread.sleep(1000);
		    		        //            VERIFY SUCESSFULLY DELETED OR NOT
		    		                 if(Brow.findElement(By.xpath("//div[@class='messagebar']/span")).getText().equals("Successfully Deleted"))
		    		                 {
		    		                     System.out.println("Successfully Deleted IS DISPLAYED");
		    		                 }
		    		                 else
		    		                     {
		    		                     System.out.println("Successfully Deleted IS NOT DISPLAYED");
		    		                     }
		    		   //       SWITCH TO DEFAULT FRAME
		    		                 Brow.switchTo().defaultContent();
		    		                 Thread.sleep(3000);
		    		   //       REFRESH PAGE
                
                               
}
                
        public void Company_Structure_TEST_CASE() throws FileNotFoundException, IOException, Exception
		{
        
     // S.No 3  -  Focus on Admin=================================================================================================
		
        	Brow.navigate().refresh();
     		WebElement OBJADM = Brow.findElement(By.id("admin"));
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
     		WebElement OBJCOM = Brow.findElement(By.linkText("Company Info"));
     		WebElement OBJJOB = Brow.findElement(By.linkText("Job"));
     		WebElement OBJQAL = Brow.findElement(By.linkText("Qualification"));
     		WebElement OBJSKL = Brow.findElement(By.linkText("Skills"));
     		
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
     		WebElement OBJGNL = Brow.findElement(By.linkText("General"));
     		WebElement OBJLOC = Brow.findElement(By.linkText("Locations"));
     		WebElement OBJCSTR = Brow.findElement(By.linkText("Company Structure"));
     		WebElement OBJCPRO = Brow.findElement(By.linkText("Company Property"));

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
     				Wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
     				
     		// Create webelement for Company Info : Company Structure				
     				WebElement OBJCINFO = Brow.findElement(By.xpath("//*[@id='layerComStruct']/h2"));
     				
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
     				
     				if(Brow.findElement(By.xpath("//*[@id='tblCompStruct']/tbody/tr[1]/td[1]")).getText().equals("QAPLANET"))
     				{
     					System.out.println("QAPLANET sub division is displayed");
     				}
     				else
     				{
     					System.out.println("QAPLANET sub division is not displayed");
     				}
     				
     // S. No 6  -  Click on Add ============================================================================================
     				
     				Brow.findElement(By.xpath("//a[@class='add']")).click();
     				Thread.sleep(1000);
     				
     				// Verify Add a sub-division to QAPLANET
     				
     				if(Brow.findElement(By.xpath("//h3[@id='parnt']")).getText().equals("Add a sub-division to QAPLANET"))
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
     				
     				WebElement OBJDPTID = Brow.findElement(By.name("txtDeptId"));
     				WebElement OBJNAME = Brow.findElement(By.name("txtTitle"));
     				WebElement OBJTYPE = Brow.findElement(By.name("cmbType"));
     				WebElement OBJLOC1 = Brow.findElement(By.name("cmbLocation"));
     				WebElement OBJDESC = Brow.findElement(By.name("txtDesc"));
     				
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
     		          Brow.findElement(By.xpath("//input[@value='Save']")).click();
     		           Thread.sleep(1000);
     		          // CREATE ALERT
     		           
     		           Alert A=Brow.switchTo().alert();
     		           
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
     		           
     		          Brow.findElement(By.id("txtDesc")).sendKeys("Add");
     		           
     		           // CLICK ON SAVE
     		         Brow.findElement(By.xpath("//input[@value='Save']")).click();
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
		}
                
  
     		          public void EDIT_Company_Structure() throws FileNotFoundException, IOException, Exception
     	        		{
     		           
     		          // EDIT TC19
   		            int rc=Brow.findElements(By.xpath("//html/body/div[1]/table/tbody/tr")).size();
   		            for(int i=rc;i<=rc;i++)
   		            {
   		            	Brow.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+i+"]/td[1]/a")).click();
   		            
   		            
   		            }
   		            Thread.sleep(2000);
   		            
   		            // VERIFY Add a sub-division to QA Planet
   		               if(Brow.findElement(By.xpath("//h3[@id='parnt']")).getText().equals("Add a sub-division to QAPLANET"))
   		               {
   		               System.out.println("Add a sub-division to QA Planet IS DISPLAYED");
   		               }
   		               else
   		               {
   		               System.out.println("Add a sub-division to QA Planet IS NOT DISPLAYED");
   		               
   		               }
   		            
   		            // SEND DATA 
   		            
   		            Brow.findElement(By.name("txtTitle")).clear();
   		         Brow.findElement(By.name("txtTitle")).sendKeys("POWER");
   		            
   		            // click on save
   		            
   		      Brow.findElement(By.xpath("//input[@value='Save']")).click();
   		            Thread.sleep(2000);
   		            
   		         
   		            for(int j=rc;j<=rc;j++)
   		            {
   		         //   driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+i+"]/td[1]/a")).click();
   		            	Brow.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+j+"]/td[4]/a")).click();
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
   		           
     	        		}
        
    	
    	
    	
	}

    	
    	
    	    

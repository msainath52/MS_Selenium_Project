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
	WebElement OBJADM;
	WebElement OBJCOM;
	WebElement OBJJOB;
	
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
		
		Brow.findElement(By.linkText("Logout")).click();
		Wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		
		// Verify Home Page
		
		assertEquals(Brow.getTitle(),"OrangeHRM - New Level of HR Management");
		Reporter.log("Sign Off & Succesful home page displayed");
		
	}	
		
// Add Employee
		
    public void AddEmployee() throws Exception
    {
    	
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
			//Define FN,LN
			String FN="QAP";
			String LN="Tset";
			Brow.findElement(By.xpath("//input[@id='txtEmpFirstName']")).sendKeys(FN);
			Brow.findElement(By.name("txtEmpLastName")).sendKeys(LN);
			//cilck on Browse
			Brow.findElement(By.id("photofile")).click();
			//wait 2sec 
			Thread.sleep(5000);
			//Runtime.getRuntime().exec("D:\\subbu\\Autoit\\upload.exe");
			Runtime.getRuntime().exec("D:\\subbu\\Autoit\\upload.exe");
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
				String Empname=Brow.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
				if (Empname.equals(FN+" "+LN))
				{
					Reporter.log(Empname+"displayedat"+i);
					break;
								}
			}
					
					Reporter.log("Add Employee");

 		}
    
    public void edit_employee(String FN,String MN,String LN)
	{
    	Brow.switchTo().frame("rightMenu");
		int rc=Brow.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
		System.out.println(rc);
		int i ;
		for(i=1;i<=rc;i++)
		{
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String strinText= Brow.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			if(strinText.equals(equals(FN+" "+MN+" "+LN)))
			{
				System.out.println("User name is dipalyed at locatio"+ i);
				break;
			}
			 System.out.println("Elemnet is not in the list" +i);
		}
		Brow.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).click();
		Brow.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//THIS IS THE JOB DETAILS OF THE EMPLOYEE.
		
		System.out.println("--------------------------------------------------------");
        System.out.println("THIS IS THE EMPLOYEE JOB DETAILS");
        System.out.println("--------------------------------------------------------");
        Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='jobLink']/span")));
        if( Brow.findElement(By.xpath(".//*[@id='jobLink']/span")).isDisplayed())
        {
       	 System.out.println("Job details of employee is displayed");
        }
        
        Brow.findElement(By.xpath(".//*[@id='jobLink']/span")).click();
        
        
        WebDriverWait wait1 = new WebDriverWait(Brow, 10);
       wait1.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[@id='job']/div[1]/div[2]/div[1]/h2"), "Job"));
       //Selecting the Job Title
       WebElement weJObEdit = Brow.findElement(By.xpath(".//*[@id='btnEditJob']"));
       weJObEdit.click();
       
        WebElement eJob= Brow.findElement(By.xpath(".//*[@id='cmbJobTitle']"));
        Select sJob = new Select(eJob);
        sJob.selectByVisibleText("Tester");
        //Selecting the Employeement Satus
        Brow.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement eJobStat= Brow.findElement(By.xpath("/html/body/form/div[3]/div[1]/div[2]/div[2]/div/select"));				         
        Select sJobStat = new Select(eJobStat);
        sJobStat.selectByIndex(1);
        //JOing Date
        Brow.findElement(By.id("txtJoinedDate")).clear();
        Brow.findElement(By.id("txtJoinedDate")).sendKeys("2014-22-08");
       
        Brow.findElement(By.id("btnEditJob")).click();
		
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
    			
    			WebElement OBJSRH = Brow.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/input[2]"));
    			WebElement OBJRST = Brow.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/input[3]"));
    			WebElement OBJADD = Brow.findElement(By.xpath("//input[@value='Add']"));
    			WebElement OBJDLT = Brow.findElement(By.xpath("//input[@value='Delete']"));
    			
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
    			WebElement OBJSAVE = Brow.findElement(By.id("editBtn"));
    			
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
    			
    			String LCNAME = "Hemanth";
    			
    			// Enter name		
    			WebElement OBJLNAME = Brow.findElement(By.name("txtLocDescription"));
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
    			WebElement OBJCNTR = Brow.findElement(By.id("cmbCountry"));
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
    				
    				String LNAME = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();
    			
    			if(LNAME.equals(LCNAME))
    			  {
    				System.out.println(LCNAME+"Displayed at:"+i);
    			  }
    			


    			Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
    			
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
    					
    					String NEWNAME = "Hemanth Kumar";
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
  		
  // S.No 4 -  Focus on Job==========================================================================================================	
  				
  				//Driver.navigate().refresh();
  				WebElement OBJJOB1 = Brow.findElement(By.linkText("Job"));
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
  				WebElement OBJJTTL = Brow.findElement(By.linkText("Job Titles"));
  				WebElement OBJJSPC = Brow.findElement(By.linkText("Job Specifications"));
  				WebElement OBJJPAYG = Brow.findElement(By.linkText("Pay Grades"));
  				WebElement OBJJEMST = Brow.findElement(By.linkText("Employment Status"));
  				WebElement OBJJEOJC = Brow.findElement(By.linkText("EEO Job Categories"));
  				
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
  				
  				WebElement OBJSDROP = Brow.findElement(By.name("loc_code"));
  				WebElement OBJSFOR = Brow.findElement(By.name("loc_name"));
  				
  				if(OBJSDROP.isDisplayed()&&OBJSFOR.isDisplayed())
  				{
  					System.out.println("Dropdown and search text field is displayed");
  				}
  				else
  				{
  					System.out.println("Dropdown and search text field is not displayed");
  				return;
  				}
  				
  				WebElement OBJSRH = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/input[2]"));
  				WebElement OBJRST = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/input[3]"));
  				WebElement OBJADD = Brow.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[3]/div[1]/input[1]"));
  				WebElement OBJDLT = Brow.findElement(By.xpath("//html/body/div/div[2]/form/div[3]/div[1]/input[2]"));
  				
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
  					WebElement OBJSAVE = Driver.findElement(By.xpath("//*[@id='frmJobTitle']/div[2]/input[1]"));
  					OBJSAVE.click();
  					Thread.sleep(2000);
  					
  				// Verify alerts
  					
  					Alert A = Driver.switchTo().alert();
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
  					
  					WebElement OBJJTN = Driver.findElement(By.name("txtJobTitleName"));
  					WebElement OBJJDIS = Driver.findElement(By.name("txtJobTitleDesc"));
  					
  					String JTN = "Software Test Engineer";
  					String JDIS = "Automation in Selenium Domain";
  					
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
  						WebElement OBJEDIT = Driver.findElement(By.xpath("//input[@id='editBtn']"));
  						OBJEDIT.click();
  						
  					// Click on Edit Employment Status
  						
  						Select S = new Select(OBJRDRP);
  						S.selectByVisibleText("Full Time Contract");
  						Driver.findElement(By.xpath("//*[@id='frmJobTitle']/div[1]/input[1]")).click();
  						Thread.sleep(3000);
  						
  						WebElement OBJFTP = Driver.findElement(By.xpath("//*[@id='cmbAssEmploymentStatus']/option[2]"));
  						if(OBJFTP.isDisplayed())
  						{
  							System.out.println("Full Time Permanent is Added and Displayed");
  						}
  						else
  						{
  							System.out.println("Not Displayed");
  						}
  						
  				// Click on Save					
  						WebElement OBJSAV1 = Driver.findElement(By.xpath("//*[@id='editBtn']"));
  						Thread.sleep(3000);
  						OBJSAV1.click();
  						Thread.sleep(3000);
  						
  				// Verification for Successfully Updated
  						
  						if(Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/span")).getText().equals("Successfully Updated"))
  						{
  							System.out.println("Successfully Updated is Displayed");
  						}
  						else
  						{
  							System.out.println("Successfully Updated is not Displayed");
  						}
  						
  				//To get row count					
  						int rc = Driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
  						
  						System.out.println(rc);
  						
  						int i;
  						
  				// Loop for selecting row count
  						
  						for(i=rc;i<=rc;i++)
  						{
  							// Get location name info details
  							
  							String OBJJTN1 = Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();
  						
  						if(OBJJTN1.equals(JTN))
  						  {
  							System.out.println(JTN+"Displayed at:"+i);
  						  }
  						


  						Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
  						
  						}
  						
  				// Edit Job Title and Delete Job Title test cases is pending		
  						
  						// select row count
  				           
  				           int rc2=Driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
  				           int j;
  				           // LOOP
  				           
  				           for( j=rc;j<=rc2;j++)
  				           {
  				                   String JTNAME=Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).getText();
  				                   if(JTNAME.equals(JTN))
  				                   {
  				                   System.out.println(JTN+" DISPLAYED AT :"+i);
  				                   }
  				                   else
  				                   {
  				                   System.out.println(JTN +"IS NOT DISPLAYED ");
  				                   }
  				               
  				                
  				               //----------------TEST CASE - 10 ---  EDIT JOB TITLE---------------------------------//
  				               
  				                 public void EDIT_JOB_TITLE() throws FileNotFoundException, IOException, Exception
   				  				{  
  				                   
  				               Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
  				               
  				           }
  				           
  				         Thread.sleep(2000);
  				        // CREATE WEB ELEMENT FOR EDIT
  				          WebElement OBJEDIT1=Driver.findElement(By.xpath("//input[@id='editBtn']"));
  				         OBJEDIT1.click();
  				         Thread.sleep(2000);
  				         
  				        // AGAIN VERIFY Job : Job Title 
  				             if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Job : Job Title"))
  				             {
  				           System.out.println("Job : Job Title is AGAIN  displayed");
  				             }
  				             else
  				             {
  				                 System.out.println("Job : Job Title is  not displayed AGAIN");
  				             }
  				             //EDIT JOB TITLE NAME
  				             WebElement OBJJTN1=Driver.findElement(By.xpath("//*[@id='txtJobTitleName']"));
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
  				                 Driver.findElement(By.xpath("//*[@id='editBtn']")).click();
  				                Thread.sleep(2000);
  				                

  				                // verification sucess fully updated or not
  				                if(Driver.findElement(By.xpath("html/body/div[1]/div[2]/form/div[2]/span")).getText().equals("Successfully Updated"))
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
  				                      String JTNAME1=Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j2+"]/td[3]/a")).getText();
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
  				}
  				                //------------------------TEST CASE  - 11 JOBTITLE DELETION----------------------------------------//
  				                      
  				                    public void JOBTITLE_DELETION() throws FileNotFoundException, IOException, Exception
  	  				  				{
  				                      
  				                Driver.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+j2+"]/td[1]/input")).click();
  				               
  				                  }
  				                
  				                Driver.findElement(By.xpath("//input[@value='Delete']")).click();
  				                
  				                if(A.getText().equals("Deletion may affect Pay Grade of Employees in PIM. Do you want to delete ?"))
  				                {
  				                    System.out.println("ALERT DISPLAYED AS : Do you want to delete ? ");
  				                }
  				                A.accept();
  				                
  				            // VERIFY SUCESSFULLY DELETED OR NOT
  				                
  				                if(Driver.findElement(By.xpath("//div[@class='messagebar']")).getText().equals("Successfully Deleted"))
  				                {
  				                    System.out.println(JTN2+" DELETED AT:"+i);
  				                }
  				                else
  				                {
  				                    System.out.println("Successfully Deleted is not Displayed");
  				                }
  				               Driver.switchTo().defaultContent();
  				               Thread.sleep(3000);
  				                // click on logout
  				                //OBJLOGOUT.click();
  				               Driver.findElement(By.linkText("Logout")).click();
  				                
  				                // wait & verify home page is displayed or not
  				               wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
  				               
  				                if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
  				                {
  				                    System.out.println("LOGOUT SUCESSFULL & HOME PAGE IS DISPLAYED");
  				                }
  				                else
  				                {
  				                    System.out.println("FAILED TO OPEN HOME PAGE");
  				                }

  					
  				}
    			  
    			  
    			  
    	
    	
    	
    	
    	
    	
    	
    	
	}

    	
    	
    	    

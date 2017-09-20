package ms_testcases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.ext.WEBGL_compressed_texture_s3tc;
import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

public class MS_Selenium_TC09_TC10_TC11 
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
		
// S.No 4 -  Focus on Job==========================================================================================================	
				
				//Driver.navigate().refresh();
				WebElement OBJJOB1 = Driver.findElement(By.linkText("Job"));
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
				WebElement OBJJTTL = Driver.findElement(By.linkText("Job Titles"));
				WebElement OBJJSPC = Driver.findElement(By.linkText("Job Specifications"));
				WebElement OBJJPAYG = Driver.findElement(By.linkText("Pay Grades"));
				WebElement OBJJEMST = Driver.findElement(By.linkText("Employment Status"));
				WebElement OBJJEOJC = Driver.findElement(By.linkText("EEO Job Categories"));
				
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
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
				
				// Verify job title and all fields
				if(Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[1]/h2")).getText().equals("Job : Job Title"))
				{
					System.out.println("Job : Job Title is displayed");
				}
				else
				{
					System.out.println("Job : Job Title is not displayed");
				return;
				}
				
				// Verify All
				
				if(Driver.findElement(By.cssSelector(".searchbox>label")).getText().equals("Search By:"))
				{
					System.out.println("Search By:is Displayed");
				}
				else
				{
					System.out.println("Search By:is not Displayed");
				return;	
				}
				
				// Create web elements
				
				WebElement OBJSDROP = Driver.findElement(By.name("loc_code"));
				WebElement OBJSFOR = Driver.findElement(By.name("loc_name"));
				
				if(OBJSDROP.isDisplayed()&&OBJSFOR.isDisplayed())
				{
					System.out.println("Dropdown and search text field is displayed");
				}
				else
				{
					System.out.println("Dropdown and search text field is not displayed");
				return;
				}
				
				WebElement OBJSRH = Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/input[2]"));
				WebElement OBJRST = Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[2]/input[3]"));
				WebElement OBJADD = Driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[3]/div[1]/input[1]"));
				WebElement OBJDLT = Driver.findElement(By.xpath("//html/body/div/div[2]/form/div[3]/div[1]/input[2]"));
				
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
				
				if(Driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/div/h2")).getText().equals("Job : Job Title"))
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
					
				
					WebElement OBJES = Driver.findElement(By.name("cmbAssEmploymentStatus"));
					WebElement OBJAES = Driver.findElement(By.name("butUnAssEmploymentStatus"));
					WebElement OBJEES = Driver.findElement(By.name("butUnAssEmploymentStatus"));
					WebElement OBJLDRP = Driver.findElement(By.xpath("//*[@id='cmbAssEmploymentStatus']"));
					WebElement OBJRDRP = Driver.findElement(By.xpath("//*[@id='cmbUnAssEmploymentStatus']"));
					WebElement OBJADD1 = Driver.findElement(By.xpath("//input[@value='< Add']"));
					
					WebElement OBJRMV1 = Driver.findElement(By.xpath("//input[@value='Remove >']"));
							
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
			                //------------------------TEST CASE  - 11 JOBTITLE DELETION----------------------------------------//
			                      
			                      
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
			                // CLOSE & QUIT THE BROWSER
			               Driver.close();
			               Driver.quit();
			               
			                

				
				
				
				
				


	}

}

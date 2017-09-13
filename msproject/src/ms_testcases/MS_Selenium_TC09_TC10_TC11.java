package ms_testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.ext.WEBGL_compressed_texture_s3tc;

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
					A.accept();	
					}
					
				// Create web elements for job title name and job description
					
					WebElement OBJJTN = Driver.findElement(By.name("txtJobTitleName"));
					WebElement OBJJDIS = Driver.findElement(By.name("txtJobTitleDesc"));
					
					String JTN = "Software Test Engineer";
					String JDIS = "Automation in Selenium Domain";
					
					OBJJTN.clear();
					OBJJTN.sendKeys(JTN);
					OBJSAVE.click();
					
					if(A.getText().equals("Job Description should be specified"))
					{
						System.out.println("Alert is displayed as 'Job Description should be specified'");
					}
					else
					{
						System.out.println("Alert is not displayed '");
					Thread.sleep(2000);	
					A.accept();	
					}
					
					OBJJDIS.clear();
					OBJJDIS.sendKeys(JDIS);
					OBJSAVE.click();
					
					
					
					
						
				
				
				
				
				
				


	}

}

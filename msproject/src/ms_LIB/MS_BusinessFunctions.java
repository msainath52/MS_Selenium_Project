package ms_LIB;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import static org.testng.Assert.*;

public class MS_BusinessFunctions
{
	
	WebDriver Brow;
	WebDriverWait Wait;
	WebElement objUN;
	WebElement objPWD;
	
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
		
    public void AddEmployee()
    {
    	Reporter.log("Add Employee");
    }
	

}

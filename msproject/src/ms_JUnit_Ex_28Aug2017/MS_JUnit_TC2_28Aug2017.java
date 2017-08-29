package ms_JUnit_Ex_28Aug2017;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MS_JUnit_TC2_28Aug2017 
{

	WebDriver Brow;
  	WebDriverWait wait;
  	
  	@Before
  	public void Setup()
  	{
  		//System.setProperty("webdriver.gecko.driver","D:\\tet\\Selenium_Demp\\geckodriver.exe");
  		//Brow = new FirefoxDriver();
  		
  		System.setProperty("webdriver.chrome.driver","D:\\tet\\chromedriver.exe");
  		Brow = new ChromeDriver();
  		
  		wait = new WebDriverWait(Brow, 30);
  		Brow.manage().window().maximize(); 		
  	
  	}
  	@After
  	public void shutdown()
  	{
  		Brow.close();
  		Brow.quit();
  		
  	}
  	
  	@Test
  	public void VerifyOrangeHRM()
	   {
		Brow.get("http://classroom:90/qahrm/login.php");
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		// Verify home page
		
		Assert.assertEquals("OrangeHRM - New Level of HR Management",Brow.getTitle());
		System.out.println("Home Page Displayed");
				
		// Create Object for UN, PWD
		
		WebElement UN = Brow.findElement(By.name("txtUserName"));
		WebElement PWD = Brow.findElement(By.name("txtPassword"));
		
		// Verify UN, PWD
		
		Assert.assertTrue(UN.isDisplayed()&&PWD.isDisplayed());
     	System.out.println("UN,PWD are exist");
				
		// Type UN and PWD
		
		String username = "qaplanet1";
		UN.sendKeys(username);
		PWD.sendKeys("user1");
		
		// Click on login
		
		Brow.findElement(By.name("Submit")).click();
		wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		
		// Verify Home Page
		
		Assert.assertEquals("OrangeHRM",Brow.getTitle());
		System.out.println("OrangeHRM page displayed");
		
		
		// Get Welcome Text
		
		String WelTxt = Brow.findElement(By.xpath(".//*[@id='option-menu']/li[1]")).getText();
		
		// Verify Welcome Text
		
		Assert.assertEquals(WelTxt,"Welcome "+username);			
		
		System.out.println("Welcome"+username+"displayed");			
		
		
		// Click on Logout
		
		Brow.findElement(By.linkText("Logout")).click();;
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		
		// Verify home page
		
		Assert.assertEquals("OrangeHRM - New Level of HR Management",Brow.getTitle());
		System.out.println("Signoff succesfull and Home Page Displayed");
		
	   	

	 }
  	

}

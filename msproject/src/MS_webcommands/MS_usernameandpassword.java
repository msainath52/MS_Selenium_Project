package MS_webcommands;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MS_usernameandpassword {

	public static void main(String[] args)throws Exception {

        System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");  
		
	    ChromeDriver Driver = new ChromeDriver();
		
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		
	    Driver.findElement(By.name("txtUserName")).clear(); 
	    
	    Driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
	    
        Driver.findElement(By.name("txtPassword")).clear(); 
	    
	    Driver.findElement(By.name("txtPassword")).sendKeys("user1");
	    
	    Driver.findElement(By.name("Submit")).click();  
	    
		Thread.sleep(2000);
		
		Driver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(2000);
		
		Driver.close();		
		
		
	}

}

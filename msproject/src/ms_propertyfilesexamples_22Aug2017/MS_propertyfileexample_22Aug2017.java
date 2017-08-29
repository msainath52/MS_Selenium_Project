package ms_propertyfilesexamples_22Aug2017;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MS_propertyfileexample_22Aug2017 
{

	public static void main(String[] args) throws Exception
	
	{
		Properties obj = new Properties();
		obj.load(new FileInputStream("D:\\msainath\\msproject\\src\\ms_propertyfilesexamples\\MS_propertyexample1"));
		String strurl = obj.getProperty("URL");
		String strusername = obj.getProperty("username");
		String strpassword = obj.getProperty("password");
		
		//-----------------------------------------------------
		
		System.setProperty("webdriver.chrome.driver","D:\\tet\\chromedriver.exe");
		
		//*******************************************************************************
		
		ChromeDriver Br = new ChromeDriver();
		Br.navigate().to(strurl);
		
		Thread.sleep(2000);
		
		Br.findElement(By.name("txtUserName"));
		Br.findElement(By.name("txtUserName")).sendKeys(strusername);
		Br.findElement(By.name("txtPassword")).sendKeys(strpassword);
		Br.findElement(By.name("Submit")).click();
		
		Thread.sleep(1000);
		
		Br.findElement(By.linkText("Logout")).click();
		Br.close();
		Br.quit();

	}

}

package MS_webcommands;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class ms_itemsfromdropdown {

	public static void main(String[] args) throws Exception {
		
          System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");  
		
	      ChromeDriver Driver = new ChromeDriver();
	      
	      Driver.get("http://classroom:90/webapp/SelectAWebSite.html");
	      
	      Thread.sleep(2000);
	      
	      WebElement E = Driver.findElement(By.name("OptWeb"));
	      
	      Select set = new Select(E);
	      
	      set.selectByVisibleText("QAPlanet");
	      
	      Thread.sleep(2000);
	      
	      set.selectByIndex(0);
	      
	      Thread.sleep(2000);
	      
	      set.selectByValue("Google");
	      
	      Thread.sleep(2000);
	      
	      Driver.close();
	      
	      
	      
	      
	      

	}

}

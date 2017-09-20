package GeneralBrowsers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser 
{
	WebDriver browser;
	Actions action;
	Select Se;
	Alert alrt;
	
	//Start firefox browser
	public void StartBrowser()
	{
		browser =new FirefoxDriver();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//browser.findElement(By.cssSelector(selector)(linkText))
		browser.get("http://apps.qaplanet.in/qahrm/login.php");
	}
	//Maximize the Browser 
	public void maximizeBrowser()
	{
		browser.manage().window().maximize();
	}
	public int LocatorType(String identifier)
	{
		int id=1;
		if(identifier=="id")
		{
			id=1;
			
		}
		else if(identifier=="className")
		{
			id=2;
		}
		else if(identifier=="tagName")
		{
			id=3;
		}
		else if(identifier=="name")
		{
			id=4;
		}
		else if(identifier=="linkText")
		{
			id=5;
		}
		else if(identifier=="partialLinkText")
		{
			id=6;
		}
		else if(identifier=="cssSelector")
		{
			id=7;
		}
		else if(identifier=="xpath")
		{
			id=8;
		}
		else 
		{
			
			id=0;
			System.out.println("invalid identifier");
		}
		
		
		return id;
	}
	//Webelemnt
		public WebElement WebElementId(String identifier,String locator)
		{
			int id=LocatorType(identifier);
			WebElement e =null;
			switch(id)
			{
			case 1: e=browser.findElement(By.id(locator));
			        break;
			case 2: e=browser.findElement(By.className(locator));
	                break;
			case 3: e=browser.findElement(By.tagName(locator));
            break;
			case 4: e=browser.findElement(By.name(locator));
            break;
			case 5: e=browser.findElement(By.linkText(locator));
            break;
			case 6: e=browser.findElement(By.partialLinkText(locator));
            break;
			case 7: e=browser.findElement(By.cssSelector(locator));
            break;
			case 8: e=browser.findElement(By.xpath(locator));
            break;
			default :System.out.println("Locator not identified");
			     e=null;
			}
			return e;
		}
		//Findelements
		public List<WebElement> WebElementIds(String identifier,String locator)
		{
			int id=LocatorType(identifier);
			List<WebElement> e =null;
			switch(id)
			{
			case 1: e=browser.findElements(By.id(locator));
			        break;
			case 2: e=browser.findElements(By.className(locator));
	                break;
			case 3: e=browser.findElements(By.tagName(locator));
            break;
			case 4: e=browser.findElements(By.name(locator));
            break;
			case 5: e=browser.findElements(By.linkText(locator));
            break;
			case 6: e=browser.findElements(By.partialLinkText(locator));
            break;
			case 7: e=browser.findElements(By.cssSelector(locator));
            break;
			case 8: e=browser.findElements(By.xpath(locator));
            break;
			default :System.out.println("Locator not identified");
			     e=null;
			}
			return e;
		}
			public void SendKeys(String identifier,String locator,String content)
			{
				WebElement e =WebElementId(identifier,locator);
				e.sendKeys(content);
						
			}
		public void clearTextField(String identifier,String locator)
		{
			WebElement e =WebElementId(identifier,locator);
			e.clear();
			
		}
		public void click(String identifier,String locator)
		{
			WebElement e =WebElementId(identifier,locator);
			e.click();
			
		}
		public void VerifyTitle(String title)
		{
			if(browser.getTitle().equals(title))
			{
				System.out.println(title + "displayed");
			}
			else
			{
				System.out.println("Title is not displayed");
			}
		}
		public void Wiatforsometime(long waitTIme)
		{
			try{
				browser.wait(waitTIme);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		public void waitUntilElementTObePresent(String ElementPath)
		{
			WebElement elementPresent=(new WebDriverWait(browser, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ElementPath))));
			
		}
		public void verifyText(String identifier,String locator,String text)
		{
			WebElement e =WebElementId(identifier, locator);
			if(e.getText().equals(text))
			{
				System.out.println("Text is verified ");
			}
			else
			{
				System.out.println("text is not dipalyed ");
			}
					}
		public void verifyElmentPresent(String identifier,String locator) 
		{
			boolean s= false;
			WebElement e =WebElementId(identifier, locator);
			s=(e!=null);
			if(s==true)
			{
				System.out.println("element is present");
			}
			else
			{
				System.out.println("Element is not present");
			}
			
		}
		public void sleepThread(long sleeptime)
		{
			try{
				Thread.sleep(sleeptime);
			}catch(Exception e){
				System.out.println(e);
			}
				
		}
		public void waitforPageToload()
		{
			try{
				for(int i=0;i<50;)
				{
					if(browser.getTitle().length()!=0)
					{
						System.out.println("page is loaded");
						i=51;
						break;
						
					}
					else
					{
						Thread.sleep(1000L);
					}
						
					
				}	
			}catch(Exception e ){
				System.out.println();
			}
		}
		//Select frame by idElement
		
		public void SelectFrameById(String locator)
		{
			browser.switchTo().frame(locator);		
		}
		//Select Default frame 
		public void SelectDefaultFrame()
		{
			browser.switchTo().defaultContent();
		}
		//getting data from table 
		public void VerifyElementInTable(String xpathlocator,String text)
		{
			boolean a=false;
			List<WebElement> tdlist=browser.findElements(By.xpath(xpathlocator));
			for(WebElement e1:tdlist)
			{
				if(e1.getText().equals(text))
				{
					a=true;					
					break;
					
				}
				
			}
			if(a==true)
			{
				System.out.println(text + "was identifiesd");
			}
			else
			{
				System.out.println(text + "was not identifiesd");
			}
		}
		//Start action 
		public void startActions()
		{
		   action = new Actions(browser);
				
		}
		//Move to Elements
		public void MoveTOElement(String identifier,String locator)
		{
			WebElement e=WebElementId(identifier, locator);
			 action.moveToElement(e);
			
		}
		public void clickActions()
		{
			action.click().perform();
		}
		//@SuppressWarnings("null")
		public void SelectItemFromDroopdrown(String identifier,String locator)
		{
			
			WebElement e=WebElementId(identifier, locator);
			Se=new Select(e);
			 Se.selectByIndex(1);
			
			// Se.selectByVisibleText("india");
			
		}
		public void Successfulmessage(String Message)
		{
			String str=browser.findElement(By.xpath("html/body/div/div[2]/form/div[2]/span")).getText();
		     if(Message.equals(str))
		     {
		    	 System.out.println("Successfull deleted the employee information from the table");
		     }
		
			
		}
		public void acceptAlert()
		{
			alrt=browser.switchTo().alert();
			alrt.accept();
			
		}
		
		
		public void closeBrowser()
		{
			browser.close();
		}
		public void QuitBrowser()
		{
			browser.quit();
		}
		
	}



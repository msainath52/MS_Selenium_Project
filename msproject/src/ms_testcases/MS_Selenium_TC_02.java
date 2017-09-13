package ms_testcases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MS_Selenium_TC_02 {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		
//Maximize browser
		Driver.manage().window().maximize();
		
//------------------------------------------------
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		Actions Act=new Actions(Driver);
//------------------------------------------------

//Open orangeHRM
		Driver.get("http://apps.qaplanet.in/qahrm/login.php");
		
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

//Create webelements for user name,password,login and clear
		WebElement objUserName=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement objPassword=Driver.findElement(By.name("txtPassword"));
		WebElement objLogin=Driver.findElement(By.name("Submit"));
		WebElement objClear=Driver.findElement(By.name("clear"));
		
		
//-------------------------------------------------------------
		
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
//--------------------------------------------------------------
//Get welcome text
		String strWelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
//Verify welcome text
		if(strWelText.equals("Welcome "+strUserName))
		{
		System.out.println("Welcome "+strUserName+" displayed");
		}

//Get only user name
		String[] Arr=strWelText.split(" ");
		String sUN=Arr[1].trim();
		if(sUN.equals(strUserName))
		{
		System.out.println(strUserName+" displayed");
		}

//Create webelements for change password and logout
		WebElement objChangePassword=Driver.findElement(By.linkText("Change Password"));
		WebElement objLogout=Driver.findElement(By.linkText("Logout"));
		
//Verify change password and logout
		if(objChangePassword.isDisplayed() && objLogout.isDisplayed())
		{
		System.out.println("Change password and logout are displayed");
		}
		
//------------------------------Step3-------------------------------------------
//Create webElement for PIM
		WebElement objPIM=Driver.findElement(By.id("pim"));
		
//Mouse over on pim
		Act.moveToElement(objPIM).perform();
		
//Click on add employee
		Driver.findElement(By.linkText("Add Employee")).click();
		
//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));

//Verify PIM : Add Employee
		if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee"))
		{
		System.out.println("PIM : Add Employee displayed");
		}

//Get employee code
		String sEmpcode=Driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
		
//----------------------------------------------------------------
		String sFN="Sainath";
		String sLN="M";
//----------------------------------------------------------------
		
//Create webElement for save
		WebElement objsave=Driver.findElement(By.id("btnEdit"));
		
//Click on save
		objsave.click();
		
//wait for alert
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		
//Verify Last Name Empty! alert
		if(A.getText().equals("Last Name Empty!"))
		{
		System.out.println("Last Name Empty! displayed");
		A.accept();
		Driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
		}
		
//Click on save
		objsave.click();
//wait for alert
		Alert A1=wait.until(ExpectedConditions.alertIsPresent());
		
//Verify First Name Empty! alert
		if(A1.getText().equals("First Name Empty!"))
		{
		System.out.println("First Name Empty! displayed");
		A1.accept();
		Driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
		}
//Click on save
		objsave.click();

//wait for Personal Details
		if(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details")))
		{
		System.out.println("Personal Details displayed");
		}

				
//Switch to parent frame
		Driver.switchTo().parentFrame();

//----------------Employee list-----------------------------------------------
//Mouse over on pim
		Act.moveToElement(objPIM).perform();
		
//Click on Employee List
		Driver.findElement(By.linkText("Employee List")).click();
		
//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));

//Verify Employee Information
		if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
		{
		System.out.println("Employee Information displayed");
		} 

//-------------------------Check empployee details---------------------------------------------------
//Get row count
		int rc=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
		int i;
		for(i=1;i<=rc;i++)
		{

//Get second column data
			String sEmpID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
//Get third column data
		String sEmpName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
		if(sEmpName.equals(sFN+" "+sLN) && sEmpID.equals(sEmpcode))
		{
		System.out.println(sEmpcode+" , "+sEmpName+" displayed at: "+i);
		break;
		}
		}
	
//Switch to top frame
		Driver.switchTo().defaultContent();
//---------------------------------------------------------------------------
//Click on logout
		objLogout.click();
//Verify home page
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
		System.out.println("Signoff sucessfull & Home Page displayed");
		}
		else
		{
		System.out.println("Failed to Signoff");
		return;
		}
//--------------------------------------------------------------
		Driver.close();
		Driver.quit();
		
		
	}

}

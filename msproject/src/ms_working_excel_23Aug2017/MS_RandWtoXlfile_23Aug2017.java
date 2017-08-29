package ms_working_excel_23Aug2017;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class MS_RandWtoXlfile_23Aug2017 
{

	public static void main(String[] args) throws Exception
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\tet\\Selenium_Demp\\geckodriver.exe");
		System.setProperty("WebDriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
		//WebDriver Brow = new FirefoxDriver();
		ChromeDriver Brow=new ChromeDriver();
		Brow.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(Brow,20);
		
		// Open Application-------------------------------------------------------------------------
		
		Brow.get("http://apps.qaplanet.in/qahrm/login.php");
		
		// Read data objects--------------------------------------------------------------------------
		
		File fis = new File("C:\\Users\\admin\\Desktop\\123.xls");
		Workbook objWB = Workbook.getWorkbook(fis);
		Sheet InPutSheet = objWB.getSheet(1);
		
		// Write data objects-------------------------------------------------------------------------
		
		WritableWorkbook wwb = Workbook.createWorkbook(new File("C:\\Users\\admin\\Desktop\\Res.xls"));
		WritableSheet OutPutSheet = wwb.createSheet("HRM",0);
		Label l = new Label(0, 0, "user name");
		Label l1 = new Label(1, 0, "pass word");
		Label l2 = new Label(2, 0, "result");
		
		OutPutSheet.addCell(l);
		OutPutSheet.addCell(l1);
		OutPutSheet.addCell(l2);
		
		Label r1;
		Label r2;
		Label r3;
		
		// Get row count---------------------------------------------------------------------------------
		
		int RCount = InPutSheet.getRows();
		
		System.out.println(RCount);
		
		for (int i =1; i <RCount; i++) 
		{
		  System.out.println("Iteration no:"+ i);	
		
		
		// Create Object for user name---------------------------------------------------------------------
		
		WebElement objUN = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		objUN.clear();
		objUN.sendKeys(InPutSheet.getCell(0,i).getContents());
		
		
		// Create object for password------------------------------------------------------------------------
		
		WebElement objPWD = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		objPWD.clear();
		objPWD.sendKeys(InPutSheet.getCell(1, i).getContents());
		
		
		
		// Click on login-----------------------------------------------------------------------------------
		
		WebElement objLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		objLogin.click();
		
		Thread.sleep(4000);
		
		String res = "passed";
		String res1 = "Failed";
		
		// Verify orangeHRM home page-------------------------------------------------------------------------
		
		if (Brow.getTitle().equals("OrangeHRM"))
			{
			   System.out.println("Login Successfull");
			   
			   r1=new Label(0, i, InPutSheet.getCell(0, i).getContents());
			   r2=new Label(1, i, InPutSheet.getCell(1, i).getContents());
			   r3=new Label(2, i, res);
			   
			   OutPutSheet.addCell(r1);
			   OutPutSheet.addCell(r2);
			   OutPutSheet.addCell(r3);
			   
			 // Click on logout--------------------------------------------------------------------------------
			   
			   Brow.findElement(By.linkText("Logout")).click();
			   Thread.sleep(4000);
			
			}
		else
		   {
			System.out.println("Failed");
			
			   r1=new Label(0, i, InPutSheet.getCell(0, i).getContents());
			   r2=new Label(1, i, InPutSheet.getCell(1, i).getContents());
			   r3=new Label(2, i, res);
			   
			   OutPutSheet.addCell(r1);
			   OutPutSheet.addCell(r2);
			   OutPutSheet.addCell(r3);
			   
			   Thread.sleep(4000);
			   
			   Brow.findElement(By.name("clear")).click();
			   
		   }
		
		}
		
		wwb.write();
		wwb.close();
		Brow.close();
		Brow.quit();
		
	}

}

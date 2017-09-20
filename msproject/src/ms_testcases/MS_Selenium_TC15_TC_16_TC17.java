package ms_testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MS_Selenium_TC15_TC_16_TC17 
{

	public static void main(String[] args) throws Exception 
	{
		//--------------------------------------TC15_TC16_TC17 ------------------------//


		 

		    {
		        
		    	System.setProperty("webdriver.chrome.driver", "D:\\tet\\chromedriver.exe");
				ChromeDriver driver=new ChromeDriver();
				
				//Maximize browser
				driver.manage().window().maximize();
				
		        
		        // EXPLICIT WAIT COMMAND 
		        WebDriverWait wait=new WebDriverWait(driver, 15);
		        
		        // GET URL
		        driver.get("http://apps.qaplanet.in/qahrm/login.php");
		        // WAIT FOR TITLE
		        wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		        // VERIFY TITLE
		        if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		        {
		            System.out.println("OrangeHRM - New Level of HR Management HOMEPAGE IS DISPLAYED");
		        }
		        else
		        {
		            System.out.println("FAILED TO LOAD HOME PAGE ");
		        }
		        
		        // CREATE WEBELEMENT FOR USERNAME ,PASSWORD,LOGIN AND CLEAR
		        
		        WebElement OBUSN=driver.findElement(By.name("txtUserName"));
		        WebElement OBPWD=driver.findElement(By.name("txtPassword"));
		        WebElement OBLGN=driver.findElement(By.name("Submit"));
		        WebElement OBCLR=driver.findElement(By.name("clear"));
		        
		        // VERIFY ABOVE ALL
		        if(OBUSN.isDisplayed()&&OBPWD.isDisplayed()&&OBLGN.isDisplayed()&&OBCLR.isDisplayed())
		        {
		            System.out.println("USERNAME,PASSWORD,LOGIN,CLEAR ARE DISPLAYED");
		        }
		        else
		        {
		            System.out.println("USERNAME,PASSWORD,LOGIN,CLEAR ARE DISPLAYED");
		        }
		        
		        String USN="qaplanet1";
		        String PWD="user1";
		        
		        // SEND DATA
		        
		        OBUSN.clear();
		        OBUSN.sendKeys(USN);
		        OBPWD.clear();
		        OBPWD.sendKeys(PWD);
		        OBLGN.click();
		        
		        Thread.sleep(2000);
		        
		        if(driver.getTitle().equals("OrangeHRM"))
		        {
		            System.out.println("OrangeHRM PAGE IS DISPLAYED");
		            
		        }
		        else
		        {
		            System.out.println("FAILED TO LOGIN ");
		        }
		        
		        // CREATE WEBWELEMENT FOR WELCOME USERNAME AND CHANGE PASSWORD AND LOGOUT
		        
		        WebElement OBWUSN=driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]"));
		        WebElement OBCP=driver.findElement(By.linkText("Change Password"));
		        WebElement OBLGT=driver.findElement(By.linkText("Logout"));
		        
		        // VERIFY WELCOME USERNAME 
		        if(OBWUSN.equals("Welcome "+USN))
		        {
		            System.out.println("Welcome "+USN +" :IS DISPLAYED");
		        }else
		        {
		            System.out.println("Welcome "+USN +" :IS NOT DISPLAYED");
		        }
		        
		        // VERIFY ,CHANGE PASSWORD,LOGOUT
		        
		        if(OBCP.isDisplayed()&&OBLGT.isDisplayed())
		        {
		            System.out.println("CHANGE PASSWORD AND LOGOUT IS DISPLAYED");
		        }
		        else
		        {
		            System.out.println("CHANGE PASSWORD AND LOGOUT IS NOT DISPLAYED");
		            
		        }
		        
		        // CREATE WEB ELEMENT FOR ADMIN
		        WebElement OBADMIN=driver.findElement(By.id("admin"));
		        
		        // VERIFY
		        if(OBADMIN.isDisplayed())
		        {
		            System.out.println("ADMIN IS DISPLAYED");
		        }
		        else
		        {
		            System.out.println("ADMIN IS NOT DISPLAYED");
		        }
		        // ACTION COMMAND
		        Actions ACT=new Actions(driver);
		        
		        // MOVE TO ELEMENT ON ADMIN
		        
		        ACT.moveToElement(OBADMIN).perform();
		        

		        // CREATE OBJECT FOR COMPANY INFO,JOBS,QUALIFICATIONS,SKILLS,ETC,

		          WebElement OBCOM=driver.findElement(By.linkText("Company Info"));
		          WebElement OBJOB=driver.findElement(By.linkText("Job"));
		          WebElement OBQAL=driver.findElement(By.linkText("Qualification"));
		          WebElement OBSKL=driver.findElement(By.linkText("Skills"));
		        
		          // VERIFY COMPANY INFO,JOBS,QUALIFICATIONS,SKILLS,ETC,
		          if(OBCOM.isDisplayed()&&OBJOB.isDisplayed() && OBQAL.isDisplayed() && OBSKL.isDisplayed())
		          {
		           System.out.println("COMPANY INFO & JOB & QUALIFICATIONS & SKILLS ARE DISPLAYED");
		           
		          }
		          else
		          {
		           System.out.println("COMPANY INFO & JOB & QUALIFICATIONS & SKILLS ARE NOT DISPLAYED");
		           return;
		          }
		          // MOVE TO ELEMENT ON QUALIFICATIONS
		          
		          ACT.moveToElement(OBQAL).perform();
		          
		          // CREATE WEBeLEMENT FOR EDUCATION,LICENCES
		        WebElement OBEDU=driver.findElement(By.linkText("Education"));
		        WebElement OBLIC=driver.findElement(By.linkText("Licenses"));
		        
		        // VERIFY 
		        
		        if(OBEDU.isDisplayed()&&OBLIC.isDisplayed())
		        {
		            System.out.println("EDUCATION,LICENCES ARE DISPLAYED");
		        }
		        else
		        {
		            System.out.println("EDUCATION,LICENCES ARE NOT DISPLAYED");
		        }
		        
		        Thread.sleep(2000);
		        // MOVE TO ELEMENT ON EDUCATION
		        ACT.moveToElement(OBEDU).click().perform();
		        
		        // WAIT FOR FRAME AND SWITCH TO IT
		        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
		        Thread.sleep(2000);
		        
		        // VERIFY QUALIFICATION : EDUCATION
		        
		        WebElement WEQE=driver.findElement(By.cssSelector(".mainHeading>h2"));
		        if(WEQE.getText().equals("Qualification : Education"))
		        {
		            System.out.println("Qualification : Education is Displayed 1 ");
		        }
		        else
		        {
		            System.out.println("Qualification : Education is Not Displayed 1");
		        }
		        
		         //     CREATE WEB ELEMENTS FOR INPUT FIELDS AND BUTTONS
		          
		          WebElement OBSBY=driver.findElement(By.name("loc_code"));
		          WebElement OBSFR=driver.findElement(By.name("loc_name"));
		          WebElement OBSRH=driver.findElement(By.xpath("//input[@value='Search']"));
		          WebElement OBRST=driver.findElement(By.xpath("//input[@value='Reset']"));
		          WebElement OBADD=driver.findElement(By.xpath("//input[@value='Add']"));
		          WebElement OBDLT=driver.findElement(By.xpath("//input[@value='Delete']"));
		          
		          //    VERIFY WEB ELEMENTS
		          
		          if(OBSBY.isDisplayed()&&OBSFR.isDisplayed()&&OBSRH.isDisplayed()&&OBRST.isDisplayed()&&OBADD.isDisplayed()&&OBDLT.isDisplayed())
		          {
		              System.out.println("SEARCH ,SEARCH FOR,SEARCH,RESET,ADD,DELETE BUTTONS ARE DISPLAYED");
		          }
		          else
		          {
		              System.out.println("SEARCH ,SEARCH FOR,SEARCH,RESET,ADD,DELETE BUTTONS ARE NOT DISPLAYED");
		                
		          }
		          
		          //     NOW CLICK ON ADD BUTTON
		          
		          OBADD.click();
		          Thread.sleep(3000);
		    
		        // VERIFY QUALIFICATION : EDUCATION
		              WebElement WEQE1=driver.findElement(By.cssSelector(".mainHeading>h2"));
		            if(WEQE1.getText().equals("Qualification : Education"))
		            {
		                System.out.println("Qualification : Education is Displayed 2 ");
		            }
		            else
		            {
		                System.out.println("Qualification : Education is Not Displayed 2");
		            }
		            
		            String INST="QAPLANET";
		            String COURS="SOFTWARE TESTING";
		            
		        // CREATE WEBELEMENT FOR INSITUTE,COURSE, SAVE BUTTON
		            
		            WebElement OBINST=driver.findElement(By.xpath("//input[@id='txtUni']"));
		            WebElement OBCOURS=driver.findElement(By.xpath("//input[@id='txtDeg']"));
		            WebElement OBSAV=driver.findElement(By.xpath("//input[@value='Save']"));
		            
		            
		            
		        // VERIFY ABOVE
		            
		            if(OBINST.isDisplayed()&&OBCOURS.isDisplayed()&&OBSAV.isDisplayed())
		            {
		                System.out.println("INSITUTE,COURSE, SAVE IS DISPLAYED");
		            }
		            else
		            {
		                System.out.println("INSITUTE,COURSE, SAVE IS NOT DISPLAYED");
		            }
		        //  CLICK ON SAVE
		            
		            OBSAV.click();
		            
		        // CREATE ALERT 
		            Alert A=driver.switchTo().alert();
		        
		        // VERIFY ALERT TEXT
		            if(A.getText().equals("Please correct the following\n\n    - Institute Cannot be a Blank Value!\n    - Course Cannot be a Blank Value!\n"))
		            {
		                System.out.println("ENTER INSTITUTE & COURSE DETAILS ARE  DISPLAYED");
		            }
		            else
		            {
		                System.out.println("ENTER INSTITUTE & COURSE DETAILS ARE NOT DISPLAYED");
		            }
		            A.accept();
		        // SEND DATA
		            
		            OBINST.clear();
		            OBINST.sendKeys(INST);
		            
		        // CLICK ON SAVE 
		            driver.findElement(By.xpath("//input[@value='Save']")).click();
		            
		        // VERIFY ALERT TEXT
		            
		            if(A.getText().equals("Please correct the following\n\n    - Course Cannot be a Blank Value!\n"))
		            {
		                System.out.println("ENTER COURSE DETAILS ARE  DISPLAYED");
		            }
		            else
		            {
		                System.out.println("ENTER COURSE DETAILS ARE NOT DISPLAYED");
		            }
		            A.accept();
		        
		            Thread.sleep(2000);
		        // SEND DATA TO COURSE
		            
		            OBCOURS.clear();
		            OBCOURS.sendKeys(COURS);
		        
		            driver.findElement(By.xpath("//input[@value='Save']")).click();
		            Thread.sleep(2000);
		      //  VERIFY SUCESSFULLY ADDED  OR NOT
		            
		            if(driver.findElement(By.xpath("//span[@class='success']")).getText().equals("Successfully Added"))
		            {
		                System.out.println("Successfully Added is Displayed");
		            }
		            else
		            {
		                System.out.println("Successfully Added is not Displayed");
		            }
		            
		        // ROW COUNT
		            int rc=driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
		            int i;
		            
		            
		        //     LOOP 1
		                for(i=rc;i<=rc;i++)
		                {
		                    String USN1=driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[4]")).getText();
		                    
		                    //VERIFY
		                    if(USN1.equals(INST))
		                    {
		                        System.out.println(INST+" DISPLAYED AT:"+i);
		                    }
		                    else
		                    {
		                        System.out.println(INST+" IS NOT DISPLAYED");
		                    }
		        //-------------------------------EDIT QUALIFIFCATION TEST CASE 16---------------------------------------
		                    
		        //     CLICK ON EDUCATION    
		                    driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
		                    
		                    }
		                    Thread.sleep(3000);
		                
		        //     VERIFY         

		        //         VERIFY QUALIFICATION : EDUCATION
		                      WebElement WEQE2=driver.findElement(By.cssSelector(".mainHeading>h2"));
		                    if(WEQE2.getText().equals("Qualification : Education"))
		                    {
		                        System.out.println("Qualification : Education is Displayed 3 ");
		                    }
		                    else
		                    {
		                        System.out.println("Qualification : Education is Not Displayed 3");
		                    
		                    }
		                    Thread.sleep(2000);
		        //      WEB ELEMENT FOR EDIT
		                    WebElement OBEDIT=driver.findElement(By.xpath("//input[@id='editBtn']"));
		        //      VERIFY EDIT BUTTON
		                    if(OBEDIT.isDisplayed())
		                    {
		                        System.out.println("EDIT BUTTON IS DISPLAYED");
		                    }
		                    else
		                    {
		                        System.out.println("EDIT BUTTON IS NOT DISPLAYED");
		                
		                    }
		        //        CLICK ON EDIT 
		                    driver.findElement(By.xpath("//input[@id='editBtn']")).click();
		                    
		        //         TYPE DATA
		                String INST1="QA ,planet";
		                
		                WebElement WEINST1=    driver.findElement(By.xpath("//input[@id='txtUni']"));

		                    WEINST1.clear();
		                    WEINST1.sendKeys(INST1);
		                    
		        //         CLICK ON SAVE
		                    
		                    driver.findElement(By.xpath("//input[@value='Save']")).click();
		                    Thread.sleep(2000);
		    
		        //         VERIFY SUCESS FULLY UPDATED OR NOT
		                    if(driver.findElement(By.xpath("//span[@class='success']")).getText().equals("Successfully Updated"))
		                    {
		                        System.out.println("Successfully Updated is Displayed");
		                    }
		                    else
		                    {
		                        System.out.println("Successfully Updated is not Displayed");
		                    }        
		                    Thread.sleep(2000);
		       //                     LOOP 2
		                    int j;
		                    for(j=rc;j<=rc;j++)
		                    {
		                        String USN2=driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[4]")).getText();
		                        
		                        //VERIFY
		                        if(USN2.equals(INST1))
		                        {
		                            System.out.println(INST1+" DISPLAYED AT:"+j);
		                        }
		                        else
		                        {
		                            System.out.println(INST1+" IS NOT DISPLAYED");
		                        }
		        //-------------------------------DELETE QUALIFIFCATION TEST CASE 17---------------------------------------
		                        
		        //             CLICK ON EDUCATION    
		                        driver.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[1]/input")).click();
		                        
		                    }
		                    
		                    Thread.sleep(2000);
		        //           CLICK ON DELETE
		                    
		                 driver.findElement(By.xpath("//input[@value='Delete']")).click();
		                
		        //            VERIFY AND ACCEPT ALERT
		                 if(A.getText().equals("Deletion might affect Education. Do you want to delete ?"))
		                 {
		                     System.out.println("Do you want to delete ? ALERT IS DISPLAYED");
		                 }
		                 else
		                 {
		                     System.out.println("Do you want to delete ?ALERT IS NOT DISPLAYED");
		                 }
		                 A.accept();
		                 Thread.sleep(1000);
		        //            VERIFY SUCESSFULLY DELETED OR NOT
		                 if(driver.findElement(By.xpath("//div[@class='messagebar']/span")).getText().equals("Successfully Deleted"))
		                 {
		                     System.out.println("Successfully Deleted IS DISPLAYED");
		                 }
		                 else
		                     {
		                     System.out.println("Successfully Deleted IS NOT DISPLAYED");
		                     }
		   //       SWITCH TO DEFAULT FRAME
		                 driver.switchTo().defaultContent();
		                 Thread.sleep(3000);
		   //       REFRESH PAGE
		                
		                 driver.navigate().refresh();
		                 
		    //       CLICK ON LOGOUT
		               
		                driver.findElement(By.linkText("Logout")).click();
		              
		                 
		    //      WAIT AND VERIFY HOMPAGE DISPLAYED OR NOT
		                wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		                
		                 if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		                 {
		                     System.out.println("LOGOUT SUCESSFULL & HOME PAGE IS DISPLAYED");
		                 }
		                 else
		                 {
		                     System.out.println("FAILED TO OPEN HOME PAGE");
		                 }
		     //     CLOSE & QUIT THE BROWSER
		                driver.close();
		                driver.quit();
		                
		                 
		              
		    }
		}







	}



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



public class MS_selenium_TC12_TC13_TC14 
{

	public static void main(String[] args) throws Exception 
	{
		//--------------------------------TC 12 13 14--------------------------------------//
	
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		     WebDriverWait wait=new WebDriverWait(driver, 15);
		     driver.manage().window().maximize();
		     Actions ACT=new Actions(driver);
		     driver.get("http://classroom:90/qahrm/login.php");
		     wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		     
		     //VERIFY HOME PAGE
		     if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		     {
		      System.out.println("OrangeHRM - New Level of HR Management PAGE IS DISPLAYED");
		     }
		     
		     // CREATING OBJECTS NAMES
		     WebElement OBJUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		     WebElement OBJPWD=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		     WebElement OBJLOGIN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		     WebElement OBJCLEAR=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("clear")));
		     // VERIFYING USERNAME AND PASSWORDS
		     if(OBJUN.isDisplayed() && OBJPWD.isDisplayed())
		     {
		      System.out.println("USERNAME & PASSWORD IS DISPLAYED");
		      
		     }
		     if(OBJLOGIN.isDisplayed() && OBJCLEAR.isDisplayed())
		     {
		      System.out.println("LOGIN AND CLEAR DISPLAYED");
		      
		     }
		     String UN="qaplanet1";
		     String PWD="user1";
		     OBJUN.clear();
		     OBJUN.sendKeys(UN);
		     OBJPWD.clear();
		     OBJPWD.sendKeys(PWD);
		     OBJLOGIN.click();
		     //VERIFY ORANGE HRM PAGE TITLE
		     if(driver.getTitle().equals("OrangeHRM"))
		     {
		      System.out.println("OrangeHRM IS DISPLAYED");
		      
		     }
		     else
		     {
		      System.out.println("OrangeHRM NOT DISPLAYED");
		      return;
		     }
		     //GET WELCOME TEXT
		       String WELTXT=driver.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText();
		       //VERIFY WELCOME TEXT
		       if(WELTXT.equals("Welcome "+UN))
		       {
		        System.out.println("Welcome "+UN+"DISPLAYED");
		       }
		       else
		       {
		        System.out.println("WELCOME TEXT FAILED TO DISPLAY");
		        return;
		       }
		       WebElement OBJCP=driver.findElement(By.linkText("Change Password"));
		       WebElement OBJLOGOUT=driver.findElement(By.linkText("Logout"));
		       
		       //VERIFY CHANGE PASSWORD AND LOGOUT
		       if(OBJCP.isDisplayed() && OBJLOGOUT.isDisplayed())
		       {
		        System.out.println("CHANGE PASSWORD AND LOGOUT");
		       }
		       else
		       {
		        System.out.println("CHANGE PASSWORD AND LOGOUT NOT DISPLAYED");
		        return;
		       }
		       //WAY2
		       String[] ARR=WELTXT.split(" ");
		       if(ARR[1].equals(UN))
		       {
		        System.out.println("CHANGE PASSWORD AND LOGOUT");   
		       }
		       else
		       {
		        System.out.println("CHANGE PASSWORD AND LOGOUT NOT DISPLAYED");
		        return;
		       }

		      driver.navigate().refresh();

		      WebElement OBJADM=driver.findElement(By.id("admin"));
		      
		      if(OBJADM.isDisplayed())
		      {
		       System.out.println("Admin is displayed");
		      }
		      else
		      {
		       System.out.println("Admin is not Displayed");
		       return;
		      }
		      
		      // MOUSE OVER

		      ACT.moveToElement(OBJADM).perform();

		      // CREATE OBJECT FOR COMPANY INFO,JOBS,QUALIFICATIONS,SKILLS,ETC,

		      WebElement OBJCOM=driver.findElement(By.linkText("Company Info"));
		      WebElement OBJJOB=driver.findElement(By.linkText("Job"));
		      WebElement OBJQAL=driver.findElement(By.linkText("Qualification"));
		      WebElement OBJSKL=driver.findElement(By.linkText("Skills"));
		      // VERIFY COMPANY INFO,JOBS,QUALIFICATIONS,SKILLS,ETC,
		      if(OBJCOM.isDisplayed()&&OBJJOB.isDisplayed() && OBJQAL.isDisplayed() && OBJSKL.isDisplayed())
		      {
		       System.out.println("COMPANY INFO & JOB & QUALIFICATIONS & SKILLS ARE DISPLAYED");
		       
		      }
		      else
		      {
		       System.out.println("COMPANY INFO & JOB & QUALIFICATIONS & SKILLS ARE NOT DISPLAYED");
		       return;
		      }
		      ACT.moveToElement(OBJJOB).perform();
		     // CREATE WEBELEMENT OBJECTS 
		     /*
		      WebElement OBJJTTL=driver.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[1]/a/span"));//getText().equals("Job Titles");
		      WebElement OBJJSPC=driver.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[2]/a/span"));
		      WebElement OBJPAYG=driver.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[3]/a/span"));
		      WebElement OBJEMST=driver.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[4]/a/span"));
		      WebElement OBJEOJC=driver.findElement(By.xpath("//*[@id='admin']/ul/li[2]/ul/li[5]/a/span"));
		      
		      */
		      WebElement OBJJTTL=driver.findElement(By.linkText("Job Titles"));//getText().equals("Job Titles");
		      WebElement OBJJSPC=driver.findElement(By.linkText("Job Specifications"));
		      WebElement OBJPAYG=driver.findElement(By.linkText("Pay Grades"));
		      WebElement OBJEMST=driver.findElement(By.linkText("Employment Status"));
		      WebElement OBJEOJC=driver.findElement(By.linkText("EEO Job Categories"));
		      
		      
		      // VERIFY 
		      if(OBJJTTL.isDisplayed()&&OBJJSPC.isDisplayed()&&OBJPAYG.isDisplayed()&&OBJEMST.isDisplayed()&&OBJEOJC.isDisplayed())
		      {
		          System.out.println(" 'Job Titles,Job Specifications,Pay Grades,Employment Status,EEO Job Categories' IS DISPLAYED  ");
		      }
		      else
		      {
		          System.out.println(" 'Job Titles,Job Specifications,Pay Grades,Employment Status,EEO Job Categories' IS NOT DISPLAYED  ");
		      }
		      Thread.sleep(2000);
		      // click on job Specifications
		      ACT.moveToElement(OBJJSPC).click().perform(); 
		      
		      // WAIT FOR FRAME AND SWITCH TO IT
		      
		      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
		      Thread.sleep(2000);
		      //--------------VERIFY JOB AND JOB SPECIFICATIONS IS DISPLAYED OR NOT
		      
		      WebElement WEJJS=driver.findElement(By.cssSelector(".mainHeading>h2"));
		      if(WEJJS.getText().equals("Job : Job Specifications"))
		      {
		          System.out.println("Job : Job Specifications is displayed1");
		      }
		      else
		      {
		          System.out.println("Job : Job Specifications is not displayed");
		      }
		      
		      //     CREATE WEB ELEMENTS FOR INPUT FIELDS AND BUTTONS
		      
		                WebElement OBJSBY=driver.findElement(By.name("loc_code"));
		              WebElement OBJSFR=driver.findElement(By.name("loc_name"));
		              WebElement OBJSRH=driver.findElement(By.xpath("//input[@value='Search']"));
		              WebElement OBJRST=driver.findElement(By.xpath("//input[@value='Reset']"));
		              WebElement OBJADD=driver.findElement(By.xpath("//input[@value='Add']"));
		              WebElement OBJDLT=driver.findElement(By.xpath("//input[@value='Delete']"));
		              
		     //      VERIFY WEB ELEMENTS
		              if(OBJSBY.isDisplayed()&&OBJSFR.isDisplayed()&&OBJSRH.isDisplayed()&&OBJRST.isDisplayed()&&OBJADD.isDisplayed()&&OBJDLT.isDisplayed())
		              {
		                  System.out.println("SEARCH ,SEARCH FOR,SEARCH,RESET,ADD,DELETE BUTTONS ARE DISPLAYED");
		              }
		              else
		              {
		                  System.out.println("SEARCH ,SEARCH FOR,SEARCH,RESET,ADD,DELETE BUTTONS ARE NOT DISPLAYED");
		                    
		              }
		              
		    //         NOW CLICK ON ADD BUTTON
		              
		              OBJADD.click();
		              Thread.sleep(1000);
		              
		    //        CHECK and VERIFY JOB SPECIFICATION 
		              WebElement WEJJS1=driver.findElement(By.cssSelector(".mainHeading>h2"));
		              
		             if( WEJJS1.getText().equals("Job : Job Specifications"))
		             {
		                 System.out.println("Job : Job Specifications is displayed2");
		             }
		             else
		             {
		                 System.out.println("Job : Job Specifications is not displayed2");
		                    
		             }
		             
		    //      CREATE STRING AND ENTER DATA
		              String NAME="SOFTWARE1";
		              String DESCR="TEST ENGINERR AT QAPLANET";
		    //        CREATE WEB ELEMENT FOR NAME AND DESCRIPTION
		              WebElement OBJNAME=driver.findElement(By.name("txtFieldName"));
		              WebElement OBJDESCR=driver.findElement(By.name("txtDesc"));
		              WebElement OBJSAV=driver.findElement(By.id("editBtn"));
		              
		    //        VERIFY WEBELEMENTS NAME,DESCRIPTION,SAVE 
		              if(OBJNAME.isDisplayed()&&OBJDESCR.isDisplayed()&&OBJSAV.isDisplayed())
		                {
		                    System.out.println("NAME,DESCRIPTION AND SAVE BUTTON IS DISPLAYED");
		                }
		                else
		                {
		                    System.out.println("NAME,DESCRIPTION AND SAVE BUTTON IS NOT DISPLAYED");
		                    
		                }
		    //        CLICK ON SAVE
		                OBJSAV.click();
		    //        CREATE ALERT
		                Alert A=driver.switchTo().alert();
		   //        VERIFY ALERT
		                if(A.getText().equals("Please correct the following\n\n    - Please specify Job Specification name\n"))
		                {
		                    System.out.println("Please specify Job Specification name\n is Displayed");
		                }
		                else
		                {
		                    System.out.println("Please specify Job Specification name\n is Displayed");
		                }
		                A.accept();

		                Thread.sleep(1000);

		                //        TYPE DATA OR SEND DATA
		              OBJNAME.clear();
		              OBJNAME.sendKeys(NAME);
		              OBJDESCR.clear();
		              OBJDESCR.sendKeys(DESCR);
		   //        CLICK ON SAVE
		              OBJSAV.click();
		  /*
		     //           VERIFY ALERT 2
		                if(A.getText().equals("Please correct the following\n\n    - This name is in use\n"))
		                {
		                    System.out.println("- This name is in use\n is Displayed");
		                }
		                else
		                {
		                    System.out.println("PThis name is in use\n is not Displayed");
		                }
		                A.accept();     */
		              Thread.sleep(2000);

		    //        CHECK and VERIFY JOB SPECIFICATION 
		              
		              WebElement WEJJS2=driver.findElement(By.cssSelector(".mainHeading>h2"));
		              
		              
		              if( WEJJS2.getText().equals("Job : Job Specifications"))
		              {
		                  System.out.println("Job : Job Specifications is displayed2");
		              }
		              else
		              {
		                  System.out.println("Job : Job Specifications is not displayed2");
		                     
		              }

		   //        CHECK AND VERIFY SUCESSFULLY ADDED OR NOT
		              if(driver.findElement(By.xpath("//span[@class='success']")).getText().equals("Successfully Added"))
		              {
		                  System.out.println("Successfully Added is displayed");
		              }
		              else
		              {
		                  System.out.println("Successfully Added is not displayed");
		              
		                }
		   //        SELECT ROW COUNT
		              int rc=driver.findElements(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr")).size();
		              int i;
		              
		    //        LOOP 1
		              for(i=rc;i<=rc;i++)
		              {
		                  String NAME1=driver.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();
		   //        VERIFY           
		              if(NAME1.equals(NAME))
		                {
		                  System.out.println(NAME+" DISPLAYED AT: "+i);
		                }
		                 else
		                  {
		                  System.out.println(NAME+" IS NOT DISPLAYED");
		                  }
		              
		   //-----------------------EDIT JOB SPECIFICATION TEST CASE 13-------------------------
		              
		              driver.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
		               }
		              Thread.sleep(2000);
		              
		   //           CLICK ON EDIT BUTTON
		              driver.findElement(By.xpath("//*[@id='editBtn']")).click();
		              Thread.sleep(1000);
		              
		 //             CLEAR AND SEND DATA
		              String NAM1="SOFTWARE ENGINEER";          
		            WebElement WENAM1 = driver.findElement(By.name("txtFieldName"));
		              WENAM1.clear();
		              WENAM1.sendKeys(NAM1);
		  
		  //            CLICK ON SAVE
		              
		              driver.findElement(By.id("editBtn")).click();

		              Thread.sleep(2000);
		   //        CHECK and VERIFY JOB SPECIFICATION 
		                          
		              WebElement WEJJS3=driver.findElement(By.cssSelector(".mainHeading>h2"));
		                                      
		                          if( WEJJS3.getText().equals("Job : Job Specifications"))
		                          {
		                              System.out.println("Job : Job Specifications is displayed3");
		                          }
		                          else
		                          {
		                              System.out.println("Job : Job Specifications is not displayed3");
		                                 
		                          }
		                          Thread.sleep(1000);
		   //        CHECK AND VERIFY SUCESSFULLY ADDED OR NOT
		                          if(driver.findElement(By.xpath("//div[@class='messagebar']/span")).getText().equals("Successfully Updated"))
		                          {
		                              System.out.println("Successfully Updated is displayed");
		                          }
		                          else
		                          {
		                              System.out.println("Successfully Updated is not displayed");
		                          
		                            }
		                          Thread.sleep(1000);
		//-----------------------------------TEST CASE 14 DELETE JOB SPECIFICATION
		   //         LOOP 2
		                  int j;
		                  for( j=rc;j<=rc;j++)
		                    {
		                        String NAME2=driver.findElement(By.xpath("html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).getText();
		  //        VERIFY           
		                        if(NAME2.equals(NAM1))
		                           {
		                             System.out.println(NAM1+" DISPLAYED AT: "+j);
		                            }
		                           else
		                        {
		                          System.out.println(NAM1+" IS NOT DISPLAYED");
		                        }
		   //         CHECK BOX SELECT AND CLICK
		                        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[1]/input")).click(); 
		                          }
		    //        CLICK ON DELETE
		                  driver.findElement(By.xpath("//input[@value='Delete']")).click();
		    //      VERIFY AND ACCEPT ALERT
		                  if(A.getText().equals("Deletion might affect employee information. Do you want to delete ?"))
		                  {
		                      System.out.println("Deletion might affect employee information. Do you want to delete ? is DISPLAYED");
		                  }
		                  else
		                  {
		                      System.out.println("Deletion might affect employee information. Do you want to delete ? is NOT DISPLAYED");
		                  }
		                  A.accept();
		                  Thread.sleep(2000);
		    //       CHECK SUCESS FULLY DELETED OR NOT
		                 if(driver.findElement(By.cssSelector(".success")).getText().equals("Successfully Deleted"))
		                 {
		                     System.out.println("Successfully Deleted is Displayed at:" +j);
		                 }
		                 else
		                 {
		                     System.out.println("Deletion Failed or Successfully Deleted is not displayed");
		                 }
		              
		   //       SWITCH TO DEFAULT FRAME
		                 driver.switchTo().defaultContent();
		                 Thread.sleep(3000);
		   // REFRESH PAGE
		                
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
		     // CLOSE & QUIT THE BROWSER
		                driver.close();
		                driver.quit();
		                             
		              
		    } 
}

package GeneralLogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import GeneralBrowsers.Browser;
import GeneralLogin.Login;

public class Admin
{
	Browser browser;
	Login login = new Login(browser);
	//constructor 
	public  Admin(Browser br)
	{
		browser=br;
	}
	Properties locators = new Properties();
	File locFile= new File("D:\\subbu\\MY Project\\src\\ElementLocations\\adminClasspropertyFIle.properties");
	public void setup() throws FileNotFoundException, IOException
	{
		locators.load(new FileInputStream(locFile));
		
	}
	
	public void editLocation(String LocationName)
	{
		int n;
        String loction1=locators.getProperty("webElementids.length.loc");
        String location2=locators.getProperty("editLocation.jobElementText.loc");
        String location3=locators.getProperty("editLocation.clickableElement.loc");
        
        //System.out.println(location);
       int e= browser.WebElementIds("xpath", loction1).size();
        System.out.println(e);
        for(n=1;n<=e;n++)
        {
        	String StrJob=browser.WebElementId("xpath",location2).getText();
       	   System.out.println(StrJob);
       	if(StrJob.equals(LocationName))
   	      {
       			//System.out.println("check");
       			browser.click("xpath", location3);
   				break;
   		
   	       }
        	
        }
		
	}
	public void deleteLocationInTable(String LocName)
	{
		int n;
         //String identifier=locators.getProperty("webElementids.length.identifier");
         String location=locators.getProperty("webElementids.length.loc");
         
         System.out.println(location);
        int e= browser.WebElementIds("xpath", location).size();
         System.out.println(e);
         for(n=1;n<=e;n++)
         {
        	 String StrJob=browser.WebElementId("xpath", "html/body/div/div[2]/form/table/tbody/tr["+n+"]/td[3]/a").getText();
        	 System.out.println(StrJob);
        	 if(StrJob.equals(LocName))
        	 {
        		 System.out.println("check");
        		 browser.click("xpath", "html/body/div[1]/div[2]/form/table/tbody/tr["+n+"]/td[1]/input");
        		
        		 break;
        		
        	 }
         }
         browser.WebElementId("xpath", "html/body/div[1]/div[2]/form/div[3]/div[1]/input[2]").click();
         
	}
	public void addjob(String Jobname)
	{
		browser.startActions();
		browser.MoveTOElement("xpath", ".//*[@id='admin']/a/span");
	    browser.MoveTOElement("xpath", ".//*[@id='admin']/ul/li[2]/a/span");
	    browser.MoveTOElement("xpath", ".//*[@id='admin']/ul/li[2]/ul/li[1]/a/span");
	    browser.clickActions();
	    browser.waitforPageToload();
	    browser.SelectFrameById("rightMenu");
	    browser.click("xpath", "html/body/div/div[2]/form/div[3]/div[1]/input[1]");
	    browser.waitforPageToload();
	    browser.waitUntilElementTObePresent("html/body/div[2]/div[2]/div[2]/div/h2");
	    browser.SendKeys("id", "txtJobTitleName", Jobname);
	    browser.SendKeys("id", "txtJobTitleDesc", "Quality assurance is the job that will test the application");
	    browser.click("xpath", ".//*[@id='frmJobTitle']/div[2]/input[1]");
	    	        
		
	}
	public void editjob(String jobName)
	{
		browser.startActions();
		browser.MoveTOElement("xpath", ".//*[@id='admin']/a/span");
	    browser.MoveTOElement("xpath", ".//*[@id='admin']/ul/li[2]/a/span");
	    browser.MoveTOElement("xpath", ".//*[@id='admin']/ul/li[2]/ul/li[1]/a/span");
	    browser.clickActions();
	    browser.waitforPageToload();
	    browser.SelectFrameById("rightMenu");

		int n;
         
        int e= browser.WebElementIds("xpath", "html/body/div/div[2]/form/table/tbody/tr").size();
         System.out.println(e);
         for(n=1;n<=e;n++)
         {
        	 String StrJob=browser.WebElementId("xpath", "html/body/div/div[2]/form/table/tbody/tr["+n+"]/td[3]/a").getText();
        	 System.out.println(StrJob);
        	 if(StrJob.equals(jobName))
        	 {
        		 System.out.println("Webelment is located in location" + n);
        		 browser.click("xpath", "html/body/div/div[2]/form/table/tbody/tr["+n+"]/td[3]/a");
        		
        		 break;
        		
        	 }
         }
          browser.waitforPageToload();
          browser.click("id", "editBtn");
          browser.SendKeys("id", "txtJobTitleComments", "This is only the Quality assurance job related comments");
          browser.SelectItemFromDroopdrown("id", "cmbJobSpecId");
          browser.SelectItemFromDroopdrown("id", "cmbPayGrade");
          browser.click("id", "editBtn");
          
        
		
	}
	public void deleteJob(String jobTitle)
	{ 
		browser.startActions();
		browser.MoveTOElement("xpath", ".//*[@id='admin']/a/span");
	    browser.MoveTOElement("xpath", ".//*[@id='admin']/ul/li[2]/a/span");
	    browser.MoveTOElement("xpath", ".//*[@id='admin']/ul/li[2]/ul/li[1]/a/span");
	    browser.clickActions();
	    browser.waitforPageToload();
	    browser.SelectFrameById("rightMenu");
	    int n;
        
        int e= browser.WebElementIds("xpath", "html/body/div/div[2]/form/table/tbody/tr").size();
         System.out.println(e);
         for(n=1;n<=e;n++)
         {
        	 String StrJob=browser.WebElementId("xpath", "html/body/div/div[2]/form/table/tbody/tr["+n+"]/td[3]/a").getText();
        	 System.out.println(StrJob);
        	 if(StrJob.equals(jobTitle))
        	 {
        		 System.out.println("Webelment is located in location" + n);
        		 browser.click("xpath", "html/body/div[1]/div[2]/form/table/tbody/tr["+n+"]/td[1]/input");
        		
        		 break;
        		
        	 }
        	 
        	
         }
         browser.click("xpath", "html/body/div/div[2]/form/div[3]/div[1]/input[2]");
        
	
	}
	public void jobSpecifications()
	{
			String movetoElemnt1= locators.getProperty("addJobSpecification.movetoelement1.loc");
			String movetoElemnt2= locators.getProperty("addJobSpecification.movetoelement2.loc");
			String movetoElemnt3= locators.getProperty("addJobSpecification.movetoelement3.loc");
			String addbtn=locators.getProperty("addJobSpecification.addbtn.loc");
			String jobSpecheading=locators.getProperty("addJobSpecification.waitforJobSpectile.loc");
			browser.startActions();
			browser.MoveTOElement("xpath",movetoElemnt1 );
		    browser.MoveTOElement("xpath", movetoElemnt2);
		    browser.MoveTOElement("xpath", movetoElemnt3);
		    browser.clickActions();
		    browser.waitforPageToload();
		    browser.SelectFrameById("rightMenu");
		    browser.click("xpath", addbtn);
		    browser.waitforPageToload();
		    browser.waitUntilElementTObePresent(jobSpecheading);
		    browser.SendKeys("xpath", locators.getProperty("addJobSpecification.jobSpecName.loc"), locators.getProperty("addJobSpecification.jobSpecName"));
		    
	}
	
	
	
	
	
	
	
	
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

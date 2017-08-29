package ms_iopackagefiles_22Aug2017;

import java.io.File;




//import java.io.io Exceptions;


public class MS_IOpackage_22Aug2017
{

	public static void main(String[] args) throws Exception 
	{
		File x= new File("C:\\Users\\admin\\Desktop\\121.xls");
		
		if(! x.exists())
		{
			x.createNewFile();
		}
		
		if(x.exists());
		{
		   System.out.println("File Exists");		    
		}
		
        // To print absolut path
		
		System.out.println(x.getAbsolutePath());
		
        // To delete file
		
		 x.delete();	     
	
	}

	
		
}

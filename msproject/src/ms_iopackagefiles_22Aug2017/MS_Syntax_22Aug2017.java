package ms_iopackagefiles_22Aug2017;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class MS_Syntax_22Aug2017
{

	public static void main(String[] args) throws Exception 
	{
		// To read data from file
		
		FileInputStream x = new FileInputStream("C:\\Users\\admin\\Desktop\\12.txt");
		
		String t="qa";
		// Link two files
		
				
		// To write data into file
		
		FileOutputStream y = new FileOutputStream("C:\\Users\\admin\\Desktop\\13.txt");
		
		byte[] text=t.getBytes();
		
				y.write(text);
				

	}

}

package ms_working_excel_23Aug2017;

import java.io.File;

import jxl.Workbook;
import jxl.Sheet;

public class MS_RSrowdata_22Aug2017 
{	
	public static void main(String[] args) throws Exception
	
		/*
		Workbook.getWorkbook("File path")                  // To Land Excel File
		Workbook.getSheet("Sheet Name");                   // To Focus on particular sheet
		Sheet.getcell(column index, row index);            // To focus on cell
		Workbook.createworkbook(new file)("C:\\ path");    // To Create excel file
		Workbook.createsheet("HRM", 0);                    // To Create Sheet
		Workbook.addcell(new Label(0,0,"user name"));       // To Add cell
		Sheet.getrows();								   // To Get row count
		Sheet.getcolumn();                                 // To Get column count
		Sheet.getcell();                                   // To get cell  count		
		*/
		
	    {
		   // To take files as input, use file
		
		   File f1 = new File("C:\\Users\\admin\\Desktop\\Singal Row.xls");
		   
		   // Load workbook
		   
		   Workbook WB = Workbook.getWorkbook(f1);
		   
		   // Get specific sheet
		   
		   Sheet S1 = WB.getSheet("QAP 1");
		   
		   int i = 1;
		   
		   String gBrow = S1.getCell(0, i).getContents();
		   String gURL = S1.getCell(1, i).getContents();
		   String gUN   = S1.getCell(2, i).getContents();
		   String gPWD  = S1.getCell(3, i).getContents();
		   String gemail = S1.getCell(4, i).getContents();
		   
		   System.out.println(gBrow);
		   System.out.println(gURL);
		   System.out.println(gUN);
		   System.out.println(gPWD);
		   System.out.println(gemail);
		   
	    }	

}

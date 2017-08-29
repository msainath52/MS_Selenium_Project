package ms_working_excel_23Aug2017;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;

public class MS_Excel_Ex_01_23Aug2017
{

	public static void main(String[] args) throws Exception
	
	{
		File file = new File("C:\\Users\\admin\\Desktop\\qa test123.xls");
		Workbook objWB = Workbook.getWorkbook(file);
		Sheet S1 = objWB.getSheet(1); // 1 means second sheet as index starts from zero
		
		// Get new count
		
		int rows = S1.getRows();
		
		S1.getRows();
		S1.getColumns();
		
		for (int i=0; i<rows; i++)
		{
			String UN = S1.getCell(0,i).getContents();
			String PWD = S1.getCell(1,i).getContents();
			System.out.println(UN+" "+PWD);
		}
		

	}

}

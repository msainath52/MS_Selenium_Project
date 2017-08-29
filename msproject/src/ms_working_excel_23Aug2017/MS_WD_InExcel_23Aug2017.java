package ms_working_excel_23Aug2017;


import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class MS_WD_InExcel_23Aug2017 
{

	public static void main(String[] args) throws Exception
	{
		WritableWorkbook wwb = Workbook.createWorkbook(new File("C:\\Users\\admin\\Desktop\\Login_Results.xls"));
		WritableSheet ws = wwb.createSheet("HRM",0);
		WritableSheet ws1 = wwb.createSheet("RES",1);
		
		Label l = new Label(0,0,"username");
		Label l1 = new Label(1,0,"Password");
		Label r1 = new Label(0,1,"qaplanet1");
		Label r2 = new Label(1,1,"admin");
		ws.addCell(l);
		ws.addCell(l1);
		ws.addCell(r1);
		ws.addCell(r2);
		wwb.write();
		wwb.close();		

	}

}

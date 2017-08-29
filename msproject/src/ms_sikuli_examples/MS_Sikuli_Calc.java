package ms_sikuli_examples;


import org.sikuli.script.App;
import org.sikuli.script.Screen;

public class MS_Sikuli_Calc {

	public static void main(String[] args) throws Exception {
		
		
			App.open("calc.exe");
			Screen x = new Screen ();
			
			// Verify Calc window
			
			if (x.exists("D:\\msainath\\ms.sikuli\\window.png") !=null)
			{
				System.out.println("Calculation window displayed");
			}
			
			x.click("D:\\msainath\\ms.sikuli\\window.png");
			x.click("D:\\msainath\\ms.sikuli\\Five.png");
			x.click("D:\\msainath\\ms.sikuli\\Six.png");
			x.click("D:\\msainath\\ms.sikuli\\Mul.png");
			x.click("D:\\msainath\\ms.sikuli\\Five1.png");
			x.click("D:\\msainath\\ms.sikuli\\Equal.png");
			
			Thread.sleep(1000);
			
			App.close("calc.exe");
			
				
		

	}

}

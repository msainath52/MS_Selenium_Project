package ms_sikuli_examples;

import org.sikuli.script.App;
import org.sikuli.script.Screen;

public class MS_Sikuli_Flight {

	public static void main(String[] args) throws Exception {
	
		
		App.open("C:\\Program Files\\HP\\Unified Functional Testing\\samples\\flight\\app\\flight4a.exe");
		Screen x = new Screen();
		
		if(x.exists("D:\\msainath\\Flight.sikuli\\Login.png")!=null)
				{
					System.out.println("Flight windodw displayed");
				}
		
		x.click("D:\\msainath\\Flight.sikuli\\Login.png");
		
		x.type("D:\\msainath\\Flight.sikuli\\username.png","Sainath");
		
		x.type("D:\\msainath\\Flight.sikuli\\password.png","mercury");
		
		x.click("D:\\msainath\\Flight.sikuli\\ok.png");
		
		
		
		
		
	}	

}

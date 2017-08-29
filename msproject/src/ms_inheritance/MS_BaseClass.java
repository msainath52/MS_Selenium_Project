package ms_inheritance;

public class MS_BaseClass extends MS_SuperClass {

	public void method3()
	
	{		
		System.out.println("method3");
	}
	
	public static void main(String[]args)
	{
		MS_BaseClass x = new MS_BaseClass();
		x.method1();
		x.method2();
		x.method3();
	}

}

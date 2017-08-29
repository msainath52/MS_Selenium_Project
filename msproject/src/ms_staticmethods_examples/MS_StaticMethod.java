package ms_staticmethods_examples;



public class MS_StaticMethod {

	public static void method1() 
		
	{	
		System.out.println("Method1");
			
	}
	
	public static void method2(int a)
	
	{
		System.out.println(a);
		
	}
	
	public static boolean method3()
	{
		return true;
	}
	
	public static int method4(int a, int b)
	{
		return a+b;
			}
	
	public static void main(String []x)
	{
		method1();
		MS_StaticMethod.method2(10);
		boolean r = MS_StaticMethod.method3();
		System.out.println(r);
		int r1 = MS_StaticMethod.method4(10,20);
		System.out.println(r1);
	}
	
	
}

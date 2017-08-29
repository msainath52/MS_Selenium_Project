package ms_staticmethods_examples;


public class MS_OverLoadMethod {

	public void method1()
	{
		System.out.println("method1");

	}

	public void method1(int a)
	{
		System.out.println(a);
	}
	
	public void method(String a)
	{
		System.out.println(a);
	}
	
	public void method1(String a, String b)
	{
		System.out.println(a+b);
	}
	
	public void method1(int a, int b)
	
	{
		System.out.println(a+b);
	}
	
	public static void main(String []args)
	{
		MS_OverLoadMethod x = new MS_OverLoadMethod();
		x.method1("10","20");
	}
}

package mspackage;

public class mscontrolstructure {

	public static void main(String[] args) {
		
// Conditonal Staements
		
// If-else = For single condition	
		
		/*int x=10;
		  if (x%2==0)
		  {System.out.println("even");}
		  else
		  {System.out.println("odd");}*/
		
// If-else-if = To Compare more than one single condition		
		
		/*String x="A";
		  if (x=="A")
		  {System.out.println("Testing");}
		  else if (x=="B")
		  {System.out.println("Selenium");}
		  else if (x=="C")
		  {System.out.println("UFT");}
		  else
		  {System.out.println("Invalid Input");}*/
		
// Nested if = To apply one condition with another		
				
			 /*int x=10;
		          if (x<=10)
		          {if (x<=5)
		          {System.out.println("Less than or equal to 5");}
		          else
		          {System.out.println("Less than or equal to 10");}	           	 
		          }*/
		
// Switch Case = When there are more number of options.		
		
		String x="C";
		
		switch(x) 
		{
		
		case "A":
			
				System.out.println("Block A Code");
				
		        break;
		        
		case "B":
			
			    System.out.println("Block B Code");
			
		        break;
		     
		default:
			
			    System.out.println("Else Block");
			
		        break;
		}		
				
	}

}

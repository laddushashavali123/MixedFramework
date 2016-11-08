package us.st.selenium;

import java.util.ArrayList;
import java.util.List;

public class learningStaff {

	//Example of final non-access modifier
	
	public class TestFinal{
		
		//final Object somevar;    - give error
		final int value = 10;
		
		//The following are examples of declaring constants:
		
		public static final int BOXWIDTH = 6;
		
		static final String TITLE= "Manager";
		
		
		
		public void changeValue(){
			
			//value = 12; // give error
			//BOXWIDTH=7; // give error
		}
	
	/*
	 * 
	 * small example of usage final
	 * 
	 * 
	 * 
	 */
		
		class TestClass1 {
			
			  private final ArrayList<String> foo=null;

			  public void Test()
			  {
			      foo = new ArrayList();
			      foo.add("foo"); // Modification-1
			  }
		}
			
		class TestClass2{
				
			  public void method()
			  {
				  TestClass1 t = new TestClass1();
			      t.foo.add("bar"); // Modification-2
			      System.out.println("print - " + t.foo);
			  }
			}	
		
	
	}
	
	
}

package us.st.java_features;

import java.awt.List;
import java.util.AbstractList;

public final class ImmutableObject {

	private final int x;
	private final int y;

	ImmutableObject(int x, int y) {
	        this.x = x;
	        this.y = y;
	}
	
	ImmutableObject p = new ImmutableObject(5, 10);

	p.x = 50;
	// Compilation error: cannot assign a value to a final variable
	
	public static void main(String[] args){
		
		String first = "first";
		
		System.out.println(first.hashCode());
		// prints something

		first = first + "!";
		
		System.out.println(first.hashCode());
		// prints something different
		List p = new List();
		
	}
}
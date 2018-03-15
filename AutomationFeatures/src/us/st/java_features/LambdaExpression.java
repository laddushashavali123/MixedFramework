package us.st.java_features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



//this class could not be extended
public final class LambdaExpression{

	private static int sum=0;
/**
 * overriding functional interfaces.
 * 	
 *	@Runnable is a @FunctionalInterface	
*/
	Runnable r = new Runnable(){
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("How it was in Java 7");
		}
		
	};
	
	Runnable r2 = () ->{
	
			System.out.println("How it was in Java 7");
			
	};
	
	//Using for loop for iteration wia loop
	
/**
 * Count Sum of array
 * @sum - global variable
 * 
 */
	public static int CountSum(Integer[] arr){
		sum=0;
		List<Integer> nums = new ArrayList<Integer>(Arrays.asList(arr));
		
		nums.stream().forEach((el) ->{
			sum= sum+ el;
		});
		
		
		return sum;
	}
	
	/**
	 * Count Sum of array
	 * @param AtamicInteger
	 * 
	 */
	public static int CountSum(List<Integer> arr){
		AtomicInteger sum=new AtomicInteger();
		
		arr.stream().forEach((el) ->{
			sum.addAndGet(el);
		});
		
		return sum.intValue();
	}
	
	
	
	public static void main(String[] args){
		System.out.println(CountSum(new Integer[]{1,2,3,4,5,6,7,9,10,11,12}));
		System.out.println(CountSum(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,9,10,11,12})));
	}
	

}

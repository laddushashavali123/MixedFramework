package us.st.tasks;

import java.util.Scanner;

public class HackerRankCalculator {
	
	
	



	    public static void main(String[] args) throws Exception {
	    	
	    	Scanner sc= new Scanner(System.in);
	    	int n;
	    	int p;
	    	 while(sc.hasNext()){
	    		 
	    		 String input = sc.nextLine();
	    		 n=Integer.parseInt(input.split(" ")[0]);
	    		 p=Integer.parseInt(input.split(" ")[1]);
	    		 System.out.println(MyCalculator.power(n,p));
	    	 }
	        // Write your code here



	    }
	
	
	
	static class MyCalculator {

	    static int power(int n, int p) throws Exception {



	        if(n < 0 || p < 0) {



	            throw new Exception("n and p should be non-negative");



	        }


	        return (p == 0) ? 1 : n*power(n,p-1);



	    }


	}

}

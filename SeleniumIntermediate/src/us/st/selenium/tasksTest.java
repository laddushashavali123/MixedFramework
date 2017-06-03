package us.st.selenium;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;



public class tasksTest {

	@Test
	public void test() {
		//int[] B = {1,2,5,7,2,3,5};
		//int[] test={1,2,3,4,4,5,6,7,9,10,11,12};
		System.out.println("=======================");
		System.out.println(parseString("Some31203-12:{#()@() text"));
		System.out.println("=======================");
		System.out.println(findPositions("b"));
		System.out.println("=======================");
		//function #1
		//System.out.println(parseString("work #@#$ bike bannana fun, perl, ##!()**ruby, function"));
		//function #2 - return unique values
		//System.out.println(parseUniqueValues("perl,python,ruby,java,go,erlang,perl,python,java,java"));
		//System.out.println(findWrongElements(test));
		//System.out.println(Solution.solution(5, B));
		//function #6 - return unique values
		//String s = "Prrrmogrrammming";
		//findDublicatedValues(s);
		//System.out.println(findPositions("ab"));
		//System.out.println(findStringOcurance(s,'m'));
		//System.out.println(Arrays.toString(removeDublicate(Arrays.asList("xyz", "abc", "xyz", "abc", "xyz")).toArray()));
		
		System.out.println(countDuplicatess(new int[]{1,3,1,3,3,6,3,2}));
		System.out.println("=======================");
		System.out.println(Arrays.toString(checkBraces(new String[] {"[]{}()","[({})]","{}[()]","][{}((","][}}(("})));
		
		//s= new String ("056");
		//int value = Integer.valueOf(s);
		
		//System.out.println(value);
		
	}
	
	//function #1 first implementation
	public String returnWord(String input){
		List <String> restrictedPatterns = (List<String>) Arrays.asList("#","@","$","!","(",")","*","^");
		for(String i:restrictedPatterns){
				input = input.replace(i, "");
		}
		return input;
	}
	
	//function #1 second implementation
	public String parseString(String input){
		ArrayList<String> inputList=new ArrayList<String>();
		int index =0;
		while (index<input.length()){
			inputList.add(input.substring(index, Math.min(input.length(), index + 1)));
			index+=1;
		}
				
			for (String i:inputList){
				
				if(!i.matches("[a-zA-Z ]")){
					input = input.replace(i, "");
					
			}
			}
			
		return input;
	}	
	
	//function #2 - return unique values
	public ArrayList<String> parseUniqueValues(String input){
		
		ArrayList result = new ArrayList<String>();
		String[] inputList = input.split(",");
		Map<String, Integer> items = new HashMap<String, Integer>(); 
		for (int i = 0; i<inputList.length; i++){
			if (!items.containsKey(inputList[i])){
			items.put(inputList[i], 1);
			} else {
				int oldvalue=(int) items.get(inputList[i]);
				
				items.replace(inputList[i], items.get(inputList[i]), oldvalue+1);
			}
		}
		for (String key:items.keySet()){
			result.add(key+":"+items.get(key)); 
		}
		System.out.println(result.size());
		return result;
		
	}
	
	
	
	/* 
	 * function #3 - write class to test api end points:
	 *  api/users - [{"user_id":1, "user_name":"Luis"},{"user_id":2, "user_name":"mike"}]
	 * 	api/users/1 - [{"user_id":1, "user_name":"Luis"},{"user_id":2, "user_name":"mike"}]
	 */
	
	// function #4 - write function to get max value in array
	
	public int getMax(List <Integer> arr){
		int result= arr.get(0);
		for (int i=0; i<arr.size();i++){
			if (arr.get(i)>result){
				result=arr.get(i);
			}
		}
		
		return result;
		
	}
	
	//function #5 to output wrong elements in array in the way described below:
	/**
	[1,2,3,4,4,5,6,7,9,10,11,12]
			 * 4,8 - output, duplicates and wrong index
	*/
	 public List findWrongElements(int[] someList){
		    List <Integer> result = new <Integer> ArrayList();
		    for (int i=1; i<someList.length; i++){
		         if(someList[i]!=someList[i-1]+1){
		            result.add(i);
		          }
		    }
			return result;
		    }
	 
	//function #6 look up in String for Sting pattern and output found positions as array:
	/**
		*	"abcfabretyab" - our String
		* 	"ab" - string-pattern we are looking for
	*/
	public List findPositions(String pattern){
		
		String string="abcfabretyab";
		List <Integer> result = new <Integer> ArrayList();
		
		int index =0;
		while (index<string.length()){
			
			if (string.indexOf(pattern, index)!=-1){
				
				result.add(string.indexOf(pattern, index));
				
				if (index!=0){
					index=string.indexOf(pattern, index);
					System.out.println("Now index: "+index);
				}
				
			} else{
				
				System.out.println(index);
				System.out.println(string.indexOf(pattern, index));
			}
			index++;
		
		}
			    
		return result;
	}
	
	//method #7 look up in String for duplicated values,  print them and their count
	/*
	 *  "Programming"
	 *  r: 2
	 *  g: 2
	 *  m: 2
	 */
	
	public void findDublicatedValues(String s){
		
		HashMap<Character, Integer> dublicates = new HashMap<Character, Integer>();
		for (int i=0; i<s.length(); i++){
			 
			if(dublicates.containsKey(s.charAt(i))){
				
				continue;
				
			}
			for (int j=i+1; j<s.length(); j++){
					
				if (s.charAt(i)==s.charAt(j)){
						
					if(!dublicates.containsKey(s.charAt(j))){
						
						dublicates.put(s.charAt(j), 2);
					
					} else {
						
						dublicates.put(s.charAt(j), dublicates.get(s.charAt(j))+1);
						
					}
				
				}
	
			}
		}

			for (Character item : dublicates.keySet()){
				
				System.out.println(item + ": "+dublicates.get(item));
				
			}
			
		
	}
	
	//method #8 find Occurrence in the String and output count of this occurrence
		/*
		 *  "Java"
		 *  output: 2
		 */
	public Integer findStringOcurance (String str, char ch){
		
		int count = 0;
		for (int i=0; i<str.length(); i++){
		
			if (str.charAt(i)==ch){
				
				count++;
			}
		
		}
		return count;
	}
	
	public static int countDuplicates(int[] numbers) {
		return 0;


    }
	//method #9 remove duplicates from given list
			/*
			 *  "xyz", "abc", "xyz", "abc", "xyz"
			 *  "xyz", "abc"
			 */
	public ArrayList<String> removeDublicate (List<String> data){
			
			ArrayList <String> result= new ArrayList<String>();
			
			for (String str:data){
				
				if (!result.contains(str)){
					result.add(str);
				}
			}
			
			return result;
	}
	
	
	public static int countDuplicatess(int[] numbers) {
	    
	    int countDub=0;
	    Set foundNum= new HashSet<Integer>();
	    
	    for (int i=0; i<numbers.length;i++){
	       
	    	if(foundNum.contains(numbers[i])){
	    		
	    		continue;
	    
	    	}
	    	
	       for (int j=i+1; j<numbers.length;j++){
	           
	           if (numbers[i]==numbers[j]){
	               
	               countDub+=1;
	               foundNum.add(numbers[i]);
	               break;
	           }
	           
	       }    
	    }
	    
	    return countDub;

	}
	
	
	//method #10 multiply elements in array and put result on position of element
	/*	
	 *  i/p: [2,4,3,5]
	 *  o/p: [60,30,40,24]
	 *  60 = 4 * 3 * 5
	 */
	
			public int[] changeArray(int[] input){
			    int[] result=new int[input.length];
			    for (int i=0;i<input.length;i++){
			        
			        int tmp=0;
			        for (int j=0;j<input.length;j++){
			            if (j==i){
			                continue;
			            }
			            tmp*=input[j];
			            
			        }
			        result[i]=tmp;
			    }
			        
			    return result;
			       
			}
		
			
		//method #11 check braces in String array
		/*	
		 *  i/p: {"[]{}()","[({})]","{}[()]","][{}((","][}}(("})
		 *  o/p: [Yes, Yes, Yes, No, No]
		 */
		public static String[] checkBraces(String[] values) {

		        String[] result = new String[values.length];
		        
		        for (int i=0;i<values.length;i++){
		        	
		        	System.out.println(values[i]);
		        	if(values[i].matches(".*\\{.*\\}.*") && values[i].matches(".*\\[.*\\].*") 
		        			&& values[i].matches(".*\\(.*\\).*")){
		        		
		        		result[i]= new String("Yes");
		        		
		        	} else{
		        		
		        		result[i]=new String("No");
		        	
		        	}
		        }
				return result;
		}
		
		public static boolean[] isBalanced(String values) {
			
			String [] input = new String[values.split(",").length];
			input=	values.split(",");
			boolean[] result = new boolean[input.length];
			        
			 for (int i=0;i<input.length;i++){
			        	
			        	
			        	if((input[i].matches(".*\\{.*\\}.*") && input[i].matches(".*\\[.*\\].*") 
			        			&& input[i].matches(".*\\(.*\\).*"))||input[i].length()==0){
			        		
			        		result[i]= true;
			        		
			        	} else{
			        		
			        		result[i]=false;
			        	
			        	}
			        }
		        
		        return result;
		}
		public static boolean isMatch(String IP) {
			
			String pattern = "[0-9]|1[0-9][0-9]|2[0-5][0-5]";
			String[] digits= new String[IP.split("\\.").length];
			digits=IP.split("\\.");
			if (digits.length==4){
				
				for (int i=0;i<4;i++){ 
					if (digits[i].matches(pattern)){
						
						if(i==3){
							return true;
						}
					} else{
						break;
						
					}
				}
				return false;
			} else {
				
				return false;
			}
		
			
		}
		
		
		
		
		
		
		public static void main(String[] args) {

	        BufferedReader br = null;

	        try {

	            br = new BufferedReader(new InputStreamReader(System.in));

	            while (true) {

	                System.out.print("Enter IP : ");
	                String input = br.readLine();

	                if ("q".equals(input)) {
	                    System.out.println("Exit!");
	                    System.exit(0);
	                }
	                
	                	System.out.println("result : " + isMatch(input));
	                	System.out.println("-----------\n");
	                	
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	    }       
		
	
		public static String[] checkBraces2(String[] values){
			
			String[] result = new String[values.length];
			/* 
			*	Solve task using removal brackets
			*
			/*
			
			/*
        	switch(values[i].charAt(0)){
        	
        	case '(' :
        		if (values[i].charAt(1)==')'||values[i].charAt(1)=='[' || values[i].charAt(1)=='{'){
        			
        			
        		} else 
        			
        		//String [] strArr  = values[i].split("(?!^)");
        		break;
        	case '[' :
        		
        		break;
        		
        	case '{' :
        		
        		
        		break;	
        	default :
        		
        		result[i]="NO";
        	}		
        	*/	
        	
        	
        	//if (strArr[i].startsWith("(") || strArr[i].startsWith("(")){
        			
        			
        			
        		//}
        		
        	
        	//} else {
        		
        	//	result[i]="NO";
        	//}
			
			
        	
      
        
			
			/*
        	switch(values[i].charAt(0)){
        	
        	case '(' :
        		if (values[i].charAt(1)==')'||values[i].charAt(1)=='[' || values[i].charAt(1)=='{'){
        			
        			
        		} else 
        			
        		//String [] strArr  = values[i].split("(?!^)");
        		break;
        	case '[' :
        		
        		break;
        		
        	case '{' :
        		
        		
        		break;	
        	default :
        		
        		result[i]="NO";
        	}		
        	*/	
        	
        	
        	//if (strArr[i].startsWith("(") || strArr[i].startsWith("(")){
        			
        			
        			
        		//}
        		
        	
        	//} else {
        		
        	//	result[i]="NO";
        	//}
        	
        //}
		return result;
	}
		        
		        
			
	
	//method #11 find Occurrence in the String and output count of this occurrence
			/*
			 *  "Java"
			 *  output: 2
			 */
	public int[] findGridSize(int n){
	    int result[] = new int[2]; 
				if (Math.sqrt(n) % 1 == 0){
					
					for (int i=0; i<2;i++){
						
						result[i]=(int) Math.sqrt(n);
						
					}
					
					return result;
				}else {
					
				    int x = (int) Math.floor(Math.sqrt(n));
				    int y=x;
				    for (int j=0; j<x;j++){
				        for (int i=1; i<x;i++)
				        if((x-j)*(y+i)==n || (x-j)*(y+i)==n+1 || (x-j)*(y+i)==n+2){
				            	
				            result[0]=x-j;
				            result[1]=y+i;
		                   return result;
		                    		            
				        }else if ((x-j)*(y+i)>n+2){
				            
		                    break;
				        }
				        
				        
				    }
					
				}
				return null;
	    
	    
	    }
	
	
	
	
/*	
	class Solution {
	    public int solution(int[] A) {
	        int result= -1;
	        List<Integer> indexes = new ArrayList<Integer>();
	        int tmpl= 0;
	        int tmpr= 0;
	        
	        if (!((A.length==1)&&(A.length==0))){
	        	//for (int P=0; P<=A.length-1; P++)
	            for (int i=0; i<A.length-1; i++){
	            	for(int j=0; j<i; j++){
	                tmpl=+A[j];
	                tmpr=+A[A.length-1-j];
	                }
	            tmpl=+A[i];
	            
	            if (tmpl==tmpr){
	            	indexes.add(i);
	            }
	            }
	            
	            int rnd = new Random().nextInt(indexes.size());
	            result = indexes.get(rnd);
	            }
	        return result;
	    }
*/
	
	class Solution {
		// function #5 - split array in the right way
		public int solution(int X, int[] A) {
	        int K = 0;
	        int amount = 0;
	        //int[] B = {5,5,1,7,2,3,5};
	        if (!((A.length==1))){
	        	
	            for (int i=0; i<A.length; i++){
	            	
	            	if (A[i]==X){
	            		for (int j=i+1; j<A.length;j++){
	            		if(!(A[j]==X)){
	            			amount = j-i;
	            			for (int k=A.length-1; k>=i+amount; k--){
		            			if (A[k]==X){
		    	            		continue;
		            		}
		            			for (int e=k; e>=i+amount;e--){
		    	            		if(A[e]==X){
		    	            			break;
		    	            		}
		    	            		if(k-e==amount){
		    	            		System.out.println("Solution found!");
		    	            		K = e+1;
		    	            		}
		    	            		}
		            			break;
		            		}
	            			break;
	            		}
	            		}
	            		break;
	            		
	            		
	            		}
	            	}
	        }
	        return K;
		}
	}
}
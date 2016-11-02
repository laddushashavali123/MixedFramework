package us.st.selenium;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;



public class tasksTest {

	@Test
	public void test() {
		int[] B = {1,2,5,7,2,3,5};
		int[] test={1,2,3,4,4,5,6,7,9,10,11,12};
		//function #1
		//System.out.println(parseString("work #@#$ bike bannana fun, perl, ##!()**ruby, function"));
		//function #2 - return unique values
		//System.out.println(parseUniqueValues("perl,python,ruby,java,go,erlang,perl,python,java,java"));
		//System.out.println(findWrongElements(test));
		//System.out.println(Solution.solution(5, B));
		//function #6 - return unique values
		String s = "Prrrmogrrammming";
		findDublicatedValues(s);
		System.out.println(findPositions("ab"));
		System.out.println(findStringOcurance(s,'m'));
		
		s= new String ("056");
		int value = Integer.valueOf(s);
		
		System.out.println(value);
		
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
				
				}
			}
			index+=1;
		
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
	            	

	
		

	
	
	

	


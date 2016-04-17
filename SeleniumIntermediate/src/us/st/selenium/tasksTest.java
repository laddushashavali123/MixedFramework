package us.st.selenium;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;



public class tasksTest {

	@Test
	public void test() {
		//function #1
		System.out.println(parseString("work #@#$ bike bannana fun, perl, ##!()**ruby, function"));
		//function #2 - return unique values
		System.out.println(parseUniqueValues("perl,python,ruby,java,go,erlang,perl,python,java,java"));
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
	
	
	
	/* function #3 - write class to test api end points:
	 *  api/users - [{"user_id":1, "user_name":"Luis"},{"user_id":2, "user_name":"mike"}]
	 * 	api/users/1 - [{"user_id":1, "user_name":"Luis"},{"user_id":2, "user_name":"mike"}]
	 */
	
	
		

	
	
	
}
	


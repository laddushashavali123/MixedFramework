package us.st.tasks;



import java.util.HashMap;
import java.util.Map;

public class TasksTest2 {
	
	
	Map<String, Integer> globMap = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		//outPutCharOcur("Hello");
		System.out.println(reverseString("Hello World"));
	}
	
	public static void outPutCharOcur(String input){
		
		Map <Character, Integer> map =new HashMap <Character, Integer>();
		//int ocur=0;
		char[] chars = input.toCharArray();
		for (int i=0; i<chars.length; i++){
			
			if(!map.containsKey(chars[i])){
				
				map.put(chars[i], 1);
			} else{
				
				int ocur = map.get(chars[i]);
				map.replace(chars[i], ocur+1);
			}
	
		}
		for (Character key: map.keySet()){
			
			System.out.println(key+" : "+map.get(key));
		}
		
		
	}
	
	public static String reverseString(String input){
		
		String result="";
		char[] chars = input.toCharArray();
		
		for (int i=input.length()-1;i>=0;i--){
			 
			result+=chars[i];
			
		}
		
		
		return result;
		
		
		
		
	}

	public void appendMap (String line, HashMap<String, Integer> map){
		
		String[] words= line.split(" ");
		
		StringBuffer b= new StringBuffer("");
		for (int i=0; i< words.length; i++){
			if (map.containsKey(words[i])){
				
				int value = map.get(words[i]);
				map.replace(words[i], value+1);
				
			}else{
				
				map.put(words[i], 1);
				
			}
		}
		//for (String key:)
		//return (HashMap<String, Integer>) globMap; 
		
	}

}



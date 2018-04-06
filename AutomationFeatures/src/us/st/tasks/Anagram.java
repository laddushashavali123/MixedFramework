package us.st.tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public class Anagram {
	 public static void main(String[] args) {
		 System.out.print(isAnogram("I am Lord Voldemort", "Tom Marvolo Riddle"));
		 System.out.print(isAnogramMap("Harry", "Potter"));
	 }
		  
	 public static boolean isAnogram(String str1, String str2){
		    str1=str1.toLowerCase().replace(" ","");
		    str2=str2.toLowerCase().replace(" ","");
		    if(str1.length()!=str2.length()){
		        return false;
		    }
		    char[] charArr1 = str1.toCharArray();
		    char[] charArr2 = str2.toCharArray();
		    for(int i=0;i<charArr1.length;){
		        for(int j=i;j<charArr2.length;){
		            if(charArr1[i]==charArr2[j]){
		              //remove char[i]from charArr1
		              charArr1= ArrayUtils.removeElement(charArr1, charArr1[i]);
		              //remove char[j]from charArr2
		              charArr2= ArrayUtils.removeElement(charArr2, charArr2[j]);
		              System.out.println("=========================");
		              System.out.println(Arrays.toString(charArr2));
		              System.out.println(Arrays.toString(charArr1));
		              System.out.println("=========================");
		              break;
		            }
		            if(charArr1[i]!=charArr2[j] && j==charArr2.length-1){
		              return false;
		            }
		            j++;
		        }
		    }
		    if(charArr1.length!=0 || charArr2.length!=0){
		    	System.out.println("Hello");
		          return false;    
		    }
		    return true;
		  }
	 public static boolean isAnogramMap(String str1, String str2){
		    str1=str1.toLowerCase().replace(" ","");
		    str2=str2.toLowerCase().replace(" ","");
		    if(str1.length()!=str2.length()){
		        return false;
		    }
		    char[] charArr1 = str1.toCharArray();
		    char[] charArr2 = str2.toCharArray();
		    Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		    
		    for(int i=0;i<charArr1.length;i++){
		    	if(charMap.containsKey(charArr1[i])){
		    		int value=charMap.get(charArr1[i]);
		    		charMap.replace(charArr1[i], value,++value);
		    		continue;
		    	}
		    	charMap.put(charArr1[i], 1);
		    }
		    for(int i=0;i<charArr2.length;i++){
		    	if(charMap.containsKey(charArr1[i])){
		    		int value=charMap.get(charArr1[i]);
		    		if(value==1){
		    			charMap.remove(charArr1[i]);
		    		}
		    		charMap.replace(charArr1[i], value,--value);
		    	}else{
		    		return false;
		    	}
		    }
		    if(charMap.isEmpty()){
		    	return true;
		    }
		    return false;
	 }
}


//Given two strings, return whether the strings are anagrams of one another: ‘I am Lord Voldemort’ = ‘Tom Marvolo Riddle’,  ‘Harry’ != ‘Potter’
//abba = baba
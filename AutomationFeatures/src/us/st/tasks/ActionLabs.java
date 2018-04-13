package us.st.tasks;

import org.apache.commons.lang3.ArrayUtils;

public class ActionLabs {

	public static void main(String[] args) {
		// abc bcd
		removeSameCharacters("abbcd","ebcdd");
	}
	
	//this solution works with duplicates of character in input str
	//input str should be equal in length
	public static void removeSameCharacters(String str1, String str2){
		
		str1=str1.toLowerCase().replace(" ","");
	    str2=str2.toLowerCase().replace(" ","");
	    if(str1.length()!=str2.length()){
	        return;
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
	              break;
	            }
	            if(charArr1[i]!=charArr2[j] && j==charArr2.length-1){
	              i++;
	            }
	            j++;
	        }
	    }
	    System.out.println(String.valueOf(charArr1));
	    System.out.println(String.valueOf(charArr2));
	   
	}

}

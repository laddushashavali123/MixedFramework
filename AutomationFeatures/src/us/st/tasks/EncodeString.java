package us.st.tasks;

import java.util.Scanner;

public class EncodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
        System.out.println(EncodeStr("aabbbbbCCCCCCbbb88888888888888zxa6x"));
	}
	public static String EncodeStr(String str){
		if(str.length()<4){
		return str;
		}
		    char[] strArr=str.toCharArray();
		    int count=0;
		    StringBuilder result = new StringBuilder("");
		    String temp="";
		  
		    for(int i=0;i<strArr.length;i++){
		        	
		    	for(int j=i+1;j<strArr.length;j++){
			        if(strArr[i]==strArr[j]){
			        	temp=temp+strArr[i];
			        	count++;
			            System.out.println(count);
			            continue;
			        }else{
			        	if(count>0 && count<3){
			        		result.append(temp);
			        		i=j;
			        		break;
			        	}
			        	result.append(count+"x"+strArr[i]);
			        	i=j;
			        	break;
			        }
		    	}
		    }
		return result.toString();
		
}
	}

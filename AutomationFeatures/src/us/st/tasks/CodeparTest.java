package us.st.tasks;

public class CodeparTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverse(String inputStr) throws InvalidInputStringException {

	    if(inputStr==null || inputStr.length()<2){
	        throw new InvalidInputStringException ("Input string is not correct");
	    }
	    
	    StringBuffer strB= new StringBuffer(inputStr);
	    
	    return strB.reverse().toString();

	}

}

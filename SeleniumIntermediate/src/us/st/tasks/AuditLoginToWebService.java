package us.st.tasks;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class AuditLoginToWebService {

	/*
	 * ABC Corp has a popular rest API that is used by millions of customers. 
	 * ABC Corp has a change requirement to audit every login to this API.  
	 * To facilitate this, a method writeAuditLog has been implemented. 
	 * This method takes two parameters, a log message, and a user id. 
	 * The log message should be of the format "Login success at <iso_date_timestamp>".
	 * 
	 * This audit feature has to be implemented without impacting the response time of the existing api. 
	 * The writes to the audit database take between 1 and 500 milliseconds.
	 * Your task is to implement the auditLogin method with minimal impact to the existing response time of the API.
	 */
	
		    static final Random rand = new Random();	
		    static final AtomicInteger written = new AtomicInteger();
		    static long sleepCount = 0L;
		    // if you need class level variables, add them before the auditLogin method
		
		    public static void auditLogin(String loginId) {
		    	// use the method writeAuditLog(String logMessage, String userId)
		    	// the log message should be "Login success at <iso_date_timestamp>".
	
		    }
	
		    private static void waitForWrites(){
		        // this method will be called to make sure all writes 
		        // are complete before shutdown.
		        // the time taken to execute this method will not be considered during evaluation
		    }
		    
		    public static void main(String[] args) throws IOException {
		    	
		    }

		    public static void writeAuditLog(String logMessage, String userId){
		
		    	try{
		
		    		if(rand.nextInt(1) == 0){
		
		    			int paws = rand.nextInt(500) + 1;
		    			sleepCount += paws;
		
		                System.out.println("sleeping for " + paws);
		                Thread.sleep(paws);
		            }
		        }catch(Exception e){}
		
		    		written.incrementAndGet();
		    		System.out.println("Logged in: " + userId);
		    		System.out.println("  message: " + logMessage);
		    }

}

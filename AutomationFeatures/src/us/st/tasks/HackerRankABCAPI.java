package us.st.tasks;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

public class HackerRankABCAPI {
	
	static final Random rand = new Random();
	static final AtomicInteger written = new AtomicInteger();
	static long sleepCount = 0L;
	private static TimeZone zone =TimeZone.getTimeZone("America/New_York");
	private static SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}
	
	// if you need class level variables, add them before the auditLogin method

	    public static void auditLogin(String loginId) {
	    
	    	ft.setTimeZone(zone);
			
	        // use the method writeAuditLog(String logMessage, String userId)
	    	writeAuditLog("Login success at <"+ft.format(new Date())+">",loginId);
	        // the log message should be "Login success at <iso_date_timestamp>".
	
	    }
	

	    private static void waitForWrites(){
	        // this method will be called to make sure all writes 
	        // are complete before shutdown.
	        //
	        // the time taken to execute this method will not be considered during evaluation
	    	while(written.get()!=50){
	    		try {
		    		 int paws = rand.nextInt(500) + 1;
		             sleepCount += paws;
		             System.out.println("sleeping for " + paws);
					 Thread.sleep(paws);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	
	    }
	    
	    public static void writeAuditLog(String logMessage, String userId){

	        try{
	        	//randomly generate 0 or 1
	            if(rand.nextInt(1) == 0){
	            	//0-500 +1
	                int paws = rand.nextInt(500) + 1;
	                sleepCount += paws;
	                System.out.println("sleeping for " + paws);
	                Thread.sleep(paws);
	            }
	        }catch(Exception e){
	        	
	        }
	        written.incrementAndGet();
	        System.out.println("Logged in: " + userId);
	        System.out.println("  message: " + logMessage);
	    }
	
	
}

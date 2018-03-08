package us.st.appium;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;


/**

There is a file containing a word and its possible meanings (like a Dictionary). The contents of the file look like this:

Apple – a fruit, a tech firm
Table – an object, contains rows and columns when used in context of computers
Orange – a fruit

Given a path to the file do the following:

a)	Create a method called doesFileExist(String path) which takes the path of the file and tells the user if the file exists at that path or not. Assume all paths are relative to your project structure. If the file does not exist, catch the requisite exception.
b)	Read each word and its possible meanings and print them out. Your output should look like this:

Word1
Meaning 1
Meaning 2
Word2
Meaning1
Meaning2

Use appropriate data structures wherever necessary.

*/


public class FileTest {
	private final static String filename="resources/File";
	
	@Test
	public void testFile(){
		
		File f;
		try {
			
			if(!isFileExist(filename)){
				Assert.fail("File '"+filename+"' is not exist in a System");
			}
			f= new File(filename);
			FileReader fileReader = new FileReader(f);
			BufferedReader br = new BufferedReader(fileReader);
			String line;
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				System.out.println("=========================");
				if(line.contains(" - ")){
					String word = line.split(" - ")[0].trim();
					//get meaning(s)
					String s = line.split(" - ")[1].trim();
					
					System.out.println(word);
					//output meaning if multiple
					if(s.contains(", ")){
						Set<String> meanings = new HashSet<String>();
						//lets assume meanings are separated by ', ' + we do not want have duplicates
						meanings.addAll(Arrays.asList(s.split(", ")));
					
						for (String meaning: meanings){
							System.out.println(meaning);
						}
					} else{
						System.out.println(s);
					}
				}		
				
			}
			fileReader.close();	
			
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException s) {
			System.out.println(s.getMessage());
			s.printStackTrace();
		}
		
   }
	
	public boolean isFileExist(String path) throws FileNotFoundException{
		
		File file = new File(path);
		if(file.isFile() && file.exists()){
				
				return true;
			} else {
				return false;
			}
		
	}
}

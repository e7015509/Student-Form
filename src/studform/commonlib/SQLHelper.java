package studform.commonlib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SQLHelper {
	public static String loadResourceToString(final String path) throws IOException{
		File file = new File(path); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String query = null;
		  String st = null ;
		  
		  while ((st = br.readLine()) != null) 
		  {
			  query = st;
		    System.out.println(st); 
		  }
	  return query;
	}
}


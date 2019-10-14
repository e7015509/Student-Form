package studform.commonlib;

import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class DataBroker {
	
		 public String[] ReadData() {
			  
			 	String browser= null;
			 	String A65formURL = null;
			 	String expStudentidlbl = null;
			 	String sqlQuery = null;
			
				String CSV_PATH = "C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\TestData\\StudFormTestdata.csv";
				
				try {
					  CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
					  String [] csvCell;
					  			  				  
					  	//Retrieving data from a CSV file.
					   csvCell = reader.readNext();	   
					   csvCell = reader.readNext();
					   browser = csvCell[0];
					   A65formURL = csvCell[1];
					   expStudentidlbl = csvCell[2];
					   sqlQuery = csvCell[3];
					   
		   
						//Printing retrieved data
					   System.out.println(browser);
					   System.out.println(A65formURL);
					   System.out.println(expStudentidlbl);
					   		  

					   reader.close();
					   
				} catch (IOException e) {
			           e.printStackTrace();
			       }
				
				String [] RetrivedData = {browser,A65formURL,expStudentidlbl};
				return RetrivedData;	
		  }
	}

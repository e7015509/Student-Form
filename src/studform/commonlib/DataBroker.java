package studform.commonlib;

import java.io.FileReader;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;

public class DataBroker {
	
		 public String[] ReadData() {
			  
			 	String browser= null;
			 	String myvutest = null;
			 	String username = null;
			 	String password =null;
			 	String unitcode1 = null;
			
				String CSV_PATH = "C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\TestData\\StudFormTestdata.csv";
				
				try {
					  CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
					  String [] csvCell;
					  			  				  
					  	//Retrieving data from a CSV file.
					   csvCell = reader.readNext();	   
					   csvCell = reader.readNext();
					   browser = csvCell[0];
					   myvutest = csvCell[1];
					   username = csvCell[2];
					   password =csvCell[3];
					   unitcode1 = csvCell[4];
		   
						//Printing retrieved data
					   System.out.println(browser);
					   System.out.println(myvutest);
					  
					   		  

					   reader.close();
					   
				} catch (IOException e) {
			           e.printStackTrace();
			       }
				
				String [] RetrivedData = {browser,myvutest,username,password,unitcode1};
				return RetrivedData;	
		  }
	}

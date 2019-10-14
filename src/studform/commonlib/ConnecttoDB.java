package studform.commonlib;


import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnecttoDB {
 
 static Connection con=null;      
 public String url="jdbc:oracle:thin:@//caldevenv3.vu.edu.au:1521/ENV3";      
 private String username="sis_owner";     
 private String password="caluser";     
 private Statement stmt;
 public ResultSet rset;
  
     
   public void openDBConnection()
   {
      try 
   {
   
      // Load the JDBC driver
      String dbdriverName = "oracle.jdbc.driver.OracleDriver";
      Class.forName(dbdriverName);

      // Create a connection to the database
         con = DriverManager.getConnection(url, username, password);
      }
      
       catch (ClassNotFoundException e) 
    {
     System.out.println("Class not found from database" );
      e.printStackTrace();
    } 
    catch (SQLException e1) 
    {
     System.out.println("ORACLE Connection error " );
      e1.printStackTrace();
    }
           
      
   }
   
    /* This Function execute the query on the connected database and return the ResultSet collection 
   Upon calling from the test case class where actual verification is being done on UI and Database.
      */
      public ResultSet runQuery(String Query) throws IOException
      {
      
       try{
      stmt = con.createStatement();
      rset = stmt.executeQuery(Query);
      
      }
       catch(SQLException e1)
       {
        System.out.println("Query Execution Error" );
     e1.printStackTrace();
       }
       
       return rset;
      }
          
          
            
    /* This Function closes the database connection from the Oracle Database Connection
   Upon calling from the test case class where actual verification is being done.
      */
      public void OracleCloseConnection() throws IOException
      {
       try{
      con.close();
       }
       
       catch(SQLException e1)
       {
        System.out.println("Query Execution Error" );
     e1.printStackTrace();
        
       }
       
   } 
       
}
	 




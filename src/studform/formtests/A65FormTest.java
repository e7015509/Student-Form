package studform.formtests;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import studform.commonlib.ConnecttoDB;
import studform.commonlib.DatabaseConnector;
import studform.commonlib.Driver;
import studform.formactions.*;

public class A65FormTest extends PersonalDetailsAction {
	//ConnecttoDB db=new ConnecttoDB();
	
	
	/*@Test(priority=1, description="Validate student id in the personal details section")
	public void studentid() throws IOException{
			validatestudentid();
			
		}
	@Test(priority=2, description="Validate course count between the database and the student form")
	public void coursecount() throws IOException{
		validatecoursecount();
	}*/
	
	/*@Test(priority=1, description="Validate course data between the database and the student form")
	public void coursedata() throws IOException{
		validatecoursedata();
	}*/
	
	@Test(priority=1, description="Validate study year")
	public void studyyear() throws Exception, Throwable{
		validatestudyyear();
	}
	
	@BeforeTest
	 public void beforeTest(){
		global();
		driver=Driver.getDriver(driver, browser);
		driver.manage().window().maximize();
		
	}
	
	@AfterTest
	public void afterTest() throws Throwable{
		driver.close();
		//db.OracleCloseConnection();
		
	}

}

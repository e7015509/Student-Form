package studform.formtests;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import studform.formactions.*;
import studform.commonlib.*;

public class A65FormMainPageTest extends A65MainPageAction {

	CommonMethods commMethods =new CommonMethods();
	
	/*@Test(priority=1, description="Validate student name in the personal details section")
	public void studentid() throws IOException{
		validatestudentname();	
		}
	@Test(priority=2, description="Validate course count between the database and the student form")
	public void coursecount() throws IOException{
		validatecoursecount();
	}
	
	@Test(priority=3, description="Validate course data between the database and the student form")
	public void coursedata() throws IOException{
		validatecoursedata();
	}
	
	@Test(priority=4, description="Validate study year")
	public void studyyear() throws Exception, Throwable{
		validatestudyyear();
	}
	
	@Test(priority=5, description="Validate course location")
	public void courselocation() throws Exception, Throwable{	
		validatecourselocation();
	}
	
	@Test(priority=6, description="Validate study period")
	public void studyperiod() throws Exception, Throwable{	
		validatestudyperiod();
	}
	
	@Test(priority=1, description="Validate study period")
	public void addunit() throws Exception, Throwable{	
		addsingleunit();
	}*/
	@Test(priority=1, description="login to MYVU")
	public void myvulogin() throws Exception, Throwable{	
		commMethods.accessA65Form(driver,myvutest);
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
		
	}

}

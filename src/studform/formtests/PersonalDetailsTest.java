package studform.formtests;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import studform.commonlib.Driver;
import studform.formactions.*;

public class PersonalDetailsTest extends PersonalDetailsAction {
	
	@Test(priority=1, description="Validate student id in the personal details section")
	public void studentid() throws IOException{
			validatestudentid();
		}
	
	@BeforeTest
	 public void beforeTest(){
		global();
		driver=Driver.getDriver(driver, browser);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void afterTest(){
		driver.close();
		
	}

}

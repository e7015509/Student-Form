package studform.formtests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import studform.commonlib.Driver;
import studform.formactions.A65UnitPageAction;

public class A65FormUnitPageTest extends A65UnitPageAction {
	
	@Test(priority=1, description="Validate Add Unit")
	public void addunit() throws Exception, Throwable{
		validateaddunit();
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




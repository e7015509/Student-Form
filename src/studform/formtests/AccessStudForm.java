package studform.formtests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import studform.commonlib.*;
import studform.pageobjectrepo.*;

public class AccessStudForm {
	
	CommonMethods commMethods=new CommonMethods();
	ConnecttoDB connDB=new ConnecttoDB();
	public WebDriver driver;
	public String browser;
	public String A65formURL;
	//public String tstQuery ="select * from ADV_STND_UNIT where S_ADV_STND_GRANTING_STATUS = 'ASSESSING' and person_id='4541258'and unit_cd='BCO3442'and enrolled_dt ='12/SEP/2019'";
		
	@Test(priority=1)
	public void login() throws InterruptedException, IOException{
		
		commMethods.accessstudentform(driver, A65formURL);
		
	}
	
	
	@BeforeClass
	 public void beforeTest() throws InterruptedException, IOException {
		  DataBroker TestData = new DataBroker();
		  String [] csvCell;
		  csvCell = TestData.ReadData();
		  
		  browser = csvCell[0];
		  A65formURL = csvCell[1];
		  
		  driver=Driver.getDriver(driver, browser);
		  driver.manage().window().maximize();
		  
		  Thread.sleep(5000);
		 // connDB.runQuery(tstQuery);
		  
	}
	
	 @AfterTest
	 public void afterTest() {
		 driver.close();
}
}

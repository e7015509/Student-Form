package studform.formactions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import studform.commonlib.*;
import studform.pageobjectrepo.A65FormLandingPageObj;

public class PersonalDetailsAction extends GlobalVariable{
	public WebDriver driver;
	CommonMethods commMethods =new CommonMethods();
	
	public void validatestudentid() throws IOException{
		try{
		commMethods.accessstudentform(driver, A65formURL);
		Thread.sleep(5000);
		String expStudIDlbl= lblStudentid;
		String actStudIdlbl= A65FormLandingPageObj.lbl_StudentId(driver).getText();
		System.out.println(actStudIdlbl);
		Assert.assertEquals(actStudIdlbl, expStudIDlbl);
	}catch (Exception persondetexcep){
		commMethods.methodname="validatestudentid_";
		commMethods.printStackTrace(persondetexcep);
		commMethods.screenshot(driver);		
	}

	}
}

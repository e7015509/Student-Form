package studform.formactions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import studform.commonlib.CommonMethods;
import studform.commonlib.ConnecttoDB;
import studform.commonlib.GlobalVariable;
import studform.pageobjectrepo.A65FormPageObj;

public class A65UnitPageAction extends GlobalVariable{
	public WebDriver driver;
	CommonMethods commMethods =new CommonMethods();
	ConnecttoDB db=new ConnecttoDB();

	public void validateaddunit() throws Exception, IOException{
		try{
			commMethods.accessA65Form(driver,myvutest);
			Thread.sleep(3000);
			
			/*Boolean addunitbtn=A65FormPageObj.btn_AddUnit(driver).isEnabled();
				if (addunitbtn = true){
					System.out.println("Add Unit button is enabled");
				}else{
					System.out.println("Add Unit button is disabled");
				}*/
			//A65FormPageObj.btn_AddUnit(driver).click();
			commMethods.clickonicon(driver,"Add Unit");
			Thread.sleep(3000);
			commMethods.clickondropdown(driver,"1");
			Thread.sleep(3000);
		}catch (Throwable addunitexcep){
			commMethods.methodname="validateaddunit_";
			commMethods.printStackTrace(addunitexcep);
			commMethods.screenshot(driver);	
			Assert.fail();
		}

	}
}

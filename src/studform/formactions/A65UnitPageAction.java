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
			commMethods.accessstudentform(driver, A65formURL);
			Thread.sleep(3000);
			
			Boolean addunitbtn=A65FormPageObj.btn_AddUnit(driver).isEnabled();
				if (addunitbtn = true){
					System.out.println("Add Unit button is enabled");
				}else{
					System.out.println("Add Unit button is disabled");
				}
			A65FormPageObj.btn_AddUnit(driver).click();
			Thread.sleep(3000);
			//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='runtime-popup']")));
			A65FormPageObj.frm_SwitchtoFrameUnit(driver);
			//driver.findElement(By.xpath("//div[@id='00000000-0000-0000-0000-000000000000_383e5a6c-5f94-55da-f16d-ba04e5634828']//div[@class='styling-outer-wrapper']//div[@class='input-control-buttons styling-right styling-inner-wrapper']//a")).click();
			A65FormPageObj.dropdwn_StudyPeriod(driver).click();
			Thread.sleep(3000);
		}catch (Throwable addunitexcep){
			commMethods.methodname="validateaddunit_";
			commMethods.printStackTrace(addunitexcep);
			commMethods.screenshot(driver);	
			Assert.fail();
		}

	}
}

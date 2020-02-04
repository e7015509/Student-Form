package studform.formactions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import studform.commonlib.CommonMethdtest;
import studform.commonlib.ConnecttoDB;
import studform.commonlib.GlobalVariable;
	
public class A65UnitPageAction extends GlobalVariable{
	public WebDriver driver;		
	CommonMethdtest commMethd =new CommonMethdtest();
	ConnecttoDB db=new ConnecttoDB();

	public void validateaddunit() throws Throwable{	
		try{
			commMethd.accessA65Form(driver);
			Thread.sleep(3000);
			a65formtestdata();
			
			/*Boolean addunitbtn=A65FormPageObj.btn_AddUnit(driver).isEnabled();
				if (addunitbtn = true){
					System.out.println("Add Unit button is enabled");
				}else{
					System.out.println("Add Unit button is disabled");
				}*/
			commMethd.clickonicon(driver,"Add unit");
			Thread.sleep(3000);
			commMethd.switchtoframeunit(driver);
			commMethd.clickondropdown(driver,"1");
			Thread.sleep(3000);
			commMethd.selectvaluefromdropdown(driver,studyperiod);
			Thread.sleep(3000);
		}catch (Throwable addunitexcep){
			commMethd.methodname="validateaddunit_";
			commMethd.printStackTrace(addunitexcep);
			commMethd.screenshot(driver);	
			Assert.fail();
		}

	}
}

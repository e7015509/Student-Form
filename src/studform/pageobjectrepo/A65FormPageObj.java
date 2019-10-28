package studform.pageobjectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import studform.commonlib.*;

public class A65FormPageObj {
	
private static WebElement element = null;
private static List<WebElement> elementList = null;

//Section A - Personal Details	
	public static WebElement lbl_StudentId(WebDriver driver){
		element=driver.findElement(By.xpath("//span[@name='Student Id Label']/b"));
		return element;
	 }
	
	public static WebElement fld_StudentId(WebDriver driver){
		element=driver.findElement(By.xpath("//span[@name='StudentId Data Label']']"));
		return element;
	 }
//Section B - Course Details
	public static WebElement fld_CourseValue(WebDriver driver){
		element=driver.findElement(By.xpath("//div[@id='174ceab2-db44-4707-ade1-3a614701d1b9_f8049f82-01dc-8898-5f05-52e16693baec_1379bb52-3568-2085-3c95-4a242050b28b_2c559f18-9fe2-4952-b12e-8e0997c1646e']/div[2]/div[2]//tr[1]//span"));
		return element;
	}
	
	public static WebElement dropdwn_Course(WebDriver driver){
		element=driver.findElement(By.xpath("//div[@id='65c9cb97-d759-463f-0fda-f91efea43359_fe13a511-a5c1-660b-c1bd-dbe9f3972df6']//a[@class='dropdown border-left-only']"));
		return element;		
	}
	
	public static List<WebElement> dropdwn_CourseList(WebDriver driver){
		elementList=driver.findElements(By.xpath("//div[@id='65c9cb97-d759-463f-0fda-f91efea43359_fe13a511-a5c1-660b-c1bd-dbe9f3972df6_droplist']//ul/li[@title]"));
		return elementList;
	}

//Section C- Unit of Study and Waiver Details
	public static WebElement lbl_StudyYear(WebDriver driver){
		element=driver.findElement(By.xpath("//span[@name='labelStudyYear']"));
		return element;
	}
	
	public static WebElement val_StudyYear(WebDriver driver){
		element=driver.findElement(By.xpath("//span[@id='65c9cb97-d759-463f-0fda-f91efea43359_770487f1-752a-b1d5-632f-61629e4015f1']"));
		return element;
	}

	public static WebElement btn_AddUnit(WebDriver driver){
		element=driver.findElement(By.xpath("//a[@id='7b5a3fcc-a9e9-d934-5ceb-f9ccd2b8654c_8db39aed-01cb-5d77-0ff4-3d0632887548_ToolbarButton']"));
		return element;	
	}
	
	public static WebElement btn_EditUnit(WebDriver driver){
		element=driver.findElement(By.xpath("//a[@id='7b5a3fcc-a9e9-d934-5ceb-f9ccd2b8654c_c6461230-0057-bdf5-49c5-ef69533f120d_ToolbarButton']"));
		return element;
	}
	
	public static WebElement btn_DeleteUnit(WebDriver driver){
		element=driver.findElement(By.xpath("//a[@id='7b5a3fcc-a9e9-d934-5ceb-f9ccd2b8654c_10e037bd-b05c-e5c3-ed50-6a80b1ee9886_ToolbarButton']"));
		return element;
	}

//Unit Add/Edit pop-up window
	public static void frm_SwitchtoFrameUnit(WebDriver driver){
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='runtime-popup']")));		
	}
	
	public static WebElement dropdwn_StudyPeriod(WebDriver driver){
		element=driver.findElement(By.xpath("//div[@id='00000000-0000-0000-0000-000000000000_383e5a6c-5f94-55da-f16d-ba04e5634828']//div[@class='styling-outer-wrapper']//div[@class='input-control-buttons styling-right styling-inner-wrapper']//a"));
		return element;
	}
	
	}



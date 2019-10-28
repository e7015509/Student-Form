package studform.formactions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Year;

import studform.commonlib.*;
import studform.pageobjectrepo.A65FormPageObj;

public class A65MainPageAction extends GlobalVariable{
	public WebDriver driver;
	CommonMethods commMethods =new CommonMethods();
	ConnecttoDB db=new ConnecttoDB();

	
	public void validatestudentid() throws IOException, AssertionError{
		try{
		commMethods.accessstudentform(driver, A65formURL);
		Thread.sleep(5000);
		String actStudIdlbl= A65FormPageObj.lbl_StudentId(driver).getText();
		System.out.println(actStudIdlbl);
		Assert.assertEquals(actStudIdlbl, expStudentidlbl);
		String sQuery="SELECT distinct p.given_names||' '||p.surname as Stduent_Name from person p left join student_course_attempt sca on p.person_id=sca.person_id where course_attempt_status in('ENROLLED','INACTIVE') and p.person_id = '4610792'";
		
		String studName=DatabaseConnector.executeSQLQuery("SysTest", sQuery);
		System.out.println("STUDENT NAME : "+studName);
		
	}catch (Throwable persondetexcep){
		commMethods.methodname="validatestudentid_";
		commMethods.printStackTrace(persondetexcep);
		commMethods.screenshot(driver);		
		Assert.fail();
	}
}
	public void validatecoursecount() throws IOException, AssertionError{
		try{
		String COURSE_COUNT_QUERY = SQLHelper.loadResourceToString("C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\Queries\\coursecount.sql");
		commMethods.accessstudentform(driver, A65formURL);
		Thread.sleep(5000);
		
		//List <WebElement> courseListForm = A65FormPageObj.dropdwn_Course(driver);//get course list from the drop down
		List <WebElement> courseListForm =driver.findElements(By.xpath("//div[@id='65c9cb97-d759-463f-0fda-f91efea43359_fe13a511-a5c1-660b-c1bd-dbe9f3972df6_droplist']//ul/li[@title]"));
		int courseCountForm= courseListForm.size(); //Count of courses from the drop down
		System.out.println("COUNT OF COURSES IN THE FORM : "+courseCountForm);
		
		//Count of courses for the student in the db
		String courseCountQuery="SELECT count(sca.course_cd) from student_course_attempt sca left join course_version cv on sca.course_cd=cv.course_cd where sca.course_attempt_status in('ENROLLED','INACTIVE') and sca.person_id = '4610792' and cv.course_status='ACTIVE' order by cv.title";
		int courseCountDB=DatabaseConnector.executeSQLQuery_Count("SysTest", COURSE_COUNT_QUERY);
		System.out.println("COUNT OF COURSES IN THE db : "+courseCountDB);
		Assert.assertEquals(courseCountForm, courseCountDB);
		
		}catch (Throwable courseexcep){
			commMethods.methodname="validatecourse_";
			commMethods.printStackTrace(courseexcep);
			commMethods.screenshot(driver);		
			Assert.fail();
		}
}
	
	public void validatecoursedata() throws IOException, AssertionError{
		try{
			String COURSE_DATA_QUERY = SQLHelper.loadResourceToString("C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\Queries\\coursedata.sql");
			commMethods.accessstudentform(driver, A65formURL);
			Thread.sleep(3000);
			A65FormPageObj.dropdwn_Course(driver).click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//div[@id='65c9cb97-d759-463f-0fda-f91efea43359_fe13a511-a5c1-660b-c1bd-dbe9f3972df6']//a[@class='dropdown border-left-only']")).isDisplayed();
			System.out.println("Clicked on course drop down successfully");
			Thread.sleep(2000);
			//String courseList = A65FormLandingPageObj.dropdwn_CourseList(driver).toString();
			List<WebElement> courseList = A65FormPageObj.dropdwn_CourseList(driver);
			System.out.println("Courses available in the form : ");
			System.out.println("--------------------------------------");
			for (WebElement opt:courseList){
				System.out.println(opt.getText());
			}
			List<String> CL =new ArrayList<String>();
				for (WebElement opt:courseList){
					//System.out.println(opt.getText());
					CL.add(opt.getText());
			    }
		
			List<String> courseListDB=new ArrayList<String>();
			courseListDB=DatabaseConnector.executeSQLQuery_List("SysTest", COURSE_DATA_QUERY);
			System.out.println("Courses available in the db :");
			System.out.println("--------------------------------------");
				for(int i=0; i<courseListDB.size(); i++){
					 System.out.println(courseListDB.get(i));
				}
			System.out.println("------------------------DATA COMPARISON OUTCOME-------------------------------");
			if(CL.equals(courseListDB)){
				System.out.println("COURSE DATA BETWEEN THE WEB FORM AND DB ARE MATCHING!!");
			}else{
				System.out.println("MISMATCH IN THE COURSE DATA BETWEEN THE WEB FORM AND DB :(");
			}
			System.out.println("--------------------------------------------------------------");
			}catch (Throwable coursedataexcep){
			commMethods.methodname="validatecoursedata_";
			commMethods.printStackTrace(coursedataexcep);
			commMethods.screenshot(driver);	
			Assert.fail();
	     } 
	}

	public void validatestudyyear() throws Exception, IOException{
	try{
		commMethods.accessstudentform(driver, A65formURL);
		Thread.sleep(3000);
		
		String actstudyrlbl= A65FormPageObj.lbl_StudyYear(driver).getText();
		Assert.assertEquals(actstudyrlbl, "Study Year:");
		
		String actstudyyrval= A65FormPageObj.val_StudyYear(driver).getText();
		System.out.println("Study Year in the Web Form : "+actstudyyrval);
		int year= Year.now().getValue();
		String expstudyyrval=Integer.toString(year);
		System.out.println("Expected Study Year : "+expstudyyrval);
		
		Assert.assertEquals(actstudyyrval, expstudyyrval);
		
	}catch (Throwable studyyrexcep){
		commMethods.methodname="validatestudyyear_";
		commMethods.printStackTrace(studyyrexcep);
		commMethods.screenshot(driver);	
		Assert.fail();
	}

}
	
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
	
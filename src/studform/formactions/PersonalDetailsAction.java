package studform.formactions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import studform.commonlib.*;
import studform.pageobjectrepo.A65FormLandingPageObj;

public class PersonalDetailsAction extends GlobalVariable{
	public WebDriver driver;
	CommonMethods commMethods =new CommonMethods();
	ConnecttoDB db=new ConnecttoDB();

	
	public void validatestudentid() throws IOException, AssertionError{
		try{
		commMethods.accessstudentform(driver, A65formURL);
		Thread.sleep(5000);
		String actStudIdlbl= A65FormLandingPageObj.lbl_StudentId(driver).getText();
		System.out.println(actStudIdlbl);
		Assert.assertEquals(actStudIdlbl, expStudentidlbl);
		String sQuery="SELECT distinct p.title||' ' ||p.given_names||' '||p.surname as Stduent_Name from person p left join student_course_attempt sca on p.person_id=sca.person_id where course_attempt_status in('ENROLLED','INACTIVE') and p.person_id = '4610792'";
		
		String studName=DatabaseConnector.executeSQLQuery("SysTest", sQuery);
		System.out.println(studName);
		
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
		
		//List <WebElement> courseListForm = A65FormLandingPageObj.dropdwn_Course(driver);//get course list from the drop down
		List <WebElement> courseListForm =driver.findElements(By.xpath("//div[@id='65c9cb97-d759-463f-0fda-f91efea43359_fe13a511-a5c1-660b-c1bd-dbe9f3972df6_droplist']//ul/li[@title]"));
		int courseCountForm= courseListForm.size(); //Count of courses from the drop down
		System.out.println("Count of courses in the form : "+courseCountForm);
		
		//Count of courses for the student in the db
		String courseCountQuery="SELECT count(sca.course_cd) from student_course_attempt sca left join course_version cv on sca.course_cd=cv.course_cd where sca.course_attempt_status in('ENROLLED','INACTIVE') and sca.person_id = '4610792' and cv.course_status='ACTIVE' order by cv.title";
		int courseCountDB=DatabaseConnector.executeSQLQuery_Count("SysTest", COURSE_COUNT_QUERY);
		System.out.println("Count of courses in the DB : "+courseCountDB);
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
		Thread.sleep(5000);
		
		//String courseListQuery="SELECT cv.title||' '||'('||sca.course_cd||')' as CourseNameCd from student_course_attempt sca left join course_version cv on sca.course_cd=cv.course_cd where sca.course_attempt_status in('ENROLLED','INACTIVE') and sca.person_id = '4610792' and cv.course_status='ACTIVE' order by cv.title";
		List<String> courseListDB=new ArrayList<String>();
		courseListDB=DatabaseConnector.executeSQLQuery_List("SysTest", COURSE_DATA_QUERY);
		for(int i=0; i<courseListDB.size(); i++){
			System.out.println(courseListDB.get(i));
		}
		}catch (Throwable coursedataexcep){
			commMethods.methodname="validatecoursedata_";
			commMethods.printStackTrace(coursedataexcep);
			commMethods.screenshot(driver);		
			Assert.fail();
		}
	}
} 
	        

	
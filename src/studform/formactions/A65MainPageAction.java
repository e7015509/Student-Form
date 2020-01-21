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

	
	public void validatestudentname() throws IOException, AssertionError{
		try{
		commMethods.accessA65Form(driver,myvutest);
		Thread.sleep(5000);
		String studentname=A65FormPageObj.getvalue_StudentName(driver).getText();
		System.out.println("STUDENT NAME IN FORM : "+studentname);
		
		String STUDENT_NAME_QUERY=SQLHelper.loadResourceToString("C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\Queries\\studentname.sql");
		String studName=DatabaseConnector.executeSQLQuery("SysTest", STUDENT_NAME_QUERY);
		System.out.println("STUDENT NAME IN DB : "+studName);
		
		Assert.assertEquals(studentname, studName);
		
	}catch (Throwable persondetexcep){
		commMethods.methodname="validatestudentname_";
		commMethods.printStackTrace(persondetexcep);
		commMethods.screenshot(driver);		
		Assert.fail();
	}
}
	public void validatecoursecount() throws IOException, AssertionError{
		try{
		String COURSE_COUNT_QUERY = SQLHelper.loadResourceToString("C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\Queries\\coursecount.sql");
		commMethods.accessA65Form(driver,myvutest);
		Thread.sleep(5000);
		
		List <WebElement> courseListForm = A65FormPageObj.getvalue_CourseList(driver);//get course list from the drop down
		//List <WebElement> courseListForm =driver.findElements(By.xpath("//div[@id='65c9cb97-d759-463f-0fda-f91efea43359_fe13a511-a5c1-660b-c1bd-dbe9f3972df6_droplist']//ul/li[@title]"));
		int courseCountForm= courseListForm.size(); //Count of courses from the drop down
		System.out.println("COUNT OF COURSES IN THE FORM : "+courseCountForm);
		
		//Count of courses for the student in the db
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
			commMethods.accessA65Form(driver,myvutest);
			Thread.sleep(3000);
			//A65FormPageObj.dropdwn_Course(driver).click();
			commMethods.clickondropdown(driver, "1");
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//div[@id='65c9cb97-d759-463f-0fda-f91efea43359_fe13a511-a5c1-660b-c1bd-dbe9f3972df6']//a[@class='dropdown border-left-only']")).isDisplayed();
			System.out.println("Clicked on course drop down successfully");
			Thread.sleep(2000);
			List<WebElement> courseList = A65FormPageObj.getvalue_CourseList(driver);
			System.out.println("Courses available in the form : ");
			System.out.println("--------------------------------------");
			for (WebElement opt:courseList){
				System.out.println(opt.getText());
			}
			List<String> CL =new ArrayList<String>();
				for (WebElement opt:courseList){
					CL.add(opt.getText());
			    }
		
			List<String> courseListDB=new ArrayList<String>();
			courseListDB=DatabaseConnector.executeSQLQuery_List("SysTest", COURSE_DATA_QUERY);
			System.out.println("Courses available in the db :");
			System.out.println("--------------------------------------");
				for(int i=0; i<courseListDB.size(); i++){
					 System.out.println(courseListDB.get(i));
				}
			System.out.println("------------------------COURSE DATA COMPARISON OUTCOME-------------------------------");
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
	
	public void validatecourselocation() throws IOException, AssertionError, Exception{
		try{
			String COURSE_LOC_QUERY=SQLHelper.loadResourceToString("C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\Queries\\courselocation.sql");
			commMethods.accessA65Form(driver,myvutest);
			Thread.sleep(3000);
			commMethods.clickondropdown(driver, "1");
			Thread.sleep(2000);
			//List of courses from the DB
			List<String> courselocationDB=new ArrayList<String>();
			courselocationDB=DatabaseConnector.executeSQLQuery_List("SysTest", COURSE_LOC_QUERY);
			//List of courses from the form
			List<WebElement> courseList = A65FormPageObj.getvalue_CourseList(driver);
		
				for(int i=0; i<courseList.size();i++){
					System.out.println(courseList.get(i).getText());
					courseList.get(i).click();
					String actcourseloc=A65FormPageObj.getvalue_CourseLocation(driver).getText();
					System.out.println("Location in form : "+actcourseloc);
					String expcourseloc=courselocationDB.get(i);
					System.out.println("Location in DB : "+expcourseloc);
					Assert.assertEquals(actcourseloc, expcourseloc);
					commMethods.clickondropdown(driver, "1");
					Thread.sleep(3000);
				}
		}catch (Throwable courselocationexcep){
		commMethods.methodname="validatecourselocation_";
		commMethods.printStackTrace(courselocationexcep);
		commMethods.screenshot(driver);	
		Assert.fail();
		}
	}

	public void validatestudyyear() throws Exception, IOException{
	try{
		commMethods.accessA65Form(driver,myvutest);
		Thread.sleep(3000);
			
		String actstudyyrval= A65FormPageObj.getvalue_StudyYear(driver).getText();
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
	
	public void validatestudyperiod() throws Exception, IOException{
		try{
			String STUDY_PERIOD_QUERY=SQLHelper.loadResourceToString("C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\Queries\\studyperiodtemp.sql");
			commMethods.accessA65Form(driver,myvutest);
			Thread.sleep(3000);
			commMethods.clickonicon(driver,"Add Unit");
			Thread.sleep(3000);
			commMethods.switchtoframeunit(driver);
			commMethods.clickondropdown(driver,"1");
			Thread.sleep(3000);
			//List of courses from the DB
			List<String> studyperiodDB=new ArrayList<String>();
			studyperiodDB=DatabaseConnector.executeSQLQuery_List("SysTest", STUDY_PERIOD_QUERY);
			System.out.println("DB array size: "+studyperiodDB.size());
			//List of courses from the form
			List<WebElement> studyperiodList = A65FormPageObj.getvalue_StudyPeriod(driver);
			//studyperiodList.removeIf(n -> (n==null || n.toString().trim().equals("")));
			System.out.println("form array size: "+studyperiodList.size());
					
			for(int i=0; i<studyperiodList.size(); i++){
				String expstudyperiod=studyperiodDB.get(i).toString();
				String actstudyperiod=studyperiodList.get(i).getText();
				System.out.println("Study Period from DB : "+expstudyperiod);
				System.out.println("study Period from Form : "+actstudyperiod);
				Assert.assertEquals(actstudyperiod, expstudyperiod);
			}
		}catch (Throwable studyperiodexcep){
			commMethods.methodname="validatestudyperiod_";
			commMethods.printStackTrace(studyperiodexcep);
			commMethods.screenshot(driver);	
			Assert.fail();
		}

	}
	
	public void addsingleunit() throws Exception, IOException{
		try{
			commMethods.accessA65Form(driver,myvutest);
			Thread.sleep(3000);
			commMethods.clickonicon(driver,"Add Unit");
			Thread.sleep(3000);
			commMethods.switchtoframeunit(driver);
			commMethods.clickondropdown(driver, "1");
			Thread.sleep(3000);
			List<WebElement> studyperiodList = A65FormPageObj.getvalue_StudyPeriod(driver);
				studyperiodList.get(0).click();
				A65FormPageObj.enter_UnitCode(driver, unitcode1);
				Thread.sleep(2000);
		}catch (Throwable addunitexcep){
			commMethods.methodname="validateaddunit_";
			commMethods.printStackTrace(addunitexcep);
			commMethods.screenshot(driver);	
			Assert.fail();
		}

	}
	        
}
	
package studform.pageobjectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import studform.commonlib.*;



public class A65FormPageObj extends GlobalVariable {
	
private static WebElement element = null;
private static List<WebElement> elementList = null;
private static String elementname=null;

//Section A - Personal Details	
	public static WebElement getvalue_StudentId(WebDriver driver){
		return element=driver.findElement(By.xpath("//span[@name='StudentId Data Label']']"));
	 }
	
	public static WebElement getvalue_StudentName(WebDriver driver){
		return element=driver.findElement(By.xpath("//span[@name='Name Data Label']"));
	}
//Section B - Course Details
	public static List<WebElement> getvalue_CourseList(WebDriver driver){
		return elementList=driver.findElements(By.xpath("//div[@id='65c9cb97-d759-463f-0fda-f91efea43359_fe13a511-a5c1-660b-c1bd-dbe9f3972df6_droplist']//ul/li[@title]"));
	}
	
	public static WebElement getvalue_CourseLocation(WebDriver driver){
		return element=driver.findElement(By.xpath("//span[@name='dlLocation']"));
	}

//Section C- Unit of Study and Waiver Details
	public static WebElement getvalue_StudyYear(WebDriver driver){
		return element=driver.findElement(By.xpath("//span[@id='65c9cb97-d759-463f-0fda-f91efea43359_770487f1-752a-b1d5-632f-61629e4015f1']"));
	}
//Add Unit
	public static List<WebElement> getvalue_StudyPeriod(WebDriver driver){
		return elementList=driver.findElements(By.xpath("//div[@id='00000000-0000-0000-0000-000000000000_31812432-47f1-4eed-a3cf-2769bed3e468_droplist']//li[@title][@class='']"));
	}
	
	public static void enter_UnitCode(WebDriver driver, String unitcode){
		driver.findElement(By.xpath("//input[@name='Unit Code']")).isEnabled();
		driver.findElement(By.xpath("//input[@name='Unit Code']")).sendKeys(unitcode);
	}
	
	}



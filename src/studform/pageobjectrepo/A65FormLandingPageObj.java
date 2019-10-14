package studform.pageobjectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import studform.commonlib.*;

public class A65FormLandingPageObj {
	
private static WebElement element = null;
private static List<WebElement> elementList = null;
	
	public static WebElement lbl_StudentId(WebDriver driver){
		element=driver.findElement(By.xpath("//span[@name='Student Id Label']/b"));
		return element;
	 }
	
	public static WebElement fld_StudentId(WebDriver driver){
		element=driver.findElement(By.xpath("//span[@name='StudentId Data Label']']"));
		return element;
	 }
	public static WebElement fld_CourseValue(WebDriver driver){
		element=driver.findElement(By.xpath("//div[@id='174ceab2-db44-4707-ade1-3a614701d1b9_f8049f82-01dc-8898-5f05-52e16693baec_1379bb52-3568-2085-3c95-4a242050b28b_2c559f18-9fe2-4952-b12e-8e0997c1646e']/div[2]/div[2]//tr[1]//span"));
		return element;
	}
	
	public static List<WebElement> dropdwn_Course(WebDriver driver){
		driver.findElements(By.xpath("//div[@id='65c9cb97-d759-463f-0fda-f91efea43359_fe13a511-a5c1-660b-c1bd-dbe9f3972df6_droplist']//ul/li[@title]"));
		return elementList;
		
	}

	}



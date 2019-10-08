package studform.pageobjectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import studform.commonlib.*;

public class A65FormLandingPageObj {
	
private static WebElement element = null;
	
	public static WebElement lbl_StudentId(WebDriver driver){
		element=driver.findElement(By.xpath("//span[@name='Student Id Label']/b"));
		return element;
	 }
	
	public static WebElement fld_StudentId(WebDriver driver){
		element=driver.findElement(By.xpath("//span[@name='StudentId Data Label']']"));
		return element;
	 }

	}



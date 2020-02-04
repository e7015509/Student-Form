package studform.pageobjectrepo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebElement;

public class CommonPageObj {

	private static WebElement element = null;
	private static List<WebElement> elementList = null;
	private static String elementname=null;
	
	//Login- MYVU
	public static WebElement txtbox_username(WebDriver driver){
		return element=driver.findElement(By.id("username"));	
	}
	
	public static WebElement txtbox_password(WebDriver driver){
		return element=driver.findElement(By.id("password"));	
	}
	
	public static WebElement btn_submit(WebDriver driver){
		return element=driver.findElement(By.name("submit"));
	}
	
	//Logout- MYVU
	public static WebElement dropdwn_user(WebDriver driver){
		return element=driver.findElement(By.xpath("//div[@class='user-info__dropdown']"));	
	}
	public static WebElement option_signout(WebDriver driver){
		return element=driver.findElement(By.linkText("Sign out"));
	}
		
	//Navigation to form links in MYVU
	public static WebElement icon_hamburger(WebDriver driver){
		return element =driver.findElement(By.xpath("//button[@class='header-button header-button--hamburger']"));
	}
	
	public static WebElement link_mycourse(WebDriver driver){
		return element=driver.findElement(By.xpath("//a[@class='slidein__section My-Course']"));
	}
	
	public static WebElement anim_courseloading(WebDriver driver){
		return element=driver.findElement(By.xpath("//div[@class='loading']"));
	}
	
	public static WebElement link_unitwaiver(WebDriver driver){
		return element=driver.findElement(By.linkText("Apply for a Unit Waiver"));
	}
	
	public static WebElement anim_loader(WebDriver driver){
		return element=driver.findElement(By.xpath("/html[1]/body[1]/div[7]"));
	}
	
	//signout A65 form
	public static WebElement btn_a65signout(WebDriver driver){
		return element=driver.findElement(By.xpath("//img[@class='picture-control-inline clickable']"));
	}
	
		

}
	


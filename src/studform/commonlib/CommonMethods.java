package studform.commonlib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import studform.pageobjectrepo.CommonPageObj;
 
import studform.commonlib.*;

public class CommonMethods extends GlobalVariable {
	public String methodname;
	//public String buttonname;
	//public String dropdownindex;
	public WebDriver driver;
		
	//Login to MYVU test
	public WebDriver accessA65Form(WebDriver driver, String URL) throws IOException{
		try{
			driver.get(URL);
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
			CommonPageObj.txtbox_username(driver).sendKeys(username);
			CommonPageObj.txtbox_password(driver).sendKeys(password);
			CommonPageObj.btn_submit(driver).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Get Started')]")));
			CommonPageObj.icon_hamburger(driver).click();
			wait.until(ExpectedConditions.elementToBeClickable(CommonPageObj.link_mycourse(driver)));
			CommonPageObj.link_mycourse(driver).click();
			wait.until(ExpectedConditions.invisibilityOf(CommonPageObj.anim_courseloading(driver)));
			CommonPageObj.link_unitwaiver(driver).click();
			wait.until(ExpectedConditions.invisibilityOf(CommonPageObj.anim_loader(driver)));
			wait.until(ExpectedConditions.elementToBeClickable(CommonPageObj.btn_a65signout(driver)));
			CommonPageObj.btn_a65signout(driver).click();
			Thread.sleep(6000);
			}catch (Exception accessA65form){
				methodname="accessA65form";
				printStackTrace(accessA65form);
				screenshot(driver);
			}
		return driver;
	}
	
		//Print stack trace to file
		public Throwable printStackTrace(Throwable persondetexcep) throws FileNotFoundException{
	        String fileformat = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
			String excepfilename = methodname+fileformat;
			File file = new File("C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\ErrorLog\\"+excepfilename+"");
			PrintStream ps = new PrintStream(file);
			persondetexcep.printStackTrace(ps);
			return persondetexcep;
		}
		//Capture screenshots
		public void screenshot(WebDriver driver) throws IOException{
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\Screenshot\\A65Form_Screenshot.jpg"));
		}
		
		//click on icon -Add/Edit/Delete Unit
		public void clickonicon(WebDriver driver,String iconname){
			boolean icon=driver.findElement(By.xpath("//span[contains(text(),'"+iconname+"')]")).isEnabled();
			if(icon=true){
				System.out.println(iconname+" is enabled");
				driver.findElement(By.xpath("//span[contains(text(),'"+iconname+"')]")).click();
			}
			else{
				System.out.println(iconname+" is not enabled");
			}
		}
		//Switch to Unit frame
		public void switchtoframeunit(WebDriver driver){
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'runtime-popup')]")));		
		}
		//click on drop down list
		public void clickondropdown(WebDriver driver,String dropdownindex){
			boolean dropdown=driver.findElement(By.xpath("(//div[contains(@class,'input-control select-box dropdown-box')])['"+dropdownindex+"']")).isDisplayed();
			if(dropdown=true){
				driver.findElement(By.xpath("(//div[contains(@class,'input-control select-box dropdown-box')])['"+dropdownindex+"']")).click();	
			}
			else{
				System.out.println("Drop down list is not displayed");
			}
			
		}
		
		//Select a value from the drop down list
		public void selectvaluefromdropdown(WebDriver driver,String dropdownvalue){
			boolean dropdownval=driver.findElement(By.xpath("//span[contains(text(),'"+dropdownvalue+"')]")).isDisplayed();
			if(dropdownval=true){
				driver.findElement(By.xpath("//span[contains(text(),'"+dropdownvalue+"')]")).click();
			}
			else{
				System.out.println(dropdownvalue+" is not displayed");
			}
		}
		
}

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
 

public class CommonMethods {
	public String methodname;
	
	 /*Login to Student Calendar*/
		public WebDriver accessstudentform(WebDriver driver, String URL) throws InterruptedException, IOException{
		try{
			driver.get(URL);
			Thread.sleep(8000);
			}catch (Exception loginexcep){
				methodname="accessstudentform_";
				printStackTrace(loginexcep);
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

		
		public void screenshot(WebDriver driver) throws IOException{
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\Screenshot\\A65Form_Screenshot.jpg"));
		}
		
		
}

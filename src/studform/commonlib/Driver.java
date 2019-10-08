package studform.commonlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {
	
	public static WebDriver getDriver(WebDriver driver, String browser){
		if(browser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\BrowserDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\BrowserDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\BrowserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
}
}

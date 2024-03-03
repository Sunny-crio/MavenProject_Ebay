package utils;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import libraries.Browser;
import libraries.ConfigFile;
import libraries.Helper;





public class Baseclass { 

	public WebDriver driver;
	
	public static ConfigFile config;
	//public ExtentReports reports;
	
	@BeforeSuite
	public void SetupExcelDataProvider() throws IOException {
		
		
		config = new ConfigFile();
	}
	
	
	
	
	
	@AfterTest
	public void teardown() {
		Browser.quitBrowser(driver);
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result) {
		
		if(result.getStatus()== ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
			System.out.println("screen shot captured");
		}
		
	}
	
}


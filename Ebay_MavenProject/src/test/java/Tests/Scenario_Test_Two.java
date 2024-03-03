package Tests;




import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Scenario_One;
import io.github.bonigarcia.wdm.WebDriverManager;
import libraries.Browser;
import libraries.ConfigFile;
import libraries.Helper;
import Pages.Scenario_Two;


public class Scenario_Test_Two {
	WebDriver driver;
	Scenario_Two scenario2;;
    
	ConfigFile configFile;
	String url="https://www.ebay.com/";
	private static final Logger logger = LogManager.getLogger(Scenario_Test_Two.class);
	


	@BeforeTest
public void browserlaunch() throws Exception {
		
      configFile = new ConfigFile();
       driver = Browser.startApplication( driver,configFile.getBrowser()); 
	    Helper.zoomIn(driver, 80);
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		logger.info("---Starting Scenario_One---");
	}
//	public void browserLaunch() throws Exception {
//	    configFile = new ConfigFile();
//
//	    System.out.println("Open");
//
//	    // Use WebDriverManager for ChromeDriver setup
//	   WebDriverManager.chromedriver().setup();
//	    
//	  // System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe ");
////
////	    
////	    // Initialize driver
////	    driver = new ChromeDriver();
//	    
//	    ChromeOptions options = new ChromeOptions();
//	   
//	    WebDriver driver = new ChromeDriver(options);
//
//	    // Navigate to the URL
//	    driver.get(url);
//
//	   
//	    driver.manage().window().maximize();
//	    scenario1 = new Scenario_One(driver, logger);
//
//	    logger.info("---Starting Scenario_One---");
//	}


	// Login to Site
	@Test(priority = 1)
	public void Testtwo() throws Exception {
		scenario2 = new Scenario_Two(driver, logger);
		
		Thread.sleep(2000);
		scenario2.searchproduct();
		scenario2.selectcateogoryoption();
		scenario2.clicksearchicon();
		scenario2.firstresultcheck();
		
		System.out.println(scenario2.firstresultcheck());
		
		
	}

	@AfterTest
	public void closeBrowser() {
		logger.info("---Ending HomeTest---");
		driver.quit();
	}
}



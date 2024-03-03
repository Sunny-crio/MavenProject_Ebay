package Tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
import Pages.Scenario_One;


public class Scenario_One_test {
	WebDriver driver;
	Scenario_One scenario1;;
    
	ConfigFile configFile;
	String url="https://www.ebay.com/";
	private static final Logger logger = LogManager.getLogger(Scenario_One_test.class);
	


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


	
	@Test(priority = 1)
	public void Testone() throws Exception {
		scenario1 = new Scenario_One(driver, logger);
		
		Thread.sleep(2000);
		scenario1.clickOnShopByCategory();
		scenario1.clickOnCellphoneAccessories();
		scenario1.clickCellPhoneSmartphones();
		scenario1.clickAllFilters();
		scenario1.conditionSelect();
		scenario1.priceSelect(100,1000);
		scenario1.selectItemLocation();
		scenario1.clickApply();
		System.out.println(scenario1.verifyFiltersApplied());
		
		
	}

	@AfterTest
	public void closeBrowser() {
		logger.info("---Ending HomeTest---");
		driver.quit();
	}
}

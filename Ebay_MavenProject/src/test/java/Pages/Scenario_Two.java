package Pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.ConfigFile;
import libraries.Helper;


public class Scenario_Two {
	
	private WebDriver driver;
	 WebDriverWait wait;
	private ConfigFile configFile ;
	private Logger logger = LogManager.getLogger(Scenario_Two.class);
	
	
	@FindBy(xpath ="*//input[@aria-label=\"Search for anything\"]")
    WebElement searchtext ;
	
	@FindBy(xpath="*//select[@aria-label=\"Select a category for search\"]")
	 WebElement clickcategory ;
	
	@FindBy(xpath="*//input[@value=\"Search\"]")
	WebElement clicksearch;	
    
	@FindBy(xpath="*//div/span/span[contains(text(),\"MacBook\")][1]")
	WebElement firstresult;
	

	
	public Scenario_Two(WebDriver driver, Logger logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	public void searchproduct() {
		logger.info("search product...");
		try {
			wait.until(ExpectedConditions.visibilityOf(searchtext));
			
			
		} catch (Exception e) { 
			logger.error(e);
		}
		searchtext.sendKeys("Macbook");
		logger.info("Sucessfully entered productname in searchproduct text box");
	}
	
	public void selectcateogoryoption() {
		logger.info("select cateogoryoption");   
		try {
			wait.until(ExpectedConditions.visibilityOf(clickcategory));
			
			
		} catch (Exception e) {
			logger.error(e);
		}
		clickcategory.click();
		
		Select select = new Select(clickcategory);

        // Select an option by visible text
		select.selectByVisibleText("Computers/Tablets & Networking");
		
	}
	
	public void clicksearchicon() {
		logger.info("Click searchicon");
		try {
			wait.until(ExpectedConditions.visibilityOf(clicksearch));
			
		} catch (Exception e) {
			logger.error(e);
		}
		clicksearch.click();
	}
	public boolean firstresultcheck() {
		logger.info("first result check ");
		try {
			//Helper.scrollIntoView(driver,firstresult);
			wait.until(ExpectedConditions.visibilityOf(firstresult));

		} catch (Exception e) {
			logger.error(e);
		}
		if(firstresult.getText().equalsIgnoreCase("MacBook"))
		{
			return true;
		}
		else
		return false;
	}
	
	}

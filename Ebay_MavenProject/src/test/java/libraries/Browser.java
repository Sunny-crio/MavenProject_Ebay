package libraries;

import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Browser {
	WebDriver driver;


	public static WebDriver startApplication(WebDriver driver,String browser) {
		
		String userdirectory = System.getProperty("C:\\MavenProject_Ebay\\src\\test\\java\\library");
		
		if(browser.equals("Chrome")) {

			WebDriverManager.chromedriver().setup();

		    ChromeOptions options = new ChromeOptions();
		    options.setCapability("acceptInsecureCerts", true);

		     driver = new ChromeDriver(options);

		      
			
		}
		else if(browser.equals("Firefox")) {
			//FirefoxOptions  options =new FirefoxOptions();
			//options.setBinary(getFirefoxLocation());
			// driver = new FirefoxDriver(options);
			 System.setProperty("webdriver.gecko.driver",userdirectory+"\\Drivers\\geckodriver.exe");
			// driver = new FirefoxDriver();
			 FirefoxOptions firefoxOptions = new FirefoxOptions();
				
				//Using the setAcceptInsecureCerts() method to pass parameter as False
			firefoxOptions.setAcceptInsecureCerts(false);
			driver = new FirefoxDriver(firefoxOptions);
				
			
		}
		else if(browser.equals("Edge")) {
			
			
			System.setProperty("webdriver.edge.driver", userdirectory+"\\Drivers\\msedgedriver.exe");
			//driver = new EdgeDriver();
			EdgeOptions edgeOptions = new EdgeOptions();
			
			//Accepting the Insecure certificates through boolean parameter
			edgeOptions.setAcceptInsecureCerts(true);
							
			//Creating instance of Edge driver by passing reference of EdgeOptions object
	                // Assuming EdgeDriver path has been set in system properties
			driver = new EdgeDriver(edgeOptions);
			

		}
		else
		{
			System.out.println("This browser is not supported");
		}
		
		return driver; 
	}
	
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}
}
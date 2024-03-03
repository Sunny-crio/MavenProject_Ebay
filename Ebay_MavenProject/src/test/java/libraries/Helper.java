package libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Helper {

	
	
	public static void captureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Use SimpleDateFormat to format the current date and time
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            // Format the current date and time
            String formattedDateTime = dateFormat.format(new Date());

            // Construct the file name with the formatted date-time
            String fileName = "./Screenshots/Screenshot_" + formattedDateTime + ".png";

            // Copy the screenshot file to the specified location
            FileHandler.copy(src, new File(fileName));

            System.out.println("Screenshot captured successfully: " + fileName);
        } catch (IOException e) {
            System.out.println("Unable to capture screenshot: " + e.getMessage());
        }
    }
	public static void scrollIntoView(WebDriver driver, WebElement element) {
		
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    } catch (Exception e) {
	        System.out.println("Unable to scroll into view: " + e.getMessage());
	    } 
	}
	//scrollIntoView(driver, elementToScroll);
	public static void zoomIn(WebDriver driver, int zoomPercentage) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "document.body.style.zoom='" + zoomPercentage + "%'";
        js.executeScript(script);
    }

	

	
}


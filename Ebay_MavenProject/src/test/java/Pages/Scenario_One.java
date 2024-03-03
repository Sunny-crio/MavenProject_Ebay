package Pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.Helper;

public class Scenario_One {

    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger = LogManager.getLogger(Scenario_One.class);

    @FindBy(xpath = "*//button[text()=\" Shop by category\"]")
    WebElement shopbycategory;

    @FindBy(xpath = "*//a[text()='Cell phones & accessories']")
    WebElement cellphone_accessories;

    @FindBy(xpath = "*//a[text()='Cell Phones & Smartphones']")
    WebElement cellPhone_Smartphones;

    @FindBy(xpath = "*//button[text()='All Filters']")
    WebElement allFilters;
    
    @FindBy(xpath="*//form[@id=\"x-overlay__form\"]")
    WebElement filtersbox;

    @FindBy(xpath = "*//div/span[text()='Condition']")
    WebElement condition;

    @FindBy(xpath = "*//label/span[text()='New']")
    WebElement condition_New_option;

    @FindBy(xpath = "*//div/span[text()='Price']")
    WebElement price;

    @FindBy(xpath = "*//input[@aria-label='Minimum Value, US Dollar']")
    WebElement minimumprice;

    @FindBy(xpath = "*//input[@aria-label='Maximum Value, US Dollar']")
    WebElement maximumprice;

    @FindBy(xpath = "*//span[text()='Item Location']")
    WebElement itemLocation;

    @FindBy(xpath = "*//input[@value='Worldwide']")
    WebElement worldwideOption;

    @FindBy(xpath = "*//button[text()='Apply']")
    WebElement apply;

    @FindBy(xpath = "*//button/span[text()='3 filters applied']")
    WebElement filtersApplied;

    public Scenario_One(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
       // this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnShopByCategory() {
        logger.info("Clicking on ShopByCategory...");
        try {
            wait.until(ExpectedConditions.visibilityOf(shopbycategory));
        } catch (Exception e) {
            logger.error(e);
        }
        shopbycategory.click();
        logger.info("Successfully clicked on ShopByCategory");
    }

    public void clickOnCellphoneAccessories() {
        logger.info("Click on Cellphone Accessories");
        try {
            wait.until(ExpectedConditions.visibilityOf(cellphone_accessories));
                    } catch (Exception e) {
            logger.error(e);
        }
        cellphone_accessories.click();

    }

    public void clickCellPhoneSmartphones() {
        logger.info("Click CellPhone Smartphones");
        try {
            wait.until(ExpectedConditions.visibilityOf(cellPhone_Smartphones));
           
        } catch (Exception e) {
            logger.error(e);
        }
        cellPhone_Smartphones.click();
    }

    public void clickAllFilters() {
        logger.info("Click AllFilters");
        try {
            Helper.scrollIntoView(driver, allFilters);
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(allFilters));
           
        } catch (Exception e) {
            logger.error(e);
        }
        allFilters.click();
        
        filtersbox.click();
        
        
    }

    public void conditionSelect() {
        logger.info("Click Condition");
        try {
            Helper.scrollIntoView(driver, condition);
            wait.until(ExpectedConditions.visibilityOf(condition));
           
           
        } catch (Exception e) {
            logger.error(e);
        }
        condition.click();
        
        try {
           
        	 Helper.scrollIntoView(driver, condition_New_option);
            wait.until(ExpectedConditions.visibilityOf(condition_New_option));
            
        } catch (Exception e) {
            logger.error(e);
        }
        condition_New_option.click();
    }

    public void priceSelect(int minAmount, int maxAmount) {
        logger.info("Select Price");
        try {
            Helper.scrollIntoView(driver, price);
            wait.until(ExpectedConditions.visibilityOf(price));
           
            
        } catch (Exception e) {
            logger.error(e);
        }
        price.click();
        
        try {
        	Helper.scrollIntoView(driver, minimumprice);
            wait.until(ExpectedConditions.visibilityOf(minimumprice));
           
            
        } catch (Exception e) {
            logger.error(e);
        }
        minimumprice.clear();
        minimumprice.sendKeys(String.valueOf(minAmount));
        
        try {
           
            wait.until(ExpectedConditions.visibilityOf(maximumprice));
         
        } catch (Exception e) {
            logger.error(e);
        }
        maximumprice.clear();
        maximumprice.sendKeys(String.valueOf(maxAmount));
    }

    public void selectItemLocation() throws InterruptedException {
        logger.info("Select Item Location");
        try {
            Helper.scrollIntoView(driver, itemLocation);
            wait.until(ExpectedConditions.elementToBeClickable(itemLocation));
          
           
        } catch (Exception e) {
            logger.error(e);
        }
        itemLocation.click();
        
        try {
           
            Helper.scrollIntoView(driver, worldwideOption);
            wait.until(ExpectedConditions.elementToBeClickable(worldwideOption));
           
        } catch (Exception e) {
            logger.error(e);
        }
        Thread.sleep(1000);
        worldwideOption.click();
        
    }

    public void clickApply() throws InterruptedException {
        logger.info("Click Apply");
        try {
            Helper.scrollIntoView(driver, apply);
            wait.until(ExpectedConditions.elementToBeClickable(apply));

        } catch (Exception e) {
            logger.error(e);
        }
        Thread.sleep(2000);
        apply.click();
    }

    public boolean verifyFiltersApplied() {
        logger.info("Verify Filters Applied");
        try {
        	Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(filtersApplied));
            
        } catch (Exception e) {
            logger.error(e);
          
        }
        if(filtersApplied.getText().equalsIgnoreCase("3 filters applied"))
        {
        	return true;
        }
        else {
			return false;
		} 
    }
}

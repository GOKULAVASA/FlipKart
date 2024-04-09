package testClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



import testUtils.ReadConfig;



public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getWebApplicationUrl();
	public static WebDriver driver;
	public static   Logger logger;
	public WebDriverWait wait;

	
	@BeforeClass
	
	public void setUp() {
		
		String  browser=readconfig.browserSelection();
		logger = LogManager.getLogger(BaseClass.class); 
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		logInfo("chrome driver triggered");	
			
			
		}else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
			logInfo("firefox driver triggered");	
		} else if(browser.equals("msedge")) {
			driver=new EdgeDriver();
			logInfo("Edge driver triggered");	
		}
		
	    if (driver != null) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(readconfig.implicitDurationcount()));
	        driver.get(baseUrl);
	        driver.manage().window().maximize();
	    } else {
	    	logError("WebDriver initialization failed. Check the browser parameter.");
	    }
	}




	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		logInfo("browser quitting ");	
	}

	     public static void CaptureScreenShot(WebDriver driver,String tname) throws IOException {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File SOURCE=ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+tname+".png");
			FileUtils.copyFile(SOURCE, target);
			System.out.println("Screenshot taken");
				
		}
	
	     
	    

	
	     protected void logInfo(String message) {
	         logger.info(message);
	     }

	    
	     protected void logWarning(String message) {
	         logger.warn(message);
	     }

	     
	     protected void logError(String message) {
	         logger.error(message);
	     }

	
	     protected void logDebug(String message) {
	         logger.debug(message);
	     }   
	     
	     public    WebDriverWait waitForElement(WebElement locator) {
		        
			  wait = new WebDriverWait(driver,Duration.ofSeconds(readconfig.implicitDurationcount())); 
			  wait.until(ExpectedConditions.visibilityOf(locator));
			  return wait;
	     }
	
	 
	     
	     public void SearchBxFlipKart(String inputForsearchProduct) {
	    	 driver.findElement(By.xpath("//input[@name='q']")).sendKeys(inputForsearchProduct, Keys.ENTER);
	     }
	     }


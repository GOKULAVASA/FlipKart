package pageClasses;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class OutofStockAtAddtoCartPage {
	WebDriver driver;
	
	JavascriptExecutor js;
	public OutofStockAtAddtoCartPage(WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(driver, this);
		
		js = (JavascriptExecutor) driver;
	}




	@FindBy(xpath="//input[@name='q']")
	WebElement SearchBox;


	@FindBy(xpath="(//div[@class='_2B099V'])[5]//a[1]")
	WebElement SelectingProduct;

	@FindBy(xpath="//span[@class='_2P_LDn' and text()='Check']")
	WebElement changePincodeBtn;

	@FindBy(xpath="//span[text()='Change' or text()='Check']")
	WebElement changePincodeBtn2;

	@FindBy(xpath="//input[@id='pincodeInputId']")
	WebElement PindcodeInputBx;

	@FindBy(xpath="//div[@class='_1SLzzw']//div")
	WebElement PincodevalidationMessg;

	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww _2Fj61M']")
	WebElement AddtocartBtn;
	
	@FindBy(xpath="//div[@class='_16FRp0']")
	WebElement unavailablity;

	public void SearchBoxProduct(String productname) throws InterruptedException {
		SearchBox.sendKeys(productname,Keys.ENTER);



	}
	public void SelectingProductList() throws InterruptedException {

		SelectingProduct.click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		String current = driver.getWindowHandle();
		for (String win : windows) {
			if (!win.equals(current)) {    
				driver.switchTo().window(win);
				String targetwindow = driver.getWindowHandle();
				System.out.println(targetwindow);
			}

		}
	} 





	public void PincodeAlterlink(String PINCODE) throws InterruptedException {
		try {
			Thread.sleep(3000);
			 changePincodeBtn.click();
			 String value =changePincodeBtn.getText();
			System.out.println("Status :"+value);
			if (value.equals("Change")) {
				changePincodeBtn.click();
				PindcodeInputBx.sendKeys(PINCODE, Keys.ENTER);
				System.out.println("Change button is displayed");
			} else if (value.equals("Check")) {
				System.out.println("Check button is displayed");
				changePincodeBtn.click();
				PindcodeInputBx.sendKeys(PINCODE, Keys.ENTER);
				System.out.println("Checking the stock Availability");
			}else {
				String productAvailibility=unavailablity.getText();
				System.out.println(productAvailibility);
			}
		} catch (StaleElementReferenceException e) {
			// Reinitialize the elements
			changePincodeBtn = driver.findElement(By.xpath("//span[@class='_2P_LDn' and text()='Check']"));

			changePincodeBtn2 = driver.findElement(By.xpath("//span[@class='_2P_LDn' and text()='Change']"));
		
		PindcodeInputBx = driver.findElement(By.xpath("//input[@id='pincodeInputId']"));
		WebElement productAvailibility= driver.findElement(By.xpath("//div[@class='_16FRp0']"));
		}

	}




public void ErrorMesg() {
	
	try {
		Thread.sleep(3000);
		PincodevalidationMessg.click();
		String messg = PincodevalidationMessg.getText();
				
		System.out.println("Error message: " + messg);

		boolean cartIcon = isAddToCartButtonEnabled();
		System.out.println("Is Add to Cart button enabled: " + cartIcon);
		
		
		if (messg.contains("Currently out of stock")) {
			Assert.assertFalse(cartIcon);
			System.out.println("out of stock so addtocart disabled");
			} else {
				Assert.assertTrue(cartIcon);
			System.out.println("Product is available");
			System.out.println("out of stock so addtocart enable");
		}  
		 
	} catch (Exception e) {
		 
		
		PincodevalidationMessg = driver.findElement(By.xpath("//div[@class='_1SLzzw']//div"));
		e.printStackTrace(); // Print stack trace for debugging
	}
}

public boolean isAddToCartButtonEnabled() {
	try {
		String script = "return arguments[0].disabled";
		return !(boolean) js.executeScript(script, AddtocartBtn);
	} catch (Exception e) {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww _2Fj61M']"));
		e.printStackTrace(); // Print stack trace for debugging
		return false; // Return false in case of any exceptions
	}
}
}

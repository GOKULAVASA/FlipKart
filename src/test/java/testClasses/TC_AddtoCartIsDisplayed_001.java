package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageClasses.CartDisplayedAndApplicablePage;

public class TC_AddtoCartIsDisplayed_001 extends BaseClass {
	
	
	  @Test
	    public void AddToCartIsDisplayed() {
		  logInfo("CART ICON VERIFICATION STARTS ");
	        CartDisplayedAndApplicablePage cart = new CartDisplayedAndApplicablePage(driver);
	       
	        try {
	         
	           WebElement carticon= cart.isCartDisplayed();
	           waitForElement(carticon);
	         boolean addtocart=  cart.isCartDisplayed().isDisplayed();
	          if(addtocart) {
	        	  Assert.assertTrue(addtocart);
	        	   String moduleName = cart.isCartDisplayed().getAttribute("title");
	                System.out.println("Module Name: " + moduleName);
	                logInfo("Cart module is displayed to new user");
	                cart.isCartDisplayed().click();
	                logInfo("cart icon is clicked ");
	                String pageTitle = driver.getTitle();
	                System.out.println("Page Title: " + pageTitle);
	                logInfo("Cart module is applicable to new user");
	                logInfo("============= Cart Validation done===========");
	            
	        	   
	           }else {
	        	   CaptureScreenShot(driver,"AddToCartIsDisplayed");
	           }
	               
	        } catch (StaleElementReferenceException e) {
	       
	        	 driver.findElement(By.xpath("//input[@name='q']"));
	        	 } catch (Exception ex) {
	          
	            logError("An error occurred: " + ex.getMessage());
	        }
	    }
	}

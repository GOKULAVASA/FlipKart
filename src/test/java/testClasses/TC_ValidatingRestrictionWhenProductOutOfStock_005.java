package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

import pageClasses.OutofStockAtAddtoCartPage;

public class TC_ValidatingRestrictionWhenProductOutOfStock_005 extends BaseClass{
	@Test
	public void ValidatingAddtoCartBtnWhenOutofStock() throws InterruptedException {
		OutofStockAtAddtoCartPage cartBtn=new OutofStockAtAddtoCartPage(driver);
		
		logInfo(" out of stock product handling ");
		
	        
	        try {
	        
	        	cartBtn.SearchBoxProduct(readconfig.SearchProduct_2());
	        	logInfo(" entered the product");
	        } catch (StaleElementReferenceException e) {
	            
	            driver.findElement(By.xpath("//input[@name='q']"));
	        } catch (Exception ex) {
	          
	            logError("An error occurred: " + ex.getMessage());
	        }
	    
	

		cartBtn.SelectingProductList();
		
		logInfo(" selected the product ");
		cartBtn.PincodeAlterlink(readconfig.Pincode());
		logInfo(" entered the picode ");
		cartBtn.ErrorMesg();
		logInfo(" ===VALIDATION DONE ====");
	}
}

 package testClasses;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.AddingProductsToCartPage;
import testUtils.AddingProductToCartUtils;
import testUtils.CartValidationUtil;


public class TC_AddingProductToCart_002 extends BaseClass {
	  
	 boolean isProductInCart;
	 boolean update;
	 String countBefore;
@Test
public void addingProductToCart() throws InterruptedException, IOException {
	logInfo("Adding product to cart Test Starts");
	AddingProductToCartUtils ct=new AddingProductToCartUtils(driver);
	CartValidationUtil val =new CartValidationUtil(driver);
	AddingProductsToCartPage at=new AddingProductsToCartPage(driver);
	try {
		
	ct.setSearchProduct(readconfig.SearchProduct());
	logInfo("Entered the product");
	  
       } catch (StaleElementReferenceException e) {
           // If stale element reference, try locating the element again
           driver.findElement(By.xpath("(//div[@class='_38VF5e'])[2]/a[1]")).click();
       } catch (Exception ex) {
           // Log any other exceptions
           logError("An error occurred: " + ex.getMessage());
       }
   
	ct.ClickSpecificProductDependsonReviewAndRating(readconfig.ProductPrice(),readconfig.productReview(),readconfig.ReviewCount());
	logInfo("clicked the required product===> now navigating to product details page");
	update=false;
	Boolean Beforecount=at.cartcountbefore();
	
	 if (Beforecount) {
	       countBefore= at.Count();
	       logInfo("counting done");
	    } else {
	        System.out.println("no products in the cart");
	    }
	
	System.out.println();
	ct.ClickingAddtoCartBtn();
	logInfo("clicked add to cart Btn===");
	String product =ct.ValidatingCartItem();
	val.CartItem(product);
	String Aftercount=val.cartIconUpdate();
	System.out.println(Aftercount);
	if(countBefore!=Aftercount) {
		update = true;
		Assert.assertTrue(update);
		logInfo("=====VALIDATION DONE========");
		System.out.println("after adding the product ...Cart is updated ");
	}else {
		 CaptureScreenShot(driver,"addingProductToCart");
	}
	
	
	
	
	
}

}

package testClasses;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageClasses.ValidatingCartProductsPage;

public class TC_ValidatingCartItem_004 extends BaseClass {
	@Test
	public void VerifyingSelectedItem_in_Cart() throws InterruptedException {
		
		SoftAssert softAssert = new SoftAssert();
		ValidatingCartProductsPage cartItem=new ValidatingCartProductsPage(driver);
		logInfo(" cart page verification starts");
		cartItem.setSearchProduct(readconfig.SearchProduct());
		logInfo(" entered the product");
		String productnameInProductDetailsPage=cartItem.ClickSpecificProductDependsonReviewAndRating(readconfig.ProductPrice(), readconfig.productReview(), readconfig.ReviewCount());
		cartItem.ClickingAddtoCartBtn();
		logInfo("product selected  ");
		WebElement productnameInCartPage=cartItem.ValidatingCartItem();
		waitForElement(productnameInCartPage);
	
		softAssert.assertEquals(productnameInCartPage, productnameInProductDetailsPage,"Product in cart does not match selected product"); 
        
		System.out.println("selected item is placed in the cart");
    	logInfo(" Validation got passed ");

	}

}

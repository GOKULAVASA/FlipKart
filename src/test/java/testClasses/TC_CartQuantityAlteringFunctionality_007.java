package testClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageClasses.QuantityAddonFunctionalityinCartPage;
import testUtils.AddingProductToCartUtils;

public class TC_CartQuantityAlteringFunctionality_007 extends BaseClass {
	boolean script;
@Test
public void CartQuantity_Add_On_Functionality() {
	logInfo("Cart Add-on verification starts");
	boolean validation;
	AddingProductToCartUtils ct=new AddingProductToCartUtils(driver);
	QuantityAddonFunctionalityinCartPage qt=new QuantityAddonFunctionalityinCartPage(driver);
	try {
		logInfo("entered the products ");
	ct.setSearchProduct(readconfig.SearchProduct());
	}catch(StaleElementReferenceException e ) {
	 driver.findElement(By.xpath("//input[@name='q']"));
	}
	logInfo("showing the list of products ");
	ct.ClickSpecificProductDependsonReviewAndRating(readconfig.ProductPrice(),readconfig.productReview(),readconfig.ReviewCount());
	logInfo("clicked the spefic product  matched the conditions");
	ct.ClickingAddtoCartBtn();
	logInfo("add to cart is applicable and intractable ====> clicking ADD TO CART BUTTON");
	ct.ValidatingCartItem();
	logInfo("Cart validation done has the same item the selected ");
	qt.IncrementalBtn();
	logInfo("clciked the ADD-ON BTN ");
	WebElement confirmationPopUp=qt.confirmationMessage();
	waitForElement(confirmationPopUp);
	
	String Messagescript=qt.validation();
			System.out.println(Messagescript);
			if(Messagescript!=null) {
				script=true;
				Assert.assertTrue(script);
				logInfo("Verfied the Message");
			}
			validation= false;
		String Qty=	qt.QuantityOfSpecficProduct();
			String priceOnCart= qt.priceOnTag();
			System.out.println("quantity :"+Qty+" "+"price "+priceOnCart);
			
			
			String totalAmt=qt.GrantTotal();
			
			
			
System.out.println(totalAmt);
logInfo("checking the price details ");
			if(totalAmt.contains(totalAmt)) {
				validation= true;
				Assert.assertTrue(validation);
				logInfo("changing quantity");
				System.out.println("reflects on the pricedetails");
			}else {
				System.out.println("not equal");
			}
}
          


}

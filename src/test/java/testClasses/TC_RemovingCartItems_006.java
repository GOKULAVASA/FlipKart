package testClasses;


import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageClasses.RemovingCartItemsPage;
import testUtils.AddingProductToCartUtils;

public class TC_RemovingCartItems_006 extends BaseClass{
	boolean messageDisplayed;
	@Test
	public void deletinCartItems() {
		logInfo("remove item in the cart functionality verification Starts");
		AddingProductToCartUtils ct=new AddingProductToCartUtils(driver);
		logInfo("entered the search product and clicked ");
		ct.setSearchProduct(readconfig.SearchProduct());
		logInfo("navigated to the list of products ");
		ct.ClickSpecificProductDependsonReviewAndRating(readconfig.ProductPrice(),readconfig.productReview(),readconfig.ReviewCount());
		logInfo("clicked the specific product which matched with the conditions");
		ct.ClickingAddtoCartBtn();
		logInfo("validation starts");
		ct.ValidatingCartItem();
		

		RemovingCartItemsPage rm=new RemovingCartItemsPage(driver);
		rm.deletingFunctionality();
		logInfo("item removed ");
		rm.Confirmationpopup();
		WebElement popupMessg=rm.Validation();
		waitForElement(popupMessg);
		messageDisplayed=false;
		String message=rm.ValidationMessageVerfying();
		if(message!=null) {
			messageDisplayed=true;
		}
		System.out.println(message);
		Assert.assertTrue(messageDisplayed);
		logInfo("===Validation done ====");
	}
	
	

}

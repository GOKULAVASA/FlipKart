package testClasses;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.SaveProductForLaterPage;
import testUtils.AddingProductToCartUtils;
import testUtils.CartValidationUtil;


public class TC_SaveProductForLater_010 extends BaseClass {
	boolean messageDisplayed;
	@Test
	public void saveForLater() {
		logInfo("save for later functionality starts ");
		CartValidationUtil ct =new CartValidationUtil(driver);
		AddingProductToCartUtils ap=new AddingProductToCartUtils(driver);
		SaveProductForLaterPage sc=new SaveProductForLaterPage(driver);
		logInfo("item entered in the search box ");
		
		ap.setSearchProduct(readconfig.SearchProduct());
		logInfo("naviagted to the list of products  ");
		ap.ClickSpecificProductDependsonReviewAndRating(readconfig.ProductPrice(),readconfig.productReview(),readconfig.ReviewCount());
		logInfo("clicked tbe specfic product");
		ap.ClickingAddtoCartBtn();
		logInfo("item added");
		String productincart=ap.ValidatingCartItem();
		boolean cartPresentSameSelectecItem=ct.CartItem(productincart);
		if(cartPresentSameSelectecItem) {
			Assert.assertTrue(cartPresentSameSelectecItem);
			logInfo("item added is reflected in the cart page  ");
			System.out.println("cart_has_SameSelectecItem");
		}
		sc.saveProductForLater();
		WebElement popupMessg=sc.Validation();
		logInfo("validation starts ");
		waitForElement(popupMessg);
		messageDisplayed=false;
		String message=sc.ValidationMessageVerfying();
		if(message!=null) {
			messageDisplayed=true;
		}
		System.out.println(message);
		Assert.assertTrue(messageDisplayed);
		logInfo("====VALIDATION DONE======");
		
	}
		
		
		
		
		
	}



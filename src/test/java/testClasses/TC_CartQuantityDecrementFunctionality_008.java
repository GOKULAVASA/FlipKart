package testClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.QuantitydecrementFunctionalityinCartPage;
import testUtils.AddingProductToCartUtils;

public class TC_CartQuantityDecrementFunctionality_008 extends BaseClass {
	String Messagescript;
	@Test
	public void CartQuantity_Sub_In_Functionality() {
		logInfo("Cart Sub-on verification starts");
		boolean validation;
		boolean script;
		AddingProductToCartUtils ct=new AddingProductToCartUtils(driver);
		QuantitydecrementFunctionalityinCartPage qt=new QuantitydecrementFunctionalityinCartPage(driver);
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
		try {
			logInfo("clciked the Sub-ON BTN ");
			qt.DcrementalBtn();
			WebElement confirmationPopUp = qt.confirmationMessage();
			waitForElement(confirmationPopUp);
			String Messagescript=qt.validation();
			System.out.println(Messagescript);
			logInfo("Verfied the Message");
		} catch (Exception e) {
			System.out.println("Minimum quantity is one.");
		}
		
		
		 
				System.out.println(Messagescript);
				if(Messagescript!=null) {
					script=true;
					Assert.assertTrue(script);
				}
				validation= false;
			String Qty=	qt.QuantityOfSpecficProduct();
				String priceOnCart= qt.priceOnTag();
				System.out.println("quantity :"+Qty+" "+"price "+priceOnCart);
				
				String totalAmt=qt.GrantTotal();
				System.out.println(totalAmt);
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



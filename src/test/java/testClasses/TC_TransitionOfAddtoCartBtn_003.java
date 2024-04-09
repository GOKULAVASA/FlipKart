package testClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageClasses.AddtoCartBtnTransitionPage;

public class TC_TransitionOfAddtoCartBtn_003 extends BaseClass {
	Boolean cart;
	String CurrentStateofAddToCart;
	@Test
	public void transitioningAddTOCart() throws InterruptedException, IOException {
		AddtoCartBtnTransitionPage addcart=new AddtoCartBtnTransitionPage(driver);
		logInfo("transition of add to cart button verification ");
		addcart.ClickSearchBox(readconfig.SearchProduct());
		logInfo(" entered the product");
		addcart.setSearchProduct();	
		logInfo("navigated to the spefic product ");
		addcart.SelectingProduct();
		logInfo(" selected the product");
		try {
		 CurrentStateofAddToCart=addcart.StateOfAddToCart();
		
    } catch (StaleElementReferenceException e) {
    	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
    }
		String windowafterclickedCartBtn=driver.getWindowHandle();
		System.out.println(windowafterclickedCartBtn);
		   driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
			String windowafterclickedCartBtn2=driver.getWindowHandle();
			System.out.println(windowafterclickedCartBtn2);
			System.out.println("backk");
			WebElement ele=addcart.TranstitionOfAddToCart();
			waitForElement(ele);
			String TranstitionStateofAddToCart=addcart.validation();
			cart=false;
			if(CurrentStateofAddToCart!=TranstitionStateofAddToCart) {
				cart=true;
				System.out.println(TranstitionStateofAddToCart);
			}else {
				CaptureScreenShot(driver,"transitioningAddTOCart");
			}
			
			Assert.assertTrue(cart);
			logInfo(" ADD TO CART =====> GO TO CART ");
			logInfo("====== VALIDATION DONE ====== ");
		
		
		
		
		
		
	}

}

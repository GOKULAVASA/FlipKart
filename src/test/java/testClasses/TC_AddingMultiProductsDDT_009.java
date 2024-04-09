package testClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageClasses.AddingMultipleProductstoCartPage;
import testUtils.AddingProductToCartUtils;
import testUtils.CartValidationUtil;
import testUtils.XLUtils;



public class TC_AddingMultiProductsDDT_009 extends BaseClass {
	boolean update;
	String countBefore;
	String currentWindow;
	int currentIndex;

	AddingMultipleProductstoCartPage adp;
	@Test(dataProvider = "Searchitem")
	public void addingMultiProducts(String item) throws InterruptedException {
		logInfo("Adding multiple products in the cart is started");
		adp =new AddingMultipleProductstoCartPage(driver);
		AddingProductToCartUtils ct=new AddingProductToCartUtils(driver);
		CartValidationUtil val =new CartValidationUtil(driver);
		AddingMultipleProductstoCartPage at=new AddingMultipleProductstoCartPage(driver);
		ct.setSearchProduct(item);
		logInfo("entered the product and clicked enter");
		ct.ClickSpecificProductDependsonReviewAndRating(readconfig.ProductPrice(),readconfig.productReview(),readconfig.ReviewCount());
		logInfo("clicked the product ---> will navigate to product details page");
		update=false;

		Boolean Beforecount=at.cartcountbefore();

		if (Beforecount) {
			countBefore= at.Count();
			logInfo("counting cart nums");
			System.out.println("Cart Count :"+countBefore);
		} else {
			
			System.out.println("cart is not visible");
		}

		logInfo("navigating between windowss");



		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		System.out.println(windowHandlesList);
		int windowsCount=windowHandlesList.size();
		System.out.println("windows count:"+windowsCount);

		if(windowsCount<=2) {
			logInfo("adding 1st product");
			currentWindow = driver.getWindowHandle();
			System.out.println(currentWindow);
			System.out.println(currentIndex);
			for (int i = 0; i < windowHandlesList.size(); i++) {
				String windowHandle = windowHandlesList.get(i); // Accessing window handle using loop variable 'i'
				if (!windowHandle.equals(currentWindow)) {
					System.out.println("Switching to new window...");
					driver.switchTo().window(windowHandle);
					String newWindow = driver.getWindowHandle();
					System.out.println("New window handle: " + newWindow);
                try {
					at.addToCart().click();
					logInfo("cart clicked");
					currentIndex++; // Increment currentIndex to move to the next window handle
					break;
				}catch(StaleElementReferenceException e) {
					driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
				}
                }
			}
		}else if(windowsCount<=3) {
			logInfo("adding 2nd product");
			currentWindow = driver.getWindowHandle();
			System.out.println(currentWindow);
			for (int i = 0; i < windowHandlesList.size(); i++) {
				String windowHandle = windowHandlesList.get(i); 

				if(i>1) {
					if (!windowHandle.equals(currentWindow)) {
						System.out.println("Switching to new window...");
						driver.switchTo().window(windowHandle);
						String newWindow = driver.getWindowHandle();
						System.out.println("New window handle: " + newWindow);

						try {
							at.addToCart().click();
							logInfo("cart clicked");
							currentIndex++; // Increment currentIndex to move to the next window handle
							break;
						}catch(StaleElementReferenceException e) {
							driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
						}
					}
				}


			}
		}else if(windowsCount<=4) {
			logInfo("adding 3rd product");
			currentWindow = driver.getWindowHandle();
			System.out.println(currentWindow);
			for (int i = 0; i < windowHandlesList.size(); i++) {
				String windowHandle = windowHandlesList.get(i); 

				if(i>2) {
					if (!windowHandle.equals(currentWindow)) {
						System.out.println("Switching to new window...");
						driver.switchTo().window(windowHandle);
						String newWindow = driver.getWindowHandle();
						System.out.println("New window handle: " + newWindow);

						try {
							at.addToCart().click();
							logInfo("cart clicked");

							currentIndex++; // Increment currentIndex to move to the next window handle
							break;
						}catch(StaleElementReferenceException e) {
							driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
						}
					}
				}


			}

		}
		logInfo("VALIDATION STARTS.....");

		String product =ct.ValidatingCartItem();
		val.CartItem(product);
		logInfo("icon update checking ");
		String Aftercount=val.cartIconUpdate();
		System.out.println(Aftercount);
		if(countBefore!=Aftercount) {
			update = true;
			
			Assert.assertTrue(update);
			logInfo("=======VALIDATION GOT PASSESD=========");
			System.out.println("after adding the product ...Cart is updated ");
		}









		System.out.println("=======================================================");
		Thread.sleep(5000);	


	}


	@DataProvider(name = "Searchitem")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/testData/SearchProduct.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
		String[][] Searchitem = new String[rownum][colnum];
		System.out.println(rownum +" rows"+colnum +" coloumns");
		for (int r = 1; r <= rownum; r++) {
			for (int c = 0; c < colnum; c++) {
				Searchitem[r - 1][c] = XLUtils.getCellData(path, "Sheet1", r, c);
			}
		}

		return Searchitem;
	}
}

package pageClasses;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ValidatingCartProductsPage   {
	WebDriver driver;
	String currentwindow;
	String productName;
	public ValidatingCartProductsPage(WebDriver remotedriver) {
	driver=	remotedriver;
		PageFactory.initElements(remotedriver,this);
	}
	
	@FindBy(xpath="//input[@name='q']")
	WebElement SearchBox;

	@FindBy(xpath="//div[@class='gUuXy- _2D5lwg']/span/div")
	List<WebElement> SearchProduct;
	
	@FindBy(xpath="//a[@class='s1Q9rs']")
	List<WebElement> ProductName;
	
	@FindBy(xpath="//div[@class='_25b18c']//div[@class='_30jeq3']")
	List<WebElement> ProductPrice;
	
	@FindBy(xpath="//span[@class='_2_R_DZ']")
	List<WebElement> ProductReviewCount;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement AddToCartBtn;

	@FindBy(xpath="//div[@class='zab8Yh _10k93p']/div[1]/div[1]/div[1]/a")
	WebElement validatingCartItem;
	
	public void setSearchProduct(String product ) {
		SearchBox.sendKeys(product,Keys.ENTER);
	}

	public String ClickSpecificProductDependsonReviewAndRating(String PriceofProduct,String proReview ,String Count) {
		
		try {
	    for (int i = 0; i < SearchProduct.size(); i++) {
	        WebElement product = SearchProduct.get(i);
	        WebElement name = ProductName.get(i);
	        WebElement price = ProductPrice.get(i);
	       WebElement ReviewCount=ProductReviewCount.get(i);
	        
	         productName = name.getText();
	         double productprice = parsePrice(price.getText());
	         double productReview = Double.parseDouble(product.getText());
	        int count=Integer.parseInt(ReviewCount.getText().replaceAll("[(),]",""));
	        boolean meetsPriceCriteria = productprice >= Double.parseDouble(PriceofProduct);
            boolean meetsReviewCriteria = productReview >= Double.parseDouble(proReview);
            boolean meetsCountCriteria = count >= Integer.parseInt(Count);

            if ((meetsPriceCriteria && meetsReviewCriteria) || meetsCountCriteria) {
                System.out.println("Product Name: " + productName);
                System.out.println("Price: Rs" + productprice);
                System.out.println("Review: " + productReview);
                System.out.println("count : " + count);
                name.click();
                break;
            }else {
            	System.out.println("no record  match ");
            }
	      
	    } 
		}catch (StaleElementReferenceException e) {
            System.out.println("Stale element encountered, refreshing page...");
            driver.navigate().refresh();
            SearchProduct = driver.findElements(By.xpath("//div[@class='gUuXy- _2D5lwg']/span/div"));
            ProductName = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
	    }
		return productName;
	}
	    public void ClickingAddtoCartBtn() {
	    	try {
	    	Set<String> windowHandles = driver.getWindowHandles();
	    	System.out.println(windowHandles);
	    	String currentWindow = driver.getWindowHandle();
	    	System.out.println(currentWindow);

	    	for (String windowHandle : windowHandles) {
	    	    if (!windowHandle.equals(currentWindow)) {
	    	        System.out.println("Switching to new window...");
	    	        driver.switchTo().window(windowHandle);
	    	        String newWindow = driver.getWindowHandle();
	    	        System.out.println("New window handle: " + newWindow);
	    	        break;
	    	    }
	    	    
	    	}

	    	AddToCartBtn.click();
			
	    }catch (StaleElementReferenceException e) {
            System.out.println("Stale element encountered this , refreshing page...");
            driver.navigate().refresh();
            AddToCartBtn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
            
	    }
	    
	    }
	    
	    
	    public WebElement ValidatingCartItem() {
	    	WebElement productInCart   =validatingCartItem;

	        return productInCart; 
	        }
	    
	    
private double parsePrice(String priceText) {
    // Remove any non-numeric characters from the price text
    String cleanPriceText = priceText.replaceAll("[^\\d.]", "");
    // Parse the cleaned price text into a double
    return Double.parseDouble(cleanPriceText);
}
}
	
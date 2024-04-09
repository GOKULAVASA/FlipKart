package testUtils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class CartValidationUtil {
	private WebDriver driver ;
	 boolean itempresent;
	 ReadConfig readconfig=new ReadConfig();
	 public WebDriverWait wait;
	 public CartValidationUtil(WebDriver remotedriver) {
	        this.driver = remotedriver;
	    }
	public   boolean CartItem(String productname) {
	
		 itempresent = false;
	        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='_2-uG6-']//a"));
	        for (WebElement product : cartProducts) {
	            String Incart = product.getText();
	            System.out.println("In_cart:"+Incart);
	            if(productname.contains(Incart)) {
	                itempresent = true;
	                break; // Exit the loop once the product is found in the cart
	            }
	        }
	        Assert.assertTrue(itempresent);
	        return true;
	    }
	
	public String cartIconUpdate() {
		
		//driver.findElement(By.xpath("//div[@class='JFPqaw']//span[@role='button']"));
		driver.findElement(By.xpath("//a[@href='/']")).click();
		
		String cartCount=driver.findElement(By.xpath("(//div[@class='_38VF5e'])[2]/a[1]/span")).getText();
		
		return cartCount;
	}
	

	 
	
}
	



package pageClasses;

import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartBtnTransitionPage {

	WebDriver driver ;
	String currentwindow;
	String windowHandle;
	

	public AddtoCartBtnTransitionPage( WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver,this);
	}

	@FindBy(xpath="//input[@name='q']")
	WebElement SearchBox;


	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[3]/div/div[3]/div/a[2]")
	WebElement SearchProduct;

	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement AddToCartBtn;

	
	

	public void ClickSearchBox(String searchProduct) throws InterruptedException {
		 currentwindow=driver.getWindowHandle();
		System.out.println(currentwindow);
		SearchBox.sendKeys(searchProduct,Keys.ENTER);

	}
	
	public void setSearchProduct() {
		SearchProduct.click();
	}

	public String  SelectingProduct() throws InterruptedException {
		Set<String> windowHandles=driver.getWindowHandles();
		System.out.println(windowHandles);
		 for (String windowHandle : windowHandles) {
	            if (!windowHandle.equals(currentwindow)) {
	                driver.switchTo().window(windowHandle);
	           
	                break;
	         
	            }          
		 }
		return windowHandle;
		 
	}
	
	public String  StateOfAddToCart() {
		String ADDtoCartState= AddToCartBtn.getText();
		System.out.println(ADDtoCartState);
		AddToCartBtn.click();
		return ADDtoCartState;
	}
		
	public WebElement  TranstitionOfAddToCart() {
		 
		return AddToCartBtn;
	}
		
	public String validation() {
		String TransitionedState=AddToCartBtn.getText();
		return TransitionedState;
	}

}

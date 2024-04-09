package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingMultipleProductstoCartPage {
	WebDriver driver;
	public AddingMultipleProductstoCartPage( WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver,this);
	}

	@FindBy(xpath = "//a[@class='_3SkBxJ']//div")
	private WebElement BeforeCartCount;

	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement addToCartBtn;

	public Boolean  cartcountbefore() {
		return isBeforeCartCountPresent();

	}
	public String  Count() {
		return BeforeCartCount.getText();

	}

	public WebElement addToCart() {
		return addToCartBtn;
	}
	public boolean isBeforeCartCountPresent() {
		try {
			// Attempt to find the element, if found return true
			return BeforeCartCount.isDisplayed();
		} catch (Exception  e) {
			// If element is not found, return false
			return false;
		}
	}


}

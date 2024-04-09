package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartDisplayedAndApplicablePage {
WebDriver localdriver;

	public CartDisplayedAndApplicablePage(WebDriver remote ) {
		localdriver=remote ;
		PageFactory.initElements(remote, this);
		
	}
	
	@FindBy(xpath="(//div[@class='_38VF5e'])[2]/a[1]")
	WebElement CartIcon;
	
	
	public WebElement  isCartDisplayed() {
		
	return CartIcon;
		 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package pageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemovingCartItemsPage  {
	WebDriver driver ;
	JavascriptExecutor js;
	
	

	public RemovingCartItemsPage( WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver,this);
		  js = (JavascriptExecutor) driver;
	}
	@FindBy(xpath="//div[@class='_3dsJAO'][2]")
	WebElement removeBtn;
	
	@FindBy(xpath="//div[@class='_3fSRat']//div//a")
	WebElement cartProduct;
	
	
	@FindBy(xpath="//div[@class='row _1lPa3S']//div[1]//div[2]")
	WebElement confirmationpopUp;
	
	
	
	@FindBy(xpath="//div[@class='_2sKwjB']")
	WebElement validationMessage;
	
	public  void deletingFunctionality() {
		
		 js.executeScript("window.scrollBy(0,700)");
		 removeBtn.click();
		
	}
	public void  Confirmationpopup() {
	confirmationpopUp.click();
}
	
	public WebElement  Validation() {
		WebElement ele=validationMessage;
		return ele;
}
	
	public String  ValidationMessageVerfying() {
		String ele=validationMessage.getText();
		return ele;
}
	
	
	
}

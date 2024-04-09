package pageClasses;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuantityAddonFunctionalityinCartPage {
	WebDriver driver;
	JavascriptExecutor  js;
	public QuantityAddonFunctionalityinCartPage(WebDriver remotedriver) {
		     driver=	remotedriver;
			PageFactory.initElements(remotedriver,this);
			js= (JavascriptExecutor )driver;
		}

	@FindBy(xpath="(//div[@class='_3dY_ZR'])[1]//button[2]")
	WebElement AddOnBtn;
	
	@FindBy(xpath="//div[@class='_2sKwjB']")
	WebElement ConfirmationMessage;
	
	@FindBy(xpath="//div[@class='_26HdzL']//input")
	WebElement Quantity;

	@FindBy(xpath="//span[@class='_2-ut7f _1WpvJ7']")
	WebElement priceTag;
	
	
	
	@FindBy(xpath="//div[@class='Ob17DV _3X7Jj1']//div[2]//span")
	WebElement grantTotal;
	
	public void IncrementalBtn() {
		js.executeScript("window.scrollBy(0,700)");
		AddOnBtn.click();
		
	}
	
	public WebElement confirmationMessage() {
		return ConfirmationMessage;
		
		 
	}
	public String validation() {
		        return ConfirmationMessage.getText();
		
	}
    
	public String priceOnTag() {
        return priceTag.getText();

}
public String QuantityOfSpecficProduct() {
	return Quantity.getAttribute("value");
}

public String GrantTotal() {
	return grantTotal.getText();
}

}

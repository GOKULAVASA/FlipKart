package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveProductForLaterPage {
WebDriver driver;
	
	public SaveProductForLaterPage( WebDriver remotedriver) {
		driver=remotedriver;
		PageFactory.initElements(remotedriver,this);
		driver.manage().window().maximize();
	}
	 @FindBy(xpath = "//div[@class='nZz3kj _1hNI6F']//div[2]//div[1]")
	    private WebElement selectForLaterLink;
	 @FindBy(xpath="//div[@class='_2sKwjB']")
		WebElement validationMessage;
	 
	public void saveProductForLater() {
		selectForLaterLink.click();
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

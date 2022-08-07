package zerodhaClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Utils;

public class PinPage {
	
	@FindBy (id="pin") private WebElement pin;
	@FindBy (xpath="//button[@type='submit']") private WebElement continue_button;
	
	public PinPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void enterPin() throws EncryptedDocumentException, IOException {
		String data = Utils.fetchData("Sheet1", 2, 0);
		pin.sendKeys(data);
	}
	public void clickContinueButton() {
		continue_button.click();
	}
	

}

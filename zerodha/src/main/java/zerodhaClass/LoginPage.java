package zerodhaClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Utils;

public class LoginPage {
	
	@FindBy (id="userid") private WebElement userId;
	@FindBy (id="password") private WebElement pass;
	@FindBy (xpath="//button[@type='submit']") private WebElement login;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId() throws EncryptedDocumentException, IOException {
		String data = Utils.fetchData("Sheet1", 0, 0);
		userId.sendKeys(data);
	}
	
	public void enterPassword() throws EncryptedDocumentException, IOException {
		String data = Utils.fetchData("Sheet1", 1, 0);
		pass.sendKeys(data);
	}
	
	public void clickLoginButton() {
		login.click();
	}

}

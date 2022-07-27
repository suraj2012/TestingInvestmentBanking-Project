package zerodhaClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile {
	@FindBy (xpath="//a[@target='_self']") private WebElement logout;
	
	public Profile(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnLogout() {
		logout.click();
	}

}

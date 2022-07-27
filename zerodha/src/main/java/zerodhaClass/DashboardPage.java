package zerodhaClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	@FindBy (xpath="//a[@href='/orders']") private WebElement orders;
	@FindBy (xpath="//a[@href='/holdings']") private WebElement holding;
	@FindBy (xpath="//a[@href='/positions']") private WebElement position;
	@FindBy (xpath="//span[@class='user-id']") private WebElement profileId;
	
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickOnOrders() {
		orders.click();
	}
	public void clickOnHolding() {
		holding.click();
	}
	public void clickOnPostion() {
		position.click();
	}
	public void clickOnProfileId() {
		profileId.click();
	}
	

}

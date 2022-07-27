package zerodhaTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browser.Base;
import zerodhaClass.DashboardPage;
import zerodhaClass.LoginPage;
import zerodhaClass.PinPage;
import zerodhaClass.Profile;

public class TestClass extends Base {
	WebDriver driver;
	LoginPage lp;
	PinPage pp;
	DashboardPage dp;
	Profile p;
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String Browser) {
		if (Browser.equals("Chrome")) {
			driver = openChromeBrowser();
		}
		if (Browser.equals("Firefox")) {
			driver = openFirefoxBrowser();
		}
	}
	@BeforeClass
	public void pomObjects() {
		lp = new LoginPage(driver);
		pp = new PinPage(driver);
		dp = new DashboardPage(driver);
		p = new Profile(driver);
	}
	
	@BeforeMethod
	public void launchLoginPage() throws InterruptedException, EncryptedDocumentException, IOException {
		driver.get("https://kite.zerodha.com/");
		lp.enterUserId();
		lp.enterPassword();
		lp.clickLoginButton();
		Thread.sleep(2000);
		
		pp.enterPin();
		pp.clickContinueButton();
		Thread.sleep(2000);
	}
	
	@Test (priority=0)
	public void testVerifyOrdersLink() throws InterruptedException {
		
		dp.clickOnOrders();
		String orders_Url=driver.getCurrentUrl();
		
		Assert.assertEquals(orders_Url, orders_Url);
	}
	@Test (priority=1)
	public void testVerifyHoldingLink() throws InterruptedException {
		
		dp.clickOnHolding();
		String holding_Url=driver.getCurrentUrl();
		
		Assert.assertEquals(holding_Url, holding_Url);
	}
	@Test (priority=2)
	public void testVerifyPositionLink() throws InterruptedException {
		
		dp.clickOnPostion();;
		String position_Url=driver.getCurrentUrl();
		
		Assert.assertEquals(position_Url, position_Url);
	}
	@AfterMethod
	public void logoutPage() throws InterruptedException {
		Thread.sleep(3000);
		dp.clickOnProfileId();
		
		p.clickOnLogout();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Change user']")).click();
	}
	
	@AfterClass
	public void  closeObjects() throws InterruptedException {
		lp = null;
		dp = null;
		pp = null;
		p = null;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
		
		driver = null;
		System.gc();
	}
	

}

package Debijonkorf.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import Debijonkorf.PageModels.AccountPage;
import Debijonkorf.PageModels.BottomBarNavigation;
import Debijonkorf.PageModels.CartPage;
import Debijonkorf.PageModels.HomePage;
import Debijonkorf.PageModels.LoginPage;
import Debijonkorf.PageModels.SupCategoryPage;

public class BaseTest {
	
	public DesiredCapabilities dc = new DesiredCapabilities();

	public HomePage homePage;
	public LoginPage loginPage;
	public AccountPage accountPage;
	public BottomBarNavigation NavigationBar;
	public SupCategoryPage subcategorypage;
	public CartPage cartPage;
	public AndroidDriver<MobileElement> driver = null;

	@BeforeSuite()
	public void StartDriver() throws Throwable {
		dc.setCapability("udid", "ce0117115bdf663005");
		dc.setCapability("app", System.getProperty("user.dir")+"\\APK\\de Bijenkorf_nl.debijenkorf.apk");
		dc.setCapability("deviceName", "SM-G935FD");
		dc.setCapability("platformName", "Android");
		dc.setCapability("appPackage", "nl.debijenkorf");
		dc.setCapability("appActivity", ".activities.common.SplashScreen");
		dc.setCapability("fullReset", false);
		driver = new AndroidDriver<MobileElement>(new URL(
				"http://0.0.0.0:4723/wd/hub"), dc);
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		accountPage = new AccountPage(driver);
		subcategorypage = new SupCategoryPage(driver);
		NavigationBar = new BottomBarNavigation(driver);
		cartPage = new CartPage(driver);
	}
	
	

}

package Debijonkorf.PageModels;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	
	public HomePage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id = "nl.debijenkorf:id/push_comm")
	private AndroidElement ToggleBtn;
	
	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement PreAcceptCookieBtn;
	
	@AndroidFindBy(id = "nl.debijenkorf:id/btn_yes")
	private AndroidElement AcceptCookieBtn;
	
	@AndroidFindBy(id = "nl.debijenkorf:id/btnBrandsLogin")
	private AndroidElement InlogginBTN;
	
	public void AcceptCookies()
	{
		WaitAndTab(PreAcceptCookieBtn);
		AcceptCookieBtn.click();
	}
	
	public void tabOnLogin()
	{
		SwipeVertically(0.6, 0.3, 0.5);
		InlogginBTN.click();
	}
	
	
}

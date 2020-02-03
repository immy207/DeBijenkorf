package Debijonkorf.PageModels;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

	public LoginPage(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id = "nl.debijenkorf:id/inputEmail")
	private AndroidElement Mail;

	@AndroidFindBy(id = "nl.debijenkorf:id/inputPassword")
	private AndroidElement Password;

	@AndroidFindBy(id = "nl.debijenkorf:id/loginButton")
	private AndroidElement LoggInBtn;
	
	public void UserEnterLoginCredintiols(String Mail,String Password) throws Throwable
	{
		this.Mail.sendKeys(Mail);
		this.Password.sendKeys(Password);
		this.LoggInBtn.click();
		Thread.sleep(4000);
	}
	
}

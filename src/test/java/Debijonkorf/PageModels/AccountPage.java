package Debijonkorf.PageModels;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AccountPage extends BasePage {

	public AccountPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	public void swibeToCategories()
	{
		SwipeVertically(0.6, 0.1, 0.5);
	}
	
	public void SelectCategory(String Category) throws Throwable
	{
		String elm = "//androidx.recyclerview.widget.RecyclerView[@resource-id='nl.debijenkorf:id/recyclerCategories']//android.widget.TextView[@text='%s']/parent::android.widget.LinearLayout";
		String category = String.format(elm, Category);
		Thread.sleep(2000);
		driver.findElement(By.xpath(category)).click();
	}
	
	
	
}

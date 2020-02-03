package Debijonkorf.PageModels;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends BasePage{

	public CartPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "nl.debijenkorf:id/navigation_search")
	private AndroidElement CartSearchBtn;
	
	@AndroidFindBy(id = "nl.debijenkorf:id/edittext_search")
	private AndroidElement CartSearchBox;
	
	@AndroidFindBy(id = "nl.debijenkorf:id/title")
	private AndroidElement PurchasedItemTitle;
	
	@AndroidFindBy(id = "nl.debijenkorf:id/price")
	private AndroidElement PurchasedItemPrice;
	
	public String GetPurchasedItemTitle()
	{
		return PurchasedItemTitle.getText();
	}
	
	public String GetPurchasedItemPrice()
	{
		return PurchasedItemPrice.getText();
	}
	
	public void SearchInCart(String SearchItem) throws Throwable
	{
		WaitAndTab(CartSearchBtn);
		Thread.sleep(2000);
		CartSearchBox.sendKeys(SearchItem);
		PressEnter();
	}

}

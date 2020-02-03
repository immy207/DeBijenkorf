package Debijonkorf.PageModels;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BottomBarNavigation extends BasePage {

	public BottomBarNavigation(AndroidDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id = "nl.debijenkorf:id/navigation_home")
	private AndroidElement Home;

	@AndroidFindBy(id = "nl.debijenkorf:id/navigation_search")
	private AndroidElement Search;

	@AndroidFindBy(id = "nl.debijenkorf:id/navigation_wishlist")
	private AndroidElement WishList;

	@AndroidFindBy(id = "nl.debijenkorf:id/navigation_cart")
	private AndroidElement Cart;

	public void MenuBarNavigateTo(String menu) throws Throwable {
		if (menu.equals("home")) {
			Home.click();
			Thread.sleep(3000);
		}else if (menu.equals("Search")) {
			Search.click();
			Thread.sleep(3000);
		}else if (menu.equals("WishList")) {
			WishList.click();
			Thread.sleep(3000);
		}else if (menu.equals("Cart")) {
			Cart.click();
			Thread.sleep(3000);
		}
	}

}

package Debijonkorf.Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Debijonkorf.Utilities.Constants;

public class AddToCartTest extends BaseTest {

	@Test
	public void f() throws Throwable {
		SoftAssert softAssert = new SoftAssert();

		// user accept Cookies
		homePage.AcceptCookies();

		// user tab on login to enter login page
		homePage.tabOnLogin();

		// user enter login credintiols
		loginPage.UserEnterLoginCredintiols(Constants.UserName,
				Constants.Password);

		// user swipe to access Categories Page
		accountPage.swibeToCategories();

		// user swipe to access Categories Page
		accountPage.SelectCategory(Constants.DemasCategory);
		
		// user select desired Sup-Category
		subcategorypage.SelectSupCategory(Constants.SuBCat_DemasHomePage);
		
		// user select the product
		subcategorypage.SelectProductFromDisplayedItems();
		
		// saving product name for the final assertion
		String ProductName = subcategorypage.GetProductName();
		
		// saving product price for the final assertion
		String ProductPrice = subcategorypage.GetProductPrice();
		
		// add product to the cart 
		subcategorypage.AddProductToCart();
		
		// navigate to the cart
		NavigationBar.MenuBarNavigateTo(Constants.CartIcon);
		
		// final assertions to verify the expeceted result by comparing the data pre-purchase with post purchase
		String PurchasedProduectName = cartPage.GetPurchasedItemTitle();
		softAssert.assertEquals(ProductName, PurchasedProduectName);
		softAssert.assertEquals(ProductPrice, cartPage.GetPurchasedItemPrice());
		softAssert.assertAll();
	}

}

package Debijonkorf.PageModels;
import java.util.Random;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class SupCategoryPage extends BasePage{

	public SupCategoryPage(AndroidDriver<MobileElement> driver) {
		super(driver);	
	}
	
	private String ProductSize_;
	
	@AndroidFindBy(id = "nl.debijenkorf:id/toolbarTitle")
	private AndroidElement ProductTitle;
	
	@AndroidFindBy(id = "nl.debijenkorf:id/oldPrice")
	private AndroidElement ProductPrice;

	@AndroidFindBy(id = "nl.debijenkorf:id/recyclerView")
	private AndroidElement ProductList;
	
	@AndroidFindBy(id = "nl.debijenkorf:id/btnCart")
	private AndroidElement AddToCartBtn;
	
	@AndroidFindBy(id = "nl.debijenkorf:id/btnSort")
	private AndroidElement SortBtn;
	
	
	public void SelectSupCategory(String Category) throws Throwable
	{
		String elm = "//android.widget.TextView[@text='%s']";
		String category = String.format(elm, Category);
		Thread.sleep(2000);
		driver.findElement(By.xpath(category)).click();
	}
	
	public void SelectProductFromDisplayedItems() throws Throwable
	{
		WaitUntillElementDisplayed(ProductList);
		Thread.sleep(5000);
		int ProductsCount = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='nl.debijenkorf:id/recyclerView']/android.widget.LinearLayout")).size();
		System.out.println(ProductsCount);
		Random rand = new Random(); 
		int selectedProduct = rand.nextInt(ProductsCount) + 1;
		System.out.println(selectedProduct);
		String ProductCount = Integer.toString(selectedProduct);
		String ProductIndex = "(//androidx.recyclerview.widget.RecyclerView[@resource-id='nl.debijenkorf:id/recyclerView']/android.widget.LinearLayout)[%s]";
		String Product = String.format(ProductIndex, ProductCount);
		driver.findElement(By.xpath(Product)).click();
		Thread.sleep(4000);
	}
	
	public String GetProductName()
	{
		return ProductTitle.getText();
	}
	
	public String GetProductPrice()
	{
		return ProductTitle.getText();
	}
	
	public String GetProductSize()
	{
		return ProductSize_;
	}
	
	public void AddProductToCart() throws Throwable
	{
		SwipeVertically(0.7, 0.1, 0.5);
		AddToCartBtn.click();
		int ProductsCount = driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='nl.debijenkorf:id/recycler_view_sizes']//android.widget.TextView")).size();
		System.out.println(ProductsCount);
		Random rand = new Random(); 
		int selectedProduct = rand.nextInt(ProductsCount) + 1;
		System.out.println(selectedProduct);
		String ProductCount = Integer.toString(selectedProduct);
		String ProductIndex = "(//androidx.recyclerview.widget.RecyclerView[@resource-id='nl.debijenkorf:id/recycler_view_sizes']//android.widget.TextView)[%s]";
		String Product = String.format(ProductIndex, ProductCount);
		String ProductSize = driver.findElement(By.xpath(Product)).getText();
		this.ProductSize_ = ProductSize;
		driver.findElement(By.xpath(Product)).click();
		WaitUntillElementDisplayed(SortBtn);
		Thread.sleep(4000);
	}
	
	
	
	
	
	
	
}

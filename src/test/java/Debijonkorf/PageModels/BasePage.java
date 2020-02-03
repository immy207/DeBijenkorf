package Debijonkorf.PageModels;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public AndroidDriver<MobileElement> driver = null;

	public WebDriverWait wait;

	public BasePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.wait = new WebDriverWait(this.driver, 10);
	}

	protected void WaitAndTab(AndroidElement elm) {
		wait.until(ExpectedConditions.elementToBeClickable(elm)).click();
	}
	
	protected void WaitUntillElementNotDisplayed(AndroidElement elm) {
		wait.until(ExpectedConditions.invisibilityOf(elm));
	}
	
	protected void PressEnter() {
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.ENTER);
	}
	
	protected void WaitUntillElementDisplayed(AndroidElement elm) {
		wait.until(ExpectedConditions.visibilityOf(elm));
	}

	protected void SwipeVertically(double startPercentage,
			double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * endPercentage);

		new TouchAction(driver).press(point(anchor, startPoint))
				.waitAction(waitOptions(ofMillis(1000)))
				.moveTo(point(anchor, endPoint)).release().perform();
	}

	protected void HideKeyboard(AndroidDriver<MobileElement> driver) {

		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	}
}

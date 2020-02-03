package Debijonkorf.Utilities;

import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	//Method to take ScreenShot when the test cases fail
		public static void CaptureScreenShot(WebDriver driver,String ScreenShotName)
		{
			Path dest =Paths.get("./ScreenShots/ScreenShoots"+ScreenShotName+".PNG");
			try {
				Files.createDirectories(dest.getParent());
				FileOutputStream out=new FileOutputStream(dest.toString());
				out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
				out.close();
			} catch (IOException e) {

				System.out.println("Exception while taking screenshot"+e.getMessage());
			}

		 } 
}

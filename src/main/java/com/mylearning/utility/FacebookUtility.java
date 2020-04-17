package com.mylearning.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FacebookUtility {
	
	//to take the screenshot
	public static void screenshoot(WebDriver driver) {
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Src =ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Src, new File("E:\\WORK\\MyFrameworkDesign\\Screenshot/"+System.currentTimeMillis()+"facebook.png"));
			System.out.println("***************Screenshot taken*********");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}

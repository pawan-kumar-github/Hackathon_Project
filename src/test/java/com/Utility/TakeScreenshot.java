package com.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	
public static void screenshot(WebDriver driver, String ssName) throws IOException {
		
		//THIS CONVERTS THE WEBDRIVER OBJECT TO TAKESCREENSHOT AND CALLS GETSCREENSHOTAS METHOD TO CREATE AN IMAGE FILE 
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 																						 
																																									
		//THIS COPIES THE CONTENTS OF THE SPECIFIED SOURCE FILE INTO THE CONTENTS OF THE SPECIFIED DESTINATION FILE PRESERVING THE DATA
		FileUtils.copyFile(src, new File("G:\\Projects\\IdentifyNewBikes_Hackathon\\IdentifyNewBikes_Hackathon\\Screenshots\\" + ssName + ".jpg"));
	}

}

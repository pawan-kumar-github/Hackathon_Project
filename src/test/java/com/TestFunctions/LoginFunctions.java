package com.TestFunctions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.TestObjects.LoginObjects;
import com.Utility.ExcelUtils;

public class LoginFunctions {

	public static WebDriver driver;														//THIS WILL CREATE AN OBJECT OF WEBDRIVER
	
	static String mainWindow;															//THIS WILL INSTANTIATE A STATIC STRING
	static String loginWindow;															//THIS WILL INSTANTIATE A STATIC STRING
	static String username;																//THIS WILL INSTANTIATE A STATIC STRING
	
	public static void clickLoginButton(WebDriver driver) {
		LoginObjects.loginOrSignUp(driver).click();										//THIS WILL CLICK ON THE REQUIRED WEBELEMENT OBTAINED FROM THE LOGINOBJECTS CLASS
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				//THIS WILL MAKE THE DRIVER WAIT IMPLICITLY FOR TEN SECONDS IN CASE THE BROWSER DOES NOT LOAD
	}
	
	public static void clickContinueWithGoogle(WebDriver driver) {
		LoginObjects.continueWithGoogle(driver).click();								//THIS WILL CLICK ON THE REQUIRED WEBELEMENT OBTAINED FROM THE LOGINOBJECTS CLASS
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				//THIS WILL MAKE THE DRIVER WAIT IMPLICITLY FOR TEN SECONDS IN CASE THE BROWSER DOES NOT LOAD
	}
	
	public static void shiftToLoginWindow(WebDriver driver) {
		
		Set<String> allWindows = driver.getWindowHandles();								//THIS WILL GET HANDLES OF ALL THE WINDOWS OPEN AND STORE THEM IN A LIST OF STRINGS
		Iterator<String> itr = allWindows.iterator();									//THIS WILL MAKE THE DRIVER ITERATE THROUGH THE ENTIRE SET 
		
		mainWindow = itr.next();														//THIS WILL GET THE HANDLE OF THE NEXT OPEN WINDOW
		loginWindow = itr.next();														//THIS WILL GET THE HANDLE OF THE NEXT OPEN WINDOW
		driver.switchTo().window(loginWindow);											//THIS WILL SWITCH THE CONTROL OF THE DRIVER TO THE LOGIN WINDOW
		
	}
	
	public static void enterInvalidEmail(WebDriver driver) throws Exception {
		username = ExcelUtils.readCellData(1, 0);										//THIS WILL READ DATA FROM THE INPUT EXCEL SHEET
		LoginObjects.emailTextbox(driver).sendKeys(username);							//THIS WILL PASS THE DATA INTO THE SPECIFIED WEBELEMENT
	}
	
	public static void clickNextButton(WebDriver driver) {
		LoginObjects.nextButton(driver).click();										//THIS WILL CLICK ON THE REQUIRED WEBELEMENT OBTAINED FROM THE LOGINOBJECTS CLASS
	}
	
	public static void captureEmailWarning(WebDriver driver) throws Exception {
		
		String emailWarning = LoginObjects.emailMessage(driver).get(0).getText();		//THIS WILL FETCH THE TEXT VALUE OF THE REQUIRED WEBELEMENT FROM THE LOGINOBJECTS CLASS
		
		//System.out.println();
		//System.out.println(emailWarning);
		
		ExcelUtils.writeCellData("Login", 1, 0, emailWarning);							//THIS WILL WRITE THE STRING VALUE INTO THE SPECIFIED SHEET AND INDEX OF THE OUTPUT EXCEL SHEET

	}
	
	public static void closeLoginWindow(WebDriver driver) {
		driver.close();																	//THIS WILL CLOSE THE LOGIN WINDOW
	}
	
	public static void shiftToMainWindow(WebDriver driver) {
		driver.switchTo().window(mainWindow);											//THIS WILL SWITCH THE CONTROL OF THE DRIVER TO THE MAIN WINDOW
	}
}

package com.TestScenarios;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.TestFunctions.BikeFunctions;
import com.TestFunctions.CarFunctions;
import com.TestFunctions.LoginFunctions;
import com.Utility.DriverSetup;
import com.Utility.ExcelUtils;
import com.Utility.TakeScreenshot;
import com.Utility.ExtentReportsFile;
import com.Utility.GetPropertiesFile;


public class TestCase {
	
	public static WebDriver driver;																			//THIS WILL CREATE AN OBJECT OF WEBDRIVER
	public static Properties prop = GetPropertiesFile.getProperties();										//THIS WILL CREATE AN OBJECT OF THE PROPERTIES CLASS AND FETCH THE GETPROPERTIES METHOD
	public static String browser;																			//THIS WILL INSTANTIATE A STRING
	
	public static ExtentReports report;																		//THIS WILL CREATE AN INSTANCE OF THE EXTENTREPORTS CLASS
	public static ExtentTest test;																			//THIS WILL CREATE AN INSTANCE OF THE EXTENTTEST CLASS
	
	@BeforeClass
	//@Parameters("browser")
	public void launchBrowser() throws IOException {														//THIS WILL LAUNCH THE BROWSER
		browser = prop.getProperty("browser");																//THIS WILL FETCH THE PROPERTY BROWSER FROM THE PROPERTIES FILE
		driver = DriverSetup.getWebDriver(browser);															//THIS WILL INVOKE THE BROWSER FROM THE DRIVER SETUP CLASS
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);									//THIS WILL MAKE THE DRIVER WAIT IMPLICITLY FOR TEN SECONDS IN CASE THE BROWSER DOES NOT LOAD
		TakeScreenshot.screenshot(driver, "HomePage");														//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
		report = ExtentReportsFile.getReportInstance();														//THIS WILL INVOKE THE GETREPORTINSTANCE METHOD FROM THE EXTENT REPORTS FILE
		
	}
	
	@Test(priority=0, groups="Regression")
	public void verifyPageTitle() {
		String actualTitle = driver.getTitle();																//THIS WILL GET THE TITLE OF THE CURRENT WEBPAGE
		String expectedTitle = "ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, Forum";		
		Assert.assertEquals(actualTitle, expectedTitle);													//THIS WILL ASSERT IF THE TITLE OF THE WEBPAGE IS VALID
		
		test = report.createTest("Title Verification of WebPage");											//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Get Page Title");															//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Title Verification Successful");												//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
	}
	
	@Test(priority=1, groups= {"Regression", "Smoke"})
	public void hoverOnNewBikes()  {
		BikeFunctions.moveToNewBikes(driver);																//THIS WILL MOVE THE CONTROL TO HOVER ON NEW BIKES
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "New_Bikes");													//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		test = report.createTest("New Bikes");																//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Move mouse to New Bikes and hold for 2 seconds");							//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Mouse Hover Successful");													//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		
	}
	
	@Test(priority=2, groups= {"Regression", "Smoke"})
	public void clickOnUpcomingBikes() {
		BikeFunctions.moveToUpcomingBikes(driver);															//THIS WILL MOVE THE DRIVER AND CLICK ON UPCOMING BIKES
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "Upcoming_Bikes");											//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		test = report.createTest("Upcoming Bikes");															//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Move mouse and click on Upcoming Bikes");									//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Upcoming Bikes selected successfully");										//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE								
		
	}
	
	@Test(priority=3, groups= {"Regression"})
	public void displayManufacturerList() {
		BikeFunctions.clickManufacturer(driver);															//THIS WILL MOVE THE DRIVER TO CLICK ON SELECT MANUFACTURER ELEMENT
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "Manufacturer_List");											//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		test = report.createTest("Select Manufacturer Dropdown");											//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Click on Select Manufacturer to display the list of manufacturers");			//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Select Manufacturer Dropdown successfully displayed");						//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		
	}
	
	@Test(priority=4, groups= {"Regression", "Smoke"})
	public void chooseManufacturer() {
		BikeFunctions.selectManufacturer(driver);															//THIS WILL INVOKE THE METHOD TO SELECT A MANUFACTURER FROM THE DISPLAYED LIST
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "Honda_Bikes");												//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		test = report.createTest("Honda");																	//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Choose Manufacturer Honda from the manufacturer list");						//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Honda is successfully selected");											//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		
	}
	
	@Test(priority=5, groups= {"Regression"})
	public void scrollDownToViewMoreBikes() {
		BikeFunctions.scrollToViewMoreBikes(driver);														//THIS WILL INVOKE THE METHOD TO SCROLL TO THE DESIRED OBJECT
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "View_More_Bikes");											//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=6, groups= {"Regression", "Smoke"})
	public void clickToViewMoreBikes() {
		BikeFunctions.clickViewMoreBikes(driver);															//THIS WILL INVOKE THE METHOD TO CLICK ON THE VIEW MORE BIKES BUTTON
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "All_Bikes");													//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		test = report.createTest("View More Bikes");															//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Click on View More Bikes button to display the entire list of Honda Bikes");		//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Successfully displayed all Honda Bikes");										//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
	
	} 
	
	@Test(priority=7, groups= {"Regression"})
	public void displayBikesUnderFourLakhs() throws InterruptedException, IOException {
		
		BikeFunctions.bikesUnderFourLakhs(driver);																//THIS WILL INVOKE THE METHOD TO DISPLAY ALL HONDA BIKES UNDER FOUR LAKHS
		
		
		test = report.createTest("Bikes under Four Lakhs");														//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Model Name of all Honda Bikes Under Four Lakhs should be displayed");			//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Model Name of all Honda Bikes Under Four Lakhs displayed successfully");			//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		test.log(Status.INFO, "Model Price of all Honda Bikes Under Four Lakhs should be displayed");			//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Model Price of all Honda Bikes Under Four Lakhs displayed successfully");		//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		test.log(Status.INFO, "Model Launch Date of all Honda Bikes Under Four Lakhs should be displayed");		//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Model Launch Date of all Honda Bikes Under Four Lakhs displayed successfully");	//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		
		
		Thread.sleep(2000);																						//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
	}
	
	@Test(priority=8, groups= {"Regression"})
	public void scrollUp() {
		BikeFunctions.scrollToTop(driver);																	//THIS WILL INVOKE THE METHOD TO SCROLL UP THE WEBPAGE
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "New_Cars");													//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=9, groups= {"Regression", "Smoke"})
	public void hoverOnUsedCars() throws InterruptedException {
		CarFunctions.moveToUsedCars(driver);																//THIS WILL INVOKE THE METHOD TO HOVER ON USED CARS
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "Used_Cars");													//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		test = report.createTest("Used Cars");																//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Move mouse to Used Cars and hold for 2 seconds");							//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Mouse Hover Successful");													//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		
	}
	
	@Test(priority=10, groups= {"Regression", "Smoke"})
	public void selectCity() {
		CarFunctions.clickOnChennai(driver);																//THIS WILL INVOKE THE METHOD TO CLICK ON CHENNAI CITY
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "Used_Cars_In_Chennai");										//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		test = report.createTest("Select City");															//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Click on Chennai under City list");											//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "City selected as Chennai successfully");										//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		
	}
	
	@Test(priority=11, groups= {"Regression"})
	public void scrollDownToViewPopularModels() {
		CarFunctions.scrollToPopularModels(driver);															//THIS WILL INVOKE THE METHOD TO SCROLL TO POPULAR MODELS IN THE WEBPAGE
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "Popular_Models");											//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	@Test(priority=12, groups= {"Regression"})
	public void displayPopularModels() {
		try {
			CarFunctions.getPopularModels(driver);															//THIS WILL INVOKE THE METHOD TO GET THE LIST OF POPULAR MODELS
			ExcelUtils.writeCellData("Cars", 0, 0, "Popular Models");										//THIS WILL INVOKE THE METHOD TO WRITE THE DATA INTO THE GIVEN SPECIFIED SHEET
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
		
		test = report.createTest("Popular Models");															//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Display all Popular Models in Chennai");										//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "All Popular Models in Chennai are displayed successfully");					//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		
	}
	
	@Test(priority=13, groups= {"Regression", "Smoke"})
	public void navigateToHomePage() throws InterruptedException {
		CarFunctions.clickImage(driver);																	//THIS WILL INVOKE THE METHOD TO CLICK ON THE ZIGWHEELS IMAGE
		
		test = report.createTest("ZigWheels Image");														//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Click on the Zigwheels image to navigate to home page");						//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "ZigWheels image clicked and driver navigated to home page successfully");	//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		Thread.sleep(2000);																					//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
	}
	
	@Test(priority=14, groups= {"Regression", "Smoke"})
	public void pressLoginButton() {
		LoginFunctions.clickLoginButton(driver);															//THIS WILL INVOKE THE METHOD TO CLICK ON THE LOGN BUTTON 
		
		try {
			TakeScreenshot.screenshot(driver, "Login_Popup");												//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			Thread.sleep(5000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR FIVE SECONDS 
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		test = report.createTest("Login/Signup Button");													//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Click on Login Button to display Login Options");							//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Login Button is clicked and login options displayed successfully");			//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		
	}
	
	@Test(priority=15, groups= {"Regression", "Smoke"})
	public void clickOnContinueWithGoogle() {
		LoginFunctions.clickContinueWithGoogle(driver);														//THIS WILL INVOKE THE METHOD TO CLICK ON CONTINE WITH GOOGLE OPTION ON THE DISPLAYED POPUP
		
		test = report.createTest("Continue With Google");													//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Click on Continue with Google to be navigated to the Login Window");			//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Continue with Google and login window opened successfully");					//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
	
	}
	
	@Test(priority=16)
	public void moveFocusToLoginWindow() {
		LoginFunctions.shiftToLoginWindow(driver);															//THIS WILL INVOKE THE METHOD TO SHIFT THE DRIVER CONTROL TO THE LOGIN WINDOW
		
	try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "Login_Window");												//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=17, groups= {"Regression"})
	public void enterInvalidUsername() throws Exception {
		LoginFunctions.enterInvalidEmail(driver);															//THIS WILL INVOKE THE METHOD TO ENTER AN INVALID EMAIL IN THE USERNAME TEXTBOX
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "Invalid_Username");											//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		test = report.createTest("Enter Invalid Username");													//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Enter an invalid username for unsuccessful login");							//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Invalid Username entered successfully");										//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		
	}
	
	@Test(priority=18, groups= {"Regression", "Smoke"})
	public void clickOnNext() throws InterruptedException {
		LoginFunctions.clickNextButton(driver);																//THIS WILL INVOKE THE METHOD TO CLICK ON THE NEXT BUTTON
		Thread.sleep(2000);																					//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
	}
	
	@Test(priority=19, groups= {"Regression"})
	public void emailWarningMessage() throws Exception {
		LoginFunctions.captureEmailWarning(driver);															//THIS WILL INVOKE THE METHOD TO CAPTURE THE WARNING MESSAGE DISPLAYED AFTER ENTERING INVALID EMAIL
		
		try {
			Thread.sleep(2000);																				//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
			TakeScreenshot.screenshot(driver, "Warning_Message");											//THIS WILL TAKE A SCREENSHOT OF THE WEBPAGE WITH THE SPECIFIED NAME
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
		ExcelUtils.writeCellData("Login", 0, 0, "Warning Message");											//THIS WILL INVOKE THE METHOD TO WRITE THE DATA INTO THE SPECIFIED INDEX OF THE OUTPUT EXCEL SHEET
		
		test = report.createTest("Email Warning");															//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Invalid username entered should trigger a warning message");					//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Warning Message displayed successfully");									//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		
	}
	
	@Test(priority=20, groups= {"Regression", "Smoke"})
	public void collapseLoginWindow() throws InterruptedException {
		LoginFunctions.closeLoginWindow(driver);															//THIS WILL INVOKE THE METHOD TO CLOSE THE LOGIN WINDOW													
		
		test = report.createTest("Close Login Window");														//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Close Login Window");														//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Login Window closed successfully");											//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		Thread.sleep(2000);																					//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
	}
	
	@Test(priority=21, groups= {"Regression", "Smoke"})
	public void moveFocusToMainWindow() throws InterruptedException {
		LoginFunctions.shiftToMainWindow(driver);															//THIS WILL INVOKE THE METHOD TO SHIFT THE DRIVER CONTROL BACK TO THE MAIN WINDOW
		
		test = report.createTest("Close Website Window");													//THIS WILL GENERATE A NEW REPORT WITH THE SPECIFIED NAME
		test.log(Status.INFO, "Close Website Window");														//THIS WILL LOG THE REPORT WITH THE SPECIFIED INFORMATION
		test.log(Status.PASS, "Website Window closed successfully");										//THIS WILL LOG THE REPORT WITH A PASS STATUS AND THE SPECIFIED MESSAGE
		Thread.sleep(2000);																					//THIS WILL MAKE THE DRIVER TO WAIT FOR TWO SECONDS 
	}
	
	
	
	@AfterClass
	public void tearDown() {
		DriverSetup.driverClose();																			//THIS WILL INVOKE THE METHOD TO CLOSE THE DRIVER
		report.flush();																						//THIS WILL FLUSH ALL THE REPORTS CREATED
	}
}

package com.Utility;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup {
	
																	
	public static WebDriver driver;																				//THE DRIVER OF TYPE WEBDRIVER IS DECLARED GLOBALLY
										
	public static Properties prop = GetPropertiesFile.getProperties();											//THIS WILL CREATE THE INSTANCE OF THE PROPERTIES FILE
	public static String baseURL = prop.getProperty("URL");														//THIS WILL FETCH THE VALUE OF THE URL FROM THE PROPERTIES FILE
	
	public static WebDriver getWebDriver(String browser) throws MalformedURLException {											
		
		//DRIVER TO RUN CHROME BROWSER
				if (browser.equalsIgnoreCase("chrome")) 
				{
	
					ChromeOptions options = new ChromeOptions();												//THIS WILL CREATE THE OBJECT OF THE CHROMEOPTIONS CLASS
					options.addArguments("--disable-notifications");											//THIS WILL DISABLE IN-BUILT NOTIFICATIONS OF THE CHROME BROWSER
					options.addArguments("start-maximized");
					options.addArguments("incognito");
				  //options.addArguments("--disable-notifications","start-maximized","incognito"); 	// this will also work
					//driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);				//THIS WILL CREATE THE INSTANCE OF THE REMOTE WEBDRIVER TO BE ACCESSED FROM SELENIUM GRID
					System.setProperty("webdriver.chrome.driver","G:\\Projects\\IdentifyNewBikes_Hackathon\\IdentifyNewBikes_Hackathon\\drivers\\91Driver\\chromedriver.exe");
					driver=new ChromeDriver(options);
				} 
				
		//DRIVER TO RUN MOZILLA FIREFOX BROWSER
				else if (browser.equalsIgnoreCase("firefox")) 
				{
				
					FirefoxOptions options = new FirefoxOptions();												//THIS WILL CREATE THE OBJECT OF THE FIREFOXOPTIONS CLASS
					options.addPreference("dom.webnotifications.enabled", false);								//THIS WILL DISABLE IN-BUILT NOTIFICATIONS OF THE FIREFOX BROWSER
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);				//THIS WILL CREATE THE INSTANCE OF THE REMOTE WEBDRIVER TO BE ACCESSED FROM SELENIUM GRID
					
				}
				
		//DRIVER TO RUN MICROSOFT EDGE BROWSER
				else if (browser.equalsIgnoreCase("edge"))
				{
					
					EdgeOptions options = new EdgeOptions();													//THIS WILL CREATE THE OBJECT OF THE EDGEOPTIONS CLASS
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);				//THIS WILL CREATE THE INSTANCE OF THE REMOTE WEBDRIVER TO BE ACCESSED FROM SELENIUM GRID
					
				}
				
		
				
		driver.manage().window().maximize();																	//THIS WILL MAXIMIZE THE BROWSER WINDOW UPON LOADING
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);										//THIS WILL MAKE THE WEBPAGE WAIT FOR A MAXIMUM OF TEN SECONDS BEFORE LOADING IT SUCCESSFULLY
		driver.get(baseURL);																					//THIS WILL RETURN THE URL OF THE WEBSITE TO THE DRIVER
		return driver;																							//THIS WILL RETURN THE DRIVER UPON CALLING 
	}
	
	public static void driverClose() {
		driver.close();																							//THIS WILL CLOSE THE DRIVER
	}	
	
}

package com.TestObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BikeObjects {
	
	public static WebElement element;																//THIS WILL CREATE AN OBJECT OF WEBELEMENT, WHICH REPRESENTS A DOM ELEMENT
	public static List<WebElement> list;															//THIS WILL CREATE A LIST THAT WILL BE USED TO STORE MULTIPLE WEBELEMENTS
	public static WebDriver driver;																	//THIS WILL CREATE AN OBJECT OF WEBDRIVER
	
	public static WebElement newBikes(WebDriver driver) {	
		element = driver.findElement(By.partialLinkText("New Bikes"));								//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR PARTIAL LINK TEXT
		return element;																				//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static WebElement upcomingBikes(WebDriver driver) {
		element = driver.findElement(By.partialLinkText("Upcoming Bikes"));							//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR PARTIAL LINK TEXT
		return element;																				//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static WebElement Manufacturer(WebDriver driver) {
		element = driver.findElement(By.id("makeId"));												//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR ID
		return element;																				//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static WebElement selectHonda(WebDriver driver) {
		element = driver.findElement(By.xpath("//option[@value='53']"));							//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR XPATH
		return element;																				//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static WebElement moreBikes(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class='zw-cmn-loadMore']"));					//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR XPATH
		return element;																				//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static List<WebElement> bikeModels(WebDriver driver) {
		list = driver.findElements(By.xpath("//div[@class='p-15 pt-0 sl-mt20']/a/strong"));			//THIS WILL LOCATE THE ELEMENTS IN THE WEB PAGE USING LOCATOR XPATH
		return list;																				//THIS WILL RETURN THE LIST OF WEB ELEMENTS 
	}
	
	public static List<WebElement> bikePrices(WebDriver driver) {
		list = driver.findElements(By.xpath("//div[@class='p-15 pt-0 sl-mt20']/div[1]"));			//THIS WILL LOCATE THE ELEMENTS IN THE WEB PAGE USING LOCATOR XPATH
		return list;																				//THIS WILL RETURN THE LIST OF WEB ELEMENTS 
	}
	
	public static List<WebElement> bikeLaunch(WebDriver driver) {
		list = driver.findElements(By.xpath("//div[@class='p-15 pt-0 sl-mt20']/div[2]"));			//THIS WILL LOCATE THE ELEMENTS IN THE WEB PAGE USING LOCATOR XPATH
		return list;																				//THIS WILL RETURN THE LIST OF WEB ELEMENTS 
	}
	
	
	
}

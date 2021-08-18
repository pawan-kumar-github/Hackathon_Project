package com.TestObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarObjects {
	
	public static WebElement element;																//THIS WILL CREATE AN OBJECT OF WEBELEMENT, WHICH REPRESENTS A DOM ELEMENT
	public static List<WebElement> list;															//THIS WILL CREATE A LIST THAT WILL BE USED TO STORE MULTIPLE WEBELEMENTS
	public static WebDriver driver;																	//THIS WILL CREATE AN OBJECT OF WEBDRIVER
	
	public static WebElement usedCars(WebDriver driver) {
		element = driver.findElement(By.partialLinkText("Used Cars"));								//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR PARTIAL LINK TEXT
		return element;																				//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static WebElement Chennai(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@city='Chennai']"));								//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR XPATH
		return element;																				//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static WebElement popularModelsHeader(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class='zw-sr-shortWrap pt-15']"));				//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR XPATH
		return element;																				//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static List<WebElement> popularModelsList(WebDriver driver) {
		list = driver.findElements(By.xpath("/html/body/div[11]/div/div[1]/div[1]/div[1]/div[2]/ul/li[2]/div[2]/div[4]/ul/li/label"));			//THIS WILL LOCATE THE ELEMENTS IN THE WEB PAGE USING LOCATOR XPATH
		return list;																				//THIS WILL RETURN THE LIST OF WEB ELEMENTS
	}
	
	public static WebElement zigwheelsImage(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@alt='ZigWheels']"));							//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR XPATH
		return element;																				//THIS WILL RETURN THE WEB ELEMENT
	}
}

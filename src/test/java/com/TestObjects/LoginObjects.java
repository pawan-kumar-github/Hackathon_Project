package com.TestObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects {
	
	public static WebElement element;														//THIS WILL CREATE AN OBJECT OF WEBELEMENT, WHICH REPRESENTS A DOM ELEMENT
	public static List<WebElement> list;													//THIS WILL CREATE A LIST THAT WILL BE USED TO STORE MULTIPLE WEBELEMENTS
	public static WebDriver driver;															//THIS WILL CREATE AN OBJECT OF WEBDRIVER
	
	public static WebElement loginOrSignUp(WebDriver driver) {
		element = driver.findElement(By.id("des_lIcon"));									//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR ID
		return element;																		//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static WebElement continueWithGoogle(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='googleSignIn']"));					//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR XPATH
		return element;																		//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static WebElement emailTextbox(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@type='email']"));						//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR XPATH
		return element;																		//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static WebElement nextButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class='VfPpkd-RLmnJb']"));				//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR XPATH
		return element;																		//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static List<WebElement> emailMessage(WebDriver driver) {
		list = driver.findElements(By.xpath("//*[@class='o6cuMc']"));						//THIS WILL LOCATE THE ELEMENTS IN THE WEB PAGE USING LOCATOR XPATH
		return list;																		//THIS WILL RETURN THE LIST OF WEB ELEMENTS
	}
	
	public static WebElement passwordTextbox(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@type='password']"));					//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR XPATH
		return element;																		//THIS WILL RETURN THE WEB ELEMENT
	}
	
	public static WebElement passwordMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class='EjBTad']"));						//THIS WILL LOCATE THE ELEMENT IN THE WEB PAGE USING LOCATOR XPATH
		return element;																		//THIS WILL RETURN THE WEB ELEMENT
	}
	
	
	
}

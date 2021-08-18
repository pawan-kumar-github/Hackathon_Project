package com.TestFunctions;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.TestObjects.CarObjects;
import com.Utility.ExcelUtils;

public class CarFunctions {
	
	public static WebDriver driver;																				//THIS WILL CREATE AN OBJECT OF WEBDRIVER
	
	public static void moveToUsedCars(WebDriver driver) {
		Actions action = new Actions(driver);																	//THIS WILL CREATE AN OBJECT OF THE ACTIONS CLASS
		action.moveToElement(CarObjects.usedCars(driver)).build().perform();									//THIS WILL PERFORM THE ACTION OF MOVING THE CONTROL TO THE REQUIRED WEBELEMENT
	}
	
	public static void clickOnChennai(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;													//THIS WILL CREATE AN OBJECT OF JAVASCRIPTEXECUTOR CLASS AND CAST INTO THE DRIVER ELEMENT
		js.executeScript("arguments[0].click()", CarObjects.Chennai(driver));									//THIS WILL CLICK ON THE REQUIRED WEBELEMENT OBTAINED FROM THE CAROBJECTS CLASS
	}
	
	public static void scrollToPopularModels(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;													//THIS WILL CREATE AN OBJECT OF JAVASCRIPTEXECUTOR CLASS AND CAST INTO THE DRIVER ELEMENT
		js.executeScript("arguments[0].scrollIntoView();", CarObjects.popularModelsHeader(driver));				//THIS WILL SCROLL TO THE REQUIRED WEBELEMENT OBTAINED FROM THE CAROBJECTS CLASS
	}
	
	public static void getPopularModels(WebDriver driver) throws IOException {
		
		for(int i=0; i<CarObjects.popularModelsList(driver).size(); i++) {
			String model = CarObjects.popularModelsList(driver).get(i).getText();								//THIS WILL FETCH THE TEXT VALUES OF THE SPECIFIED LIST FROM THE CAROBJECTS CLASS
			//System.out.println(model);
			ExcelUtils.writeCellData("Cars", i+2, 0, model);													//THIS WILL WRITE THE STRING VALUE TO THE SPECIFIED SHEET IN THE OUTPUT EXCEL FILE
		}
	}
	
	public static void clickImage(WebDriver driver) {
		CarObjects.zigwheelsImage(driver).click();																//THIS WILL CLICK ON THE REQUIRED WEBELEMENT OBTAINED FROM THE CAROBJECTS CLASS
	}
}

package com.TestFunctions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.TestObjects.BikeObjects;
import com.Utility.ExcelUtils;

public class BikeFunctions {
	
	public static WebDriver driver;																//THIS WILL CREATE AN OBJECT OF WEBDRIVER

	public static Map<Integer, List<String>> mapper = new TreeMap<>();							//THIS WILL CREATE A NEW MAP WITH PARAMETERS OF AN INTEGER AND A LIST OF STRINGS
	public static int k=0;
	
	public static void moveToNewBikes(WebDriver driver)  {
		Actions action = new Actions(driver);													//THIS WILL CREATE AN OBJECT OF THE ACTIONS CLASS
		action.moveToElement(BikeObjects.newBikes(driver)).build().perform();					//THIS WILL PERFORM THE ACTION OF MOVING THE CONTROL TO THE REQUIRED WEBELEMENT
	}
	
	public static void moveToUpcomingBikes(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;									//THIS WILL CREATE AN OBJECT OF JAVASCRIPTEXECUTOR CLASS AND CAST INTO THE DRIVER ELEMENT
		js.executeScript("arguments[0].click()", BikeObjects.upcomingBikes(driver));			//THIS WILL CLICK ON THE REQUIRED WEBELEMENT OBTAINED FROM THE BIKEOBJECTS CLASS
	}
	
	public static void clickManufacturer(WebDriver driver) {
		BikeObjects.Manufacturer(driver).click();												//THIS WILL CLICK ON THE REQUIRED WEBELEMENT OBTAINED FROM THE BIKEOBJECTS CLASS
	}
	
	public static void selectManufacturer(WebDriver driver) {
		
		BikeObjects.selectHonda(driver).click();												//THIS WILL CLICK ON THE REQUIRED WEBELEMENT OBTAINED FROM THE BIKEOBJECTS CLASS
	}
	
	public static void scrollToViewMoreBikes(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;									//THIS WILL CREATE AN OBJECT OF JAVASCRIPTEXECUTOR CLASS AND CAST INTO THE DRIVER ELEMENT
		js.executeScript("arguments[0].scrollIntoView();", BikeObjects.moreBikes(driver));		//THIS WILL SCROLL TO THE REQUIRED WEBELEMENT OBTAINED FROM THE BIKEOBJECTS CLASS
	}
	
	public static void clickViewMoreBikes(WebDriver driver) {
		BikeObjects.moreBikes(driver).click();													//THIS WILL CLICK ON THE REQUIRED WEBELEMENT OBTAINED FROM THE BIKEOBJECTS CLASS
	}
	
	public static void bikesUnderFourLakhs(WebDriver driver) throws IOException {
		
		List<String> title = new ArrayList<String>();											//THIS WILL CREATE A NEW ARRAYLIST
		title.add("Model Name");																//THIS WILL ADD THE STRING VALUE TO THE ARRAYLIST
		title.add("Model Price");																//THIS WILL ADD THE STRING VALUE TO THE ARRAYLIST
		title.add("Launch Date");																//THIS WILL ADD THE STRING VALUE TO THE ARRAYLIST
		mapper.put(k++, title);																	//THIS WILL STORE THE VALUES IN THE ARRAYLIST IN THE MAP AT THE SPECIFIED NDEX
		
		for(int i=0; i<BikeObjects.bikePrices(driver).size(); i++) {
			String priceString = BikeObjects.bikePrices(driver).get(i).getText();				//THIS WILL FETCH THE TEXT OF THE WEBELEMENT FROM BIKEOBJECTS CLASS
			String store = " ";
			
			for(int j=3; j<priceString.length();j++) {
				if(priceString.charAt(j)==' ') {												//THIS WILL CHECK THE CONDITION WITH A CHARACTER AT THE SPECIFIED INDEX
					store = priceString.substring(3, j);										//THIS WILL EXTRACT AND STORE THE SUBSTRING WITH THE SPECIFIED INDEX
				}
			}
			
			Double price = Double.parseDouble(store);											//THIS WILL PARSE THE STRING VALUE AND STORE IT INTO A DOUBLE OBJECT
			if(price<4.00) {
				//System.out.println(BikeObjects.bikeModels(driver).get(i).getText());
				//System.out.println(BikeObjects.bikePrices(driver).get(i).getText());
				//System.out.println(BikeObjects.bikeLaunch(driver).get(i).getText());
				//System.out.println();
				
				List<String> outputList = new ArrayList<String>();								//THIS WILL CREATE A NEW ARRAYLIST
				
				outputList.add(BikeObjects.bikeModels(driver).get(i).getText());				//THIS WILL ADD THE LIST OBJECT TO THE ARRAYLIST
				outputList.add(BikeObjects.bikePrices(driver).get(i).getText());				//THIS WILL ADD THE LIST OBJECT TO THE ARRAYLIST
				outputList.add(BikeObjects.bikeLaunch(driver).get(i).getText());				//THIS WILL ADD THE LIST OBJECT TO THE ARRAYLIST
				
				mapper.put(k++, outputList);													//THIS WILL STORE THE VALUES IN THE ARRAYLIST IN THE MAP AT THE SPECIFIED NDEX
			}
		}
		try {
			ExcelUtils.writeExcelBikes(mapper);													//THIS WILL WRITE THE VALUES FROM THE MAP INTO AN EXCEL SHEET
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void scrollToTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;									//THIS WILL CREATE AN OBJECT OF JAVASCRIPTEXECUTOR CLASS AND CAST INTO THE DRIVER ELEMENT
		js.executeScript("window.scrollTo(0,0)");												//THIS WILL SCROLL TO THE REQUIRED DESTINATION IN THE WEBPAGE
	}
}

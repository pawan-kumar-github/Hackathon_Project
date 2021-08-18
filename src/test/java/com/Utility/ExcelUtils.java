package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static File src;																																					//THIS WILL CREATE A FILE
	public static String inputFilePath = "G:\\Projects\\IdentifyNewBikes_Hackathon\\IdentifyNewBikes_Hackathon\\src\\test\\java\\com\\ExcelIO\\InputFile.xlsx";		//THIS WILL STORE THE PATH OF THE INPUT EXCEL FILE INTO A STRING
	public static String inputSheetName = "Sheet1";																															//THIS WILL STORE THE NAME OF THE EXCEL SHEET INTO A STRING
	
	public static String outputFilePath = "G:\\Projects\\IdentifyNewBikes_Hackathon\\IdentifyNewBikes_Hackathon\\src\\test\\java\\com\\ExcelIO\\OutputFile.xlsx";		//THIS WILL STORE THE PATH OF THE OUTPUT EXCEL FILE INTO A STRING
	
	public static FileInputStream fin;																//THIS WILL CREATE AN OBJECT OF THE CLASS FILEINPUTSTREAM	
	public static FileOutputStream fout;
	public static XSSFWorkbook workbook;															//THIS WILL CREATE AN OBJECT OF THE CLASS XSSFWORKBOOK
	public static XSSFSheet sheet;																	//THIS WILL CREATE AN OBJECT OF THE CLASS XSSFSHEET
	public static XSSFRow row;																		//THIS WILL CREATE AN OBJECT OF THE CLASS XSSFROW
	public static XSSFCell cell;																	//THIS WILL CREATE AN OBJECT OF THE CLASS XSSFCELL
	
	
	public static String readCellData(int rowNum, int column) throws Exception {
		
		fin = new FileInputStream(inputFilePath);													//THIS WILL CREATE A NEW FILE INPUT STREAM TO FETCH DATA FROM THE FILEPATH
		workbook = new XSSFWorkbook(fin);															//THIS WILL CREATE A BLANK WORKBOOK CONNECTED TO THE INPUT STREAM
		sheet = workbook.getSheet(inputSheetName);													//THIS WILL NAVIGATE THE WORKBOOK TO THE REQUIRED SHEET OF THE EXCEL FILE
		row = sheet.getRow(rowNum);																	//THIS WILL SELECT THE FIRST ROW
		cell = row.getCell(column);																	//THIS WILL SELECT THE FIRST COLUMN
		
		String s1 = null;
		if(cell.getCellType() == CellType.STRING) {													//THIS WILL CHECK IF THE CELL CONTAINS A STRING
			s1 = cell.getStringCellValue();															//THIS WILL FETCH THE CELL VALUE INTO THE STRING S1
			workbook.close();																		//THIS WILL CLOSE THE WORKBOOK
			fin.close();																			//THIS WILL CLOSE THE INPUT STREAM
			
		}
		else if(cell.getCellType() == CellType.NUMERIC) {											//THIS WILL CHECK IF THE CELL CONTAINS A NUMERIC VALUE
			int v = (int)cell.getNumericCellValue();												//THIS WILL FETCH THE CELL VALUE AND TYPECAST IT
			s1 = String.valueOf(v);																	//THIS WILL CONVERT THE NUMERIC VALUE TO A STRING 
			workbook.close();																		//THIS WILL CLOSE THE WORKBOOK
			fin.close();																			//THIS WILL CLOSE THE INPUT STREAM
			
		}
		
		return s1;																					//THIS WILL RETURN THE STRING S1 CONTAINING THE CELL VALUE
		
	}
	
	
	public static void writeCellData(String outputSheetName, int rowNum, int cellNum, String value)  {		//GENERAL METHOD TO WRITE OUTPUT INTO THE OUTPUT FILE
		try {
			src = new File(outputFilePath);															//THIS WILL CREATE A NEW FILE AT THE SOURCE STRING 
			fin = new FileInputStream(src);															//THIS WILL CREATE A NEW FILE INPUT STREAM TO FETCH DATA FROM THE FILEPATH
			workbook = new XSSFWorkbook(fin);														//THIS WILL CREATE A BLANK WORKBOOK CONNECTED TO THE INPUT STREAM
			sheet = workbook.getSheet(outputSheetName);												//THIS WILL NAVIGATE THE WORKBOOK TO THE REQUIRED SHEET OF THE EXCEL FILE
			
			row = sheet.createRow(rowNum);															//THIS WILL CREATE A ROW FROM THE SPECIFIED INDEX
			cell = row.createCell(cellNum);															//THIS WILL CREATE A CELL FROM THE SPECIFIED INDEX
			cell.setCellValue(value);																//THIS WILL WRITE THE VALUE OF THE PARAMETER TO THE CELL
		
			fout = new FileOutputStream(outputFilePath);											//THIS WILL CREATE A NEW FILE OUTPUT STREAM TO FETCH DATA FROM THE FILEPATH
			workbook.write(fout);																	//THIS WILL WRITE INTO THE WORKBOOK
			workbook.close();																		//THIS WILL CLOSE THE WORKBOOK
			fout.close();																			//THIS WILL CLOSE THE OUTPUT STREAM
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void writeExcelBikes(Map<Integer, List<String>> m) throws Exception {				//METHOD TO WRITE DATA INTO THE BIKES SHEET OF THE OUTPUT FILE
			src = new File(outputFilePath);
			fin = new FileInputStream(src);
			workbook = new XSSFWorkbook(fin);
			sheet = workbook.getSheet("Bikes");
			Set<Integer> MapKey = m.keySet();														//THIS WILL CREATE AN OBJECT OF AN INTEGER SET 				
			int rownum = 0;
			for (Integer i : MapKey) {
				row = sheet.createRow(rownum++);													//THIS WILL CREATE A ROW AT THE SPECIFIED INDEX AND INCREMENT THE INDEX WITH EACH RUN OF THE LOOP
				List<String> outputArray = m.get(i);												//THIS WILL CRREATE AN OBJECT OF A LIST OF STRINGS
				int cellnum = 0;
				for (String value : outputArray) {
					cell = row.createCell(cellnum++);												//THIS WILL CREATE A CELL AT THE SPECIFIED INDEX AND INCREMENT THE INDEX WITH EACH RUN OF THE LOOP
					cell.setCellValue(value);
				}

			}
			try {
				fout = new FileOutputStream(outputFilePath);
				workbook.write(fout);
				workbook.close();
				fout.close();
				
			} catch (Exception e) {

				e.printStackTrace();
			}

	}
	
}

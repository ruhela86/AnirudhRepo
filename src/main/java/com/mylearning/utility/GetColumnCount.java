package com.mylearning.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetColumnCount {

	
	public short columncount(short currentrow){
		
		
		
	File myFile = new File("E:\\WORK\\MyFrameworkDesign\\Devil.xlsx");
	FileInputStream file = null;
	try {
		file = new FileInputStream(myFile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	XSSFWorkbook wb = null;
	try {
		wb = new XSSFWorkbook(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	XSSFSheet sheet = wb.getSheetAt(0);
	 
			
			XSSFRow row  = sheet.getRow(currentrow);
			 short lastcol=row.getLastCellNum();
			 
			 return lastcol;
			
	 
		
			
			
			
	}
	
	
}

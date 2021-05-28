
package com.dominous.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
	
	/**
	 * This generic reusable method is used for reading the data from excel file
	 * @param excelPath
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return str
	 * @throws Throwable
	 */
	
	public String getExcelData(String excelPath,String sheet,int row,int cell) throws Throwable
	{
		//Go to Excel path
		//FileInputStream is used for Reading Purpose
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		//Go to particular Sheet
		Sheet sh = wb.getSheet(sheet);
		//Go to particular Row
		Row r = sh.getRow(row);
		//Go to particular Cell
		Cell c = r.getCell(cell);
		//Fetch the Data
		String str = c.toString();
		//return string
		return str;
	}
	/**
	 * This generic reusable methods is used to write data into excel file
	 * @param excelPath
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	
	public void writeData(String excelPath,String sheet,int row,int cell,String data) throws Throwable
	{
		  //Open the file in read mode
		  FileInputStream fis = new FileInputStream(excelPath);
	      //Go to excel path
		  Workbook wb = WorkbookFactory.create(fis);
		  //Go to particular Sheet
		  Sheet sh = wb.getSheet(sheet);
		  //Go to particular Row
		  Row r = sh.getRow(row);
		  //Create a cell
		  Cell c = r.createCell(cell);
		  //Write the data
		  c.setCellValue(data);
				
				
		  //open the file in write mode
		  FileOutputStream fos = new FileOutputStream(excelPath);
		  //Save the file
		  wb.write(fos);
				
				
	}
	
	public String readPropData(String propPath,String key) throws Throwable
	{
		//Open the file in read mode
		FileInputStream fis=new FileInputStream(propPath);
		//Create an object of Properties Class
		Properties prop = new Properties();
		//Keep file ready for reading
		prop.load(fis);
		//give the key, get the value
		String propValue = prop.getProperty(key, "Incorrect key");
		//return propValue
		return propValue;
	}
	
	
}

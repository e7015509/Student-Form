package studform.commonlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataConnector {
	
		String excelPath ="C:\\Users\\e7015509\\Documents\\StudentForm-AutoRepo\\Student-Form\\TestData\\formsTestData.xlsx";
		
		public String getExcelRowData(String sheetName , int rowNum , int colNum) throws InvalidFormatException, IOException{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			String data = row.getCell(colNum).getStringCellValue();
			return data;
			
		}
		
		public int getRowcount(String sheetName) throws InvalidFormatException, IOException{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int rowCount = sh.getLastRowNum();
			return rowCount;
		}
		
		public void setExcelData(String sheetName , int rowNum , int colNum , String data) throws InvalidFormatException, IOException{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell cel = row.createCell(colNum);
			DataFormatter formatter =new DataFormatter();
			formatter.formatCellValue(sh.getRow(rowNum).getCell(colNum)).toString();
			
			FileOutputStream fos = new FileOutputStream(excelPath);
			cel.setCellValue(data);
			wb.write(fos);
		
		}
		
}
		
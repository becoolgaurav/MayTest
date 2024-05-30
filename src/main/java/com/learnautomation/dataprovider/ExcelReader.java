package com.learnautomation.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	
	public static Object[][] getData(String sheetName) throws IOException
	{
		
		//File file=new File("");
		File file=new File(System.getProperty("user.dir")+"/Book1.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetName);
		int rowcount=sheet.getPhysicalNumberOfRows();
		int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] val=new Object[rowcount][colcount];
		
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				val[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
				
		return val;
	}
}

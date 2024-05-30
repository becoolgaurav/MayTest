package com.learnautomation.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="TestData")
	public Object[][] getData() throws IOException
	{
		Object[][] val=ExcelReader.getData("Sheet1");
		return val;
	}
	
	@DataProvider(name="TestData1")
	public Object[][] getData1() throws IOException
	{
		Object[][] val=ExcelReader.getData("Sheet2");
		return val;
	}
}

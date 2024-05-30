package com.learnautomation.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ConfigReader {

	public static String getProperty(String key) throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("./ConfigFiles/Config.properties");
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
		
	}
}

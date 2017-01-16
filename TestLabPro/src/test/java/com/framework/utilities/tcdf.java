package com.framework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class tcdf {
	
static String testdataPath="D:\\MobileAppTesting\\script\\TestLabPro\\src\\test\\resources\\EnvironmentVars";	
	
public static String globalValue(String property) throws Exception{
		
		Properties objProp=new Properties();
		objProp.load(new FileInputStream(testdataPath));
		String value=objProp.getProperty(property);
		return value.trim();
}
}
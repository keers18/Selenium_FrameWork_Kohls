package com.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class tcdf {
	
static String testdataPath="C:\\Users\\kanha\\git\\TestLabPro\\TestLabPro\\src\\test\\resources\\EnvironmentVars";	
	
public static String globalValue(String property) throws Exception{
		
		Properties objProp=new Properties();
		objProp.load(new FileInputStream(testdataPath));
		String value=objProp.getProperty(property);
		return value.trim();
}
public static String getExcelValue(int row,int column) throws Exception{
	String str_cellValue=null;
	try{
		 Workbook workbookObj =  Workbook.getWorkbook(new File(tcdf.globalValue("XLFilepath")+"testXL.xls"));
         Sheet selectedSheet = workbookObj.getSheet(0);
         Cell cellValue = selectedSheet.getCell(column, row);
         str_cellValue = cellValue.getContents();
	     }catch(Exception e){
		 e.printStackTrace();
	     }
		 return str_cellValue.trim() ;
}
}
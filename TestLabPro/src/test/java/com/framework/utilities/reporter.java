package com.framework.utilities;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.pageFactory.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class reporter extends TestBase {
	protected static ExtentReports Report;
	protected static ExtentTest logger;
	public static void initReport(String reportName,String testCaseName) throws Exception{
		System.out.println("Report status:INITIALIZING REPORT");
		Report =new ExtentReports(tcdf.globalValue("ReportPath")+reportName+".html");
		logger=Report.startTest(testCaseName);
		//logger.assignAuthor("#Author:"+author);
		System.out.println("Report status:REPORT BASE READY");
	}
	public static void tearReport() throws Exception{
		try{
		System.out.println("Report status:TEARING REPORT");
		Report.endTest(logger);
		Report.flush();
		System.out.println("Report status:CREATED");
		}catch(Exception e){e.printStackTrace();}}
	
	public static void reportTestStep(String testStepName,String actual,String expected,String Status,boolean screenShot) throws Exception{
		try{
			System.out.println("Report status:ADDING");
			
			if(actual.equals(expected) && Status.equals("PASS") && screenShot==false){
			//CODE FOR PASS CASE.  
			logger.log(LogStatus.INFO, testStepName);
			}
			
		else {
				if(screenShot==true && Status.equals("FAIL")){
				//SCREENSHOT CODE NOT WORKING.  .	
				//driverUtil.getscreenshot(testStepName);
					logger.log(LogStatus.FAIL, testStepName);
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
	                FileUtils.copyFile(scrFile, new File((tcdf.globalValue("ScreenShots")+testStepName+".png").trim()));
				
				}else if(screenShot==false && Status.equals("FAIL"))
					logger.log(LogStatus.FAIL, testStepName);
				}}catch(Exception e){e.printStackTrace();}
	}
	

}

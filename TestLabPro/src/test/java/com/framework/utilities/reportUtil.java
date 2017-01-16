package com.framework.utilities;
import com.framework.pageFactory.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class reportUtil extends TestBase {
	protected static ExtentReports Report;
	protected static ExtentTest logger;
	
	public static void initReport(String reportName,String testName) throws Exception{
		Report =new ExtentReports(tcdf.globalValue("ReportPath")+reportName+".html");
		logger=Report.startTest(testName);
	}
	public static void tearReport() throws Exception{
		
		Report.endTest(logger);
		Report.flush();
		
	
	}
	public static void reportTestStep(String testStepName,String actual,String expected,String testStepStatus,boolean screenShot) throws Exception{
		try{
			if(actual.equals(expected) && testStepStatus.equals("PASS")){
				logger.log(LogStatus.INFO, testStepName);
			}else {
				
				if(screenShot==true){
				driverUtil.getscreenshot(testStepName);
				logger.log(LogStatus.FAIL, testStepName);
				}else if(screenShot==false)
					logger.log(LogStatus.FAIL, testStepName);
				}
				
	
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}

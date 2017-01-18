package com.framework.testCases;
import org.testng.annotations.Test;
import com.framework.annotations.annotationFactory.Author;
import com.framework.annotations.annotationFactory.TC_NO;
import com.framework.pageFactory.TestBase;
import com.framework.reusable.components;
//import com.framework.utilities.reportUtil;

public class TestCases extends TestBase {
components component=new components();
 

@Author("Shruti")
/******************************TESTCASES START HERE*****************************************/
@TC_NO("001")
@Test(groups= {""})
public void TC001_login_validation() throws Exception{
	component.openURL();
	component.clickLogin();
	
}

@TC_NO("002")
@Test(groups= {"Dev"})
public void TC002_fassured_validation() throws Exception{
	//reportUtil.initReport("TC002_Fassured_Functionality_Validation", "Flipkart:F-assured Functionality");
	component.openURL();
	component.clickFAssured();
	//reportUtil.tearReport();
	
}
@TC_NO("003")
@Test(groups= {""})
public void TC003_checkGiftCardFunctionality() throws Exception{
	component.openURL();
	component.checkGiftCardFunctionality();
	Thread.sleep(5000);
}


}

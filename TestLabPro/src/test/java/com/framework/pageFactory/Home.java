package com.framework.pageFactory;
import org.openqa.selenium.By;

import com.framework.utilities.driverUtil;
import com.framework.utilities.reportUtil;
public class Home extends TestBase {
//OBJECT MAP  
By lnkFAssured=By.xpath("//a[.='F-Assured']");
By lnkLogin=By.xpath("//a[.='Log In']");
By btncloseLogin=By.xpath("//button[.='✕']");
By lnkGiftCard=By.xpath("//a[.='Gift Card']");	
By combobxVoucherValue=By.xpath("//label[contains(text(),'Value of Gift Card')]/../..//select");	

//ASSOCIATED METHODS   .
public void openURL() throws Exception{

	 try{
	 driverUtil.trigger();
	 }
		
	catch(Exception e){
		e.printStackTrace();
	}
}


public void clickFAssured() throws Exception{
	
	//driver.findElement(By.xpath("//a[.='F-Assured']")).click();
	driverUtil.waitForElementDisplayed(lnkFAssured, 120);
	driverUtil.click(lnkFAssured);
	//reportUtil.reportTestStep("Click F-assured-HomePage Link", "ok", "ok", "PASS", false);
	
	
	
}
public void clickLogin() throws Exception{
	driverUtil.waitForElementDisplayed(lnkLogin, 120);
	driverUtil.click(lnkLogin);
	Thread.sleep(5000);
	driverUtil.click(btncloseLogin);
}
public void checkGiftCardFunctionality() throws Exception{
	driverUtil.waitForElementDisplayed(lnkGiftCard, 15);
	driverUtil.click(lnkGiftCard);
	driverUtil.waitForElementDisplayed(combobxVoucherValue, 15);
	driverUtil.comboIntract(combobxVoucherValue, "100");
	
}
}

package com.framework.pageFactory;
import org.openqa.selenium.By;
import com.framework.utilities.driverUtil;
import com.framework.utilities.reporter;
import com.framework.utilities.tcdf;
public class Home extends TestBase {
//OBJECT MAP  
By lnkFAssured=By.xpath("//a[.='F-Assured']");
By lnkLogin=By.xpath("//a[.='Log In']");
By btncloseLogin=By.xpath("//button[.='✕']");
By lnkGiftCard=By.xpath("//a[.='Gift Card']");	
By combobxVoucherValue=By.xpath("//label[contains(text(),'Value of Gift Card')]/../..//select");
//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//For Facebook demo
By txtboxUserName=By.id("email");
By txtboxPassword=By.id("pass");
By btnSignIn=By.xpath("//input[@type='submit']");
By lnkNavigateToprofile=By.xpath("(//span[contains(text(),'Kanha')])[1]");

//zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
//ASSOCIATED METHODS OF THE HOME PAGE
public void openURL() throws Exception{

	 try{
	 driverUtil.trigger();
	 reporter.reportTestStep("App Launch", "ok", "ok", "PASS", false);
	 }
		
	catch(Exception e){
		e.printStackTrace();
	}
}
//---------------------------------------------------
public void fbLogin() throws Exception{
	driverUtil.sendKeys(txtboxUserName, tcdf.globalValue("uname"));
	driverUtil.sendKeys(txtboxPassword, tcdf.globalValue("password"));
	driverUtil.click(btnSignIn);
	driverUtil.waitForElementDisplayed(lnkNavigateToprofile, 30);
	driverUtil.click(lnkNavigateToprofile);

}


public void clickFAssured() throws Exception{
	driverUtil.waitForElementDisplayed(lnkFAssured, 120);
	driverUtil.click(lnkFAssured);
	//WE CAN ADD TRADITIONAL VERIFICATION STEPS 
	reporter.reportTestStep("Click F-assured-HomePage Link", "ok", "notok", "FAIL", true);}

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

package com.framework.reusable;
import org.openqa.selenium.support.PageFactory;
import com.framework.pageFactory.Home;
import com.framework.pageFactory.TestBase;

 public  class components extends TestBase {
	//PAGE OBJECT DECLARTIONS. . .
	static Home oHome=PageFactory.initElements(driver, Home.class);

	
	
	//COMPONENT METHOD DEFINITIONS.  .
	public void openURL() throws Exception{
		oHome.openURL();
		Thread.sleep(6000);
			
	}
	public void fbLogin() throws Exception{
		
		oHome.fbLogin();
	}
	
	public void clickFAssured() throws Exception{
		oHome.clickFAssured();
	}
	public void clickLogin() throws Exception{
		oHome.clickLogin();
	}
	public void checkGiftCardFunctionality() throws Exception{
		oHome.checkGiftCardFunctionality();
	}
}

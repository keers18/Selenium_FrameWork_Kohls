package com.framework.utilities;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.framework.pageFactory.TestBase;

public class driverUtil extends TestBase{
	//CONTAINS DRIVER RELATED FUNCTIONALITIES.  .
	public static void trigger() throws Exception{
		try{
		driver.manage().deleteAllCookies();
		driver.get(tcdf.globalValue("url"));
		driver.manage().timeouts().implicitlyWait(Long.valueOf(tcdf.globalValue("implicit_wait_time")), TimeUnit.SECONDS);}
		
		catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void click(By locator) throws Exception{
		try{
			driver.findElement(locator).click();
			//System.out.println("clicked:"+locator.toString());
		
		}catch(Exception e){
			//System.out.println("clickable element"+locator.toString()+" not found");
			//e.printStackTrace();
			

		}
	}
	public static void waitForElementDisplayed(By locator,int waitTime) throws Exception{
		try{
			System.out.println("waiting for element:"+locator.toString());
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("element:"+locator.toString()+" is visible");}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void sendKeys(By locator,String data) throws Exception{
		try{
			driver.findElement(locator).sendKeys(data);
			System.out.println("sent "+data+" to"+locator.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void clear(By locator) throws Exception{
		try{
			driver.findElement(locator).clear();
			System.out.println("cleared the text of the locator:"+locator.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static String getText(By locator) throws Exception{
		String Text="";
		try{
			Text=driver.findElement(locator).getText().trim();


		}catch(Exception e){
			e.printStackTrace();
		}
		return Text;
	}
	public static String getAttribute(By locator,String attribute) throws Exception{
		String attributeVal="";
		try{
			attributeVal=driver.findElement(locator).getAttribute(attribute).trim();


		}catch(Exception e){
			e.printStackTrace();
		}
		return attributeVal;
	}
	public static boolean isElementDisplayed(By locator) throws Exception{
		boolean flag=driver.findElement(locator).isDisplayed();
		return flag;
	}
	public static boolean isElementEnabled(By locator) throws Exception{
		boolean flag=driver.findElement(locator).isEnabled();
		return flag;
	}
	public static void comboIntract(By comboboxLocator,String visibleValue) throws Exception{
		try{
			waitForElementDisplayed(comboboxLocator,15);
			Select comboSelect =new Select(driver.findElement(comboboxLocator));
			comboSelect.selectByVisibleText(visibleValue);
		}catch(Exception e){
			
		}
		
	}
	 public static void getscreenshot(String ScreenShotName) throws Exception 
     {
            
             try{
            	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
            	 FileUtils.copyFile(scrFile, new File((tcdf.globalValue("ScreenShots")+ScreenShotName+".png").trim()));}
             				catch(Exception e){
             						e.printStackTrace();
             }
     }
	

}

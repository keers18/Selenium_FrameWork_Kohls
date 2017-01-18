package com.framework.pageFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.framework.utilities.tcdf;

public class TestBase {
	//PRESESSION CONFIGURATIONS
	protected static WebDriver driver;
    protected static Logger Log = Logger.getLogger(TestBase.class.getName());
	//WEBDRIVER CONFIGURATIONS  
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		String browser=tcdf.globalValue("browser").trim();
		Log.info("Test execution started");
		Log.info(browser+ "browser selected");
		if(browser.equals("chrome")){
			Log.info("starting chrome services");
			System.setProperty("webdriver.chrome.driver",tcdf.globalValue("ChromeDriver").trim());
			Log.info("configuring browser capabilities");
			ChromeOptions optionsChrome = new ChromeOptions();
			optionsChrome.addArguments("--start-maximized");
			driver = new ChromeDriver( optionsChrome );}
		else if(browser.equals("IE")){
			Log.info("starting IE services");
			System.setProperty("webdriver.ie.driver",tcdf.globalValue("IEDriver"));
			Log.info("configuring browser capabilities");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();}	
	   else if(browser.equals("safari")){
			//code for safari thread
		   }
	 else {
		System.out.println("Invalid browser type detected using phantom execution.");
		Log.warn("No browser selected");
			/* System.setProperty("phantomjs.binary.path", "D:\\MobileAppTesting\\script\\TestLabPro\\drivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
			 driver=new PhantomJSDriver();*/}}
	//WEBDRIVER SESSION TEAR DOWN  .
	@AfterMethod(alwaysRun = true)
	public void teardown() throws Exception{
		Log.info("killing current driver session");
		Thread.sleep(5000);
		driver.close();}

}

package com.framework.pageFactory;
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
	//WEBDRIVER CONFIGURATIONS  
	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception{
		String browser=tcdf.globalValue("browser").trim();
		System.out.println("selected browser:"+browser);
		if(browser.equals("chrome")){
			System.out.println("starting chrome services");
			System.setProperty("webdriver.chrome.driver",tcdf.globalValue("ChromeDriver").trim());
			System.out.println("configuring browser options");
			ChromeOptions optionsChrome = new ChromeOptions();
			optionsChrome.addArguments("--start-maximized");
			driver = new ChromeDriver( optionsChrome );}
		else if(browser.equals("IE")){
			System.setProperty("webdriver.ie.driver",tcdf.globalValue("IEDriver"));
			System.out.println("configuring browser options");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();}	
	   else if(browser.equals("safari")){
			//code for safari thread
		   }
	 else {
		System.out.println("Invalid browser type detected using phantom execution.");
			/* System.setProperty("phantomjs.binary.path", "D:\\MobileAppTesting\\script\\TestLabPro\\drivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
			 driver=new PhantomJSDriver();*/}}
	//WEBDRIVER SESSION TEAR DOWN  .
	@AfterMethod(alwaysRun = true)
	public void teardown() throws Exception{
		System.out.println("killing current driver session");
		Thread.sleep(5000);
		driver.close();
		//reportUtil.reportTestStep("driver session close", "ok", "ok", "PASS", false);
		//reportUtil.tearReport();
	}

}

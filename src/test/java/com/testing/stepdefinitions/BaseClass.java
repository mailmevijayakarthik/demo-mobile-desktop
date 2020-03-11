package com.testing.stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author Vijayakarthikeyan
 *
 */
public class BaseClass extends AbstractTestNGCucumberTests {
	public static RemoteWebDriver driver;
	public static AppiumDriver<MobileElement> mdriver;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest test;
	
	/*Getting all the Properties of environment.properties file and based on this value loading the needed resource.properties
	 * Initalization of Driver value based on the environment.properties details - Docker | local 
	 * ExtentReport - Not yet customized */ 
	

	public static void Initiaziation(String BrowserName) throws MalformedURLException {
		System.out.println("Executing TestNG's @BeforeMethod...in the Browser type "+ BrowserName);
		//BrowserName=prop.getProperty("browsername");
		prop=getProperty();
		DriverInitialization(BrowserName);
		report=new ExtentReports();
		
	}
	
	/*Quiting the Driver which is created */
	

	public static void tearDown() {
		 report.flush();
		System.out.println("@AfterTest TestNG Annotation is tearing down");
		driver.quit();
	}
	
 
	/*Initializing Remote Driver 
	  Added implicit wait 
      Loaded the BrowserURl*/
	
 public static RemoteWebDriver DriverInitialization(String browsername) throws MalformedURLException {
	 String Execution=prop.getProperty("Executionmode");
	 if(Execution.equalsIgnoreCase("Local")) {
		 System.out.println("Creating Driver for Local Execution ..");
		 if(browsername.equalsIgnoreCase("Chrome")) {

			 System.setProperty("webdriver.chrome.driver", "src/test/resources/lib/chromedriver");
			 driver = new ChromeDriver();

		 }else if (browsername.equalsIgnoreCase("FireFox")) {

			 System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\lib\\geckodriver.exe");
			 driver = new FirefoxDriver();

		 }else if (browsername.equalsIgnoreCase("IE")) {

			 System.setProperty("webdriver.ie.driver", "src\\test\\resources\\lib\\IEDriverserver.exe");
			 driver = new InternetExplorerDriver();

		 }else if (browsername.equalsIgnoreCase("safari")) {
			 driver = new SafariDriver();
		 }else if (browsername.equalsIgnoreCase("mobileChrome")) {

			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setCapability("platformName", "Android");
			 caps.setCapability("browserName", "Chrome");
			 caps.setCapability("deviceName", "emulator-5554");
			 try {
				 driver =new RemoteWebDriver(new URL(prop.getProperty("AppiumurlPort")),caps);
				 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			 } catch (MalformedURLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }



		 } else if(browsername.equalsIgnoreCase("mobileSafari")) {
			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setCapability("platformName", "iOS");
			 caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
			 caps.setCapability("platformVersion", "12.2");
			 caps.setCapability("deviceName", "iPhone 8 Plus");
			 caps.setCapability("automationName", "XCUITest");

			 try {
				 driver =new RemoteWebDriver(new URL(prop.getProperty("AppiumurlPort")),caps);
				 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			 } catch (MalformedURLException e) {
				 // TODO Auto-generated catch block
				 e.printStackTrace();
			 }

		 }

	 }

		 
  System.out.println(driver+ "Driver created successfully");
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  
 return driver;
 }
 
 /*Get Property method to load the details / values from the property file */
 
 public static Properties getProperty(){
		
		Properties prop = new Properties();
		System.out.println("Getting all the needed property files");
		try {
			prop.load(new FileInputStream("src/test/resources/environment.properties"));
			prop.load(new FileInputStream(prop.getProperty("resourcepath")));
			prop.load(new FileInputStream("src/test/resources/qa/Endpoint.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
 
 /*Need to be re-looked - Not completed */
 
 public  void getlistoffiles(){
    
	 File file = new File("prod");
	 String path = file.getAbsolutePath();
	 System.out.println("Root Path :"+ path);
	File file1 = new File(path);
	String[] files = file1.list();
	 
    for (String f : files)
    {
        System.out.println(f);
    }
 }

 public RemoteWebDriver getMobileDriver() {
	
	 DesiredCapabilities caps = new DesiredCapabilities();
	 caps.setCapability(CapabilityType.PLATFORM, "ANDROID");
	 caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ee9bb4d1");
	 caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	 caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	 try {
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		mdriver = new AppiumDriver<>(url, caps);
		
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return mdriver;
	 
 }
}

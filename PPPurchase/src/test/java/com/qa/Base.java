package com.qa;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base{
	
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		ExtentHtmlReporter reporter=new  ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/reportname.html"));
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		driver=BrowserFactory.initilization(driver,"firefox");
		//Reporter.log("Browser Initiated",true);
		logger=extent.createTest("Browser Intilization to Phiscal Product Purchase");
		//logger.info("Browser Intilization");
		logger.info("Broswer Launch the Application");
		driver.get(ConfigReader.getApplicationUrl());
		String actual ="American Psychological Association (APA)";
		 String expected=driver.getTitle();
		  boolean result=actual.equalsIgnoreCase(expected);
		//  Assert.assertTrue(result);
			  logger.info("User Navigated to American Psychological Association (APA)");
		Thread.sleep(2000);
		extent.flush();
	}
	
//@AfterClass
//	public void  browserClose() {
//	driver.close();
//logger.info("Browser Closed");
//
//}
	
//	@AfterClass
//	public  void tearDown(ITestResult result) throws IOException
//	{
//		
//		if(result.getStatus()==ITestResult.FAILURE) {
//			logger.info("Captured Failure Screen Short");
//			logger.fail("Test Fail", MediaEntityBuilder.createScreenCaptureFromPath(TestUtility.getScreenShort(driver)).build());
//		}
//	
//		extent.flush();
//	}
	
	

}

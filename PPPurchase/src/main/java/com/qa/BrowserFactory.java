package com.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	WebDriver driver;
	public static ConfigReader cfgr;
	
public static  WebDriver  initilization(WebDriver driver,String browsername) {
		cfgr=new ConfigReader();
	
		if (browsername.equalsIgnoreCase("firefox")) {
			//System.out.println(ConfigReader.getFirefoxPath()+"***************");
			System.setProperty("webdriver.gecko.driver", ConfigReader.getFirefoxPath());
			driver=new FirefoxDriver();
			
		}
		else if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ConfigReader.getChromePath());
			driver=new ChromeDriver();
			
		}else if(browsername.equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.gecko.internetexplorer", ConfigReader.getIEPath());
			driver=new InternetExplorerDriver();
		}
		
	//	driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	return driver;
	}
	
	

}

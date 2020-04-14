package com.qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
		
		public static  Properties prop;
		public static String configFileName ="C:\\Users\\Babitha\\Desktop\\Automation\\poiExcel\\PPPurchase\\Config\\config.properties";
		
		public  ConfigReader(){
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(configFileName );
				prop.load(ip);
				//System.out.println("******************"+prop);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Reading the config values 

		public static String getChromePath() {
				String chromepath=prop.getProperty("chrome");
				//System.out.println("*************"+chromepath);
				return chromepath;
		}
		
		public  static String  getFirefoxPath() {
			String firefoxpath=prop.getProperty("firefox");
			//System.out.println("*************"+firefoxpath);
			return firefoxpath;
		
	}
		public  static String getIEPath() {
			String iEpath=prop.getProperty("ie");
			return iEpath;
		
	}
		public static  String getApplicationUrl() {
			return prop.getProperty("url");
			
		}
		public static String getUserName() {
			return prop.getProperty("username");
		}
		public static String getPassword() {
			return prop.getProperty("password");
		}
		//Reading Shipping Details
		public static String getfirstName() {
			return prop.getProperty("FirstName");
		}
		public static String getlastName() {
			return prop.getProperty("LastName");
		}
		public static String getaddressLine1() {
			return prop.getProperty("AddressLine1");
		}
		public static String getaddressLine2() {
			return prop.getProperty("AddressLine2");
		}
		public static String getCity() {
			return prop.getProperty("City");
		}
		public static String getState() {
			return prop.getProperty("State");
		}
		public static String getZipCode() {
			return prop.getProperty("ZipCode");
		}
		public static String getcountry() {
			return prop.getProperty("country");
		}
		public static String getPhone() {
			return prop.getProperty("Phone");
		}
		public static String getExtention() {
			return prop.getProperty("Extention");
		}
		public static String	getCardName() {
			return prop.getProperty("CardName");
			
		}
		public static String	getCardType() {
			return prop.getProperty("CardType");
			
		}
		public static String	getCreditCardNO() {
			return prop.getProperty("CreditCardNO");
			
		}
		public static String	getSecurityCode() {
			return prop.getProperty("SecurityCode");
			
		}
		public static String	getExpireMonth() {
			return prop.getProperty("ExpireMonth");
			
		}
		public static String	getExpireYear() {
			return prop.getProperty("ExpireYear");
			
		}
		
	}

	
	



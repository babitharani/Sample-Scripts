package com.qa;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
	public static WebDriver driver;
    String chrome_path;
    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
   // public static String file_location = System.getProperty("user.dir")+"/Akeneo_product";
    static String SheetName= "Sheet1";
    public  String Res;
  //  Write obj1=new Write();
    public int DataSet=-1;
	@BeforeSuite
    public void OpenBrowser() throws InterruptedException
 
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Babitha\\Desktop\\Automation\\poiExcel\\APAapp\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("http://192.168.1.91/user/login");
        Thread.sleep(3000);
    }
	
	@DataProvider
  public Object[][] ReadData() throws IOException {
	  FileInputStream fileInputStream= new FileInputStream("C:\\Users\\Babitha\\Desktop\\Automation\\poiExcel\\APAapp\\TestData\\testdata.xlsx"); //Excel sheet file location get mentioned here
      workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
      worksheet=workbook.getSheet("data");// get my sheet from workbook
      XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
   
      int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
      int ColNum= Row.getLastCellNum(); // get last ColNum 
       
      Object Data[][]= new Object[RowNum-1][ColNum]; // pass my  count data in array
       
          for(int i=0; i<RowNum-1; i++) //Loop work for Rows
          {  
        	  XSSFRow row= worksheet.getRow(i+1);
               
              for (int j=0; j<ColNum; j++) //Loop work for colNum
              { 	
                  if(row==null)
                      Data[i][j]= "";
                  else
                  {
                	  XSSFCell cell= row.getCell(j);
                      if(cell==null)
                          Data[i][j]= ""; //if it get Null value it pass no data 
                      else
                      {
                          String value=formatter.formatCellValue(cell);
                          Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                      }
                  }
              }
          }

      return Data;
  }
	
	
	@Test //Test method
	(dataProvider="ReadData")
	public void AddVariants(String FirstName, String LastName
, String UserName, String Email, String RetypeEmail, String ChoosePassword,String RetypePassword ) throws Exception
	{
	//Data will set in Excel sheet once one parameter will get from excel sheet to Respective locator position.
	DataSet++;
	System.out.println("NAme of product available are:" +FirstName);
	System.out.println("Weight for products are:" +LastName);
	System.out.println("Volume of product are:" +UserName);
	System.out.println("Description quotation are:" +Email);
	System.out.println("Description picklings are:" +RetypeEmail);
	System.out.println("Description quotation are:" +ChoosePassword);
	System.out.println("Description picklings are:" +RetypePassword);
	 
	}
  }


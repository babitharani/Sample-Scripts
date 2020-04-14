package com.qa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtility {
	
	public static long PAGE_LOAD_TIMEOUT =30;
	public static long IMPLICIT_WAIT =30;
	public static Sheet sheetname;
	public static String[][] data;
	public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static DataFormatter formatter= new DataFormatter();
    
    //public  String Res;
    
	
	 public static Object[][] ReadData(String Filelocation,String filename,String sheetname) throws IOException {
		  FileInputStream fileInputStream= new FileInputStream(Filelocation+filename); //Excel sheet file location get mentioned here
	      workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
	      worksheet=workbook.getSheet(sheetname);// get my sheet from workbook
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
		

public static String getScreenShort(WebDriver ldriver) {
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String Currentdate= dateFormat.format(new Date());
		//Take screenshot and store as a file format             
		
		 File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);      
		 String screenshortpath="C:\\Users\\Babitha\\Desktop\\Automation\\poiExcel\\APAapp\\ScreenShorts\\"+Currentdate+".png";    
		 try {
		// now copy the  screenshot to desired location using copyFile method
		 //FileUtils.copyFile(src, new File("D:\\MavenAPA\\Examples\\screenshorts\\"+Currentdate+".png"));    
			 FileUtils.copyFile(src, new File(screenshortpath));                     
						
		 } catch (IOException e)
			{
			  System.out.println(e.getMessage());
			  }
		 return screenshortpath;
		  }
	
//public static boolean  VerifyPageTitle(String actualValue,String expectedValue) {
//	return actualValue.equalsIgnoreCase(expectedValue);
//	
//}



}

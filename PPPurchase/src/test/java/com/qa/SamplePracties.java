package com.qa;



import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream.GetField;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class SamplePracties {
	
	  public WebDriver driver;
  @Test
  public void SampleMethod() {
	  
	  System.setProperty("webdriver.gecko.driver", "D:\\UpdatedScripts\\APALogin\\drivers\\geckodriver.exe");
	  
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.navigate().to("http://demo.guru99.com/Agile_Project/Agi_V1/index.php");
	  
	  driver.findElement(By.name("uid")).clear();
	  driver.findElement(By.name("uid")).sendKeys("1303");
	  driver.findElement(By.name("password")).clear();
	  driver.findElement(By.name("password")).sendKeys("Guru99");
	  driver.findElement(By.name("btnLogin")).click();
	  
	  
	  try {	 
		  Alert al=driver.switchTo().alert();
		  System.out.println("Alert text"+al.getText());  
		  al.accept();	  
		  
	  }catch (NoAlertPresentException e) {
		System.out.println("No alert is present");
	}
	  driver.findElement(By.xpath("//a[contains(text(),'Mini Statement')]")).click();
	 Select options=new Select(driver.findElement(By.name("accountno")));
	  List<WebElement> li= options.getOptions();
	  for(int i=0;i<li.size();i++) {
		  
		  String opt=li.get(i).getText();
		  if(opt.contains("3309")) {
			  options.selectByIndex(i);
			  driver.findElement(By.name("AccSubmit")).click();
	  }
	  
	  }
  }
	  @Test	
	  public void  fetchData() {
		  
		  try{
			  File scr=new File("C:\\Users\\Babitha\\Desktop\\Automation\\poiExcel\\PPPurchase\\TestData\\GurruMiniData.xlsx");
			  
			  FileInputStream fis=new FileInputStream(scr);
			  
			  XSSFWorkbook wrbook=new XSSFWorkbook(fis);
			 XSSFSheet sheet= wrbook.getSheet("sheet1");
			 
			int rowcount=  sheet.getLastRowNum()+1;
			
			 System.out.println(rowcount);
			 for(int i=0;i<rowcount;i++) {
				Row row= sheet.getRow(i);
				
				 for(int j=0;j< row.getLastCellNum();j++) {
					 
					 System.out.println(row.getCell(j).getStringCellValue());
					 
				 }
			 }
			 
			
		  }catch (Exception e) {
			//System.out.println("file not found exception");
		}
	  }
			  
	  @Test	
	  public void  WriteData() {
		 FileOutputStream fos=null;
		  try{
			  File scr=new File("C:\\Users\\Babitha\\Desktop\\Automation\\poiExcel\\PPPurchase\\TestData\\WriteGurruMiniData.xlsx");
			  
			  FileInputStream fis=new FileInputStream(scr);
			  
			  XSSFWorkbook wrbook=new XSSFWorkbook(fis);
			 XSSFSheet sheet= wrbook.getSheet("sheet1");
			//Get the current count of rows in excel file

			    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

			    //Get the first row from the sheet

			    Row row = sheet.getRow(0);
			  //Create a new row and append it at last of sheet

			    Row newRow = sheet.createRow(rowCount+1);

			    //Create a loop over the cell of newly created Row

			    for(int j = 0; j < row.getLastCellNum(); j++){

			        //Fill data in row

			        Cell cell = newRow.createCell(j);

			        cell.setCellValue("babitha");
			    }//Close input stream

			    fis.close();

			    //Create an object of FileOutputStream class to create write data in excel file

			    FileOutputStream outputStream = new FileOutputStream(scr);

			    //write data in the excel file

			    wrbook.write(outputStream);

			    //close output stream

			    outputStream.close();
				
//			 for(int i=0;i<=3;i++) {
//				 Row row=sheet.createRow(i);
//				 for(int j=0;j<2;j++) {
//					 Cell cell=row.createCell(j);
//					 cell.setCellType(cell.CELL_TYPE_STRING);
//					 
//					 cell.setCellValue("pass");
//					 fos=new FileOutputStream("C:\\Users\\Babitha\\Desktop\\Automation\\poiExcel\\PPPurchase\\TestData\\WriteGurruMiniData.xlsx");
//					 wrbook.write(fos);
//								
//			 Row row=sheet.createRow(0);
//			 
//			 Cell cell=row.createCell(0);	
		  }catch (Exception e) {
			//System.out.println("file not found exception");
		}
	   
		  }

	  }
	  
	  
  
 


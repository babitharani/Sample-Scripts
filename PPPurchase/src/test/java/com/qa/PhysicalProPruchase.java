package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhysicalProPruchase extends Base {
	public String actualValue;
	public String expectedvalue;
	  boolean result;
	
  @Test(priority = 2)
  public void selectproduct() throws InterruptedException {
	  
	  logger=extent.createTest("Physcial Product to Purchase");
	  driver.findElement(By.xpath("//nav[@class='topnav']//a[contains(text(),'Publications & Databases')]")).click();
	  Thread.sleep(3000);
	//driver.findElement(By.linkText("APA Books")).click();
	
	  logger.info("User Navigated to Publications & Databases");
	  logger.info("click  publications and DataBase link");
	 
	  driver.findElement(By.xpath("//a[contains(text(),\"Children's Books\")]")).click();
	  logger.info("Click children Books link on Publications & Databases page ");
	  Thread.sleep(3000);
	//verify page title
	  Assert.assertEquals("Magination Press Children's Books", driver.getTitle());
	 driver.findElement(By.xpath("//a[@id='pubsLink_PublicationsProductLandingPage_6']")).click();
	  logger.info("Click on By Title link");
	  Thread.sleep(3000);
	  
	  if (driver.findElement(By.partialLinkText("Abracadabra! The Magic of Trying")).getText()!=null)
			 driver.findElement(By.partialLinkText("Abracadabra! The Magic of Trying")).click();
		 else
			 logger.fail("Abracadabra! The Magic of Trying  link is not present");
	  
	  logger.info("select  product----Abracadabra! The Magic of Trying");
	  
	//check Add to  cart option is valiable
	  WebElement AddToCartElement =driver.findElement(By.xpath("//a[@id='pubsLink_ChildrenBook_1']"));
	 if( AddToCartElement.isDisplayed())
	 {
		 AddToCartElement.click();
		 logger.info("Click on Add to Cart option.");
	 }else {
		 logger.info("Click on Add to Cart option is not vailable");
		 logger.fail("Click to  Add to Cart option is faild");
	 }
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@id='cart:shoppingCartTable:0:quantity']")).clear();
	
	  logger.info("updating the quality of product");
	  //Thread.sleep(3000);
	  //update the quantity
	  driver.findElement(By.xpath("//input[@id='cart:shoppingCartTable:0:quantity']")).sendKeys("3");
	  Thread.sleep(1000);
	  //check the quantity updated or not
	  driver.findElement(By.xpath("//span[@class='updateQuantity']")).click();
	  Thread.sleep(3000);
	  //String value=driver.findElement(By.xpath("//input[@id='cart:shoppingCartTable:0:quantity']")).getAttribute("value");
	  String value=driver.findElement(By.xpath("//input[@id='cart:shoppingCartTable:0:quantity']")).getAttribute("value");
	  Assert.assertEquals(value, "3");
	  logger.info("Quantity  updated to 3");
	  Thread.sleep(3000);
	  
	  logger.info("Click on ADDTOCART  Button");
	  WebDriverWait wait2 = new WebDriverWait(driver, 10);
	  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='j_idt46:topcheckoutbtn']")));
	  driver.findElement(By.xpath("//input[@id='j_idt46:topcheckoutbtn']")).click();
	  Thread.sleep(3000);
	  logger.info("Application navigated to login page");
	  extent.flush();
  }
  
  @Test(priority =1)
  public void login() throws InterruptedException {
	  logger=extent.createTest("Verify Login Page");
	 // Assert.assertEquals("APA Login",driver.getTitle());
	  
	  logger.info("Enter valid  credentilas on login page");
	  //enter username and password
	  Thread.sleep(2000);
	  driver.findElement(By.id("username")).sendKeys("apatest001@apa.org");
	  Thread.sleep(3000);
	  driver.findElement(By.id("password")).sendKeys("password001");
	  Thread.sleep(3000);
	  driver.findElement(By.id("loginBtnccc")).click();
	  Thread.sleep(3000);
	  
	  extent.flush();
  }
  
  
  @Test(priority =3)
  public void shippingAndBilling() throws InterruptedException {
	  Assert.assertEquals("Provide Addresses",driver.getTitle());
	  logger=extent.createTest("Verify Shipping And Billing Details");
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
		
	 WebElement element= driver.findElement(By.xpath("//a[contains(text(),'a new shipping address.')]"));
	 logger.info("Enter  Shipping and Billing Details");
	 if (element.isDisplayed()) {
		 element.click();
	 }
	  //enter entet shipping and billing address
	  driver.findElement(By.xpath("//input[@id='addressForm:firstnameShipping']")).clear();
	  driver.findElement(By.xpath("//input[@id='addressForm:firstnameShipping']")).sendKeys(ConfigReader.getfirstName());
	  Thread.sleep(2000);
	  jse.executeScript("scroll(250, 250);");
	  driver.findElement(By.xpath("//input[@id='addressForm:lastnameShipping']")).clear();
	  driver.findElement(By.xpath("//input[@id='addressForm:lastnameShipping']")).sendKeys(ConfigReader.getlastName());
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='addressForm:lineoneShipping']")).clear();
	  driver.findElement(By.xpath("//input[@id='addressForm:lineoneShipping']")).sendKeys(ConfigReader.getaddressLine1());
	  Thread.sleep(2000);
	  jse.executeScript("scroll(250, 250);");
//	  driver.findElement(By.xpath("//input[@id=''addressForm:linetwoShipping']")).clear();
//	  Thread.sleep(2000);
//	  driver.findElement(By.xpath("//input[@id=''addressForm:linetwoShipping']")).sendKeys(ConfigReader.getaddressLine2());
	  //Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='addressForm:cityShipping']")).clear();
	  driver.findElement(By.xpath("//input[@id='addressForm:cityShipping']")).sendKeys(ConfigReader.getCity());
	  Thread.sleep(2000);
	  
	  Select selectCity=new Select(driver.findElement(By.xpath("//select[@id='addressForm:stateShipping']")));
	  selectCity.selectByVisibleText(ConfigReader.getState());
	  driver.findElement(By.xpath("//input[@id='addressForm:zipShipping']")).clear();
	  driver.findElement(By.xpath("//input[@id='addressForm:zipShipping']")).sendKeys(ConfigReader.getZipCode());
	  Thread.sleep(2000);
	 
	  jse.executeScript("scroll(0, 250)");
	  
	  Select selectCountry=new Select(driver.findElement(By.xpath("//select[@id='addressForm:COUNTRYSET']")));
	  selectCountry.selectByVisibleText(ConfigReader.getcountry());
	  
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='addressForm:phoneShipping']")).clear();
	  driver.findElement(By.xpath("//input[@id='addressForm:phoneShipping']")).sendKeys(ConfigReader.getPhone());
	  jse.executeScript("scroll(0, 250)");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='addressForm:ext']")).clear();
	 WebElement ele= driver.findElement(By.xpath("//input[@id='addressForm:ext']"));
	 ele.sendKeys(ConfigReader.getExtention());
	 ele.sendKeys(Keys.PAGE_DOWN);
	  Thread.sleep(1000);
	  driver.findElement(By.className("shipBillSameCheckbox")).click();
	  //driver.findElement(By.xpath("//input[@id='addressForm:sameasshipping']")).click();
	  Thread.sleep(2000);
	 // jse.executeScript("scroll(500, 500);");
	  logger.info("click on continu button on address page");
	  driver.findElement(By.xpath("//form[@id='addressForm']//div//input[@value='Continue']")).click();
	  logger.info("Application Navigated to Payment Page");
	Thread.sleep(5000);
	  extent.flush();
  }
  
  @Test(priority = 4)
  public void PaymentAndReview() throws InterruptedException {
	  
	   logger=extent.createTest("Verify Payment details");
	   logger.info("Enter credit card details");
			 // Assert.assertEquals("Payment & Review",driver.getTitle());
	  // JavascriptExecutor jse = (JavascriptExecutor)driver;
	  driver.switchTo().frame(0);
	   Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='txtEmbeddedCreditCardName']")).clear();
	  driver.findElement(By.xpath("//input[@id='txtEmbeddedCreditCardName']")).sendKeys(ConfigReader.getCardName());
	  Thread.sleep(3000);
	  Select selectCardType=new Select(driver.findElement(By.xpath("//select[@id='ddlEmbeddedCreditCardType']")));
	  selectCardType.selectByVisibleText(ConfigReader.getCardType());
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//input[@id='txtEmbeddedCreditCardNumber']")).sendKeys(ConfigReader.getCreditCardNO());
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//input[@id='txtEmbeddedCVV']")).clear();
	  driver.findElement(By.xpath("//input[@id='txtEmbeddedCVV']")).sendKeys(ConfigReader.getSecurityCode());
	  Thread.sleep(2000);
	   
	  
	  Select selectExpireMonth=new Select (driver.findElement(By.xpath("//select[@id='ddlEmbeddedExpirationMonth']")));
	  selectExpireMonth.selectByVisibleText(ConfigReader.getExpireMonth());
	  Thread.sleep(2000);
	 
	  Select selectExpireYear=new Select (driver.findElement(By.xpath("//select[@id='ddlEmbeddedExpirationYear']")));
	  selectExpireYear.selectByVisibleText(ConfigReader.getExpireYear());
	
	  driver.switchTo().defaultContent();
	 
	  WebElement myelement = driver.findElement(By.xpath("//input[@value='Submit Your Order']"));
	  JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	  jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
	  logger.info("Click on submit order ");
	  driver.findElement(By.xpath("//input[@value='Submit Your Order']")).click(); 
	  
	  logger.info("Application Navigated to Order Review page");
	  extent.flush();
	  
  }

  
  
}

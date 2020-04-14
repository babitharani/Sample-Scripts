package com.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PhysicalProductPurchase {
	WebDriver driver;
	
	@BeforeTest
	public void BrowserInti() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Babitha\\Desktop\\Automation\\poiExcel\\PPPurchase\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://mytest.apa.org");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
  @Test
  public void Login() throws InterruptedException {
	  driver.findElement(By.id("username")).sendKeys("apatest001@apa.org");
	  Thread.sleep(3000);
	  driver.findElement(By.id("password")).sendKeys("password001");
	  Thread.sleep(3000);
	  driver.findElement(By.id("loginBtnccc")).click();
	  Thread.sleep(3000);
  }

@Test(priority = 1)
public void selectProduct() throws InterruptedException {
	driver.findElement(By.xpath("//nav[@class='topnav']//a[contains(text(),'Publications & Databases')]")).click();
	  Thread.sleep(3000);
	driver.findElement(By.linkText("Children's Books")).click();
	 Thread.sleep(2000);
	 WebDriverWait wait=new WebDriverWait(driver,20);
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='pubsLink_PublicationsProductLandingPage_20']")));
	 
	 
	//driver.findElement(By.xpath("//a[@id='pubsLink_PublicationsProductLandingPage_20']")).click();
}
@Test(priority = 2)
public void shoppingCart() throws InterruptedException {
	
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@id='j_idt46:topcheckoutbtn']")).click();
	 Thread.sleep(5000);
}
@Test(priority = 3)
public void provideAddressPage() throws InterruptedException {
	
	driver.findElement(By.xpath("//input[@id='addressForm:firstnameShipping']")).sendKeys("Rajesh");
	driver.findElement(By.xpath("//input[@id='addressForm:lastnameShipping	']")).sendKeys("kumar");
	 Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='addressForm:lineoneShipping']")).sendKeys("7th street");
	 Thread.sleep(3000);
	driver.findElement(By.xpath("//dt[@class='cityDTShipping']")).sendKeys("Hill city");
	
	 Thread.sleep(3000);
	
WebElement country=	driver.findElement(By.xpath("//select[@id='addressForm:COUNTRYSET']"));
Select option=new Select(country);
option.selectByVisibleText("United States of America");
Thread.sleep(3000);
WebElement city=	driver.findElement(By.xpath("//select[@id='addressForm:stateShipping']"));
Select option2=new Select(city);
option2.selectByVisibleText("California (CA)");
Thread.sleep(3000);
driver.findElement(By.xpath("//input[@id='addressForm:zipShipping']")).sendKeys("90224");
Thread.sleep(3000);
driver.findElement(By.xpath("//input[@id='addressForm:phoneShipping']")).sendKeys("1122334455");
Thread.sleep(3000);
driver.findElement(By.xpath("//input[@id='addressForm:sameasshipping']")).click();
	 Thread.sleep(3000);
	
}
}
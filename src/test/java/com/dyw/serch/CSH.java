package com.dyw.serch;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CSH {
	private WebDriver driver;
	private String baseUrl;
 
@BeforeClass
  public void setUp() {
	  driver=new FirefoxDriver();
	  baseUrl="https://www.baidu.com/";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Test
  @Parameters("test1")
  public void testCase(String test1)throws Exception{
	  driver.get(baseUrl+"/");
	  System.out.println("查询的关键字是"+test1);
	  driver.findElement(By.id("kw")).sendKeys(test1);
	  driver.findElement(By.id("su")).click();
	  Thread.sleep(3000);
	  String title=driver.getTitle();
	  System.out.println(title);
	 assertEquals(title,test1+"ererer 搜索","dfdsd");
	 System.out.println(title);
  }
  
  
@AfterClass
  public void tearDown() throws Exception
  {
	driver.quit();
	//Runtime.getRuntime().exec("taskkill/F /IM firefox.exe");
  }
}

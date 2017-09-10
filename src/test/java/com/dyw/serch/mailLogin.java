package com.dyw.serch;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class mailLogin {
	private WebDriver driver;
	private String baseUrl;
  
  @BeforeClass
  public void setUp() {
	  driver=new FirefoxDriver();
	  baseUrl="http://144.131.254.212:6178/omps/a/login;JSESSIONID=88a46131ccd743609b65770dbb1ed616";
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  //定义对象数组
  @DataProvider(name="user")
  public Object[][] Users(){
	  return new Object[][]{
			  
			  {"15195815941","Aa199216"},
			  
	  };
  }
  @Test(dataProvider="user")
  public void testCase(String username ,String password )throws Exception{
	   driver.get(baseUrl);
	   driver.findElement(By.id("username")).clear();
	   driver.findElement(By.id("username")).sendKeys(username);
	   driver.findElement(By.id("showpassword")).clear();
	   driver.findElement(By.id("password")).sendKeys(password);
	   driver.findElement(By.id("btnSubmit")).click();
	   Thread.sleep(3000);
	   String text=driver.findElement(By.id("userlogin_name")).getText();
	   assertEquals(text,"呼呼呼1   (  15195815941  )","不相等：");
  }
@AfterClass
public void tearDown()
{
	driver.quit();
	}
}

package com.dyw.serch;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ModthYl {
	//登录方法
  public static void login(WebDriver driver,String username, String password ){
	   driver.findElement(By.id("username")).clear();
	   driver.findElement(By.id("username")).sendKeys(username);
	   driver.findElement(By.id("showpassword")).clear();
	   driver.findElement(By.id("password")).sendKeys(password);
	   driver.findElement(By.id("btnSubmit")).click();
  }
  public static void logout(WebDriver driver) throws InterruptedException
  {
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id='login_h_div']/span[2]/a")).click();
  }
  @Test
  public void verifyLogin() throws InterruptedException {
	  WebDriver driver =new FirefoxDriver();
	  driver.get("http://144.131.254.212:6178/omps/");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  String username="15195815941";
	  String password="Aa199216";
	  login(driver,username,password);
	  Thread.sleep(3000);
	  String text=driver.findElement(By.id("userlogin_name")).getText();
	  assertEquals(text,"呼呼呼1   (  15195815941  )","不相等：");
	  logout(driver);
	  driver.quit();
	  
	  
  }
  @Test(dependsOnMethods={"verifyLogin"})
  public void veriffySearchMail() throws InterruptedException{
	  WebDriver driver =new FirefoxDriver();
	  driver.get("http://144.131.254.212:6178/omps/");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  String username="15195815941";
	  String password="Aa199216";
	  login(driver,username,password);
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("html/body/div[2]/div/ul/li[2]/a")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id='dataList']/li[4]/a/img")).click();
	  driver.switchTo().frame("frame_content_middle");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id='pane']/div[1]/ul/li[3]/a")).click();
//	  Thread.sleep(3000);
//      driver.findElement(By.cssSelector("[target=frame_content]")).click();
	
//	  Thread.sleep(3000);
//	  driver.findElement(By.linkText("会员列表")).click();
	  driver.switchTo().frame("frame_content");
	  Thread.sleep(3000);
	  driver.findElement(By.id("customCardId")).sendKeys("eeeeeeeeeee");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id='recordform']/div[1]/ul/li[10]/span/a")).click();
	  Thread.sleep(3000);
	  driver.quit();
//	  WebElement search=driver.findElement(By.xpath(""));
//	  search.sendKeys("");
//	  search.sendKeys(Keys.ENTER);
//	  String text=driver.findElement(By.className("")).getText();
//	  System.out.println(text);
//	  assertEquals(text,"搜索结果");
//	  logout(driver);
	  
	  
			  
  }
}

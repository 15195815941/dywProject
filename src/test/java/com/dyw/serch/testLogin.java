package com.dyw.serch;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dyw.demo1.driver.driver;
import com.dyw.demo1.login.business.LoginPageBusiness;



public class testLogin {

WebDriver dri=null;
@BeforeClass
public void setUP()throws Exception{
	dri=new FirefoxDriver();
	driver.getInstance(dri);
	dri.manage().window().maximize();
	
	 //dri.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
//定义对象数组
@DataProvider(name="user")
public Object[][] Users(){
	  return new Object[][]{
			  
			  {"","","登录帐号为空"},
			  {"15195815941","","密码为空"},
			  {"","Aa199216","登录帐号为空"},
			  {"error","error","用户不存在"},
	  };
}
@Test(dataProvider="user")
public void testCase(String username ,String password ,String expectTeXt)throws Exception{
	 
	

	
	LoginPageBusiness.getHomePage();
	 
	LoginPageBusiness.login(username, password);
	  String text= dri.findElement(By.id("errors_msg")).getText();
	  //System.out.println(tezy);
	   //tearDown();
//	   String text=driver.findElement(By.id("userlogin_name")).getText();
       assertEquals(text,expectTeXt,"不相等：");
       //tearDown();
}
@AfterClass
public void tearDown()
{
	dri.quit();
	
}

}

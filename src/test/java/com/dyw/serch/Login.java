package com.dyw.serch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login {
 
	public static void login(WebDriver driver,String username, String password ){
		   driver.findElement(By.id("username")).clear();
		   driver.findElement(By.id("username")).sendKeys(username);
		   driver.findElement(By.id("showpassword")).clear();
		   driver.findElement(By.id("password")).sendKeys(password);
		   driver.findElement(By.id("btnSubmit")).click();
	  }
	public static void logout(WebDriver driver )throws Exception{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='login_h_div']/span[2]/a")).click();
	  }
	
}

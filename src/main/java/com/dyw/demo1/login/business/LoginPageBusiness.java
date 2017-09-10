package com.dyw.demo1.login.business;

import org.openqa.selenium.By;

import com.dyw.demo1.driver.driver;
import com.dyw.demo1.element.pageElement;



public class LoginPageBusiness extends driver{
	
	public static void getHomePage(){
		
		dr.get(pageElement.homePageUrl);
		
	}
	
	public static void inputName(String userName){
		
		dr.findElement(By.id(pageElement.NameId)).clear();;
		dr.findElement(By.id(pageElement.NameId)).sendKeys(userName);
		
	}
	
	public static void inputPassWord(String passWord) {
		
		dr.findElement(By.id(pageElement.showPassWordId)).click();
		
		dr.findElement(By.id(pageElement.passWordId)).clear();
		
		dr.findElement(By.id(pageElement.passWordId)).sendKeys(passWord);
	}
	
	
	public static void clickLoginBtn(){
		
		dr.findElement(By.xpath(pageElement.loginBtnId)).click();;
		
	}
	
	public static void login(String userName,String passWord) {
		
		inputName(userName);		
		inputPassWord(passWord);
		clickLoginBtn();
		
	}
	
	
	

}

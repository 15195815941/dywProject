package com.dyw.demo1.driver;

import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;

public class driver {
public static WebDriver dr = null;
	
	public static void getInstance(WebDriver superdriver){
		if(dr == null){
			dr = superdriver;
		}
	}
	
	public static void InitDriver(){
		if(dr!= null){
			dr = null;
		}
	}
}

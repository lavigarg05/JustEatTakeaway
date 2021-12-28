package com.jet.framework.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverContext {
	
	private static WebDriver driver;
	private static JavascriptExecutor js;
	public static Browser browser;
	
	public static void setDriver(WebDriver driverArg) {
		driver = driverArg;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static JavascriptExecutor getJSExecutor() {
		return js;
	}

	public static void setJSExecutor() {
		js = (JavascriptExecutor) driver;
	}
	
}

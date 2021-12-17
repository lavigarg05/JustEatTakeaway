package com.jet.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverContext {
	
	private static WebDriver driver;
	public static Browser browser;
	
	protected static void setDriver(WebDriver driverArg) {
		driver = driverArg;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
}

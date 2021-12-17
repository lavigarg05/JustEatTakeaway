package com.jet.framework.base;

import org.openqa.selenium.WebDriver;


import com.jet.framework.connections.Settings;

public class FrameworkInitialize extends Base{
	
	private WebDriver driver;
	
	public void InitializeBrowser(BrowserType browserType) {
		Browser browser=new Browser();
		browser.InitializeBrowser(browserType);
		browser.maximize();
		browser.implicitWait(Settings.TimeoutImplicit);
	}
	


}

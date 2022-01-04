package com.jet.framework.base;

import com.jet.framework.connections.Settings;

public class FrameworkInitialize extends Base{
	
	
	public void InitializeBrowser(BrowserType browserType) {
		Browser browser=new Browser();
		browser.InitializeBrowser(browserType);
		browser.maximize();
		browser.implicitWait(Settings.TimeoutImplicit);
	}
	


}

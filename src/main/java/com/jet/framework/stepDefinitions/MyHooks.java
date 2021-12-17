package com.jet.framework.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.jet.framework.base.BrowserType;
import com.jet.framework.base.DriverContext;
import com.jet.framework.base.FrameworkInitialize;
import com.jet.framework.connections.ConfigReader;
import com.jet.framework.connections.Settings;
import com.jet.framework.utilities.ExcelUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;



public class MyHooks extends FrameworkInitialize{	
	protected ExcelUtil util;
	
	@Before
	public void init() throws FileNotFoundException, IOException {
		ConfigReader.loadConfig();
		util=new ExcelUtil(Settings.ExcelPath);		
	}
	
	@After
	public void after() {
		DriverContext.getDriver().quit();
	}

}

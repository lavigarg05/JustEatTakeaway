package com.jet.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.jet.framework.utilities.WaitUtility;

public abstract class BasePage extends Base{

	public BasePage() {	
		PageFactory.initElements(DriverContext.getDriver(), this);
	}
}

package com.jet.framework.base;

import org.openqa.selenium.support.PageFactory;
import com.jet.framework.utilities.WebDriverWaitUtility;

public abstract class BasePage extends Base{
	public WebDriverWaitUtility wait;
	
	public BasePage() {	
		
		wait=new WebDriverWaitUtility();
		PageFactory.initElements(DriverContext.getDriver(), this);
	}
}

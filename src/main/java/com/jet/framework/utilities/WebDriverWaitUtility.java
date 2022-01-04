package com.jet.framework.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jet.framework.base.DriverContext;
import com.jet.framework.connections.Settings;

public class WebDriverWaitUtility {
	
    private WebDriverWait wt=new WebDriverWait(DriverContext.getDriver(),Settings.TimeoutExplicit);

	
	public void setWait(WebDriverWait wait) {
		this.wt = wait;
	}

	public void WaitForElementToBeClickable( WebElement elementFindBy){
		wt.until(ExpectedConditions.elementToBeClickable(elementFindBy));
    }
    
    public WebElement WaitForElementToBeClickableByXpath( String xpathExpression){
        return wt.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
    }
    
    public void WaitForElementToBeVisable( WebElement elementFindBy){
    	wt.until(ExpectedConditions.visibilityOf(elementFindBy));
    }

}

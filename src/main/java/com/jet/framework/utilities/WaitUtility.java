package com.jet.framework.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jet.framework.base.DriverContext;
import com.jet.framework.connections.Settings;

public class WaitUtility {
	
    private static WebDriverWait wait= new WebDriverWait(DriverContext.getDriver(), Settings.TimeoutExplicit);
	
    public static void WaitForElementToBeClickable( WebElement elementFindBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementFindBy));
    }
    
    public static WebElement WaitForElementToBeClickableByXpath( String xpathExpression){
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
    }
    
    public static void WaitForElementToBeVisable( WebElement elementFindBy){
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }

}

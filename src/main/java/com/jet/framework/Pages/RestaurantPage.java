package com.jet.framework.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.jet.framework.base.Base;
import com.jet.framework.base.BasePage;
import com.jet.framework.base.DriverContext;
import com.jet.framework.utilities.WaitUtility;


public class RestaurantPage extends BasePage{

	public RestaurantPage() {
		super();
	}

	
	public WebElement getFoodItemCategory(String ItemCategory) {		
		return DriverContext.getDriver().findElement(By.xpath("//div[@data-qa='menu-category-nav-categories']//span[text()='"+ItemCategory+"']"));		
	}	

	public void selectFoodItemCategory(String ItemCategory) {
		getFoodItemCategory(ItemCategory).click();
	}	
	
}

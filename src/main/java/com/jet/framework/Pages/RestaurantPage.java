package com.jet.framework.Pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	@FindBy(how = How.XPATH,using ="//button[@data-qa='sidebar-action-checkout']")
	public WebElement btnCheckOut;
	
	public WebElement getFoodItemCategory(String ItemCategory) {		
		return DriverContext.getDriver().findElement(By.xpath("//div[@data-qa='menu-category-nav-categories']//span[text()='"+ItemCategory+"']"));		
	}	

	public void selectFoodItemCategory(String ItemCategory) {
		getFoodItemCategory(ItemCategory).click();
	}
	
	public WebElement getAddItem(String ItemName) {
		//section[@data-qa='item-category']//h3[text()='"+ItemName+"']/ancestor::div[@data-qa='item']//span[@data-qa='item-add-icon']
		return DriverContext.getDriver().findElement(By.xpath("//section[@data-qa='item-category']//h3[text()='"+ItemName+"']"));	
	}
	
	public boolean addItem(List<String> itemNameList,List<String> itemCountList) {
		if(itemNameList.size()!=itemCountList.size())
			return false;
		Actions action=new Actions(DriverContext.getDriver());
		for(int i=0;i<itemNameList.size();i++) {
			WebElement itemName=getAddItem(itemNameList.get(i));
			int itemCount=Integer.parseInt(itemCountList.get(i));
			WaitUtility.WaitForElementToBeClickable(itemName);
			for(int j=0;j<itemCount;j++) {
				action.moveToElement(itemName).perform();
				itemName.click();
			}
			logger.info("Added "+itemCount+" "+itemNameList.get(i)+" to cart");			
			
		}
		
		return true;
	}
	
	public void clickCheckout() {
		btnCheckOut.click();
	}
	
	public WebElement checkOutHeading() {
		WebElement heading=DriverContext.getDriver().findElement(By.xpath("	//h3[text()='Checkout']"));
		return heading;
	}
	
	public CheckoutPage getCheckOutPage() {
		WaitUtility.WaitForElementToBeVisable(checkOutHeading());
		return new CheckoutPage();			
	}
	
}

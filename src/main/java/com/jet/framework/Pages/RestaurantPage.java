package com.jet.framework.Pages;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.jet.framework.utilities.Util;
import com.jet.framework.utilities.WaitUtility;


public class RestaurantPage extends BasePage{
	
	private Util util=new Util();

	public RestaurantPage() {
		super();
	}

	@FindBy(how = How.XPATH,using ="//button[@data-qa='sidebar-action-checkout']")
	public WebElement btnCheckOut;
	
	@FindBy(how = How.XPATH,using ="//span[@data-qa='cart-expanded-summary-total']")
	public WebElement txtTotalCartValue;
	
	@FindBy(how = How.XPATH,using ="	//div[@data-qa='cart-mov-message-not-reached']")
	public WebElement txtCartErrorMessage;
	

	
	public WebElement getFoodItemCategory(String ItemCategory) {		
		return DriverContext.getDriver().findElement(By.xpath("//div[@data-qa='menu-category-nav-categories']//span[text()='"+ItemCategory+"']"));		
	}	

	public void selectFoodItemCategory(String ItemCategory) {
		getFoodItemCategory(ItemCategory).click();
	}
	
	public String getCartErrorMessage() {
		return txtCartErrorMessage.getText();
	}
	
	public WebElement getAddItem(String ItemName) {
		//section[@data-qa='item-category']//h3[text()='"+ItemName+"']/ancestor::div[@data-qa='item']//span[@data-qa='item-add-icon']
		return DriverContext.getDriver().findElement(By.xpath("//section[@data-qa='item-category']//h3[text()='"+ItemName+"']"));	
	}
	
	public WebElement getItemPriceElement(String ItemName) {
		
		return DriverContext.getDriver().findElement(By.xpath("//section[@data-qa='item-category']//h3[text()='"+ItemName+"']//ancestor::div[@data-qa='flex']//span[@data-qa='text']"));	
	}
	
	public boolean addItem(List<String> itemNameList,List<Integer> itemCountList) {
		if(itemNameList.size()!=itemCountList.size())
			return false;
		Actions action=new Actions(DriverContext.getDriver());
		for(int i=0;i<itemNameList.size();i++) {
			WebElement itemName=getAddItem(itemNameList.get(i));
			int itemCount=itemCountList.get(i);
			util.scrollToItem(itemName);
			WaitUtility.WaitForElementToBeClickable(itemName);
			for(int j=0;j<itemCount;j++) {
				action.moveToElement(itemName).perform();
				itemName.click();
			}
			logger.info("Added "+itemCount+" "+itemNameList.get(i)+" to cart");			
			
		}
		
		return true;
	}
	
	public List<Double> getItemPrice(List<String> itemNameList) {
		
		String price="";
		List<Double> priceList=new ArrayList<>();
		for(String item: itemNameList) {
			WebElement el =getItemPriceElement(item);
			price=el.getText();
			priceList.add(Util.processPrice(price));
		}	
		return priceList;		
	}
	
	public void clickCheckout() {
		btnCheckOut.click();
	}
	
	public WebElement checkOutHeading() {
		WebElement heading=DriverContext.getDriver().findElement(By.xpath("	//h3[text()='Checkout']"));
		return heading;
	}
	
	public double getTotalCartValue() {
		return Util.processPrice(txtTotalCartValue.getText());
	}
	
	public CheckoutPage getCheckOutPage() {
		WaitUtility.WaitForElementToBeVisable(checkOutHeading());
		return new CheckoutPage();			
	}
	
}

package com.jet.framework.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.jet.framework.base.Base;
import com.jet.framework.base.BasePage;
import com.jet.framework.base.DriverContext;
import com.jet.framework.utilities.WaitUtility;


public class ShowRestaurants extends BasePage{

	public ShowRestaurants() {
		super();
	}


	@FindBy(how = How.NAME,using ="search")
	public WebElement txtSearch;
	
	public WebElement getRestaurantCard(String restaurantName) {		
		return DriverContext.getDriver().findElement(By.xpath("//*[@data-qa='search-result-card-title' and text()='"+restaurantName+"']"));		
	}
	
	
	public void searchText(String text) {
		try {
			WaitUtility.WaitForElementToBeClickable(txtSearch);
			txtSearch.click();
			txtSearch.sendKeys(text);
		}
		catch(NoSuchElementException e) {
			logger.error("Unable to locate element: searchbox ");
			throw e;
		}
	}
	
	public void selectRestaurant(String restaurantName) {
		getRestaurantCard(restaurantName).click();
	}
	
	

}

package com.jet.framework.Pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.jet.framework.base.BasePage;




public class ShowRestaurants extends BasePage {

	public ShowRestaurants() {
		super();
	}


	@FindBy(how = How.NAME,using ="search")
	public WebElement txtSearch;
	
	public WebElement getRestaurantCard(String restaurantName) throws InterruptedException {
		Thread.sleep(5000);
		return wait.WaitForElementToBeClickableByXpath("//h3[@data-qa='search-result-card-title' and text()='"+restaurantName+"']");		
	}
	
	
	public void searchText(String text) {
		try {
			wait.WaitForElementToBeClickable(txtSearch);
			txtSearch.click();
			txtSearch.sendKeys(text);
		}
		catch(NoSuchElementException e) {
			logger.error("Unable to locate element: searchbox ");
			throw e;
		}
	}
	
	public void selectRestaurant(String restaurantName) throws InterruptedException {
		WebElement restautantCard=getRestaurantCard(restaurantName);
		restautantCard.click();
	}
	
}

package com.jet.framework.stepDefinitions;

import com.jet.framework.Pages.RestaurantPage;
import com.jet.framework.Pages.ShowRestaurants;
import com.jet.framework.base.BrowserType;
import com.jet.framework.base.DriverContext;
import com.jet.framework.base.FrameworkInitialize;
import com.jet.framework.connections.Settings;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CommonStepDefs extends FrameworkInitialize{
	
	 protected ShowRestaurants sr;
	 protected Object CurrentPage;
	 protected RestaurantPage rp=new RestaurantPage();
	  
	  /**
	 * @param browser : name of browser 
	 * description : this glue code launches the website in given browser. 
	 */
	@Given("^I launch the website on browser (\\w+)$")
	  public void launchWebsite(String browser) {	

		  InitializeBrowser(BrowserType.valueOf(browser));
		  sr=new ShowRestaurants();
		  String website=Settings.URL;
		  DriverContext.getDriver().get(website);
		  logger.info("Website "+website +" launched successfully on "+browser+" browser");
	  }
	
	
	  /**
	 * @param searchString : string to search in searchbox
	 * @throws Throwable
	 * description : search for given keyword.
	 */
	@When("^I search for \"(.*)\"$")
	    public void searchForKeyword(String searchString) throws Throwable {		
			sr.searchText(searchString);
			logger.info("Search successfull for '"+searchString+"'");
	  }
	
	  /**
	 * @param searchString : restaurant to select from search results
	 * @throws Throwable
	 * description : select desired restaurant.
	 */
	@When("^I select restaurant \"(.*)\"$")
	public void selectRestaurant(String searchString) {
		sr.selectRestaurant(searchString);
		logger.info("Restaurant '"+searchString+"' selected");
	}
	
	
	  /**
	 * @param FoodCategory : Menu option to be selected from navigation bar
	 * @throws Throwable
	 * description : selects menu option from navigation bar.
	 */
	@When("^I select menu option \"(.*)\"$")
	public void selectMenuItem(String FoodCategory) {
		rp=new RestaurantPage();
		rp.selectFoodItemCategory(FoodCategory);
		logger.info("Clicked menu option - "+FoodCategory);
	}
	
	
}
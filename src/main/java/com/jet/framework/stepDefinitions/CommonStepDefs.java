package com.jet.framework.stepDefinitions;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.jet.framework.Pages.CheckoutPage;
import com.jet.framework.Pages.RestaurantPage;
import com.jet.framework.Pages.ShowRestaurants;
import com.jet.framework.base.BrowserType;
import com.jet.framework.base.DriverContext;
import com.jet.framework.base.FrameworkInitialize;
import com.jet.framework.connections.Settings;
import com.jet.framework.utilities.Calculations;
import com.jet.framework.utilities.ExcelUtil;
import com.jet.framework.utilities.Util;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonStepDefs extends FrameworkInitialize{
	
	 protected ShowRestaurants sr;
	 protected Object CurrentPage;
	 protected RestaurantPage rp=new RestaurantPage();
	 protected CheckoutPage cop;
	 private Calculations calc=new Calculations();

	  
	  /**
	 * @param browser : name of browser 
	 * description : this glue code launches the website in given browser. 
	 */
	@Given("^I launch the website on browser (\\w+)$")
	  public void launchWebsite(String browser) {	

		  InitializeBrowser(BrowserType.valueOf(browser));
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
		    sr=new ShowRestaurants();
			sr.searchText(searchString);
			logger.info("Search successfull for '"+searchString+"'");
	  }
	
	  /**
	 * @param searchString : restaurant to select from search results
	 * @throws InterruptedException 
	 * @throws Throwable
	 * description : select desired restaurant.
	 */
	@When("^I select restaurant \"(.*)\"$")
	public void selectRestaurant(String searchString) throws InterruptedException {
		sr.selectRestaurant(searchString);
		logger.info("Restaurant '"+searchString+"' selected");
	}
	
	
	  /**
	 * @param FoodCategory : Menu option to be selected from navigation bar
	 * @throws InterruptedException 
	 * @throws Throwable
	 * description : selects menu option from navigation bar.
	 */
	@When("^I select menu option \"(.*)\"$")
	public void selectMenuItem(String FoodCategory) throws InterruptedException {
		Thread.sleep(10000);
		rp=new RestaurantPage();
		rp.selectFoodItemCategory(FoodCategory);
		logger.info("Clicked menu option - "+FoodCategory);
	}
	
	
	  /**
	 * @param DataTable : cucumber dataTable with 2 headers item and count. 'item' contains ; seperated food items 
	 * and count contains ; seperated count of each respective item to be added
	 * description : adds food items to cart
	 */
	@When("^I add food items in cart and verify total bill amount$")
	public void addItems(DataTable dt) {
		List<Map<String, String>> itemMap = dt.asMaps(String.class, String.class);
		List<String> foodItemNames=Arrays.asList(itemMap.get(0).get("item").split(";"));
 		List<Integer> foodItemCount=Util.stringListToInt(Arrays.asList(itemMap.get(0).get("count").split(";")));
		boolean result = rp.addItem(foodItemNames, foodItemCount);
		Assert.assertTrue(result==true, "item names and item count size is not same");
		List<Double> priceList = rp.getItemPrice(foodItemNames);		
		double totalAmountExpected = calc.calculateCartAmount(priceList, foodItemCount);
		double totalAmountActual=rp.getTotalCartValue();
		Assert.assertEquals(totalAmountActual, totalAmountExpected);
		logger.info("PASS: Total cart amount verified : "+totalAmountActual);
		rp.clickCheckout();
		logger.info("Clicked on checkout button");
	}

	 /**
	 *  description : checks out with address mentioned in excel and places order
	 */
	@When("^I checkout with cash and place the order$")
	public void checkout() {
		cop=rp.getCheckOutPage();
		LinkedHashMap<String, String> checkOutInfo = ExcelUtil.getRowData(0);		
		cop.checkOutWithCash(checkOutInfo);
		cop.placeOrder();
	}
	
	@Then("^verify error message (.*)$")
	public void verify(String errorExpected) throws IOException {
		String errorActual = cop.getErrorText();
		Util.takeScreenshot("errorScreenshot.png");
		Assert.assertTrue(errorActual.contains(errorExpected), "Expected and Actual error message mismatch. \nExpected : '"+errorExpected+"' \nActual : '"+errorActual+"'");
		logger.info("Message displayed on screen : "+ errorActual);
	}
	
	
}
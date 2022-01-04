package com.jet.framework.Pages;

import java.util.LinkedHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.jet.framework.base.BasePage;
import com.jet.framework.base.DriverContext;


public class CheckoutPage extends BasePage{
	
	public CheckoutPage() {
		super();
		
	}
	
	@FindBy(how = How.NAME,using ="streetName")
	public WebElement txtStreetName;
	
	@FindBy(how = How.NAME,using ="streetNumber")
	public WebElement txtHouseNumber;
	
	@FindBy(how = How.NAME,using ="postalCode")
	public WebElement txtPostalCode;
	
	@FindBy(how = How.NAME,using ="city")
	public WebElement txtCity;
	
	@FindBy(how = How.NAME,using ="fullName")
	public WebElement txtFullName;
	
	@FindBy(how = How.NAME,using ="email")
	public WebElement txtEmail;
	
	@FindBy(how = How.NAME,using ="phoneNumber")
	public WebElement txtPhoneNumber;

	public WebElement paymentMethodsHeading() {
		WebElement heading=DriverContext.getDriver().findElement(By.xpath("//div[@data-qa='payment-modal']//h2[text()='Payment methods']"));
		return heading;
	}
	
	public WebElement getErrorBanner() {
		WebElement banner = DriverContext.getDriver().findElement(By.xpath("//div[@data-qa='local-error-banner-delivery']"));
		return banner;
	}

	public void selectPayWith() {
		DriverContext.getDriver().findElement(By.xpath("//*[text()='Pay with']")).click();
	}
	
	public void selectPaymentOption(String Option) {
		DriverContext.getDriver().findElement(By.xpath("//div[@data-qa='payment-modal']//span[text()='"+Option+"']")).click();
	}
	
	public void clickDone() {
		DriverContext.getDriver().findElement(By.xpath("//div[@data-qa='payment-modal']//button[text()='Done']")).click();
	}
	
	public void placeOrder() {
		DriverContext.getDriver().findElement(By.xpath("//button[@data-qa='multi-step-checkout-action-submit-order']")).click();
	}
	
	public void addAddress(LinkedHashMap<String,String> checkOutInfo) {
		txtFullName.clear();
		txtFullName.sendKeys(checkOutInfo.get("Name"));
		
		txtStreetName.clear();
		txtStreetName.sendKeys(checkOutInfo.get("Address"));
		
		txtHouseNumber.clear();
		txtHouseNumber.sendKeys(checkOutInfo.get("HouseNr"));
		
		txtPostalCode.clear();
		txtPostalCode.sendKeys(checkOutInfo.get("PostCode"));
		
		txtCity.clear();
		txtCity.sendKeys(checkOutInfo.get("City"));
		
		txtPhoneNumber.clear();
		txtPhoneNumber.sendKeys(checkOutInfo.get("PhoneNum"));
		
		txtEmail.clear();
		txtEmail.sendKeys(checkOutInfo.get("e-mail"));
	}
	
	public void checkOutWithCash(LinkedHashMap<String,String> rowData) {
		logger.info("Placing order for customer with details : "+rowData);
		addAddress(rowData);		
		selectPayWith() ;
		wait.WaitForElementToBeVisable(paymentMethodsHeading());
		selectPaymentOption("Cash");
		clickDone();
	}
	
	public String getErrorText() {
		WebElement banner;
		
		try {
			banner=getErrorBanner();
			wait.WaitForElementToBeVisable(banner);
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			banner=getErrorBanner();
		}

		return banner.getText();
	}

}

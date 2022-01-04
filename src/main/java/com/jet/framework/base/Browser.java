package com.jet.framework.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.jet.framework.connections.Settings;

public class Browser extends Base{
	
	private WebDriver driver=null;
	
	
	public void InitializeBrowser(BrowserType browserType) {

		switch(browserType) {
			
			case Chrome: 
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\browserExeFiles\\chromedriver.exe");
     			ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				if(Settings.headless)
					options.addArguments("--headless");
				options.addArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling");
				driver = new ChromeDriver(options);
				break;
			}
			
			case Firefox:
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\browserExeFiles\\geckodriver.exe");
		        FirefoxOptions options = new FirefoxOptions();
		        if(Settings.headless)
		        	options.setHeadless(true);

				driver = new FirefoxDriver(options);
				break;
			}
			
			case IE:
			{
				break;
			}
			
			default:System.out.println("Invalid Browser");
		}
		
		DriverContext.setDriver(driver);
		DriverContext.setJSExecutor();
		logger.info(browserType.toString()+" browser initialized");
	}
	
	public void maximize() {
		DriverContext.getDriver().manage().window().maximize();
	}
	
	public void implicitWait(int TimeOut) {
		DriverContext.getDriver().manage().timeouts().implicitlyWait(TimeOut,TimeUnit.SECONDS);
	}
	
    public void GoToUrl(String url)
    {
        DriverContext.getDriver().get(url);
    }
	

}



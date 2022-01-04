package com.jet.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.jet.framework.base.Base;
import com.jet.framework.base.DriverContext;

public class Util extends Base {
	
	public static void takeScreenshot(String fileName) throws IOException {
		File sourceFile=((TakesScreenshot) DriverContext.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("screenshots/"+fileName));
		logger.info("Error screenshot captured at screenshots/"+ fileName);
	}
	
	public static List<Integer> stringListToInt(List<String> list){
		List<Integer> listInt=new ArrayList<>();
		for(String s:list)
			listInt.add(Integer.parseInt(s));
		return listInt;
		
	}
	
	public static double processPrice(String price) {
		return Double.parseDouble(price.replace(",", ".").split("€")[1].trim());	
	}
	
}

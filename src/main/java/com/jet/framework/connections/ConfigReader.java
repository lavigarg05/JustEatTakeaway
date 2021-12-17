package com.jet.framework.connections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
	
	public static void  loadConfig() throws FileNotFoundException, IOException {
		ConfigReader reader=new ConfigReader();
		reader.readConfig();
	}
	
	public void readConfig() throws FileNotFoundException, IOException {
		Properties prop=new Properties();
		prop.load(new FileInputStream("config/config.properties"));
		
		Settings.Logpath=prop.getProperty("Logpath");
		Settings.ExcelPath=prop.getProperty("ExcelPath");
		Settings.URL=prop.getProperty("URL");
		Settings.TimeoutExplicit=Integer.parseInt(prop.getProperty("TimeOutExplicit"));
		Settings.TimeoutImplicit=Integer.parseInt(prop.getProperty("TimeOutImplicit"));
		Settings.reportConfigPath=prop.getProperty("reportConfigPath");
		Settings.headless=Boolean.parseBoolean(prop.getProperty("headless"));
	}
}

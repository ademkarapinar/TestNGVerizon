package com.qa.verizon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver(String browserName){
		System.out.println("Browser name: "+browserName);
		
		if(browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			
			if(prop.getProperty("headless").equals("yes")){
				ChromeOptions co = new ChromeOptions();		
				driver = new ChromeDriver(co);
			}else{
				driver = new ChromeDriver();		
			}			
		}else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			if(prop.getProperty("headless").equals("yes")){
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver();
			}			
		}else if(browserName.equals("safari")){
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		}else{
			System.out.println("Browser name: "+browserName+ "is not found, please pass the correct browser");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	public Properties init_properties(){
		prop = new Properties();
		String path = "./src/main/java/com/qa/verizon/config/config.properties";
		try{
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		}catch(FileNotFoundException e){
			System.out.println("Some issue with config properties... Please correct your config...");
		}catch(IOException e){
			e.printStackTrace();
		}
		return prop;
	}
}

package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;

public class CustomizePhone extends BasePage{
	WebDriver driver;
	By shopBox = By.xpath("//*[@viewBox='0 0 13 15']");
	
	
	public CustomizePhone(WebDriver driver) {
		this.driver = driver;
	}
	public String getCustomizePageTitle(){
		return driver.getTitle();
	}
	public ShoppingCartPage customizePhone(){
		driver.findElement(shopBox).click();
		
		return new ShoppingCartPage(driver);
	}
	

}

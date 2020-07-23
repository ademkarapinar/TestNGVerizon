package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.verizon.base.BasePage;

public class PhoneListPage extends BasePage{
	
	WebDriver driver;
	By selectPhone = By.xpath("//span[text()= 'iPhone 11']");
	
	public PhoneListPage(WebDriver driver){
		this.driver = driver;
	}	
	public String getSmartPhoneListTitle(){
		return driver.getTitle();
	}	
	public SelectedPhonePage clickAPhone(){		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("scroll(0, 500);");
		
		WebElement aPhone = driver.findElement(selectPhone);
		aPhone.click();
		
		return new SelectedPhonePage(driver);	
	}	
}

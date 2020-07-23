package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ShoppingCartPage {
	WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getShoppingCartTitle(){
		return driver.getTitle();		
	}
	public void verifyPhone(){
		String text = driver.findElement(By.xpath("//*[@class='h2'] /span")).getText();
		System.out.println("I bought "+text);
		Assert.assertEquals(text, "iPhone 11");				
	}
}

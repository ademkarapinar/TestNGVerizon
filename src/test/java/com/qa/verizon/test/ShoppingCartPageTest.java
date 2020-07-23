package com.qa.verizon.test;
//passed
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.CustomizePhone;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.PhoneListPage;
import com.qa.verizon.pages.SelectedPhonePage;
import com.qa.verizon.pages.ShoppingCartPage;
import com.qa.verizon.util.AppConstants;

public class ShoppingCartPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	PhoneListPage phoneListPage;
	SelectedPhonePage selectedPhonePage;
	CustomizePhone customizePhone;
	ShoppingCartPage shoppingCartPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		
		homePage = new HomePage(driver);
		phoneListPage = homePage.mouseHoverAndClick(driver);
		phoneListPage = new PhoneListPage(driver);
		selectedPhonePage = phoneListPage.clickAPhone();
		selectedPhonePage = new SelectedPhonePage(driver);
		customizePhone = selectedPhonePage.selectPhoneFeatures();
		customizePhone = new CustomizePhone(driver);
		shoppingCartPage = customizePhone.customizePhone();
		shoppingCartPage = new ShoppingCartPage(driver);
	}
	@Test(priority=1)
	public void shoppingPageTitle(){
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, AppConstants.SHOPPING_CART_PAGE);
	}
	@Test(priority=2)
	public void verifyPhoneTest(){
		shoppingCartPage.verifyPhone();
	}	
    @AfterTest
    public void tearDown(){
	//driver.quit();
   }
}
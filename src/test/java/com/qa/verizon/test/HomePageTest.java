package com.qa.verizon.test;
//it passed
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.util.AppConstants;

public class HomePageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
     	homePage = new HomePage(driver);
	}	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is " + title);
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
	}
	@Test(priority=2)
	public void mouseHoverAndClickTest(){
		homePage.mouseHoverAndClick(driver);
	}	
	@AfterTest
	public void tearDown(){
//		driver.quit();
	}
}

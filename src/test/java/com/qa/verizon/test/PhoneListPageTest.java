package com.qa.verizon.test;
//passed
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.HomePage;
import com.qa.verizon.pages.PhoneListPage;
import com.qa.verizon.util.AppConstants;

public class PhoneListPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	PhoneListPage phoneListPage;
	HomePage homePage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		homePage = new HomePage(driver);
		phoneListPage = homePage.mouseHoverAndClick(driver);
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void verifyPhonesListTitleTest() {
		String title = driver.getTitle();
		System.out.println("SmartPhones list title is: " + title);
		Assert.assertEquals(title, AppConstants.PHONE_LIST_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void clickAPhoneTest() throws InterruptedException {
		phoneListPage.clickAPhone();
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}

}

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
import com.qa.verizon.pages.SelectedPhonePage;
import com.qa.verizon.util.AppConstants;

public class SelectedPhonePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	PhoneListPage phoneListPage;
	SelectedPhonePage selectedPhonePage;

	@BeforeTest
	public void setUp() {
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
	}
	@Test(priority = 1)
	public void selectedPhonePageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Selected phone page title is: " + title);
		Assert.assertEquals(title, AppConstants.SELECTED_PHONE_PAGE);
	}
	@Test(priority = 2)
	public void selectPhoneFeaturesTest() throws InterruptedException {
		selectedPhonePage.selectPhoneFeatures();
	}
	@AfterTest
	public void tearDown() {
//		driver.quit();
	}
}

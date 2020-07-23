package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.verizon.base.BasePage;

	public class SelectedPhonePage extends BasePage{
		
		WebDriver driver;
		By yellowColor = By.xpath("//div[@style='background-color: rgb(251, 229, 128);']");
		By capacity = By.xpath("//*[text()='256GB']");
		By price = By.xpath("//div[@class='cursorPointer height100p positionRelative border_grayThree ']");
		By continueButton = By.id("ATC-Btn");
		By zipcode = By.id("zipcode");
		By confirmButton = By.xpath("//button[@class='defaultPrimaryCTA ']");
		By newCustomerBtn = By.xpath("//button[@class='modalButton fontSize_12 NHaasDS55Rg background_FF onlyRightMargin margin8']");
		
		public SelectedPhonePage(WebDriver driver){
			this.driver = driver;
		}	
		public String selectedPhonePageTitle(){
			return driver.getTitle();
		}		
		public CustomizePhone selectPhoneFeatures() throws InterruptedException{
			driver.findElement(yellowColor).click();
			driver.findElement(capacity).click();
			driver.findElement(price).click();
			driver.findElement(continueButton).click();
			driver.findElement(zipcode).clear();
			Thread.sleep(3000);
			driver.findElement(zipcode).sendKeys("45431");
			driver.findElement(confirmButton).click();
			driver.findElement(newCustomerBtn).click();		
			
			return new CustomizePhone(driver);
		}
}

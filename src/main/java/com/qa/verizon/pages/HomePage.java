package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.qa.verizon.base.BasePage;

public class HomePage extends BasePage{
		
		WebDriver driver;
		By phones = By.xpath("((//*[@class='gnav20-navigation'])[2]//following-sibling::button[2])[1]"); // mousehover
		By smartPhone = By.xpath("((//*[@item-title='L2']//following::a)//following-sibling::a)[1]");//click		
		
		//constructor
		public HomePage(WebDriver driver){
			this.driver = driver;
		}		
		//page title method
		public String getHomePageTitle(){
			return driver.getTitle();
		}	
		public PhoneListPage mouseHoverAndClick(WebDriver driver){  //it was void but we returned to
			WebElement element1 = driver.findElement(phones);         //   phonelistpage 
			Actions actions = new Actions(driver);
			actions.moveToElement(element1).build().perform();
			
			WebElement element2 = driver.findElement(smartPhone);
			element2.click();
			
			return new PhoneListPage(driver);    //to go to next page 			
		}
}

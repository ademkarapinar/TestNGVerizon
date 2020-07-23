package com.qa.verizon.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.verizon.util.AppConstants;

public class ElementUtil {
	WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtil(WebDriver driver){
		this.driver=driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIMEOUT);
	}
	/**
	 * wait for title
	 * @param title
	 * @return
	 */
	public boolean waitForTitlePresent(String title){
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}
	/**
	 * presence of element
	 * @param locator
	 * @return
	 */
	public boolean waitForElementPresent(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	/**
	 * visibilityOfElement
	 * @param locator
	 * @return
	 */
	public boolean waitForElementVisible(By locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	/**
	 * @author adem
	 * get title method
	 * @return
	 */
	public String doGetPageTitle(){
		try {
			return driver.getTitle();
		} catch (Exception e) {
         System.out.println("Some exception got occured while getting the title...");		
    }
		return null;			
	}
	/**
	 * getElement
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator){
		WebElement element = null;
		try {
//			if(waitForElementPresent(locator));   
			element = driver.findElement(locator);
		} catch (Exception e) {
	         System.out.println("Some exception got occured while creating web element..." + locator);		
		}
		return element;
	}
	/**
	 * doClickMethod
	 * @param locator
	 */
	public void doClick(By locator){
		try {
			getElement(locator).click();
		} catch (Exception e) {
	         System.out.println("Some exception got occured while clicking web element..."+locator);		
		}
	}
	/**
	 * doSendKeysMethod
	 * @param locator
	 * @param value
	 */
		public void doSendKeys(By locator, String value){
			try {
				WebElement element = getElement(locator);
				element.clear();
				element.sendKeys(value);
			} catch (Exception e) {
		         System.out.println("Some exception got occured while entering value..."+locator);		
			}
		}
		/**
		 * isDisplayedMethod
		 * @param locator
		 * @return
		 */
		public boolean doIsDisplayed(By locator){
			try {
				return getElement(locator).isDisplayed();
			} catch (Exception e) {
		         System.out.println("Some exception got occured while isDisplayed..."+locator);		
			}
			return false;
		}
		/**
		 * isEnabledMethod
		 * @param locator
		 * @return
		 */
		public boolean doIsEnabled(By locator){
			try {
				return getElement(locator).isEnabled();
			} catch (Exception e) {
		         System.out.println("Some exception got occured while isEnabled..."+locator);		
			}
			return false;
		}
		/**
		 * IsSelectedMethod
		 * @param locator
		 * @return
		 */
		public boolean doIsSelected(By locator){
			try {
				return getElement(locator).isSelected();
			} catch (Exception e) {
		         System.out.println("Some exception got occured while IsSelected..."+locator);		
			}
			return false;
		}
		/**
		 * doGetTextMethod
		 * @param locator
		 * @return
		 */
		public String doGetText(By locator){
			try {
				return getElement(locator).getText();
			} catch (Exception e) {
		         System.out.println("Some exception got occured while getting text..."+locator);		
			}
			return null;
		}

}

package com.selenium.po;

/*
 * INCOMPLETE-UNABLE TO LAUNCH A BLANK WEBPAGE AND OPENING THE AUT PAGE IN A NEW TAB
 */

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchTabsPageObjectFactory {

	private static String googleBrowserPage="https://www.google.com/";
	
	@FindBy(name = "q")
	public WebElement searchField;
	
	@FindBy(css = "body")
	public WebElement pageBody;
	
	public String pageURL(WebDriver webdriver) {

		webdriver.manage().window().maximize();
		return googleBrowserPage;
	}
	
	 public void openNewTab(WebDriver webdriver){
		 pageBody.sendKeys(Keys.CONTROL + "t");
		 ArrayList<String> tabs = new ArrayList<String>(webdriver.getWindowHandles());
		 webdriver.switchTo().window(tabs.get(0));
	 }
	 
	 	
	
	public SwitchTabsPageObjectFactory initialiseElements(WebDriver webdriver) {
		PageFactory.initElements(webdriver, SwitchTabsPageObjectFactory.this);
		return SwitchTabsPageObjectFactory.this; 
	}
	
}

package com.selenium;
//POM: switch between tabs
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.po.YahooGoogleSwitchTabPageObject;

public class YahooGoogleSwitchTabPageObjectTest {

	private YahooGoogleSwitchTabPageObject pgobj;
	private WebDriver webdriver;
	private Actions actions;
	private WebElement searchFieldElement;
	
	@Before
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	webdriver = new ChromeDriver();
	actions = new Actions(webdriver);
	pgobj = new YahooGoogleSwitchTabPageObject();
	
	}

	@After
	public void tearDown() throws Exception {
	
		webdriver.quit();
	}

	@Test
	public void testYahooGoogleSwitchTabPageObject() throws InterruptedException {
		/*
		 //search 'Yahoo' in Google
		//click on Yahoo link
		//enter text "Google" in Yahoo search box
		//click on Google URL:it will open in a new tab [finding Google URL by id or CSS will not work because these are generated dynamically and so different everytime. Use XPath ]
		//navigate(i.e switchTo(tabs.get(1))) to the new tab and wait a bit to see the tab switch thru naked eye
		//now navigate(i.e switchTo(tabs.get(0))) back to yahoo search page
		//assert whether correct tab have been switched to
		 */
		webdriver.get(pgobj.pageURL(webdriver));
		searchFieldElement = pgobj.findGoogleSearchField(webdriver);
		actions.sendKeys(searchFieldElement, "Yahoo").perform();
		actions.sendKeys(Keys.ENTER).perform();
		actions.click(pgobj.clickYahooURL(webdriver)).perform();
		searchFieldElement = pgobj.findYahooSearchField(webdriver);
		actions.sendKeys(searchFieldElement, "Google").perform();
		actions.sendKeys(Keys.ENTER).perform();
		actions.click(pgobj.clickGoogleURL(webdriver)).perform();
		ArrayList<String> tabs = new ArrayList<String> (webdriver.getWindowHandles());
		webdriver.switchTo().window(tabs.get(1));
		new WebDriverWait(webdriver,YahooGoogleSwitchTabPageObject.waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(YahooGoogleSwitchTabPageObject.googleSearchFieldbyCSS)));
		//System.out.println("tab name: "+ webdriver.switchTo().window(tabs.get(0)).getTitle());
		assertEquals("google - Yahoo India Search Results",webdriver.switchTo().window(tabs.get(0)).getTitle());
	}

}

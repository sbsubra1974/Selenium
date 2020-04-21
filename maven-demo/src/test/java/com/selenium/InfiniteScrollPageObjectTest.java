package com.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.selenium.po.InfiniteScrollPageObject;

public class InfiniteScrollPageObjectTest {

	WebDriver webdriver;
	InfiniteScrollPageObject pgobj;
	private WebElement element;
	private JavascriptExecutor js;
	Actions actions;
	private String testString = "Infinite scroll rest of site";

	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		pgobj = new InfiniteScrollPageObject();	
		js = (JavascriptExecutor) webdriver;
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testfindElementToScrollTo() {
		//open page to be tested
		//find the element to scroll to in DOM
		//scroll till the element
		//assert whether the correct element was scrolled to 
		webdriver.get(pgobj.pageURL(webdriver));
		element = pgobj.findElementToScrollTo(webdriver,js);

		System.out.println("Element Text: "+ element.getText());
		assertTrue(testString.contentEquals(element.getText()));
		
	}

}

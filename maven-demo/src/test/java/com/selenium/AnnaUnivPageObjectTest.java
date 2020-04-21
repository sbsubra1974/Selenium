package com.selenium;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.po.AnnaUnivPageObject;

public class AnnaUnivPageObjectTest {

	WebDriver webdriver;
	AnnaUnivPageObject obj;
	private java.util.List<WebElement> elements;
	private WebElement element;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		webdriver = new ChromeDriver();
		obj = new AnnaUnivPageObject();
	}

	@After
	public void tearDown() throws Exception {

		webdriver.quit();
	}

	@Test //should contain only user actions and assertions
	public void test1() {
		webdriver.get(obj.pageURL()); //this is a user action-hence written for every test and is not part of setUp()
		assertEquals("https://www.annauniv.edu/",webdriver.getCurrentUrl());	
	}
	
	@Test //incomplete:
	//attempt to iterate elements with a common tag name, get the tag name you want, try various ways to click it
	//attempt to click on an element which is partially hidden but shows up as normal on the browser page (anna univ)
	public void test2() /*throws InterruptedException required for Thread.sleep()*/ {
		webdriver.get(obj.pageURL()); //open webpage to perform user actions on
		elements=obj.findAllTagsOnPage(webdriver); //locater strategy: tag name will slow down the test
		Iterator<WebElement> iterator = elements.iterator();
	   try {
		while(iterator.hasNext()) {	    	  		
	    	  		//when you find the tag with text 'Centres' exit the while loop and click on it
	    	  		WebElement webelement = iterator.next(); 
	    	  		String btnLabl=webelement.getAttribute("text");
	    	  		if (btnLabl.compareTo("Centres")==0)
	    	  		{
	    	  			System.out.println(btnLabl);
	    	  			//System.out.println(webelement.getTagName());
	    	  			//webelement.sendKeys(Keys.ENTER);
	    	  			//WebDriverWait wait = new WebDriverWait(webdriver, 5);   // wait for 5 seconds
	    	  			//wait.until(ExpectedConditions.elementToBeClickable(webelement));
	    	  			
	    	  			
	    	  			
	    	  			System.out.println("X:"+ webelement.getLocation().getX());
	    	  			//Thread.sleep(20000);
	    	  			
	    	  			
	    	  			Actions actions = new Actions(webdriver); //move the mouse around a bit to get the handover
	    	  			//actions.moveToElement(webelement,webelement.getLocation().getX(),webelement.getLocation().getY()).click(webelement).perform();
	    	  			//actions.moveByOffset(webelement.getLocation().getX(),webelement.getLocation().getY());
	    	  			
	    	  				actions.click(webelement);
	    	  			
	    	  			break;
	    	  		}
	      		}
	   }
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	@Test	
	public void test3() {
		webdriver.get(obj.pageURL()); //open webpage to perform user actions on
		element = obj.getCentresButtonXPath(webdriver);
		
		//using Javascript is OK. Selenium webdriver allows it(via JavascriptExecutor Interface) for difficult to work with elements
		JavascriptExecutor jse = (JavascriptExecutor)webdriver; //JavascriptExecutor Interface as a data type? Yes! See https://docs.oracle.com/javase/tutorial/java/IandI/interfaceAsType.html
		jse.executeScript("arguments[0].click();", element);
		
	}	
}

//For 10th March:
//Try JavascriptExecutor for the following:-
//1.Mouse pointer not changing to the hand on hover interaction
//2.Mouse pointer does not physically move while executing click command via webdriver
//3.Click action not working on pop-up window button
//Start with IMDB pageObject [OK]

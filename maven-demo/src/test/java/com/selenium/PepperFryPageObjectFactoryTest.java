package com.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.hamcrest.MatcherAssert;

import com.selenium.po.PepperFryPageObjectFactory;
import com.selenium.util.BoilerPlateClass;

public class PepperFryPageObjectFactoryTest extends BoilerPlateClass{

	private static PepperFryPageObjectFactory pgobj;

	@Before
	public void setUp() throws Exception {
	
		setupWebdriver();
		pgobj = new PepperFryPageObjectFactory();		
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void alertPopUptest() throws InterruptedException {
		//open test page
		//initialise webelements in the page
		//wait for the frame to be shown containing the alert
		//switch to the frame
		//click on the top right X icon to close the alert
		//wait for the form to be shown as popup
		//click on the top right X icon to close the alert
		//assert whether the alerts[any one] were closed (and hence not visible or displayed anymore)
		
		webdriver.get(pgobj.pageURL(webdriver));
		pgobj=pgobj.initialiseElements(webdriver);		
		
		new WebDriverWait(webdriver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("webklipper-publisher-widget-container-notification-frame")));
		actions.click(pgobj.happycodeAlertIcon).perform();
		
		new WebDriverWait(webdriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("signup-form")));
		actions.click(pgobj.cashbackCloseIcon).perform();
		
		//assertThrows confirms the alert was closed and not available anymore
		assertThrows("error!",NoSuchElementException.class,() ->
		{
			ExpectedConditions.presenceOfElementLocated(By.id("signup-form"));
			
		});		

	}
	
	@Test
	public void CSSDecorationColortest() throws InterruptedException {
		//open test page
		//initialise webelements in the page
		//close expected alert and popup
		//then perform mouse hover		

		webdriver.get(pgobj.pageURL(webdriver));
		pgobj=pgobj.initialiseElements(webdriver);		
	
		new WebDriverWait(webdriver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("webklipper-publisher-widget-container-notification-frame")));
		actions.click(pgobj.happycodeAlertIcon).perform();
		
		new WebDriverWait(webdriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("signup-form")));
		actions.click(pgobj.cashbackCloseIcon).perform();
		
		actions.moveToElement(pgobj.linkText).perform();
		new WebDriverWait(webdriver, 5).until(ExpectedConditions.elementToBeClickable(pgobj.linkText));
		System.out.println("CSS: "+pgobj.linkText.getCssValue("text-decoration-color")); //mouse hover colour change not possible with selenium. And shouldn't be tested too-since it will be the browser behaviour and not that of UI under test. A very low priority for the user 
	}
	
	@Test
	public void toolTipTextTest() {
		//open test page
		//initialise webelements in the page
		//assert the tool tip of the image (imageelement.getattribute)

		webdriver.get(pgobj.pageURL(webdriver));
		pgobj = pgobj.initialiseElements(webdriver);
		assertEquals(pgobj.monumentsIcon.getAttribute("title"),"monument");
		
	}
}

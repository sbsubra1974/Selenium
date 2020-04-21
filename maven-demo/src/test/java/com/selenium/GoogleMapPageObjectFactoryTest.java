package com.selenium;
//POM: Static elements with PageFactory + Dynamically generated element w/o PageFactory, screenshots from com.selenium.util pkg
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.selenium.po.GoogleMapPageObjectFactory;
import com.selenium.util.ScreenShotClass;

public class GoogleMapPageObjectFactoryTest extends ScreenShotClass {

	private WebDriver webdriver;
	private WebElement element;
	private Actions actions;
	private GoogleMapPageObjectFactory pgobj;
	private String testString;
	private String screenshotFilePathStart="F:\\Users\\User\\eclipse-workspace\\maven-demo\\screenshots\\GoogleMapPageObjectFactoryTest-start.jpg";
	private String screenshotFilePathEnd="F:\\Users\\User\\eclipse-workspace\\maven-demo\\screenshots\\GoogleMapPageObjectFactoryTest-end.jpg";
	
	@Before
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	webdriver = new ChromeDriver();
	actions = new Actions(webdriver);
	pgobj = new GoogleMapPageObjectFactory();
	}

	@After
	public void tearDown() throws Exception {
		webdriver.quit();
	}

	@Test
	public void testGoogleMapPageObjectFactory()  {
		/*
		 * 1. Go to the below URL: https://www.google.com/maps/

			2. Capture the screenshot at the start
			
			3. Type and search for the below Address:(use k/b)
			Harvard Business School, Boston, MA 02163, United States
			
			4. Verify the Text Present “Harvard Business School” in the header of location card
			
			5. Assert phone number +(617) 495-6000 present within the inline popup window.
			
			6. Display the rating number in the log of IDE
			
			7. Capture the screenshot at the end
			
			8. Save and view the screen shots
		 */
		
	webdriver.get(pgobj.pageURL(webdriver));
	
	try {
		ScreenShot(webdriver,screenshotFilePathStart);
	}catch (Exception e) {
		
	}
	
	pgobj=pgobj.InitialiseElements(webdriver);
	testString = "Harvard Business School, Boston, MA 02163, United States";
	actions.sendKeys(pgobj.searchBox,testString).perform();
	
	actions.sendKeys(pgobj.searchBox,Keys.ENTER).perform();
	element = pgobj.findSectionHeader(webdriver);
	assertTrue(element.getText().contains("Harvard Business School"));
	
	element = pgobj.findPhoneNumber(webdriver);
	testString = "+1 617-495-6000";
	assertArrayEquals(testString.toCharArray(),element.getText().trim().toCharArray());
	
	try {
		ScreenShot(webdriver,screenshotFilePathEnd);
	}catch (Exception e) {
		
	}
	
	element = pgobj.findRatingNumber(webdriver);
	System.out.println("pgobj.findRatingNumber: "+element.getText().trim());
	
	}

}

package com.selenium;
//POM: 
//Youtube popups: switch over to iframe containing popup, click close icon on the popup, switch back to parent DOM
//drag and drop
//to assert two character strings

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.selenium.po.DragandDropPageObject;

public class DragandDropPageObjectTest {

	DragandDropPageObject pgobj;
	WebDriver webdriver;
	WebElement videoAlertiFrame,videoAlertElement,sourceElement,targetElement,targetContentElement;
	Actions actions;	
	
	@Before
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	webdriver = new ChromeDriver();
	pgobj = new DragandDropPageObject();
	actions = new Actions(webdriver);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDragAndDropPageObject() {
		//open the webpage to test
		//switch over to the iFrame containing the video alert and close the video alert before identifying source and target which may show up on the page
		//switch back to parent DOM
		//identify the element to drag (source)
		//identify the element to drop to (target)
		//perform the drag and drop action
		//get the dropped text at target using Element.getText() [and not Element.getAttribute("text")]
		//assert the element was dropped correctly
	webdriver.get(pgobj.pageURL(webdriver));	
	videoAlertiFrame = pgobj.findVideoAlertFrame(webdriver);	
	webdriver.switchTo().frame(videoAlertiFrame);
	videoAlertElement = pgobj.findVideoAlert(webdriver);	
	actions.click(videoAlertElement).perform(); //make sure to create actions object first to avoid null pointer exception
	webdriver.switchTo().defaultContent();
	sourceElement = pgobj.findSourceElement(webdriver); 
	targetElement = pgobj.findTargetElement(webdriver);	
	//System.out.println("sourceElement: "+sourceElement.getAttribute("text"));
	//System.out.println("targetElement: "+targetElement.getAttribute("class"));	
	actions.dragAndDrop(sourceElement, targetElement).perform();	
	targetContentElement = pgobj.findTargetLocationContent(webdriver);	
	//System.out.println("targetContentElement: "+targetContentElement.getText()); 
	assertArrayEquals("equal",sourceElement.getAttribute("text").strip().toCharArray(),targetContentElement.getText().strip().toCharArray());
	
	
	}

}

package com.selenium;

import static org.junit.Assert.*;

import java.util.List;

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

import com.selenium.po.SelectFromDropDownPageObjectFactoryList;

public class SelectFromDropDownPageObjectFactoryListTest {
	
	private WebDriver webdriver;
	private WebElement element;
	private Actions actions;
	private SelectFromDropDownPageObjectFactoryList pgobj;
	private static int wait = 5;
	private List<WebElement> elements;
	
	@Before
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	webdriver = new ChromeDriver();
	actions = new Actions(webdriver);
	pgobj = new SelectFromDropDownPageObjectFactoryList();
	}

	@After
	public void tearDown() throws Exception {
	
		webdriver.quit();
	}

	@Test
	public void testSelectFromDropDownPageObjectFactoryList() {
		
		/* 	1. Go to http://jqueryui.com/autocomplete/
			2. Switch over to the iFrame that contains the widget in which textfield is located
			3. wait for the textfield to  be shown
			4. Type 'j' in the Tags textfield (present on the iFrame)
			5. Get all the full resultset (resultset list element is dynamically created AJAX element:hence w/o pagefactory)
			6. Assert whether the List size is at-least 3-if not abort
			7. Clear textfield (i.e remove search text "j")
			8. select 3rd search result from the list
			9. Type the 3rd search result in the textfield using actions.sendkeys (once you enter the 3rd search result in text field, the list size will reduce to 1 because other items previously present will now disappear)
			10. Assert whether the third search result was correctly entered in the textfield (to fetch the entered text in a JQuery AJAX textield, use textfieldelement.getAttribute("value") and not textfield.getText())
			11. Switch back to the parent window and exit
		  */
		webdriver.get(pgobj.pageURL(webdriver));
		pgobj=pgobj.initialisePageElements(webdriver);

		webdriver.switchTo().frame(pgobj.iframeElement);
		new WebDriverWait(webdriver, wait).until(ExpectedConditions.visibilityOf(pgobj.autoCompleteField));
		actions.sendKeys(pgobj.autoCompleteField, "j").perform();
		
		elements=pgobj.findResultsetList(webdriver);
		

		assertTrue(elements.size()>=3); //junit will continue if assertTrue passes else it will abort
		
		actions.sendKeys(pgobj.autoCompleteField,Keys.CLEAR);
		actions.sendKeys(pgobj.autoCompleteField, elements.get(2).getText()).perform(); 
		
		
		assertArrayEquals("equal",elements.get(2).getText().toCharArray(),pgobj.autoCompleteField.getAttribute("value").strip().toCharArray());
		webdriver.switchTo().defaultContent();


}
}

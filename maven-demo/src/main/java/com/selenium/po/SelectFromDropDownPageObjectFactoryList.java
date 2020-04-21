package com.selenium.po;
//POM find elements with Selenium built-in PageFactory for static elements+
//find elements w/o pagefactory for dynamically created AJAX elements

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SelectFromDropDownPageObjectFactoryList {

	private static String browserPage = "http://jqueryui.com/autocomplete/";
	
	@FindBy(id = "tags")
	public WebElement autoCompleteField; //this element can't be accessed from test class if made private
	
	@FindBy(css = "#content > iframe")
	public WebElement iframeElement;
	
	//@FindBy(css = "#ui-id-1")
	//WebElement unsortedResultList;

	private WebElement element;
	private List<WebElement> elements;
	private static int waitDuration = 5;
	
	private static String unsortedResultListbyCSS="#ui-id-1"; //This element is created at runtime AFTER the user types a search text(e.g "j"). Pagefactory will not recognize it.
	private static String sortedListItemsbyClassName="ui-menu-item"; //This element is created at runtime AFTER the user types a search text(e.g "j"). Pagefactory will not recognize it.
	
	public String pageURL(WebDriver webdriver) {
		
		webdriver.manage().window().maximize();
		
		return browserPage;
	}
	
	public SelectFromDropDownPageObjectFactoryList initialisePageElements(WebDriver webdriver) {

		PageFactory.initElements(webdriver, SelectFromDropDownPageObjectFactoryList.this);
		
		return SelectFromDropDownPageObjectFactoryList.this;
		
		}
	
	public List<WebElement> findResultsetList (WebDriver webdriver) { 
		
		try {
			
			//first find the unsorted list (ul)
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(unsortedResultListbyCSS)));
			//then find all the list nodes present within ul
			elements = element.findElements(By.className(sortedListItemsbyClassName));
			
		}catch (StaleElementReferenceException e) {
			System.out.println("Error: "+ e.getMessage());
		}
		catch (NoSuchElementException e) {
			System.out.println("Error: "+ e.getMessage());			
		}
		catch (ElementNotVisibleException e) {
			System.out.println("Error: "+ e.getMessage());			
		}
		catch (MoveTargetOutOfBoundsException e) {
			System.out.println("Error: "+ e.getMessage());			
		}
	
		return elements;
}
}

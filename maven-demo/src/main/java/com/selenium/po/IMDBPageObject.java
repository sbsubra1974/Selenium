package com.selenium.po;
//POM
//Tip: These pages are stored as objects, which will contain specific information about how the web page is composed and how actions are performed– very little of which should concern you as a tester.

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IMDBPageObject {

	private static String browserPage = "https://www.imdb.com/";
	private static WebElement element;
	private static List<WebElement> elements;
	private static String searchFieldCSS = "#suggestion-search";
	private static String unorderedMovielistXPath = "//*[@id=\"nav-search-form\"]/div[2]/div/div/div/ul";/*/li";*/
	private static String unorderdMovielistNodesTagName = "li";
	private static int waitDuration = 5;
	
	public String pageURL(WebDriver webdriver) {
		webdriver.manage().window().maximize();
		return browserPage; 
	}
	
	public WebElement findSearchField(WebDriver webdriver) {
		
	try {
		element = webdriver.findElement(By.cssSelector(searchFieldCSS));
	
		}catch (NoSuchElementException e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
		return element;
	} 
	
	public WebElement waitAndFindSearchField(WebDriver webdriver) {
		
		try {
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(searchFieldCSS)));			
	
			
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
		
		return element;
	}
	
	public List<WebElement> waitAndFindMovieList (WebDriver webdriver) { 
		
		try {
			
			//first find the unsorted list (ul)
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unorderedMovielistXPath)));
			//then find all the list nodes present within ul
			elements = element.findElements(By.tagName(unorderdMovielistNodesTagName));
			
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

	public WebElement waitAndFindMoviePage(WebDriver webdriver, String xPathLocator) { //xPathLocator of the element to be asserted should come from the test case-because element to be asserted can change at end user's discretion. Hence, do not declare it as a constant in POM class
		
		try {
			
			System.out.println(webdriver.getTitle());
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathLocator)));
		
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
		return element;
	}

}
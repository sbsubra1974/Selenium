package com.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooGoogleSwitchTabPageObject {

	private WebElement element;
	private static String googleBrowserPage = "https://www.google.co.in/";
	private static String yahoobrowserPageHyperlinkbyCSS = "#rso > div:nth-child(1) > div > div > div.r > a > h3";
	public static String googleSearchFieldbyCSS = "#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input";
	private static String yahooSearchFieldbyId = "header-search-input";
	private static String googlebrowserPageHyperlinkbyXPath = "/html/body/div[1]/div[3]/div/div/div[1]/div/div/div/div/ol/li[1]/div/div[1]/h3/a"; //id and CSS will not work because they are generated dynamically and hence different each time
	public static int waitDuration = 5;
	
	public String pageURL(WebDriver webdriver) {

		webdriver.manage().window().maximize();
		return googleBrowserPage;
	}
	
	public WebElement findGoogleSearchField(WebDriver webdriver) {
		
		try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(googleSearchFieldbyCSS)));			
			
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
	
	public WebElement clickYahooURL(WebDriver webdriver) {
		
		try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(yahoobrowserPageHyperlinkbyCSS)));			
			
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
	
	public WebElement findYahooSearchField(WebDriver webdriver) {
		
		try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.id(yahooSearchFieldbyId)));			
			
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
	
	public WebElement clickGoogleURL(WebDriver webdriver) {
		
		try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.xpath(googlebrowserPageHyperlinkbyXPath)));			
			
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

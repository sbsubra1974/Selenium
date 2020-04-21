package com.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfiniteScrollPageObject {

	private static String browserPage = "https://infinite-scroll.com/";
	private static String scrollButtonByClass = "site-scroll";
	WebElement element; 
	private static int waitDuration = 5;
	
	public String pageURL(WebDriver webdriver) {
		
		webdriver.manage().window().maximize();
		
		return browserPage;
	}
	
	public WebElement findElementToScrollTo(WebDriver webdriver,JavascriptExecutor js) {
		
		try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.className(scrollButtonByClass)));			
			
			//This will scroll the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", element);
			
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

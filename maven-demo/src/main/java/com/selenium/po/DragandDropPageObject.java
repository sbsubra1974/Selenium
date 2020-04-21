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

public class DragandDropPageObject {

	private static String browserPage = "http://demo.guru99.com/test/drag_drop.html";
	private static String videoAlertFrameById = "flow_close_btn_iframe"; 
	private static String closeButtonByCSS = "#closeBtn";
	private static String sourceElementbyXPath = "//*[@id=\"fourth\"]/a"; //webpage contains list of buttons with same Li class[block13 ui-draggable],id[fourth], selector and but different text[' 5000 ' vs ' 5000']. Selenium will pick the first one that is finds. That is fine with us
	private static String targetElementbyCSS = "#amt7 > li";
	private static String targetLocationContentbyCSS = "#amt7 > li";
	private WebElement element;
	private static int waitDuration = 5;
	
	public String pageURL(WebDriver webdriver) {
		
		webdriver.manage().window().maximize();
		
		return browserPage;
	}
	
	public WebElement findVideoAlertFrame(WebDriver webdriver) {
	
		try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.id(videoAlertFrameById)));			
			
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
	
	public WebElement findVideoAlert(WebDriver webdriver) {
	
		try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector((closeButtonByCSS))));			
						
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
	
	public WebElement findSourceElement(WebDriver webdriver) {
		
	try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.xpath(sourceElementbyXPath)));			
			
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
	
	public WebElement findTargetElement(WebDriver webdriver) {
		
	try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(targetElementbyCSS)));			
			
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
	
	public WebElement findTargetLocationContent(WebDriver webdriver) {
		
		try {
		
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(targetLocationContentbyCSS)));
			
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

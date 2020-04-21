package com.selenium.po;

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

public class GoogleMapPageObjectFactory {

	private static String browserPage = "https://www.google.com/maps/";
	private static int waitDuration = 15;
	
	//Static elements: OK to use @FindBy [i.e you can use PageObjectFactory]
	@FindBy(css="#searchboxinput")
	public WebElement searchBox; //keep it public-we will access it from test class

	//Dynamically generated elements: Do not use @FindBy [i.e do not use PageObjectFactory]
	WebElement element;
	private static String sectionHeaderbyCSS = "#pane > div > div.widget-pane-content.scrollable-y > div > div > div.section-hero-header-title > div.section-hero-header-title-description";
	private static String widgetPaneLinkPhNumbyCSS="#pane > div > div.widget-pane-content.scrollable-y > div > div > div:nth-child(13) > div > div.section-info-line > span.section-info-text > span.widget-pane-link";
	private static String ratingNumberbyCSS="#pane > div > div.widget-pane-content.scrollable-y > div > div > div.section-hero-header-title > div.section-hero-header-title-description > div.section-hero-header-title-description-container > div > div.GLOBAL__gm2-body-2.section-rating-line > span:nth-child(1) > span > span";
		
	public String pageURL(WebDriver webdriver) {
		
		webdriver.manage().window().maximize();
		
		return browserPage;
		
	}
	
	public GoogleMapPageObjectFactory InitialiseElements(WebDriver webdriver) {
		
		PageFactory.initElements(webdriver, GoogleMapPageObjectFactory.this);		
		
		return GoogleMapPageObjectFactory.this;
	}
	
	public WebElement findSectionHeader(WebDriver webdriver) {
		
		try {
		
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(sectionHeaderbyCSS)));
			
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

	public WebElement findPhoneNumber(WebDriver webdriver) {
		
		try {
		
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(widgetPaneLinkPhNumbyCSS)));
			
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

	public WebElement findRatingNumber(WebDriver webdriver) {
		
		try {
		
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ratingNumberbyCSS)));
		
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

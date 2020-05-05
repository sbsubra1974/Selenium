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

public class SeleniumWebDriverUploadFilePageObject {

	WebElement element;
	private static String uploadFile ="uploadfile";
	private static String browserPage="C:\\Users\\User\\git\\repository\\Selenium\\maven-demo\\src\\main\\resources\\com\\selenium\\webpages\\SeleniumWebdriverUploadFile.html";
	private static int waitDuration = 10;

public String pageURL() {
		return browserPage;
	}
	
public WebElement findElement(WebDriver webdriver) {
	try {
		
		element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.presenceOfElementLocated(By.id(uploadFile)));			
		
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

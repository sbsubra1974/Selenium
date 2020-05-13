package com.selenium.po;

/* 13-May-2020: INCOMPLETE: Stopped Selenium study here. maven-demo project folder pushed to GitHub and Jenkins wporkspace
 * 
 * */

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

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
	private String browserPage= "/com/selenium/webpages/SeleniumWebdriverUploadFile.html"; //file path relative to project workspace in Jenkins
	private static int waitDuration = 10;

public String pageURL() throws URISyntaxException {
	
	URL resource = SeleniumWebDriverUploadFilePageObject.class.getResource(browserPage);
	System.out.println("path: "+Paths.get(resource.toURI()).toFile().getPath());
	browserPage=new String(Paths.get(resource.toURI()).toFile().getPath());
	
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

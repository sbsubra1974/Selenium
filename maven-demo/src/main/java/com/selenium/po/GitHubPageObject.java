package com.selenium.po;
//POM

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GitHubPageObject {

	private static String browserPage = "https://github.com/login";
	private static String loginFieldbyId = "login_field";
	private static String pwdFieldbyId = "password";
	private static WebElement element;
	private static int waitDuration = 5;
	
	public String pageURL(WebDriver webdriver) {
		webdriver.manage().window().maximize();
		return browserPage;
	}

	public WebElement logInNameField(WebDriver webdriver){
		
		try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.visibilityOfElementLocated(By.id(loginFieldbyId)));			
			
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

	public WebElement logInPwdField(WebDriver webdriver){
		
		try {
			
			element = new WebDriverWait(webdriver,waitDuration).until(ExpectedConditions.visibilityOfElementLocated(By.id(pwdFieldbyId)));			
			
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

package com.selenium.po;
//POM created using PageFactory: Selenium's built-in Page Object Model

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class GitHubPageObjectFactory {

	private static String browserPage = "https://github.com/login";
	private int wait = 5;
	@FindBy(id="login_field") //@FindBy annotation is used when we need to find elements using Selenium inbuilt PageFactory method
	public WebElement loginFieldbyId;	
	@FindBy(id="password")
	public WebElement pwdFieldbyId;
	
	public String pageURL(WebDriver webdriver) {
		webdriver.manage().window().maximize();
		return browserPage;
	}
	
	public GitHubPageObjectFactory initialiseElements(WebDriver webdriver ) {
	
		PageFactory.initElements(webdriver, GitHubPageObjectFactory.this ); //PageFactory.initElements will create all webelements of the page
		//PageFactory.initElements(new AjaxElementLocatorFactory(webdriver, wait), GitHubPageObjectFactory.this);
		return GitHubPageObjectFactory.this;
	}
}

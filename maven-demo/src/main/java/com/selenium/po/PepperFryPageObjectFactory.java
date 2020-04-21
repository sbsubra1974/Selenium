package com.selenium.po;

//POM with Selenium's pagefactory pattern (i.e with @FindBy, PageFactory.initElements)

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PepperFryPageObjectFactory {

private static String browserPage = "https://www.pepperfry.com/";
@FindBy(xpath="//*[@id=\"homeContainer\"]/div[9]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[2]/div/ul/li[1]/a")
public WebElement linkText;

@FindBy(xpath="//*[@id=\"homeContainer\"]/div[10]/div[2]/div[1]/div/a/img")
public WebElement monumentsIcon;

@FindBy(id="webklipper-publisher-widget-container-notification-frame")
public WebElement happycodeFrame;

@FindBy(xpath="//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]/span")
public WebElement happycodeAlertIcon; 

@FindBy(id="signup-form")
public WebDriver cashbackForm;

@FindBy(xpath="//*[@id=\"regPopUp\"]/a")
public WebElement cashbackCloseIcon;

public String pageURL(WebDriver webdriver) {
	webdriver.manage().window().maximize();
	return browserPage;
}

public PepperFryPageObjectFactory initialiseElements(WebDriver webdriver ) {
	
	PageFactory.initElements(webdriver, PepperFryPageObjectFactory.this ); 
	return PepperFryPageObjectFactory.this;
}

}

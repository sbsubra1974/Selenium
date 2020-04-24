package com.selenium.inc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TypeTextInSearchBox {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","F:\\Users\\User\\eclipse-workspace\\maven-demo\\drivers\\chromedriver.exe");
	WebDriver webdriver = new ChromeDriver();
	try {
		webdriver.get("https://www.google.com/");
		webdriver.findElement(By.name("q")).sendKeys("Hello to Selenium",Keys.ENTER);
		WebElement firstResult = new WebDriverWait(webdriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input"))); 
		System.out.println("firstResult: "+firstResult.getAttribute("value"));
	}
	finally {
	webdriver.quit(); //this will quit webdriver instances running on the machine
	}

	}
	}

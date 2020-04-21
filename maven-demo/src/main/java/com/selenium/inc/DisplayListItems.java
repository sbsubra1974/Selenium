package com.selenium.inc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisplayListItems {

	public static void main(String[] args) throws InterruptedException {	 
	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver webdriver = new ChromeDriver();
		
		try {
		webdriver.get("https://www.google.com/");
		webdriver.findElement(By.name("q")).sendKeys("selenium");
		WebElement unsortedList = new WebDriverWait(webdriver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#tsf > div:nth-child(2) > div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > ul")));
		Thread.sleep(10000);
		List<WebElement>listElements = unsortedList.findElements(By.tagName("span"));
				//
		System.out.println("List size: "+listElements.size());
		for (WebElement element : listElements) {
			System.out.println("element: "+element.getText());
		}
		}
		finally {
			webdriver.quit();
		}
	}

}

//05-Apr
//To do: TRY loading customized Chrome Profile and verify whether search history is getting stored for subsequent webdriver browsing sessions
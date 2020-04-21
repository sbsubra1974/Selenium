package com.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AnnaUnivPageObject {

	private static String browserPage = "https://www.annauniv.edu";
	private static String tagName = "a";
	private java.util.List<WebElement> elements;
	private WebElement element;
	private String centresButtonXPath = "/html/body/table/tbody/tr[1]/td[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td[6]/div/a";
			/* "/html/body/table/tbody/tr[1]/td[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td[13]/div/a";*/ 
	
	public String pageURL() {
		return browserPage;
	}
	
	public java.util.List<WebElement> findAllTagsOnPage(WebDriver webdriver) {
	
		elements = webdriver.findElements(By.tagName(tagName)); //webdriver.findElements will never throw NoSuchElementException
		return elements;

	}
	
	public WebElement getCentresButtonXPath(WebDriver webdriver) { 
 
		try {
				element = webdriver.findElement(By.xpath(centresButtonXPath));
		}catch(NoSuchElementException e) {
			
			System.out.println("Error: "+e.getMessage()+" "+e.getStackTrace().toString());
		}
		
		return element;
	}

}

// should a command like this be made part of POM class?
//element = webdriver.findElement(By.name("userName")); //will be webpage specific
// Tip: These pages are stored as objects, which will contain specific information about how the web page is composed and how actions are performed– very little of which should concern you as a tester.
// So, the answer is 'yes' because findElement(By.) details how actions are going to be performed on the page
// the pageURL() simply returns the composition of the webpage (i.e its URL). Hence, it is included in the PO file
// - https://www.selenium.dev/documentation/en/introduction/on_test_automation/
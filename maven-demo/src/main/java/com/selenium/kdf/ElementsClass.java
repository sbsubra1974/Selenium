package com.selenium.kdf;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsClass {
	WebElement webelement;
	List<WebElement>elements;
		
	public void openBrowserPage(WebDriver webdriver,Properties objectRepo, String Parameter) {
		webdriver.get(objectRepo.getProperty(Parameter));
		webdriver.manage().window().maximize();
	}
	
	
	public WebElement findElementOnPage	(WebDriver webdriver,Properties objectRepo,
			String action,String elementlocatorType, 
			String uielement, String propertyFilePath,
			ReadObject object){
	 
	//get the locator from property file
	String locator = objectRepo.getProperty(uielement);
	
	//search element with locator strategy as given in column 'ElementLocatorType' of keywordsheet for the given test case 
	//Including Switch-case for locator types in POM class will not work.In POM,there is no way to know the changed locator type at runtime before calling findElement(by.<>locator type>) [In keyword driven framework,you get to know the locator type atruntime from the keywordsheet]
	try {
		switch (elementlocatorType.toUpperCase()) {
		case "NAME":
			webelement = new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
			break;
		case "ID": 
     		 webelement = new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
     		 break;
		case "XPATH":
			webelement = new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			break;
		case "CLASS":
			webelement = new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			break;
		case "CSS":
			webelement = new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			break;		
		}
	}catch (Exception e) {
 		//element found in DOM but Webdriver can't act on it:Set JSFlag to call JavaScriptExecutor to perform action on the element
 		System.out.println("Exception e from findElementOnPage: "+e.getMessage());
		object.setJSFlag(propertyFilePath,"jsFlag","true");    			
 		return webelement; // this will still return webelement as NULL b'cse the element was not visible to webdriver even after WebDriverWait timeout		
	}	        
	return webelement;
    }
	
	public List<WebElement> findElementsOnPage	(WebDriver webdriver,Properties objectRepo,
			WebElement element,String elementlocatorType, 
			String uielement, String propertyFilePath,
			ReadObject object){
	 
	//get the locator from property file
	String locator = objectRepo.getProperty(uielement);
	
	try {
		switch (elementlocatorType.toUpperCase()) {
		case "NAME":
			elements = new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locator)));			
			break;
		case "ID": 
     		 elements = new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locator)));
     		 break;
		case "XPATH":
			elements = new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
			break;
		case "CLASS":
			elements = new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(locator)));
			break;
		case "CSS":
			elements = new WebDriverWait(webdriver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locator)));
			break;		
		}
	}catch (Exception e) {
 		//object.setJSFlag(propertyFilePath,"jsFlag","true"); javascriptexecutor on xple elements not required
		return elements; // this will still return webelement as NULL b'cse the element was not visible to webdriver even after WebDriverWait timeout		
	}	        
	return elements;
    }
	
	public List<WebElement> finduiListElements(WebDriver webdriver,Properties objectRepo,
			WebElement element,String elementlocatorType, 
			String uielement, String propertyFilePath,
			ReadObject object){
	 
	//get the locator from property file
	String locator = objectRepo.getProperty(uielement);
	try {
		switch (elementlocatorType.toUpperCase()) {
		case "NAME":
			elements = element.findElements(By.name(locator));						
			break;
		case "ID": 
			elements = element.findElements(By.id(locator));
     		 break;
		case "XPATH":
			elements = element.findElements(By.xpath(locator));
			break;
		case "CLASS":
			elements = element.findElements(By.className(locator));
			break;
		case "CSS":
			elements = element.findElements(By.cssSelector(locator));
			break;		
		}
	}catch (Exception e) {
 		//object.setJSFlag(propertyFilePath,"jsFlag","true"); javascriptexecutor on xple elements not required
 		return elements; // this will still return webelement as NULL b'cse the element was not visible to webdriver even after WebDriverWait timeout		
	}	        
	return elements;
    }	
	
	public WebElement findElementInList(List<WebElement>elements,String Parameter){
		int i=0;
		for (i=0;  i < elements.size(); i++) {
		    if (elements.get(i).getText().toLowerCase().trim().compareTo(Parameter.toLowerCase().trim())==0)
		    {
		    	webelement = elements.get(i); 
		    	break;
		    }
		}
		//System.out.println(elements.get(i).getText());
		return webelement;
	}
	
	public void closeBrowserPage(WebDriver webdriver) {
		webdriver.quit();
	}

	public void performActionOnElement(WebDriver webdriver,String propertyFilePath,WebElement element,
			String Keyword,String Parameter,Boolean jsexec,Properties objectRepo,String UIElement,
			String ElementLocatorType,ReadObject object){
	
		//if jsexec is true => element is NULL => element is present in DOM but no action could be performed on it since it was not found by webdriver(due to overlay etc)
		//if jsexec is false => element was found by webdriver.We can perform webdriver action on it(no JavaScriptExecutor required)
		switch (Keyword.toUpperCase()) {
		case "CLICK":
			if (jsexec) {
				callJavaScriptExecutor(webdriver,Keyword,element,Parameter,UIElement,ElementLocatorType,objectRepo,propertyFilePath,object);			
			}
			else
				element.click();
		break; 
		case "ENTERTEXT":
			if (jsexec) 
				callJavaScriptExecutor(webdriver,Keyword,element,Parameter,UIElement,ElementLocatorType,objectRepo,propertyFilePath,object);			
			else
				element.sendKeys(Parameter);
		break;
		case "SEARCHLIST":
			element.click();
		break;		
		default:
		break;
		
		}
	
	}
	
	private void callJavaScriptExecutor(WebDriver webdriver,String Keyword,
			WebElement element,String Parameter,
			String UIElement,String ElementLocatorType,
			Properties objectRepo, String propertyFilePath,ReadObject object) {
		JavascriptExecutor jse = (JavascriptExecutor)webdriver;
		switch (Keyword) {
		case "CLICK":
			executeClickWithJavaScript(webdriver,jse,element,UIElement,ElementLocatorType,objectRepo);
			break;
		case "ENTERTEXT":
			executeTypeWithJavaScript(webdriver,jse,element,UIElement,ElementLocatorType,Parameter,objectRepo);
			break;
			default:
			break;

		}
	}
	
	private void executeClickWithJavaScript(WebDriver webdriver,JavascriptExecutor jse,WebElement element,String UIElement,String ElementLocatorType,Properties objectRepo ) {
	
		jse = (JavascriptExecutor)webdriver;
		jse.executeScript("arguments[0].click();", getElement(webdriver,ElementLocatorType, objectRepo,UIElement));
		
	}
	
	private void executeTypeWithJavaScript(WebDriver webdriver,JavascriptExecutor jse,WebElement element,String UIElement,String ElementLocatorType,String Parameter,Properties objectRepo) {
		
		jse = (JavascriptExecutor)webdriver;
		jse.executeScript("\"arguments[0].value=\'"+Parameter+"\';\"", getElement(webdriver,ElementLocatorType, objectRepo,UIElement));
	}

	private WebElement getElement(WebDriver webdriver, String ElementLocatorType,Properties objectRepo,String UIElement ) {
		
		String locator = objectRepo.getProperty(UIElement);
		
		System.out.println("locator from getElement: "+locator);
		
		//note that we are not using any webdriverwait.until here (and webdriverwait.until may still fail since the element may not be visible for the webdriver to perform action on it). 
		//This is because JavaScriptExecutor needs an element to be present in DOM for it perform actions.(since the page is loaded successfully, the element will be present in DOM) 
		//It doesn't matter to JavaScriptExecutor that element is visibly available for webdriver actions or not. Presence in DOM is enough and so webdriver.findElement() will work fine w/o webdriver.waituntil(element is visible)
		switch (ElementLocatorType.toUpperCase()){
		case "ID":
			webelement = webdriver.findElement(By.id(locator));
			break;
		case "NAME":
			webelement = webdriver.findElement(By.name(locator));
			break;
		case "XPATH":
			webelement = webdriver.findElement(By.xpath(locator));
			break;
		case "CSS":
			webelement = webdriver.findElement(By.cssSelector(locator));
			break;
		case "CLASS":
			webelement = webdriver.findElement(By.className(locator));
			break;	
		}
		
		return webelement;
	}
}



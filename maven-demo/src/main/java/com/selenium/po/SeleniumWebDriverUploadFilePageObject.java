package com.selenium.po;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

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
	private static String browserPage= "http://cc366df2.ngrok.io/job/SeleniumTestsFromGitHub/ws/maven-demo/src/main/resources/com/selenium/webpages/SeleniumWebdriverUploadFile.html"; //file path relative to project workspace in Jenkins
			//System.getProperty("user.dir")+"/src/main/resources/com/selenium/webpages/SeleniumWebdriverUploadFile.html"; //hint: drivers/chromedriver.exe
	// Use File.separator for best cross platform or '/'. The '/' works in Java even on Windows		
	private static int waitDuration = 10;

public String pageURL() throws URISyntaxException {
	System.out.println("user.dir:User Working Directory "+System.getProperty("user.dir"));	
	System.out.println("user.home:User Home Directory "+System.getProperty("user.home"));
	System.out.println("line.separator:Sequence used by operating system to separate lines in text files "+System.getProperty("line.separator"));
	System.out.println("browserPage: "+browserPage);
	System.out.println("File path: "+new File(SeleniumWebDriverUploadFilePageObject.class.getResource("/maven-demo/src/main/resources/com/selenium/webpages/SeleniumWebdriverUploadFile.html").toURI().getPath()));
	//URL res = YourClass.getClassLoader().getResource("/maven-demo/src/main/resources/com/selenium/webpages/SeleniumWebdriverUploadFile.html");
	//System.out.println("res: "+res.toString());
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

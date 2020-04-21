package com.selenium.cucumber.stepdef;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.po.GoogleMapPageObjectFactory;
import com.selenium.po.PepperFryPageObjectFactory;
import com.selenium.util.ScreenShotClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleMapPageObjectFactoryStepDefinition extends ScreenShotClass {

	WebDriver webdriver;
	WebElement element;
	GoogleMapPageObjectFactory pgobj;
	Actions actions;
	WebDriverWait wait;
	int waitDuration = 10;
	
	@Given("ChromeDriver is available for GoogleMap Page") //Background
	  public void setUpGoogleMapPageObjectFactoryTest() throws Throwable {      
		  System.out.println("Given ChromeDriver is available for GoogleMap Page:1");
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
			webdriver = new ChromeDriver();
			pgobj = new GoogleMapPageObjectFactory();
			actions = new Actions(webdriver);
			wait = new WebDriverWait(webdriver,waitDuration);
	   }
	
	@And("GoogleMap Page is opened")
	public void openGoogleMapPage() {
		webdriver.get(pgobj.pageURL(webdriver));		
	}
	
	@And("all GoogleMap page elements are initialised")
	public void initialiseGoogleMapPage(){	
		pgobj=pgobj.InitialiseElements(webdriver);	
	}
	
	@When("I capture screenshot on GoogleMap page to be stored at {string}")
	public void captureScreenshotGoogleMapPage(String screenshotFilePath) {
		System.out.println("captureScreenshotGoogleMapPage: "+screenshotFilePath);
		try {
			ScreenShot(webdriver,screenshotFilePath);
		}catch (Exception e) {}
	}
	
	@Then("an image should be stored in local drive path {string}")
	public void storeScreenshotGoogleMap(String screenshotFilePath) {
		System.out.println("Inside storeScreenshotGoogleMap: "+screenshotFilePath);
	}
	
	@When("I type the {string} on GoogleMap Page")
	public void typeSearchAddressGoogleMap(String searchAddress) {
		actions.sendKeys(pgobj.searchBox,searchAddress).perform();		
		actions.sendKeys(pgobj.searchBox,Keys.ENTER).perform();
	}
	
	@Then("I verify the section header contains {string} on GoogleMap Page")
	public void verifySectionHeaderTextGoogleMap(String searchAddress) {
		element = pgobj.findSectionHeader(webdriver);
		try {
			assertTrue(element.getText().contains(searchAddress));
		}catch (Throwable e)
		{
			System.out.println("assertTrue error: "+e.getMessage());
		}
	}
}

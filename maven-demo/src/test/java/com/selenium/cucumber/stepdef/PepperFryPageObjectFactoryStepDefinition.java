package com.selenium.cucumber.stepdef;

import static org.junit.Assert.assertThrows;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.po.PepperFryPageObjectFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PepperFryPageObjectFactoryStepDefinition {

	WebDriver webdriver;
	PepperFryPageObjectFactory pgobj;
	Actions actions;
	WebDriverWait wait;
	int waitDuration = 10;
	
	@Given("ChromeDriver is available for PepperFry Page") //Background
	  public void setUp() throws Throwable {      
		  System.out.println("Given ChromeDriver is available for PepperFry Page:1");
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
			webdriver = new ChromeDriver();
			pgobj = new PepperFryPageObjectFactory();
			actions = new Actions(webdriver);
			wait = new WebDriverWait(webdriver,waitDuration);
	   }
	
	@And("PepperFry Page is opened")
	public void openPepperFryPage(){
		webdriver.get(pgobj.pageURL(webdriver));
	}
	
	@And("all PepperFry page elements are initialised")
	public void initialisePepperFryPage() {
		pgobj=pgobj.initialiseElements(webdriver);	
	}
	
	@Given("promotion popup is shown on PepperFry Page")
	public void promotionalPopUpPepperFryPage() {
		new WebDriverWait(webdriver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("webklipper-publisher-widget-container-notification-frame")));
	}
	
	@When("I click on happycodeAlertIcon on PepperFry Page")
	public void clickhappycodeAlertIconPepperFryPage() {
		actions.click(pgobj.happycodeAlertIcon).perform();
	}
	
	@Then("I validate the promotion popup on PepperFry Page is closed")
	public void validatePromotionPopupPepperFryPage() {
		assertThrows("error!",NoSuchElementException.class,() ->
		{
			ExpectedConditions.presenceOfElementLocated(By.id("webklipper-publisher-widget-container-notification-frame"));
		});
	}
	
	@Given("Signup form is displayed on PepperFry Page")
	public void signupPopUpPepperFryPage() {
		new WebDriverWait(webdriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("signup-form")));
	}
	
	@When("I click on cashbackCloseIcon on PepperFry Page")
	public void clickcashbackCloseIconPepperFryPage() {
		actions.click(pgobj.cashbackCloseIcon).perform();
	}
	
	@Then("I validate the Signup form on PepperFry Page is closed")
	public void validateSignupFormPepperFryPage() {
		assertThrows("error!",NoSuchElementException.class,() ->
		{
			ExpectedConditions.presenceOfElementLocated(By.id("signup-form"));
			
		});
	}
}

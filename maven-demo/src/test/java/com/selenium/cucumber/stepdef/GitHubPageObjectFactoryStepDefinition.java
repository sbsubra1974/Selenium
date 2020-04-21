package com.selenium.cucumber.stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.po.GitHubPageObjectFactory;
import static org.junit.Assert.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GitHubPageObjectFactoryStepDefinition {
  
	WebDriver webdriver;
	GitHubPageObjectFactory pgobj,pgelm;
	Actions actions;
	WebDriverWait wait;
	private int waitDuration = 5;	
  
  
  @Given("GitHub page is opened")	//open pageURL
  public void openPageInitialise() throws Throwable{
	  System.out.println("Given GitHub PUT is opened:2");
	  webdriver.get(pgobj.pageURL(webdriver));
  }
   
  @Given("Login field is present in GitHub Page")
  public void loginFieldsAreVisible() {
  System.out.println("Given Login field is present in GitHub Page:4");	  
  }
  
  @And("Password field is present in GitHub Page")
  public void pwdFieldsAreVisible() {
  System.out.println("And Password field is present in GitHub Page:5");  
  }
    
  @When("I enter the user id {string} in GitHub Page"/*step definition is represented as a cucumber expression*/) //@When("^I enter the user id \"([^\"]*)\"$") //@When ("^I enter the user id \"(.*)\"$" /*step definition is represented as a regular expression*/)
  public void enterLoginCredentials(String loginName) {
	  System.out.println("When I enter the user id <userID>:6");	
	  actions.sendKeys(pgobj.loginFieldbyId, loginName).perform();
  }
  
  @And("I enter the password {string} in GitHub Page"/*step definition is represented as a cucumber expression*/)  //@And("^I enter the password \"(.*)\"$" /*step definition is represented as a regular expression*/)
  public void enterPwdCredentials(String loginPwd) {
	  actions.sendKeys(pgobj.pwdFieldbyId, loginPwd).perform();  
  }
  
  @Then("I verify the entered {string} in Login field in GitHub Page"/*step definition is represented as a cucumber expression*/) //@Then("^I verify the entered \"(.*)\" in Login field$" /*step definition is represented as a regular expression*/)
  public void verifylogIn(String loginName){
	  System.out.println("Then I verify the entered <userID> in Login field in GitHub Page:8");	
	  wait.until(ExpectedConditions.textToBePresentInElementValue(pgobj.loginFieldbyId, loginName));
		assertEquals(pgobj.loginFieldbyId.getAttribute("value"),loginName+"Sai");
  }
  
  @And("I verify the entered {string} in Password field in GitHub Page") //@And("^I verify the entered \"(.*)\" in Password field  $")
  public void verifyPassword(String loginPwd){
	  System.out.println("And I verify the entered <pwd> in Password field in GitHub Page:9");
	  wait.until(ExpectedConditions.textToBePresentInElementValue(pgobj.pwdFieldbyId, loginPwd));
		assertEquals(pgobj.pwdFieldbyId.getAttribute("value"),loginPwd);
  }

  @Then("all GitHub page elements are initialised") //assert pgobj
  public void pageObjectInitialise() {
	  System.out.println("Then all GitHub page elements are initialised:3");
	  pgobj=pgobj.initialiseElements(webdriver);
	 assertNotNull(pgobj);
  }
  
  @Given("ChromeDriver is available for GitHub Page") //Background
  public void setUp() throws Throwable {      
	  System.out.println("Given ChromeDriver is available:1");
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		webdriver = new ChromeDriver();
		pgobj = new GitHubPageObjectFactory();
		actions = new Actions(webdriver);
		wait = new WebDriverWait(webdriver,waitDuration);
   }
}
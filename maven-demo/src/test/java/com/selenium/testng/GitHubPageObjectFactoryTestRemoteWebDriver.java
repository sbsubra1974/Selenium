package com.selenium.testng;

/* Incomplete: Issue raised on Stackoverflow on 04th May 2020
 * FAILED CONFIGURATION: @BeforeClass beforeClass org.openqa.selenium.WebDriverException: Unable to parse remote response: <!DOCTYPE html>
 * */

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.po.GitHubPageObjectFactory;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class GitHubPageObjectFactoryTestRemoteWebDriver {
  
  WebDriver webdriver;
  GitHubPageObjectFactory pgobj;
  Actions actions;
  WebDriverWait wait;
  static int waitDuration =10;
  private String loginName = "SaiBaba";
  private String loginPwd = "Saibaba2020";
  
  @Test
  public void testPageObjectFactory() {
	  	webdriver.get(pgobj.pageURL(webdriver));
		pgobj=pgobj.initialiseElements(webdriver);
		actions.sendKeys(pgobj.loginFieldbyId, loginName).perform();
		actions.sendKeys(pgobj.pwdFieldbyId, loginPwd).perform();
		wait.until(ExpectedConditions.textToBePresentInElementValue(pgobj.loginFieldbyId, loginName));
		wait.until(ExpectedConditions.textToBePresentInElementValue(pgobj.pwdFieldbyId, loginPwd));
		assertEquals(pgobj.loginFieldbyId.getAttribute("value"),loginName);
		assertEquals(pgobj.pwdFieldbyId.getAttribute("value"),loginPwd);
  
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException, InterruptedException {
   	//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
	 System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
	  //webdriver = new ChromeDriver();
	  //ChromeOptions chromeOptions = new ChromeOptions();
	  FirefoxOptions firefoxOptions = new FirefoxOptions(); 
	  //firefoxOptions.setCapability("browserName", "firefox");
	  //firefoxOptions.setCapability("platformName", "WIN10");
	  //firefoxOptions.setCapability("marionette", true);
	  //chromeOptions.addArguments("no-sandbox");
	  //chromeOptions.setCapability("browserName", "chrome");
	  //chromeOptions.setCapability("browserVersion", "81");
	  //chromeOptions.setCapability("platformName", "Windows 10");
	  webdriver = new RemoteWebDriver(new URL("http://192.168.1.9:5555"), firefoxOptions);
	   //pgobj = new GitHubPageObjectFactory();
		//actions = new Actions(webdriver);
		//wait = new WebDriverWait(webdriver,waitDuration);		
 
}




  @AfterClass
  public void afterClass() {
  webdriver.quit();
  }

}

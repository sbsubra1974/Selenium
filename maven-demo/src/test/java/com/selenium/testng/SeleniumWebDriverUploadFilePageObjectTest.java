package com.selenium.testng;

import org.testng.annotations.Test;

import com.selenium.po.SeleniumWebDriverUploadFilePageObject;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class SeleniumWebDriverUploadFilePageObjectTest {
  
	SeleniumWebDriverUploadFilePageObject pgobj;
	Actions actions;
	WebDriver webdriver;
	
  @Test(groups= {"gp1"})
  public void testSeleniumWebDriverUploadFilePageObject() {
  
	  webdriver.get(pgobj.pageURL());
	  
  }
  @BeforeClass(groups= {"gp1"})
  public void beforeClass() throws MalformedURLException {
  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
  //webdriver = new ChromeDriver();
  ChromeOptions chromeOptions = new ChromeOptions();
  webdriver = new RemoteWebDriver(new URL("http://192.168.1.5:4444"), chromeOptions);
  pgobj= new SeleniumWebDriverUploadFilePageObject();
  actions = new Actions(webdriver);  
  
  }

  @AfterClass(groups= {"gp1"})
  public void afterClass() {
 //webdriver.quit();
  }

}

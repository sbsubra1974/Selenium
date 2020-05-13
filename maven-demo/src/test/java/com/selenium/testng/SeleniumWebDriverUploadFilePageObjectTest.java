package com.selenium.testng;

/* 13-May-2020: INCOMPLETE: Stopped Selenium study here. maven-demo project folder pushed to GitHub and Jenkins wporkspace
 * 
 * */

import org.testng.annotations.Test;

import com.selenium.po.SeleniumWebDriverUploadFilePageObject;
import com.selenium.util.FTPFileTransfer;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
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
	FTPFileTransfer ftp;
	
  @Test(groups= {"gp1"})
  public void testSeleniumWebDriverUploadFilePageObject() throws URISyntaxException {
  
	  webdriver.get(pgobj.pageURL());
	  
  }
  @BeforeClass(groups= {"gp1"})
  public void beforeClass() throws MalformedURLException {
  
  //send the static HTML file to the remote server
  ftp = new FTPFileTransfer();
  ftp.ftpFileTransfer("192.168.1.5", 4444, "/maven-demo/src/main/resources/com/selenium/webpages/SeleniumWebdriverUploadFile.html","SeleniumWebdriverUploadFile.html");
	  
  //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
  //webdriver = new ChromeDriver();
  ChromeOptions chromeOptions = new ChromeOptions();
  webdriver = new RemoteWebDriver(new URL("http://192.168.1.5:4444/wd/hub"), chromeOptions);
  pgobj= new SeleniumWebDriverUploadFilePageObject();
  actions = new Actions(webdriver);  
  
  }

  @AfterClass(groups= {"gp1"})
  public void afterClass() {
 //webdriver.quit();
  }

}

package com.selenium.testng;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.po.GitHubPageObjectFactory;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class GitHubPageObjectFactoryTest {
  
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
  public void beforeClass() {
   	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		webdriver = new ChromeDriver();
		pgobj = new GitHubPageObjectFactory();
		actions = new Actions(webdriver);
		wait = new WebDriverWait(webdriver,waitDuration);		
 
}




  @AfterClass
  public void afterClass() {
  webdriver.quit();
  }

}

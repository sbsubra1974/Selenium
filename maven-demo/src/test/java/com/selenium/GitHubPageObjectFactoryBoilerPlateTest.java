package com.selenium;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.po.GitHubPageObjectFactory;
import com.selenium.util.BoilerPlateClass;

@RunWith(Parameterized.class)
public class GitHubPageObjectFactoryBoilerPlateTest extends BoilerPlateClass {

	GitHubPageObjectFactory pgobj;
	
	@Rule
	public TestName testname = new TestName();

	@Parameters //two parameters:three sets
	 public static Object[][] data() {
	        return new Object[][] { 
	        		{"SubraPGF","password1"}, 
	        		{"DhruvPGF","password2"}, 
	        		{"SaiPGF","password3"}
	        	};
	        } 
	
	@Parameter(0)
	public String loginName;
	
	@Parameter(1)
	public String loginPwd;	

	@Before
	public void setUp(){

		setupWebdriver();
		pgobj = new GitHubPageObjectFactory();			

	}

	@After
	public void tearDown() {
	}

	@Test
	public void testPageObjectFactory() {

		/*
		 * Given I navigate to the GitHub login page:-
			webdriver.get(pgobj.pageURL(webdriver));
			pgobj=pgobj.initialiseElements(webdriver);
			When I type the name in the login field:-
			actions.sendKeys(pgobj.loginFieldbyId, loginName).perform();
			wait.until(ExpectedConditions.textToBePresentInElementValue(pgobj.loginFieldbyId, loginName));
			Then the login text field should show the name
			assertEquals(pgobj.loginFieldbyId.getAttribute("value"),loginName); 
		 */
		
		webdriver.get(pgobj.pageURL(webdriver));
		pgobj=pgobj.initialiseElements(webdriver);
		actions.sendKeys(pgobj.loginFieldbyId, loginName).perform();
		actions.sendKeys(pgobj.pwdFieldbyId, loginPwd).perform();
		wait.until(ExpectedConditions.textToBePresentInElementValue(pgobj.loginFieldbyId, loginName));
		wait.until(ExpectedConditions.textToBePresentInElementValue(pgobj.pwdFieldbyId, loginPwd));
		assertEquals(pgobj.loginFieldbyId.getAttribute("value"),loginName);
		assertEquals(pgobj.pwdFieldbyId.getAttribute("value"),loginPwd);
	}

}

//23-Mar
//page scroll: https://www.guru99.com/scroll-up-down-selenium-webdriver.html
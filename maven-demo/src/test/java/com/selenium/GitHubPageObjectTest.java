package com.selenium;
//Data providers: multiple parameters
//Page factory

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.selenium.po.GitHubPageObject;

@RunWith(Parameterized.class)
public class GitHubPageObjectTest {
	
	WebDriver webdriver;
	GitHubPageObject pgobj;
	private WebElement element;
	Actions actions;	 

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		webdriver = new ChromeDriver();
		pgobj = new GitHubPageObject();
		actions = new Actions(webdriver);	
	}

	@After
	public void tearDown() throws Exception {
		//webdriver.quit();
	}

	@Rule
	public TestName testname = new TestName();
	
	@Parameters //two parameters:three sets
	 public static Object[][] data() {
	        return new Object[][] { 
	        		{"Subra","password1"}, 
	        		{"Dhruv","password2"}, 
	        		{"Sai","password3"}
	        	};
	        } 
	
	@Parameter(0)
	public String loginName;
	
	@Parameter(1)
	public String loginPwd;	
	
	@Test
	public void testLoginCredentials() {

		webdriver.get(pgobj.pageURL(webdriver));
		element = pgobj.logInNameField(webdriver);
		actions.sendKeys(element,loginName).perform();
		
		element = pgobj.logInPwdField(webdriver);
		actions.sendKeys(element, loginPwd).perform();
	}

}


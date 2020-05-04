package com.selenium.testng;

import org.testng.annotations.Test;

import com.selenium.po.SwitchTabsPageObjectFactory;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class SwitchTabsPageObjectTest {
  
	WebDriver webdriver;
	SwitchTabsPageObjectFactory pgobj;
	Actions actions;
	
  @Test(groups= {"gp1"})
  public void switchTabs() {
  /*
   * 1. Open a URL in a new tab
   * 2. Perform some assertions there
   * 3. Switch back to the previous tab
   * 4. Confirm switch back
   * 5. Exit test
   * */
	 
	 webdriver.get(pgobj.pageURL(webdriver));
	 pgobj=pgobj.initialiseElements(webdriver);
	 //perform this step only after webdriver.get()
	 //pgobj.openNewTab(webdriver);
	 
	 
	 
	 actions.moveToElement(pgobj.searchField).sendKeys("Sai Baba").perform();
	 assertEquals(pgobj.searchField.getAttribute("value"),"Sai Baba");
	  
  }
  @BeforeClass(groups= {"gp1"})
  public void beforeClass() {
  
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  webdriver = new ChromeDriver();
	  pgobj = new SwitchTabsPageObjectFactory();
	  actions = new Actions(webdriver);
  }

  @AfterClass(groups= {"gp1"})
  public void afterClass() {
  webdriver.quit();
  }

}

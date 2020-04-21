package com.selenium;
// 1.Data Provider:-
// @RunWith(Parameterized.class)
// @Parameters
// Test Name:-
// @Rule
// 2. ErrorCollector:-
// @Rule
// org.hamcrest.CoreMatchers.equalTo
// collector.checkThat
// 3. looping through unsorted list:Selenium doesn't allow to get only the text of child elements:-
// element.getText() will return text of h1 class(movie name) including its sublement- span (titleYear)

import static org.junit.Assert.*;
//
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.po.IMDBPageObject;

@RunWith(Parameterized.class)
public class IMDBPageObjectTest {

	WebDriver webdriver;
	IMDBPageObject pgobj;
	private WebElement element;
	private List<WebElement>elements;
	WebDriverWait wait;
	Actions actions;
	private static int waitDuration = 15;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		webdriver = new ChromeDriver();
		pgobj = new IMDBPageObject();
		actions = new Actions(webdriver);
		wait = new WebDriverWait(webdriver,waitDuration);
	}

	@After
	public void tearDown() throws Exception {
	//webdriver.quit();	
	}

	@Rule
	public TestName testname = new TestName(); //can we place this statement in @Before/setUp()?
	@Rule
	public ErrorCollector collector = new ErrorCollector(); //to continue the test case even after an assert fails(replace your asserts with calls to collector.checkThat(...))
	
	@Parameters //one parameter:three sets
	 public static Object[] data() {
	        return new Object[] { 
	        	"Shirdi ke Sai Baba", 
	        	"Cars", 
	        	"Parasite"
	        	};
	        } 
	
	@Parameter(0)
	public String movieName;
	
	@Test
	public void testOpenPage() {
		//display the test name in console
		//open the browser test page maximized
		//verify that the browser loads the correct test page
		System.out.println("Running "+testname.getMethodName());
		webdriver.get(pgobj.pageURL(webdriver));
		assertEquals("https://www.imdb.com/",webdriver.getCurrentUrl());
	}
	
	@Test
	public void testfindSearchField() {
		//display the test name in console
		//open the browser test page maximized
		//find the search field
		//enter text in the search field
		//verify that the text was entered correctly
		System.out.println("Running "+testname.getMethodName());		
		webdriver.get(pgobj.pageURL(webdriver));		
		element = pgobj.findSearchField(webdriver);
		//element.sendKeys("Sai Baba"); //results in org.openqa.selenium.WebDriverException: unknown error: call function result missing 'value'
										//not sure why. Use SendKeys method from Actions class instead
										//check whether this issue occurs only in IMDB website or only with Sendkeys method
		actions.sendKeys(element, "Sai Baba").perform();
		assertEquals("Sai Baba",element.getText());
	}
	
	@Test
	public void testwaitAndFindSearchField()  {
		//display the test name in console
		//open the browser test page maximized
		//find the search field-wait till it becomes available [pro-find wait]
		//enter text in the search field
		//wait(explicit) for the text to appear fully in the search field [pro-action wait]
		//verify that the text entered was correct
		System.out.println("Running "+testname.getMethodName());
		webdriver.get(pgobj.pageURL(webdriver));		
		element = pgobj.waitAndFindSearchField(webdriver);
		//element.sendKeys("Sai Baba"); //results in org.openqa.selenium.WebDriverException: unknown error: call function result missing 'value'
										//not sure why. Use SendKeys method from Actions class instead
										//check whether this issue occurs only in IMDB website or only with Sendkeys method
		actions.sendKeys(element, "Sai Baba").perform();
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, "Sai Baba")); //textToBePresentInElement(element, "Sai Baba")) will not work
		assertEquals("Sai Baba",element.getAttribute("value")); //element.getText() will not work
	}
	

	@Test
	public void testdataProviderFindSearchField() {
		//display the test name in console
		//open the browser test page maximized
		//find the search field-use single parameter data provider
		//enter moviename in the search field (user data provider's @Parameter annotated variable)
		//wait(explicit) for the moviename to appear fully in the search field
		//verify that the moviename entered was correct
		System.out.println("Running "+testname.getMethodName());
		webdriver.get(pgobj.pageURL(webdriver));		
		element = pgobj.waitAndFindSearchField(webdriver);
		actions.sendKeys(element, movieName).perform(); //movieName is the data provider annotated variable
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, movieName)); 
		assertEquals(movieName,element.getAttribute("value"));
	}	
	
	@Test
	public void testmovienameFromList_collectorCheckThat() {
		//display the test name in console
		//open the browser test page maximised
		//find the search field-wait till it becomes available  [pro-find wait]
		//enter movie name in the search field (not the full movie name)
		//wait for the list of movies with similar names to be shown  [pro-find wait]
		//loop through the list and verify whether the movie name is present (using collector.checkThat)
		System.out.println("Running "+testname.getMethodName());
		webdriver.get(pgobj.pageURL(webdriver));		
		element = pgobj.waitAndFindSearchField(webdriver); //find search field
		actions.sendKeys(element, "Sai Baba").perform();
		elements = pgobj.waitAndFindMovieList(webdriver); //find ul and all list nodes within ul
		
		for (WebElement element: elements) {
		      System.out.println(element.getText()); //Gets the visible (i.e. not hidden by CSS) text of this element[i.e ul], including sub-elements[i.e all list nodes present within ul].
		      //Q: In Selenium, is it possible to fetch text of only the main element or only of sub elements? If not why?
		      //A: NO. Because your XPath expressions and CSS selectors have to point to an actual element.
		      //possible workarounds: https://stackoverflow.com/questions/28945692/how-to-get-text-from-parent-element-and-exclude-text-from-children-c-selenium
		      collector.checkThat("Shirdi ke Sai Baba",equalTo(element.getText()));
		      System.out.println("inside for loop");
		}
	}
	
	@Test
	public void testmovienameFromList() {
		//display the test name in console
		//open the browser test page maximised
		//find the search field-wait till it becomes available  [pro-find wait]
		//enter movie name in the search field (not the full movie name)
		//wait for the list of movies with similar names to be shown  [pro-find wait]
		//loop through the list and verify whether the movie name is present
		System.out.println("Running "+testname.getMethodName());
		webdriver.get(pgobj.pageURL(webdriver));		
		element = pgobj.waitAndFindSearchField(webdriver); //find search field
		actions.sendKeys(element, "Sai Baba").perform();
		elements = pgobj.waitAndFindMovieList(webdriver); //find ul and all list nodes within ul
		
		for (WebElement element: elements) {
			if(element.getText().startsWith("Shirdi Ke Sai Baba"))
			{
				assertTrue(element.getText().startsWith("Shirdi Ke Sai Baba"));
				System.out.println(element.getText());
				break;
			}
		}
	}
	
	@Test
	public void testclickMovieName() {
		//open the browser test page maximised
		//find the search field-wait till it becomes available  [pro-find wait]
		//enter movie name in the search field
		//click on the Movie's name
		//wait for the movie name text to be shown in the movie's page  [pro-find wait]
		//verify if the page loaded corresponds to the movie name which was clicked
		System.out.println("Running "+testname.getMethodName());
		webdriver.get(pgobj.pageURL(webdriver));
		element = pgobj.waitAndFindSearchField(webdriver); //find search field
		actions.sendKeys(element, "Shirdi Ke Sai Baba").perform();
		elements = pgobj.waitAndFindMovieList(webdriver); //find ul and all list nodes within ul
		
		for (WebElement element: elements) {
			if(element.getText().startsWith("Shirdi Ke Sai Baba"))
			{
				System.out.println(element.getText());
				actions.click(element).perform();
				element = pgobj.waitAndFindMoviePage(webdriver, "//*[@id=\"title-overview-widget\"]/div[1]/div[2]/div/div[2]/div[2]/h1"); //h1 class (title)
				assertEquals("Shirdi Ke Sai Baba",element.getText()); //element.getText() will return text of h1 class(movie name) including its sublement- span (titleYear)
				break;
			}
		}
		
	}

}


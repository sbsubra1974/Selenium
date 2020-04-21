package com.selenium.junit.testrunner;



import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


import com.selenium.GitHubPageObjectFactoryTest;
import com.selenium.YahooGoogleSwitchTabPageObjectTest;


@RunWith(Suite.class)
@SuiteClasses({
				YahooGoogleSwitchTabPageObjectTest.class,
				GitHubPageObjectFactoryTest.class
				})
public class TestRunnerClass {
	
	
}

//26 Mar
//keyword driven in POM:-
//Abstract testing steps, page elements and locators to excel sheet
//check:-
//do we need properties file
//in keyword driven testing, are we able to keep Page object seperate from test class?
//difference  between keyword driven in selenium w/ and w/o POM and Page Factory 
 
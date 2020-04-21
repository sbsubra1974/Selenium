package com.selenium.cucumber.junit.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) //This will execute all scenarios in same package as the runner, by default glue code is also assumed to be in the same package.
@CucumberOptions(tags={"@test1","@test2"},
features= {"src/main/resources/com/selenium/cucumber/features/GoogleMapPageObjectFactory.feature"},
glue= {"com.selenium.cucumber.stepdef"}
) 
public class GoogleMapPageObjectFactoryTestRunner {

}

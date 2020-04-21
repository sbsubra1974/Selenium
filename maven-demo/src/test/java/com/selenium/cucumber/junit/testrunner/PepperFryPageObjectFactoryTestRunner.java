package com.selenium.cucumber.junit.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(tags= {"@feature","@test1"},
features= {"src/main/resources/com/selenium/cucumber/features2/PepperFryPageObjectFactory.feature"},
glue= {"com.selenium.cucumber.stepdef"}
) 
public class PepperFryPageObjectFactoryTestRunner {

}

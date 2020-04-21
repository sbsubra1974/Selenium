package com.selenium.cucumber.junit.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(tags= {"@feature","@test3"},
features= {"src/main/resources/com/selenium/cucumber/features/GitHubPageObjectFactory_second.feature"},
glue= {"com.selenium.cucumber.stepdef","com.selenium.cucumber.stepdef2"}
) 
public class GitHubPageObjectFactoryTestRunner { }

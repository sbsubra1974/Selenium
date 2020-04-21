package com.selenium.cucumber.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SampleStepDefinition {
  @Given("^sample feature file is ready$")
  public void givenStatement() throws Throwable {      
             System.out.println("Given statement executed successfully");
   }

  @When("^I run the feature file$")
  public void whenStatement(){
         System.out.println("When statement execueted successfully");
  }

  @Then("^run should be successful$")
  public void thenStatment(){
         System.out.println("Then statement executed successfully");
  }  

}

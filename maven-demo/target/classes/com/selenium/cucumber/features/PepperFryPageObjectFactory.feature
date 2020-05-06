#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@feature
Feature: PepperFryPageObjectFactory
    
  Background: setUp PepperFryPageObjectFactory
  Given ChromeDriver is available for PepperFry Page
  And PepperFry Page is opened
  And all PepperFry page elements are initialised 

  @test1
  Scenario: closePromotionPopUpAlertTest
    Given promotion popup is shown on PepperFry Page
    When I click on happycodeAlertIcon on PepperFry Page
    Then I validate the promotion popup on PepperFry Page is closed
    
  @test2
  Scenario: closeSignUpFormTest 
    Given Signup form is displayed on PepperFry Page
    When I click on cashbackCloseIcon on PepperFry Page
    Then I validate the Signup form on PepperFry Page is closed

    
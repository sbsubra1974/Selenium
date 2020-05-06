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
Feature: GitHubPageObjectTest

Background: setUp
	Given ChromeDriver is available
     
@test1
Scenario: Initialise Page Object
    When Password field is present in PUT
    	Then Password field is present in PUT
        
@test2
Scenario Outline: Validate login credentials
   	Given Log in field is present in PUT
  	And Password field is present in PUT
  	When  I enter the user id "<userID>"
  	And I enter the password "<pwd>"
  	Then I verify the entered "<userID>" in Login field
  	And I verify the entered "<pwd>" in Password field 
  
Examples: 
      | userID  | pwd |
      | SaiBaba |     password1|
      | Shridi |     password2|

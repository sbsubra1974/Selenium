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

Background: setUp GitHub Page Object
	Given ChromeDriver is available for GitHub Page
	And GitHub page is opened
	And all GitHub page elements are initialised
     
@test1
Scenario: Initialise GitHub Page Object
   Given  all GitHub page elements are initialised
   Then 	all GitHub page elements are initialised
@test3
Scenario: Initialise GitHub Page Object
    When   Password field is present in GitHub Page
    Then Password field is present in GitHub Page 
        
@test2
Scenario Outline: Validate GitHub login credentials
   	Given Login field is present in GitHub Page
  	And Password field is present in GitHub Page
  	When  I enter the userid "<userID>" in GitHub Page
  	And I enter the password "<pwd>" in GitHub Page
  	Then I verify the entered "<userID>" in Login field in GitHub Page
  	And I verify the entered "<pwd>" in Password field in GitHub Page
  
Examples: 
      | userID  | pwd |
      | SaiBaba |     password1|
      | Shridi |     password2|

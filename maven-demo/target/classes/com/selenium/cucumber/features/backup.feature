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
@GoogleMapPageObjectFactory
Feature: GoogleMapPageObjectFactory
  
 Background: setUpGoogleMapPageObjectFactoryTest
 	Given ChromeDriver is available for GoogleMap Page
  And GoogleMap Page is opened
  And all GoogleMap page elements are initialised 

  @test11
  Scenario Outline: captureScreenShotatStartGoogleMap
    When I capture screenshot on GoogleMap page to be stored at "<screenshotFilePathStart>"
 		Then an image should be stored in local drive path "<screenshotFilePathStart>"
 		
 	@test21
 	Scenario Outline: typeAndVerifyAddressGoogleMap
 	When I type the "<searchAddress>" on GoogleMap Page
 	Then I verify the section header contains "<searchAddress>" on GoogleMap Page
 	
 	@test31
 	Scenario Outline: phnuminlinePopUpGoogleMap
 	When I type the "phoneNumber" on GoogleMap Page
 	Then I verify the inline popup window contains "phoneNumber" on GoogleMap Page	

  @test41
  Scenario Outline: captureScreenShotatEndGoogleMap
  When I capture screenshot on GoogleMap page to be stored at "<screenshotFilePathEnd>"
 	Then an image should be stored in local drive path "<screenshotFilePathEnd>"
 	
 	Examples:
 	| screenshotFilePathStart |
 	|F:\\Users\\User\\eclipse-workspace\\maven-demo\\screenshots\\GoogleMapPageObjectFactoryTest-start.jpg|
 	
 	Examples:
 		| screenshotFilePathEnd |
 		|F:\\Users\\User\\eclipse-workspace\\maven-demo\\screenshots\\GoogleMapPageObjectFactoryTest-end.jpg|
 		
 	Examples:
 	 	| searchAddress  |
    | Harvard Business School, Boston, MA 02163, United States |    
          
 	
 	
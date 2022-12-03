#Background: Authorization is set to 'Basic Auth' with valid username and password
Feature: Validate and Test GET request for All Users API
  I want to use this template for my feature file

Scenario: User is able to get list of all users
	Given User is on GET request with Users endpoint
  When User sends GET request for all users
  Then User should be displayed success status code 200 with list of all users.
  
  Scenario: User is able to get list of all userskillmap
	Given User is on GET request with userskillmap endpoint
  When User sends GET request for all users
  Then User should be displayed success status code 200 with list of all users.
  
   
   Scenario: User is able to get list of all userskillmapgetapi
  Given User is on GET request with userskillmapgetapi endpoint
  When User sends GET request for all users
  Then User should be displayed success status code 200 with list of all users.
  
  
   Scenario: User is able to get list of all skillapi
  Given User is on GET request with skillapi endpoint
  When User sends GET request for all users
  Then User should be displayed success status code 200 with list of all users.
  
  
Scenario: User is unable to get list of all users when credentail is wrong
    Given User is on GET request with Users endpoint with invalid Credential
    When User sends GET request for all users with invalid credential
    Then User should be displayed unsuccess status code 401 .
  
  
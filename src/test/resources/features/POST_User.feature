
@tag
Feature: Post the new user detail 

  @tag1
  Scenario: Post the new user detail with valid credentials and endpoint
    Given authentication is sent for POST request with valid username and valid password
    When User send post request with valid user inputs
    Then User should be displayed success status code 201 with message Successfully Created. with automatically generated userid
     
  Scenario: Post the new user detail with valid credentials and endpoint
    Given authentication is sent for POST request with valid username and valid password
    When User send post request with invalid user inputs
    Then User should be displayed success status code 400 for bad request.
    
     Scenario: Post the new user detail with valid credentials and endpoint
    Given authentication is sent for POST request with endpoint userSkillMap 
    When User send post request with valid userSkillMap  inputs
    Then User should be displayed success status code 201 with message Successfully Created. with automatically generated userid
    
   Scenario: Post the new user detail with valid credentials and endpoint
    Given authentication is sent for POST request with endpoint Skills
    When User send post request with valid Skills   inputs
    Then User should be displayed success status code 201 with message Successfully Created. with automatically generated userid
    
   

 


Feature: Update the user
  

  @tag1
  Scenario: Verify that existing user record is updated
    Given  User is on put user request with endpoint
    When User sends put request with all valid parameter values in request body
    Then Status code 201 record updated should be displayed
    
    Scenario: Verify that existing user record is updated
    Given  User is on put userskillmap request with endpoint
    When User sends put request with all valid userskillmap values in request body
    Then Status code 201 record updated should be displayed
    
    Scenario: Verify that existing user record is updated
    Given  User is on put skill request with endpoint
    When User sends put request with all valid skill values in request body
    Then Status code 201 record updated should be displayed
    
    
     Scenario: Verify that nonexisting user record is updated
    Given  User is on put user request with endpoint
    When User sends put request with non existing user with all valid parameter in request body
    Then Status code 404 record with Not found message

    Scenario: Verify that existing user record is updated with invalid input
    Given  User is on put user request with endpoint
    When User sends put request with existing user with all valid parameter with invalid input in request body
    Then Status code 400 record with Bad request message

    
  
  
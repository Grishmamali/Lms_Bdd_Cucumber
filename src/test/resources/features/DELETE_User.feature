Feature: Delete the user
  
  Scenario: Verify that user record gets deleted
    Given User is on delete request call endpoint with valid credential 
    When User send delete request with valid userId
    Then Status code 200 successfully deleted should be displayed with record has been deleted message
    
     Scenario: Verify that user record gets deleted
    Given User is on delete request call userskillmap endpoint with valid credential 
    When User send delete request with valid userskillmap
    Then Status code 200 successfully deleted should be displayed with record has been deleted message
    
     Scenario: Verify that user record gets deleted
    Given User is on delete request call skill endpoint with valid credential 
    When User send delete request with valid skill
    Then Status code 200 successfully deleted should be displayed with record has been deleted message
    
    
    Scenario: Verify that user record gets deleted
    Given User is on delete request call endpoint with valid credential with invalid userid
    When User send delete request with Invalid userId
    Then Status code 404 with not found message
    
    
  
 
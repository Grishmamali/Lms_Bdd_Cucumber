Feature: validat Get request foe single user Id 

Scenario: Verify if we get single user record by valid user Id 
    Given User is on GET request with Users endpoint by id
    When User sends GET request for single Id users
    Then User should be displayed success status 200 with single users.
    
    Scenario: Verify if we get single user record by valid userskillmap id  
    Given User is on GET request with userskillmap endpoint by id
    When User sends GET request for userskillmap Id 
    Then User should be displayed success status 200 with single users.
    
    Scenario: Verify if we get single skillapi with valid skillapiid  
    Given User is on GET request with skillapiid endpoint by id
    When User sends GET request for skillapiid Id 
    Then User should be displayed success status 200 with single users.
    
     Scenario: Verify if we get record by valid userskillmapgetuserid id  
    Given User is on GET request with userskillmapgetuserid endpoint valid id
    When User sends GET request for userskillmapgetuserid 
    Then User should be displayed success status 200 with single users.
    
     Scenario: Verify if we get record by valid userskillmapgetskillid id  
    Given User is on GET request with userskillmapgetskillid endpoint valid id
    When User sends GET request for userskillmapgetskillid  
    Then User should be displayed success status 200 with single users.
    
    Scenario: Verify if we get single user record by Invalid user Id 
    Given User is on GET request with Users endpoint by InvalidId
    When User sends GET request for single User with endpoint 
    Then User should be displayed unsuccess status 404 with not found message
    
      Scenario: Verify if we get single userskillmap record by Invald userskillmapid
    Given User is on GET request with Userskillmap endpoint by Invalid userskillmapid
    When  User sends GET request for userskillmap Id 
    Then User should be displayed unsuccess status 404 with not found message
    
     Scenario: Verify if we get single userskillmapget record by Invalid userskillmapgetid
    Given User is on GET request with userskillmapgetid endpoint by Invalid userskillmapgetid
    When  User sends GET request for userskillmapgetid Id 
    Then User should be displayed unsuccess status 404 with not found message
    
     Scenario: Verify if we get single skillapiid record by Invalid skillapiid
    Given User is on GET request with skillapiid endpoint by Invalid skillapiid
    When  User sends GET request for skillapiid 
    Then User should be displayed unsuccess status 404 with not found message
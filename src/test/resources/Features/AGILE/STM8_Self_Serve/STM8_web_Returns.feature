@returns @sprint_64
Feature: To test the returns functionality
  
  Background:
  	Given web site is launched successfully and user "does" accept the cookies
  	And customer accesses the website as "orders_login" user
    When User navigates to order history and tracking page
  
  @returnCTA
  Scenario Outline: To verify that Return CTA is available
    When Selects a order with "<orderConfirmationNumber>" in order history and tracking page
    Then Verify that order details page is displayed
    Then Verify that Return CTA is available for returnable product
    @uat @nwk
		Examples:
    | orderConfirmationNumber |
    | 750723 |
    
    @ft @eu
		Examples:
    | orderConfirmationNumber |
    | 59758329 |
    
  @digital
  Scenario Outline: To verify that Non-returnable message for digital product is available
    When Selects a order with "<orderConfirmationNumber>" in order history and tracking page
    Then Verify that order details page is displayed
    And Verify that "<nonReturnableMessage>" is available for returnable product
    @ft @nwk
		Examples:
    | orderConfirmationNumber | nonReturnableMessage |
    | 744657 | Digital products are non-returnable |
    
  @ncnr
  Scenario Outline: To verify that Non-returnable message for NCNR product is available
    When Selects a order with "<orderConfirmationNumber>" in order history and tracking page
    Then Verify that order details page is displayed
    And Verify that "<nonReturnableMessage>" is available for returnable product
    @ft @nwk
		Examples:
    | orderConfirmationNumber | nonReturnableMessage |
    | 744657 | Non-Cancelable / Non Returnable |   
    
  @hazardous
  Scenario Outline: To verify that Non-returnable message for Hazardous product is available
    When Selects a order with "<orderConfirmationNumber>" in order history and tracking page
    Then Verify that order details page is displayed
    And Verify that "<nonReturnableMessage>" is available for returnable product
    @ft @nwk
		Examples:
    | orderConfirmationNumber | nonReturnableMessage |
    | 744657 | Hazardous products are non-returnable |
            
    @ft @eu
		Examples:
    | orderConfirmationNumber | nonReturnableMessage |
    | 59758329 | Hazardous products are non-returnable |
    
  @returnperiodended
  Scenario Outline: To verify that return period ended message is available when return period expired
    When Selects a order with "<orderConfirmationNumber>" in order history and tracking page
    Then Verify that order details page is displayed
    And Verify that "<returnPeriodExpired>" is available when return period expired
    @ft @nwk
		Examples: 
    | orderConfirmationNumber | returnPeriodExpired |
    | 744657 | Return period ended |
    
    @ft @eu
		Examples: 
    | orderConfirmationNumber | returnPeriodExpired |
    | 59758022 | Return period ended |
@viewinvoice @sprint_65
Feature: To test the view invoice functionality
  
  Background:
  	Given web site is launched successfully and user "does" accept the cookies
  
  @verifyinvoices1
  Scenario Outline: To verify View invoice feature for logged users
  	Given customer accesses the website as "orders_login" user
    When User navigates to order history and tracking page
    And Selects a order with "<orderConfirmationNumber>" in order history and tracking page
    Then Verify that order details page is displayed
    And Verify element "MyOrderDetails.viewInvoice_button" is present on page
    When clicks on "MyOrderDetails.viewInvoice_button"
    Then Verify element "eInvoicing.ordernumber_text" is present on page
    And Verify that invoices related to the "<orderConfirmationNumber>" displayed
    @uat @nwk
		Examples:
    | orderConfirmationNumber |
    | 750723 |
    
  @searchinvoiceparameters
  Scenario Outline: To verify search parameters in eInvoicing page are enabled for logged users
  	Given customer accesses the website as "orders_login" user
    When User navigates to order history and tracking page
    And Selects a order with "<orderConfirmationNumber>" in order history and tracking page
    Then Verify that order details page is displayed
    When clicks on "MyOrderDetails.viewInvoice_button"
    Then Verify element "eInvoicing.ordernumber_text" is present on page
    And Verify that search parameters in eInvoicing page are enabled
    When clicks on "eInvoicing.resetallfields_button"
    Then Verify that order number field is blanked out and all the invoices are displayed
    @uat @nwk
		Examples:
    | orderConfirmationNumber |
    | 750723 |
    
  @verifyinvoices
  Scenario Outline: To verify View invoice feature for guest users using order tracking
    Given click on "Header.trackOrders_link"
    When User enters "<orderConfirmationNumber>","<emailaddress>" and "<postcode>"
    And click on "MyOrderDetails.findOrder_button"
    Then Verify that order details page is displayed
    And Verify element "MyOrderDetails.viewInvoice_button" is present on page
    When clicks on "MyOrderDetails.viewInvoice_button"
    Then Verify element "eInvoicing.ordernumber_text" is present on page
    And Verify that invoices related to the "<orderConfirmationNumber>" displayed
    @uat @nwk
		Examples:
    | orderConfirmationNumber | emailaddress | postcode |
    | 750723 | mlehet@newark.com | 606404457 |
    
  @searchinvoiceparameters1
  Scenario Outline: To verify search parameters in eInvoicing page are disabled for guest users
  	Given click on "Header.trackOrders_link"
    When User enters "<orderConfirmationNumber>","<emailaddress>" and "<postcode>"
    And click on "MyOrderDetails.findOrder_button"
    Then Verify that order details page is displayed
    When clicks on "MyOrderDetails.viewInvoice_button"
    Then Verify element "eInvoicing.ordernumber_text" is present on page
    And Verify that order confirmation number in eInvoicing page is disabled
    When clicks on "eInvoicing.resetallfields_button"
    Then Verify that order number field is not blanked out
    @uat @nwk
		Examples:
    | orderConfirmationNumber | emailaddress | postcode |
    | 750723 | mlehet@newark.com | 606404457 |
    
  @verifyinvoices
  Scenario Outline: To verify View invoice link on order history and tracking page
  	Given customer accesses the website as "orders_login" user
    When User navigates to order history and tracking page
    And Clicks on view invoice link for order with "<orderConfirmationNumber>"
    Then Verify element "eInvoicing.ordernumber_text" is present on page
    And Verify that invoices related to the "<orderConfirmationNumber>" displayed
    @uat @nwk
		Examples:
    | orderConfirmationNumber |
    | 750723 |
    
  @searchinvoiceparameters1
  Scenario Outline: To verify search is working in eInvoicing page
  	Given customer accesses the website as "orders_login" user
    When User navigates to eInvoicing page
    And enters value "<orderConfirmationNumber>" in textbox "eInvoicing.ordernumber_text"
    And clicks on "eInvoicing.search_button"
    Then Verify that invoices related to the "<orderConfirmationNumber>" displayed
    @uat @nwk
		Examples:
    | orderConfirmationNumber |
    | 750723 |
Feature: Smoke tests - CPC only, Web

  #it is imperitive that Web_Smoke CPC tests are run prior to these jobs

  @orderHistory @checkoutNewTradeAccount @cpconly @cpc
  Scenario: Verify the order history for recent orders on CPC site
    Given web site is launched successfully and user "does" accept the cookies
    When last registered "regular" user login to website successfully
    And I assume environment stub is disabled in PP environment
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.orderHistory_link"
    And I wait for "5" seconds
    And I take screenshot to verify the Order History page is displayed with recent order table
    And I click on link of recent order placed PO Number "OrderHistory.poNo_link"
    And I wait for "8" seconds
    And I take screenshot to view My Order Details page
    Then I verify element "OrderTracking.MyOrderDetails_text" is present on page and display 'My Order Details' in report
    And I verify PO Number "OrderTracking.orderRefNum_text" of recently placed order is "NewTradeTestorder"

  @synchuser @cpc @cpconly
  Scenario: Verify Back office Account number is synched in Account Summary for CPC
    Given I assume environment stub is disabled in PP environment
    Given web site is launched successfully and user "does" accept the cookies
    When last registered "sync" user login to website successfully
    And Verify user is logged in on Home page successfully
    When I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Managing Your Account from the dropdown "Header.managingYourAccount_link"
    And I wait for "5" seconds
    And I click Account Summary Link "AccountSummary.accountSummary_link"
    And I wait for "5" seconds
    And I scroll till "AccountSummary.accountName_text"
    And I take screenshot to view the Account Summary page
    Then I verify element "AccountSummary.accountName_text" is present on page and display 'Back Office Account Name' in report

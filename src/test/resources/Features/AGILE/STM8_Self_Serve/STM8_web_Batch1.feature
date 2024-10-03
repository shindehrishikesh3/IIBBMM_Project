Feature: It includes test cases for various functionality developed in sprints

  @STM8363 @Sprint66
  Scenario Outline: To verify different packaging type in BOM view
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    When I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
  	And User scroll down the page by pixels "1000"
    And I delete if any BOM file present on page "BOMUploadPage.delete_icon"
    And I upload the file "<bomFileName>" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "10" seconds
    Then I verify element "BOMUploadPage.fullReel_icon" is present on page
    And I verify element "BOMUploadPage.cutTape_icon" is present on page
    And I verify element "BOMUploadPage.boxPackaging_icon" is present on page
    And I verify element "BOMUploadPage.cardPackaging_icon" is present on page
    And I verify element "BOMUploadPage.packPackaging_icon" is present on page
    And I verify element "BOMUploadPage.pairPackaging_icon" is present on page
    And I verify element "BOMUploadPage.footPackaging_icon" is present on page
    And I verify element "BOMUploadPage.kitPackaging_icon" is present on page
    And I verify element "BOMUploadPage.metrePackaging_icon" is present on page
    And I verify element "BOMUploadPage.cardPackaging_icon" is present on page
    @eu @apac
		Examples:
    | bomFileName |
    | BOM_File_PackagingType_EU_APAC.xlsx |

    @nwk
		Examples:
    | bomFileName |
    | BOM_File_PackagingType_US.xlsx |

  @STM8175 @Sprint67
  Scenario Outline: To verify the sorting of products in see alternatives modal on BOM
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "login" user
    When I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
  	And User scroll down the page by pixels "1000"
    And I delete if any BOM file present on page "BOMUploadPage.delete_icon"
    And I upload the file "<bomFileName>" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "10" seconds
    And clicks on "BOMUploadPage.seeAlternatives_button"
    Then I verify element "BOMUploadPage.seeAlternatives_modal" is present on page
    And Verify the sorting of products on See alternavtives modal
    @eu @apac
		Examples:
    | bomFileName |
    | BOM_File_PackagingType_EU_APAC.xlsx |

    @nwk
		Examples:
    | bomFileName |
    | BOM_File_PackagingType_US.xlsx |

   @STM8671 @Sprint72 @openorder
   Scenario: To verify the open order report CTA on order history & tracking page
    Given web site is launched successfully and user "does" accept the cookies
  	And customer accesses the website as "orders_login" user
    When User navigates to order history and tracking page
    Then I verify element "OrderHistory.openOrdersReport_button" is present on page
    When clicks on "OrderHistory.openOrdersReport_button"
    Then Verify that open order report downloaded succesfully
                                                                              
   @returnCTA @Sprint72 @STM8700
   Scenario Outline: To verify the Return functionality for iBuy user
  	Given web site is launched successfully and user "does" accept the cookies
  	And customer accesses the website as "orders_login" user
  	When I hover on element My Account dropdown "Header.myAccount_dropdown"
  	And clicks on "Header.accountSummary_link"
    And clicks on "MyAccount.orders/Reports_link"
    And Selects a order with "<orderConfirmationNumber>" in orders and reports page
    Then Verify that order details page is displayed
    And Verify that Return CTA is available for returnable product
    @ft @apac
		Examples:
    | orderConfirmationNumber |
    | 59758329 |

    @ft @newark
		Examples:
    | orderConfirmationNumber |
    | 746157 |
    
   @STM8796 @Sprint75 @openorder
   Scenario: To verify the open order report CTA on orders & reports page
    Given web site is launched successfully and user "does" accept the cookies
  	And customer accesses the website as "ibuy" user
    When User navigates to order history and tracking page
    Then I verify element "OrderHistory.openOrdersReport_button" is present on page
    When clicks on "OrderHistory.openOrdersReport_button"
    Then Verify that open order report downloaded succesfully

   @Sprint75 @STM8843
   Scenario Outline: To verify the account header is clickable for registered user
  	Given web site is launched successfully and user "does" accept the cookies
  	And customer accesses the website as "login" user
  	When I click My Account dropdown "Header.myAccount_dropdown"
    Then I verify element "AccountSummary.myAccountSummary_text" is present on page
    When I click My Account dropdown "Header.userFirstName_text"
    Then I verify element "AccountSummary.myAccountSummary_text" is present on page
    When I click My Account dropdown "Header.userIcon_image"
    Then I verify element "AccountSummary.myAccountSummary_text" is present on page
    
   @Sprint75 @STM8843
   Scenario Outline: To verify the account header is clickable for ibuy user
  	Given web site is launched successfully and user "does" accept the cookies
  	And customer accesses the website as "ibuy" user
  	When I click My Account dropdown "Header.myAccount_dropdown"
    Then I verify element "AccountSummary.myAccountSummary_text" is present on page
    When I click My Account dropdown "Header.userFirstName_text"
    Then I verify element "AccountSummary.myAccountSummary_text" is present on page
    When I click My Account dropdown "Header.userIcon_image"
    Then I verify element "AccountSummary.myAccountSummary_text" is present on page
    
   @Sprint76 @STM8960
   Scenario Outline: To verify threshold error message for order detail report in OH&T
  	Given web site is launched successfully and user "does" accept the cookies
  	And customer accesses the website as "<user>" user
  	When User navigates to order history and tracking page
    And clicks on "OrderHistory.exportOrdersAsXLS_button"
    And clicks on "OrderHistory.orderDetailsReport_link"
    Then I verify element "OrderHistory.errorGeneratingReport_label" is present on page
    When clicks on "OrderHistory.contactUsNow_button"
		Then I verify element "ContactUs.contactUs_label" is present on page
		Examples:
    | user |
    | login |
    | ibuy |
    
   @Sprint76 @STM8960
   Scenario Outline: To verify threshold error message for line details report in OH&T
  	Given web site is launched successfully and user "does" accept the cookies
  	And customer accesses the website as "<user>" user
  	When User navigates to order history and tracking page
    And clicks on "OrderHistory.exportOrdersAsXLS_button"
    And I scroll till "OrderHistory.lineDetailsReport_link"
    And clicks on "OrderHistory.lineDetailsReport_link"
    Then I verify element "OrderHistory.errorGeneratingReport_label" is present on page
    When clicks on "OrderHistory.contactUsNow_button"
		Then I verify element "ContactUs.contactUs_label" is present on page
		Examples:
    | user |
    | login |
    | ibuy |

   @Sprint76 @STM8797 @openorder
   Scenario: To verify the open order status in orders and reports page
  	Given web site is launched successfully and user "does" accept the cookies
  	And customer accesses the website as "ibuy" user
  	When User navigates to order history and tracking page
  	And User select by option "OP" from dropdown "OrderHistory.orderStatus_dropdown"
  	And clicks on "OrderHistory.orderSearch_button"
  	Then verify element "OrderHistory.completeStatus_label" is not visible in DOM
  	And verify element "OrderHistory.cancelledStatus_label" is not visible in DOM

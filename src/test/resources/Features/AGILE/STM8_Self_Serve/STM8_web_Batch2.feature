Feature: It includes test cases for various functionality developed in sprints

   @STM8945 @Sprint77 @openorder
   Scenario: To verify the open order report CTA on order history & tracking page
    Given web site is launched successfully and user "does" accept the cookies
  	And customer accesses the website as "orders_login" user
    When User navigates to order history and tracking page
    Then I verify element "OrderHistory.openOrdersReport_button" is present on page
    When clicks on "OrderHistory.openOrdersReport_button"
    Then I verify element "OrderHistory.errorGeneratingReport_label" is present on page
    When clicks on "OrderHistory.contactUsNow_button"
    And I switch to contact us window 
    And wait "3" seconds for contact us new window
		Then I verify element "ContactUs.contactUs_label" is present on page
		And closed contact us window and back to parent window
		
	 @STM8844 @Sprint78 @bomerror
   Scenario Outline: To verify BOM max line count error when line exceeds 1000 records
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "<userType>" user
  	When I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And I upload the file "BOM_1000_records.xlsx" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "2" seconds
    Then I verify element "BOMUploadPage.lineItemsExceeded_modal" is present on page
    And I take screenshot of the page
    And clicks on "BOMUploadPage.okLineItemsExceeded_button"
    
    Examples:
    |userType|
    |login|
    |ibuy|
    |guest|
    
   @STM81414 @sprint82
   Scenario Outline: To verify available for back order message on BOM multiple matches modal
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "<userType>" user
  	When I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And I upload the file "BOMRegressionTest.xlsx" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.downloadBom_link" is present on page
    And user clicks on view all results matching with "<partNumber>" part number
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.viewAllResults_modal" is present on page
    And I verify element "BOMUploadPage.backOrderViewAllResults_icon" is present on page
    
    @eu @apac
    Examples:
    |userType|partNumber|
    |login|C1210C335K5RAC|
    |ibuy|C1210C335K5RAC|
    |guest|C1210C335K5RAC|
    
    @nwk
    Examples:
    |userType|partNumber|
    |login|bav|
    |ibuy|bav|
    |guest|bav|
    
    
   @STM81302 @sprint83 @eu @apac @nwk
   Scenario Outline: To verify description in BOM manual match modal changed to Line note
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "<userType>" user
  	When I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And I upload the file "BOM_ManualMatch.xlsx" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.BomManualMatch_modal" is present on page
    And I verify BOM match modal contains "Line Note" in "BOMUploadPage.BomManualMatch_modal"
    And I verify the line note option "Line Note (Optional)" present in edit dropdown on BOM match modal
    
    Examples:
    |userType|
    |login|
    |ibuy|
    |guest|
    
   @STM81470 @sprint84 @eu @apac @nwk
   Scenario: To test that verify email banner not coming for newly registered users
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
  	When I hover on element My Account dropdown "Header.myAccount_dropdown"
  	And I click on Account Summary link under My Account dropdown "Header.accountSummary_link"
  	Then verify absence of element "AccountSummary.emailUpdate_banner"
  	
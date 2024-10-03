#Author: Hrishikesh Shinde
@RoHS  @mobValidationTests
Feature: Verify RoHS Certificate
 
  @RoHStag @eu @apac @nwk @live
   Scenario: This scenario is to verify RoHS Compliance
   Given web site is launched successfully and user "does" accept the cookies
   And customer accesses the website as "register" user
   When I click the "Header.searchIcon_button"
   Then I wait for "2" seconds
   And I verify element "BrowseForProducts.firstCategory_link" is present on page and display name of First Category in report
   Then I click "BrowseForProducts.firstCategory_link"
   And User verify in L1 Category Page element "CategoryPage.section_category" is present on page
   And I verify element "CategoryPage.firstCategoryInCategories_link" is present on page
   Then I click on "CategoryPage.firstCategoryInCategories_link"
   And I verify element "PLP.firstProdExtAttr_section" is present on page
   Then I click on "PLP.firstProdExtAttr_section"
   And I verify element "PDP.roHSCompliantIcon_element" is present on page
   Then I click on "PDP.roHSCompliantIcon_element"
   And I verify element "PDP.pDFCert_link" is present on page
   And I verify element "PDP.hTMLCert_link" is present on page
   Then I click on "PDP.hTMLCert_link"
   Then I switch to new window  
   And I wait for "2" seconds
   Then scroll till "PDP.roHSOrderCode_text"
   And I verify element "PDP.roHSOrderCode_text" is present on page
   And I verify element "PDP.roHS_customerName" is present on page
   Then I closed child window and back to parent window   
   And I wait for "2" seconds
   Then I click on "PLP.firstManufacturerPartNo_link"
   And I wait for "2" seconds
   Then scroll till "PDP.legislationAndEnvSection_element"
   And I wait for "2" seconds
   And I verify element "PDP.legislationAndEnvSection_text" is present on page
   Then I click on "PDP.legislationAndEnvSection_text"
   And I verify element "PDP.roHSCompliantIcon_element" is present on page
   And I verify element "PDP.prodComplianceCert_link" is present on page
   Then I click on "PDP.prodComplianceCert_link"
   And I verify element "PDP.pDFCert_link" is present on page
   And I verify element "PDP.hTMLCert_link" is present on page
   Then I click on "PDP.hTMLCert_link"
   Then I switch to new window   
   And I wait for "2" seconds
   Then scroll till "PDP.roHSOrderCode_text"
   And I verify element "PDP.roHSOrderCode_text" is present on page
   Then I verify element "PDP.roHS_customerName" is present on page
   Then I closed child window and back to parent window  
   And I wait for "2" seconds
   Then scroll till "PDP.addToCart_button"
   Then I click on "PDP.addToCart_button"
   And I wait for "2" seconds
   Then I click on "PDP.checkout_button"
   And I wait for "2" seconds
   Then scroll till "ShoppingCart.additionalInformation_button"
   And I click on "ShoppingCart.additionalInformation_button" using js
   And I verify element "PDP.roHSCompliantIcon_element" is present on page
   Then I click on "PDP.roHSCompliantIcon_element" using js
   And I verify element "PDP.pDFCert_link" is present on page
   And I verify element "PDP.hTMLCert_link" is present on page
   Then I click on "PDP.hTMLCert_link"
   Then I switch to new window  
   And I wait for "2" seconds
   Then scroll till "PDP.roHSOrderCode_text"
   And I verify element "PDP.roHSOrderCode_text" is present on page
   And I verify element "PDP.roHS_customerName" is present on page
   Then I closed child window and back to parent window   
   And I wait for "2" seconds
   Then I click on "ShoppingCart.checkoutNow_button"
   And I wait for "2" seconds
   
   
#Author: Raji Kambar
@BurgerNavigation @mobValidationTests @mobAgileRegression
Feature: Burger Navigation Regression

  Background: Launch Burger Navigation for regression check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "guest" user
    And I refresh browser
    And I wait for "5" seconds
    When I click on Navigation Toggle Bar on Home page "Home.navToggle_button"
    And I wait for "3" seconds

  #BurgerNavigation verification
  @Level1 @eu @apac @nwk @live
  Scenario: I want to verify Burger Navigation Level One
    And I take screenshot to see the list Level One Categories List
    And verify values in the "BurgerNavigation.category1Menu_list" table are not empty
    And user display the level1 categories list "BurgerNavigation.category1Menu_list" in the report
    And I verify backArrow header element "BurgerNavigation.backLeftArrowLevel1_button" is present on page
    #check for right arrow
    And I verify the list of elements "BurgerNavigation.category1Menu_list" with right Arrow and aligned as "left"
    When user click on backLeftArrow logo "BurgerNavigation.backLeftArrowLevel1_button"
    And I wait for "3" seconds

  @ViewAllProducts @eu @apac @nwk @live
  Scenario: I want to verify view all products on Burger Navigation
    And I scroll till "BurgerNavigation.viewAllProducts_link"
    And I take screenshot to see View All Products category available
    And I verify element "BurgerNavigation.viewAllProducts_link" is present on page
    And I verify background color of 'View All Products' as "Gray,#cfcfcf,BurgerNavigation.viewAllProducts_link"
    And user click on View All Products category link "BurgerNavigation.viewAllProducts_link"
    And I wait for "3" seconds
    And I take screenshot to see click on the View All Products navigated to Browse for Products page
    And I wait for "5" seconds
    And verify url parameter value as "browse-for-products"
    When user click on farenell logo "Header.companylogo_element"
    And I wait for "3" seconds

  @Manufactureres @eu @apac @nwk @live
  Scenario: I want to verify Manufactureres on  Burger Navigation
    And I scroll till "BurgerNavigation.manufacturer_link"
    And I take screenshot to see Manufacturer category available
    And I verify element "BurgerNavigation.manufacturer_link" is present on page
    And I verify background color of 'Manufacturers' as "Gray,#cfcfcf,BurgerNavigation.manufacturer_link"
    And user click on Manufacturer category link "BurgerNavigation.manufacturer_link"
    And I wait for "3" seconds
    And I take screenshot to see the click on Manufacturer navigated to Manufacturer Lister Page
    #And verify url parameter value as "manufacturers"
    #And user verify text "Manufacturer List" is visible for "BurgerNavigation.manufacturerHeading_element"
    And verify values in the "BurgerNavigation.manufacturer_list" table are not empty
    And user click on manufacturer link "BurgerNavigation.manufacturer_element" only in "UK" store/region
    #And verify values in the "BurgerNavigation.manufacturer1_list" table are not empty
    And user click on manufacturer link "BurgerNavigation.manufacturer1_list" only in "UK" store/region
    When user click on farenell logo "Header.companylogo_element"
    And I wait for "3" seconds

  @Resources @eu @apac @nwk @live
  Scenario: I want to verify Resources on  Burger Navigation
    And I verify element "BurgerNavigation.resources_link" is present on page
    And I scroll till "BurgerNavigation.resources_link"
    And I take screenshot to see Resources category available
    And I verify background color of 'Resources' as "Gray,#cfcfcf,BurgerNavigation.resources_link"
    And user click on Resources category link "BurgerNavigation.resources_link"
    And I wait for "3" seconds
    And I take screenshot to see the click on Resources navigated to Resources List
    And I verify element "BurgerNavigation.resourcesMenuBackEU_button" is present on "EUROPE" region/store
    And I verify element "BurgerNavigation.resourcesMenuBack_button" is present on "APAC,NEWARK" region/store
    #And I verify backArrow header element "BurgerNavigation.resourcesMenuBack_button" is present on page except in "UK" region/store
    And user verify text "Back to Main Menu" in page "BurgerNavigation.resourcesPanelTitleUK_element" for "EUROPE" region/store
    And user verify text "Back to Main Menu" in page "BurgerNavigation.resourcesPanelTitle_element" for "APAC,NEWARK" region/store
    And verify values in the "BurgerNavigation.resourcesMenu_list" table are not empty for "APAC,NEWARK" region/store
    And verify values in the "BurgerNavigation.resourcesMenuUK_list" table are not empty for "EUROPE" region/store
    And user display the level1 categories list "BurgerNavigation.resourcesMenu_list" in the report
    #<-----Ui Verification Step--------->
    And I verify text color of 'Back to Main Menu' as "White,#ffffff,BurgerNavigation.resourcesPanelTitleUK_element" for "EUROPE" region/store
    And I verify text color of 'Back to Main Menu' as "White,#ffffff,BurgerNavigation.resourcesPanelTitle_element" for "APAC,NEWARK" region/store
    And I verify text of 'Back to Main Menu' is Bold "BurgerNavigation.resourcesPanelTitle_element" for "APAC,NEWARK" region/store
    And I verify text of 'Back to Main Menu' is Bold "BurgerNavigation.resourcesPanelTitleUK_element" for "EUROPE" region/store
    And I verify background color of 'Back to Main Menu' as "Green,#41c363,BurgerNavigation.resourcesPanelTitleBckGrnd_element" for "APAC,NEWARK" region/store
    And I verify background color of 'Back to Main Menu' as "Green,#41c363,BurgerNavigation.resourcesPanelTitleBckGrndUK_element" for "EUROPE" region/store
    And user click on backleftArrow on resources "BurgerNavigation.resourcesMenuBack_button" only in "APAC,NEWARK" store/region
    And user click on backleftArrow on resources "BurgerNavigation.resourcesMenuBackEU_button" only in "EUROPE" store/region
    And I wait for "3" seconds
    Then user click on backLeftArrow logo "BurgerNavigation.backLeftArrowLevel1_button"

  @NewProducts @eu @apac @nwk @live
  Scenario: I want to verify New Products on  Burger Navigation
    And I scroll till "BurgerNavigation.newProducts_link"
    And I take screenshot to see NewProducts category available
    And I verify element "BurgerNavigation.newProducts_link" is present on page
    And I verify background color of 'Resources' as "Gray,#cfcfcf,BurgerNavigation.newProducts_link"
    And user click on New Products category link "BurgerNavigation.newProducts_link"
    And I wait for "3" seconds
    And I take screenshot to see the click on new products navigated to new products list
    And I verify backArrow header element "BurgerNavigation.newProductsBack_button" is present on page
    And user verify text "Back to Main Menu" is visible for "BurgerNavigation.newProductsPanelTitle_element"
    And verify values in the "BurgerNavigation.newProductsMenu_list" table are not empty
    And user display the level1 categories list "BurgerNavigation.newProductsMenu_list" in the report
    #<-----Ui Verification Step--------->
    And I verify text color of 'Back to Main Menu' as "White,#ffffff,BurgerNavigation.newProductsPanelTitle_element"
    And I verify background color of 'Back to Main Menu' as "Green,#41c363,BurgerNavigation.newProductsPanelTitle_element"
    And user click on backleftArrow on new products "BurgerNavigation.newProductsBack_button"
    And I wait for "3" seconds
    And user click on backleftArrow on new products "BurgerNavigation.backLeftArrowLevel1_button"

  @AllBurgerNavigation	@eu @apac @nwk @live
  Scenario: I want to verify Burger Navigation Levels of categories
    And I take screenshot to see the list Level One categories
    And user display the level1 categories list "BurgerNavigation.category1Menu_list" in the report
    And I verify backArrow header element "BurgerNavigation.backLeftArrowLevel1_button" is present on page
    #check for right arrow
    And I verify the list of elements "BurgerNavigation.category1Menu_list" with right Arrow and aligned as "left"
    And I wait for "3" seconds
    And user click on the level1 stack element "BurgerNavigation.firstCategory_link"
    And I wait for "2" seconds
    And I take screenshot to see the list Level Two categories
    And user display the level2 categories list "BurgerNavigation.subCategoryMenu_list" in the report
    And user verify the list of elements Sub Menu "BurgerNavigation.subCategoryMenu_list" with right Arrow and aligned as "start"
    And user click on the level2 stack element "BurgerNavigation.subFirstCategory_link"
    And I wait for "2" seconds
    And I take screenshot to see the list Level Three categories
    And user display the level3 categories list "BurgerNavigation.finalSubCategoryMenu_list" in the report
    And user click on the level3 stack element "BurgerNavigation.finalSubFirstCategory_link"
    And I wait for "3" seconds
    #Optional verification of PLP
    And I take screenshot to see Product Lister Page is displayed
    And I verify element "CategoryPage.breadcrumb_link" is present on page and display 'Passive Components' in report
    And I verify h1 element "CategoryPage.category_heading" is present on page and display 'Resistors - Fixed Value' in report
    And I verify text color of 'h1' Category heading as "Black,#333333,CategoryPage.category_heading"
    And I verify text of 'h1' Category heading is Bold "CategoryPage.category_heading"
    And I wait for "3" seconds
    And I verify element "CategoryPage.titleProductCount_value" is present on page and display its value in report
    And I verify text color of Product count value as "Green,#35a753,CategoryPage.titleProductCount_value"
    #---- Below validation step is commented in Sprint77 due to SSP content change
    # And I verify text of Category description in page "CategoryPage.cateogoryMainDescription_text" is present from file "Mobile_TextVerification" except in "NEWARK" region/store.
    And I verify text of "Refine Results" in page "CategoryPage.refineResults_button"
    #<-----Ui Verification Step--------->
    And I verify text color of 'Refine Results' as "White,#ffffff,CategoryPage.refineResults_button"
    And I verify text of 'Refine Results' is Bold "CategoryPage.refineResults_button"
    And I wait for "3" seconds
    And I verify background color of 'Refine Results' as "Green,#41c363,CategoryPage.refineResults_button"

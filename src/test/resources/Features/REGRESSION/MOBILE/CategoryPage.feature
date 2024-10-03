#Author: Naina Vaish

@CategoryPage @clp @mobAgileRegression @mobValidationTests
Feature: Category page regression
  
  In this Feature file Category page naviagtion through search keyword, Buger Navigation and through URL is shown.
  All the basic features for Category Page Regression to be success are covered.
  All the Product lister validation specific to products will be covered in PLP Regression

  #NOTE: Category Main description is switched off by content Team for Newark
  
  Background: Launch homepage for regression check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user

  @CategoryPageReg @eu @apac @nwk @live
  Scenario: Validate Category Page first landing page Sections
    When I click on Navigation Toggle Bar on Home page "Home.navigationToggleBar_button"
    And I wait for "4" seconds
    And I verify first category element "BurgerNavigation.firstCategory_link" is present on page and display 'Passives' in report
    And I click "BurgerNavigation.firstCategory_link"
    And I verify first sub level category element "BurgerNavigation.subFirstCategory_link" is present on page and display 'Passive Components' in report
    And I click "BurgerNavigation.subFirstCategory_link"
    And I verify first sub level category element "BurgerNavigation.finalSubFirstCategory_link" is present on page and display 'Resistors - Fixed Value' in report
    And I click "BurgerNavigation.finalSubFirstCategory_link"
    And I wait for "4" seconds
    #<----Verification of Category text is dependent on keyword search : Resistor------->
    And I verify element "CategoryPage.breadcrumb_link" is present on page and display 'Passive Components' in report
    And I verify h1 element "CategoryPage.category_heading" is present on page and display 'Resistors - Fixed Value' in report
    And I verify text color of 'h1' Category heading as "Black,#333333,CategoryPage.category_heading"
    And I verify text of 'h1' Category heading is Bold "CategoryPage.category_heading"
    And I verify element "CategoryPage.titleProductCount_value" is present on page and display its value in report
    And I verify text color of Product count value as "Green,#35a753,CategoryPage.titleProductCount_value"
    #---- Below validation step is commented in Sprint77 due to SSP content change
    # And I verify text of Category description in page "CategoryPage.cateogoryMainDescription_text" is present from file "Mobile_TextVerification" except in "NEWARK" region/store.
    And I verify text of "Refine Results" in page "CategoryPage.refineResults_button"
    #<-----Ui Verification Step--------->
    And I verify text color of 'Refine Results' as "White,#ffffff,CategoryPage.refineResults_button"
    And I verify text of 'Refine Results' is Bold "CategoryPage.refineResults_button"
    And I verify background color of 'Refine Results' as "Green,#41c363,CategoryPage.refineResults_button"
    #<---------------------------------->
    And User verify in L0 Category Page element "CategoryPage.section_category" is present on page
    And I verify text of "Categories" in page "CategoryPage.categories_text"
    #<-----Ui Verification Step--------->
    And I verify text color of 'h2' Categories heading as "White,#ffffff,CategoryPage.categories_text"
    And I verify text of 'h2' Categories  heading is Bold "CategoryPage.categories_text"
    And I verify background color of 'Categories' as "Green,#41c363,CategoryPage.section_category"
    #<---------------------------------->
    And I verify Miscellaneous Categories are present at the bottom in Categories Section "CategoryPage.categoriesSection_list"
    Then I verify Categories with product count is present in descending order in Categories Section "CategoryPage.categoriesSection_list"
    And I verify SortBy element "CategoryPage.sortBy_dropdown" is present on page
    And I verify first pagination element "CategoryPage.topPagination_text" is present on page and display 'Showing 1-25 of xx products' in report
    And I verify Category lister page is not empty "CategoryPage.categorylisterProducts_section"
    And I scroll till "CategoryPage.categorylisterProducts_section"
    And I take screenshot to view the product section availability
    Then I scroll till "CategoryPage.bottomPagination_text"
    And I wait for "2" seconds
    And I verify first pagination element "CategoryPage.bottomPagination_text" is present on page and display 'Showing 1-25 of xx products' in report
    And I verify text of "1" in page "CategoryPage.currentPageSelected_text"
    #<-----Ui Verification Step--------->
    And I verify text color of '1' for pagination as "Green,#41c363,CategoryPage.currentPageSelected_text"
    And I verify text of '1' for pagination is Bold "CategoryPage.currentPageSelected_text"
    And I scroll till "CategoryPage.currentPageSelected_text"
    And I take screenshot to view the pagination current selection set to 1 having 2,3...xx and arrow

  #<---------------------------------->
  @multiCategoryPage @eu @apac @nwk @live
  Scenario Outline: Validate the multi-category page navigating via search keyword
    When user enter the value "Resistor" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I take screenshot to view the searched category page display
		#-------Currently removed----------
    #And I verify text of Category First Paragraph from "KeyValue" in page "CategoryPage.categoryFirstParagraph_text" from file "Mobile_TextVerification"
    And I take screenshot to view the Category page
    #-------Currently removed----------
    #And I verify text of Category Sub Paragraph in page "CategoryPage.categorySubParagraph_text" from file "Mobile_TextVerification"
    #And I verify link to sub paragraph element "CategoryPage.categorySubParagraph_link" is present on page
    #When I click on the first link for viewing similar list of items "CategoryPage.categorySubParagraph_link"
    And I take screenshot to view the multi category page display
    And I verify text of Category description in page "MultiCategoryPage.resultFoundFor_text" is present from file "Mobile_TextVerification" except in "" region/store.
    And I verify element "MultiCategoryPage.titleProductCount_value" is present on page and display its value in report
    And I verify text color of Product count value as "Green,#35a753,MultiCategoryPage.titleProductCount_value"
    And I verify text of Product count is Bold "MultiCategoryPage.titleProductCount_value"
    And I verify text of "Refine Results" in page "MultiCategoryPage.refineResults_button"
    #<-----Ui Verification Step--------->
    And I verify text color of 'Refine Results' as "White,#ffffff,MultiCategoryPage.refineResults_button"
    And I verify text of 'Refine Results' is Bold "MultiCategoryPage.refineResults_button"
    And I verify background color of 'Refine Results' as "Green,#41c363,MultiCategoryPage.refineResults_button"
    #<---------------------------------->
    And I verify search within textbox element "MultiCategoryPage.searchWithin_textbox" is present on page
    And I verify search within button element "MultiCategoryPage.searchWithin_icon" is present on page
    And I enter value "Chip" in textbox "MultiCategoryPage.searchWithin_textbox"
    And I click "MultiCategoryPage.searchWithin_icon"
    And I verify text of Category description in page "MultiCategoryPage.resultFoundForSearchWithin_text" is present from file "Mobile_TextVerification" except in "" region/store.
    And I take screenshot to view the shortlisted categories
    And I verify Multi-Categories for element "MultiCategoryPage.multiCategories_section" is present on page except in "CN" region/store
    And I verify text of "Show All Products" in page "MultiCategoryPage.onlyAtBottomShowAllProducts_button" for "UK,SG,US,MEXICO" region/store
    #<-----Ui Verification Step--------->
    And I verify text color of 'Show All Products' as "White,#ffffff,MultiCategoryPage.onlyAtBottomShowAllProducts_button" for "UK,SG,US,MEXICO" region/store
    And I verify text of 'Show All Products' is Bold "MultiCategoryPage.onlyAtBottomShowAllProducts_button" for "UK,SG,US,MEXICO" region/store
    And I verify background color of 'Show All Products' as "Green,#41c363,MultiCategoryPage.onlyAtBottomShowAllProducts_button" for "UK,SG,US,MEXICO" region/store
    #<---------------------------------->
    And I click "MultiCategoryPage.onlyAtBottomShowAllProducts_button" only in "UK,SG,US,MEXICO" store/region
    And I take screenshot to see Category page is displayed with all categories
    Then verify values in the "CategoryPage.multiCategorySection_element" table are not empty

  @plpCategorySectionLink @eu @apac @nwk @live
  Scenario: Naviagte to PLP using the subcategory links in categories section
    When I navigate to "Category-Node-L1" page using details from json "pageUrls.json"
    And I verify in L0 Category Page element "CategoryPage.section_category" is present on page
    And I verify first category element "CategoryPage.categoriesSectionFirst_link" is present on page and display 'Chip SMD Resistors' in report
    And I click "CategoryPage.categoriesSectionFirst_link"
    And I take screenshot to view the PLP landing page
    And I verify breadcrumb element "PLP.breadcrumb_link" is present on page and display 'Resistors - Fixed Value' in report
    And I verify category name element "PLP.category_text" is present on page and display 'Chip SMD Resistors' in report
    And I verify element "PLP.titleProductCount_value" is present on page and display its value in report
    And I click "PLP.breadcrumb_link"
    And I take screenshot to view that user is naviated back to category page
    And I verify h1 element "CategoryPage.category_heading" is present on page and display 'Resistors - Fixed Value' in report
    And I click "CategoryPage.refineResults_button"
    Then I verify text of "Apply Filters" in page "Filters.applyFilters_button"
    And I take screenshot to see that refine results button is working fine

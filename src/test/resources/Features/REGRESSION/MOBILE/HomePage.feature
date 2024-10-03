#Author: Rajeshwari KV
@homepage @mobAgileRegression @mobValidationTests
Feature: Home page functionality check

  Background: Launch homepage for regression check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "guest" user

  #HomePage Header verification
  @HomePage @Header @eu @apac @nwk @nacn @live
  Scenario: I want to verify Header on HomePage header section
    And I wait for "3" seconds
    And I verify link "Header.login_link" is present
    And I verify text "Login / Register" in page "Header.login_link"
    # And user verify text "Login / Register" is visible for "Header.login_link"
    When user click on login link "Header.login_link"
    Then I wait for "6" seconds
    And I take screenshot to see the login page is loaded
    And I verify element "Login.username_textbox" is present on page
    When user click on registernow button "Login.register_now_button"
    Then I wait for "6" seconds
    And I take screenshot to see the Register page is loaded
    And I verify element "Register.registerTitle_text" is present on page
    When user click on farenell logo "Header.companylogo_element"
    And I wait for "3" seconds
    And I verify element "Header.countrySelector_icon" is present on page
    When user click on country selector flag "Header.countrySelector_icon"
    Then I wait for "6" seconds
    And I take screenshot to see the country selection page is loaded
    And I verify the Country/Region element "CountryPopUp.countries_element" is present on page
    And I verify the continue button element "CountryPopUp.continue_button" is present on page
    And I verify link "CountryPopUp.export_link" is present
    And user click on close icon "CountryPopUp.close_icon"
    And I wait for "3" seconds
    And I verify element "Header.miniBasket_link" is present on page
    And I verify element "Header.itemsInMiniBasket_text" is present on page
    And user click on shoppingcart icon "Header.miniBasket_link"
    And I wait for "3" seconds
    And I take screenshot to see the shopping page is present
    And I verify element "ShoppingCart.checkoutNow_button" is present on page
    And user click on farenell logo "Header.companylogo_element"
    And I wait for "3" seconds
    And I verify element "Header.searchBox_textbox" is present on page
    When user click on searchIcon element "Header.searchIcon_button"
    And verify url parameter value as "browse-for-products"
    And user click on farenell logo "Header.companylogo_element"
    And user enter search term value "res" in textbox "Header.searchBox_textbox"
    And I wait for "3" seconds
    And I verify the "Search.attributes_text" listed for "Search.attributes_list" has atleast "1" rows of data
    And I verify the "Search.productCategories_text" listed for "Search.productCategories_list" has atleast "3" rows of data
    And I verify the "Search.manufacturers_text" listed for "Search.manufacturers_list" has atleast "3" rows of data
    And I verify the "Search.products_text" listed for "Search.products_list" has atleast "3" rows of data
    And user click on farenell logo "Header.companylogo_element"
    And I wait for "3" seconds
    #Navigation bar
    And I verify element "Home.navToggle_button" is present on page
    And user click on navigation bar "Home.navToggle_button"
    And I wait for "3" seconds
    And I take screenshot to see the list Level One categories
    And verify values in the "Home.category1_list" table are not empty
    And user click on backarrow element "Home.backArrow_link"

  #service proposition Verification
  @HomePage @HomepageCenter @eu @apac @nwk @nacn @live
  Scenario: I want to verify Categories and Tiles on HomePage
    And I wait for "3" seconds
    And I verify service title element "Home.truck_image" is present on page
    And I verify service title element "Home.title_element" is present on page
    And I verify service sub title element "Home.subtitle_element" is present on page
    #Marketing Espot verification
    And I verify marketing Espot section element "Home.espot_element" is present on page
    #Horizontal category section
    And I scroll till "Home.subcategory_list"
    And I take screenshot to see the Horizontal category section on the home page
    And verify values in the "Home.subcategory_list" table are not empty
    When user click on category link "Home.category_link"
    And I wait for "3" seconds
    And I verify the categorylist sticky element "Home.sticky_element" is present on page
    And I verify the category close sticky element "Home.viewAll_link" is present on page
    Then user click on close icon "Home.stickyclose_element"
    And I wait for "3" seconds
    #Recent Searches
    And I scroll till "Home.paneltitle_element"
    And I take screenshot to see the Recent search section on the home page
    And I verify the recent search section element "Home.paneltitle_element" is present on page
    #Quick launch section
    And I verify values in the "Home.quicklaunch_list" table are not empty
    #E-commm Banner Section
    And I scroll till "Home.ecommbanner_list"
    And I take screenshot to see the E Banner section on the home page
    And I verify values in the "Home.ecommbanner_list" table are not empty
    Then I wait for "6" seconds
    #New product,Great deals and Featured products section
    And I scroll till "Home.newProducts_label"
    And I take screenshot to see the New Products section on the home page
    And user verify text "New Products" is visible for "Home.newProducts_label"
    And verify text "New Products" in page "Home.newProducts_label"
    And I verify element "Home.newProductviewAll_link" is present on page
    And verify values in the "Home.newProducts_list" table are not empty
    Then I wait for "6" seconds
    And I scroll till "Home.greatDeals_label"
    And I take screenshot to see the Great Deals section on the home page
    And verify text "Great Deals" in page "Home.greatDeals_label"
    And I verify element "Home.greatDealsviewAll_link" is present on page
    And verify values in the "Home.greatDeals_list" table are not empty
    Then I wait for "6" seconds
    And I scroll till "Home.featuredproducts_label"
    And I take screenshot to see the featured products section on the home page
    And verify text "Featured Products" in page "Home.featuredproducts_label"
    And verify values in the "Home.featured_list" table are not empty
    #Manufactures Section
    And I scroll till "Home.manufacture_label"
    And I take screenshot to see the Manufacturer section on the home page
    And verify contains "leading manufacturers" in "Home.manufacture_label"
    And I verify element "Home.manufacturevieAll_link" is present on page
    And I verify element "Home.manufacturerList_image" is present on page

  #Footer Section verification
  @HomePage @Footer @eu @apac @nwk @nacn @live
  Scenario: I want to verify Footer Section on HomePage
    And I wait for "3" seconds
    # And I verify values in the "Home.services_list" table are not empty
    Then I verify below are displayed for "UK,SG,US" region or store in "Home.services_list" table
      | View All Products        |
      | Shopping Cart            |
      | My Account               |
      | Order History & Tracking |
      | Calculators & Charts     |
      | View All Manufacturers   |
      | Engineering Glossary     |
      | Contact Us               |
      | About Us                 |
    But I verify below are displayed for "CN,FR,MEXICO" region or store in "Home.services_list" table
      | View All Products        |
      | Shopping Cart            |
      | My Account               |
      | Order History & Tracking |
      | Calculators & Charts     |
      | View All Manufacturers   |
      | Contact Us               |
      | About Us                 |
    And I scroll till "Home.faceBook_icon"

    And I take screenshot to see the Footer Services section on the page
    Then I verify element "Home.faceBook_icon" is present on "[EUROPE,APAC,NEWARK]" region/store.
    Then I verify element "Home.twitter_icon" is present on "[EUROPE,APAC,NEWARK]" region/store.
    Then I verify copyright section element "Home.copyright_element" is present on page
    And I verify element "Home.desktopSite_link" is present on "[EUROPE,APAC,NEWARK]" region/store.
    And I verify element "Home.termsOfpurchase_link" is present on "[EUROPE]" region/store.
    And I verify element "Home.termsOfAccess_link" is present on "[EUROPE]" region/store.
    And I verify element "Home.termsconditions_link" is present on "[APAC,NEWARK]" region/store.
    And I verify element "Home.termsOfuse_link" is present except in "[EUROPE,NEWARK]" region/store.
    And I verify element "Home.cookieeSetting_link" is present on "[EUROPE]" region/store.
    And I verify element "Home.services_link" is present on "[EUROPE,APAC,NEWARK]" region/store.
    And I verify element "Home.technicalRes_link" is present on "[EUROPE,APAC,NEWARK]" region/store.
    And I verify element "Home.help_link" is present on "[EUROPE,APAC,NEWARK]" region/store.
    And I scroll till "Home.help_link"
    And I take screenshot to see the Footer section on the home page

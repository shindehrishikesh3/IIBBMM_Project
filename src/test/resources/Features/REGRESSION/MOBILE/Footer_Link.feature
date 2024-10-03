@mobValidationTests
Feature: All pages footer link to be covered mainly for dual languages stores like DE, CH etc.

  @footerLink @dualLang @eu @apac @nwk @live
  Scenario Outline: Verify Footer Section
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    And I wait for "2" seconds
    And I verify element "Header.countrySelector_icon" is present on page
    When user click on country selector flag "Header.countrySelector_icon"
    Then I wait for "5" seconds
    And I verify the Country/Region element "CountryPopUp.countries_element" is present on page
    And I take screenshot
    And I select "<Language>" language for dual language store
    And I click on the continue button "CountryPopUp.continue_button" using js
    And I wait for "2" seconds
    And I scroll till "Home.faceBook_icon"
    And I take screenshot
    And I click on view all products footer link on home page "Home.viewAllProducts_link"
    And I wait for "3" seconds
    And I verify element "BrowseForProducts.firstCategory_link" is present on page and display name of First Category in report
    And I wait for "3" seconds
    And user click on farenell logo for navigate to home page "Header.companylogo_element"
    And I wait for "2" seconds
    And I click on shopping cart link on home page "Home.shoppingCart_link"
    And I wait for "5" seconds
    Then I verify text "Checkout Now" in page "ShoppingCart.checkoutNow_button"
    And user click on farenell logo for navigate to home page "Header.companylogo_element"
    And I wait for "2" seconds
    And I click on my account footer link "Home.myFooterAccount_link" using js
    And I wait for "5" seconds
    Then I verify text "My Account Summary" in page "AccountSummary.myAccountSummary_text"
    And user click on farenell logo for navigate to home page "Header.companylogo_element"
    And I wait for "5" seconds
    And I click on Order History & Tracking footer link "Home.orderHistoryAndTracking_link"
    And I wait for "2" seconds
    Then I verify text "Order History & Tracking" in page "OrderHistory.orderHistoryTracking_text"
    And user click on farenell logo for navigate to home page "Header.companylogo_element"
    And I wait for "2" seconds
    And I click on Calculators & Charts footer link  "Home.calculatorsAndCharts_link"
    And I wait for "2" seconds
    And I verify current url contains "calculators-conversion-tools"
    And user click on farenell logo for navigate to home page "Header.companylogo_element"
    And I wait for "2" seconds
    And I click on view All Manufacturers footer link "Home.viewAllManufacturers_link"
    And I wait for "6" seconds
    Then I verify text "Manufacturer List" in page "ManufacturerListPage.ManufacturerList_text"
    And user click on farenell logo for navigate to home page "Header.companylogo_element"
    And I wait for "2" seconds
    And I verify and click on element Engineering Glossary link if its present on page
    And user click on farenell logo for navigate to home page "Header.companylogo_element"
    And I wait for "2" seconds
    And I click on "Home.contactUs_link"
    And I wait for "2" seconds
    And user verify text "Contact Us" in page "ContactUs.contctUsHeading_text" for "EUROPE" region/store
		And user verify text "Contact Us" in page "ContactUs.contctUsHeadingAPAC_text" for "APAC" region/store
		And I wait for "5" seconds
		And user verify text "Contact Us" in page "ContactUs.contctUsHeadingNWK_text" for "NEWARK" region/store
    And user click on farenell logo for navigate to home page "Header.companylogo_element"
    And I wait for "2" seconds
    And I click on "Home.aboutUs_link"
    And I wait for "2" seconds
    And I wait "3" seconds for switch About Us new window
    And I switch to About Us window
    And I verify element "AboutUs.aboutUs_text" is present on page
    And I take screenshot

    Examples: 
      | Language |
      | First    |
      | Second   |

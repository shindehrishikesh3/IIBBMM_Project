#GeoLocation banner validation
 
 @mobValidationTests @GeoLocationValidation @Priority4
 Feature: GeoLocation functionality check

  Background: Launch homepage for regression check
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "guest" user
 
   @Geolocation1
   Scenario: I want to verify the Geolocation banner No button in homepage
    And I wait for "3" seconds
    And I verify element "Home.geoLocationbanner_element" is present on page
    And I verify element "Home.geoLocationPrefercountry_text" is present on page
    And I verify element "Home.geoLocationYes_button" is present on page
    And I verify element "Home.geoLocationNo_button" is present on page
    And I verify element "Home.geoLocationcountry_link" is present on page
    And I verify element "Home.geoLocationremember_text" is present on page
    And I verify element "Home.geoLocationremember_checkbox" is present on page
    And I take screenshot of the page
    And I verify the "Home.geoLocationNo_button" functionality
    And I take screenshot of the page
    
    @Geolocation2
    Scenario: I want to verify the Geolocation banner yes button in homepage
    And I wait for "3" seconds
    And I verify element "Home.geoLocationbanner_element" is present on page
    And I verify element "Home.geoLocationPrefercountry_text" is present on page
    And I verify element "Home.geoLocationYes_button" is present on page
    And I verify element "Home.geoLocationNo_button" is present on page
    And I verify element "Home.geoLocationcountry_link" is present on page
    And I verify element "Home.geoLocationremember_text" is present on page
    And I verify element "Home.geoLocationremember_checkbox" is present on page
    And I take screenshot of the page
    Then I verify the "Home.geoLocationremember_checkbox" remember me functionality
    And web site is launched successfully and user "does" accept the cookies
    And I take screenshot of the page
    And I wait for "5" seconds
    
    @Geolocation3
    Scenario: I want to verify the Geolocation change country button in homepage
    And I wait for "3" seconds
    And I verify element "Home.geoLocationbanner_element" is present on page
    And I verify element "Home.geoLocationPrefercountry_text" is present on page
    And I verify element "Home.geoLocationYes_button" is present on page
    And I verify element "Home.geoLocationNo_button" is present on page
    And I verify element "Home.geoLocationcountry_link" is present on page
    And I verify element "Home.geoLocationremember_text" is present on page
    And I verify element "Home.geoLocationremember_checkbox" is present on page
    And I take screenshot of the page
    And I click on "Home.geoLocationcountry_link" and verify its functionality
    And I wait for "5" seconds
    And I take screenshot of the page
    
    @Geolocation4
   Scenario: I want to verify the Geolocation banner cancel button
    And I wait for "3" seconds
    And I verify element "Home.geoLocationbanner_element" is present on page
    And I verify element "Home.geoLocationYes_button" is present on page
    And I verify element "Home.geoLocationPrefercountry_text" is present on page
    And I verify element "Home.geoLocationNo_button" is present on page
    And I verify element "Home.geoLocationclose_icon" is present on page
    And I verify element "Home.geoLocationcountry_link" is present on page
    And I click on the geoLocation cancel button "Home.geoLocationclose_button"
    And I verify absence of element "Home.geoLocationbanner_element"
    And I take screenshot of the page
    Then I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I verify element "Home.geoLocationbanner_element" is present on page
    And I take screenshot of the page
#Author: Rajeshwari KV
#Cookie Verification
@mobRegression
Feature: CookieBanner functionality check

  @CookieValidation @eu @apac @nwk
  Scenario: Validate the one trust cookie functionality
    Given web site is launched successfully and user "does not" accept the cookies
    Then customer accesses the website as "guest" user
    Then I verify element "CookieSetting.cookieebanner_element" is present on page
    And user verify text "Cookie Settings and Privacy" is visible for "CookieSetting.cookieeTitle_element"
    And I take screenshot to see the Cookiee Banner is present on page
    And I verify link "CookieSetting.moreinfo_link" is present
    And I verify the accept all cookies button element "CookieSetting.oneTrustCookie_button" is present on page
    And I verify the text "CookieSetting.oneTrustCookie_button" is aligned as "center"
    And I verify element "CookieSetting.cookieSettings_element" is present on page
    And I verify text "CookieSetting.cookieSettings_element" is aligned as "center"
    And user click on cookiesetting link on cookie banner "CookieSetting.cookieSettings_element"
    And I wait for "3" seconds
    And user verify text "Cookies Preference Center" is visible for "CookieSetting.cookieeprefrence_element"
    And user click on close icon "CookieSetting.preferenceClose_element"
    And I wait for "4" seconds
    And user click on acceptall cookie button "CookieSetting.oneTrustCookie_button"
    And I wait for "3" seconds
    And I take screenshot to see the page is loaded on accepting cookiee

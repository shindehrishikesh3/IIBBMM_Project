@analyticstests @analyticsValidation @eu @live
Feature: OneTrust Consent Scenarios

  Background: Initial Cookie Checks
    Given web site is launched successfully and user "does not" accept the cookies
    And I verify element "CookieSetting.cookieSettings_link" is present on page
    When I click the "CookieSetting.cookieSettings_link"
    And I wait for "10" seconds
    And I scroll till "CookieSetting.savePreferences_button"
    And I verify text "false" in page "CookieSetting.cookieFunctional_Switch" with attribute "aria-checked"
    And I verify text "false" in page "CookieSetting.cookieTargeting_Switch" with attribute "aria-checked"
    And I verify text "false" in page "CookieSetting.cookiePerformance_Switch" with attribute "aria-checked"
    And I take screenshot

  @onetrust @enablePerfLogs @SEIT-38
  Scenario: All cookies enabled using allow all button - all calls should happen
    And I click the "CookieSetting.cookieAllowAll_Button"
    And I wait for "10" seconds
    And get performance logs
    Then verify "/ss" call exists
    And verify "AppMeasurement" call exists

  @onetrust @enablePerfLogs @SEIT-38
  Scenario: All cookies enabled using toggles - all calls should happen
    And I click the "CookieSetting.cookieFunctional_Switch"
    And I verify text "true" in page "CookieSetting.cookieFunctional_Switch" with attribute "aria-checked"
    And I click the "CookieSetting.cookieTargeting_Switch"
    And I verify text "true" in page "CookieSetting.cookieTargeting_Switch" with attribute "aria-checked"
    And I click the "CookieSetting.cookiePerformance_Switch"
    And I verify text "true" in page "CookieSetting.cookiePerformance_Switch" with attribute "aria-checked"
    And I wait for "5" seconds
    And I take screenshot
    And I click the "CookieSetting.savePreferences_button"
    And I wait for "10" seconds
    And get performance logs
    Then verify "/ss" call exists
    And verify "AppMeasurement" call exists

  #Functional Cookies, Targeting Cookies, Performance Cookies
  @onetrust @enablePerfLogs @SEIT-38
  Scenario: No cookies enabled - no calls should happen
    And I click the "CookieSetting.savePreferences_button"
    And I wait for "10" seconds
    And get performance logs
    Then verify "/ss" call does not exist
    And verify "AppMeasurement" call does not exist

  @onetrust @enablePerfLogs @SEIT-38
  Scenario: Functional Cookies and Targeting Cookies enabled Performance Cookies disabled - no calls should happen
    And I click the "CookieSetting.cookieFunctional_Switch"
    And I verify text "true" in page "CookieSetting.cookieFunctional_Switch" with attribute "aria-checked"
    And I click the "CookieSetting.cookieTargeting_Switch"
    And I verify text "true" in page "CookieSetting.cookieTargeting_Switch" with attribute "aria-checked"
    And I wait for "5" seconds
    And I take screenshot
    And I click the "CookieSetting.savePreferences_button"
    And I wait for "10" seconds
    And get performance logs
    Then verify "/ss" call does not exist
    And verify "AppMeasurement" call does not exist

  @onetrust @enablePerfLogs @SEIT-38
  Scenario: Functional Cookies disabled Targeting Cookies and Performance Cookies enabled - all calls should happen
    And I click the "CookieSetting.cookieTargeting_Switch"
    And I verify text "true" in page "CookieSetting.cookieTargeting_Switch" with attribute "aria-checked"
    And I click the "CookieSetting.cookiePerformance_Switch"
    And I verify text "true" in page "CookieSetting.cookiePerformance_Switch" with attribute "aria-checked"
    And I wait for "5" seconds
    And I take screenshot
    And I click the "CookieSetting.savePreferences_button"
    And I wait for "10" seconds
    And get performance logs
    Then verify "/ss" call exists
    And verify "AppMeasurement" call exists

  @onetrust @enablePerfLogs @SEIT-38
  Scenario: Functional Cookies and Targeting Cookies disabled Performance Cookies enabled - no calls should happen
    And I click the "CookieSetting.cookiePerformance_Switch"
    And I verify text "true" in page "CookieSetting.cookiePerformance_Switch" with attribute "aria-checked"
    And I wait for "5" seconds
    And I take screenshot
    And I click the "CookieSetting.savePreferences_button"
    And I wait for "10" seconds
    And get performance logs
    Then verify "/ss" call does not exist
    And verify "AppMeasurement" call does not exist

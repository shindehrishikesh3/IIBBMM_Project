@validationTests 
Feature: Homepage and login validation tests

  @ForgotPassword @Priority3 @eu @apac @nwk @live
  Scenario: Forgot password
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "guest" user
		    And I click on login link on home page "Header.login_link"
		    And wait for "2" seconds
		    Then I scroll till "Login.forgotPassword_link"
		    And I click on forgot password link on login page "Login.forgotPassword_link" using js
		    And I wait for "2" seconds
		    Then I verify the message that contains "your password" in Forgot Password page "ForgotPassword.forgotYourPassword_text"
		    And I enter email value "pf_testuser@yahoo.com" in textbox "ForgotPassword.email_textbox"
		    And I click on send reset link "ForgotPassword.sendResetLink_button"
		    And I wait for "10" seconds
		    And I check if MultipleUsername window is displayed and add username in "ForgotUsername.username_text"
		    And I wait for "2" seconds
		    And I verify the message that contains "Email Sent" in page "ForgotPassword.resetEmailSent_text"
		    And I take screenshot of page

  @ShowPagesForTabs @Priority3 @eu @apac @nwk @live
  Scenario: Homepage - View Pages for tabs on Home page
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "register" user
		    And I wait for "3" seconds
		    And I hover on element "Header.tools_link"
		    And I click BuyingTools tab from homepage "Home.allBuyingtools_link"
		    And I verify element "BuyingTools.buyingListTools_link" is present on page and display 'BuyingListTools' in report
		    Then I take screenshot
		    And I wait for "3" seconds
		    Then I hover on element "Header.resource_link"
		    And I wait for "3" seconds
		    And I click all Services_link under resources tab "Home.allServices_link"
		    And I wait for "3" seconds
		    And I verify element "Services.services_link" is present on page and display 'Services' in report
		    Then I take screenshot
		    And I click "Header.resource_link"
		    And I wait for "3" seconds
		    And I click "Home.alltechnicalResources_link" using js
		    And I verify element "TechnicalResources.technicalResources_text" is present on page and display 'TechnicalResources' in report
		    Then I take screenshot
		    And I click "Header.resource_link"
		    And I wait for "3" seconds
		    And I click on help tab "Home.help_link"
		    And I wait for "3" seconds
		    And verify url parameter value as "help"
		    Then I take screenshot
		    And I hover on element My Account "Header.myAccount_dropdown"
		    And I wait for "2" seconds
		    And I click Account Summary from the dropdown "Header.accountSummary_link"
		    And I wait for "5" seconds
		    And I take screenshot to verify the Account Summary page is displayed
		    And I verify element "AccountSummary.accountSummary_link" is present on page and display 'My Account Summary' in report
		    And I hover on element My Account "Header.myAccount_dropdown"
		    And I click on logout option "Header.logout_button"

  @ForgotUsername @Priority3 @eu @apac @nwk @live
  Scenario: Forgotten Username - Successful Request test
		    Given web site is launched successfully and user "does" accept the cookies
		    When customer accesses the website as "guest" user
		    Then User click on Login link in Header page "Header.login_link"
		    And I scroll till "Login.forgotUsername_link"
		    And I click on Forgotten Username link "Login.forgotUsername_link" using js
		    And I verify text "Forgotten your username?" in page "ForgotUsername.forgotUsernameconfirmation_element" with attribute "innerText"
		    And I enter email value "pf_testuser@yahoo.com" in textbox "ForgotUsername.email_text"
		    Then User scroll till "ForgotUsername.sendUsername_button"
		    #And I click on label "ForgotUsername.email_label"
		    And I click on send Button  "ForgotUsername.sendUsername_button" using js
   	    And I wait for "15" seconds
        And I check if MultipleUsername window is displayed and add username in "ForgotUsername.username_text"
		    And user verify text "Username has been sent" in page "ForgotUsername.successMessage_text"
		    And I take screenshot of the page

  @ChangeCountry @Priority3 @eu @apac @nwk @live
  Scenario: Homepage - Change the country usning country selector on header topbar
		    Given web site is launched successfully and user "does" accept the cookies
		    When customer accesses the website as "guest" user
		    Then User click on Change Country Button in Header topbar "Header.flag_link"
		    And I switch to Country Selector window
		    Then I click on Coutry field  "Header.country_dropdown"
		    And User select Country from dropdown "Header.country_dropdown"
		    And I click on continue Button "Header.continue_button"
		    And I wait for "4" seconds
		    And User verify Expected URL matches with Current URL
		    And I take screenshot of page
		    And user navigates back in the browser

  @NavigateToCommunitySiteTest @Priority3 @eu @apac @nwk @live
  Scenario: Navigate to community site
		    Given web site is launched successfully and user "does" accept the cookies
		    When customer accesses the website as "guest" user
		    And I wait for "5" seconds
		    And I click on element "Header.community_tab"
		    And I wait for "8" seconds
		    And I take screenshot
		    And I click on  Community link "Home.community_link"
		    And I wait "8" seconds for communitySite new window
		    And I switch to communitySite window
		    And I wait for "5" seconds
		    And I take screenshot of communitySite
		    And I verify current url contains "https://community.element14.com/"

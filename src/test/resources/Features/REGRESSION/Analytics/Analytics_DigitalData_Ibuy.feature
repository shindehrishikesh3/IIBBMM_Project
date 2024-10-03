#Author: Rashmi P
Feature: Analytics digitaldata Ibuy smoke Tests

  Background: 
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "userType" user

  @ibuydigidata @analyticssmoke @eu @apac @nwk
  Scenario: Add account to newly created PFSA iBuy Organisation
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "ibuy pfsa admin" user
    And I wait for "3" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    #----- Ibuy Options validation -------#
    And I scroll till "MyAccount.companyList_link"
    And I wait for "5" seconds
    And I take screenshot of the page to view iBuy menu on LHS
    Then I verify element "MyAccount.iBuyAdmin_text" is present on page
    And I verfiy element "MyAccount.companyList_link" is present on page
    When I click on "MyAccount.companyList_link"
    And I wait for "3" seconds
    And I take screenshot of Company List page
    #---- Creating Ibuy Organisation ---------#
    And I scroll till "iBuyCompanyList.addNewCompany_button"
    And I click on "iBuyCompanyList.addNewCompany_button"
    And I wait for "4" seconds
    And I take screenshot of Add Company page
    Then I verfiy element "iBuyAddCompany.addCompanyHeader_text" is present on page and display 'Add Company page' in report
    And I enter new IBUY Company name on Add Company page
    And I take screenshot of the page
    And I click on Add button "iBuyAddCompany.add_button"
    And I wait for "5" seconds
    And I scroll till "iBuyCompanyList.companyNameInTable_label"
    And I take screenshot of the page
    #---- Add Account to created company----#
    And I click on "iBuyEditCompany.editCompany_link"
    And I click on "iBuyAddAccount.addNewAccount_button"
    Then I verify element "iBuyRetrieveAccount.accountNumber_textbox" is present on page
    When I enter Trade account Account number using given file "OrderInformation.xlsx"
    And I click on "iBuyRetrieveAccount.searchUsers_button"
    And I wait for "5" seconds
    And I scroll till "iBuyEditCompany.save_button"
    Then I click on save button "iBuyEditCompany.save_button"
    And I scroll down the page by pixels "300"
    Then I verfiy element "iBuyCompanyStructure.companyStructure_link" is present on page and display 'Company Structure page' in report
    And I click on "iBuyCompanyStructure.companyStructure_link"
    And I wait for "3" seconds
    And I click on "iBuyCompanyStructure.structureTopLevel_text"
    And I click on Account and Payment link "iBuyEditCompany.editCompanyAcctandPayment"
    And I wait for "3" seconds
    And I click on the enable checkbox icon "iBuyEditCompany.enableCheckbox"
    And I click on the Save button "iBuyEditCompany.save_button"
    And I wait for "3" seconds
    And I take screenshot of the page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"

  @ibuydigidata @analyticssmoke @eu @apac @nwk
  Scenario Outline: To Create iBuy user-<UserRole>
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "ibuy pfsa admin" user
    And I wait for "10" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "10" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I scroll till "MyAccount.companyList_link"
    And I wait for "5" seconds
    And I take screenshot of the page to view iBuy menu on LHS
    When I click on "MyAccount.companyList_link"
    And I wait for "3" seconds
    And I take screenshot of Company List page
    Then I verify element "iBuyCompanyList.companyListHeader_text" is present on page and display 'Company List Page' in report
    #---search for a company and navigate to company page---#
    Then I enter last registered company in textbox "iBuyCompanyList.companyName_textbox"
    And I wait for "3" seconds
    And I click on search users button "iBuyCompanyList.searchUsers_button" without wait
    And I take screenshot
    And I click on search result "iBuyCompanyList.companyNameInTable_label" without wait
    Then I verfiy element "iBuyCompanyStructure.companyStructure_text" is present on page and display 'Company Structure page' in report
    And I take screenshot of the iBuyCompanyStructure page
    And I click on CompanyName below Company Structure heading "iBuyCompanyStructure.structureTopLevel_text" without wait
    And I wait for "2" seconds
    And I take screenshot of the iBuyEditCompanyTier page
    Then I verify element "iBuyEditCompany.editCompanyTier_text" is present on page and display 'Edit Company Tier Page' in report
    And I click on users link from table "iBuyEditCompany.users_link" without wait
    And I wait for "3" seconds
    And I take screenshot of the users page
    #---users page---#
    Then I verify element "iBuyAddUser.users_text" is present on page and display 'Users Page' in report
    And I select by index the companyname "0" from dropdown "iBuyAddUser.tierName_dropdown"
    Then I click on add new user button "iBuyAddUser.addNewUser_button" without wait
    And I wait for "3" seconds
    And I take screenshot of the add new user page
    Then I verify element "iBuyAddUser.addNewUser_text" is present on page and display 'Add New User Page' in report
    #--Add user with empty values to check digitaldata error message--#
    And I fill iBuy "<UserRole>" user details using given Jsonfile "iBuyUserDetailsNegativeValidation.json"
    And I click on add button "iBuyAddUser.add_button" without wait
    And I Execute digitaldata command for "ibuy-add cta"
    And I wait for "2" seconds
    Then verify below key values are exact match in "event" node
      | action        | iBuy: Add User: Submit Error |
      | elementDetail | CTA: ADD Button              |
      | type          | Click                        |
      | linkType      | Button                       |
      | pageSection   | Add New User                 |
      | errorMsgs[0]  | personTitle                  |
      | errorMsgs[1]  | firstName                    |
      | errorMsgs[2]  | lastName                     |
      | errorMsgs[3]  | email1                       |
      | errorMsgs[4]  | phone1                       |
      | errorMsgs[5]  | logonId                      |
      | errorMsgs[6]  | logonPassword                |
      | errorMsgs[7]  | primaryRole                  |
      | errorMsgs[8]  | primaryUse                   |
    And I fill iBuy "<UserRole>" user details using given Jsonfile "iBuyUserDetails.json"
    And I take screenshot of the page
    And I click on add button "iBuyAddUser.add_button" without wait
    And I save the created iBuy "<UserRole>" user details
    And I wait for "3" seconds
    And I scroll down the page by pixels "300"
    And I take screenshot of the page
    Then I verify element "iBuyAddUser.users_text" is present on page and display 'Users Created' in report
    #--Validating error messages in edit form user--#
    And I click on "iBuyAddUser.userSearch_link"
    And I wait for "10" seconds
    And I Clear the Edit form text fields
    And I wait for "10" seconds
    And I click on add button "iBuyAddUser.add_button" without wait
    And I Execute digitaldata command for "ibuy-edit cta"
    And I wait for "2" seconds
    Then verify below key values are exact match in "event" node
      | action        | iBuy: Edit User: Submit Error |
      | elementDetail | CTA: Save Button              |
      | type          | Click                         |
      | linkType      | Button                        |
      | pageSection   | Edit User                     |
      | errorMsgs[0]  | personTitle                   |
      | errorMsgs[1]  | firstName                     |
      | errorMsgs[2]  | lastName                      |
      | errorMsgs[3]  | email1                        |
      | errorMsgs[4]  | phone1                        |
      | errorMsgs[5]  | primaryRole                   |
      | errorMsgs[6]  | primaryUse                    |
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"

   

    @TSA
    Examples: 
      | UserRole          |
      | TierAdministrator |

@validationTests
Feature: PFSA iBuy user tests

  @AddAccountPfsaOrg @Priority1 @PFSAAccount @eu @apac @nwk @live
  Scenario: Add account to newly created PFSA iBuy Organisation
		    Given web site is launched successfully and user "does" accept the cookies
		    When customer accesses the website as "ibuy pfsa admin" user
		    And I wait for "3" seconds
		    And I hover on element My Account "Header.myAccount_dropdown"
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
		    And I verify element "iBuyCompanyList.companyListHeader_text" is present on page and display 'Company List Page' in report
		    Then I verify element "iBuyCompanyList.companyName_textbox" is present on page
		    And I verify element "iBuyCompanyList.accountNumber_textbox" is present on page
		    #---- Creating Ibuy Organisation ---------#
		    And I scroll till "iBuyCompanyList.addNewCompany_button"
		    And I click on "iBuyCompanyList.addNewCompany_button"
		    And I wait for "4" seconds
		    And I take screenshot of Add Company page
		    Then I verfiy element "iBuyAddCompany.addCompanyHeader_text" is present on page and display 'Add Company page' in report
		    And I enter new Company name on Add Company page
		    And I take screenshot of the page
		    And I click on Add button "iBuyAddCompany.add_button"
		    And I wait for "5" seconds
		    And I scroll till "iBuyCompanyList.companyNameInTable_label"
		    And I take screenshot of the page
		    Then I verify iBuy company name on element "iBuyCompanyList.companyNameInTable_label" on ibuy submenu
		    And I click on company name in Table "iBuyCompanyList.companyNameInTable_label"
		    And I wait for "4" seconds
		    Then I verfiy element "iBuyCompanyStructure.companyStructure_text" is present on page and display 'Company Structure page' in report
		    And I take screenshot of the page
		    And I verify element "iBuyCompanyStructure.structureTopLevel_text" is present on page
		    And I verify element "iBuyCompanyStructure.addCompanyTier_button" is present on page
		    And I scroll till "MyAccount.iBuyAdmin_text"
		    And I take screenshot of the page to view iBuy menu on LHS
		    Then I verify below are displayed in "MyAccount.iBuyMenu_list" table iBuy submenu
		      | Company Structure |
		      | Users             |
		      | Orders / Reports  |
		      | Edit Company      |
		      | Import Users      |
		      | Add Account       |
		    Then I verify iBuy company name on element "MyAccount.companyName_text" on ibuy submenu
		    #---- Add Account to created company----#
		    When I click on Add account on iBuy Submenu "MyAccount.addAccount_link"
		    And I wait for "5" seconds
		    Then I verfiy element "iBuyRetrieveAccount.retrieveAccount_text" is present on page and display 'Retrieve Account page' in report
		    And I take screenshot of the page to view Retrieve Account Page
		    Then I verify element "iBuyRetrieveAccount.accountNumber_textbox" is present on page
		    And I verify element "iBuyRetrieveAccount.companyId_dropdown" is present on page
		    When I enter Trade account Account number using given file "OrderInformation.xlsx"
		    And I click on search users button on Retrieve Account page "iBuyRetrieveAccount.searchUsers_button"
		    Then I wait for "4" seconds
		    And I take screenshot of the page to view Add Account Page
		    Then I verfiy element "iBuyAddAccount.addAccount_text" is present on page and display 'Add Account page' in report
		    And I verify element "iBuyAddAccount.billingAccount_text" is present on page
		    And I verify iBuy account number on element "iBuyAddAccount.billingAccount_text" on Add account page
		    Then I click on save button on Add account page "iBuyAddAccount.save_button"
		    Then I wait for "5" seconds
		    And I take screenshot of the page to view Edit Company Page
		    Then I verfiy element "iBuyEditCompany.editCompany_text" is present on page and display 'Edit Company page' in report
		    And I verify element "iBuyEditCompany.companyName_textbox" is present on page
		    And I verify element "iBuyEditCompany.accountNumber_link" is present on page
		    And I verify iBuy company name on element "iBuyEditCompany.companyName_textbox"
		    And I verify account number on element "iBuyEditCompany.accountNumber_link"
		    Then I click on save button "iBuyEditCompany.save_button"
		    Then I wait for "4" seconds
		    And I take screenshot of the page
		    And I hover on element My Account "Header.myAccount_dropdown"
		    Then User click on logout option "Header.logout_button"

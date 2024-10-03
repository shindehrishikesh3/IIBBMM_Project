@iBuyvalidation @PFSAAdmin
Feature: PFSA iBuy admin

  @createOrgforPFSA @Priority1 @PFSAAccount @eu @apac @nwk
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

  @ibuyAddUser @Priority1 @PFSAAccount @eu @apac @nwk
  Scenario Outline: To Create iBuy user-<UserRole>
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "ibuy pfsa admin" user
    And I wait for "3" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
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
    #---To fill all mandatory fields in add user page---#
    And I fill iBuy "<UserRole>" user details using given Jsonfile "iBuyUserDetails.json"
    And I take screenshot of the page
    And I click on add button "iBuyAddUser.add_button" without wait
    And I save the created iBuy "<UserRole>" user details
    And I wait for "3" seconds
    And I scroll down the page by pixels "300"
    And I take screenshot of the page
    Then I verify element "iBuyAddUser.users_text" is present on page and display 'Users Created' in report
    #---Verify the created user---#
     And I scroll up the page by pixels "200"
    Then I enter FirstName of user to be searched in UserSearch textbox
    And I wait for "3" seconds
    Then I click on user search button "iBuyAddUser.userSearch_button" without wait
    And I wait for "2" seconds
    And I scroll till "iBuyAddUser.userSearch_link"
    And I take screenshot of the page
    Then I click on user search result "iBuyAddUser.userSearch_link" without wait
    And I wait for "2" seconds
    And I take screenshot of the page
    And I verify if new ibuy user is created
    And I wait for "2" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"

    @SA
    Examples:
      | UserRole           |
      | SuperAdministrator |

    @TSA
    Examples:
      | UserRole          |
      | TierAdministrator |

    @User
    Examples:
      | UserRole |
      | User     |

  @customFields @PFSAAccount @eu @apac @nwk @live
  Scenario: Set Custom fields
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "ibuy pfsa admin" user
    And I wait for "3" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I scroll till "MyAccount.companyList_link"
    And I wait for "5" seconds
    #----- Ibuy Options validation -------#
    And I take screenshot of the page to view iBuy menu on LHS
    Then I verify element "MyAccount.iBuyAdmin_text" is present on page
    And I verfiy element "MyAccount.companyList_link" is present on page
    When I click on "MyAccount.companyList_link"
    And I wait for "3" seconds
    And I verify element "iBuyCompanyList.companyListHeader_text" is present on page and display 'Company List Page' in report
    And I take screenshot of Company List page
    Then I enter last registered company in textbox "iBuyCompanyList.companyName_textbox"
    And I click on search button "iBuyCompanyList.searchUsers_button"
    And I scroll till "iBuyCompanyList.companyNameInTable_label"
    And I take screenshot of the page
    Then I verify iBuy company name on element "iBuyCompanyList.companyNameInTable_label" on ibuy submenu
    And I click on company name in Table "iBuyCompanyList.companyNameInTable_label"
    Then I verfiy element "iBuyCompanyStructure.companyStructure_text" is present on page and display 'Company Structure page' in report
    And I take screenshot of the page
    And I verify element "iBuyCompanyStructure.structureTopLevel_text" is present on page
    And I click on element "iBuyCompanyStructure.structureTopLevel_text" using js
    And I wait for "5" seconds
    And I verify element "iBuyEditCompanyTier.editCompanyTier_text" is present on page
    #---- Set Custom fields----#
    And I click on element "iBuyEditCompanyTier.customFieldsInTable_link" using js
    And I wait for "2" seconds
    And I verify element "iBuyCustomFields.customFields_text" is present on page
    And I set Custom fields using given file "CustomFields.xlsx"
    And I click on element "iBuyCustomFields.save_button" using js
    And I wait for "5" seconds
    And I verify element "iBuyCustomFields.successfullyUpdated_text" is present on page and display 'Your changes successfully updated' in report
    And I click on element "iBuyCustomFields.returnToEditTier_button" using js
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"

  @setBudget @createOrgforPFSA @eu @apac @nwk
  Scenario: Set Budget limits to newly created PFSA iBuy Organisation
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "ibuy pfsa admin" user
    And I wait for "3" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I scroll till "MyAccount.companyList_link"
    And I wait for "5" seconds
    And I take screenshot of the page to view iBuy menu on LHS
    Then I verify element "MyAccount.iBuyAdmin_text" is present on page
    #---- search for recently added comapny -----#
    And I verfiy element "MyAccount.companyList_link" is present on page
    When I click on "MyAccount.companyList_link"
    And I wait for "3" seconds
    And I verify element "iBuyCompanyList.companyListHeader_text" is present on page and display 'Company List Page' in report
    And I take screenshot of Company List page
    Then I enter last registered company in textbox "iBuyCompanyList.companyName_textbox"
    And I click on search button "iBuyCompanyList.searchUsers_button"
    And I scroll till "iBuyCompanyList.companyNameInTable_label"
    And I take screenshot of the page
    Then I verify iBuy company name on element "iBuyCompanyList.companyNameInTable_label" on ibuy submenu
    And I click on company name in Table "iBuyCompanyList.companyNameInTable_label"
    Then I verfiy element "iBuyCompanyStructure.companyStructure_text" is present on page and display 'Company Structure page' in report
    And I take screenshot of the page
    And I verify element "iBuyCompanyStructure.structureTopLevel_text" is present on page
    And I click on element "iBuyCompanyStructure.structureTopLevel_text" using js
    And I wait for "5" seconds
    And I verify element "iBuyEditCompanyTier.editCompanyTier_text" is present on page
    And I click on element "iBuyEditCompanyTier.limitsAndBudget_link" using js
    Then I verfiy element "iBuyLimitsBudgetsAndDeliveryMethods.limitsBudgetsDeliveryMetods_text" is present on page and display 'Limits Budgets DeliveryMetods page' in report
    And I click on element "iBuyLimitsBudgetsAndDeliveryMethods.addAddBudget_button" using js
    # -------Adding budget on Add Budget page -------#
    And I verify element "iBuyLimitsBudgetsAndDeliveryMethods.addBudgets_text" is present on page
    And I enter budget value "Budget1" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.addBudgetName_textbox"
    And I enter budget value "150" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.addBudgetValue_textbox"
    And I select by visible text budget period "Week" from dropdown "iBuyLimitsBudgetsAndDeliveryMethods.addBudgetsPeriod_dropdown"
    And I take screenshot of the page
    Then I click on "iBuyLimitsBudgetsAndDeliveryMethods.addBudgetsSave_button"
    And I verify text after saving budget "Your changes have been saved." in page "iBuyLimitsBudgetsAndDeliveryMethods.budgetSavedConformation_text"
    #----Adding per order limit value in Spend control setting section on Limit and budgets page-----#
    And I enter per order limit value "150" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.perOrderLimitValue_textbox"
    And I scroll till "iBuyLimitsBudgetsAndDeliveryMethods.save_button"
    Then I click on element "iBuyLimitsBudgetsAndDeliveryMethods.save_button" using js
    And I wait for "3" seconds
    And I verify text after saving budget "Your changes have been saved." in page "iBuyLimitsBudgetsAndDeliveryMethods.budgetSavedConformation_text"
    And I take screenshot of the page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"

  @amendTSAUser @PFSAAccount @eu @apac @nwk
  Scenario: Amend TSA User to add SA user as approver
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
    Then I verify element "iBuyCompanyList.companyListHeader_text" is present on page and display 'Company List Page' in report
    Then I enter last registered company in textbox "iBuyCompanyList.companyName_textbox"
    And I click on search button "iBuyCompanyList.searchUsers_button"
    And I scroll till "iBuyCompanyList.companyNameInTable_label"
    And I click on company name in Table "iBuyCompanyList.companyNameInTable_label"
    And I click on "iBuyCompanyStructure.structureTopLevel_text"
    And I click on "iBuyEditCompanyTier.user_link"
    And I click on "iBuyEditCompanyTier.taUser_link"
    And I take screenshot of the page
    And I wait for "2" seconds
    And I scroll till "iBuyEditCompanyTier.limitBudgetAndDeliveryMethod_link"
    And I click on "iBuyEditCompanyTier.limitBudgetAndDeliveryMethod_link"
    And I scroll till "iBuyLimitsBudgetsAndDeliveryMethods.allocateMoreApprover_button"
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.allocateMoreApprover_button"
    And I wait for "3" seconds
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.saUser_checkbox"
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.allocateApprovers_button"
    And I take screenshot of the page
    And I wait for "3" seconds
    Then I verify element "iBuyLimitsBudgetsAndDeliveryMethods.saApprover_text" is present on page
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.emailAllSecondaryapprovers_checkbox"
    And I enter value "0" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.approvaltime_textbox"
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.emailAllBudgetOwners_checkbox"
    And I enter value "75" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.spendThreshold_textbox"
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.orderApprover_checkbox"
    And I wait for "2" seconds
    Then I click on the save button "iBuyLimitsBudgetsAndDeliveryMethods.save_button"
    And I wait for "2" seconds
    Then I verify element "iBuyLimitsBudgetsAndDeliveryMethods.changesHavebeenSaved_text" is present on page
    And I take screenshot of the page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"



  @amendSAUser @PFSAAccount @eu @apac @nwk
  Scenario: Amend SA user to add the TSA User as approver
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "ibuy pfsa admin" user
    And I wait for "3" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I scroll till "MyAccount.companyList_link"
    And I wait for "5" seconds
    #----- Ibuy Options validation -------#
    And I take screenshot of the page to view iBuy menu on LHS
    Then I verify element "MyAccount.iBuyAdmin_text" is present on page
    And I verfiy element "MyAccount.companyList_link" is present on page
    When I click on "MyAccount.companyList_link"
    And I wait for "3" seconds
    And I verify element "iBuyCompanyList.companyListHeader_text" is present on page and display 'Company List Page' in report
    And I take screenshot of Company List page
    Then I enter last registered company in textbox "iBuyCompanyList.companyName_textbox"
    And I click on search button "iBuyCompanyList.searchUsers_button"
    And I scroll till "iBuyCompanyList.companyNameInTable_label"
    And I take screenshot of the page
    And I click on company name in Table "iBuyCompanyList.companyNameInTable_label"
    Then I verfiy element "iBuyCompanyStructure.companyStructure_text" is present on page and display 'Company Structure page' in report
    And I click on element "iBuyCompanyStructure.structureTopLevel_text" using js
    And I wait for "5" seconds
    And I verify element "iBuyEditCompanyTier.editCompanyTier_text" is present on page
    #----Select TSA User as approver ----#
    And I click on element "iBuyEditCompanyTier.user_link" using js
    And I wait for "2" seconds
    And I verify element "iBuyAddUser.users_text" is present on page
    And I click on element "iBuyEditCompanyTier.saUser_link" using js
    And I wait for "2" seconds
    And I take screenshot of the page
    And I wait for "2" seconds
    And I scroll till "iBuyEditCompanyTier.limitBudgetAndDeliveryMethod_link"
    And I click on "iBuyEditCompanyTier.limitBudgetAndDeliveryMethod_link"
    And I scroll till "iBuyLimitsBudgetsAndDeliveryMethods.allocateMoreApprover_button"
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.allocateMoreApprover_button"
    And I wait for "3" seconds
    And I click on element "iBuyLimitsBudgetsAndDeliveryMethods.taUser_checkbox"
    And I click on element "iBuyLimitsBudgetsAndDeliveryMethods.allocateApprovers_button"
    Then I verify text "Your changes have been saved." in page "iBuyLimitsBudgetsAndDeliveryMethods.changesHavebeenSaved_text"
    And I verify element "iBuyLimitsBudgetsAndDeliveryMethods.taApprover_text" is present on page and display its value in report
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.emailAllSecondaryapprovers_checkbox"
    And I enter value "0" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.approvaltime_textbox"
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.emailAllBudgetOwners_checkbox"
    And I enter value "75" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.spendThreshold_textbox"
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.orderApprover_checkbox"
    And I wait for "2" seconds
    Then I click on the save button "iBuyLimitsBudgetsAndDeliveryMethods.save_button"
    And I wait for "2" seconds
    Then I verify text "Your changes have been saved." in page "iBuyLimitsBudgetsAndDeliveryMethods.changesHavebeenSaved_text"
    And I take screenshot of the page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on "Header.logout_button"

  @enableAccount @eu @apac @nwk
  Scenario: Enable Account for iBuy User
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "ibuy pfsa admin" user
    And I wait for "3" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I scroll till "MyAccount.companyList_link"
    And I wait for "3" seconds
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
    And I scroll till "iBuyCompanyList.companyNameInTable_label"
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
    And I click on users name link from table "iBuyAddUser.userSearch_link" without wait
    And I scroll till "iBuyAddUser.accounts&Payment_link"
    And I take screenshot of the users page
    And I click on delivery address link from table "iBuyAddUser.accounts&Payment_link" without wait
    Then I verfiy element "iBuyPaymentMethods.paymentMethod_text" is present on page and display 'Payment Methods' in report
    And I wait for "2" seconds
    And I verify element "iBuyPaymentMethods.existingAccount_link" is present on page
    And I verify element "iBuyPaymentMethods.enableAccount_checkbox" is selected on page
    And I take screenshot of the payment method page
    And I scroll till "iBuyPaymentMethods.returnToPrevPage_button"
    And I click on element "iBuyPaymentMethods.returnToPrevPage_button"
    #And I click on return to previous page button "iBuyPaymentMethods.returnToPrevPage_button" without wait
    And I wait for "2" seconds
    Then I verify element "iBuyAddUser.editUser_label" is present on page
    And I wait for "2" seconds
    And I take screenshot of edit user page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"

    @addDeliveryAddress @eu @apac @nwk
  Scenario: Add Delivery Address for iBuy User
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "ibuy pfsa admin" user
    And I wait for "3" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I scroll till "MyAccount.companyList_link"
    And I wait for "3" seconds
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
    And I click on users name link from table "iBuyAddUser.userSearch_link" without wait
    And I scroll till "iBuyAddUser.deliveryAddress_link"
    And I take screenshot of the users page
    And I click on delivery address link from table "iBuyAddUser.deliveryAddress_link" without wait
    Then I verfiy element "iBuyAddDeliveryAddress.deliveryAddress_text" is present on page and display 'Delivery Address' in report
    And I take screenshot of the users page
    And I click on add new address button "iBuyAddDeliveryAddress.addNewAddress_button" without wait
    And I fill Address Information Details on Address Page using given file "Address.xlsx"
    And I take screenshot of the users page
    And I click on save button "iBuyAddDeliveryAddress.saveAddress_button" without wait
    And I wait for "2" seconds
    And I verify element "iBuyAddDeliveryAddress.newlyAddedAddress_link" is present on page
    And I verify element "iBuyAddDeliveryAddress.deliveryAddressEnable_checkbox" is selected on page
    And I take screenshot of the users page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"

    @amendUser @eu @apac @nwk
	Scenario: Amend User to add the SA and TSA as Approvers
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "ibuy pfsa admin" user
    And I wait for "3" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I scroll till "MyAccount.companyList_link"
    And I wait for "5" seconds
    And I take screenshot of the page to view iBuy menu on LHS
    Then I verify element "MyAccount.iBuyAdmin_text" is present on page
    #---- search for recently added comapny -----#
    And I verfiy element "MyAccount.companyList_link" is present on page
    When I click on "MyAccount.companyList_link"
    And I wait for "3" seconds
    And I verify element "iBuyCompanyList.companyListHeader_text" is present on page and display 'Company List Page' in report
    And I take screenshot of Company List page
    Then I enter last registered company in textbox "iBuyCompanyList.companyName_textbox"
    And I click on search button "iBuyCompanyList.searchUsers_button"
    And I scroll till "iBuyCompanyList.companyNameInTable_label"
    And I take screenshot of the page
    Then I verify iBuy company name on element "iBuyCompanyList.companyNameInTable_label" on ibuy submenu
    And I click on company name in Table "iBuyCompanyList.companyNameInTable_label"
    Then I verfiy element "iBuyCompanyStructure.companyStructure_text" is present on page and display 'Company Structure page' in report
    And I take screenshot of the page
    And I verify element "iBuyCompanyStructure.structureTopLevel_text" is present on page
    And I click on element "iBuyCompanyStructure.structureTopLevel_text" using js
    And I wait for "5" seconds
    And I verify element "iBuyEditCompanyTier.editCompanyTier_text" is present on page
		And I click on users link from table "iBuyEditCompany.users_link" without wait
		And I wait for "3" seconds
		And I take screenshot of the users page
		#----Select  User as approver ----#
		And I click on element "iBuyEditCompanyTier.iBuyUserRole_link" using js
    And I wait for "2" seconds
    And I wait for "2" seconds
    And I take screenshot of the page
    And I wait for "2" seconds
    And I scroll till "iBuyEditCompanyTier.limitBudgetAndDeliveryMethod_link"
    And I click on "iBuyEditCompanyTier.limitBudgetAndDeliveryMethod_link"
    And I scroll till "iBuyLimitsBudgetsAndDeliveryMethods.allocateMoreApprover_button"
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.allocateMoreApprover_button"
    And I wait for "3" seconds
    And I click on element "iBuyLimitsBudgetsAndDeliveryMethods.saUser_checkbox"
    And I click on element "iBuyLimitsBudgetsAndDeliveryMethods.taUser_checkbox"
    And I click on element "iBuyLimitsBudgetsAndDeliveryMethods.allocateApprovers_button"
    Then I verify text "Your changes have been saved." in page "iBuyLimitsBudgetsAndDeliveryMethods.changesHavebeenSaved_text"
		And I take screenshot of the users page
    And I verify element "iBuyLimitsBudgetsAndDeliveryMethods.ta_approver" is present on page and display its value in report
    And I verify element "iBuyLimitsBudgetsAndDeliveryMethods.sa_approver" is present on page and display its value in report
    # -------Removing exisiting budget on Add Budget page -------#
    And I verify existing budget element "iBuyLimitsBudgetsAndDeliveryMethods.budgets_checkbox" is present on page
    And I click on "iBuyLimitsBudgetsAndDeliveryMethods.budgets_checkbox"
    And I click on element "iBuyLimitsBudgetsAndDeliveryMethods.deleteBudget_button"
    And I click on element "iBuyLimitsBudgetsAndDeliveryMethods.confirmRemoveBudget_button"
    And I wait for "4" seconds
    # -------Adding budget on Add Budget page -------#
    And I click on element "iBuyLimitsBudgetsAndDeliveryMethods.addAddBudget_button" using js
    And I verify element "iBuyLimitsBudgetsAndDeliveryMethods.addBudgets_text" is present on page
    And I enter budget name value "Books" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.addBudgetName_textbox"
    And I enter budget value "100" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.addBudgetValue_textbox"
    And I select by visible text budget period "Year" from dropdown "iBuyLimitsBudgetsAndDeliveryMethods.addBudgetsPeriod_dropdown"
    And I take screenshot of the page
    Then I click on "iBuyLimitsBudgetsAndDeliveryMethods.addBudgetsSave_button"
    And I verify text after saving budget "Your changes have been saved." in page "iBuyLimitsBudgetsAndDeliveryMethods.changesHavebeenSaved_text"
    #----Adding per order limit value in Spend control setting section on Limit and budgets page-----#
    And I clears text from textbox "iBuyLimitsBudgetsAndDeliveryMethods.perOrderLimitValue_textbox"
    And I enter per order limit value "100" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.perOrderLimitValue_textbox"
    And I scroll till "iBuyLimitsBudgetsAndDeliveryMethods.save_button"
    Then I click on element "iBuyLimitsBudgetsAndDeliveryMethods.save_button" using js
    And I wait for "3" seconds
    And I verify text after saving budget "Your changes have been saved." in page "iBuyLimitsBudgetsAndDeliveryMethods.changesHavebeenSaved_text"
    And I take screenshot of the page
    #-------- Actions on Approvers section ------------------#
    Then I click on element "iBuyLimitsBudgetsAndDeliveryMethods.allowUsers_checkbox" using js
    And I click on order checkbox for SA User "iBuyLimitsBudgetsAndDeliveryMethods.orderApprover_checkbox"
    And I click on budgets checkbox for SA User "iBuyLimitsBudgetsAndDeliveryMethods.budgetApprover1_checkbox"
    And I click on order checkbox for TA User "iBuyLimitsBudgetsAndDeliveryMethods.orderApprover2_checkbox"
    And I click on budgets checkbox for TA User "iBuyLimitsBudgetsAndDeliveryMethods.budgetApprover2_checkbox"
    And I click on email secondary approvers checkbox  "iBuyLimitsBudgetsAndDeliveryMethods.emailAllSecondaryapprovers_checkbox"
 		And I enter value "0" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.approvaltime_textbox"
 		And I click on "iBuyLimitsBudgetsAndDeliveryMethods.emailAllBudgetOwners_checkbox"
		And I enter value "75" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.spendThreshold_textbox"
    And I click on save button "iBuyLimitsBudgetsAndDeliveryMethods.save_button"
    Then I verify text "Your changes have been saved." in page "iBuyLimitsBudgetsAndDeliveryMethods.changesHavebeenSaved_text"
    And I take screenshot of the page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on "Header.logout_button"

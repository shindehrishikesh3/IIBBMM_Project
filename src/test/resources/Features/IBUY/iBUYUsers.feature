@iBuyvalidation
Feature: Checkout iBuy user tests

  @iBuyUserCheckout @Priority1 @PFSAAccount @eu @apac @nwk @live
  Scenario: Checkout with newly created iBuy user with custom field validation
    Given web site is launched successfully and user "does" accept the cookies
    #------------Login as iBuy user---------------------#
    When last registered "iBuy user" user login to website successfully
    And I wait for "3" seconds
    Then I reset password for newly registerd iBuy user
    And I clear items from shopping cart if any present
    #------- Add product to cart -----------------------#
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "3" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    #------Shopping cart validation ---------------------#
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page
    And I verify element "ShoppingCart.lineNoteCustomfield_text" is present on page
    And I wait for "2" seconds
    And I select by visible text "PCABC" from dropdown "ShoppingCart.lineNoteCustomfield_dropdown"
    And I verify element "ShoppingCart.customFieldOne_text" is present on page
    And I wait for "2" seconds
    And I select by visible text "PCABC" from dropdown "ShoppingCart.customFieldOne_dropdown"
    And I wait for "2" seconds
    And User take screenshot of the page
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "4" seconds
    #-----Checkout validation ---------------------------#
    And I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
    And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
    And I verify sync account element "Checkout.syncAccount_radio" is selected on page
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
    Then I verify edit button element "Checkout.editPaymentMethod_button" is present on page
    And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
    And I wait for "2" seconds
    And User take screenshot of the page
    And I click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
    And I wait for "8" seconds
    Then I verify edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
    And I verify element "Checkout.deliveryOptions_text" is present on page and display its value in report
    And I wait for "2" seconds
    And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    Then User verify edit button element "Checkout.editDeliveryOptions_button" is present on page
    And I verify element "Checkout.paymentDetails_text" is present on page and display its value in report
    And I wait for "3" seconds
    And I select trade account radio button and click continue button in section 4 payment method
    And I wait for "3" seconds
    And I fill Additional Information Details for iBuy Account user
    And I take screenshot of the page
    And I click on Continue button on additional information section "Checkout.additionalInformationContinue_button" using js
    And I enter PO number value "order0" in textbox "Checkout.poNumber_textbox"
    And User checks terms and conditions checkbox and click on Submit Order button
    And I wait for "3" seconds
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    And I take screenshot of the page
    And I wait for "7" seconds
    #----Verify Custom fields----#
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click Order and Reports from the dropdown "Header.orders&reports_link"
    And I wait for "10" seconds
    And I refresh page till order history table is displayed.
    And I take screenshot to view My Order Details page
    Then user verifies Order Details element "OrderHistory.orderHistory_table" is present on page
    And I select by option "buyerPONumber" from dropdown "OrderHistory.searchBy_dropdown"
    And I enter PO number value "order0" in textbox "OrderHistory.searchValue_textbox"
    And I click on "OrderHistory.orderSearch_button"
    And I wait for "7" seconds
    And I click on link of PO Number search result "OrderHistory.firstPONumber_element" using js
    And I wait for "7" seconds
    And I wait "medium" duration for "OrderHistory.MyOrderDetails_text" element to "appear"
    And I take screenshot of the page
    Then I verify element "OrderTracking.MyOrderDetails_text" is present on page and display 'My Order Details' in report
    And I wait for "2" seconds
    And I verify iBuy "Department" and "Cost Code" fields  displayed in order Info
    And I scroll down the page by pixels "600"
    And I take screenshot of the page
    And I verify iBuy "Line Note" and "Project Code" fields  displayed in order shipping details
    And I scroll up the page by pixels "600"
    And I wait for "2" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on "Header.logout_button"

  @overOrderBudgetLimits @PFSAAccount @eu @apac @nwk @orders
  Scenario: Order 1 - over Order and Budget Limits  - Pay on Account (this order to be approved)
    Given web site is launched successfully and user "does" accept the cookies
    #--------- iBuy User navigate PDP and add product to basket------------------------------
    When last registered "Updated Pswd iBuy user" user login to website successfully
    And I wait for "3" seconds
    And I clear items from shopping cart if any present
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "3" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    #----------Shopping cart validation ---------------------------------------------
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And User clears text from textbox "ShoppingCart.quantityFirstProduct_textbox"
    Then I enter Quantity value "10000" in textbox "ShoppingCart.quantityFirstProduct_textbox"
    And I click "ShoppingCart.updateBasket_button"
    And I wait for "5" seconds
    And I verify price is greater than the set limit i.e "100"
    And I click "ShoppingCart.updateBasket_button"
    And I wait for "5" seconds
    And I select by visible text "PCABC" from dropdown "ShoppingCart.lineNoteCustomfield_dropdown"
    And I verify element "ShoppingCart.customFieldOne_text" is present on page
    And I select by visible text "PCABC" from dropdown "ShoppingCart.customFieldOne_dropdown"
    Then User click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
    And I wait for "4" seconds
    And I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
    And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
    Then I verify edit button element "Checkout.editPaymentMethod_button" is present on page
    And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
    And I wait for "2" seconds
    And User take screenshot of the page
    And I click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
    And I wait for "8" seconds
    Then I verify edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
    And I verify element "Checkout.deliveryOptions_text" is present on page and display its value in report
    And I wait for "2" seconds
    And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    Then User verify edit button element "Checkout.editDeliveryOptions_button" is present on page
    And I wait for "4" seconds
    And I click on Continue button on payment details Section "Checkout.paymentDetailsSectionContinue_button"
    And I wait for "3" seconds
    #------------ Assign approver -------------------------------------------------------
    And I fill Additional Information Details for iBuy Account user
    And I verify text "Your order requires approval for the following reason(s)" in page "Checkout.requireApprovalMsg_text"
    And I verify text "This order has caused the budget limit to be exceeded." in page "Checkout.budgetExceedMsg_text"
    Then I select by index SA approver "1" from dropdown "Checkout.selectApprover_dropdown"
    And I click on Continue button on additional information section "Checkout.additionalInformationContinue_button" using js
    And I wait for "3" seconds
    And I enter PO number value "order1" in textbox "Checkout.poNumber_textbox"
    And User checks terms and conditions checkbox and click on Submit Order button
    And I wait for "3" seconds
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    And I verify element "Checkout.orderSentToApproval_text" is present on page and display its value in report
    And I take screenshot of the page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"
    And I wait for "5" seconds
   

  @overOrderBudgetLimits2 @PFSAAccount @eu @apac @nwk @orders
  Scenario: Order 2 - over Order and Budget Limits  - Pay on Account (this order to be rejected)
    Given web site is launched successfully and user "does" accept the cookies
    #--------- iBuy User navigate PDP and add product to basket------------------------------
    When last registered "Updated Pswd iBuy user" user login to website successfully
    And I wait for "3" seconds
    And I clear items from shopping cart if any present
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "3" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    #----------Shopping cart validation ---------------------------------------------
    Then I scroll up the page by pixels "500"
    And I wait for "1" seconds
    And I click on "Header.miniBasket_link"
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And User clears text from textbox "ShoppingCart.quantityFirstProduct_textbox"
    Then I enter Quantity value "10000" in textbox "ShoppingCart.quantityFirstProduct_textbox"
    And I click "ShoppingCart.updateBasket_button"
    And I wait for "5" seconds
    And I verify price is greater than the set limit i.e "100"
    And I click "ShoppingCart.updateBasket_button"
    And I wait for "5" seconds
    And I select by visible text "PCABC" from dropdown "ShoppingCart.lineNoteCustomfield_dropdown"
    And I verify element "ShoppingCart.customFieldOne_text" is present on page
    And I select by visible text "PCABC" from dropdown "ShoppingCart.customFieldOne_dropdown"
    Then User click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
    And I wait for "4" seconds
    And I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
    And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
    And I scroll till "Checkout.paymentDetailsSectionContinue_button"
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
    Then I verify edit button element "Checkout.editPaymentMethod_button" is present on page
    And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
    And I wait for "2" seconds
    And User take screenshot of the page
    And I click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
    And I wait for "8" seconds
    Then I verify edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
    And I verify element "Checkout.deliveryOptions_text" is present on page and display its value in report
    And I wait for "2" seconds
    And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    Then User verify edit button element "Checkout.editDeliveryOptions_button" is present on page
    And I wait for "4" seconds
    And I click on Continue button on payment details Section "Checkout.paymentDetailsSectionContinue_button"
    And I wait for "3" seconds
    #------------ Assign approver -------------------------------------------------------
    And I fill Additional Information Details for iBuy Account user
    And I verify text "Your order requires approval for the following reason(s)" in page "Checkout.requireApprovalMsg_text"
    And I verify text "This order has caused the budget limit to be exceeded." in page "Checkout.budgetExceedMsg_text"
    Then I select by index SA approver "1" from dropdown "Checkout.selectApprover_dropdown"
    And I click on Continue button on additional information section "Checkout.additionalInformationContinue_button" using js
    And I wait for "3" seconds
    And I enter PO number value "order2" in textbox "Checkout.poNumber_textbox"
    And User checks terms and conditions checkbox and click on Submit Order button
    And I wait for "3" seconds
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    And I verify element "Checkout.orderSentToApproval_text" is present on page and display its value in report
    And I take screenshot of the page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"
   
    

  @underOrderBudgetLimits @PFSAAccount @PFSAUser @orders @eu @apac @nwk
  Scenario: Order 3 - To Place an order under Order and Budget Limits,Pay on Account and check no approval needed
    #--Login as PFSA Admin--#
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
    #--Navigating to Users link--#
    And I click on users link from table "iBuyEditCompany.users_link" without wait
    And I wait for "3" seconds
    And I take screenshot of the users page
    #---search for users and navigate to edit users page---#
    Then I verify element "iBuyAddUser.users_text" is present on page and display 'Users Page' in report
    Then I enter iBuyUser "iBuy user" to be searched
    And I wait for "5" seconds
    And I scroll till "iBuyAddUser.userSearch_link"
    And I take screenshot of the page
    Then I click on user search result "iBuyAddUser.userSearch_link" without wait
    And I wait for "2" seconds
    And I take screenshot of the page
    Then I verify element "iBuyAddUser.editUser_label" is present on page and display 'Edit Users Page' in report
    #----Adding per order limit value in Spend control setting section on Limit and budgets page-----#
    And I click on Limits, Budgets, & Delivery Methods link "iBuyAddUser.limitsBudgets_link" without wait
    And I clears text from textbox "iBuyLimitsBudgetsAndDeliveryMethods.perOrderLimitValue_textbox"
    And I enter per order limit value "100" in textbox "iBuyLimitsBudgetsAndDeliveryMethods.perOrderLimitValue_textbox"
    And I scroll till "iBuyLimitsBudgetsAndDeliveryMethods.save_button"
    Then I click on element "iBuyLimitsBudgetsAndDeliveryMethods.save_button" using js
    And I wait for "3" seconds
    And I verify text after saving budget "Your changes have been saved." in page "iBuyLimitsBudgetsAndDeliveryMethods.budgetSavedConformation_text"
    And I take screenshot of the page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"
    #--Login as ibuy User, reset password and clear cart--#
    When last registered "Updated Pswd iBuy user" user login to website successfully
    And I wait for "3" seconds
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And I take screenshot of the page
    And I clear items from shopping cart if any present
    #--Searching for a pdt and adding to cart--#
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "3" seconds
    And I click on search "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I take screenshot of the page
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    #--Place an order under Budget and proceed without approval--#
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And I take screenshot of the page
    And User clears text from textbox "ShoppingCart.quantityFirstProduct_textbox"
    Then I enter Quantity value "250" in textbox "ShoppingCart.quantityFirstProduct_textbox"
    And I scroll till "ShoppingCart.updateBasket_button"
    And I click "ShoppingCart.updateBasket_button"
    And I wait for "5" seconds
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page
    And I verify element "ShoppingCart.lineNoteCustomfield_text" is present on page
    And I wait for "2" seconds
    And I select by visible text "PCABC" from dropdown "ShoppingCart.lineNoteCustomfield_dropdown"
    And I verify element "ShoppingCart.customFieldOne_text" is present on page
    And I wait for "2" seconds
    And I select by visible text "PCABC" from dropdown "ShoppingCart.customFieldOne_dropdown"
    And I wait for "2" seconds
    And User take screenshot of the page
    And I scroll till "ShoppingCart.shoppingBasket_text"
    And I take screenshot of the page
    And I verify price is less than the set limit i.e "100"
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "4" seconds
    #--Order Information Details--#
    And I take screenshot of the page
    And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
    And I take screenshot of the page
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
    Then I verify edit button element "Checkout.editPaymentMethod_button" is present on page
    And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
    And I wait for "2" seconds
    And User take screenshot of the page
    And I click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
    And I wait for "8" seconds
    Then I verify edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
    And I verify element "Checkout.deliveryOptions_text" is present on page and display its value in report
    And I wait for "2" seconds
    And I take screenshot of the page
    And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    Then User verify edit button element "Checkout.editDeliveryOptions_button" is present on page
    And I wait for "4" seconds
    And I take screenshot of the page
    And I click on Continue button on payment details Section "Checkout.paymentDetailsSectionContinue_button"
    And I wait for "3" seconds
    And I fill Additional Information Details for iBuy Account user
    And User take screenshot of the page
    And I click on Continue button on additional information section "Checkout.additionalInformationContinue_button" using js
    And I wait for "3" seconds
    And I enter PO number value "order3" in textbox "Checkout.poNumber_textbox"
    And User checks terms and conditions checkbox and click on Submit Order button
    And I wait for "3" seconds
    And I take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    And I take screenshot of the page
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"

    @overOrderBudgetLimits @orders @PFSAAccount @eu @apac @nwk
    Scenario: Order 1 - over budget Limits and order to be approved
    Given web site is launched successfully and user "does" accept the cookies
    #--------SA User logged in and approve the order -----------------------------------------
    When last registered "iBuy SA user" user login to website successfully
    And I wait for "3" seconds
    Then I reset password for newly registerd iBuy user
    And I verify element "MyAccount.approvePopUp_element" is present on page
    And I click view now button on pop up "MyAccount.viewNow_button"
    And I wait for "3" seconds
    And I refresh page till order history table is displayed.
    And I take screenshot to view My Order Details page
    And I select by option "buyerPONumber" from dropdown "OrderHistory.searchBy_dropdown"
    And I enter PO number value "order1" in textbox "OrderHistory.searchValue_textbox"
    And I click on "OrderHistory.orderSearch_button"
    And I wait for "7" seconds
    And I click on link of recent order placed PO Number "OrderHistory.firstPONumber_element" using js
    And I wait for "7" seconds
    And I wait "medium" duration for "OrderHistory.MyOrderDetails_text" element to "appear"
    And I click on approve button "MyOrderDetails.approver_button"
    And I wait for "2" seconds
    And I take screenshot to view My Order Details page
    And I verify element "MyOrderDetails.orderApproved_text" is present on page and display its value in report
    And I verify element "MyOrderDetails.approvedBy_text" is present on page and display its value in report
    And I verify element "MyOrderDetails.approveDate_text" is present on page and display its value in report
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"
    
    @overOrderBudgetLimits2 @orders @PFSAAccount @eu @apac @nwk
    Scenario: Order 2 - over budget Limits and order to be rejected
    Given web site is launched successfully and user "does" accept the cookies
    #--------SA User logged in and approve the order -----------------------------------------
    When last registered "Updated Pswd iBuy SA user" user login to website successfully
    And I wait for "3" seconds
    And I verify element "MyAccount.approvePopUp_element" is present on page
    And I click view now button on pop up "MyAccount.viewNow_button"
    And I wait for "3" seconds
    And I refresh page till order history table is displayed.
    And I take screenshot to view My Order Details page
    And I select by option "buyerPONumber" from dropdown "OrderHistory.searchBy_dropdown"
    And I enter PO number value "order2" in textbox "OrderHistory.searchValue_textbox"
    And I click on "OrderHistory.orderSearch_button"
    And I wait for "7" seconds
    And I click on link of recent order placed PO Number "OrderHistory.firstPONumber_element" using js
    And I wait for "7" seconds
    And I wait "medium" duration for "OrderHistory.MyOrderDetails_text" element to "appear"
    And I enter value "This order to be rejected" in textbox "MyOrderDetails.rejectReason"
    And I click on reject button "MyOrderDetails.rejectButton"
    And I wait for "2" seconds
    And I take screenshot to view My Order Details page
    And I verify element "MyOrderDetails.orderRejected_text" is present on page and display its value in report
    And I verify element "MyOrderDetails.rejectedByUser_text" is present on page and display its value in report
    And I verify element "MyOrderDetails.rejectDate_text" is present on page and display its value in report
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    Then User click on logout option "Header.logout_button"
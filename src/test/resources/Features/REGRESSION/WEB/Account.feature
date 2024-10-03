@validationTests @Account
Feature: Account validations tests

  @ApplyForTradeAccountTest @eu @Priority3 @live
  Scenario: Form filling: Apply for trade account option from my account drop down
		    Given web site is launched successfully and user "does" accept the cookies
		    When customer accesses the website as "register" user
		    And I hover on element My Account "Header.myAccount_dropdown"
		    And I click on Apply for Trade Account link "MyAccount.applyForTradeAccount_link"
		    And I wait for "5" seconds
		    And I take screenshot of the page
		    And I verify text of Trade Account as payment method "Apply for a Trade Account Today" in page "TradeAccount.headerTitle_element"
		    And I scroll till "TradeAccount.jobRole_dropdown"
		    And I fill Customer details in Apply for Trade Account page
		    And I fill Invoice address in Trade Account page using given file "OrderInformation.xlsx"
		    And I fill Company Details for New Trade Account using given file "OrderInformation.xlsx"
		    And I take screenshot of the page
		    And I scroll till "TradeAccount.postcode_textbox"
		    And I wait for "3" seconds
		    And I click on "TradeAccount.submit_button" using js
		    And I wait for "20" seconds
		    And I verify text of Trade Account confirmation message "Your Trade Account application has been received." in page "TradeAccount.tradeAccountConfirmation_message"
		    And I take screenshot of the page
		    And I hover on element My Account dropdown "Header.myAccount_dropdown"
		    Then I click on logout option "Header.logout_button"
		    
  @ReturnProduct
  Scenario: Returning Product test from Account Summary page
		    Given web site is launched successfully and user "does" accept the cookies
		    When customer accesses the website as "register" user
		    And I hover on element My Account "Header.myAccount_dropdown"
		    And I click Account Summary from the dropdown "Header.accountSummary_link"
		    And I wait for "5" seconds
		    And I take screenshot of the page
		    And I click on "MyAccount.returns_link"
		    Then I switch to window
		    And I wait for "5" seconds
		    And I scroll till "ReturnProduct.firstOrderCode_textbox"
		    And I fill return of product form using given file "Return_Products.xlsx"
		    And I take screenshot of return product form page
		    And I click on "ReturnProduct.submit_button"
		    And I verify text of Return Product confirmation message "Thank You" in page "ReturnProduct.messageThankYou_text" with attribute "innerHTML"
		    And I take screenshot of the page
		    And I switch to window
		    And I wait "5" seconds for new window
		    And I hover on element My Account "Header.myAccount_dropdown"
		    Then I click on logout option "Header.logout_button"

  @EmailAddFavouriteList @eu @apac @nwk @Priority3 @live
  Scenario: Email Favourite List from PDP page
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "register" user
		    When I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
		    And I wait for "4" seconds
		    And I click on Manufacturer Product Name in PLP page "PLP.manufacturerFirst_link"
		    And I wait for "5" seconds
		    #----- Creating favourites list -----#
		    And I scroll till "PDP.addToFavourites_link"
		    And I wait for "3" seconds
		    And I click on "PDP.addToFavourites_link"
		    And I wait for "5" seconds
		    And I switch to "PDP.addFavouriteFrame_frame" frame
		    And user verify text "Add to Favourites List" in page "Favourites.favouritesTitle_element"
		    And I take screenshot of the page
		    And I click on "Favourites.newFavouriteListInPopup_link"
		    And I wait for "5" seconds
		    And I switch to default frame
		    And I enter Favourite List Name value "First Favourite" in textbox "Favourites.favouriteListName_text"
		    And I take screenshot of the page
		    And I click on "Favourites.createNew_button"
		    And I wait for "3" seconds
		    And I scroll till "Favourites.orderCode_textbox"
		    And I enter ordercode to add in Favourites List in "Favourites.orderCode_textbox"
		    And I enter Quantity value "20" in textbox "Favourites.quantity_textbox"
		    And I click on "Favourites.add_button"
		    And I clears text from textbox "Favourites.quantityInDetailTable_textbox"
		    And I enter updated quantity value "30" in textbox "Favourites.quantityInDetailTable_textbox"
		    And I click on "Favourites.update_button"
		    And I wait for "5" seconds
		    #----- Email favourites list ------#
		    And I scroll till "Favourites.sendList_button"
		    And I click on "Favourites.sendList_button"
		    And I wait for "5" seconds
		    And I switch to "Favourites.sendFavouritesListFrame_frame" frame
		    And I take screenshot of the page
		    And I select by visible text of Favourite name "First Favourite" from dropdown "Favourites.selectFavourite_dropdown"
		    And I enter Email address value "favouritesuser@pfmail.com" in textbox "Favourites.emailTo_text"
		    And I enter Message value "Sending Favourites List to My Mail" in textbox "Favourites.message_text"
		    And I take screenshot of the page
		    And I click on "Favourites.submit_button"
		    And I wait for "5" seconds
		    And user verify text "Your email has been sent." in page "Favourites.emailSuccessMessage_element"
		    And I take screenshot of the page
		    And I switch to default frame
		    And I click on "Favourites.closeEmailShoppingCartFrame_link"
		    And I wait for "4" seconds
		    And I click on delete button in table "Favourites.deleteInTable_link"
		    And I wait for "5" seconds
		    And I take screenshot of the page
		    And I scroll till "Favourites.cancel_button"
		    And I click on cancel button in favourites page "Favourites.cancel_button"
		    And I wait for "5" seconds
		    And I click on favourites list delete button in favourites page "Favourites.deleteInDisplayTable_link"
		    And I wait for "3" seconds
		    And I take screenshot of the page
		    And I scroll till "Header.myAccount_dropdown"
		    And I hover on element My Account "Header.myAccount_dropdown"
		    Then User click on logout option "Header.logout_button"

  @EditProfileInformation  @eu @apac @nwk @Priority3 @live
  Scenario: Edit Profile Information
		    Given web site is launched successfully and user "does" accept the cookies
		    And customer accesses the website as "register" user
		    And I hover on element My Account "Header.myAccount_dropdown"
		    #----Edit profile information ----#
		    And I click on Profile Information link "Header.profileInfo_link"
		    And I wait for "2" seconds
		    And I edit Profile Information Deatails form using given file "OrderInformation.xlsx"
		    And I click Save button on Profile Information page "MyAccountProfileInformation.save_button"
		    And I wait for "2" seconds
		    Then I verify element "MyAccountProfileInformation.successMessage_text" is present on page and display in report
		    #------- Add Address  -------#
		    And I click Address link on Account page "MyAccount.addresses_link"
		    And I wait for "4" seconds
		    Then I verify element "MyAccountAddress.addAddress_text" is present on page and display in report		    
		    And I take screenshot to verify the Add Address page is displayed
		    And I fill Address Information Details on Address Page using given file "OrderInformation.xlsx"
		    And I click Save button on Address page "MyAccountAddress.saveAddress_button"
		    And I click You Entered if address validation pop-up is displayed
		    And I wait for "4" seconds
		    Then I verify element "MyAccountAddress.addressUpdateSave_text" is present on page and display in report
		    And I take screenshot to verify the address is saved.
		   	#------- Edit Address -------#
		    And I fill Address Information Details on Address Page using given file "Address.xlsx"
		    And I click on update button "MyAccountAddress.update_button"
		    And I click You Entered if address validation pop-up is displayed
		    And I wait for "4" seconds
		    Then I verify element "MyAccountAddress.addressUpdateSave_text" is present on page and display in report
		    #-----  Delete Address ------#
		    And I click on "MyAccountAddress.deleteAddress_button"
		    And I wait for "2" seconds
		    And I click on "MyAccountAddress.confirmDelete_button"
		    Then I verify element "MyAccountAddress.addressUpdateSave_text" is present on page and display in report
		    #------ Changing profile Password ------ #
		    And I click on "MyAccount.profileInformation_link"
		    And I verify element "MyAccountProfileInformation.changePassword_text" is present on page
		    And I enter current password in textbox "MyAccountProfileInformation.currentPassword_textbox"
		    And I enter new password in textbox "MyAccountProfileInformation.newPassword_textbox"
		    And I click on "MyAccountProfileInformation.change_button"
		    And I wait for "2" seconds
		    And I verify element "AccountSummary.edit_button" is present on page
		    And I hover on element My Account "Header.myAccount_dropdown"
		    And I click on "Header.logout_button"

  @CSVExportForOrderSummary @eu @apac @nwk @Priority3
  Scenario: CSV export for order summary and details
		    Given web site is launched successfully and user "does" accept the cookies
		    # Below commented step is used to run the script with user having order history,for that comment the lines from registraion of user upto verifying Thank you msg after placing an order
		    #When last registered "regular" user login to website successfully
		    When customer accesses the website as "register" user
		    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
		    And I wait for "3" seconds
		    And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		    #----- User Add products to cart and place an order steps-----#
		    And I enter ordercode in textbox "ShoppingCart.firstOrderCode_textbox"
		    And I verify text "1" in page "ShoppingCart.quantity_textbox" with attribute "value"
		    And I click "ShoppingCart.updateBasket_button"
		    And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		    And I verify element "ShoppingCart.firstProductOnCart_text" is present on page and display its value in report
		    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
		    And I wait "medium" duration for "Checkout.paymentMethod_text" element to "appear"
		    And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
		    And I would like to open a new Trade Account
		    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		    Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		    And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		    And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
		    And I wait for "5" seconds
		    Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
		    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
		    And I wait for "3" seconds
		    And I scroll till "Checkout.deliverySectionContinue_button"
		    And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		    And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		    Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		    And I select trade account radio button and click continue button in section 4 payment method
		    Then I verify element "Checkout.editPaymentDetails_button" is present except in "ph" region/store
		    And I fill Additional Information Details for New Trade Account using given file "OrderInformation.xlsx"
		    And I wait for "3" seconds
		    And User take screenshot of the page
		    And I enter PO number value "NewTradeAcc" in textbox "Checkout.poNumber_textbox"
		    And I wait for "2" seconds
		    And User checks terms and conditions checkbox and click on Submit Order button
		    And I wait for "4" seconds
		    And user take screenshot of the page
		    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		    And user take screenshot of the page		    
		    #------User verify Order history and export it to CSV ----#
		    And I hover on element My Account "Header.myAccount_dropdown"
		    And I wait for "2" seconds
		    And I click Account Summary from the dropdown "Header.orderHistory_list"
		    And I wait for "5" seconds
		    And I take screenshot to verify the Order History and tracking page is displayed with order history table
		    And I verify order history table is displayed
		    Then I click Export orders as XLS button from Order Histroy and Tracking page "OrderHistory.exportOrdersAsXLS_button"
		    And I wait for "5" seconds
		    And I take screenshot to verify order detials report link and line details report link from exportOrderAsXLS button dropdown is present
		    And I verify element "OrderHistory.orderDetailsReport_link" is present on page and display 'Order Details report link' in report
		    And I verify element "OrderHistory.lineDetailsReport_link" is present on page and display 'line Details report link' in report
		    And I scroll till "OrderHistory.Cancel_button"
		    And I wait for "3" seconds
		    Then I click order details report link "OrderHistory.orderDetailsReport_link"
		    And I wait for "5" seconds
		    And I verify popup element "OrderHistory.downloadReport_popUp" is present on page and display 'popUP' in report
		    And I wait for "3" seconds
		    And I take screenshot to verify order report file download progress bar is visible
		    And I wait "medium" duration for "OrderHistory.downloadReport_popUp" element to "disappear"
		    And I wait for "2" seconds
		    Then I click Export orders as XLS button from Order Histroy and Tracking page "OrderHistory.exportOrdersAsXLS_button"
		    And I wait for "3" seconds
		    Then I click line details report link "OrderHistory.lineDetailsReport_link"
		    And I wait for "3" seconds
		    And I verify popup element "OrderHistory.downloadReport_popUp" is present on page and display 'popUP' in report
		    And I wait for "3" seconds
		    And I take screenshot to verify line report file download progress bar is visible
		    And I wait "medium" duration for "OrderHistory.downloadReport_popUp" element to "disappear"
		    And I hover on element My Account "Header.myAccount_dropdown"
		    Then I click on logout option "Header.logout_button"

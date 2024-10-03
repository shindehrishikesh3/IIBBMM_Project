#Author: Pooja Katkar
@25893web
Feature: Verify Paypal on Newark sites - Web

  @setPaypalAsOrderPreferences @nwk @us
  Scenario: Set Paypal as Order Preferences to complete any future orders.
    #----- Registration Steps ----#
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register as synch" user
    And I save the newly registered "sync" user details
    And I wait for "10" seconds
    When I hover on element My Account "Header.myAccount_dropdown"
    And I click on element Account Summary "Header.accountSummary_link"
    And I wait for "5" seconds
    And I take screenshot to verify the Account Summary page is displayed with recent order table
    When I click Address link on Account page "MyAccount.addresses_link"
    And I wait for "4" seconds
    #----- User enters Address details ----#
    Then I verify text "Add Address" in page "MyAccountAddress.addAddress_text"
    And I take screenshot to verify the Add Address page is displayed
    And I fill Address Information Details on Address Page using given file "OrderInformation.xlsx"
    And I click Save button on Address page "MyAccountAddress.saveAddress_button"
    And I wait for "4" seconds
    Then I verify the message that contains "was successfully added." in Address page "MyAccountAddress.addressUpdateSave_text"
    And I take screenshot to verify the address is saved.
    #----- User enters Payment Card details ----#
    And I click Payment Cards link "MyAccount.paymentCards_link" using js
    And I wait for "4" seconds
    And I take screenshot to verify Add Payment Card page is displayed
    And I fill Payment Card Details on Add Payment Card page using given file "OrderInformation.xlsx"
    And I click Save button on Payment Card page "MyAccountPaymentCard.Save_button"
    Then I verify the message that contains "Your new payment card details have been saved." in Payment Card page "MyAccountPaymentCard.cardSaved_text"
    And I take screenshot to verify the Card is saved
    #----- User selects Order Preferences ----#
    Then I click Order Preferences link "MyAccount.orderPreferences_link"
    And I wait for "15" seconds
    And I refresh browser
    And I wait for "8" seconds
    And I refresh browser
    And I select by index Account number "1" from dropdown "MyAccountOrderPref.accountNumber_dropdown"
    And I wait for "4" seconds
    Then I Select Order Preferences as page "PayPal"
    And I wait for "3" seconds
    And I click Save button "MyAccountOrderPref.Save_button"
    And I wait for "3" seconds
    And I take screenshot to verify the Order Preferences is saved
    Then I verify text "Your new order preferences have been saved." in page "MyAccountOrderPref.orderPrefSaved_text"

  @ExpressCheckoutUsingPaypal @nwk @us
  Scenario: Place order using PayPal after setting preferences.
    #----- Registration Steps ----#
    Given web site is launched successfully and user "does" accept the cookies
    When last registered "sync" user login to website successfully
    And I wait for "20" seconds
    #----- User search a product and add the product to the basket ----#
    And I enter ordercode value "04R9691" in textbox "Header.searchBox_textbox"
    And I wait for "3" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I take screenshot to verify the Add to cart button.
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And I take screenshot to verify the Shopping Cart page is displayed
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "5" seconds
    And I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
    And I take screenshot to verify Checkout page is displayed
    And I enter random PO Number on Order Review section
    And I take screenshot of the page
    And I wait for "20" seconds
    #-----Enter PayPal details  ----
    And I check terms and conditions checkbox and click on Paypal button
    And I wait "60" seconds for paypal new window
    And I switch to Paypal window
    And I verify page title contains "PayPal" in "Checkout.paypalLoginWindow_element"
    And I Login Paypal
    Then I switch to parent window
    And I wait for "10" seconds
    And I verify element "Checkout.orderConfirmationTitle_text" is present on page and display 'Thank you for your order' in report
    And I take screenshot of the page

  @PaypalPCheckout @nwk @us
  Scenario: Newly Registered user perform Checkout using Paypal as a Payment Method
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    And I save the newly registered "regular" user details
    And I verify element "Header.searchBox_textbox" is present on page
    #----- User navigate to PDP and add the product to the basket ----#
    Then I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "3" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I take screenshot to verify the Add to cart button.
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And I take screenshot to verify the Shopping Cart page is displayed
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "5" seconds
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
    And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
    And I wait for "2" seconds
    And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
    And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
    And I wait for "8" seconds
    And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    And I click paypal account radio button in payment details section 4 "Checkout.payPalPaymentDetails_radio"
    And User take screenshot of the page
    And I wait for "2" seconds
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
    And I wait for "4" seconds
    And I take screenshot of the page
    And I enter random PO Number on Order Review section
    And I take screenshot of the page
    And I wait for "20" seconds
    #-----Enter PayPal details  ----
    And I check terms and conditions checkbox and click on Paypal button
    And I wait "60" seconds for paypal new window
    And I switch to Paypal window
    And I verify page title contains "PayPal" in "Checkout.paypalLoginWindow_element"
    And I Login Paypal
    Then I switch to parent window
    And I wait for "10" seconds
    And I verify element "Checkout.orderConfirmationTitle_text" is present on page and display 'Thank you for your order' in report
    And I take screenshot of the page

  @GuestUserCheckoutUsingPaypal @nwk @us
  Scenario: Guest user perform checkout using Paypal as a Payment Method
    Given web site is launched successfully and user "does" accept the cookies
    And I verify element "Header.searchBox_textbox" is present on page
    Then I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "3" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I take screenshot to verify the Add to cart button.
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And I take screenshot to verify the Shopping Cart page is displayed
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "4" seconds
    And I continue only if guest checkout feature is enabled
    And User click on Checkout Without registering radio button on popup "ShoppingCart.checkoutWithoutRegistering_radio"
    And I populate company details if B2Bonly store and click checkout without registering button
    Then I wait for "8" seconds
    And User take screenshot of the page
    And User fill Checkout Your details section form using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User click on Continue button on Your Details Section "Checkout.yourDetailsSectionContinue_button"
    And I wait for "8" seconds
    And User click on Enter Address Manually Link "Checkout.addAddressManually_link"
    And User take screenshot of the page
    And User fill Checkout Invoice address manually using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
    Then User verify green tick mark element "Checkout.greenTickMarkSection2_icon" is present on page
    And User take screenshot of the page
    And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    And User take screenshot of the page
    Then User verify green tick mark element "Checkout.greenTickMarkSection3_icon" is present on page
    And I wait for "8" seconds
    And I click paypal account radio button in payment details section 4 "Checkout.payPalPaymentDetails_radio"
    And User take screenshot of the page
    And I wait for "2" seconds
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
    And I wait for "2" seconds
    And I take screenshot of the page
    And I enter random PO Number on Order Review section
    And I take screenshot of the page
    And I wait for "20" seconds
    And I check terms and conditions checkbox and click on Paypal button
    And I wait "60" seconds for paypal new window
    And I switch to Paypal window
    And I verify page title contains "PayPal" in "Checkout.paypalLoginWindow_element"
    And I Login Paypal
    Then I switch to parent window
    And I wait for "10" seconds
    And I verify element "Checkout.orderConfirmationTitle_text" is present on page and display 'Thank you for your order' in report
    And I take screenshot of the page
    Then User gets Order confirmation Number

  @SchedulingOrderUSPaypal
  Scenario: Place order through Paypal after scheduling order for next 10 months
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "register" user
    And I wait for "3" seconds
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I verify mini shopping cart header contains "0" items in "Header.itemsInMiniBasket_text"
    And I wait for "3" seconds
    And I enter ordercode value "18M7982" in textbox "ShoppingCart.firstOrderCode_textbox"
    And I scroll till "ShoppingCart.updateBasket_button"
    And I click "ShoppingCart.updateBasket_button"
    And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
    And I wait for "3" seconds
    And I scroll till "Header.itemsInMiniBasket_text"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I wait for "3" seconds
    When I click on Create Schedule on Shopping cart page
    And I click on Delete Schedule on Schedule Page "ScheduleOrder.deleteSchedule_button"
    And I take screenshot of the page
    And I click on confirm Button on Delete Schedule pop up "ScheduleOrder.confirmDeleteSchedule_button"
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And User scroll till "ShoppingCart.createSchedule_button"
    When I click on Create Schedule on Shopping cart page
    And I verify element "ScheduleOrder.scheduleOrderPageTitle_text" is present on page and display in report
    And I click on Add Schedule link on Schedule page "ScheduleOrder.addSchedule_link"
    And I wait for "4" seconds
    And I click on Delete icon on Schedule page "ScheduleOrder.delete_icon"
    And I wait for "4" seconds
    And I click on Add Schedule link on Schedule page "ScheduleOrder.addSchedule_link"
    And I click on Calendar icon on Schedule page "ScheduleOrder.calender_icon"
    And I click on Calendar next year on Schedule page "ScheduleOrder.nextYear_element"
    And I click on Calendar next year month on Schedule page "ScheduleOrder.dateNextYear_element"
    And I take screenshot of the page
    Then I enter Scheduled Quantity value "1" in textbox "ScheduleOrder.scheduledQuantity_text"
    And I click on save Button on Schedule page "ScheduleOrder.saveSchedule_button"
    And I take screenshot of the page
    And I click on Continue to Basket Button on Schedule page "ScheduleOrder.continueToBasket_button"
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And I take screenshot of the page
    And I scroll till "ShoppingCart.orderscheduledconfirmation_message"
    And user verify text "Order scheduled!" in page "ShoppingCart.orderscheduledconfirmation_message"
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "5" seconds
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
    And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
    And I wait for "2" seconds
    And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
    And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
    And I wait for "8" seconds
    And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    And I click paypal account radio button in payment details section 4 "Checkout.payPalPaymentDetails_radio"
    And User take screenshot of the page
    And I wait for "2" seconds
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
    And I wait for "4" seconds
    And I take screenshot of the page
    And I enter random PO Number on Order Review section
    And I take screenshot of the page
    And I wait for "20" seconds
    And I check terms and conditions checkbox and click on Paypal button
    And I wait "60" seconds for paypal new window
    And I switch to Paypal window
    And I verify page title contains "PayPal" in "Checkout.paypalLoginWindow_element"
    And I Login Paypal
    Then I switch to parent window
    And I wait for "10" seconds
    And I verify element "Checkout.orderConfirmationTitle_text" is present on page and display 'Thank you for your order' in report
    And I take screenshot of the page

  @CheckPaypalAsPaymentMethod @PaypalPCheckout @nwk @us
  Scenario: Verify Paypal as payment methode on order history page
    Given web site is launched successfully and user "does" accept the cookies
    When last registered "regular" user login to website successfully
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.orderHistory_list"
    And I wait for "2" seconds
    And I click on link of recent order placed PO Number "OrderHistory.firstPONumber_element" using js
    And I wait for "8" seconds
    And I wait "medium" duration for "OrderHistory.MyOrderDetails_text" element to "appear"
    And I verify element "OrderTracking.paymentInformation_text" is present on page and display its value in report
    And I take screenshot to view My Order Details page

  @PaypalPDisable @us
  Scenario: Verify PayPal is disabled if Tax is not calculated
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    And I wait for "3" seconds
    When I click the "Header.searchIcon_button"
    And I verify element "BrowseForProducts.secondCategory_link" is present on page and display name of Second Category in report
    And I click "BrowseForProducts.secondCategory_link"
    And I scroll till "CategoryPage.showAllProducts_button"
    And I click Show all Products button on L0 category page "CategoryPage.showAllProducts_button"
    Then User verify in L0 Category Page element "CategoryPage.section_category" is present on page
    And I click on Add product button in PLP page "PLP.firstAdd_button" using js
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait for "4" seconds
    And I scroll till "ShoppingCart.checkoutNow_button"
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "5" seconds
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
    And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
    And I wait for "2" seconds
    And User click on Enter Address Manually Link "Checkout.addAddressManually_link"
    And User take screenshot of the page
    And User fill Checkout Invoice address manually using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
    Then User verify green tick mark element "Checkout.greenTickMarkSection2_icon" is present on page
    And I wait for "8" seconds
    And I click on second Day Air delivery method "Checkout.deliveryMethodSecond_radio"
    And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "4" seconds
    And I verify tax value is not calcuated and contains "--" in at order total "Checkout.taxPrice_element"
    And I wait for "3" seconds
    And I verify element "Checkout.paypalDisablemsg_text" is present on page and display its value in report
    And I wait for "3" seconds
    And I verify element "Checkout.payPalPaymentDetails_radio" is not Clickable
    And User take screenshot of the page

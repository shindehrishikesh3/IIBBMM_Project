@25893mob
Feature: US payapl mobile

  @USPayPalRegisteredUser @USPayPalMob @us
  Scenario: To check whether a registered user is able to make payment using Paypal
    Given web site is launched successfully and user "does" accept the cookies
    Given customer accesses the website as "register" user
    And I save the newly registered "regular" user details
    #--------------------------Searching the product--------------------------------------------
    When I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify that element "Search.breadCrumb_element" is present on page
    And I verify that element "PDP.yourPartNo_link" is present on page
    When I click on "PDP.yourPartNo_link"
    And I enter value "123" in textbox "PDP.yourPartNo_textbox"
    And I wait for "3" seconds
    And I enter value "ABC" in textbox "PDP.lineNote_textbox"
    And I wait for "3" seconds
    Then user verify text "Quantity" is visible for "PDP.quantity_text"
    And I verify that element "PDP.quantity_textbox" is present on page
    When I click on "PDP.addToCart_button"
    And I wait "medium" duration for "PDP.addToCartPopup_text" element to "appear"
    Then user verify text "This item has been added to your basket" is visible for "PDP.addToCartPopup_text"
    And I click on "PDP.checkout_button"
    #--------------------------Validation in Shopping Cart--------------------------------------------
    And I wait "medium" duration for "ShoppingCart.updateBasket_button" element to "appear"
    And I scroll till "ShoppingCart.partLineNo_input"
    Then I verify textbox "123" in page "ShoppingCart.partNo_input" with attribute "value"
    Then I verify textbox "ABC" in page "ShoppingCart.lineNo_input" with attribute "value"
    And I scroll till "ShoppingCart.checkoutNowBttom_button"
    When I click on "ShoppingCart.checkoutNowBttom_button"
    #--------------------------Checkout via PayPal--------------------------------------------
    And I wait "medium" duration for "Checkout.checkout_breadcrumbs" element to "appear"
    And User take screenshot of the page
    And I enter PO number value "PaymentViaPayPal" in textbox "Checkout.poNumber_textbox"
    And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    Then User verify green tick mark element "Checkout.account_section" is present on page
    When I select by visible text in Payment Method type as "PayPal" from dropdown "Checkout.paymentMethod_dropdown"
    And I wait for "3" seconds
    And User fill mobile checkout Invoice or billing address manually using given file "OrderInformation.xlsx"
    And I wait for "2" seconds
    And User take screenshot of the page
    And User click on Continue button on Payment Details Section "Checkout.paymentDetailsSectionContinue_button"
    Then User verify green tick mark element "Checkout.paymentInformation_section" is present on page
    When User click on Continue button on Delivery Address Section "Checkout.addressSectionContinue_button"
    Then User verify green tick mark for Delivery Address element "Checkout.shippingAddress_section" is present on page
    And User enter value "Test Order Placed via PayPal" in textbox "Checkout.deliveryInstructions_textbox"
    And User selects special instructions "other" from dropdown and enter instructions if any
    Then User take screenshot of the page
    When User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And User take screenshot of the page
    Then I verify element "Checkout.reviewYourOrder_text" is present on page and display 'Review Your Order Before Submitting' in report
    #And I wait "medium" duration for "Checkout.paypalFrame" element to "appear"
    And I wait for "8" seconds
    And I switch to "Checkout.paypalFrame" frame
    And I wait for "3" seconds
    When I click on "Checkout.paypal_button"
    And I wait for "3" seconds
    And I switch to Paypal window
    And I verify page title contains "PayPal" in "Checkout.paypalLoginWindow_element"
    And I Login to Paypal
    And I take screenshot of the page
    Then I switch to parent window
    And I wait for "10" seconds
    And I verify element "Checkout.orderConfirmationTitle_text" is present on page and display 'Thank you' in report
    And I take screenshot of the page

  @USPayPalGuestUser @USPayPalMob @us
  Scenario: To check whether a guest user is able to make payment using Paypal
    Given web site is launched successfully and user "does" accept the cookies
    Given customer accesses the website as "guest" user
    #--------------------------Searching the product--------------------------------------------
    When I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify that element "Search.breadCrumb_element" is present on page
    And I verify that element "PDP.yourPartNo_link" is present on page
    And I scroll till "PDP.yourPartNo_link"
    When I click on "PDP.yourPartNo_link"
    And I enter value "123" in textbox "PDP.yourPartNo_textbox"
    And I wait for "3" seconds
    And I enter value "ABC" in textbox "PDP.lineNote_textbox"
    And I wait for "3" seconds
    Then user verify text "Quantity" is visible for "PDP.quantity_text"
    And I verify that element "PDP.quantity_textbox" is present on page
    When I click on "PDP.addToCart_button"
    And I wait "medium" duration for "PDP.addToCartPopup_text" element to "appear"
    Then user verify text "This item has been added to your basket" is visible for "PDP.addToCartPopup_text"
    And I click on "PDP.checkout_button"
    #--------------------------Validation in Shopping cart--------------------------------------------
    And I wait "medium" duration for "ShoppingCart.updateBasket_button" element to "appear"
    And I scroll till "ShoppingCart.partLineNo_input"
    Then I verify textbox "123" in page "ShoppingCart.partNo_input" with attribute "value"
    Then I verify textbox "ABC" in page "ShoppingCart.lineNo_input" with attribute "value"
    And I scroll till "ShoppingCart.checkoutNowBttom_button"
    When I click on "ShoppingCart.checkoutNowBttom_button" using js
    And I wait for "1" seconds
    And I switch to popoup window
    And I take screenshot of the page
    And I click on "ShoppingCart.checkoutWithoutRegistering_button"
    Then I switch to parent window
    #--------------------------Checkout via PayPal--------------------------------------------
    And I wait "medium" duration for "Checkout.checkout_breadcrumbs" element to "appear"
    And User take screenshot of the page
    And I enter PO number value "PaymentViaPayPal" in textbox "Checkout.poNumber_textbox"
    And I scroll till "Checkout.continueAccountSection_button"
    And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    And I wait for "5" seconds
    Then User verify green tick mark element "Checkout.account_section" is present on page
    When I select by visible text in Payment Method type as "PayPal" from dropdown "Checkout.paymentMethod_dropdown"
    And I wait for "3" seconds
    And User fill mobile checkout Invoice or billing address manually using given file "OrderInformation.xlsx"
    And I wait for "2" seconds
    And User take screenshot of the page
    And User click on Continue button on Payment Details Section "Checkout.paymentDetailsSectionContinue_button"
    Then User verify green tick mark element "Checkout.paymentInformation_section" is present on page
    When User click on Continue button on Delivery Address Section "Checkout.addressSectionContinue_button"
    Then User verify green tick mark for Delivery Address element "Checkout.shippingAddress_section" is present on page
    And User enter value "Test Order Placed via PayPal" in textbox "Checkout.deliveryInstructions_textbox"
    And User selects special instructions "other" from dropdown and enter instructions if any
    Then User take screenshot of the page
    When User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And User take screenshot of the page
    And I wait "medium" duration for "Checkout.reviewYourOrder_text" element to "appear"
    Then I verify element "Checkout.reviewYourOrder_text" is present on page and display 'Review Your Order Before Submitting' in report
    #And I wait "medium" duration for "Checkout.paypalFrame" element to "appear"
    And I wait for "8" seconds
    #And I click on "Checkout.termsAndConditions_checkbox"
    And I wait for "3" seconds
    And I switch to "Checkout.paypalFrame" frame
    When I click on "Checkout.paypal_button"
    And I wait for "3" seconds
    And I switch to Paypal window
    And I verify page title contains "PayPal" in "Checkout.paypalLoginWindow_element"
    And I Login to Paypal
    And I take screenshot of the page
    Then I switch to parent window
    And I wait for "10" seconds
    And I verify element "Checkout.orderConfirmationTitle_text" is present on page and display 'Thank you' in report
    And I take screenshot of the page

  @USorderHistory @USPayPalMob @us
  Scenario: Verify the payment method as Paypal for recent order
    Given web site is launched successfully and user "does" accept the cookies
    When last registered "regular" user login to website successfully
    And I wait for "3" seconds
    And I scroll till "Home.orderHistoryAndTracking_link"
    Then I click order history and tracking link "Home.orderHistoryAndTracking_link" using js
    And I wait for "3" seconds
    And I verify element "OrderHistory.orderHistoryTracking_text" is present on page and display 'Order History & Tracking' in report
    And I take screenshot of the page to see the recent order table displayed on page
    And I verify element "OrderHistory.orderDate_text" is present on page and display 'Date of Purchase' in report
    And I click more detials link on order history page "OrderHistory.moreDetails_link"
    And I wait for "4" seconds
    And I scroll till "OrderHistory.paymentInfo_section"
    And I click payment inforamtion section to expand "OrderHistory.paymentInfo_section" using js
    And I wait for "2" seconds
    Then I verify text "PayPal" is visible for "OrderHistory.paymentmethod_text"

  @DisablePayPal @USPayPalMob @us
  Scenario: Verify PayPal is disabled if Tax is not calculated
    Given web site is launched successfully and user "does" accept the cookies
    Given customer accesses the website as "register" user
    #--------------------------Searching the product--------------------------------------------
    When I enter "multiimage" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify that element "Search.breadCrumb_element" is present on page
    When I click on "PDP.addToCart_button"
    And I wait "medium" duration for "PDP.addToCartPopup_text" element to "appear"
    Then user verify text "This item has been added to your basket" is visible for "PDP.addToCartPopup_text"
    And I click on "PDP.checkout_button"
    And I wait "medium" duration for "ShoppingCart.updateBasket_button" element to "appear"
    And I scroll till "ShoppingCart.checkoutNowBttom_button"
    When I click on "ShoppingCart.checkoutNowBttom_button"
    #--------------------------Checkout via PayPal--------------------------------------------
    And I wait "medium" duration for "Checkout.checkout_breadcrumbs" element to "appear"
    And User take screenshot of the page
    And I wait for "5" seconds
    And I enter PO number value "PaymentViaPayPal" in textbox "Checkout.poNumber_textbox"
    And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    Then User verify green tick mark element "Checkout.account_section" is present on page
    When I select by visible text in Payment Method type as "PayPal" from dropdown "Checkout.paymentMethod_dropdown"
    And I wait for "3" seconds
    And User fill mobile checkout Invoice or billing address manually using given file "OrderInformation.xlsx"
    And I wait for "2" seconds
    And User take screenshot of the page
    And User click on Continue button on Payment Details Section "Checkout.paymentDetailsSectionContinue_button"
    Then User verify green tick mark element "Checkout.paymentInformation_section" is present on page
    When User click on Continue button on Delivery Address Section "Checkout.addressSectionContinue_button"
    Then User verify green tick mark for Delivery Address element "Checkout.shippingAddress_section" is present on page
    And I wait for "2" seconds
    And User click on second Day Air delivery method "Checkout.deliveryMethodSecond_radio"
    And User enter value "Test Order Placed via PayPal" in textbox "Checkout.deliveryInstructions_textbox"
    And User selects special instructions "other" from dropdown and enter instructions if any
    Then User take screenshot of the page
    When User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And User take screenshot of the page
    And I wait for "6" seconds
    And I verify element "Checkout.paypalDisableMessage_text" is present on page and display its value in report
    And I take screenshot of the page
    And I scroll till "Checkout.continueAccountSection_button"
    And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    And I wait for "6" seconds
    And I click on "Checkout.paymentMethod_dropdown"
    And I wait for "2" seconds
    And I verify element "Checkout.paypalPaymentMethod_dropdown" is disabled
    And User take screenshot of the page

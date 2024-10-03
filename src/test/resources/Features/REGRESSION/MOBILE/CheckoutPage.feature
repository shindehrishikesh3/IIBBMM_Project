#Author: Soumen Maity

@checkout @mobAgileRegression @mobValidationTests
Feature: Checkout Page Regression

  Background: Launch homepage for PDP regression check
    Given web site is launched successfully and user "does" accept the cookies

  @VoucherCode @editPaymentToTradeFromCC @Priority2 @eu @apac @nwk @nacn
  Scenario: Verify user able to apply voucher code successfully and place order using credit card 
  					and user is also able to edit the payment method from Credit Card to Trade account
  	Given customer accesses the website as "register" user
    And I save the newly registered "regular" user details
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
    And I wait "medium" duration for "ShoppingCart.updateBasket_button" element to "appear"
    And I scroll till "ShoppingCart.partLineNo_input"
    And I wait for "3" seconds
    Then I verify textbox "123" in page "ShoppingCart.partNo_input" with attribute "value"
    Then I verify textbox "ABC" in page "ShoppingCart.lineNo_input" with attribute "value"
    And I scroll till "ShoppingCart.voucherCode_textBox"
    And I enter E-voucher code in "ShoppingCart.voucherCode_textBox" using given file "EVouchers.xlsx"
    And I click on "ShoppingCart.voucherCodeApply_button" using js
    And I wait for "4" seconds
    Then User verify text "Voucher Discount" is visible for "ShoppingCart.voucherCode_text"
    And User take screenshot of the page
    And I verify element "ShoppingCart.voucherName_text" is present on page    
    When I click on "ShoppingCart.checkoutNowBttom_button" refreshed element
    And I wait "medium" duration for "Checkout.checkout_breadcrumbs" element to "appear"
    And User take screenshot of the page
    And I enter PO number value "VoucherTest" in textbox "Checkout.poNumber_textbox"
    And I wait for "2" seconds
    And User take screenshot of the page
    And User scroll till "Checkout.continueAccountSection_button"
    And I wait for "2" seconds
    And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    Then User verify green tick mark element "Checkout.account_section" is present on page
    #-----------------------Making payment using Credit Card---------------------------------
    When I select by option in Payment Method type as "CardPayment" from dropdown "Checkout.paymentMethod_dropdown"
    And I wait for "3" seconds
    And User fill mobile checkout Invoice or billing address manually using given file "OrderInformation.xlsx"
    And I wait for "2" seconds
    And User take screenshot of the page
    And I select by visible text in Card type as "VISA" from dropdown "Checkout.cardType_dropdown"
    And User fill Credit Card Details in mobile using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    Then User scroll till "Checkout.cardHolderPhone_textbox"
    And I wait for "2" seconds
    And User click on Continue button on Payment Details Section "Checkout.paymentDetailsSectionContinue_button"
    Then User verify green tick mark element "Checkout.paymentInformation_section" is present on page
    And I wait for "5" seconds
    And User click on Continue button on Delivery Address Section "Checkout.addressSectionContinue_button" using js
    Then User verify green tick mark for Delivery Address element "Checkout.shippingAddress_section" is present on page
    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And User selects special instructions "other" from dropdown and enter instructions if any
    And User take screenshot of the page
    And User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And I wait "medium" duration for "Checkout.orderReviewSection_element" element to "appear"
    And User take screenshot of the page
    Then I verify element "Checkout.reviewYourOrder_text" is present on page and display 'Review Your Order Before Submitting' in report
    #-----------------------Editing the Payment method as Trade Account-----------------------
    When I click on "Checkout.editInvoiceAddress_button" using js
    And I wait "medium" duration for "Checkout.paymentDetails_section" element to "appear"
    And I wait for "3" seconds
    And I select by visible text in Payment Method type as "Trade Account" from dropdown "Checkout.paymentMethod_dropdown"
    And User take screenshot of the page
    And User click on Continue button on Payment Details Section "Checkout.paymentDetailsSectionContinue_button"
    Then User verify green tick mark element "Checkout.paymentInformation_section" is present on page
    And User click on Continue button on Delivery Address Section "Checkout.addressSectionContinue_button"
    Then User verify green tick mark for Delivery Address element "Checkout.shippingAddress_section" is present on page
    And User enter value "Updated Payment option" in textbox "Checkout.deliveryInstructions_textbox"
    And User selects special instructions "other" from dropdown and enter instructions if any
    And User take screenshot of the page
    And User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And User take screenshot of the page
    Then I verify element "Checkout.reviewYourOrder_text" is present on page and display 'Review Your Order Before Submitting' in report
    And User checks terms and conditions checkbox and click on Submit Order button
    And I wait for "8" seconds
    And user take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you' in report
    Then user take screenshot of the page
    
	@PayPalRegisteredUser @eu @Priority1
	Scenario: To check whether a registered user is able to make payment third party Paypal
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
    And I enter PO number value "PayViaPayPal" in textbox "Checkout.poNumber_textbox"
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
    And User enter value "This is Test Placed Order via PayPal" in textbox "Checkout.deliveryInstructions_textbox"
    And User selects special instructions "other" from dropdown and enter instructions if any
    Then User take screenshot of the page
    When User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And User take screenshot of the page
    Then I verify element "Checkout.reviewYourOrder_text" is present on page and display 'Review Your Order Before Submitting' in report
    #And I wait "medium" duration for "Checkout.paypalFrame" element to "appear"
    And I wait for "8" seconds
    And I click on "Checkout.termsAndConditions_checkbox"
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
		
	@PayPalGuestUser @eu @Priority1 @live
	Scenario: To check whether a guest user is able to make payment third party Paypal
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
		When I click on "ShoppingCart.checkoutNowBttom_button"
		And I wait for "1" seconds
		And I switch to popoup window
		And I take screenshot of the page
		And I click on "ShoppingCart.checkoutWithoutRegistering_button"
		Then I switch to parent window
		#--------------------------Checkout via PayPal--------------------------------------------
    And I wait "medium" duration for "Checkout.checkout_breadcrumbs" element to "appear"
    And User take screenshot of the page
    And I enter PO number value "PayViaPayPal" in textbox "Checkout.poNumber_textbox"
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
    And User enter value "PayPal Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And User selects special instructions "other" from dropdown and enter instructions if any
    Then User take screenshot of the page
    When User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And User take screenshot of the page
    And I wait "medium" duration for "Checkout.reviewYourOrder_text" element to "appear"
    Then I verify element "Checkout.reviewYourOrder_text" is present on page and display 'Review Your Order Before Submitting' in report
    #And I wait "medium" duration for "Checkout.paypalFrame" element to "appear"
    And I wait for "8" seconds
    And I click on "Checkout.termsAndConditions_checkbox"
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
		
		
#Author: Soumen Maity

@orderHistory @mobAgileRegression @mobValidationTests
Feature: My Account page Regression 

 	Background: Launch homepage to verify Order History & Tracking
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "login" user
    And I wait for "3" seconds
    When I click on Navigation Toggle Bar on Home page "Home.navigationToggleBar_button"
    And I wait for "4" seconds
    Then I click My Account link "Home.myAccount_link"
    And I wait for "7" seconds

	@orderHistory @registeredUser @Priority3 @eu @apac @nwk
  Scenario: Verify the order history for recent orders
    Then I verify element "OrderHistory.recentOrderHistoryTable_element" is present on page and display 'Recent Order details' in report
    And I verify recent order history table in mobile app is displayed
    And I wait for "5" seconds
    And I scroll till "OrderHistory.recentOrders_text"
    Then I click on View all Orders button "OrderHistory.viewAllOrders_button"
    And I wait for "4" seconds
    Then I verify element "OrderHistory.orderHistoryTracking_text" is present on page and display 'Order History & Tracking' in report
    And I take screenshot of the page to see the recent order table displayed on page
    Then I check element "OrderHistory.orderDate_text" is present on page
    And I check element "OrderHistory.moreDetails_link" is present on page
    And I check element "OrderHistory.otherDetails_section" is present on page
    When I click more details link "OrderHistory.moreDetails_link"
    And I wait "short" duration for "OrderHistory.orderDetails_section" element to "appear"
    And I take screenshot
    Then I check element "OrderHistory.orderDateText_text" is present on page
    And I check element "OrderHistory.orderInfo_section" is present on page
    And I check element "OrderHistory.deliveryAddress_section" is present on page
    And I check element "OrderHistory.deliveryInfo_section" is present on page
    And I check element "OrderHistory.paymentInfo_section" is present on page
    And I scroll till "OrderHistory.NotShippedProduct_section"
    Then I check element "OrderHistory.NotShippedProduct_section" is present on page
    
  @reOrder @registeredUser @Priority3 @eu @apac @nwk
  Scenario: Verify customer is able to reorder product from Order History & Tracking for guest user
     #------------------------Order History and Tracking---------------------------------
    And I verify element "OrderHistory.recentOrderHistoryTable_element" is present on page and display 'Recent Order details' in report
    And I verify recent order history table in mobile app is displayed
    And I wait for "5" seconds
    And I scroll till "OrderHistory.recentOrders_text"
    And I click on View all Orders button "OrderHistory.viewAllOrders_button"
    And customer wait "long" duration for "OrderHistory.orderHistoryTracking_text" element to "appear"
    And I take screenshot
    And I click on View all Orders button "OrderHistory.moreDetails_link"
    #And customer wait "long" duration for "OrderHistory.orderDetails_section" element to "appear"
    And I wait for "30" seconds
    And I take screenshot
    And I scroll till "OrderHistory.NotShippedProduct_section"
    And I wait for "2" seconds
    When customer clicks on "OrderHistory.NotShippedProduct_section" without wait
    And User take screenshot of the page
    #And I save the order code obtained from "OrderHistory.orderCode_text"
    And User checks if the order is shipped or not and save the order code
    #------------------------Re order---------------------------------
    And customer clicks on "OrderHistory.reorder_link"
    And I wait "long" duration for "PDP.addToCartPopup_text" element to "appear"
    Then user verify text "This item has been added to your basket" is visible for "PDP.addToCartPopup_text"
    And I click on "PDP.checkout_button"
    And I wait "medium" duration for "ShoppingCart.shoppingcartMain_section" element to "appear"
    And I scroll till "ShoppingCart.basketContent_section"
    And I wait for "2" seconds
    And I take screenshot
    Then I verify whether same product from order history is reordered added to basket
    And I scroll till "ShoppingCart.updateBasket_button"
    And I wait for "2" seconds
    And I click on "ShoppingCart.updateBasket_button"
    And I scroll till "ShoppingCart.checkoutNowBttom_button"
    And I wait for "2" seconds
    When I click on "ShoppingCart.checkoutNowBttom_button"
    And I wait for "4" seconds
    And customer wait "long" duration for "Checkout.poNumber_textbox" element to "appear"
    And User take screenshot of the page
    And I enter PO number value "TestOrder" in textbox "Checkout.poNumber_textbox"
    And I wait for "3" seconds
    And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    And I wait "long" duration for "Checkout.paymentMethod_dropdown" element to "appear"
    And I wait for "3" seconds    
    And I select by visible text in Payment Method type as "Credit / Debit Card" from dropdown "Checkout.paymentMethod_dropdown"
    And User take screenshot of the page
    And I select by visible text in Card type as "VISA" from dropdown "Checkout.cardType_dropdown"
    And User fill Credit Card Details in mobile using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User click on Continue button on Payment Details Section "Checkout.paymentDetailsSectionContinue_button"
    Then User verify green tick mark element "Checkout.paymentInformation_section" is present on page
    And User click on Continue button on Delivery Address Section "Checkout.addressSectionContinue_button"
    Then User verify green tick mark for Delivery Address element "Checkout.shippingAddress_section" is present on page
    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And User selects special instructions "other" from dropdown and enter instructions if any
    And User take screenshot of the page
    And User clicks on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And I wait "long" duration for "Checkout.reviewYourOrder_text" element to "appear"
    And User take screenshot of the page
    And I verify element "Checkout.reviewYourOrder_text" is present on page and display 'Review Your Order Before Submitting' in report
    And User checks terms and conditions checkbox and click on Submit Order button
    And I wait for "8" seconds
    And user take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you' in report
    And user take screenshot of the page
    
	@errorValidation @registeredUser @changePwdErrorValidation @Priority4 @eu @apac @nwk @live
  Scenario: Verify error while user entering blank or incorrect password or password not matching the criteria while changing the password
		Given customer click on profile information button "AccountSummary.editProfile_button"
		#---------validating error message without entering any password------------
		And he click on "AccountSummary.changePassword_button"
		Then he verify text error message "Please enter all required information. The following was not entered:" in page "Login.topHeaderError_text"
		And verify below are displayed in "AccountSummary.errorMsg_text" table on PDP
      | Temporary Password      |
      | Password							  |
      | Confirm Password			  |
    And he take screenshot of the page
    #---------validating error message with entering only current password and leaving others blank------------
		When he enter password type as "old" password in "AccountSummary.currentPassword_input" field
		And click on "AccountSummary.changePassword_button"
		Then he verify text error message "Please enter all required information. The following was not entered:" in page "Login.topHeaderError_text"
		And verify below are displayed in "AccountSummary.errorMsg_text" table on PDP
      | Password							  |
      | Confirm Password			  |
    And take screenshot of the page
    #---------validating error message with keeping confirm password field blank------------
		When he enter password type as "new" password in "Login.password_textbox" field
		And click on "AccountSummary.changePassword_button"
		Then he verify text error message "Please enter all required information. The following was not entered:" in page "Login.topHeaderError_text"
		And verify below are displayed in "AccountSummary.errorMsg_text" table on PDP
      | Confirm Password			  |
		And take screenshot of the page
		#---------validating error message with entering invalid criteria of password------------
		When he clears text from textbox "Login.password_textbox"
		And enter password type as "invalid" password in "Login.password_textbox" field
		And clears text from textbox "AccountSummary.confirmPassword_input"
		And enter password type as "invalid" password in "AccountSummary.confirmPassword_input" field
		And click on "AccountSummary.changePassword_button"
		Then he verify text error message "Password entered does not meet the criteria specified below." in page "AccountSummary.firstErrorMsg_text"
		And take screenshot of the page
		#---------validating error message while entering unmatching password in Confirm password------------
		When he clears text from textbox "Login.password_textbox"
		And enter password type as "new" password in "Login.password_textbox" field
		And clears text from textbox "AccountSummary.confirmPassword_input"
		And enter password type as "different" password in "AccountSummary.confirmPassword_input" field
		And click on "AccountSummary.changePassword_button"
		Then he verify text error message "The password and confirm password do not match. Please re-enter and try again." in page "AccountSummary.firstErrorMsg_text"
		And take screenshot of the page
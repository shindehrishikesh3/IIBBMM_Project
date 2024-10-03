@validationTests @checkout
Feature: Checkout validation tests

	@ExpressCheckout @Priority1 @agileRegression  @nacn @eu @apac @nwk @live
	Scenario: Express Checkout
		#----- Registration Steps ----#
		Given web site is launched successfully and user "does" accept the cookies
		And customer accesses the website as "register" user
		And I wait for "20" seconds
		When I hover on element My Account "Header.myAccount_dropdown"
		And I click on element Account Summary "Header.accountSummary_link"
		And I wait for "5" seconds
		And I take screenshot to verify the Account Summary page is displayed with recent order table
		And I verify element "OrderHistory.recentOrders_text" is present on page and display 'Recent Orders' in report
		When I click Address link on Account page "MyAccount.addresses_link"
		And I wait for "4" seconds
		#----- User enters Address details ----#
		Then I verify text "Add Address" in page "MyAccountAddress.addAddress_text"
		And I take screenshot to verify the Add Address page is displayed
		And I fill Address Information Details on Address Page using given file "OrderInformation.xlsx"		
		And I click Save button on Address page "MyAccountAddress.saveAddress_button"
		And I click You Entered if address validation pop-up is displayed
		Then I verify element "MyAccountAddress.addressUpdateSave_text" is present on page and display in report 
		And I take screenshot to verify the address is saved.
		#----- User enters Payment Card details ----#
		And I click Payment Cards link "MyAccount.paymentCards_link"
		And I wait for "4" seconds
		And I take screenshot to verify Add Payment Card page is displayed
		And I fill Payment Card Details on Add Payment Card page using given file "OrderInformation.xlsx"
		And I click Save button on Payment Card page "MyAccountPaymentCard.Save_button"
		Then I verify element "MyAccountPaymentCard.cardSaved_text" is present on page and display in report
		And I take screenshot to verify the Card is saved
		#----- User selects Order Preferences ----#
		Then I click Order Preferences link "MyAccount.orderPreferences_link"
		And I wait for "4" seconds
		Then I select Order Preferences in page
		And I click Save button "MyAccountOrderPref.Save_button"
		And I wait for "3" seconds
		And I take screenshot to verify the Order Preferences is saved
		Then I verify element "MyAccountOrderPref.orderPrefSaved_text" is present on page and display in report
		#----- User search a product and add the product to the basket ----#
		Then I enter ordercode in Searchbox to navigate to PDP page
		And I wait for "3" seconds
		And I click on order code link "Search.lookAheadSKU_link"
		And I wait for "3" seconds
		And I scroll till "PDPBuyBox.addToCart_button"
		And I wait for "2" seconds
		And I take screenshot to verify the Add to cart button.
		And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
		#----- User navigate to PDP and add the product to the basket ----#
		And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
		And I wait for "3" seconds
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
		And I take screenshot to verify the Shopping Cart page is displayed
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
		And I wait for "5" seconds
		And I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
		And I take screenshot to verify Checkout page is displayed
		And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
		And I take screenshot of the page
		And I wait for "2" seconds
		#And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		#----- User Checkout and places an order ----#
		Then I enter cvv number "123"
		#And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		And I scroll till "Checkout.poNumber_textbox"
		And I take screenshot to verify Order Review section is displayed
		Then I enter random PO Number on Order Review section
		And User checks terms and conditions checkbox and click on Submit Order button
		And I wait for "5" seconds
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		And I take screenshot to verify Order Confirmation page is displayed

	@PlaceAnOrderWithAccount @Priority1 @agileRegression @nacn @namx @eu @apac @nwk @naie
	Scenario: Synced user place an order with account
		Given web site is launched successfully and user "does" accept the cookies
		When customer accesses the website as "contract" user
		And Verify user is logged in on Home page successfully
		And I clear items from shopping cart if any present
		And I hover on element My Account "Header.myAccount_dropdown"
		And I click Account Summary from the dropdown "Header.accountSummary_link"
		And I wait for "2" seconds
		And I scroll till "AccountSummary.backOfficeAccount_text"
		And I take screenshot to view the Account Summary page
		Then I verify element "AccountSummary.backOfficeAccount_text" is present on page and display 'Back Office Account number Synched' in report
		And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
		And I wait for "3" seconds
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		And I enter ordercode in textbox "ShoppingCart.firstOrderCode_textbox"
		And I verify text "1" in page "ShoppingCart.quantity_textbox" with attribute "value"
		And I click "ShoppingCart.updateBasket_button"
		And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		And I verify element "ShoppingCart.firstProductOnCart_text" is present on page and display its value in report
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
		And I wait for "4" seconds
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
		Then I scroll till "Checkout.paymentDetailsSectionContinue_button"
		And User click on Continue button "Checkout.paymentDetailsSectionContinue_button"
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait for "8" seconds
		Then User verify edit button element "Checkout.editDeliveryOptions_button" is present on page
		And I verify element "Checkout.paymentDetails_text" is present on page and display its value in report
		And I wait for "3" seconds
		And I select trade account radio button and click continue button in section 4 payment method
		And I enter PO number value "syncedAcc" in textbox "Checkout.poNumber_textbox"
		And User checks terms and conditions checkbox and click on Submit Order button
		And I wait for "3" seconds
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		And I take screenshot of the page
		And I hover on element My Account "Header.myAccount_dropdown"
		And I click on "Header.logout_button"

	@RegistrationPromptAfterGuestCheckout @Priority1 @eu @apac @nwk
	Scenario: Checkout - Registration prompt after guest checkout
		Given web site is launched successfully and user "does" accept the cookies
		And customer accesses the website as "guest" user
		And I verify element "Header.searchIcon_button" is present on page
		And I enter the value "bav99" in textbox "Header.searchBox_textbox"
		And I click the "Header.searchIcon_button"
		And I wait for "2" seconds
		And I verify PLP table element "PLP.PLP_element" is present on page
		And I click on Add button on PLP "PLP.firstAdd_button"
		And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "3" seconds
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		And I verify element "ShoppingCart.firstProductOnCart_text" is present on page and display its value in report
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And I wait for "4" seconds
		And I continue only if guest checkout feature is enabled
		And User click on Checkout Without registering radio button on popup "ShoppingCart.checkoutWithoutRegistering_radio"
		#And User click on Checkout without registering button "ShoppingCart.checkoutWithoutRegistering_button"
		And I populate company details if B2Bonly store and click checkout without registering button
		Then I wait for "8" seconds
		And User take screenshot of the page
		And User fill Checkout Your details section form using given file "OrderInformation.xlsx"
		And User take screenshot of the page
		And User click on Continue button on Your Details Section "Checkout.yourDetailsSectionContinue_button"
		And User click on Enter Address Manually Link "Checkout.addAddressManually_link"
		And User fill Checkout Invoice address manually using given file "OrderInformation.xlsx"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		Then User verify green tick mark element "Checkout.greenTickMarkSection2_icon" is present on page
		#And User scroll till "Checkout.deliveryInstructions_textbox"
		#And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		Then User verify green tick mark element "Checkout.greenTickMarkSection3_icon" is present on page
		And User fill Credit Card Details using given file "OrderInformation.xlsx"
		And I wait for "3" seconds
		And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		And I wait for "3" seconds
		When User enter random PO Number on Order Review section
		And I wait for "10" seconds
		And User checks terms and conditions checkbox and click on Submit Order button
		And I wait for "4" seconds
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		Then User gets Order confirmation Number
		And user take screenshot of the page
		And I fill details in create account section on Order Confirmation form using given file "Registration.xlsx"
		And I wait for "4" seconds
		And I verify text "Welcome" in page "AccountSummary.welcome_text"
		And I wait for "5" seconds
		And I hover on element My Account "Header.myAccount_dropdown"
		And I click on "Header.logout_button"

	@VerifyContractPrice @Priority2 @eu @apac @nwk
	Scenario: Verify contract price
		Given web site is launched successfully and user "does" accept the cookies
		When customer accesses the website as "contract" user
		And Verify user is logged in on Home page successfully
		And I clear items from shopping cart if any present
		Then I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
		And I wait for "4" seconds
		And I verify PLP table element "PLP.PLP_element" is present on page
		And I verify element "PLP.contractPrice_icon" is present on page
		And I click on Manufacture Part No link on PLP page to navigate to PDP page "PLP.manufacturerPartNo_link"
		And I wait for "4" seconds
		And I verify element "PDPBuyBox.contractPrice_icon" is present on page
		And I click on add to cart button "PDPBuyBox.addToCart_button" using js
		And I wait for "3" seconds
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "3" seconds
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page
		And I verify element "ShoppingCart.contractPrice_icon" is present on page
		And I hover on element My Account "Header.myAccount_dropdown"
		And I click on "Header.logout_button"

	@PaypalPaymentCheckout @Priority2 @agileRegression @eu @live @naie
	Scenario: Checkout - To verify successful Paypal Payment as a Registered user
		Given web site is launched successfully and user "does" accept the cookies
		When customer accesses the website as "register" user
		Then I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
		And I wait for "3" seconds
		And I click on Add product button in PLP page "PLP.firstAdd_button" using js
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "4" seconds
		And I scroll till "ShoppingCart.checkoutNow_button"
		When User click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And I wait for "4" seconds
		And I click Paypal as Payment method in section 1 "Checkout.creditcardPaypal_radio"
		And I select credit card or paypal Payment method in section one for DE store
		And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
		And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
		And I wait for "2" seconds
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		And I wait for "8" seconds
		#-------This field is removed asd part of Sprint 67 in checkout----------
#		And I enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
#		And I wait for "3" seconds
		And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
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
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		And I take screenshot of the page

	@ChangePaymentMethod @Priority2 @agileRegression @nacn @eu @apac @nwk @live
	Scenario: Checkout - Change payment method test
		Given web site is launched successfully and user "does" accept the cookies
		When customer accesses the website as "register" user
		Then I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
		And I wait for "3" seconds
		And I click on Add product button in PLP page "PLP.firstAdd_button" using js
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "4" seconds
		And I scroll till "ShoppingCart.checkoutNow_button"
		When User click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And I wait for "4" seconds
		And User take screenshot of the page
		Given I verify element "Checkout.paymentDetails_text" is present on page and display its value in report
		And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
		And I would like to open a new Trade Account
		And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		And I wait for "8" seconds
		Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
		#-------This field is removed asd part of Sprint 67 in checkout----------
#		And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
#		And I wait for "3" seconds
		And I scroll till "Checkout.deliverySectionContinue_button"
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait for "8" seconds
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		And I select trade account radio button and click continue button in section 4 payment method
		Then I verify Payment Details section edit button element "Checkout.editPaymentDetails_button" is present on page
		And I fill Additional Information Details for New Trade Account using given file "OrderInformation.xlsx"
		And I wait for "3" seconds
		And User take screenshot of the page
		And I scroll till "Checkout.editPaymentDetails_button"
		And I click Edit button in Payment method in section 1 "Checkout.editPaymentDetails_button"
		And I click Credit card as Payment method  in section 4 "Checkout.creditcardPayment_radio"
		And User fill Credit Card Details using given file "OrderInformation.xlsx"
		And User take screenshot of the page
		And I scroll till "Checkout.paymentDetailsSectionContinue_button"
		And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
		And I wait for "8" seconds
		And User take screenshot of the page
		When User enter random PO Number on Order Review section
		And User take screenshot of the page
		And I wait for "10" seconds
		And User checks terms and conditions checkbox and click on Submit Order button
		And user take screenshot of the page
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		Then User gets Order confirmation Number
		And user take screenshot of the page

	@E-vouchers @Priority2 @eu @apac @nwk
	Scenario: Checkout - evouchers General Test
		Given web site is launched successfully and user "does" accept the cookies
		When customer accesses the website as "register" user
		And I wait for "5" seconds
		Then I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
		And I wait for "3" seconds
		And I clears text from textbox "PLP.quantity_text"
		And I enter Quantity value "5" in textbox "PLP.quantity_text"
		And I click on Add product button in PLP page "PLP.firstAdd_button" using js
		And I wait for "3" seconds
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "4" seconds
		And I scroll till "ShoppingCart.e-voucher_link"
		And I click on E-Vochers link shopping basket page "ShoppingCart.e-voucher_link"
		And I get the Total Price before applying E-voucher
		And I take screenshot of the page
		And I enter E-voucher code in "ShoppingCart.vouchercode_text" using given file "EVouchers.xlsx"
		And I click on apply "ShoppingCart.applyEvoucher_button"
		And I wait for "10" seconds
		And I verify the Total Price after applying E-voucher
		And I scroll till "ShoppingCart.discountPrice_message"
		And I take screenshot of the page
		And I verify Discount Price text contains "Discount Price" in "ShoppingCart.discountPrice_message"
		And I scroll till "ShoppingCart.voucherDiscount_message"
		And I verify Discount Price text contains "Voucher Discount" in "ShoppingCart.voucherDiscount_message"
		And I scroll till "ShoppingCart.checkoutNow_button"
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And I wait for "4" seconds
		And I verify the Total Price after applying E-voucher in Checkout Page
		And I take screenshot of the page
		And I verify Discount Price text contains "Voucher Discount" in "ShoppingCart.voucherDiscount_message"
		And I click on "Header.companylogo_element"
		And I wait for "5" seconds
		And I hover on element My Account "Header.myAccount_dropdown"
		Then I click on logout option "Header.logout_button"

	@SchedulingOrderRegression @Priority1 @eu @apac @nwk @live
	Scenario: Schedule Order test
		Given web site is launched successfully and user "does" accept the cookies
		When customer accesses the website as "register" user
		Then I enter ordercode in Searchbox to navigate to PDP page
		And I wait for "3" seconds
		And I click on order code link "Search.lookAheadSKU_link"
		And I wait for "3" seconds
		And I scroll till "PDPBuyBox.addToCart_button"
		And I wait for "2" seconds
		#And User clears text from textbox "PDPBuyBox.qty_textbox"
		#Then I enter Quantity value "30" in textbox "PDPBuyBox.qty_textbox"
		And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
		And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
		And User clears text from textbox "ShoppingCart.quantityFirstProduct_textbox"
		Then I enter Quantity value "30" in textbox "ShoppingCart.quantityFirstProduct_textbox"
		And I click "ShoppingCart.updateBasket_button"
		And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		And User scroll down the page by pixels "500"
		And I wait for "5" seconds
		And I take screenshot of the page
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
		And I select date to Schedule Order
		And I take screenshot of the page
		Then I enter Scheduled Quantity value "10" in textbox "ScheduleOrder.scheduledQuantity_text"
		And I click on save Button on Schedule page "ScheduleOrder.saveSchedule_button"
		And I take screenshot of the page
		And I click on Continue to Basket Button on Schedule page "ScheduleOrder.continueToBasket_button"
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
		And I take screenshot of the page
		And I scroll till "ShoppingCart.orderscheduledconfirmation_message"
		And user verify text "Order scheduled!" in page "ShoppingCart.orderscheduledconfirmation_message"
		And I take screenshot of the page
		When User click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
		And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
		And I click Existing Trade account option "Checkout.existingTradeAcc_radio" without wait
		And I enter Trade account Account number and CID details using given file "OrderInformation.xlsx"
		And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		And I wait for "2" seconds
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		And I verify element "Checkout.deliveryOptions_text" is present on page and display its value in report
		#And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
		And I take screenshot of the page
		And I wait for "3" seconds
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I select trade account radio button and click continue button in section 4 payment method
		And I wait for "2" seconds
		And I enter PO number value "ExistingAcc" in textbox "Checkout.poNumber_textbox"
		And I checks terms and conditions checkbox and click on Submit Order button
		And I take screenshot of the page
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		And I scroll till "Checkout.scheduleConfirmation_message"
		And I verify text  "Requested Delivery Date" in page "Checkout.scheduleConfirmation_message"
		And I verify Scheduled Date in Order Confirmation page
		And I take screenshot of the page

	@DeliveryCharges @Priority3 @nwk @live
	Scenario: Change the Delivery method and verify charges
		Given web site is launched successfully and user "does" accept the cookies
		When customer accesses the website as "register" user
		And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
		And I wait for "3" seconds
		And I verify element "ShoppingCart.shoppingBasket_text" is present on page
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
		And I wait for "8" seconds
		Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
		And I wait for "3" seconds
		And I take screenshot before selecting shipping option
		And select Shipping method option and display its name in report
		And I take screenshot of shipping option checkout section
		And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
		And I wait for "2" seconds
		Then I scroll till "Checkout.deliverySectionContinue_button"
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		And I take screenshot after successfully applying shipping method
		Then I verify shipping charge is applied in Order Total

	@LinenoteShareOrder @ft @eu @apac @nwk @Priority3
	Scenario: Enter the Partno and Line note while placing an order and then share the order
		#----- Registration Steps ----#
		Given web site is launched successfully and user "does" accept the cookies
		And I wait for "3" seconds
		And customer accesses the website as "register" user
		And I save the newly registered "regular" user details
		When I navigate to "Product-Lister-Leaf-L2" page using details from json "pageUrls.json"
		And I wait for "3" seconds
		#----User navigates to PDP and adds product to basket----#
     Then I scroll down the page by pixels "200"
		And I click on the add button "PLP.firstAdd_button"
		And I wait for "3" seconds
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "5" seconds
		And I click on the "ShoppingCart.enteryourPartno_link"
		And I scroll till "ShoppingCart.partNoFirstProductOnCart_textbox"
		And I enter values "Test1" and "123" in textbox "ShoppingCart.partNoFirstProductOnCart_textbox" and "ShoppingCart.lineNoteFirstProductOnCart_textbox" respectively.
		And user take screenshot of the page
		And I click on "ShoppingCart.update_link"
		And I scroll till "ShoppingCart.checkoutNow_button"
		When User click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And I wait for "5" seconds
		And I select credit card or paypal Payment method in section one for DE store
		And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
		And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
		And I wait for "2" seconds
		#----- User enters Address details ----#
		And User fill Checkout Invoice address by entering four characters in auto Search textbox "Calle"
    And I scroll till "Checkout.addressSectionContinue_button"
		And I click on Continue button on Delivery Section "Checkout.addressSectionContinue_button" using js
		And I wait for "5" seconds
		And I scroll till "Checkout.deliverySectionContinue_button"
		And User click on Continue button on Delivery Address Section "Checkout.deliverySectionContinue_button" using js
		#----- User enters Payment Card details ----#
		And I wait for "4" seconds
		And I wait "medium" duration for "Checkout.creditCardNum_textbox" element to "appear"
		And User fill Credit Card Details using given file "OrderInformation.xlsx"
		And I wait for "3" seconds
		And I scroll till "Checkout.paymentDetailsSectionContinue_button"
		And User click on Continue button on Payment Details Section "Checkout.paymentDetailsSectionContinue_button" using js
		And I wait for "5" seconds
		And I wait "short" duration for "Checkout.poNumber_textbox" element to "appear"
		And I enter PO number value "POforLinenoinfo" in textbox "Checkout.poNumber_textbox"
		And I wait for "5" seconds
		And I checks terms and conditions checkbox and click on Submit Order button
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		And user take screenshot of the page
		And I wait for "5" seconds
		#----User shares the order in OrderConfirmation page----#
		And I wait "medium" duration for "Checkout.shareOrder_button" element to "appear"
		And I click "Checkout.shareOrder_button"
		And I wait for "2" seconds
		And I enter value "testuser@premierfarnell.com" in textbox "Checkout.emailOnPopup_textbox"
		And I wait for "2" seconds
		And I click the checkbox "Checkout.shareOrder_checkbox"
		And I click on the button "Checkout.sendOrder_button" using js
		And I wait for "3" seconds
		And user take screenshot of the page
		And I check if the order is sent
		#----User tracks the order and shares the order in Order tracking page----#
		And I wait "medium" duration for "Checkout.trackOrder_button" element to "appear"
		Then I click on track your order button on order confirmation page "Checkout.trackOrder_button"
		And I wait for "5" seconds
		And I click on "OrderHistory.orderSearch_button" using js
		#And I verify element "OrderHistory.firstPONumber_element" is present on page
		And I click on "OrderHistory.firstPONumber_element" using js
		#And I verify element "Test1" is present on page
		And I scroll till "OrderTracking.orderTrackingShare_button"
		And I click on "OrderTracking.orderTrackingShare_button"
		And I wait for "3" seconds
		And I enter value "testuser@premierfarnell.com" in textbox "Checkout.emailOnPopup_textbox"
		And I click the checkbox "Checkout.shareOrder_checkbox"
		And I click the "OrderTracking.sendOrdertracking_button"
		And I wait for "3" seconds
		Then I click on the "OrderTracking.reorder_button"
		And I wait for "5" seconds
		And I scroll up and click on the "Header.miniBasket_link"
		And User click "ShoppingCart.delete_link" using js
		And user take screenshot of the page
		Then I hover on element My Account "Header.myAccount_dropdown"
		And I wait for "2" seconds
		And I click Order history and tracking from the dropdown "Header.trackOrders_link"
		And I wait for "5" seconds
		And I click the POnumber link "OrderHistory.firstPONumber_element" using js
		And I wait for "5" seconds
		And I verify element "OrderHistory.firstPONumber_text" is present on page and display its value in report
		And I scroll till "OrderHistory.addAllToBasket_button"
		And I click on the "OrderHistory.addAllToBasket_button"
		And I wait for "3" seconds
		#----User Logs out----#
		Then I hover on element My Account "Header.myAccount_dropdown"
		Then I click on the "Header.logout_button"
		And user take screenshot of the page

	@paymentwithdifferentCC @Priority2 @sre @agileRegression @nacn
	Scenario Outline: Place order with different credit cards - "<creditCardType>"
		Given web site is launched successfully and user "does" accept the cookies
		And customer accesses the website as "register" user
		And I save the newly registered "regular" user details
		When I click the "Header.searchIcon_button"
		And I wait for "3" seconds
		And I verify element "BrowseForProducts.secondCategory_link" is present on page and display name of First Category in report
		And I click "BrowseForProducts.secondCategory_link"
		And I scroll till "CategoryPage.showAllProducts_button"
		And I click Show all Products button on L0 category page "CategoryPage.showAllProducts_button"
		Then User verify in L0 Category Page element "CategoryPage.section_category" is present on page
		And I save the value of First Order code from PLP table
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
		And I verify mini shopping cart header contains "0" items in "Header.itemsInMiniBasket_text"
		And I wait for "3" seconds
		When I enter the ordercode saved from PLP to update the basket to place order
		And I scroll till "ShoppingCart.updateBasket_button"
		And I wait for "2" seconds
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		And I scroll till "ShoppingCart.updateBasket_button"
		And I wait for "3" seconds
		And I scroll till "Header.itemsInMiniBasket_text"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
		And I wait for "4" seconds
		And I wait "medium" duration for "Checkout.paymentMethod_text" element to "appear"
		And I select credit card or paypal Payment method in section one for DE store
		And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
		Then User verify green tick mark element "Checkout.greenTickMarkSection2_icon" is present on page
		#-------This field is removed asd part of Sprint 67 in checkout in EU----------
#		And User scroll till "Checkout.deliveryInstructions_textbox"
#		And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
		And User take screenshot of the page
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And User take screenshot of the page
		Then User verify green tick mark element "Checkout.greenTickMarkSection3_icon" is present on page
		And enter "<creditCardType>" credit card details from json "creditCards.json"
		And User take screenshot of the page
		And I wait for "10" seconds
		And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		And User take screenshot of the page
		When User enter random PO Number on Order Review section
		And User take screenshot of the page
		And I wait for "10" seconds
		And User checks terms and conditions checkbox and click on Submit Order button
		And user take screenshot of the page
		And I submit details on 3D Auth screen to verify "<creditCardType>" credit card if asked
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		Then User gets Order confirmation Number
		And user take screenshot of the page
		@eu @apac @nwk
		Examples:
			| creditCardType |
			| visa           |
			| mastercard     |
		@eu @naie
		Examples:
			| creditCardType |
			| amex           |
		@us
		Examples:
			| creditCardType |
			| discover       |

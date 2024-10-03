@Agile_Checkout @Team4_Web @web
Feature: Checkout - E2E tests

	Background: Launch homepage for Checkout functionalities
   Given web site is launched successfully and user "does" accept the cookies
   Then customer accesses the website as "userType" user
	
	@E2E_Guest @Guest @GuestCheckoutUsingCreditCard
	Scenario: E2E Guest Checkout - Registering Guest user on OCP page
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "2" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I scroll till "PDPBuyBox.addToCart_button"
		And I wait "short" duration for "Header.itemsInMiniBasket_text" element to "disappear"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "2" seconds
		And I verify element "ShoppingCart.firstProductOnCart_text" is present on page and display its value in report
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Guest - Login Overlay Modal
		And I continue only if guest checkout feature is enabled
		And User click on Checkout Without registering radio button on popup "ShoppingCart.checkoutWithoutRegistering_radio"
		And user take screenshot of the page
		And I populate company details if B2Bonly store and click checkout without registering button
		Then I wait for "5" seconds
		And User take screenshot of the page
		#Section 1 - Your Details
		And User fill Checkout Your details section form using given file "OrderInformation.xlsx"
		And User take screenshot of the page
		And User click on Continue button on Your Details Section "Checkout.yourDetailsSectionContinue_button"
		And I select credit card Payment method in section one for CPC store and continue
		#Section 2 - Invoice and Address Delivery
		And User click on Enter Address Manually Link "Checkout.addAddressManually_link"
		And User fill Checkout Invoice address manually using given file "OrderInformation.xlsx"
		And user take screenshot of the page
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		Then User verify green tick mark element "Checkout.greenTickMarkSection2_icon" is present on page
		#Section 3 - Delivery Method
		And User scroll till "Checkout.deliverySectionContinue_button"
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		Then User verify green tick mark element "Checkout.greenTickMarkSection3_icon" is present on page
		#Section 4 - Payment Details
		And User fill Credit Card Details using given file "OrderInformation.xlsx"
		And user take screenshot of the page
		And I wait for "3" seconds
		And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		And I wait for "3" seconds
		#Section 5 - Order Review
		When User enter random PO Number on Order Review section
		And user take screenshot of the page
		And I wait for "5" seconds
		And User checks terms and conditions checkbox and click on Submit Order button
		And user take screenshot of the page
		And I wait for "4" seconds
		#Order Confirmation
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		Then User gets Order confirmation Number
		And I take screenshot to verify Order Confirmation page is displayed
		And I wait for "5" seconds
		#User registration on Order Confirmation Page
		When user register itself on Order Confirmation Page and click on Create Account button
		And I wait for "3" seconds
		Then user verifies that it lands on the Account Summary Page
		And user take screenshot of the page
		
	@E2E_CreditCard @Register @CheckoutUsingCreditCard
	Scenario: Checkout E2E test - Place order using Credit Card Payment for a Registered user
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I wait "short" duration for "Header.itemsInMiniBasket_text" element to "disappear"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "2" seconds
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Section 1 - Payment Method
		And user take screenshot of the page
		Given I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
		And user click on credit card or existing business account radio button in section 1
		And I click on Continue button on Payment Method section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And I wait for "3" seconds
		#Section 2 - Invoice and Delivery Address
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		And User take screenshot of the page
		And I wait for "3" seconds
		#Section 3 - Delivery Options
		And User take screenshot of the page
		And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		And User take screenshot of the page
		And I wait for "3" seconds
		#Section 4 - Payment Details
		And User fill Credit Card Details using given file "OrderInformation.xlsx"
		And I scroll till "Checkout.paymentDetailsSectionContinue_button"
		And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
		And I wait for "3" seconds
		And User take screenshot of the page
		Then I verify Payment Details section edit button element "Checkout.editPaymentDetails_button" is present on page
		#Section 5 - Order Review
		When User enter random PO Number on Order Review section
		And User take screenshot of the page
		And User checks terms and conditions checkbox and click on Submit Order button
		And I wait for "2" seconds
		And user take screenshot of the page
		And I submit details on 3D Auth screen to verify "visa" credit card if asked
		And I wait for "3" seconds
		#Order Confirmation
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		And user take screenshot of the page
		
	@E2E_Paypal @Register @GuestCheckoutUsingPaypal
	Scenario: Checkout E2E test - Place order using PayPal Payment for a Registered user
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I scroll till "PDPBuyBox.addToCart_button"
		And I wait "short" duration for "Header.itemsInMiniBasket_text" element to "disappear"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		And I wait for "1" seconds
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "3" seconds
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Section 1 - Payment Method
		Given I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
		And user click on paypal or existing business account radio button in section 1
		And User take screenshot of the page
		And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And I wait for "2" seconds
		#Section 2 - Invoice and Delivery Address
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		And User take screenshot of the page
		And I wait for "4" seconds
		#Section 3 - Delivery Options
		And User take screenshot of the page
		And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		And User take screenshot of the page
		And I wait for "4" seconds
		#Section 4 - Payment Details
		And user select paypal radio button and click continue button in section 4 payment method if presented
		And I wait for "4" seconds
		And User take screenshot of the page
		Then I verify Payment Details section edit button element "Checkout.editPaymentDetails_button" is present on page
		#Section 5 - Order Review
		When User enter random PO Number on Order Review section
		And User take screenshot of the page
		And I wait for "4" seconds
		And I check terms and conditions checkbox and click on Paypal button
		And user take screenshot of the page
		And I wait "8" seconds for paypal new window
		#Paypal Modal
		And I switch to Paypal window
		And I verify page title contains "PayPal" in "Checkout.paypalLoginWindow_element"
		And I Login Paypal
		Then I switch to parent window
		And I wait for "8" seconds
		#Order Confirmation
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		And user take screenshot of the page
		
	@E2E_OpenNewTradeAcct @Register @CheckoutByOpeningNewTradeAccount
	Scenario: Checkout E2E test - Place order by Opening a new trade account for a Registered user
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I scroll till "PDPBuyBox.addToCart_button"
		And I wait "short" duration for "Header.itemsInMiniBasket_text" element to "disappear"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		And I wait for "1" seconds
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "3" seconds
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Section 1 - Payment Method
		Given I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
		And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
		And I would like to open a new Trade Account
		And User take screenshot of the page
		And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And I wait for "2" seconds
		#Section 2 - Invoice and Delivery Address
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		And User take screenshot of the page
		And I wait for "4" seconds
		#Section 3 - Delivery Options
		And User take screenshot of the page
		And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		And User take screenshot of the page
		And I wait for "4" seconds
		#Section 4 - Payment Details
		And I select trade account radio button and click continue button in section 4 payment method
		And I wait for "4" seconds
		And I scroll till "Checkout.editPaymentDetails_button"
		And User take screenshot of the page
		Then I verify Payment Details section edit button element "Checkout.editPaymentDetails_button" is present on page
		#Section 5 - Additional Information
		And I fill Additional Information Details for New Trade Account using given file "OrderInformation.xlsx"
		And I wait for "3" seconds
		And User take screenshot of the page
		#Section 6 - Order Review
		When User enter random PO Number on Order Review section
		And I scroll till "Checkout.poNumber_textbox"
		And User take screenshot of the page
		And I wait for "5" seconds
		And User checks terms and conditions checkbox and click on Submit Order button
		And user take screenshot of the page
		#Order Confirmation
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		And user take screenshot of the page
		
	@STM4-2395 @Sprint_70 @TaxExempt @USOnly @Guest

	Scenario Outline: Improve Tax Exempt Journey In The Basket/Checkout For US Guest User
		Given user navigate to "<store>" store homepage and "does" accept the cookies
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "3" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I wait for "2" seconds
		And I click on order code link "Header.miniBasketClose_link"
		And I scroll till "Header.miniBasket_link"
		And I wait for "2" seconds
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "3" seconds
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Guest - Login Overlay Modal
		And I continue only if guest checkout feature is enabled
		And User click on Checkout Without registering radio button on popup "ShoppingCart.checkoutWithoutRegistering_radio"
		And I verify element "ShoppingCart.guestUserTaxExemptContainer_element" is present on page
		And I verify text tax exempt info as "<value>" in page "ShoppingCart.guestUserTaxExemptMessage_text"
		And User take screenshot of the page
		
		@us @live
    Examples:
      | store | value                                                               																															|
      | 	us	| Are you tax exempt? You must Sign-in or Register to place your order tax exempt.																									|
      | es-us	| ¿Está usted exento de impuestos? Por favor ingrese a su cuenta o regístrese para procesar su orden de compra exenta de impuestos.	|
      | pt-BR | Você é isento de taxas? Faça login ou cadastre-se para fazer seu pedido sem impostos.																							|
		
	@STM4-2395 @Sprint_70 @TaxExempt @USOnly @Register
	Scenario Outline: Improve Tax Exempt Journey In The Basket/Checkout For US Registered User
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "3" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I wait for "2" seconds
		And I click on order code link "Header.miniBasketClose_link"
		And I scroll till "Header.miniBasket_link"
		And I wait for "2" seconds
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "3" seconds
		And I verify text tax exempt info as "<value>" in page "ShoppingCart.registerUserTaxExemptMessage_text"
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Section 1 - Payment Method
		And I verify text tax exempt info as "<value>" in page "ShoppingCart.registerUserTaxExemptMessage_text"
		And user take screenshot of the page
		Given I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
		And user click on credit card or existing business account radio button in section 1
		And I click on Continue button on Payment Method section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And I wait for "3" seconds
		#Section 2 - Invoice and Delivery Address
		And I verify text tax exempt info as "<value>" in page "ShoppingCart.registerUserTaxExemptMessage_text"
		And user take screenshot of the page
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		And User take screenshot of the page
		And I wait for "3" seconds
		#Section 3 - Delivery Options
		And I verify text tax exempt info as "<value>" in page "ShoppingCart.registerUserTaxExemptMessage_text"
		And user take screenshot of the page
		And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		And User take screenshot of the page
		And I wait for "3" seconds
		#Section 4 - Payment Details
		And I verify text tax exempt info as "<value>" in page "ShoppingCart.registerUserTaxExemptMessage_text"
		And user take screenshot of the page
		And User fill Credit Card Details using given file "OrderInformation.xlsx"
		And I scroll till "Checkout.paymentDetailsSectionContinue_button"
		And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
		And I wait for "3" seconds
		And User take screenshot of the page
		Then I verify Payment Details section edit button element "Checkout.editPaymentDetails_button" is present on page
		#Section 5 - Order Review (Tax Exempt verified status)
		And I wait for "4" seconds
		And user verify absence of element "ShoppingCart.registerUserTaxExemptMessage_text"
		And user verify text "taxExemptSubtitle" on page "Checkout.taxExemptSubtitle_text"
		And user verify text "taxExemptLabel" on page "Checkout.taxExemptLabel_text"
		And I click on Tax Exempt tooltip on Order Review Section "Checkout.taxExemptTooltip_element"
		And I wait for "2" seconds
		And user verify text "taxExemptTooltip" on page "Checkout.taxExemptTooltip_text"
		And I click on Tax Exempt tooltip on Order Review Section "Checkout.taxExemptTooltip_element"
		And I wait for "2" seconds
		And user verify text "taxExemptDesc" on page "Checkout.taxExemptDesc_text"
		And user take screenshot of the page
		And user click on tax exempt checkbox order review "Checkout.taxExempt_checkbox"
		And user take screenshot of the page
		And I wait for "2" seconds
		And I verify element "Checkout.taxExemptVerifiedIcon_element" is present on page
		And user verify text "taxExemptVerified" on page "Checkout.taxExemptVerified_text"
		And I wait for "2" seconds
		And user take screenshot of the page
			
		@us @live
    Examples:
     | store 	| value 																																														| 
     | 	us		| Tax Exempt can be applied within the checkout at Order Review step. 															|
		
		@Sprint70 @STM4-2427
		Scenario: To Verify Use Export Site Message On Delivery Section
		And I verify element "Header.searchIcon_button" is present on page
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "3" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait for "4" seconds
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait for "3" seconds
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
    And user take screenshot of the page
    And I wait for "3" secondsAnd I wait for "3" seconds
		#Section 1 - Payment Method
		Given I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
		And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
		And I would like to open a new Trade Account
		And User take screenshot of the page
		And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And I wait for "2" seconds
		#Section 2 - Invoice and Delivery Address
		And I wait for "10" seconds
		And User take screenshot of the page
		And I click on delivery address checkbox
		And verify export website link txt is present
		And I wait for "3" seconds
		And I click on export website link
		
	@Sprint71 @STM4-2475 @PrivacyPolicyConsent
  Scenario: To Verify Privacy and Policy Consent in Checkout
    And I verify element "Header.searchIcon_button" is present on page
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "3" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click on order code link "Header.miniBasketClose_link"
    And I scroll till "Header.miniBasket_link"
    And I wait for "2" seconds
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait for "3" seconds
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
    And user take screenshot of the page
    And I wait for "3" seconds
    #Guest - Login Overlay Modal
    And I continue only if guest checkout feature is enabled
    And User click on Checkout Without registering radio button on popup "ShoppingCart.checkoutWithoutRegistering_radio"
    And I populate company details if B2Bonly store and click checkout without registering button
    Then I wait for "8" seconds
    And User take screenshot of the page
    And User fill Checkout Your details section form using given file "OrderInformation.xlsx"
    And User take screenshot of the page   
    Then I wait for "8" seconds
    And I verify text "I have read and agree to the privacy policy of element14 group" in page "Checkout.privacypolicy_labeltxt"
    When user click on privacy policy link "Checkout.privacypolicy_link"
		Then user wait "3" seconds for new window
		And user switch to child window
		And user wait for "2" seconds
		And user verify element "Checkout.privacyPolicyTitle_text" is present on page
		And user verify text privacy policy title as "Privacy Policy" in page "Checkout.privacyPolicyTitle_text"
		And user take screenshot of the page
		And user closed child window and navigate back to parent window
		And user wait for "2" seconds
		And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		And I wait for "3" seconds
		And user take screenshot of the page
		And user verify element "Checkout.requiredfield_text" is present on page
		And user verify text privacy policy error as "*Required Field" in page "Checkout.requiredfield_text"
		And user take screenshot of the page
    And I click on privacy policy checkbox "Checkout.privacypolicy_checkbox" 
    And user take screenshot of the page
		
	@Sprint72 @STM4-2517 @UpdateMarketingEmailOptIn
  Scenario: To verify updated Marketing Email Opt In Option on Checkout Page for UK and DE
    And I verify element "Header.searchIcon_button" is present on page
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "2" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemsInMiniBasket_text" element to "disappear"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait for "2" seconds
    And I verify element "ShoppingCart.firstProductOnCart_text" is present on page and display its value in report
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
    And user take screenshot of the page
    And I wait for "3" seconds
    #Guest - Login Overlay Modal
    And I continue only if guest checkout feature is enabled
    And User click on Checkout Without registering radio button on popup "ShoppingCart.checkoutWithoutRegistering_radio"
    And user take screenshot of the page
    And I populate company details if B2Bonly store and click checkout without registering button
    Then I wait for "5" seconds
    And user take screenshot of the page
    #Section 1 - Your Details
    And user verify element "Checkout.marketingOptIn_text" is present on page
    And user verify contains text "marketingOptInDesc" on page "Checkout.marketingOptIn_text"
    And user take screenshot of the page
    When user click on premier farnell group link "Checkout.premierFarnellGroup_link"
    Then user wait "3" seconds for new window
    And user switch to child window
    And user wait for "2" seconds
    And user verify element "Checkout.termsOfAccessTitle_text" is present on page
    And user verify text terms of Access title as "Terms of Access" in page "Checkout.termsOfAccessTitle_text"
    And user take screenshot of the page
    And user closed child window and navigate back to parent window
    And user wait for "3" seconds
    And user verify element "Checkout.yourDetails_form" is present on page
    And user take screenshot of the page
    And user verify contains text "privacyMoreInfoText" on page "Checkout.privacyMoreInfo_text"
    And user take screenshot of the page
    When user click on privacy policy link "Checkout.privacyPolicy_link"
    Then user wait "3" seconds for new window
    And user switch to child window
    And user wait for "2" seconds
    And user verify element "Checkout.privacyPolicyTitle_text" is present on page
    And user verify text privacy policy title as "Privacy" in page "Checkout.privacyPolicyTitle_text"
    And user take screenshot of the page
    And user closed child window and navigate back to parent window
    And user wait for "3" seconds
    And user verify element "Checkout.yourDetails_form" is present on page
    And user take screenshot of the page
    And User fill Checkout Your details section form using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User click on Continue button on Your Details Section "Checkout.yourDetailsSectionContinue_button"
    And I select credit card Payment method in section one for CPC store and continue
    And I wait for "5" seconds
    And I scroll till "Checkout.signUpMarketingEmail_text"
    And user verify text sign up for marketing email as "Sign up for marketing emails" in page "Checkout.signUpMarketingEmail_text"
    And user take screenshot of the page   
    
    @Sprint73 @STM4-2540 @QuickAddToolMoveToTop @apac @eu
    Scenario: To Verify Quick Add Tool Move To Top in ShoppingBasket
    
    And user wait for "3" seconds 
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait for "2" seconds
    And User take screenshot of the page
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page
    And I clear items from shopping cart if any present
    And I wait for "3" seconds
    And I verify element "ShoppingCart.quickadd_label" is present on page
		And I enter ordercode in textbox "ShoppingCart.firstOrderCode_textbox"		
		And I verify text "1" in page "ShoppingCart.quantity_textbox" with attribute "value"
		And User take screenshot of the page
		And I click "ShoppingCart.addbasket_button"
		And I wait for "2" seconds
		And User take screenshot of the page
		And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
		And I wait for "5" seconds
		And I verify element "ShoppingCart.firstProductOnCart_text" is present on page and display its value in report
		And User take screenshot of the page
		
		@Sprint76 @STM4-2581 @ImproveFirstQuestionOnNewarkCheckout @USOnly @Register		
		Scenario: To verify the first question on billing method in checkout
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I wait "short" duration for "Header.itemsInMiniBasket_text" element to "disappear"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "2" seconds
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Section 1 - Payment Method
		And user take screenshot of the page
		Given I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
		And user take screenshot of the page
		And I verify text "tradeAccountHeaderText" in page "Checkout.tradeaccount_header"
		And user take screenshot of the page
		And I click on newark trade account tooltip on Billing Method Section "Checkout.tradeaccount_tooltip"
		And I wait for "2" seconds
		And user take screenshot of the page
		And user verify text "tradeAccountTooltipText" on page "Checkout.tradeaccount_tooltiptext"
		And user take screenshot of the page
		
		@Sprint77 @STM4-2561 @UserNotReceivingPasswordResetEmail 		
		Scenario: To verify the user not receiving password reset email
		And user click on register link "Header.login_link"
		And user wait for "5" seconds
		And user take screenshot of the page
		And I scroll till "ForgotPassword.forgotYourPassword_link"
		And user click on forgot password link "ForgotPassword.forgotYourPassword_link"
		And user wait for "5" seconds 
		And user take screenshot of the page
		And enter value "automationtest@farnell.com" in textbox "ForgotPassword.email_textbox"
		And user take screenshot of the page
		And user click on forgot password link "ForgotPassword.sendResetLink_button"
		And user wait for "10" seconds
		And user take screenshot of the page
		And user verify text "emailSentTitle" on page "ForgotPassword.resetEmailSent_text"
		And user take screenshot of the page
		And user verify text "SuccessMessageText" on page "ForgotPassword.subtitlesuccessMessage_text"
		And user verify text "loginSuccessMsgText" on page "ForgotPassword.loginSuccessMessage_text"
		And user verify text "tryToRegisterLink" on page "ForgotPassword.tryToRegister_text"
		And user take screenshot of the page
		
		@sprint82 @STM4-2706 @live @ReduceZipCodeFieldLength @canada
		Scenario: To verify zip code field length has been reduced for a Registered user
		And customer accesses the website as "register" user
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I wait "short" duration for "Header.itemsInMiniBasket_text" element to "disappear"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "2" seconds
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Section 1 - Payment Method
		And user take screenshot of the page
		Given I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
		And user take screenshot of the page
		And I click on Continue button on Payment Method section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And I wait for "4" seconds
		#Section 2 - Billing and Shipping Address
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And user clears text from textbox "Checkout.zipCode_textbox"
		And enter value "SE12 6TH" in textbox "Checkout.zipCode_textbox"
		And I press the tab key in "Checkout.zipCode_textbox"
		And user take screenshot of the page
		And I wait for "2" seconds
		And user verify text "zipCodeErrorText" on page "Checkout.zipCodeError_textbox"
		And user take screenshot of the page
		And user clears text from textbox "Checkout.zipCode_textbox"
		And enter value "SE1-6TH" in textbox "Checkout.zipCode_textbox"
		And I press the tab key in "Checkout.zipCode_textbox"
		And user take screenshot of the page
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		And I wait for "3" seconds
		And user take screenshot of the page
		And user click on billing and shipping address edit button "Checkout.editInvoiceAndDeliveryAddress_button" 
		And I wait for "3" seconds
		And user take screenshot of the page
		And user click on billing address edit button "Checkout.editInvoiceAddress_button"
		And user take screenshot of the page
		And user clears text from textbox "Checkout.zipCode_textbox"
		And enter value "SE12 6TH" in textbox "Checkout.zipCode_textbox"
		And I press the tab key in "Checkout.zipCode_textbox"
		And user take screenshot of the page
		And I wait for "2" seconds
		And user verify text "zipCodeErrorText" on page "Checkout.zipCodeError_textbox"
		And user take screenshot of the page
		And I wait for "2" seconds
		And user clears text from textbox "Checkout.zipCode_textbox"
		And enter value "SE126TH" in textbox "Checkout.zipCode_textbox"
		And I press the tab key in "Checkout.zipCode_textbox"
		And user take screenshot of the page
		And user click Save button in Edit Billing Address layout "Checkout.saveAddress_button"
		And user take screenshot of the page
		
		@sprint85 @STM4-2938 @showpasswordloginpage @web
		Scenario: To verify the eye icon in password field
		And I click on  link "Header.login_link"
		And enter value "dfkjgkgewwf@pft.com" in textbox "Login.username_textbox"
		And enter value "Farnell@1234" in textbox "Login.password_textbox"	
		And I verify element "Login.visibilityOfEyeicon" is present on page
		And user take screenshot of the page
		And I verify the eye icon of password field in the page "loginpage"
		
		@sprint85 @STM4-2938 @showpasswordguestloginmodel @web
		Scenario: To verify the eye icon in password field
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "2" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I scroll till "PDPBuyBox.addToCart_button"
	  And I wait "short" duration for "Header.itemsInMiniBasket_text" element to "disappear"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "2" seconds
		And I verify element "ShoppingCart.firstProductOnCart_text" is present on page and display its value in report
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Guest - Login Overlay Modal
		And I continue only if guest checkout feature is enabled
		And user take screenshot of the page
    And enter value "wedugefuv@pft.com" in textbox "Login.username_textbox"
		And enter value "Farnell@1234" in textbox "Login.password_textbox"	
	  And I verify element "Login.visibilityOfEyeicon" is present on page
		And user take screenshot of the page
		And I verify the eye icon of password field in the page "guestloginmodel"
		
		@sprint86 @STM-2707 @ReducePhoneNumberFieldlength @canada @live
		Scenario Outline: To verify phone number field has validations for new user
		And customer accesses the website as "register" user
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
		And I wait "short" duration for "Header.itemsInMiniBasket_text" element to "disappear"
		And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
		And I click on shopping basket icon on header bar "Header.miniBasket_link"
		And I wait for "2" seconds
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Section 1 - Payment Method
		And user take screenshot of the page
		Given I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
		And user click on credit card or existing business account radio button in section 1
		And I click on Continue button on Payment Method section "Checkout.paymentDetailsSectionContinue_button" using js
		Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
		And I wait for "3" seconds
		#Section 2 - Invoice and Delivery Address
		And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
		And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
		And User take screenshot of the page
		And I wait for "3" seconds
		#Section 3 - Delivery Options
		And User take screenshot of the page
		And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
		Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
		And User take screenshot of the page
		And I wait for "3" seconds
		#Section 4 - Payment Details
		And User fill Credit Card Details using given file "OrderInformation.xlsx"
		And user clears text from textbox "Checkout.cardHolderPhone_textbox"
		And enter value "09465756477" in textbox "Checkout.cardHolderPhone_textbox"
		And I press the tab key in "Checkout.cardHolderPhone_textbox"
		And user take screenshot of the page
		And I wait for "2" seconds
		And user verify text "phoneNumberErrortext" on page "Checkout.phoneNumberError_text"
		And user take screenshot of the page
		And I wait for "2" seconds
		And user clears text from textbox "Checkout.cardHolderPhone_textbox"
		And enter value "0946575647" in textbox "Checkout.cardHolderPhone_textbox"
		And I press the tab key in "Checkout.cardHolderPhone_textbox"
		And user take screenshot of the page
		And I scroll till "Checkout.paymentDetailsSectionContinue_button"
		And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button"
		And I wait for "3" seconds
		And User take screenshot of the page
				
		
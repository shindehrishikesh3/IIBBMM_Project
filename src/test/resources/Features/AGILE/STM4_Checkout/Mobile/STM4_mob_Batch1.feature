@Agile_Checkout @Team4_Mob
Feature: Mobile - Checkout Page

	Background: Launch homepage for Checkout functionalities
    Given web site is launched successfully and user "does" accept the cookies
		
	@Sprint71 @STM4-2475 @PrivacyPolicyConsent
  Scenario: To Verify Privacy and Policy Consent in Checkout for AU/NZ
    And I verify element "Header.searchIcon_button" is present on page
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "3" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait for "5" seconds
    And I click on checkout popup button "PDP.checkout_button"
    And I wait for "3" seconds
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
    And user take screenshot of the page
    And I wait for "3" seconds
    #Guest - Login Overlay Modal
    And I continue only if guest checkout feature is enabled
    And I populate company details if B2Bonly store and click checkout without registering button
    Then I wait for "8" seconds
    And User take screenshot of the page
    And I enter random PO Number on account
    And user click on continue button on account "Checkout.continueAccountSection_button"
    Then I wait for "8" seconds
    And User fill mobile checkout Invoice or billing address manually using given file "OrderInformation.xlsx"
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
		And fill Credit Card Details in mobile using given file "OrderInformation.xlsx"
		And user wait for "2" seconds
		And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		And I wait for "3" seconds
		And user take screenshot of the page
		And user verify element "Checkout.requiredfield_text" is present on page
		And user verify text privacy policy error as "Agreement to privacy policy" in page "Checkout.requiredfield_text"
		And user take screenshot of the page
    And I click on privacy policy checkbox "Checkout.privacypolicy_checkbox" 
    And user take screenshot of the page
    And I wait for "3" seconds
    
  @Sprint72 @STM4-2517 @UpdateMarketingEmailOptIn
  Scenario Outline: To verify updated Marketing Email Opt In Option on Checkout Page for UK and DE
    And I verify element "Header.searchIcon_button" is present on page
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait for "5" seconds
    And I click on checkout popup button "PDP.checkout_button"
    And I wait for "3" seconds
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
    And user take screenshot of the page
    And I wait for "3" seconds
    #Guest - Login Overlay Modal
    And I continue only if guest checkout feature is enabled
    And I populate company details if B2Bonly store and click checkout without registering button
    Then I wait for "5" seconds
    And User take screenshot of the page
    And I enter random PO Number on account
    And user click on continue button on account "Checkout.continueAccountSection_button"
    Then I wait for "3" seconds
    And user take screenshot of the page
    #Section 2 - Payment Information
    And I scroll till "Checkout.marketingOptIn_text"
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
    And user verify element "Checkout.marketingOptIn_text" is present on page
    And user take screenshot of the page
    
  @sprint82 @STM4-2786 @live @ReduceZipCodeFieldLength @canada
	Scenario: To verify zip code field has additional validations for registered user
		And customer accesses the website as "register" user
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click on Go to Checkout mini basket button "Header.miniBasketGoToCheckout_button"
		And I wait for "4" seconds
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Section 1 - Order Information(Account)
		And user take screenshot of the page
		And I click on Continue button on Payment Method section "Checkout.continueAccountSection_button" using js
		And I wait for "6" seconds
		#Section 2 - Order Information(Payment Details)
		And user take screenshot of the page
		When I select by visible text in Payment Method type as "Newark Account" from dropdown "Checkout.paymentMethod_dropdown"
		And user take screenshot of the page
		And User fill mobile checkout Invoice or billing address manually using given file "OrderInformation.xlsx"
		And user clears text from textbox "Checkout.zipCode_textbox"
		And enter value "SE12 6TH" in textbox "Checkout.zipCode_textbox"
		And user take screenshot of the page
		And User click on Continue button on Invoice addressSection "Checkout.shippingAddressSectionContinue_button"
		And I wait for "3" seconds
		And user take screenshot of the page
		And User click on Continue button on Delivery Address Section "Checkout.addressSectionContinue_button"
    And user take screenshot of the page
    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And User selects special instructions "other" from dropdown and enter instructions if any
    And User take screenshot of the page
    And User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And I wait for "5" seconds
    And user verify text "mobileZipCodeErrorText" on page "Checkout.zipCodeError_textbox"
		And I click on "Checkout.paymentInformation_section"
		And user take screenshot of the page
		
		@sprint85 @STM4-2938 @showpasswordcheckbox @mob
		Scenario: To verify the eye icon in password field
		And user click on register link "Header.login_link"
		And user wait for "2" seconds
		And enter value "dfkjgkgewwf@pft.com" in textbox "Login.username_textbox"
		And enter value "Farnell@1234" in textbox "Login.password_textbox" 
		And I verify element "Login.showpassword_checkbox" is present on page
		And user take screenshot of the page
		And I verify the eye icon of password field in the page "loginpage"
		
		@sprint86 @STM-2707 @ReducePhoneNumberFieldlength @canada @live
		Scenario Outline: To verify phone number field has validations for new user
		And customer accesses the website as "register" user
		And I verify element "Header.searchIcon_button" is present on page
		When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "2" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click on Go to Checkout mini basket button "Header.miniBasketGoToCheckout_button"
		And I wait for "4" seconds
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And user take screenshot of the page
		And I wait for "3" seconds
		#Section 1 - Order Information(Account)
		And user take screenshot of the page
		And I click on Continue button on Payment Method section "Checkout.continueAccountSection_button" using js
		And I wait for "6" seconds
		#Section 2 - Order Information(Payment Details)
		And user take screenshot of the page
		When I select by visible text in Payment Method type as "Credit/Debit Card" from dropdown "Checkout.paymentMethod_dropdown"
		And user take screenshot of the page
		And User fill mobile checkout Invoice or billing address manually using given file "OrderInformation.xlsx"
		And User fill Credit Card Details in mobile using given file "OrderInformation.xlsx"
		And user clears text from textbox "Checkout.cardHolderPhone_textbox"
		And enter value "12345678900" in textbox "Checkout.cardHolderPhone_textbox"
		And user take screenshot of the page
		And User click on Continue button on payment details section "Checkout.paymentDetailsSectionContinue_button"
		And I wait for "3" seconds
		And user verify text "mobilePhoneNumberErrortext" on page "Checkout.phoneNumberError_text"
		And user take screenshot of the page	
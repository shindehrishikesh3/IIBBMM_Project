@Agile_Checkout @Team4_Mob @mob @EmailVerification
Feature: Checkout Mobile - Email Verification

  Background: Launch homepage for Checkout page
   Given web site is launched successfully and user "does" accept the cookies
   
  @sprint85 @STM4-2868 @E2E_Email_Verification @MyAccount @UpdateThankYouPage
  Scenario: Registering new user through email verification process - Mobile
    And user submits registration form as "Register" user
    And user take screenshot of the page
		And user verifies Thank You page of email verification for "Register" 
		And user take screenshot of the page
		And user clicks on the email verification link
		And user take screenshot of the page
    And user verify text "accountActivatedText" on page "Register.accountActivation_text" from "registration" property file
    And user verify text "tradeAccountText" on page "Register.tradeAccount_text" from "registration" property file
    And user verify successful registraion email is received
    
  @sprint84 @STM4-2780 @LoginWithoutActivation @uk @cpc @cpcireland
  Scenario: To verify the banner when user tries to login without activation
   	And customer registers and login to the website without activation
   	And user wait for "2" seconds
   	And user verify text "Your web account has not yet been activated.Follow these simple steps:" in page "Login.loginWithoutActivation_Text"
   	And user take screenshot of the page
   	And user click on resend activation email button "Login.resendActivationemail_Button"
   	And user wait for "2" seconds
   	And user verify text "Check your Email" in page "Login.checkyourmail_text"
   	And user verify text "Activation email sent" in page "Login.ActivationEmail_text"
   	And user take screenshot of the page
    
  @sprint85 @STM4-2885 @STM4-2868 @EmailVerifyBasket @CheckoutNowModal @UpdateThankYouPage @uk @cpc @cpcireland
  Scenario: New User Registration through Checkout modal on Basket page
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
		And user take screenshot of the page
		And I click on the Register button "ShoppingCart.register_button"
		And I wait for "3" seconds
		And user take screenshot of the page
		And user submits registration form as "Register" user
		And user take screenshot of the page
		And verify element "Register.thankYouTitle_text" is present on page
		And user verifies Thank You page of email verification for "Checkout"
		And user clicks on the email verification link
		And user take screenshot of the page
		#Checkout - Activate Success Banner
		And I verify element "Checkout.regActivateSuccessTitle_text" is present on page
		And user verify text "regActivateSuccessTitleText" on page "Checkout.regActivateSuccessTitle_text" from "checkout" property file
		And user verify text "regActivateSuccessText" on page "Checkout.regActivateSuccess_text" from "checkout" property file
		And user take screenshot of the page
		And user verify successful registraion email is received
		
  @sprint85 @STM4-2779 @STM4-2797 @ResendEmail @uk @cpc @cpcireland
  Scenario: Verify resend email function through registration page
    And user submits registration form as "Register" user
    And user take screenshot of the page
    And verify element "Register.thankYouTitle_text" is present on page
    And user take screenshot of the page
    And I click on the Resend activation email button "Register.resendActivation_button"
    And user take screenshot of the page
    # Check your email page
    And user verify element "Register.checkYourEmail_text" is present on page
    And user verify text "checkYourEmailText" on page "Register.checkYourEmail_text" from "registration" property file
    And user verify text "activationEmailSentText" on page "Register.activationEmailSent_text" from "registration" property file
    And user verify text "emailActivateText" on page "Register.emailActivate_text" from "registration" property file
    And user verify text "receiveEmailCheckEmailText" on page "Register.receiveEmailCheckEmail_text" from "registration" property file
    And user take screenshot of the page
    And user clicks on the email verification link
    And user take screenshot of the page
    # My Account page
    And user verify text "accountActivatedText" on page "Register.accountActivation_text" from "registration" property file
    And user verify text "tradeAccountText" on page "Register.tradeAccount_text" from "registration" property file
    And user verify successful registraion email is received
		
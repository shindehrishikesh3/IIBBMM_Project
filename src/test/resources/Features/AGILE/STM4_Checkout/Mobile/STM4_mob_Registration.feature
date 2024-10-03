@Registration @Team4_Mob @mob
Feature: Mobile - Registration Page

	Background: Launch homepage for Registration functionalities
  Given web site is launched successfully and user "does" accept the cookies
		
	@Sprint71 @STM4-2476 @PrivacyPolicyConsent
	Scenario Outline: New Privacy and Policy consent in Registration Page for AU/NZ
		And user click on register link "Header.login_link"
		And user wait for "3" seconds
		And user click on register now button "Register.registerNow_button"
		And user wait for "2" seconds
		And user scroll till "Register.privacyPolicyConsent_checkbox"
		And user wait for "2" seconds
		And user verify element "Register.privacyPolicyConsent_checkbox" is present on page
		And user verify text new privacy and policy as "<value>" in page "Register.privacyPolicyConsent_text"
		And user take screenshot of the page
		#Terms and Conditions link
		When user click on terms & conditions link "Register.termsConditions_link"
		Then user wait "4" seconds for new window
		And user switch to child window
		And user wait for "2" seconds
		And user verify element "Register.termsConditionsTitle_text" is present on page
		And user verify text terms & conditions title as "Terms & Conditions of Sale" in page "Register.termsConditionsTitle_text"
		And user take screenshot of the page
		And user closed child window and navigate back to parent window
		And user wait for "2" seconds
		And user verify element "Register.registerTitle_text" is present on page
		#Privacy Policy link
		When user click on privacy policy link "Register.privacyPolicy_link"
		Then user wait "4" seconds for new window
		And user switch to child window
		And user wait for "2" seconds
		And user verify element "Register.privacyPolicyTitle_text" is present on page
		And user verify text privacy policy title as "Privacy Policy" in page "Register.privacyPolicyTitle_text"
		And user take screenshot of the page
		And user closed child window and navigate back to parent window
		And user wait for "2" seconds
		And user verify element "Register.registerTitle_text" is present on page
		And user click on register button "Register.register_button"
		And user take screenshot of the page
		And user verify element "Register.privacyPolicyConsentError_link" is present on page
		And user verify text privacy policy error as "<error>" in page "Register.privacyPolicyConsentError_text"
		And user scroll till "Register.privacyPolicyConsent_checkbox"
		And user take screenshot of the page
		
		@au @nz @live
    Examples:
    | value                                                               									 | error 																								 | 
    | I have read and agree to the terms & conditions and privacy policy of element14 group* | Agreement to the terms & conditions and privacy policy|
    
  @Sprint72 @STM4-2517 @UpdateMarketingEmailOptIn
  Scenario Outline: To verify updated Marketing Email Opt In Option on Registration Page for UK and DE
    And user click on register link "Header.login_link"
    And user wait for "3" seconds
    And user click on register now button "Register.registerNow_button"
    And user wait for "3" seconds
    And user scroll till "Register.marketingOptIn_text"
    And user wait for "2" seconds
    And user take screenshot of the page
    And user verify element "Register.marketingOptIn_text" is present on page
    And user verify text marketing opt in "<value>" in page "Register.marketingOptIn_text"
    And user take screenshot of the page
    When user click on premier farnell group link "Register.premierFarnellGroup_link"
    Then user wait "3" seconds for new window
    And user switch to child window
    And user wait for "2" seconds
    And user verify element "Register.termsOfAccessTitle_text" is present on page
    And user verify text terms of Access title as "Terms of Access" in page "Register.termsOfAccessTitle_text"
    And user take screenshot of the page
    And user closed child window and navigate back to parent window
    And user wait for "2" seconds
    And user verify element "Register.registerTitle_text" is present on page
    
    @uk @de @live
    Examples:
    | value                                                                                                                                                                        | 
    | Yes sign me up for marketing emails, including exclusive special offers, new products and suppliers, event invitations and the latest content from the Premier Farnell Group.|
  	
  @sprint82 @STM4-2786 @live @ReduceZipCodeFieldLength
	Scenario Outline: To verify zip code field has additional validations for new user
		And user click on register link "Header.login_link"
		And user wait for "3" seconds
		And user enter details on the registration page with "zipcode" as "<zipcode>"
		And user take screenshot of the page
		And user wait for "3" seconds
		And user click on register now button "Register.register_button"
		And user wait for "5" seconds
		And user verify element "Register.zipCodeError_text" is present on page
		And user verify text "Postal Code has exceeded the 7 character limit. Please reduce the number of characters and try again." in page "Register.zipCodeError_text"
		And user take screenshot of the page
		
		@canada
    Examples:
    | zipcode		|
    |	SE12 6TH	|
    | f-rne  l	|
    | f12   ll	|
    | f- n l l	|
    
    @sprint86 @STM-2707 @ReducePhoneNumberFieldlength @live
    Scenario Outline: To verify phone number field has validations for new user
    And user click on register link "Header.login_link"
		And user wait for "3" seconds 
		And user enter details on the registration page with "phonenumber" as "<phonenumber>"
		And user take screenshot of the page
		And user click on register button "Register.register_button"
		And user wait for "5" seconds
		And user verify element "Register.phoneNumberError_text" is present on page
		And user verify text "Phone Number has exceeded the 10 character limit. Please reduce the number of characters and try again." in page "Register.phoneNumberError_text"
		And user take screenshot of the page
		
		@canada
    Examples:
    | phonenumber		|
    |	94374386543   |
    | 4@2343242343  |
    | 9-&4564863434 |

    @sprint86 @STM4-2626 @CantAcceptKoreanCharacters @kr @live
		Scenario: Add banner to show we cant accept Korean characters on Registration Page in Korea store
		And user click on register link "Header.login_link"
    And user wait for "3" seconds
    And user click on register now button "Register.registerNow_button"
    And user wait for "3" seconds
		And user verify element "Register.requiredMsg_text" is present on page
		And user take screenshot of the page
		#Verify New Korea Banner
		And user verify element "Register.bannerKorea_text" is present on page
		And user verify text "koreaBannerText" on page "Register.bannerKorea_text" from "registration" property file
		And user take screenshot of the page

    
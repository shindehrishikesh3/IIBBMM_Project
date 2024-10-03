#Author: saseelam@in.ibm.com (In progress)
@mobAgileRegression @mobValidationTests @mobRegistration
Feature: Regression on Registraion page

   @mobRegistration @ui @eu @apac @nwk @live
   Scenario: Verification of Mobile Registration form
      Given web site is launched successfully and user "does" accept the cookies
      When user verify if the element contains "Register" as partial text in "Register.register_link"
      And user click on the register link "Register.register_link"
      And user verify text "Register Now" in page "Register.registerNow_button"
      And user verify background color of 'Register Now' as "Green,#41c363,Register.registerNow_button"
      And user click "Register.registerNow_button"
      And I wait for "3" seconds
      Then user verify text "Register" in page "Register.registerTitle_text"
      And user verify text "Register now and enjoy features" in page "Register.registrationBenefitDesc_text" for "APAC" region/store
      And user verify text "Reasons to register with us" in page "Register.reasonsToRegisterTitle_text" for "APAC" region/store
      And user verify element contains "Already registered?" as partial text in "Register.alreadyRegistered_text"
      And user verify text "Log In" in page "Register.login_link"
      And user verify text "*Required Field" in page "Register.requiredField_text"
      And user verify text "Email and Password" in page "Register.usrnameAndPwdTitle_text"
      And user verify text "*Email" in page "Register.usrname_label"
      And user verify text "*Password" in page "Register.password_label"
      And user verify text "Show password" in page "Register.showPassword_text"
      And user verifies the name and address input labels "Register.nameAndAddressFormfields_list" on the registration form using "MobileRegistrationRegression.xlsx" file
      And user verify below are displayed in "Register.passwordValidation_list" table on page
         | 8 or more characters                |
         | Include a lower case letter (a-z)   |
         | Include a uppercase character (A-Z) |
         | Include a number (0-9)              |
      # |Include a special character (!&#@,..)  |
      And user verify text "Your information" in page "Register.yourInformationTitle_text"
      And user verify if the element contains "We need this information from you to provide you with the products and services you order and to manage your account." as partial text in "Register.yourInformationDetail_text"
      When scroll till "Register.yourInformationTitle_text"
      And I wait for "2" seconds
      And user verify link "Register.privacyPolicy_link" is present in the your information detailed information
      And user verify text "Privacy Policy" in page "Register.privacyPolicy_link"
      # And user verify text "Preferences" in page "Register.preferencesSectionTitle_text"
      # And user verify text "How should we contact you?" in page "Register.howShouldWeContactYou_text" for "EUROPE,APAC" region/store
      And user verify text "Account Type" in page "Register.accountTypeTitle_text" for "NEWARK" region/store
      And user verify element "Register.Business_radio" is present on "NEWARK" region/store
      And user verify element "Register.Personal_radio" is present on "NEWARK" region/store
      And user verify text "Business" in page "Register.Business_label" for "NEWARK" region/store
      And user verify text "Personal" in page "Register.Personal_label" for "NEWARK" region/store
      # And user verifies the contact preference details "Register.contactPreferences_list" on the registration form using "MobileRegistrationRegression.xlsx" file in "EUROPE,APAC" regions
      And user verify element "Register.register_button" is present on page
      And user verify text "Register" in page "Register.register_button" with attribute "value"
      And user verify background color of 'Register button' as "Green,#41c363,Register.register_button"

   @invalidPwd @errorValidation @eu @apac @nwk @live
   Scenario: Error Message when Password is Invalid
      Given web site is launched successfully and user "does" accept the cookies
      When user click on the register link "Register.register_link"
      And user click "Register.registerNow_button"
      And user wait for "3" seconds
      And user enters customer data with "INVALID_PASSWORD" details in registration page from "MobileRegistrationRegression.xlsx" file
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user click "Register.register_button"
      And user wait for "3" seconds
      Then user verify text "Please correct the following fields:" in page "Register.singleErrMessageHeading_text"
      And user verify text color of the error message heading as "Red,#d9534f,Register.singleErrMessageHeading_text"
      And user verify text of 'Please correct the following fields:' is Bold "Register.singleErrMessageHeading_text"
      And user verify if the invalid input fields "password" are displayed in the error message "Register.errInputFieldsInSingleError_list"
      And user verify color of elements text in "Register.errInputFieldsInSingleError_list" list as "Red,#d9534f"
      And user verify color of elements text in "Register.passwordValidation_list" list as "Red,#ff0000&&#007f3b"
      And user take screenshot of the error message displayed on page

   @invalidDetails @errorValidation @eu @apac @nwk @live
   Scenario: Error message when Password and Email are Invalid
      Given web site is launched successfully and user "does" accept the cookies
      When user click on the register link "Register.register_link"
      And user click "Register.registerNow_button"
      And user wait for "3" seconds
      And user enters customer data with "INVALID_USRNAME_PWD_EMAIL" details in registration page from "MobileRegistrationRegression.xlsx" file
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user click "Register.register_button"
      And user wait for "3" seconds
      And user verify text "Please correct the following fields:" in page "Register.singleErrMessageHeading_text"
      And user verify text color of the error message heading as "Red,#d9534f,Register.singleErrMessageHeading_text"
      And user verify text of 'Please correct the following fields:' is Bold "Register.singleErrMessageHeading_text"
      And user verify if the invalid input fields "email#password" are displayed in the error message "Register.errInputFieldsInSingleError_list"
      And user verify color of elements text in "Register.errInputFieldsInSingleError_list" list as "Red,#d9534f"
      And user verify color of elements text in "Register.passwordValidation_list" list as "Red,#ff0000&&#007f3b"
      And user take screenshot of the error message displayed on page

   @blankInput @errorValidation @eu @apac @nwk @live
   Scenario: Error Message when only partial input fields are blank
      Given web site is launched successfully and user "does" accept the cookies
      When user click on the register link "Register.register_link"
      And user click "Register.registerNow_button"
      And user wait for "3" seconds
      And user enters customer data with "BLANK_PARTIAL_INPUT_FIELDS" details in registration page from "MobileRegistrationRegression.xlsx" file
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user click "Register.register_button"
      And user wait for "3" seconds
      Then user verify text "Please enter all required information. The following was not entered:" in page "Register.singleErrMessageHeading_text"
      And user verify text color of the error message heading as "Red,#d9534f,Register.singleErrMessageHeading_text"
      And user verify text of 'Please enter all required information' is Bold "Register.singleErrMessageHeading_text"
      And user verifies if "email#password#primaryjob#firstname#title" input fields displayed on blank error message "Register.errInputFieldsInSingleError_list" when user enters data from "MobileRegistrationRegression.xlsx" file in "EU,APAC" regions
      And user verifies if "email#password#primaryjob#firstname" input fields displayed on blank error message "Register.errInputFieldsInSingleError_list" when user enters data from "MobileRegistrationRegression.xlsx" file in "NEWARK" regions
      And user verify color of elements text in "Register.errInputFieldsInSingleError_list" list as "Red,#d9534f"
      And user verify color of elements text in "Register.passwordValidation_list" list as "Red,#ff0000"
      And user take screenshot of the error message displayed on page

   # @existingUname @errorValidation @eu @apac @nwk @live
   # Scenario: Registration with existing username
   #    Given web site is launched successfully and user "does" accept the cookies
   #    When user click on the register link "Register.register_link"
   #    And user click "Register.registerNow_button"
   #    And user wait for "3" seconds
   #    And user enters customer data with "EXISTING_REGISTERED_USERNAME" details in registration page from "MobileRegistrationRegression.xlsx" file
   #    And user take screenshot of the details entered in the registration page
   #    And user scroll down the page by pixels "200"
   #    And user take screenshot of the details entered in the registration page
   #    And user scroll down the page by pixels "200"
   #    And user take screenshot of the details entered in the registration page
   #    And user click "Register.register_button"
   #    And user wait for "3" seconds
   #    And user verify text "Please correct the following fields:" in page "Register.singleErrMessageHeading_text"
   #    And user verify text color of the error message heading as "Red,#d9534f,Register.singleErrMessageHeading_text"
   #    And user verify text of 'Please correct the following fields:' is Bold "Register.singleErrMessageHeading_text"
   #    And user verify if the existing user error "Register.existingUserError_text" displayed on page when "EXISTING_REGISTERED_USERNAME" is entered using "MobileRegistrationRegression.xlsx" file
   #    And user verify text color of the existing username error message as "Red,#d9534f,Register.existingUserError_text"
   #    And user take screenshot of the error message displayed on page

   @blankPwd @errorValidation @eu @apac @nwk @live
   Scenario: Error message when only Password is blank
      Given web site is launched successfully and user "does" accept the cookies
      When user click on the register link "Register.register_link"
      And user click "Register.registerNow_button"
      And user wait for "3" seconds
      And user enters customer data with "BLANK_PASSWORD" details in registration page from "MobileRegistrationRegression.xlsx" file
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user click "Register.register_button"
      And user wait for "3" seconds
      Then user verify text "Please enter all required information. The following was not entered:" in page "Register.singleErrMessageHeading_text"
      And user verify text color of the error message heading as "Red,#d9534f,Register.singleErrMessageHeading_text"
      And user verify text of 'Please enter all required information' is Bold "Register.singleErrMessageHeading_text"
      And user verifies if "password" input fields displayed on blank error message "Register.errInputFieldsInSingleError_list" when user enters data from "MobileRegistrationRegression.xlsx" file
      And user verify color of elements text in "Register.errInputFieldsInSingleError_list" list as "Red,#d9534f"
      And user verify color of elements text in "Register.passwordValidation_list" list as "Red,#ff0000"
      And user take screenshot of the error message displayed on page

   # @blankCreds @errorValidation @eu @apac @nwk @live
   # Scenario: Error message when Username and Password are blank
   #    Given web site is launched successfully and user "does" accept the cookies
   #    When user click on the register link "Register.register_link"
   #    And user click "Register.registerNow_button"
   #    And user wait for "3" seconds
   #    And user enters customer data with "BLANK_USRNAME_PWD" details in registration page from "MobileRegistrationRegression.xlsx" file
   #    And user take screenshot of the details entered in the registration page
   #    And user scroll down the page by pixels "200"
   #    And user take screenshot of the details entered in the registration page
   #    And user scroll down the page by pixels "200"
   #    And user take screenshot of the details entered in the registration page
   #    And user click "Register.register_button"
   #    And user wait for "3" seconds
   #    Then user verify text "Please enter all required information. The following was not entered:" in page "Register.singleErrMessageHeading_text"
   #    And user verify text color of the error message heading as "Red,#d9534f,Register.singleErrMessageHeading_text"
   #    And user verify text of 'Please enter all required information' is Bold "Register.singleErrMessageHeading_text"
   #    And user verifies if "password" input fields displayed on blank error message "Register.errInputFieldsInSingleError_list" when user enters data from "MobileRegistrationRegression.xlsx" file
   #    And user verify color of elements text in "Register.errInputFieldsInSingleError_list" list as "Red,#d9534f"
   #    And user verify color of elements text in "Register.passwordValidation_list" list as "Red,#ff0000"
   #    And user take screenshot of the error message displayed on page

   @blankData @errorValidation @eu @apac @live
   Scenario: Error message when customer data entered is both blank and invalid
      Given web site is launched successfully and user "does" accept the cookies
      When user click on the register link "Register.register_link"
      And user click "Register.registerNow_button"
      And user wait for "3" seconds
      And user enters customer data with "BLANK_AND_INVALID_CUSTOMER_DATA" details in registration page from "MobileRegistrationRegression.xlsx" file
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user click "Register.register_button"
      And user wait for "3" seconds
      Then user verify text "Please enter all required information. The following was not entered:" in page "Register.errMsgHeadingOfBlankFieldsInMulErrors_text"
      And user verify text color of the error message heading as "Red,#d9534f,Register.errMsgHeadingOfBlankFieldsInMulErrors_text"
      And user verify text of 'Please enter all required information.' is Bold "Register.errMsgHeadingOfBlankFieldsInMulErrors_text"
      And user verifies if "lastname#primaryuse" input fields displayed on blank error message "Register.blankInputFieldLabelsInMulErrors_list" when user enters data from "MobileRegistrationRegression.xlsx" file
      And user verify color of elements text in "Register.blankInputFieldLabelsInMulErrors_list" list as "Red,#d9534f"
      And user verify text "Please correct the following fields:" in page "Register.errMsgHeadingOfInvalidDataInMulErrors_text"
      And user verify text color of the error message heading as "Red,#d9534f,Register.errMsgHeadingOfInvalidDataInMulErrors_text"
      And user verify text of 'Please correct the following fields:' is Bold "Register.errMsgHeadingOfInvalidDataInMulErrors_text"
      And user verify color of elements text in "Register.errMsgHeadingOfInvalidDataInMulErrors_text" list as "Red,#d9534f"
      And user verify if the invalid input fields "password#email" are displayed in the error message "Register.errInvalidInputFieldsInMulErrors_list"
      And user verify text "Please enter a valid Email Address" in page "Register.emailInLineErrorMessage_text"
      And user verify text color of 'Inline error message-Please enter a valid Email Address' as "Red,#ff0000,Register.emailInLineErrorMessage_text"
      And user verify text of 'Inline error message-Please enter a valid Email Address' is Bold "Register.emailInLineErrorMessage_text"
      And user scroll down the page by pixels "300"
      And user take screenshot of the error message displayed on page


   @blankInput @errorValidation @eu @apac @nwk @live
   Scenario: Error message when all input fields are blank
      Given web site is launched successfully and user "does" accept the cookies
      When user click on the register link "Register.register_link"
      And user click "Register.registerNow_button"
      And user wait for "3" seconds
      And user enters customer data with "ALL_BLANK_INPUT_FIELDS" details in registration page from "MobileRegistrationRegression.xlsx" file
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user scroll down the page by pixels "200"
      And user take screenshot of the details entered in the registration page
      And user click "Register.register_button"
      And user wait for "3" seconds
      Then user verify text "Please enter all required information. The following was not entered:" in page "Register.singleErrMessageHeading_text"
      And user verify text color of the error message heading as "Red,#d9534f,Register.singleErrMessageHeading_text"
      And user verify text of 'Please enter all required information.' is Bold "Register.singleErrMessageHeading_text"
      And user verifies if "all" input fields displayed on blank error message "Register.errInputFieldsInSingleError_list" when user enters data from "MobileRegistrationRegression.xlsx" file
      And user verify color of elements text in "Register.errInputFieldsInSingleError_list" list as "Red,#d9534f"
      And user verify color of elements text in "Register.passwordValidation_list" list as "Red,#ff0000"
      And user take screenshot of the error message displayed on page

   @mobRegistration @functionalValidation @eu @apac @nwk
   Scenario: To Verify User is able to register succesfully in mobile
      Given web site is launched successfully and user "does" accept the cookies
      And customer accesses the website as "register" user
      And save the newly registered "regular" user details
      And verify element "Home.username_text" is present on page
      Then customer take screenshot of the homepage after succesful registration
      And user click "Home.navToggle_button"
      And user click "Header.logOut_button"
      Then customer take screenshot of the login page after logout
      When last registered "regular" user login to website successfully
      And wait for "3" seconds
      Then verify element "Home.username_text" is present on page
      And customer take screenshot of the homepage after succesful login



#Author: Naina Vaish
@loginpage @mobAgileRegression @mobValidationTests
Feature: Login Page Regression

  @login @ui @eu @apac @nwk @live
  Scenario: Validate the UI text and fields for Login page with valid credentials
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And user click on "Header.login_link"
    Then user wait for "3" seconds
    And user verify text "Log In" in page "Login.logInHeading_text"
    And user take screenshot of Login page with blank details
    And user verify text "New customer?" in page "Login.newCustomer_text"
    And user verify text "Returning Customer" in page "Login.returningCustomer_text"
    And user verify text "You have already registered to this site, please log in. If you need help please contact us on contact customer service." in page "Login.section_text"
    And user verify text "Register Now" in page "Register.registerNow_button"
    And user verify element "Register.registerNow_button" is present on page
    And user verify text "*Required Field" in page "Login.requiredField_text"
    And user verify text "Email or username" in page "Login.username_label"
    And user verify text "*Password" in page "Login.password_label"
    And user verify link "Login.forgotYourPassword_link" is present on page
    And user verify link "Login.forgotYourUsername_link" is present on page
    And user verify text "Forgotten your password?" in page "Login.forgotYourPassword_link"
    And user verify text "Forgotten your username?" in page "Login.forgotYourUsername_link"
    And user verify element "Login.login_button" is present on page
    And user click "Login.customerService_link"
    Then user wait for "4" seconds
    And user verify text "> Contact Us" in page "ContactUs.breadcrumbContactUs_text" for "EU,APAC" region/store
    And user verify text "Contact Us" in page "ContactUs.contctUsHeading_text" for "EU,APAC" region/store
    And user verify text "Contact Us" in page "ContactUs.contctUsHeadingNWK_text" for "NEWARK" region/store
    Then customer accesses the website as "login" user

  @login @errorValidation @eu @apac @nwk
  Scenario Outline: Validate the error message for login page
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And user click on "Header.login_link"
    Then user wait for "3" seconds
    And user verify element "Login.logInHeading_text" is present on page
    And user wait for "3" seconds
    And user click on "Login.login_button" using js
    And user take screenshot of the page to see the error messages
    And user wait for "3" seconds
    Then user verify text of "Please enter all required information. The following was not entered:" in page "Login.topHeaderError_text"
    And user verify text color of 'error message' heading as "Red,#d9534f,Login.topHeaderError_text"
    And user verify text of 'error message' heading is Bold "Login.topHeaderError_text"
    And user verify text of "Username" in page "Login.usernameError_text"
    And user verify text of "Password" in page "Login.passwordError_text"
    And user verify text "Email or username" in page "Login.username_label"
    And user verify text color of '*Email or username error message' heading as "Red,#d9534f,Login.username_label"
    And user verify text of '*Email or username error message' heading is Bold "Login.username_label"
    And user verify text "*Password" in page "Login.password_label"
    And user verify text color of '*Password error message' heading as "Red,#d9534f,Login.password_label"
    And user verify text of '*Password error message' heading is Bold "Login.password_label"
    When user enter value "<InvalidUsername>" in textbox "Login.username_textbox"
    And user enter value "<InvalidPassword>" in textbox "Login.password_textbox"
    And user click on "Login.login_button" using js
    And user wait for "3" seconds
    And user take screenshot to view the invalid data error page
    Then user verify text of "Please correct the following fields:" in page "Login.topHeaderError_text"
    And user verify text color of 'error message' heading as "Red,#d9534f,Login.topHeaderError_text"
    And user verify text of 'error message' heading is Bold "Login.topHeaderError_text"
    And user verify text of "Either the email/username or password is incorrect. Please check and re-enter the information again." in page "Login.invalidUsernameOrPassword_text"
    And user verify text color of 'error message' heading as "Red,#d9534f,Login.invalidUsernameOrPassword_text"
    And user clears text from textbox "Login.password_textbox"
    And user click on "Login.login_button" using js
    And user verify text of "Please enter all required information. The following was not entered:" in page "Login.topHeaderError_text"
    And user verify text of "Password" in page "Login.passwordError_text"
    And user clears text from textbox "Login.username_textbox"
    And user enter value "<InvalidPassword>" in textbox "Login.password_textbox"
    And user click on "Login.login_button" using js
    And user verify text of "Please enter all required information. The following was not entered:" in page "Login.topHeaderError_text"
    And user verify text of "Username" in page "Login.usernameError_text"

    Examples: 
      | InvalidUsername | InvalidPassword |
      | test            | test            |

  @changePwd @registeredUser @priority4 @eu @apac @nwk @live
  Scenario: Validate user is able to change the password successfully and able to login with new password
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    Then he save the newly registered "regular" user details
    And wait for "3" seconds
    And he click on Navigation Toggle Bar on Home page "Home.navigationToggleBar_button"
    And wait for "4" seconds
    Then click My Account link "Home.myAccount_link"
    And wait for "7" seconds
    And click on profile information button "AccountSummary.editProfile_button"
    Then I enter password type as "current" password in "AccountSummary.currentPassword_input" field
    And enter value "Avnet@1234" in textbox "Login.password_textbox"
    And enter value "Avnet@1234" in textbox "AccountSummary.confirmPassword_input"
    Then click on "AccountSummary.changePassword_button"
    And wait for "3" seconds
    Then click on Navigation Toggle Bar on Home page "Home.navigationToggleBar_button"
    And click on "Header.logOut_button"
    And wait for "3" seconds
    When customer enter registered username
    And enter value "Avnet@1234" in textbox "Login.password_textbox"
    And click on "Login.login_button" using js
    Then he wait "long" duration for "Home.username_text" element to "appear"

  @fusername @singleuser @multiuser @functionalValidation @eu @apac @nwk @live
  Scenario Outline: To validate the functionality of forgot your username on PF website for single/multi user
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "Guest" user
    Then user click on "Header.login_link"
    When user click on "Login.forgotYourUsername_link"
    And wait for "3" seconds
    And user enter value "<email>" in textbox "ForgotYourUsername.email_textbox"
    And user verify link "Login.forgotYourPassword_link" is present on retrieve username page
    And user take screenshot of the enter details page for forgot username
    And user click on "ForgotYourUsername.sendUsername_button"
    And user take screenshot of the success forgot username page
    Then user verify element "ForgotYourUsername.userNameHasBeenSent_text" is present on page and display 'Username has been sent' in report
    Then user verify element "ForgotYourUsername.emailDescription_text" is present on page and display 'If the name and email you entered belongs to a Premier Farnell account, we will recover your username.' in report

    Examples: 
      | email         |
      | test@test.com |

  @fusername @singleuser @multiuser @UiValidation @eu @apac @nwk @live
  Scenario Outline: To validate the UI Validation & functionality of forgot your username on PF website for single/multi user
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "Guest" user
    Then user click on "Header.login_link"
    When user click on "Login.forgotYourUsername_link"
    And wait for "3" seconds
    And user take screenshot of the enter details page for forgot username
    And user verify text of "Forgotten your username?" in page "ForgotYourUsername.forgottenYourUsername_text"
    And user verify text of "Retrieve Username" in page "ForgotYourUsername.subTitleDescription_element"
    And user verify text of "It happens from time to time. We're here to help you." in page "ForgotYourUsername.mobileDescriptionOne_element"
    And user verify text of "Enter your email and we will recover your username for you." in page "ForgotYourUsername.mobileDescriptionTwo_element"
    And user verify text of "*Required Field" in page "ForgotYourUsername.requiredFieldsMessage_text"
    And user verify text of "* Email" in page "ForgotYourUsername.email_label"
    And user verify link "Login.forgotYourPassword_link" is present on retrieve username page
    Then user verify text of "Forgotten your password?" in page "Login.forgotYourPassword_link"
    When user enter value "<email>" in textbox "ForgotYourUsername.email_textbox"
    And user click on "ForgotYourUsername.sendUsername_button"
    And wait for "3" seconds
    And user verify text of "Username has been sent" in page "ForgotYourUsername.userNameHasBeenSent_text"
    And user take screenshot of the success forgot username page
    And user verify text of "If the name and email you entered belongs to a Premier Farnell account, we will recover your username." in page "ForgotYourUsername.emailDescription_text"
    Then user verify text color of 'Username has been sent' heading as "Green,#3a9c54,ForgotYourUsername.userNameHasBeenSent_text"

    Examples: 
      | email         |
      | test@test.com |

  @fusername @singleuser @multiuser @errorValidation @eu @apac @nwk @live
  Scenario Outline: To validate error functionality of forgot your username on PF website for single/multi user
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "Guest" user
    Then user click on "Header.login_link"
    When user click on "Login.forgotYourUsername_link"
    And user enter value "<InvalidEmail>" in textbox "ForgotYourUsername.email_textbox"
    And user click on "ForgotYourUsername.sendUsername_button"
    And user take screenshot of the error page for forgot username
    Then user verify text of "Please enter a valid Email Address" in page "ForgotYourUsername.enterValidEmailAddress_text"
    And user verify text color of 'error message' heading as "Red,#ff0000,ForgotYourUsername.enterValidEmailAddress_text"
    And user verify text of 'error message' heading is Bold "ForgotYourUsername.enterValidEmailAddress_text"
    And user verify border color of email text box as "Red,#d9534f,ForgotYourUsername.email_textbox"
    And user clears text from textbox "ForgotYourUsername.email_textbox"
    And user wait for "4" seconds
    And user click on "ForgotYourUsername.sendUsername_button" using js
    And user wait for "4" seconds
    Then user verify text of "Please enter a valid Email Address" in page "ForgotYourUsername.enterValidEmailAddress_text"
    And user verify text color of 'error message' heading as "Red,#ff0000,ForgotYourUsername.enterValidEmailAddress_text"
    And user verify text of 'error message' heading is Bold "ForgotYourUsername.enterValidEmailAddress_text"
    And user verify text color of 'required field message' heading as "Red,#ff0000,ForgotYourUsername.enterValidEmailAddress_text"
    And user verify border color of email text box as "Red,#d9534f,ForgotYourUsername.email_textbox"

    Examples: 
      | InvalidEmail |
      | pf_yahoo     |

  @fpwd @singleuser @functionalValidation @regfpwd @eu @apac @nwk @live
  Scenario: To validate the functionality of forgot your password on PF website for single user
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "Guest" user
    Then user click on "Header.login_link"
    When user click on "Login.forgotYourPassword_link"
    And user enters email in "ForgotPassword.email_textbox" for "single" username
    And user verify link "Login.forgotYourUsername_link" is present on retrieve username page
    And user take screenshot of the enter details page for forgot password
    And user click on "ForgotPassword.sendResetLink_button"
    And user take screenshot of the success forgot password page
    Then user verify element "ForgotPassword.resetEmailSent_text" is present on page and display 'Reset email sent' in report
    Then user verify element "ForgotPassword.emailDescriptionOne_element" is present on page and display 'Farnell has sent an email with a link to reset your password to:' in report
    Then user verify element "ForgotPassword.userEmailID_text" is present on page and display 'user email address' in report
    Then user verify element "ForgotPassword.emailDescriptionTwo_element" is present on page and display 'Did not receive the email? Please check that you have a Farnell account, the spelling of the email address and your spam folder.' in report

  @fpwd @multiuser @functionalValidation @regfpwd @eu @apac @nwk
  Scenario: To validate the functionality of forgot your password on PF website for multi user
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "Guest" user
    Then user click on "Header.login_link"
    When user click on "Login.forgotYourPassword_link"
    And user enters email in "ForgotPassword.email_textbox" for "multiple" username
    And user verify link "Login.forgotYourUsername_link" is present on retrieve username page
    And user take screenshot of the enter details page for forgot password
    And user click on "ForgotPassword.sendResetLink_button"
    And I wait "long" duration for "ForgotPassword.enhanceMultiuser_text" element to "appear"
    And user take screenshot of the success multi username page
    Then user verify element "ForgotPassword.enhanceMultiuser_text" is present on page and display 'We found multiple accounts' in report
    And user verify element "ForgotPassword.returningCustomer_text" is present on page and display 'Returning Customer' in report
    And user verify element "ForgotPassword.usernameAssociated_text" is present on page and display 'There are {*} usernames associated with your email:{.*}' in report
    And user verify element "ForgotPassword.multiUserDescription_text" is present on page and display 'In order to reset your password please supply the username for which you need to reset' in report
    When user enters username in "ForgotPassword.username_textbox" for "username"
    And user verify link "Login.forgotYourUsername_link" is present on retrieve username page
    And user click on "ForgotPassword.continue_button"
    Then user verify element "ForgotPassword.resetEmailSent_text" is present on page and display 'Reset email sent' in report
    And user verify element "ForgotPassword.emailDescriptionOne_element" is present on page and display 'Farnell has sent an email with a link to reset your password to:' in report
    And user verify element "ForgotPassword.userEmailID_text" is present on page and display 'user email address' in report
    And user verify element "ForgotPassword.emailDescriptionTwo_element" is present on page and display 'Did not receive the email? Please check that you have a Farnell account, the spelling of the email address and your spam folder.' in report
    Then user take screenshot to view the final success reset email sent page

  @fpwd @singleuser @multiuser @UiValidation @eu @apac @nwk @live
  Scenario: To validate the UI Validation & functionality of forgot your password on PF website for single and multi user
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "Guest" user
    Then user click on "Header.login_link"
    When user click on "Login.forgotYourPassword_link"
    And wait for "3" seconds
    And user verify link "Login.forgotYourUsername_link" is present on retrieve username page  
    And user take screenshot of the enter details page for forgot password
    And user verify text of "Forgotten your password" in page "ForgotPassword.forgotPwdHeader_text"
    And user verify text of "It happens from time to time. We are here to help you." in page "ForgotPassword.mobileDescriptionOne_element"
    And user verify text of "Enter your email and we'll send you instructions on how to reset your password. Reset links are valid for 24 hours." in page "ForgotPassword.mobileDescriptionTwo_element"
    And user verify text of "*Required Field" in page "ForgotPassword.requiredFieldsMessage_text"
    And user verify text of "* Email" in page "ForgotPassword.email_label"
    And user verify link "Login.forgotYourUsername_link" is present on retrieve username page
    And user verify text of "Forgotten your username?" in page "Login.forgotYourUsername_link"
    And user enters email in "ForgotPassword.email_textbox" for "single" username
    And user take screenshot of the enter details page for forgot password
    And user verify text of "Send Reset Link" in page "ForgotPassword.sendResetLink_button"
    And user click on "ForgotPassword.sendResetLink_button"
    And wait for "3" seconds
    And user take screenshot of the enter details page for forgot password
    And user verify text of "Check your email" in page "ForgotPassword.forgottenYourPassword_text"
    Then user verify text of "Email Sent" in page "ForgotPassword.resetEmailSent_text"
    And user verify text color of 'Email Sent' heading as "Green,#3a9c54,ForgotPassword.resetEmailSent_text"
    And user verify text of "If you have a registered account with us, you will receive the reset password link to your email." in page "ForgotPassword.emailDescriptionOne_element"
    And user verify element "ForgotPassword.userEmailID_text" is present on page and display 'user email address' in report
    And user verify text of "Did not receive the email? Check the spelling of the email address and also your spam folder." in page "ForgotPassword.emailDescriptionTwo_element"
    And user take screenshot of the success forgot password page for single user email
    #-----Rechecking with Multiple user email address-------
    And user enters email in "ForgotPassword.email_textbox" for "multiple" username
    And user verify text of "Send Reset Link" in page "ForgotPassword.sendResetLink_button"
    And user click on "ForgotPassword.sendResetLink_button"
    And wait for "3" seconds
    And user verify text of "We found multiple accounts" in page "ForgotPassword.enhanceMultiuser_text"
    And user verify text of "Returning Customer" in page "ForgotPassword.returningCustomer_text"
    And user verify element "ForgotPassword.usernameAssociated_text" is present on page and display 'There are {*} usernames associated with your email:{.*}' in report
    And user verify text of "In order to reset your password please supply the username for which you need to reset" in page "ForgotPassword.multiUserDescription_text"
    And user verify text of "*Required Field" in page "ForgotPassword.requiredFieldsMessage_text"
    And user verify the message "Username" is present in multiple tags using innertext in page "ForgotPassword.username_text"
    And user verify link "Login.forgotYourUsername_link" is present on retrieve username page
    And wait for "3" seconds
    And user verify text of "Forgotten your username?" in page "Login.forgotYourUsername_link"
    When user enters username in "ForgotPassword.username_textbox" for "username"
    And user click on "ForgotPassword.continue_button"
    And user verify text of "Check your email" in page "ForgotPassword.forgottenYourPassword_text"
    Then user verify text of "Email Sent" in page "ForgotPassword.resetEmailSent_text"
    And user verify text color of 'Email Sent' heading as "Green,#3a9c54,ForgotPassword.resetEmailSent_text"
    And user verify text of "If you have a registered account with us, you will receive the reset password link to your email." in page "ForgotPassword.emailDescriptionOne_element"
    And user verify element "ForgotPassword.userEmailID_text" is present on page and display 'user email address' in report
    And user verify text of "Did not receive the email? Check the spelling of the email address and also your spam folder." in page "ForgotPassword.emailDescriptionTwo_element"
    And user take screenshot of the success forgot password page for multi user email

  @fpwd @multiuser @errorValidation @eu @apac @nwk @live
  Scenario Outline: To validate error functionality of forgot your password on PF website for single/multi user
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "Guest" user
    Then user click on "Header.login_link"
    When user click on "Login.forgotYourPassword_link"
    And user enter value "<InvalidEmail>" in textbox "ForgotPassword.email_textbox"
    And user wait for "4" seconds
    And user click on "ForgotPassword.sendResetLink_button"
    And user take screenshot of the error page for forgot username
    Then user verify text of "Please enter a valid Email Address" in page "ForgotPassword.enterValidEmailAddress_text"
    And user verify text color of 'error message' heading as "Red,#ff0000,ForgotPassword.enterValidEmailAddress_text"
    And user verify text of 'error message' heading is Bold "ForgotPassword.enterValidEmailAddress_text"
    And user verify border color of email text box as "Red,#d9534f,ForgotPassword.email_textbox"
    And user clears text from textbox "ForgotPassword.email_textbox"
    And user wait for "4" seconds
    And user click on "ForgotPassword.sendResetLink_button" using js
    And user wait for "4" seconds
    Then user verify text of "Please enter a valid Email Address" in page "ForgotPassword.enterValidEmailAddress_text"
    And user verify text color of 'error message' heading as "Red,#ff0000,ForgotPassword.enterValidEmailAddress_text"
    And user verify text of 'error message' heading is Bold "ForgotPassword.enterValidEmailAddress_text"
    And user verify border color of email text box as "Red,#d9534f,ForgotYourUsername.email_textbox"
    And user enter value "<ValidEmail>" in textbox "ForgotPassword.email_textbox"
    And user click on "ForgotPassword.sendResetLink_button"
    And user enter value "<InvalidUsername>" in textbox "ForgotPassword.username_textbox"
    And user click on "ForgotPassword.continue_button"
    And user wait for "4" seconds
    Then user verify text of "Enter a valid username" in page "ForgotPassword.enterValidUsernameError_message"
    And user verify text color of 'error message' heading as "Red,#ff0000,ForgotPassword.enterValidUsernameError_message"
    And user verify text of 'error message' heading is Bold "ForgotPassword.enterValidUsernameError_message"
    And user clears text from textbox "ForgotPassword.username_textbox"
    And user wait for "4" seconds
    And user click on "ForgotPassword.continue_button" using js
    And user wait for "4" seconds
    Then user verify text of "Enter a valid username" in page "ForgotPassword.enterValidUsernameError_message"
    And user verify text color of 'error message' heading as "Red,#ff0000,ForgotPassword.enterValidUsernameError_message"
    And user verify text of 'error message' heading is Bold "ForgotPassword.enterValidUsernameError_message"
    And user take screenshot of the username error page

    Examples: 
      | InvalidEmail | InvalidUsername | ValidEmail            |
      | pf_test      | test            | test@test.com |

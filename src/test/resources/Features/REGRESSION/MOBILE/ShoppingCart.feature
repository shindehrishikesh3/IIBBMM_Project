#Author: Soumen Maity

@checkout @mobAgileRegression @mobValidationTests
Feature: Shopping Cart Regression

  Background: Launch homepage for Shopping cart regression check
    Given web site is launched successfully and user "does" accept the cookies
    
  @emailBasket @Priority3 @eu @apac @nwk
  Scenario: Verify user able to Email the shopping cart
  	Given customer accesses the website as "register" user
  	And I save the newly registered "regular" user details
    When I enter "instock" ordercode from file "MobilePDPRegressionOrderCodes.xlsx" in searchbox
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    Then I verify that element "Search.breadCrumb_element" is present on page
    And I take screenshot of the page
    And I wait for "5" seconds
    And I verify that element "PDP.yourPartNo_link" is present on page
    When I click on "PDP.yourPartNo_link"
    And I enter value "123" in textbox "PDP.yourPartNo_textbox"
    And I wait for "3" seconds
    And I enter value "ABC" in textbox "PDP.lineNote_textbox"
    And I wait for "3" seconds
    And I take screenshot of the page
    And I wait for "5" seconds
    Then user verify text "Quantity" is visible for "PDP.quantity_text"
    And I verify that element "PDP.quantity_textbox" is present on page
    When I click on "PDP.addToCart_button"
    And I wait "medium" duration for "PDP.addToCartPopup_text" element to "appear"
    Then user verify text "This item has been added to your basket" is visible for "PDP.addToCartPopup_text"
    And I click on "PDP.checkout_button"
    And I wait "medium" duration for "ShoppingCart.updateBasket_button" element to "appear"
    And user verify element "ShoppingCart.emailBasket_button" is present on page
    And I take screenshot of Shopping cart page
    And I click on "ShoppingCart.emailBasket_button"
    And I wait for "10" seconds
    And I switch to "ShoppingCart.emailShopingCartFrame_frame" frame
    And I enter email value "pfuser@pfmail.com" in textbox "ShoppingCart.email_text"
    And I enter message value "Test Email Basket" in textbox "ShoppingCart.message_text"
    And I take screenshot of Email Shopping Basket Page
    And I click on Submit Button "ShoppingCart.sendEmail_button"
    And I wait for "5" seconds
    And user verify text "Your email has been sent." in page "ShoppingCart.emailSuccessMessage_element"
    And I take screenshot of the page
    And I switch to default frame
    And I clicked on "ShoppingCart.closeEmailShoppingCartFrame_EUlink" or "ShoppingCart.closeEmailShoppingCartFrame_USlink" based on the dynamic element as per store
    And I take screenshot of the page
    And I click My Account dropdown "Header.burgerNav_Button"
    Then User click on logout option "Header.logOut_button"
    
	@shoppingCartErrorValidation @eu @nwk @Priority2
	Scenario: Error validation for adding different products on Shopping cart page in EU and Newark Region
		Given I click the "ShoppingCart.shoppingCart_icon"
		And I wait "medium" duration for "ShoppingCart.updateBasket_button" element to "appear"
		#--------------Checking errror for Supplier Ship Product--------------------
		When I enter "SupplierShip" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I scroll till "ShoppingCart.updateBasket_button"
		And I wait for "2" seconds
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.errorMessage_text" element to "appear"
		And I scroll till "ShoppingCart.errorMessage_text"
		And I wait for "2" seconds
		And I verify error message from file "CartItemsErrorValidation.xlsx" for "SupplierShip" product
		And I wait for "2" seconds
		And I take screenshot of the page
		And I scroll till "ShoppingCart.deleteProduct_button"
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking errror for Product shipped from different stores--------------------
		When I enter "DifferentStoreShip" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.errorMessage_text" element to "appear"
		And I scroll till "ShoppingCart.errorMessage_text"
		And I wait for "2" seconds
		And I verify error message from file "CartItemsErrorValidation.xlsx" for "DifferentStoreShip" product
		And I wait for "2" seconds
		And I take screenshot of the page
		And I scroll till "ShoppingCart.deleteProduct_button"
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking errror for Product in Package--------------------
		When I enter "Package" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.errorMessage_text" element to "appear"
		And I scroll till "ShoppingCart.errorMessage_text"
		And I wait for "2" seconds
		And I verify error message from file "CartItemsErrorValidation.xlsx" for "Package" product
		And I wait for "2" seconds
		And I take screenshot of the page
		And I scroll till "ShoppingCart.deleteProduct_button"
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking error for Hazaradous Product--------------------
		When I enter "Hazaradous" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.errorMessage_text" element to "appear"
		And I scroll till "ShoppingCart.errorMessage_text"
		And I wait for "2" seconds
		And I verify error message from file "CartItemsErrorValidation.xlsx" for "Hazaradous" product
		And I wait for "2" seconds
		And I take screenshot of the page
		And I scroll till "ShoppingCart.deleteProduct_button"
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking quantity gets updated automatically while ordering Product below minimum quantity --------------------
		When I enter "Minimum Item" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "appear"
		And I scroll till "ShoppingCart.deleteProduct_button"
		And I verify entered quantity in "ShoppingCart.quantity_textbox" does not match with ordered quantity in "PDP.quantity_textbox" for "value" attribute
		And I wait for "2" seconds
		And I take screenshot of the page
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking quantity gets updated automatically while ordering Product not as per multiple mentioned quantity --------------------
		When I enter "Change Multiple Item" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I enter quantity value "15" in textbox "ShoppingCart.quantity_textbox"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "appear"
		And I scroll till "ShoppingCart.deleteProduct_button"
		And I verify entered quantity in "ShoppingCart.quantity_textbox" does not match with ordered quantity in "PDP.quantity_textbox" for "value" attribute
		And I wait for "2" seconds
		And I take screenshot of the page
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking no longer manufactured products are not getting added --------------------
		When I enter "No Longer Stocked" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait for "2" seconds
		And I scroll till "ShoppingCart.shoppingCart_icon"
		Then I verify element "ShoppingCart.deleteProduct_button" is not visible in DOM
		And I wait for "2" seconds
		And I take screenshot of the page
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking no longer stocked products are not getting added --------------------
		When I enter "No Longer Manufactured" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait for "2" seconds
		And I scroll till "ShoppingCart.shoppingCart_icon"
		And I verify element "ShoppingCart.deleteProduct_button" is not visible in DOM
		And I wait for "2" seconds
		And I take screenshot of the page
		
	@shoppingCartErrorValidation @apac @Priority2
	Scenario: Error validation for adding different products on Shopping cart page in APAC Region
		Given I click the "ShoppingCart.shoppingCart_icon"
		And I wait "medium" duration for "ShoppingCart.updateBasket_button" element to "appear"
		#--------------Checking errror for Supplier Ship Product--------------------
		When I enter "SupplierShip" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I scroll till "ShoppingCart.updateBasket_button"
		And I wait for "2" seconds
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.errorMessage_text" element to "appear"
		And I scroll till "ShoppingCart.errorMessage_text"
		And I wait for "2" seconds
		And I verify error message from file "CartItemsErrorValidation.xlsx" for "SupplierShip" product
		And I wait for "2" seconds
		And I take screenshot of the page
		And I scroll till "ShoppingCart.deleteProduct_button"
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking errror for Product in Package--------------------
		When I enter "Package" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.errorMessage_text" element to "appear"
		And I scroll till "ShoppingCart.errorMessage_text"
		And I wait for "2" seconds
		And I verify error message from file "CartItemsErrorValidation.xlsx" for "Package" product
		And I wait for "2" seconds
		And I take screenshot of the page
		And I scroll till "ShoppingCart.deleteProduct_button"
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking error for Hazaradous Product--------------------
		When I enter "Hazaradous" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.errorMessage_text" element to "appear"
		And I scroll till "ShoppingCart.errorMessage_text"
		And I wait for "2" seconds
		And I verify error message from file "CartItemsErrorValidation.xlsx" for "Hazaradous" product
		And I wait for "2" seconds
		And I take screenshot of the page
		And I scroll till "ShoppingCart.deleteProduct_button"
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking quantity gets updated automatically while ordering Product below minimum quantity --------------------
		When I enter "Minimum Item" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "appear"
		And I scroll till "ShoppingCart.deleteProduct_button"
		And I verify entered quantity in "ShoppingCart.quantity_textbox" does not match with ordered quantity in "PDP.quantity_textbox" for "value" attribute
		And I wait for "2" seconds
		And I take screenshot of the page
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking quantity gets updated automatically while ordering Product not as per multiple mentioned quantity --------------------
		When I enter "Change Multiple Item" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I enter quantity value "15" in textbox "ShoppingCart.quantity_textbox"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "appear"
		And I scroll till "ShoppingCart.deleteProduct_button"
		And I verify entered quantity in "ShoppingCart.quantity_textbox" does not match with ordered quantity in "PDP.quantity_textbox" for "value" attribute
		And I wait for "2" seconds
		And I take screenshot of the page
		Then I click on "ShoppingCart.deleteProduct_button"
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking no longer manufactured products are not getting added --------------------
		When I enter "No Longer Stocked" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait for "2" seconds
		And I scroll till "ShoppingCart.shoppingCart_icon"
		Then I verify element "ShoppingCart.deleteProduct_button" is not visible in DOM
		And I wait for "2" seconds
		And I take screenshot of the page
		And I wait "medium" duration for "ShoppingCart.deleteProduct_button" element to "disappear"
		And I scroll till "ShoppingCart.firstOrderCode_textbox"
		#--------------Checking no longer stocked products are not getting added --------------------
		When I enter "No Longer Manufactured" order Code in textbox "ShoppingCart.firstOrderCode_textbox" from file "CartItemsErrorValidation.xlsx"
		And I wait for "2" seconds
		And I take screenshot of the page
		And I click on "ShoppingCart.updateBasket_button"
		And I wait for "2" seconds
		And I scroll till "ShoppingCart.shoppingCart_icon"
		And I verify element "ShoppingCart.deleteProduct_button" is not visible in DOM
		And I wait for "2" seconds
		And I take screenshot of the page
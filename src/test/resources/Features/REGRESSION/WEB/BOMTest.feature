@validationTests @BOMTest 
Feature: BOM validation test

  @BOMUpload @eu @apac @nwk 
  Scenario: As a customer user should be able to add products from BOM page.
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "register" user
    And I save the newly registered "regular" user details
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "1000"
    And I upload the file "BOMRegressionTest.xlsx" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "10" seconds
   	And I choose worksheet to read store specific data 
   	And I wait for "4" seconds
    And I navigates back in the browser
    And I wait for "2" seconds
    And I wait "long" duration for "BOMUploadPage.dateCreated_text" element to "appear"
    And I verify element "BOMUploadPage.dateCreated_text" is present on page and display Date Created in report
    And I verify element "BOMUploadPage.lastModified_text" is present on page and display last modifed date in report
    And I verify element "BOMUploadPage.verfiedLines_text" is present on page and display verified line /total lines in report
    And I wait for "2" seconds
    And I click on delete element "BOMUploadPage.delete_icon" using js
    And I click on delete cancel button "BOMUploadPage.deleteCancel_button"
    And I click on view button "BOMUploadPage.view_button"
    And I wait for "2" seconds
    And I rename the existing BOM file
    And I wait for "2" seconds
    And I click on "BOMUploadPage.addPart_link"
    And I wait for "3" seconds
    And I enter an Order Code and Quantity and click Add a part button
    And I wait for "5" seconds
  	And I verify "In-stock" products present on BOM view page
    And I wait for "2" seconds 	
    And I verify the number of "Direct" qualifier present in page "BOMUploadPage.qualifier_text"
    And I click on create Quote button "BOMUploadPage.CreateQuote_link"
    And I verify element "BOMUploadPage.pricingQuery_radio" is present on page
    And I verify element "BOMUploadPage.intendedOrder_radio" is present on page
    And I click on pricing query radio button "BOMUploadPage.pricingQuery_radio"
    And I click continue button on quote pop-up "BOMUploadPage.continue_button"
    And I wait for "2" seconds
    And I update quote name if pop-up displayed
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomQuote_link" is present on page
    And I click on select all checkbox "BOMUploadPage.selectAll_checkbox"
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button" using js
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I verify element "ShoppingCart.bomReference_icon" is present on page
    And I clear items from shopping cart if any present
    And I wait for "2" seconds
    And I verify mini shopping cart header contains "0" items in "Header.itemsInMiniBasket_text"
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "5" seconds
    And User scroll down the page by pixels "1000"
    And I click on view button "BOMUploadPage.view_button"
    And I wait for "2" seconds
    And I click on all select checkbox "BOMUploadPage.allSelect_checkbox"
    And I save the value of the product count "BOMUploadPage.matchedLinesCircle_element"
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button"
    And I wait for "2" seconds
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
  	And I verify that the product searched and added to BOM is available in basket
   	And I verify Number of Matched lines products on BOM view page is available on basket page "Header.itemsInMiniBasket_text"
    And I clear items from shopping cart if any present
    And I wait for "2" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on logout option "Header.logout_button"

     @BOMViewUIValidation @eu @apac @nwk @live
  	Scenario: BOM view UI elements verification
    Given web site is launched successfully and user "does" accept the cookies
 		And I	register new "regular" user when last registered user details are unavailable
 		And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "1000"
   	And I upload the BOM file "BOMRegressionTest.xlsx" if no file is present on BOM page
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.verfiedLines_text" is present on page and display verified line /total lines in report
    And I wait for "2" seconds
    And I click on view button "BOMUploadPage.view_button"
    And I wait for "4" seconds
    And I verify element "BOMUploadPage.bomDetailsHeader_element" is present on page
    And I verify element "BOMUploadPage.addPart_link" is present on page
    And I verify element "BOMUploadPage.deleteSelected_button" is present on page
    And I verify element "BOMUploadPage.addToBasket_button" is present on page
    And I verify element "BOMUploadPage.CreateQuote_link" is present on page
    And I verify element "BOMUploadPage.morePricing_link" is present on page
    And I verify element "BOMUploadPage.fullReel_icon" is present on page
    And I verify element "BOMUploadPage.downloadBom_link" is present on page
    And I verify element "BOMUploadPage.downloadBom_link" is present on page
   	And I verify that BOM File downloaded succesfully "BOMUploadPage.downloadBom_link" 
    And I take screenshot of the page
  	And I verify "In-stock" products present on BOM view page
   	And I verify "Backorder" products present on BOM view page
  	And I verify "No-Match" products present on BOM view page
   	And I verify "Multi-Match" products present on BOM view page	
 		And I verify the number of "Suggested" qualifier present in page "BOMUploadPage.qualifier_text"
    And I verify the number of "Direct" qualifier present in page "BOMUploadPage.qualifier_text"
	  And I hover on element My Account dropdown "Header.myAccount_dropdown"
 		And I click on logout option "Header.logout_button"

   @BOMMultiPackaging @eu @apac 
  Scenario: Verify packaging type from BOM page.
    Given web site is launched successfully and user "does" accept the cookies
 		And I	register new "regular" user when last registered user details are unavailable
 		And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "1000"
   	And I upload the BOM file "BOMRegressionTest.xlsx" if no file is present on BOM page
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.verfiedLines_text" is present on page and display verified line /total lines in report
    And I wait for "2" seconds
    And I click on view button "BOMUploadPage.view_button"
    And I wait for "2" seconds
    And I select "Cut Tape" packaging type for multiple packaging products
    And I take screenshot
	  And I wait for "4" seconds
    And I take screenshot
		And I extract number value from text "BOMUploadPage.minQunatity_text" element on page
 		And User scroll down the page by pixels "15000" 	
 		And I clears text from textbox "BOMUploadPage.fullReelPackageQuantity_textbox"
    Then I enter extracted number in "BOMUploadPage.fullReelPackageQuantity_textbox" text box
    And I take screenshot
    And I scroll till "BOMUploadPage.addToBasket_button"
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button" using js
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
 		And I verify selected packaging type is present on Basket Page
    And I clear items from shopping cart if any present
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on logout option "Header.logout_button"
    
    @NoMatches @eu @apac @nwk 
  Scenario: validate No match BOM functionality
    Given web site is launched successfully and user "does" accept the cookies
 		And I	register new "regular" user when last registered user details are unavailable
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "1000"
   	And I upload the BOM file "BOMRegressionTest.xlsx" if no file is present on BOM page
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.verfiedLines_text" is present on page and display verified line /total lines in report
    And I wait for "2" seconds
    And I click on view button "BOMUploadPage.view_button"
    And I wait for "2" seconds
    And I take screenshot
    And I verify element "BOMUploadPage.bomFileDetails_element" is present on page
    And I verify element "BOMUploadPage.noMatch_element" is present on page
    And I verify border color of 'noMatch' as "Red,#DA1E28,BOMUploadPage.noMatchCircle_element"
    And I verify element "BOMUploadPage.noMatchCircle_element" is present on page and display its value in report
    And I save the value of the product count "BOMUploadPage.noMatchCircle_element"
    And I wait for "5" seconds
    And I clears text from textbox "BOMUploadPage.unmatchedPartNo_textbox"    
    And I enter ordercode to add instock product to BOM in "BOMUploadPage.unmatchedPartNo_textbox"
  	And I wait for "2" seconds
  	And I click on "BOMUploadPage.searchProduct_button"
  	And I wait for "5" seconds
  	And I take screenshot
  	And I verify element "BOMUploadPage.noMatchCircle_element" is present on page and display its value in report
    And I compare product count before and after delete product "BOMUploadPage.noMatchCircle_element"
    And I click on all select checkbox "BOMUploadPage.allSelect_checkbox"
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button"
    And I wait for "2" seconds
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I take screenshot
    And I wait for "5" seconds
    And I verify that the product searched and added to BOM is available in basket
    And I clear items from shopping cart if any present
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on logout option "Header.logout_button"
    
    @BOMMultipleMatches @eu @apac @nwk 
    Scenario: As a customer user should check Multiple matches
    Given web site is launched successfully and user "does" accept the cookies
 		And I	register new "regular" user when last registered user details are unavailable
    And I click on the "Header.miniBasket_link"
    And I clear items from shopping cart if any present
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And User scroll down the page by pixels "1000"
    And I wait for "2" seconds
   	And I upload the BOM file "BOMRegressionTest.xlsx" if no file is present on BOM page
    And I wait for "2" seconds
    And I click on view button "BOMUploadPage.view_button"
    And I wait for "8" seconds
    Then I verify element "BOMUploadPage.multipleMatch_button" is present on page
    And I verify border color of MultipleMatch as "Yellow,#ff0000,BOMUploadPage.multipleMatch_rows"
    And I wait for "2" seconds
    Then I verify element "BOMUploadPage.viewAllResults_button" is present on page
    And I wait for "2" seconds
    And I scroll till "BOMUploadPage.nonExactMatch_text"
    And I verify element "BOMUploadPage.nonExactMatch_text" is present on page
    And I verify text "Suggested" in page "BOMUploadPage.nonExactMatch_text"
    And I verify text "Direct" in page "BOMUploadPage.exactMatchDirect_text"
    And I verify text "Available for back order" in page "BOMUploadPage.exactMatchAvailableForBackOrder_text"
    And I scroll till "BOMUploadPage.fullReel_text"
    And I verify text "Full Reel" in page "BOMUploadPage.fullReel_text"
    Then I take screenshot of the page
    And I select in-stock multiple matches from the table and compare the count
    Then I take screenshot of the page
    And I wait for "2" seconds
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button"
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on logout option "Header.logout_button"
    
    @BOMDeleteProduct @eu @apac @nwk @BOMTest
    Scenario: As a customer user should be able to delete products from BOM page.
    Given web site is launched successfully and user "does" accept the cookies
 		And I	register new "regular" user when last registered user details are unavailable
    And I click on the "Header.miniBasket_link"
    And I clear items from shopping cart if any present
    And And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And User scroll down the page by pixels "1000"
    And I wait for "2" seconds
   	And I upload the BOM file "BOMRegressionTest.xlsx" if no file is present on BOM page
    And I wait for "2" seconds
    And I click on view button "BOMUploadPage.view_button"
    And I wait for "8" seconds
    And I save the value of the product count "BOMUploadPage.showallCircle_element"
    Then I click on the "BOMUploadPage.allSelect_checkbox"
    Then I click on the "BOMUploadPage.allSelect_checkbox"
    And I wait for "3" seconds
    And I click on the "BOMUploadPage.productTobeDeleted_checkbox"
    And I take screenshot of the page
    And I wait for "5" seconds
    And I click on "BOMUploadPage.deleteSelected_button" using js
    And I wait for "3" seconds
    And I compare product count before and after delete product "BOMUploadPage.showallCircle_element"
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button"
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    Then I take screenshot of the page
    And I wait for "2" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on logout option "Header.logout_button"
    
    @BOMAlternatives @eu @apac @nwk @live
    Scenario: User should check and add alternatives product on BOM Page.
    Given web site is launched successfully and user "does" accept the cookies
 		And I	register new "regular" user when last registered user details are unavailable
    And I click on the "Header.miniBasket_link"
    And I clear items from shopping cart if any present
    And And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And User scroll down the page by pixels "1000"
    And I wait for "2" seconds
   	And I upload the BOM file "BOMRegressionTest.xlsx" if no file is present on BOM page
  	And I wait "short" duration for "BOMUploadPage.view_button" element to "disappear"    
  	And I click on view button "BOMUploadPage.view_button"
    And I wait "long" duration for "BOMUploadPage.bomFileDetails_element" element to "appear"
    And User scroll down the page by pixels "1000"
		And I verify element "BOMUploadPage.seeAlternatives_button" is present on page
		And I click see alternatives button "BOMUploadPage.seeAlternatives_button"
    And I wait for "2" seconds
		And I save the value of First Manufacturer Part No from Alternatives table	
		And I click add to BOM button to add first product from alternatives table "BOMUploadPage.addToBOMAlt_button"
		And I wait for "2" seconds		
		And I verify First product is added to BOM from Alternatives table
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button"
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on logout option "Header.logout_button"
    
    @BOMUploadMaxData @eu @apac @nwk @BOMTest @live
    Scenario: As a customer user should be able to upload file with 200 testdata
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "register" user
    And I save the newly registered "regular" user details
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And I upload the file "BOM_Test_200.xlsx" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "4" seconds  
    And I verify element "BOMUploadPage.pagination_button" is present on page
    And I take screenshot of the page
    Then I verify element "BOMUploadPage.showallItems_element" is present on page
    Then I verify text matched products "200" in page "BOMUploadPage.showallItems_element"
    And I save the value of the product count "BOMUploadPage.matchedLinesCircle_element"
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button"
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I verify Number of Matched lines products on BOM view page is available on basket page "Header.itemsInMiniBasket_text"
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on logout option "Header.logout_button"
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I upload the file "BOM_Test_200.xlsx" into the element "BOMUploadPage.uploadFile_text"
   	And I wait for "4" seconds
    And I click on create Quote button "BOMUploadPage.CreateQuote_link"
    And I take screenshot of the page
    And I verify element "BOMUploadPage.loginOrRegister_popup" is present on page
    Then I click on "BOMUploadPage.login_link"
    And last registered "regular" user login to website successfully
    And I wait for "2" seconds
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    Then I scroll down the page by pixels "500"
    And I verify text "BOM_Test_200.xlsx" in page "BOMUploadPage.fileName_text"
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on logout option "Header.logout_button"

    @BOMGuestUserUpload @eu @apac @nwk @BOMTest @live
    Scenario: As a guest user should upload a BOM file and place an order
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "guest" user
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "1000"
    And I upload the file "BOMRegressionTest.xlsx" into the element "BOMUploadPage.uploadFile_text"
    And I wait for "5" seconds
   	And I choose worksheet to read store specific data 
   	And I wait for "4" seconds
   	And I take screenshot of the page
   	And I click on add to basket button on page "BOMUploadPage.addToBasket_button"
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I take screenshot of the page
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button"
		And I wait for "4" seconds
		And I continue only if guest checkout feature is enabled
		And User click on Checkout Without registering radio button on popup "ShoppingCart.checkoutWithoutRegistering_radio"
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
		And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
		Then User verify green tick mark element "Checkout.greenTickMarkSection3_icon" is present on page
		And User fill Credit Card Details using given file "OrderInformation.xlsx"
		And I wait for "3" seconds
		And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
		And I wait for "3" seconds
		When User enter random PO Number on Order Review section
		And I wait for "5" seconds
		And User checks terms and conditions checkbox and click on Submit Order button
		And I wait for "4" seconds
		And I verify order confirmation message is present on page and display 'Thank you for your order' in report
		
		@BOMCheckout @eu @apac @nwk 
  	Scenario: Registered user add product through BOM and place order
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "register" user
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "1000"
    And I upload the file "BOMRegressionTest.xlsx" into the element "BOMUploadPage.uploadFile_text"
    And I wait "medium" duration for "BOMUploadPage.worksheet_dropdown" element to "appear"
   	And I choose worksheet to read store specific data 
 		And I wait "short" duration for "BOMUploadPage.matchedLinesCircle_element" element to "appear"
    And I save the value of the product count "BOMUploadPage.matchedLinesCircle_element"
 	  And I click on add to basket button on page "BOMUploadPage.addToBasket_button"
    And I wait for "2" seconds
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
		And I verify Number of Matched lines products on BOM view page is available on basket page "Header.itemsInMiniBasket_text"
		When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait "long" duration for "Checkout.paymentMethod_text" element to "appear"
    And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
    And I would like to open a new Trade Account
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
    Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
    And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
    And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
    And I wait "medium" duration for "Checkout.editInvoiceAndDeliveryAddress_button" element to "appear"
    Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And I wait for "3" seconds
    And I scroll till "Checkout.deliverySectionContinue_button"
    And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
    Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
    And I select trade account radio button and click continue button in section 4 payment method
    Then I verify element "Checkout.editPaymentDetails_button" is present except in "ph" region/store
    And I fill Additional Information Details for New Trade Account using given file "OrderInformation.xlsx"
    And I wait for "3" seconds
    And User take screenshot of the page
    And I enter PO number value "BOM" in textbox "Checkout.poNumber_textbox"
    And User take screenshot of the page
    And User checks terms and conditions checkbox and click on Submit Order button
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    And user take screenshot of the page
    
 
    
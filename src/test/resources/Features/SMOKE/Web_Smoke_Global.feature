@websmoketest
Feature: Smoke tests - Web

  @synchuser_us @usonly @nwk
  Scenario: Register a user with known details for newark
    Given web site is launched successfully and user "does" accept the cookies
    Then customer accesses the website as "register as synch" user
    And I save the newly registered "sync" user details

  @synchuser @checkoutUsingExistingTradeAccount @eu @apac @live @euapaconly @cicd @sre @cpc
  Scenario: Synch user Checkout with existing trade account
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    And I save the newly registered "sync" user details
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "3" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "4" seconds
    And I verify element "Checkout.paymentMethod_text" is present on page and display its value in report
    And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
    And I click Existing Trade account option "Checkout.existingTradeAcc_radio" without wait
    And I enter Trade account Account number and CID details using given file "OrderInformation.xlsx"
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
    And I verify element "Checkout.invoiceAndDeliveryAddress_text" is present on page and display its value in report
    And I wait for "2" seconds
    And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
    And I click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
    And I wait for "8" seconds
    And I verify element "Checkout.deliveryOptions_text" is present on page and display its value in report
   	And I enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And I scroll till "Checkout.deliverySectionContinue_button"
    And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    And I verify element "Checkout.paymentDetails_text" is present except in "ph, cpc" region/store
    And I wait for "3" seconds
    And I select trade account radio button and click continue button in section 4 payment method
    And I wait for "3" seconds
    And I enter PO number value "ExistingAccount" in textbox "Checkout.poNumber_textbox"
    And I checks terms and conditions checkbox and click on Submit Order button
    And I take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    And I take screenshot of the page

  @checkoutNewTradeAccount @eu @apac @nwk @live @cicd @sre @cpc
  Scenario: Blank search & Checkout requesting new Trade Account
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
    And I click "ShoppingCart.updateBasket_button"
    And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
    And I wait for "3" seconds
    And I scroll till "Header.itemsInMiniBasket_text"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "10" seconds
    And I wait "medium" duration for "Checkout.paymentMethod_text" element to "appear"
    And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
    And I would like to open a new Trade Account
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
    Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
    And fill Checkout Invoice address by entering four characters in auto Search textbox "test"
    And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
    And I wait for "8" seconds
    Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And I wait for "3" seconds
    And I scroll till "Checkout.deliverySectionContinue_button"
    And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
    Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
    And I select trade account radio button and click continue button in section 4 payment method
    Then I verify element "Checkout.editPaymentDetails_button" is present except in "ph" region/store
    And I fill Additional Information Details for New Trade Account using given file "OrderInformation.xlsx"
    And I wait for "3" seconds
    And User take screenshot of the page
    And I enter PO number value "NewTradeAcc" in textbox "Checkout.poNumber_textbox"
    And User take screenshot of the page
    And I wait for "10" seconds
    And User checks terms and conditions checkbox and click on Submit Order button
    And user take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    And user take screenshot of the page

  @guestcheckoutUsingCC @eu @apac @nwk @live @sre @agileRegression @cpc 
  Scenario: A guest user adds products to cart directly using a community url then places order successfully using creditcard
    Given web site is launched successfully and user "does not" accept the cookies
    And User save cookie preferences
    When User navigate to community URL using file "CommunityURL.xlsx"
    And I wait for "4" seconds
    And user verify element "ShoppingCart.checkoutNow_button" is present on page
    And User scroll till "ShoppingCart.firstProductOnCart_text"
    And I wait for "4" seconds
    When User click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "4" seconds
    And I continue only if guest checkout feature is enabled
    And User click on Checkout Without registering radio button on popup "ShoppingCart.checkoutWithoutRegistering_radio"
    And I populate company details if B2Bonly store and click checkout without registering button
    Then I wait for "8" seconds
    And User take screenshot of the page
    And User fill Checkout Your details section form using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User click on Continue button on Your Details Section "Checkout.yourDetailsSectionContinue_button"
    And I wait for "8" seconds
    And I select credit card Payment method in section one for CPC store and continue
    And I wait for "8" seconds
    And User click on Enter Address Manually Link "Checkout.addAddressManually_link"
    And User take screenshot of the page
    And User fill Checkout Invoice address manually using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
    Then User verify green tick mark element "Checkout.greenTickMarkSection2_icon" is present on page
    And User scroll till "Checkout.deliveryInstructions_textbox"
    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And User take screenshot of the page
    And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    And User take screenshot of the page
    Then User verify green tick mark element "Checkout.greenTickMarkSection3_icon" is present on page
    And User fill Credit Card Details using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And I wait for "10" seconds
    And User click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
    And User take screenshot of the page
    When User enter random PO Number on Order Review section
    And User take screenshot of the page
    And I wait for "10" seconds
    And User checks terms and conditions checkbox and click on Submit Order button
    And user take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    Then User gets Order confirmation Number
    And user take screenshot of the page

  @SearchLookAhead @guest @eu @apac @nwk @live @cicd @cpc
  Scenario: Search Lookahead and Keyword search
    Given web site is launched successfully and user "does" accept the cookies
    And I verify element "Header.searchBox_textbox" is present on page
    And user enter the value "res" in textbox "Header.searchBox_textbox"
    And I wait for "3" seconds
    And I verify searchlookahead header and data row count
    And I take screenshot to view the search look ahead is dispalyed properly
    And I clears text from textbox "Header.searchBox_textbox"
    When user enter the value "capacitor" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
    And I take screenshot to verify the correct search page is loaded
    Then I verify element "Search.productsHeader_text" is present on page and display 'Total Products found for search term' in report

  @verifySEOTitle @guest @eu @apac @nwk @live @cicd @cpc
  Scenario: I want to verify the SEO title for PDP page
    Given web site is launched successfully and user "does" accept the cookies
    When I enter ordercode in Searchbox to navigate to PDP page
    And I click on the first order result "Search.searchFirst_text"
    And I wait for "3" seconds
    Then I verify element "PDP.manufDescription_text" is present on page except in "cpc" region/store
    Then I verify element "PDP.manuf_text" is present on page and display 'Manufacturer Name' in report
    Then I verify element "PDP.manufPartNo_text" is present on page and display 'Manufacturer part number' in report
    And I take screenshot to view the PDP page
    Then I verify the SEO title for the PDP page


  @filter @guest @eu @apac @nwk @live @cicd @cpc
  Scenario: Validate the Left filters functionality
    Given web site is launched successfully and user "does" accept the cookies
    When I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
    And I wait for "4" seconds
    And I verify element "Filters.staticFilterAvailability_section" is present on page
    And I get the Products found count before applying filters
    When I click on second availability filter checkbox "Filters.suitableForNewDesigns_checkbox"
    And I click on Show Result Button "Filters.showResult_button" refreshed element
    And I verify the Products found count after applying filters
    And I verify Filter Applied section element "Filters.filterAppliedLeftView_section" is present on page
    And I click "Filters.clearAllFilters_link"
    And I wait for "8" seconds
    And I verify the Products found count after clearing all the filters

  @filter @guest @eu @apac @nwk @live @cicd 
  Scenario: Validate the Top filters functionality
    Given web site is launched successfully and user "does" accept the cookies
    When I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
    And I wait for "4" seconds
    And I get the Products found count before applying filters
    And I click the toggle view from LEFT to TOP view "Filters.filterView_toggle"
    When I select by index "1" from dropdown "Filters.filterManufacturer_section"
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And I verify the Products found count after applying filters
    And I verify Filter Applied section element "Filters.filterAppliedTopView_section" is present on page
    And I click on "Filters.reset_link"
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And I verify the Products found count after clearing all the filters
    And I verify PLP table element "PLP.PLP_element" is present on page
    And I click on Add button on PLP "PLP.firstAdd_button" using js
    And I wait for "6" seconds
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"

  @trackOrder @guestcheckoutUsingCC @eu @apac @euapaconly
  Scenario: Guest user track order by entering order confirmation number, email and zip code
    Given web site is launched successfully and user "does" accept the cookies
    When user click on Track Orders link On home page from the header "Header.trackOrders_link"
    Then user verifies Order Details element "OrderTracking.orderDetails_text" is present on page
    And I continue only if guest checkout feature is enabled
    And Guest user submits the Order tracking details
    And I wait "medium" duration for "OrderTracking.orderRefNum_text" element to "appear"
    And I take screenshot
    Then user verifies the Order Ref number on My Order details page

  @orderHistory @checkoutNewTradeAccount @eu @apac @nwk
  Scenario: Verify the order history for recent orders
    Given web site is launched successfully and user "does" accept the cookies
    When last registered "regular" user login to website successfully
    And I assume environment stub is disabled in PP environment
    When I hover on element My Account "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I wait for "5" seconds
    And I take screenshot to verify the Account Summary page is displayed with recent order table
    And I verify element "OrderHistory.recentOrders_text" is present on page and display 'Recent Orders' in report
    And I verify PO Number "OrderHistory.firstPONumber_element" of recently placed order is "NewTradeAcc"
    And I scroll till "OrderHistory.viewAllOrders_button"
    When I click on View All Orders button "OrderHistory.viewAllOrders_button"
    And I verify element "OrderHistory.txt_OrderHistory&Tracking" is present on page and display 'Order History & Tracking' in report
    And I click on link of recent order placed PO Number "OrderHistory.firstPONumber_element" using js
    And I wait for "8" seconds
    And I wait "medium" duration for "OrderHistory.MyOrderDetails_text" element to "appear"
    And I take screenshot to view My Order Details page
    Then I verify element "OrderTracking.MyOrderDetails_text" is present on page and display 'My Order Details' in report

  @synchuser @synchuser_us @eu @apac @nwk
  Scenario: Verify Back office Account number is synched in Account Summary
    Given I assume environment stub is disabled in PP environment
    Given web site is launched successfully and user "does" accept the cookies
    When last registered "sync" user login to website successfully
    And Verify user is logged in on Home page successfully
    When I hover on element My Account "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I wait for "5" seconds
    And I scroll till "AccountSummary.backOfficeAccount_text"
    And I take screenshot to view the Account Summary page
    Then I verify element "AccountSummary.backOfficeAccount_text" is present on page and display 'Back Office Account number Synched' in report

  @BOM @eu @apac @nwk @live
  Scenario: Verify registered user can upload BOM file and add product into Basket
    Given web site is launched successfully and user "does" accept the cookies
    When customer accesses the website as "register" user
    When I hover on element My Account "Header.myAccount_dropdown"
    And I click on BOM Upload link under My Account dropdown "Header.bomUpload_link"
    And I wait for "2" seconds
    And I verify element "BOMUploadPage.bomUpload_element" is present on page
    And User scroll down the page by pixels "1000"
    And I delete if any BOM file present on page "BOMUploadPage.delete_icon"
    And I upload the file "BOM_Test.xlsx" into the element "BOMUploadPage.uploadFile_text"
    Then I verify element "BOMUploadPage.showAllitems_text" is present on page
    And I save the value of the product count "BOMUploadPage.matchedLinesCircle_element"
    And I click on add to basket button on page "BOMUploadPage.addToBasket_button" using js
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
   	And I verify Number of Matched lines products on BOM view page is available on basket page "Header.itemsInMiniBasket_text"
    And I hover on element My Account "Header.myAccount_dropdown"
    And I click on logout option "Header.logout_button"   
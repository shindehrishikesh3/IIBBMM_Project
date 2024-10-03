@MobSmoke
Feature: Smoke tests - Mobile

  @checkoutNewTradeAccount @live @mobsmoketest @cicd @eu @apac @nwk
  Scenario: Blank search & Checkout requesting new Trade Account
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    And I save the newly registered "regular" user details
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And I verify element "BrowseForProducts.firstCategory_link" is present on page and display name of First Category in report
    And I click "BrowseForProducts.secondSubCategory_link"
    Then User verify in L0 Category Page element "CategoryPage.section_category" is present on page
    And I wait for "3" seconds
    And I save the value of First Order code from PLP table
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait "medium" duration for "Header.itemsInMiniBasket_text" element to "appear"
    And I verify mini shopping cart header contains "0" items in "Header.itemsInMiniBasket_text"
    And I wait for "3" seconds
    And I scroll till "ShoppingCart.updateBasket_button"
    When I enter the ordercode saved from PLP to update the basket to place order
    And I wait for "5" seconds
    And User take screenshot of the page
    And I click "ShoppingCart.updateBasket_button"
    And I wait for "5" seconds
    #And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I refresh browser to load all the elements
    And I take screenshot to see the checkout page is still displayed after refresh
    And I wait "medium" duration for "ShoppingCart.checkoutNow_button" element to "appear"
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I take screenshot to verify that Trade Account page is displayed
    And I wait "medium" duration for "Checkout.tradeAccountOption_checkbox" element to "appear"
    And I click on checkbox to open a new Trade Account "Checkout.tradeAccountOption_checkbox"
    And I enter PO number value "TradeTestorder" in textbox "Checkout.poNumber_textbox"
    And I wait for "3" seconds
    And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    And I wait "short" duration for "Checkout.paymentMethod_dropdown" element to "appear"
    And I select by visible text in Payment Method type as "Trade Account" from dropdown "Checkout.paymentMethod_dropdown"
    And I wait for "3" seconds
    And User fill mobile checkout Invoice or billing address manually using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User click on Continue button on Payment Details Section "Checkout.paymentDetailsSectionContinue_button"
    And User click on Continue button on Delivery Address Section "Checkout.addressSectionContinue_button"
    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And User take screenshot of the page
    And I scroll till "Checkout.proceedToOrderReview_button"
    And I wait for "3" seconds
    And User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And User take screenshot of the page
    And I wait for "7" seconds
    Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
    Then I verify Invoice Address section edit button element "Checkout.editInvoiceAddress_button" is present on page
    Then I verify Delivery Address section edit button element "Checkout.editDeliveryAddress_button" is present on page
    Then I verify Delivery Selection & Order Options section edit button element "Checkout.editDeliverySelection_button" is present on page
    And User checks terms and conditions checkbox and click on Submit Order button
    And I wait for "8" seconds
    And user take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you' in report

  @SearchLookAhead @guest @live @mobsmoketest  @cicd @eu @apac @nwk
  Scenario: Search Lookahead and Keyword search
    Given web site is launched successfully and user "does" accept the cookies
    And I verify element "Header.searchBox_textbox" is present on page
    And user enter the value "res" in textbox "Header.searchBox_textbox"
    And I wait for "3" seconds
    And I verify the "Search.attributes_text" listed for "Search.attributes_list" has atleast "1" rows of data
    And I verify the "Search.productCategories_text" listed for "Search.productCategories_list" has atleast "3" rows of data
    And I verify the "Search.manufacturers_text" listed for "Search.manufacturers_list" has atleast "3" rows of data
    And I verify the "Search.products_text" listed for "Search.products_list" has atleast "3" rows of data
    And I take screenshot to view the search look ahead is dispalyed properly
    And I clears text from textbox "Header.searchBox_textbox"
    When user enter the value "capacitor" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    #And I verify breadcrumb for Results element "Search.breadCrumb_element" is present on page
    Then I verify element "Search.productsHeader_text" is present on page and display 'Total Products found for search term' in report

  @filter @guest @mobsmoketest @usftonly
  Scenario: Validate filter functionality is working fine
    Given web site is launched successfully and user "does" accept the cookies
    When I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
    And I wait for "4" seconds
    And I verify element "Filters.searchWithinTermBox_textbox" is present on page
    And I get the Products found count before applying filters
    And I click on refine results button to view the filters options "Filters.refineResults_button"
    And I scroll down the page by pixels "250"
    And I click on the expand button of Static Filters Availability to see the options "Filters.plusSignOfAvailability_image"
    And I click on Instock checkbox to apply the filters "Filters.instock_checkbox"
    Then I verify element "Filters.filtersSelected_text" is present on page and display '1 Filter(s) Selected' in report
    And I click on Apply Filters button to see the resultant products count "Filters.applyFilters_button"
    And I wait for "5" seconds
    And I verify the Products found count after applying filters
    And I verify element "Filters.filtersApplied_text" is present on page and display 'Refine Results (1) Filter Applied' in report
    And I click on Refine results again to clear the last Instock selected filter "Filters.refineResults_button"
    And I click Clear All Filters button to reset the selection "Filters.clearAllFilters_button"
    And I wait for "5" seconds
    #BELOW LINE TO BE UNCOMMENTED WHEN ISSUE OF CLEAR ALL FILTERS FOR EXCLUDE ORDERS IS RESOLVED FOR US FT & LIVE
    #Then I verify the Products found count after clearing all the filters
    And I click on refine results button to view the filters options "Filters.refineResults_button"
    And I scroll till "Filters.plusSignOfManufacturer_image"
    And I click on the expand button of Static Filters Manufacturer to see the options "Filters.plusSignOfManufacturer_image"
    Then select any manufacturer from "Filters.mfrProductCount_text" which is having atleast "20" product
    # And I click on First Manufacturer checkbox to apply the filters "Filters.firstManuf_checkbox"
    Then I verify element "Filters.filtersSelected_text" is present on page and display '1 Filter(s) Selected' in report
    And I click on Apply Filters button to see the resultant products count "Filters.applyFilters_button"
    And I verify the Products found count after applying filters
    And I verify element "Filters.filtersApplied_text" is present on page and display 'Refine Results (1) Filter Applied' in report
    And I click on Refine results again to clear the last Instock selected filter "Filters.refineResults_button"
    And I wait for "5" seconds
    And I scroll till "Filters.plusSignOfManufacturer_image"
    And I click on First Manufacturer checkbox to Clear(uncheck) the filters "Filters.firstManuf_checkbox"
    And I wait for "7" seconds
    And I verify element "Filters.filtersSelected_text" is present on page and display '0 Filter(s) Selected' in report
    And I click on Apply Filters button to see the resultant products count after reset "Filters.applyFilters_button"
    And I wait for "3" seconds
    #BELOW LINE TO BE UNCOMMENTED WHEN ISSUE OF CLEAR ALL FILTERS FOR EXCLUDE ORDERS IS RESOLVED FOR US FT & LIVE
    #Then I verify the Products found count after clearing all the filters

  @allfilter @guest @live @mobsmoketest  @cicd @eu @apac @nwk
  Scenario: Validate that all filter functionality is working fine
    Given web site is launched successfully and user "does" accept the cookies
    When I navigate to "Product-Lister-Leaf-L2" page using details from json "pageUrls.json"
    And I wait for "4" seconds
    And I verify element "Filters.searchWithinTermBox_textbox" is present on page
    And I get the Products found count before applying filters
    And I click on refine results button to view the filters options "Filters.refineResults_button"
    And I scroll down the page by pixels "250"
    And I click on the expand button of Static Filters Availability to see the options "Filters.plusSignOfAvailability_image"
    And I click on Instock checkbox to apply the filters "Filters.instock_checkbox"
    Then I verify element "Filters.filtersSelected_text" is present on page and display '1 Filter(s) Selected' in report
    And I click on Apply Filters button to see the resultant products count "Filters.applyFilters_button"
    And I wait for "5" seconds
    And I verify the Products found count after applying filters
    And I verify element "Filters.filtersApplied_text" is present on page and display 'Refine Results (1) Filter Applied' in report
    And I click on Refine results again to clear the last Instock selected filter "Filters.refineResults_button"
    And I click Clear All Filters button to reset the selection "Filters.clearAllFilters_button"
    And I wait for "5" seconds
    Then I verify the Products found count after clearing all the filters
    And I click on refine results button to view the filters options "Filters.refineResults_button"
    And I scroll till "Filters.plusSignOfManufacturer_image"
    And I click on the expand button of Static Filters Manufacturer to see the options "Filters.plusSignOfManufacturer_image"
    # And I click on First Manufacturer checkbox to apply the filters "Filters.firstManuf_checkbox"
    Then select any manufacturer from "Filters.mfrProductCount_text" which is having atleast "20" product
    Then I verify element "Filters.filtersSelected_text" is present on page and display '1 Filter(s) Selected' in report
    And I click on Apply Filters button to see the resultant products count "Filters.applyFilters_button"
    And I verify the Products found count after applying filters
    And I verify element "Filters.filtersApplied_text" is present on page and display 'Refine Results (1) Filter Applied' in report
    And I click on Refine results again to clear the last Instock selected filter "Filters.refineResults_button"
    And I wait for "5" seconds
    And I scroll till "Filters.plusSignOfManufacturer_image"
    # And I click on First Manufacturer checkbox to Clear(uncheck) the filters "Filters.firstManuf_checkbox"
    Then I unchecked the previosly selected filter as "Filters.checkedMfrFilter_checkbox"
    And I wait for "7" seconds
    And I verify element "Filters.filtersSelected_text" is present on page and display '0 Filter(s) Selected' in report
    And I click on Apply Filters button to see the resultant products count after reset "Filters.applyFilters_button"
    And I wait for "8" seconds
    Then I verify the Products found count after clearing all the filters

  @guestcheckoutUsingCC @mobsmoketest @eu @apac @nwk
  Scenario: A guest user adds products to cart directly by searching SKU and then places order successfully using creditcard
    Given web site is launched successfully and user "does not" accept the cookies
    And User save cookie preferences
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "3" seconds
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I wait for "5" seconds
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait for "5" seconds
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "4" seconds
    And User click on Checkout without registering button "ShoppingCart.checkoutWithoutRegistering_button"
    Then I wait for "4" seconds
    And User take screenshot of the page
    And I enter PO number value "GuestCheckout" in textbox "Checkout.poNumber_textbox"
    And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    Then User verify green tick mark element "Checkout.account_section" is present on page
    And I select by visible text in Payment Method type as "Credit / Debit Card" from dropdown "Checkout.paymentMethod_dropdown"
    #And User fill mobile checkout your details in address section using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User fill mobile checkout Invoice or billing address manually using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And I select by visible text in Card type as "VISA" from dropdown "Checkout.cardType_dropdown"
    And User fill Credit Card Details in mobile using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User click on Continue button on Payment Details Section "Checkout.paymentDetailsSectionContinue_button"
    Then User verify green tick mark element "Checkout.paymentInformation_section" is present on page
    And User click on Continue button on Delivery Address Section "Checkout.addressSectionContinue_button"
    Then User verify green tick mark for Delivery Address element "Checkout.shippingAddress_section" is present on page
    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And User selects special instructions "other" from dropdown and enter instructions if any
    And User take screenshot of the page
    And User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And User take screenshot of the page
    And I verify element "Checkout.reviewYourOrder_text" is present on page and display 'Review Your Order Before Submitting' in report
    And User checks terms and conditions checkbox and click on Submit Order button
    And I wait for "8" seconds
    And user take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you' in report
    And user take screenshot of the page

  @checkoutUsingExistingTradeAccount @live @mobsmoketest  @cicd @eu @apac @nwk
  Scenario: Checkout with existing trade account
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user
    And I wait for "3" seconds
    When I navigate to "Product-Lister-Leaf-L2" page using details from json "pageUrls.json"
    And I wait for "4" seconds
    And I click on first product on PLP to place an order "PLP.firstAdd_button"
    And I wait for "5" seconds
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait for "5" seconds
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "7" seconds
    Then I verify element "Checkout.account_section" is present on page and display 'Account' in report
    And I click on checkbox having existing Trade Account "Checkout.existingTradeAccount_checkbox"
    And I click on link use an existing Trade account "Checkout.existingTradeAccount_link"
    And I enter Trade account Account number and CID details using given file "OrderInformation.xlsx"
    And I enter PO number value "TradeTestorder" in textbox "Checkout.poNumber_textbox"
    And I click on Continue button on Account section "Checkout.continueAccountSection_button" using js
    Then I verify element "Checkout.paymentInformation_section" is present on page and display 'Payment Details' in report
    And I select by visible text in Payment Method type as "Trade Account" from dropdown "Checkout.paymentMethod_dropdown"
    And I wait for "3" seconds
    And User fill mobile checkout Invoice or billing address manually using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And User click on Continue button on Payment Details Section "Checkout.paymentDetailsSectionContinue_button"
    Then I verify element "Checkout.shippingAddress_section" is present on page and display 'Delivery Address' in report
    And User click on Continue button on Delivery Address Section "Checkout.addressSectionContinue_button"
    Then I verify element "Checkout.shippingMethod_section" is present on page and display 'Delivery Method' in report
    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And User take screenshot of the page
    And User click on button on Delivery Method Section "Checkout.proceedToOrderReview_button"
    And User take screenshot of the page
    And I wait for "7" seconds
    And User checks terms and conditions checkbox and click on Submit Order button
    And I wait for "8" seconds
    And user take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you' in report

  @orderHistory @checkoutNewTradeAccount @mobsmoketest @eu @apac @nwk
  Scenario: Verify the order history for recent orders
    Given web site is launched successfully and user "does" accept the cookies
    When last registered "regular" user login to website successfully
    And I wait for "3" seconds
    And I click on Navigation Toggle Bar on Home page "Home.navigationToggleBar_button"
    And I wait for "4" seconds
    And I click My Account link "Home.myAccount_link"
    And I wait for "7" seconds
    And I verify element "OrderHistory.recentOrderHistoryTable_element" is present on page and display 'Recent Order details' in report
    And I verify recent order history table in mobile app is displayed
    And I wait for "5" seconds
    And I scroll till "OrderHistory.recentOrders_text"
    And I click on View all Orders button "OrderHistory.viewAllOrders_button"
    And I wait for "4" seconds
    And I verify element "OrderHistory.orderHistoryTracking_text" is present on page and display 'Order History & Tracking' in report
    And I take screenshot of the page to see the recent order table displayed on page
    And I verify element "OrderHistory.orderDate_text" is present on page and display 'Date of Purchase' in report

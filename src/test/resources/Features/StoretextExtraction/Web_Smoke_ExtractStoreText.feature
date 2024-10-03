@WebSmokeExtractStoreText
Feature: Basic navigation to fetch storetext from the website

  @storetext
  Scenario: Register a user with known details for newark
    Given web site is launched successfully and user "does" accept the cookies
    And user get all the store text keys of "HomePage" page
    And user get the store text keys of "HeaderPart" page for element "StoreTextKeys.header_element"

  @storetext
  Scenario: Guest user Checkout with CC to get storetext keys
    Given web site is launched successfully and user "does" accept the cookies
    And user get all the store text keys of "HomePage" page
    And user get the store text keys of "HeaderPart" page for element "StoreTextKeys.header_element"
    Then customer accesses the website as "guest" user
    When I enter ordercode in Searchbox to navigate to PDP page
    And I wait for "3" seconds
    And user get all the store text keys of "PDPSearchPage" page
    And I click on order code link "Search.lookAheadSKU_link"
    And I wait for "3" seconds
    And I scroll till "PDPBuyBox.addToCart_button"
    And I wait for "2" seconds
    And I click Add to cart button "PDPBuyBox.addToCart_button"
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And user get all the store text keys of "CartPage" page
    And User create a URL and navigate to checkout page
    Then user get all the store text keys of "CheckoutPage" page
    And I wait for "4" seconds
    #Section 1 - Your details
    And User fill Checkout Your details section form using given file "OrderInformation.xlsx"
    And User take screenshot of the page
    And user get all the store text keys of "CheckoutPage" page
    And User click on Continue button on Your Details Section "Checkout.yourDetailsSectionContinue_button"
    And I wait for "8" seconds
    #Section 2 - Invoice and Delivery Address
    And clicks on "Checkout.addAddressManually_link"
    And fill Checkout Invoice address manually using given file "Address.xlsx"
    And user get all the store text keys of "CheckoutPage" page
    And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
    And User take screenshot of the page
    And I wait for "4" seconds
    #Section 3 - Delivery Options
    And User take screenshot of the page
    And user get all the store text keys of "CheckoutPage" page
    And I click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
    Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
    And User take screenshot of the page
    And I wait for "4" seconds
    #Section 4 - Payment Details
    And User fill Credit Card Details using given file "OrderInformation.xlsx"
    And I wait for "4" seconds
    And I scroll till "Checkout.paymentDetailsSectionContinue_button"
    And user get all the store text keys of "CheckoutPage" page
    And User take screenshot of the page
    Then I verify Payment Details section edit button element "Checkout.paymentDetailsSectionContinue_button" is present on page
    And I click on Continue button on Delivery Section "Checkout.paymentDetailsSectionContinue_button"
    #Section 6 - Order Review
    When User enter random PO Number on Order Review section
    And I scroll till "Checkout.poNumber_textbox"
    And User take screenshot of the page
    And user get all the store text keys of "CheckoutPage" page
    And I wait for "5" seconds
    And User checks terms and conditions checkbox and click on Submit Order button
    And user take screenshot of the page
    #Order Confirmation
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    And user get all the store text keys of "CheckoutPage" page
    And user take screenshot of the page

  @storetext
  Scenario Outline: navigate to PDP only and get all storetext
    Given web site is launched successfully and user "does" accept the cookies
    And I wait for "10" seconds
    When I navigate to "Product-Details-Page" page using details from json "pageUrls.json"
    And I wait for "10" seconds
    And I take screenshot of the page
    And user get all the store text keys of "Product-Details-Page" page

  @storetext
  Scenario Outline: navigate to various pages and get all storetext
    Given web site is launched successfully and user "does" accept the cookies
    And I wait for "10" seconds
    When I navigate to "<navigate>" page using details from json "pageUrls.json"
    And I wait for "10" seconds
    And I take screenshot of the page
    And user get all the store text keys of "<pagename>" page

    Examples:
      | navigate               | pagename               |
      | browse-for-products    | browse-for-products    |
      | Product-Lister-Node    | Product-Lister-Node    |
      | Category-Node-L1-1     | Category-Node-L1       |
      | Product-Details-Page   | Product-Details-Page   |
      | Product-Lister-Leaf-L1 | Product-Lister-Leaf-L1 |
      | Product-Lister-Leaf-L2 | Product-Lister-Leaf-L2 |
      | Category-Node-L1       | Category-Node-L1       |

  @storetext
  Scenario: Synch user Checkout with existing trade account
    Given web site is launched successfully and user "does" accept the cookies
    And I wait for "3" seconds
    And customer accesses the website as "register" user storetext
    And I wait for "10" seconds
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
    And clicks on "Checkout.addAddressManually_link"
    And fill Checkout Invoice address manually using given file "Address.xlsx"
    And I click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button"
    And I wait for "8" seconds
    And I verify element "Checkout.deliveryOptions_text" is present on page and display its value in report
    And I enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And I wait for "3" seconds
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

  @storetext
  Scenario: Blank search & Checkout requesting new Trade Account
    Given web site is launched successfully and user "does" accept the cookies
    And customer accesses the website as "register" user storetext
    And I save the newly registered "regular" user details
    When I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And user get all the store text keys of "CategoryL1Page" page
    And I click "BrowseForProducts.firstCategory_link"
    And I scroll till "CategoryPage.showAllProducts_button"
    And user get all the store text keys of "CategoryL2Page" page
    And I click Show all Products button on L0 category page "CategoryPage.showAllProducts_button"
    And user get all the store text keys of "CategoryL3Page" page
    And I save the value of First Order code from PLP table
    And user get all the store text keys of "PLPPage" page
    And I click on shopping basket icon on header bar "Header.miniBasket_link"
    And I wait "long" duration for "ShoppingCart.shoppingBasket_text" element to "appear"
    And I wait for "3" seconds
    When I enter the ordercode saved from PLP to update the basket to place order
    And user get all the store text keys of "BasketPage" page
    And I scroll till "ShoppingCart.updateBasket_button"
    And I click "ShoppingCart.updateBasket_button"
    And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
    And I wait for "3" seconds
    And I scroll till "Header.itemsInMiniBasket_text"
    And user get all the store text keys of "MiniBasketPage" page
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And User create a URL and navigate to checkout page
    And I wait for "5" seconds
    Then user get all the store text keys of "CheckoutPage" page
    And I wait "medium" duration for "Checkout.paymentMethod_text" element to "appear"
    And I click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
    And I would like to open a new Trade Account
    And I click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
    Then I verify Payment Method section edit button element "Checkout.editPaymentMethod_button" is present on page
    And clicks on "Checkout.addAddressManually_link"
    And fill Checkout Invoice address manually using given file "Address.xlsx"
    Then user get all the store text keys of "CheckoutPage" page
    And User click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
    And I wait for "8" seconds
    Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
    And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
    And I wait for "3" seconds
    Then user get all the store text keys of "CheckoutPage" page
    And I scroll till "Checkout.deliverySectionContinue_button"
    And User click on Continue button on Delivery Section "Checkout.deliverySectionContinue_button"
    And I wait for "8" seconds
    And I wait "long" duration for "Checkout.editDeliveryOptions_button" element to "appear"
    Then I verify Delivery options section edit button element "Checkout.editDeliveryOptions_button" is present on page
    And I select trade account radio button and click continue button in section 4 payment method
    Then I verify element "Checkout.editPaymentDetails_button" is present except in "ph" region/store
    Then user get all the store text keys of "CheckoutPage" page
    And I fill Additional Information Details for New Trade Account using given file "OrderInformation.xlsx"
    And I wait for "3" seconds
    And I enter PO number value "NewTradeAcc" in textbox "Checkout.poNumber_textbox"
    Then user get all the store text keys of "CheckoutPage" page
    And I wait for "10" seconds
    And User checks terms and conditions checkbox and click on Submit Order button
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    Then user get all the store text keys of "CheckoutPage" page

  @storetext
  Scenario: A guest user adds products to cart directly using a community url then places order successfully using creditcard
    Given web site is launched successfully and user "does not" accept the cookies
    And User save cookie preferences
    When User navigate to community URL using file "CommunityURL.xlsx"
    And user get all the store text keys of "CartPage" page
    And User scroll till "ShoppingCart.firstProductOnCart_text"

  @storetext
  Scenario: Search Lookahead and Keyword search
    Given web site is launched successfully and user "does" accept the cookies
    And user enter the value "res" in textbox "Header.searchBox_textbox"
    And I wait for "3" seconds
    And user get all the store text keys of "SearchLookaheadValuesSeaction" page
    And I clears text from textbox "Header.searchBox_textbox"
    When user enter the value "capacitor" in textbox "Header.searchBox_textbox"
    And I click the "Header.searchIcon_button"
    And I wait for "3" seconds
    And user get all the store text keys of "SearchResultsPage" page

  @storetext
  Scenario: I want to verify the SEO title for PDP page
    Given web site is launched successfully and user "does" accept the cookies
    And user get all the store text keys of "HomePageWithoutCookiesAccepted" page
    When I enter ordercode in Searchbox to navigate to PDP page
    And user get all the store text keys of "PDPPage" page
    And I click on the first order result "Search.searchFirst_text"
    And I wait for "3" seconds
    And user get all the store text keys of "PDPPage" page

  @storetext
  Scenario: Validate the Left and Top filters functionality
    Given web site is launched successfully and user "does" accept the cookies
    When I navigate to "Product-Lister-Leaf-L1" page using details from json "pageUrls.json"
    And I wait for "4" seconds
    And user get all the store text keys of "PLPPageBeforeLeftViewFilter" page
    And I get the Products found count before applying filters
    When I click on Instock checkbox "Filters.instock_checkbox"
    And I click on Show Result Button "Filters.showResult_button" refreshed element
    And user get all the store text keys of "PLPPageAfterLeftViewFilter" page
    And I click "Filters.clearAllFilters_link"
    And I wait for "8" seconds
    And I click the toggle view from LEFT to TOP view "Filters.filterView_toggle"
    And user get all the store text keys of "PLPPageBeforeTopViewFilter" page
    When I select by index "1" from dropdown "Filters.filterManufacturer_section"
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And user get all the store text keys of "PLPPageAfterTopViewFilter" page
    And I click on "Filters.reset_link"
    And I click on Show Result button "Filters.showResult_button" refreshed element
    And user get all the store text keys of "PLPPageAfterTopViewFilterReset" page
    And I click on Add button on PLP "PLP.firstAdd_button" using js

  @storetext
  Scenario: Guest user track order by entering order confirmation number, email and zip code
    Given web site is launched successfully and user "does" accept the cookies
    When user click on Track Orders link On home page from the header "Header.trackOrders_link"
    Then user verifies Order Details element "OrderTracking.orderDetails_text" is present on page
    And user get all the store text keys of "TrackOrderPage" page
    And Guest user submits the Order tracking details
    And I wait for "3" seconds
    And user click on findorder button "OrderTracking.findorder_button"
    And user get all the store text keys of "FindOrderSectionPage" page

  @storetext
  Scenario: Verify the order history for recent orders
    Given web site is launched successfully and user "does" accept the cookies
    And user get all the store text keys of "HomePageWithCookiesAccepted" page
    When customer accesses the website as "contract" user storetext
    And I assume environment stub is disabled in PP environment
    And I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And user get all the store text keys of "MyAccountDropdownSection" page
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I wait for "5" seconds
    And user get all the store text keys of "MyAccountSummaryPage" page
    And I scroll till "OrderHistory.viewAllOrders_button"
    When I click on View All Orders button "OrderHistory.viewAllOrders_button"
    And user get all the store text keys of "ViewAllOrdersPage" page
    And I click on link of recent order placed PO Number "OrderHistory.firstPONumber_element" using js
    And I wait for "8" seconds
    And I wait "medium" duration for "OrderHistory.txt_OrderHistory&Tracking" element to "appear"
    And user get all the store text keys of "OrderHistoryWithPOSearchResultsSection" page

  @storetext
  Scenario: Verify Back office Account number is synched in Account Summary
    Given I assume environment stub is disabled in PP environment
    Given web site is launched successfully and user "does" accept the cookies
    And user get all the store text keys of "HomePageWithCookiesAccepted" page
    When customer accesses the website as "contract" user storetext
    When I hover on element My Account dropdown "Header.myAccount_dropdown"
    And I wait for "2" seconds
    And I click Account Summary from the dropdown "Header.accountSummary_link"
    And I wait for "5" seconds
    And user get all the store text keys of "MyAccountSummaryPage" page

  @storetext
  Scenario: Extract store text from incorrect user credentials page and forgot username and password page
    Given web site is launched successfully and user "does" accept the cookies
    When user navigate to "login" page
    Then user get all the store text keys of "LoginPage" page
    When User enters incorrect username "incorrect" and password "incorrect" to login to the application
    Then user get all the store text keys of "LoginPage" page
    When user click on "Login.forgotUsername_link"
    Then user get all the store text keys of "LoginPage" page
    When user navigate to "login" page
    Then user click on "Login.forgotPassword_link"
    And user get all the store text keys of "LoginPage" page

  @storetext
  Scenario: Extract store text from registration page
    Given web site is launched successfully and user "does" accept the cookies
    When user navigate to "registration" page
    Then user get all the store text keys of "Registration" page
    When user click on "Register.register_button"
    Then user get all the store text keys of "Registration" page
    When user enters value "testemail" in textbox "Register.emailAddress_textbox"
    Then user get all the store text keys of "Registration" page

  @storetext
  Scenario: Extract store text from compare products page
    Given web site is launched successfully and user "does" accept the cookies
    When I navigate to "c/crystals-oscillators/crystals" page
    And I wait for "2" seconds
    And user click on "PLP.rohsCertificateOfCompliance_link"
    And I wait for "2" seconds
    Then user get all the store text keys of "PLPPage" page
    When user click on "PLP.rohsContinueShopping_button"
    And User select first "2" checkbox from PLP table
    And user click on "PLP.compareSlected_button"
    And I wait for "5" seconds
    Then user get all the store text keys of "CompareProducts" page

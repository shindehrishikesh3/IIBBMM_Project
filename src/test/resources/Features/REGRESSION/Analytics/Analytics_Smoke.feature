@analyticstests @analyticssmoke
Feature: Analytics /ss Smoke Tests

  @eu @apac @nwk @enablePerfLogs @pages @live @eachpage
  Scenario Outline: Verify Analytics calls <pageName>
    Given "<pageName>" page is launched and user "does not" accept the cookies
    And verify _satellite object is defined
    When I accept all cookies if asked
    And I wait for "10" seconds
    And get performance logs
    Then verify visitorAPI call based on ADOBE_VISITORAPI_IN_LAUNCH xcomreg
    Then verify "AppMeasurement" call exists
    Then verify "/ss" call exists
    Then verify "decibel" call exists
    And verify _satellite object is defined

    Examples: 
      | pageName             |
      | homepage             |
      | browse-for-products  |
      | Product-Lister-Node  |
      | Product-Details-Page |
      | Category-Node-L1-1   |

  @eu @apac @nwk @shoppingbasket @enablePerfLogs @live
  Scenario: Verify Analytics calls - Shopping basket page
    Given "Product-Lister-Node" page is launched and user "does" accept the cookies
    When click on "PLP.firstAdd_button" using js
    And I wait "short" duration for "Header.itemAddedPopUp_element" element to "disappear"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And verify _satellite object is defined
    And get performance logs
    Then verify visitorAPI call based on ADOBE_VISITORAPI_IN_LAUNCH xcomreg
    Then verify "AppMeasurement" call exists
    Then verify "/ss" call exists
    Then verify "decibel" call exists

  @enablePerfLogs @eu @apac @nwk @checkoutanalyticssmoke @live
  Scenario Outline: Verify query parameters checkout pages
    Given web site is launched successfully and user "does" accept the cookies
    And I click on shopping basket icon on header bar "Header.miniBasket_link" using js
    And I wait for "3" seconds
    And I verify element "ShoppingCart.shoppingBasket_text" is present on page and display its value in report
    And I enter "instock" ordercode in quick add part number textbox
    And I scroll till "ShoppingCart.updateBasket_button"
    And I click "ShoppingCart.updateBasket_button"
    And I wait "short" duration for "ShoppingCart.loader_element" element to "disappear"
    And I wait for "3" seconds
    And I scroll till "Header.itemsInMiniBasket_text"
    And I verify mini shopping cart contains "1" items in "Header.itemsInMiniBasket_text"
    When I click on CheckoutNowButton on Shopping cart Page "ShoppingCart.checkoutNow_button" using js
    And I wait for "4" seconds
    And login as "regular" user
    And I wait "medium" duration for "Checkout.paymentMethod_text" element to "appear"
    And I wait for "10" seconds
    And verify _satellite object is defined
    And get performance logs
    Then verify visitorAPI call based on ADOBE_VISITORAPI_IN_LAUNCH xcomreg
    Then verify "AppMeasurement" call exists
    Then verify "decibel" call exists
    Then verify "/ss" call exists
    Then get all query string parameters for "order-info-page-load"
    And skip rest of the script in live environment
    And click on "Checkout.tradeAccountOption_radio" option in section 1 payment method if presented
    And would like to open a new Trade Account
    And click on Continue button on Payment Details section "Checkout.paymentDetailsSectionContinue_button" using js
    And I wait for "5" seconds
    #And refresh browser
    And click on Continue button on Invoice addressSection "Checkout.addressSectionContinue_button" using js
    And I wait for "8" seconds
    Then I verify Invoice and Delivery Address Method section edit button element "Checkout.editInvoiceAndDeliveryAddress_button" is present on page
    #And User enter value "This is Test Placed Order" in textbox "Checkout.deliveryInstructions_textbox"
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
    And I enter PO number value "NewTradeOrd" in textbox "Checkout.poNumber_textbox"
    And User take screenshot of the page
    And I wait for "10" seconds
    And User checks terms and conditions checkbox and click on Submit Order button
    And user take screenshot of the page
    And I verify order confirmation message is present on page and display 'Thank you for your order' in report
    And take screenshot of the page
    And verify _satellite object is defined
    And get performance logs
    Then verify "/ss" call exists
    Then get all query string parameters for "order-confirmation-page-load"
    
